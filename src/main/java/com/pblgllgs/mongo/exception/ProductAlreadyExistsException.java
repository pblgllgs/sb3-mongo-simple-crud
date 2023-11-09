package com.pblgllgs.mongo.exception;

/**
 * @author pblgl
 * Created on 08-11-2023
 */

public class ProductAlreadyExistsException extends RuntimeException{
    public ProductAlreadyExistsException(String message) {
        super(message);
    }
}
