package com.Exam.ExamServer.model.exam;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "CATEGORY")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long cId;
    private String title;
    private String description;

    @OneToMany(mappedBy = "category", fetch = FetchType.LAZY, cascade =CascadeType.ALL)
    @JsonIgnore //while fetching category avoid fetching quizzes
    private Set<Quiz> quizzes=new LinkedHashSet<>();

    public Category(Long cId, String title, String description) {
        this.cId = cId;
        this.title = title;
        this.description = description;
    }
    public Category() {
    }

    public Long getcId() {
        return cId;
    }

    public void setcId(Long cId) {
        this.cId = cId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Category{" +
                "cId=" + cId +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
