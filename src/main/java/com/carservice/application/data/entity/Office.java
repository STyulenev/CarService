package com.carservice.application.data.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "Office", schema = "public")
public class Office {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "city", length = 30)
    private String city;

    @Column(name = "address", length = 30)
    private String address;

    @OneToMany(mappedBy = "id")
    private List<Office> offices;

    /*public Office() {}

    public Office(Long id, String city, String address) {
        this.id = id;
        this.city = city;
        this.address = address;
    }*/

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public List<Office> getOffices() {
        return offices;
    }

    public void setOffices(List<Office> offices) {
        this.offices = offices;
    }
}
