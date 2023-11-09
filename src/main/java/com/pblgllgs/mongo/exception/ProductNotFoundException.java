package com.pblgllgs.mongo.exception;

/**
 * @author pblgl
 * Created on 08-11-2023
 */

public class ProductNotFoundException extends RuntimeException{
    public ProductNotFoundException(String message) {
        super(message);
    }
}
