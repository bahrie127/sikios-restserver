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
@Table(name = "user_kios")
public class UserKios {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "user_kios_id")
    private Long id;

    @ManyToOne
    @JoinColumn(nullable = false, name = "kios_id")
    private Kios kios;

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

    public Kios getKios() {
        return kios;
    }

    public void setKios(Kios kios) {
        this.kios = kios;
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

        UserKios userKios = (UserKios) o;

        if (akses != null ? !akses.equals(userKios.akses) : userKios.akses != null) return false;
        if (id != null ? !id.equals(userKios.id) : userKios.id != null) return false;
        if (kios != null ? !kios.equals(userKios.kios) : userKios.kios != null) return false;
        if (password != null ? !password.equals(userKios.password) : userKios.password != null) return false;
        if (username != null ? !username.equals(userKios.username) : userKios.username != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (kios != null ? kios.hashCode() : 0);
        result = 31 * result + (username != null ? username.hashCode() : 0);
        result = 31 * result + (password != null ? password.hashCode() : 0);
        result = 31 * result + (akses != null ? akses.hashCode() : 0);
        return result;
    }
}
