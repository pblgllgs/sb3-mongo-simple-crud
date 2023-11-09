package com.pblgllgs.mongo.repositories;

import com.pblgllgs.mongo.documents.Product;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * @author pblgl
 * Created on 08-11-2023
 */

public interface ProductRepository extends MongoRepository<Product,String> {
}
