package com.example.hotels.models;

import com.example.hotels.enums.PurchaseStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;
import java.util.List;

@Entity
@Data
@Table(name = "Purchases")
@AllArgsConstructor
@NoArgsConstructor
public class Purchase {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "purchase_id")
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "hotel_id")
    private Hotel hotel;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    private User user;

    @Column(name = "purchase_status")
    private PurchaseStatus purchaseStatus;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "director_id")
    private User director;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "room_id")
    private Room room;

    @Column(name = "start_date")
    private Date startDate;

    @Column(name = "end_date")
    private Date endDate;

    @ManyToMany(fetch = FetchType.EAGER, cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinTable(
            name = "purchase_service",
            joinColumns = { @JoinColumn(name = "purchase_id") },
            inverseJoinColumns = { @JoinColumn(name = "service_id")}
    )
    private List<Service> services;

    @Column(name = "cost")
    private int cost;

    public boolean isExcepted() {
        return purchaseStatus.equals(PurchaseStatus.EXCEPT);
    }

    public boolean isRejected() {
        return purchaseStatus.equals(PurchaseStatus.REJECT);
    }

    public boolean isWait() {
        return purchaseStatus.equals(PurchaseStatus.WAIT);
    }

    public boolean isInhabited() {
        return purchaseStatus.equals(PurchaseStatus.INHABITED);
    }
}
