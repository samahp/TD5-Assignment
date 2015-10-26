package com.jking31cs.jerseyexample.objects;

import com.google.common.base.Objects;
import com.googlecode.objectify.annotation.Entity;
import com.googlecode.objectify.annotation.Id;
import com.fasterxml.jackson.annotation.JsonCreator;

/**
 * Contains basic information about a User, specifically a name and email address.
 */
@Entity
public class User {

    @Id
    private Long id;

    private String name;
    private String email;

    @JsonCreator
    public User() {}



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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equal(id, user.id) &&
            Objects.equal(name, user.name) &&
            Objects.equal(email, user.email);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id, name, email);
    }
}
