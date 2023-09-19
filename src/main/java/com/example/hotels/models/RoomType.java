package com.example.hotels.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@Table(name = "room_type")
@AllArgsConstructor
@NoArgsConstructor
public class RoomType {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "room_type_id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "capacity")
    private int capacity;

    @Column(name = "cost")
    private int cost;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "roomType", cascade = CascadeType.REMOVE)
    private List<Room> rooms;

}
