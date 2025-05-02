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
    private SystemUser systemUser;

    public Person() {
    }

    public Person(Long id, String name, String documenyIdentification, SystemUser systemUser) {
        this.id = id;
        this.name = name;
        this.documenyIdentification = documenyIdentification;
        this.systemUser = systemUser;
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

    public SystemUser getUser() {
        return systemUser;
    }

    public void setUser(SystemUser systemUser) {
        this.systemUser = systemUser;
    }
}
