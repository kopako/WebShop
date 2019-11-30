package com.gmail.kopandima.webshop.models;

import javax.persistence.*;

import org.springframework.security.core.GrantedAuthority;

import java.util.Set;

@Entity
public class Role implements GrantedAuthority{
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true)
    private String name;

    @ManyToMany(mappedBy = "roles")
    private Set<User> customUsers;

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

    public Set<User> getCustomUsers() {
        return customUsers;
    }

    public void setCustomUsers(Set<User> customUsers) {
        this.customUsers = customUsers;
    }

    @Override
    public String getAuthority() {
          return this.getName();
    }
}
