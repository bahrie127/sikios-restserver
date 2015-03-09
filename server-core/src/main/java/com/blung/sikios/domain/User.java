package com.blung.sikios.domain;

import javax.persistence.*;
import javax.validation.constraints.Size;

/**
 * Created with IntelliJ IDEA.
 * User: saifulbahri
 * Date: 9/17/13
 * Time: 9:53 PM
 * To change this template use File | Settings | File Templates.
 */
@Entity
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "user_id")
    private Long id;

    @Column(nullable = false,length = 30,name = "username")
    @Size(min = 0,max = 30)
    private String username;

    @Column(nullable = false,length = 30,name = "password")
    @Size(min = 0,max = 30)
    private String password;

    @Column(nullable = false,name = "akses")
    private Integer akses;

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
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getAkses() {
        return akses;
    }

    public void setAkses(Integer akses) {
        this.akses = akses;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        if (akses != null ? !akses.equals(user.akses) : user.akses != null) return false;
        if (id != null ? !id.equals(user.id) : user.id != null) return false;
        if (password != null ? !password.equals(user.password) : user.password != null) return false;
        if (username != null ? !username.equals(user.username) : user.username != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (username != null ? username.hashCode() : 0);
        result = 31 * result + (password != null ? password.hashCode() : 0);
        result = 31 * result + (akses != null ? akses.hashCode() : 0);
        return result;
    }
}
