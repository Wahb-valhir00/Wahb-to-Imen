package com.mootez.resvervation.model;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import com.mongodb.lang.NonNull;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Document(collection = "Repas")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Repas {
    @Id
    private String id;
    
    @Field(name = "Name")
    private String name;
    
    @Field(name = "Description")
    private String description;
    @NonNull
    @Field(name = "Prix")
    private Long prix;
    
    @Field(name = "Ingredients")
    private List<Ingredient> ingredients;
    
    

}
