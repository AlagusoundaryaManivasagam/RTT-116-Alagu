package com.example.module309.database.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "productlines")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString


public class Productline {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "product_line")
    private String productLine;

    @Column(name = "description")
    private String description;


}
