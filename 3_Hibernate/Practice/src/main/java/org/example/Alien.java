package org.example;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name="alien_table") // change the table name
public class Alien {
    @Id
    private int aid;
    @Column(name="alien_name") // change the column name
    private String aname;
//    @Transient // if you don't want this field to be inserted in the database
    private String tech;

    @OneToMany(mappedBy = "alien") // fetch = FetchType.EAGER) one of the mothod to fetch eagerly instead of lazy
    // fetching  |||  instead we can use (mappedBy and let the laptop table handle the relationship instead of
    // creating a seperate alien+laptop table for mapping)
    private List<Laptop> laptops;

    public String getAname() {
        return aname;
    }

    public void setAname(String aname) {
        this.aname = aname;
    }

    public String getTech() {
        return tech;
    }

    public void setTech(String tech) {
        this.tech = tech;
    }

    public int getAid() {
        return aid;
    }

    public void setAid(int aid) {
        this.aid = aid;
    }

    public List<Laptop> getLaptop() {
        return laptops;
    }

    public void setLaptops(List<Laptop> laptop) {
        this.laptops = laptop;
    }

    @Override
    public String toString() {
        return "Alien{" +
                "aid=" + aid +
                ", aname='" + aname + '\'' +
                ", tech='" + tech + '\'' +
                ", laptop=" + laptops +
                '}';
    }
}
