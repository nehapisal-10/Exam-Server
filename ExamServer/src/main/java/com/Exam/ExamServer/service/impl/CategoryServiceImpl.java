package com.Exam.ExamServer.service.impl;

import com.Exam.ExamServer.model.exam.Category;
import com.Exam.ExamServer.repository.CategoryRepository;
import com.Exam.ExamServer.service.CategoryService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedHashSet;
import java.util.Set;
@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;
    @Override
    public Category addCategory(Category category) {
        return this.categoryRepository.save(category);
    }

    @Override
    public Category updateCategory(Category category) {
        return this.categoryRepository.save(category);
    }

    @Override
    public Category getCategory(Long categoryId) {
        return this.categoryRepository.findById(categoryId).get();
    }

    @Override
    public Set<Category> getCategories() {
        return new LinkedHashSet<>(this.categoryRepository.findAll());
    }

    @Override
    @Transactional
    public void deleteCategory(Long categoryId) {
        Category category= new Category();
        category.setcId(categoryId);
       // this.categoryRepository.delete(category);
        this.categoryRepository.deleteById(categoryId);
    }
}
