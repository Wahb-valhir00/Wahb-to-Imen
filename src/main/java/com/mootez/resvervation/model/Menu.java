package com.mootez.resvervation.model;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Document(collection = "Menu")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Menu {
    @Id
    private String id;
    
    @Field(name = "Repas")
    private List<Repas> repas;
}
