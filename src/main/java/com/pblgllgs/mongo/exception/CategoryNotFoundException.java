package com.pblgllgs.mongo.exception;

/**
 * @author pblgl
 * Created on 08-11-2023
 */

public class CategoryNotFoundException extends RuntimeException{
    public CategoryNotFoundException(String message) {
        super(message);
    }
}
