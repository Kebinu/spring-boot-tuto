package com.ecommerce.microcommerce.model;

import com.fasterxml.jackson.annotation.JsonFilter;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
@Entity
//@JsonFilter("myDynamicFilter")
public class Product {

    @Id
    @GeneratedValue
    private int id;
    private String nom;
    private int prix;

    private int prixAchat;
}
