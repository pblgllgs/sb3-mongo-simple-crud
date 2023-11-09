package com.pblgllgs.mongo.exception;

/**
 * @author pblgl
 * Created on 08-11-2023
 */

public class CategoryAlreadyExistsException extends RuntimeException{
    public CategoryAlreadyExistsException(String message) {
        super(message);
    }
}
