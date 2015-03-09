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
@Table(name = "pembayaran_hutang")
public class PembayaranHutang {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "pembayaran_hutang_id")
    private Long id;

    @ManyToOne
    @JoinColumn(nullable = false, name = "hutang_id")
    private Hutang hutang;

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

    public Hutang getHutang() {
        return hutang;
    }

    public void setHutang(Hutang hutang) {
        this.hutang = hutang;
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

        PembayaranHutang that = (PembayaranHutang) o;

        if (hutang != null ? !hutang.equals(that.hutang) : that.hutang != null) return false;
        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (tanggal != null ? !tanggal.equals(that.tanggal) : that.tanggal != null) return false;
        if (total != null ? !total.equals(that.total) : that.total != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (hutang != null ? hutang.hashCode() : 0);
        result = 31 * result + (total != null ? total.hashCode() : 0);
        result = 31 * result + (tanggal != null ? tanggal.hashCode() : 0);
        return result;
    }
}
