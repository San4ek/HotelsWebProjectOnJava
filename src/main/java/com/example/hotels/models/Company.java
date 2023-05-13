package com.example.hotels.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@Table(name = "Companies")
@AllArgsConstructor
@NoArgsConstructor
public class Company {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "company_id")
    private Long id;

    @Column(name = "name")
    private String name;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "country_id")
    private Country country;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "company", cascade = CascadeType.REMOVE)
    private List<Hotel> hotels;
}
