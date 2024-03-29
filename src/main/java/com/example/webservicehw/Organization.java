package com.example.webservicehw;

import java.time.LocalDate;

public class Organization {
    private Long id;
    private String title;
    private String address;
    private LocalDate creationDate;

    public Organization(){
    }

    public Organization(Long id, String title, String address, LocalDate creationDate){
        this.id = id;
        this.title = title;
        this.address = address;
        this.creationDate = creationDate;
    }

    public long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public LocalDate getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDate creationDate) {
        this.creationDate = creationDate;
    }
}
