package com.example.hotels.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "hotels")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Hotel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "hotel_id")
    private Long id;

    @Column(name = "name")
    private String name;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "country_id")
    private Country country;

    @Column(name = "number_of_stars")
    private int numberOfStars;

    @ManyToOne
    @JoinColumn(name = "director_id")
    private User director;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "hotel", cascade = CascadeType.REMOVE)
    private List<Employee> employees;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "company_id")
    private Company company;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "hotel", cascade = CascadeType.REMOVE)
    private List<Purchase> purchases;

    @Column(name = "numb_of_rooms")
    private int numbOfRooms;
}
