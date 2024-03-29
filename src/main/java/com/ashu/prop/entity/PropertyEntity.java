package com.ashu.prop.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "PROPERTY_TABLE")
@Getter
@Setter
public class PropertyEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "PROPERTY_NAME", nullable = false)
    private String title;
    private String description;
    private String ownerName;
    @Column(name = "EMAIL", nullable = false)
    private String ownerEmail;
    private Double price;
    private String address;
}
