package com.example.hotels.models;

import com.example.hotels.enums.RoomStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@Table(name = "Rooms")
@AllArgsConstructor
@NoArgsConstructor
public class Room {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "room_id")
    private Long id;

    @Column(name = "room_numb")
    private int roomNumb;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "hotel_id")
    private Hotel hotel;

    @Column(name = "room_status")
    private RoomStatus roomStatus;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "room",  cascade = CascadeType.REMOVE)
    private List<Purchase> purchases;

}