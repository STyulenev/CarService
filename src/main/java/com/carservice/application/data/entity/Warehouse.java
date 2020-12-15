package com.carservice.application.data.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "Warehouse", schema = "public")
public class Warehouse {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne()
    @JoinColumn(name = "detailId")
    private Detail ownerDetail;

    @ManyToOne()
    @JoinColumn(name = "officeId")
    private Office ownerOffice;

    @Column(name = "quantity")
    private Integer quantity;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Detail getOwnerDetail() {
        return ownerDetail;
    }

    public void setOwnerDetail(Detail ownerDetail) {
        this.ownerDetail = ownerDetail;
    }

    public Office getOwnerOffice() {
        return ownerOffice;
    }

    public void setOwnerOffice(Office ownerOffice) {
        this.ownerOffice = ownerOffice;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
}
