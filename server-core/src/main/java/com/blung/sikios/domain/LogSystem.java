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
@Table(name = "log_system")
public class LogSystem {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "log_system_id")
    private Long id;

    @ManyToOne
    @JoinColumn(nullable = false, name = "user_id")
    private User user;

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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
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

        LogSystem logSystem = (LogSystem) o;

        if (action != null ? !action.equals(logSystem.action) : logSystem.action != null) return false;
        if (id != null ? !id.equals(logSystem.id) : logSystem.id != null) return false;
        if (path != null ? !path.equals(logSystem.path) : logSystem.path != null) return false;
        if (user != null ? !user.equals(logSystem.user) : logSystem.user != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (user != null ? user.hashCode() : 0);
        result = 31 * result + (path != null ? path.hashCode() : 0);
        result = 31 * result + (action != null ? action.hashCode() : 0);
        return result;
    }
}
