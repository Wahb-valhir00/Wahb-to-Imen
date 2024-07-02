package com.mootez.resvervation.model;

import java.util.Date;
import java.util.List;

import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collation = "Reservation")
public class Reservation {
    private String id;
    private User user;
    private Restaurant restaurant;
    private Integer nbPerso;
    private Date date;
    private List<Repas> repas;
    

    public void setDate(Date date) {
        if (date.before(new Date())) {
            throw new IllegalArgumentException("The date cannot be in the past.");
        }
        this.date = date;
    }
}
