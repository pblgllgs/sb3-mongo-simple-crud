package com.pblgllgs.mongo.documents;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * @author pblgl
 * Created on 08-11-2023
 */

@Data
@AllArgsConstructor
@Builder
@Document(value = "categories", collection = "categories")
public class Category {

    @Id
    private String id;
    private String name;
    private String description;
}
