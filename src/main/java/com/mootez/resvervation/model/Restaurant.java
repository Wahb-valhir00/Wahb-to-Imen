package com.mootez.resvervation.model;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Document(collection = "Restaurant")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Restaurant {
    @Id
    private String id;
    
    @Field(name = "Name")
    private String name;
    
    @Field(name = "Address")
    private String address;
    
    @Field(name = "Phone")
    private String phone;
    
    @Field(name = "Description")
    private String description;
    
    @Field(name = "Menu")
    private Menu menu; 
}
