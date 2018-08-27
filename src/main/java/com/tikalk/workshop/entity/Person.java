package com.tikalk.workshop.entity;

import javax.persistence.*;
import java.util.Objects;

/**
 * Person table entity
 * Created by sigals on 03/03/2018.
 */
@Entity
@Table(name="person")
public class Person {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name = "ID", unique = true, nullable = false)
    private Long id;

    @Column(name = "givenName", nullable = false)
    private String givenName;

    @Column(name = "sureName")
    private String sureName;

    public Person() {
    }

    public Person(String givenName, String sureName) {
        this.givenName = givenName;
        this.sureName = sureName;
    }

    public Long getId() {
        return id;
    }

    public String getGivenName() {
        return givenName;
    }

    public void setGivenName(String givenName) {
        this.givenName = givenName;
    }

    public String getSureName() {
        return sureName;
    }

    public void setSureName(String sureName) {
        this.sureName = sureName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return Objects.equals(id, person.id) &&
                Objects.equals(givenName, person.givenName) &&
                Objects.equals(sureName, person.sureName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, givenName, sureName);
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", givenName='" + givenName + '\'' +
                ", sureName='" + sureName + '\'' +
                '}';
    }
}
