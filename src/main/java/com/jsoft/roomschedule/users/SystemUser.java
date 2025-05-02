package com.jsoft.roomschedule.users;

import jakarta.persistence.*;

@Entity
@Table(name = "system_user")
public class SystemUser {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "system_user_seq")
    @SequenceGenerator(name = "system_user_seq", sequenceName = "system_user_seq")
    private Long id;
    private String login;
    private String password;
    private String email;
    @OneToOne
    private Profile profile;

    public SystemUser() {
    }

    public SystemUser(Long id, String login, String password, String email, Profile profile) {
        this.id = id;
        this.login = login;
        this.password = password;
        this.email = email;
        this.profile = profile;
    }
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getLogin() {
        return login;
    }
    public void setLogin(String login) {
        this.login = login;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public Profile getProfile() {
        return profile;
    }
    public void setProfile(Profile profile) {
        this.profile = profile;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
