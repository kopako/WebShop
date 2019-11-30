package com.gmail.kopandima.webshop.models;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "usr")
public class User {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true)
//    @Size(min = 8, max = 20)
    private String username;
    @Column(length = 100)
    private String password;
    @ManyToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    @JoinTable(
            name = "users_roles",
            joinColumns = @JoinColumn(
                    name = "user_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(
                    name = "role_id", referencedColumnName = "id"))
    private Collection<Role> roles;

    public User() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setRoles(Collection<Role> roles) {
        this.roles = roles;
    }

    public Collection<Role> getRoles() {
        return roles;
    }


    public static final class CustomUserBuilder {
        private Long id;
        //    @Size(min = 8, max = 20)
        private String username;
        private String password;
        private Collection<Role> roles;

        private CustomUserBuilder() {
        }

        public static CustomUserBuilder aCustomUser() {
            return new CustomUserBuilder();
        }

        public CustomUserBuilder withId(Long id) {
            this.id = id;
            return this;
        }

        public CustomUserBuilder withUsername(String username) {
            this.username = username;
            return this;
        }

        public CustomUserBuilder withPassword(String password) {
            this.password = password;
            return this;
        }

        public CustomUserBuilder withRoles(Collection<Role> roles) {
            this.roles = roles;
            return this;
        }

        public User build() {
            User customUser = new User();
            customUser.setId(id);
            customUser.setUsername(username);
            customUser.setPassword(password);
            customUser.setRoles(roles);
            return customUser;
        }
    }
}

//    @Override
//    public boolean isAccountNonExpired() {
//        return true;
//    }
//
//    @Override
//    public boolean isAccountNonLocked() {
//        return true;
//    }
//
//    @Override
//    public boolean isCredentialsNonExpired() {
//        return true;
//    }
//
//    @Override
//    public boolean isEnabled() {
//        return this.enabled;
//    }
//
//    public void setUsername(String username) {
//        this.username = username;
//    }
//
//    @Override
//    public Collection<? extends GrantedAuthority> getAuthorities() {
//        return this.getRoles();
//    }
