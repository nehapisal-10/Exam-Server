package com.Exam.ExamServer.controller;

import com.Exam.ExamServer.config.JwtUtil;
import com.Exam.ExamServer.model.JwtRequest;
import com.Exam.ExamServer.model.JwtResponse;
import com.Exam.ExamServer.model.User;
import com.Exam.ExamServer.service.impl.UserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@RestController
@CrossOrigin("*")
public class AuthenticateController {

    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private UserDetailsServiceImpl userDetailsService;

    @Autowired
    private JwtUtil jwtUtil;

    //generate token
    @PostMapping("/generate-token")
    public ResponseEntity<?> generateToken(@RequestBody JwtRequest jwtRequest) throws Exception {
            try{
                authenticate(jwtRequest.getUsername(), jwtRequest.getPassword());
            }catch(UsernameNotFoundException e){
                e.printStackTrace();
                throw new Exception("user not found");
            }

        UserDetails userDetails = this.userDetailsService.loadUserByUsername(jwtRequest.getUsername());
            String token = this.jwtUtil.generateToken(userDetails);
            return ResponseEntity.ok(new JwtResponse(token));
    }

    private void authenticate(String username,String password) throws Exception {
        try{
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username,password));
        }catch(DisabledException e){
            throw new Exception("user is disabled" + e.getMessage());
        }catch (BadCredentialsException e){
            throw new Exception("Invalid Credential" + e.getMessage());
        }
    }

    //returns the details of current user
    @GetMapping("/current-user")
    public User getCurrentUser(Principal principal){
        return ((User)userDetailsService.loadUserByUsername(principal.getName()));
    }
}
