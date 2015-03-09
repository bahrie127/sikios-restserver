package com.blung.sikios.domain;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.Calendar;

/**
 * Created with IntelliJ IDEA.
 * User: saifulbahri
 * Date: 9/17/13
 * Time: 9:21 PM
 * To change this template use File | Settings | File Templates.
 */
@Entity
@Table(name = "pembayaran_kios")
public class PembayaranKios {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "pembayaran_kios_id")
    private Long id;

    @ManyToOne
    @JoinColumn(nullable = false, name = "kios_id")
    private Kios kios;

    @Column(nullable = false, name = "tanggal")
    @Temporal(value = TemporalType.DATE)
    private Calendar tanggal;

    @Column(nullable =false,name = "total")
    private Integer total;

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

    public Calendar getTanggal() {
        return tanggal;
    }

    public void setTanggal(Calendar tanggal) {
        this.tanggal = tanggal;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PembayaranKios that = (PembayaranKios) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (kios != null ? !kios.equals(that.kios) : that.kios != null) return false;
        if (tanggal != null ? !tanggal.equals(that.tanggal) : that.tanggal != null) return false;
        if (total != null ? !total.equals(that.total) : that.total != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (kios != null ? kios.hashCode() : 0);
        result = 31 * result + (tanggal != null ? tanggal.hashCode() : 0);
        result = 31 * result + (total != null ? total.hashCode() : 0);
        return result;
    }
}
