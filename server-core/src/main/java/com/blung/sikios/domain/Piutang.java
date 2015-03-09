package com.blung.sikios.domain;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.Calendar;

/**
 * Created with IntelliJ IDEA.
 * User: saifulbahri
 * Date: 9/17/13
 * Time: 9:47 PM
 * To change this template use File | Settings | File Templates.
 */
@Entity
@Table(name = "piutang")
public class Piutang {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "piutang_id")
    private Long id;

    @Column(nullable = false,length = 50,name = "nama")
    @Size(min = 0,max = 50)
    private String nama;

    @Column(nullable = false, name = "jatuh_tempo")
    @Temporal(value = TemporalType.DATE)
    private Calendar jatuhTempo;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Calendar getJatuhTempo() {
        return jatuhTempo;
    }

    public void setJatuhTempo(Calendar jatuhTempo) {
        this.jatuhTempo = jatuhTempo;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Piutang piutang = (Piutang) o;

        if (id != null ? !id.equals(piutang.id) : piutang.id != null) return false;
        if (jatuhTempo != null ? !jatuhTempo.equals(piutang.jatuhTempo) : piutang.jatuhTempo != null) return false;
        if (nama != null ? !nama.equals(piutang.nama) : piutang.nama != null) return false;


        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;

        result = 31 * result + (nama != null ? nama.hashCode() : 0);
        result = 31 * result + (jatuhTempo != null ? jatuhTempo.hashCode() : 0);
        return result;
    }
}
