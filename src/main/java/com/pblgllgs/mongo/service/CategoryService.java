package com.pblgllgs.mongo.service;

import com.pblgllgs.mongo.documents.Category;
import com.pblgllgs.mongo.exception.CategoryAlreadyExistsException;
import com.pblgllgs.mongo.exception.CategoryNotFoundException;
import com.pblgllgs.mongo.repositories.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * @author pblgl
 * Created on 08-11-2023
 */

@Service
@RequiredArgsConstructor
public class CategoryService {
    private static final String CATEGORY_NOT_FOUND = "CATEGORY_NOT_FOUND";
    private static final String CATEGORY_ALREADY_EXISTS = "CATEGORY_ALREADY_EXISTS";
    private final CategoryRepository categoryRepository;

    public Category save(Category category) {
        Optional<Category> optional = categoryRepository.findById(category.getId());
        if (optional.isPresent()) {
            throw new CategoryAlreadyExistsException(CATEGORY_ALREADY_EXISTS);
        }
        return categoryRepository.save(category);
    }

    public Category findById(String id) {
        return categoryRepository.findById(id).orElseThrow(() -> new CategoryNotFoundException(CATEGORY_NOT_FOUND));
    }

    public List<Category> findAll() {
        return categoryRepository.findAll();
    }

    public void deleteById(String id) {
        Optional<Category> optional = categoryRepository.findById(id);
        if (optional.isEmpty()) {
            throw new CategoryNotFoundException(CATEGORY_NOT_FOUND);
        }
        categoryRepository.deleteById(id);
    }
}
