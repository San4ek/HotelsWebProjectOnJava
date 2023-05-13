package com.example.hotels.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "Directors")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Director {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "director_id")
    private Long id;

    @Column(name = "name")
    private String name;

    @OneToOne(mappedBy = "director", cascade = CascadeType.REMOVE)
    private Hotel hotel;

}

