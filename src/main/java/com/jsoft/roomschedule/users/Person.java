package com.jsoft.roomschedule.users;

import jakarta.persistence.*;

@Entity
@Table(name = "person")
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "person_seq")
    @SequenceGenerator(name = "person_seq", sequenceName = "person_seq")
    private Long id;
    private String name;
    private String documenyIdentification;
    @OneToOne
    private User user;

    public Person() {
    }

    public Person(Long id, String name, String documenyIdentification, User user) {
        this.id = id;
        this.name = name;
        this.documenyIdentification = documenyIdentification;
        this.user = user;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDocumenyIdentification() {
        return documenyIdentification;
    }

    public void setDocumenyIdentification(String documenyIdentification) {
        this.documenyIdentification = documenyIdentification;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
