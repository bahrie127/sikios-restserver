package com.blung.sikios.domain;

import javax.persistence.*;
import java.util.Calendar;

/**
 * Created with IntelliJ IDEA.
 * User: saifulbahri
 * Date: 9/17/13
 * Time: 9:45 PM
 * To change this template use File | Settings | File Templates.
 */
@Entity
@Table(name = "pembayaran_piutang")
public class PembayaranPiutang {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "pembayaran_piutang_id")
    private Long id;

    @ManyToOne
    @JoinColumn(nullable = false, name = "piutang_id")
    private Piutang piutang;

    @Column(nullable = false,name = "total")
    private Integer total;

    @Column(nullable = false, name = "tanggal")
    @Temporal(value = TemporalType.DATE)
    private Calendar tanggal;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Piutang getPiutang() {
        return piutang;
    }

    public void setPiutang(Piutang piutang) {
        this.piutang = piutang;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public Calendar getTanggal() {
        return tanggal;
    }

    public void setTanggal(Calendar tanggal) {
        this.tanggal = tanggal;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PembayaranPiutang that = (PembayaranPiutang) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (piutang != null ? !piutang.equals(that.piutang) : that.piutang != null) return false;
        if (tanggal != null ? !tanggal.equals(that.tanggal) : that.tanggal != null) return false;
        if (total != null ? !total.equals(that.total) : that.total != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (piutang != null ? piutang.hashCode() : 0);
        result = 31 * result + (total != null ? total.hashCode() : 0);
        result = 31 * result + (tanggal != null ? tanggal.hashCode() : 0);
        return result;
    }
}
