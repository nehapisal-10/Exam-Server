package com.Exam.ExamServer.service;

import com.Exam.ExamServer.model.exam.Category;

import java.util.Set;

public interface CategoryService {
    public Category addCategory(Category category);
    public Category updateCategory(Category category);
    public Category getCategory(Long categoryId);
    public Set<Category> getCategories();
    public void deleteCategory(Long CategoryId);

}
