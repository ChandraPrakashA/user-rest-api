package com.restful.restApiCreation1.model;

import javax.persistence.*;
import java.util.StringJoiner;

@Entity
@Table(name = "address")
public class Address {
    @Id
    @GeneratedValue
    private long id;
    @Column
    private String city;
    @Column
    private String state;
    @Column
    private String country;


    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "userId", referencedColumnName = "id")
    private User user;

//    @OneToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "artist_id")
//    private Artist artist;

    public long getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Address.class.getSimpleName() + "[", "]")
                .add("id=" + id)
                .add("city='" + city + "'")
                .add("state='" + state + "'")
                .add("country='" + country + "'")
                .add("user=" + user)
                .toString();
    }
}
