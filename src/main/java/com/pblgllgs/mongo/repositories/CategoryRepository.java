package com.pblgllgs.mongo.repositories;

import com.pblgllgs.mongo.documents.Category;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * @author pblgl
 * Created on 08-11-2023
 */

public interface CategoryRepository extends MongoRepository<Category, String> {
}
