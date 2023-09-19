package com.example.hotels.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@Table(name = "Service")
@AllArgsConstructor
@NoArgsConstructor
public class Service {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "service_id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "cost")
    private int cost;

    @ManyToMany(mappedBy = "services", fetch = FetchType.EAGER)
    private List<Hotel> hotels;

    @ManyToMany(mappedBy = "services", fetch = FetchType.EAGER)
    private List<Purchase> purchases;
}
