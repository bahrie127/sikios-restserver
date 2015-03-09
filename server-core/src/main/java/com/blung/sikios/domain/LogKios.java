package com.blung.sikios.domain;

import javax.persistence.*;
import javax.validation.constraints.Size;

/**
 * Created with IntelliJ IDEA.
 * User: saifulbahri
 * Date: 9/17/13
 * Time: 9:58 PM
 * To change this template use File | Settings | File Templates.
 */
@Entity
@Table(name = "log_kios")
public class LogKios {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "log_kios_id")
    private Long id;

    @ManyToOne
    @JoinColumn(nullable = false, name = "user_kios_id")
    private UserKios userKios;

    @Column(nullable = false,length = 255,name = "path")
    @Size(min = 0,max = 255)
    private String path;

    @Column(nullable = false,length = 30,name = "action")
    @Size(min = 0,max = 30)
    private String action;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public UserKios getUserKios() {
        return userKios;
    }

    public void setUserKios(UserKios userKios) {
        this.userKios = userKios;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        LogKios logKios = (LogKios) o;

        if (action != null ? !action.equals(logKios.action) : logKios.action != null) return false;
        if (id != null ? !id.equals(logKios.id) : logKios.id != null) return false;
        if (path != null ? !path.equals(logKios.path) : logKios.path != null) return false;
        if (userKios != null ? !userKios.equals(logKios.userKios) : logKios.userKios != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (userKios != null ? userKios.hashCode() : 0);
        result = 31 * result + (path != null ? path.hashCode() : 0);
        result = 31 * result + (action != null ? action.hashCode() : 0);
        return result;
    }
}
