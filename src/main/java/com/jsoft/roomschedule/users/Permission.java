package com.jsoft.roomschedule.users;

import jakarta.persistence.*;

@Entity
@Table(name = "permission")
public class Permission {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "permission_seq")
    @SequenceGenerator(name = "permission_seq", sequenceName = "permission_seq")
    private Long id;
    @Enumerated(EnumType.STRING)
    private RoleName key;
    private String description;
    private String label;

    public Permission() {
    }

    public Permission(Long id, RoleName key, String description, String label) {
        this.id = id;
        this.key = key;
        this.description = description;
        this.label = label;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public RoleName getKey() {
        return key;
    }

    public void setKey(RoleName key) {
        this.key = key;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }
}
