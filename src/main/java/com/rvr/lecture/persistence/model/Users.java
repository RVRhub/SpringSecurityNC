package com.rvr.lecture.persistence.model;


import javax.persistence.*;
import java.util.Set;

@Entity
public class Users {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "USER_ID")
    private Long id;

    @Column(unique = true, nullable = false)
    private String name;

    @Column(nullable = false)
    private String password;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(// @formatter:off
            joinColumns =        { @JoinColumn(name = "USER_ID", referencedColumnName = "USER_ID") },
            inverseJoinColumns = { @JoinColumn(name = "AUTHORITY_ID", referencedColumnName = "AUTHORITY_ID") }
    ) // @formatter:on
    private Set<Authority> authorities;

    public Users() {
        super();
    }

    public Users(final String nameToSet, final String passwordToSet, final Set<Authority> rolesToSet) {
        super();

        name = nameToSet;
        password = passwordToSet;
        authorities = rolesToSet;
    }

    public Users(final String nameToSet, final String passwordToSet, final Set<Authority> rolesToSet, final String uuidToSet) {
        this(nameToSet, passwordToSet, rolesToSet);
    }

    // API

    public Long getId() {
        return id;
    }

    public void setId(final Long idToSet) {
        id = idToSet;
    }

    public String getName() {
        return name;
    }

    public void setName(final String nameToSet) {
        name = nameToSet;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(final String passwordToSet) {
        password = passwordToSet;
    }

    public Set<Authority> getAuthorities() {
        return authorities;
    }

    public void setAuthorities(final Set<Authority> authorities) {
        this.authorities = authorities;
    }

    //

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        return result;
    }

    @Override
    public boolean equals(final Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        final Users other = (Users) obj;
        if (name == null) {
            if (other.name != null)
                return false;
        } else if (!name.equals(other.name))
            return false;
        return true;
    }

}
