package org.example.database.entity;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "customers")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Customer implements Serializable {
    // to add one to many
    // 1) gto to the example website and create the one to many and many to one anotation
    // 2) in the entity with the foreign key mark that column as insertable = false and updatable = false
    // 3) add @toString.exclude  annotation to both side
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "sales_rep_employee_id")
    @ToString.Exclude
    private Employee employee;

    @OneToMany(mappedBy = "customer", fetch = FetchType.LAZY,
            cascade = CascadeType.ALL)
    @ToString.Exclude
    private Set<Order> orders;


    @Column(name = "customer_name")
    private String customerName;

    @Column(name = "contact_lastname")
    private String contactLastname;

    @Column(name = "contact_firstname")
    private String contactFirstname;

    @Column(name = "phone")
    private String phone;

    @Column(name = "address_line1")
    private String addressLine1;

    @Column(name = "address_line2")
    private String addressLine2;

    @Column(name = "city")
    private String city;

    @Column(name = "state")
    private String state;

    @Column(name = "postal_code")
    private String postalCode;

    @Column(name = "country")
    private String country;

    @Column(name = "sales_rep_employee_id",insertable=false, updatable=false)
    private Integer salesRepEmployeeId;

    @Column(name = "credit_limit", columnDefinition = "decimal")
    private double creditLimit;
    //@Column(name = "created")
    //@Temporal(TemporalType.TIMESTAMP)
    //private Date created;

}
