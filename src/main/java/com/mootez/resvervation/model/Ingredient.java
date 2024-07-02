package com.mootez.resvervation.model;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@Document(collection = "Ingredient")
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Ingredient {

    @Id
    private String id;

    private String name;

  
}