package com.example.hotels.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@Table(name = "Countries")
@AllArgsConstructor
@NoArgsConstructor
public class Country {

    @Id
    @Column(name = "country_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "name")
    private String Name;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "country", cascade = CascadeType.REMOVE)
    private List<Hotel> hotels;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "country", cascade = CascadeType.REMOVE)
    private List<Company> companies;
}
