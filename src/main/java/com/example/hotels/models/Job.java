package com.example.hotels.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@Table(name = "Jobs")
@AllArgsConstructor
@NoArgsConstructor
public class Job {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "job_id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "salary")
    private int salary;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "job", cascade = CascadeType.REMOVE)
    private List<Employee> purchases;
}
