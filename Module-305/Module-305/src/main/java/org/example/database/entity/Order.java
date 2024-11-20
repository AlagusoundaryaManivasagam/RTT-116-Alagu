package org.example.database.entity;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "orders")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Order implements Serializable {
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "customer_id", nullable = false)
    @ToString.Exclude
    private Customer customer;

    @OneToMany(mappedBy = "order", fetch = FetchType.LAZY,
            cascade = CascadeType.ALL)
    @ToString.Exclude
    private Set<OrderDetail> orderDetails;


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "customer_id", insertable=false, updatable=false)
    private int customerId;

    @Column(name = "order_date", columnDefinition = "Date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date orderDate;

    @Column(name = "required_date", columnDefinition = "Date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date requiredDate;

    @Column(name = "shipped_date", columnDefinition = "Date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date shippedDate;

    @Column(name = "status")
    private String status;

    @Column(name = "comments", columnDefinition = "text")
    private String comments;

    //We can use @Data instead of writing getter, setter, toString



}
