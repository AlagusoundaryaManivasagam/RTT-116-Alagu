package com.example.module309.database.entity;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "employees")
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Employee implements Serializable {
    // the @Id anotation tells hibernate that this is private key for this entity
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    // this tells hibernate that the database will auto increment the new Id for a new record in the database
    @Column(name = "id")
    private Integer id;

    @OneToMany(mappedBy = "employee", fetch = FetchType.LAZY,
            cascade = CascadeType.ALL)
    @ToString.Exclude
    private List<Customer> customers;

    @Column(name = "office_id")
    private int officeId;

    @Column(name = "lastname")
    private String lastname;

    @Column(name = "firstname")
    private String firstName;
    @Column(name = "extension")
    private String extension;

    @Column(name = "email")
    private String email;

    @Column(name = "reports_to")
    private Integer reportsTo;

    @Column(name = "job_title")
    private String jobTitle;

    @Column(name = "vacation_hours")
    private int vacationHours;

    @Column(name = "profile_image_url")
    private String profileImageUrl;

    public Employee(int id, int officeId, String lastname, String firstName, String extension, String email,
                    int reportsTo, String jobTitle, int vacationHours, String profileImageUrl) {
        this.id = id;
        this.officeId = officeId;
        this.lastname = lastname;
        this.firstName = firstName;
        this.extension = extension;
        this.email = email;
        this.reportsTo = reportsTo;
        this.jobTitle = jobTitle;
        this.vacationHours = vacationHours;
        this.profileImageUrl = profileImageUrl;
    }



    public Integer getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getOfficeId() {
        return officeId;
    }

    public void setOfficeId(int officeId) {
        this.officeId = officeId;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getExtension() {
        return extension;
    }

    public void setExtension(String extension) {
        this.extension = extension;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getReportsTo() {
        return reportsTo;
    }

    public void setReportsTo(int reportsTo) {
        this.reportsTo = reportsTo;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public int getVacationHours() {
        return vacationHours;
    }

    public void setVacationHours(int vacationHours) {
        this.vacationHours = vacationHours;
    }

    public String getProfileImageUrl() {
        return profileImageUrl;
    }

    public void setProfileImageUrl(String profileImageUrl) {
        this.profileImageUrl = profileImageUrl;
    }

    public List<Customer> getCustomers() {
        return customers;
    }

    public void setCustomers(List<Customer> customers) {
        this.customers = customers;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", officeId=" + officeId +
                ", lastname='" + lastname + '\'' +
                ", firstName='" + firstName + '\'' +
                ", extension='" + extension + '\'' +
                ", email='" + email + '\'' +
                ", reportsTo=" + reportsTo +
                ", jobTitle='" + jobTitle + '\'' +
                ", vacationHours=" + vacationHours +
                ", profileImageUrl='" + profileImageUrl + '\'' +
                '}';
    }
}
