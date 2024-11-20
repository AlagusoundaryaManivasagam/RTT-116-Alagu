package org.example.database.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Entity
@Table(name = "payments")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "customer_id")
    private int customerId;

    @Column(name = "check_number")
    private String checkNumber;

    @Column(name = "payment_date", columnDefinition = "date")
    @Temporal(TemporalType.DATE)
    private Date paymentDate;

    @Column(name = "amount", columnDefinition = "decimal")
    private int amount;




}
