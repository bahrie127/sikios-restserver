package com.blung.sikios.domain;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.Calendar;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: saifulbahri
 * Date: 9/9/13
 * Time: 10:16 PM
 * To change this template use File | Settings | File Templates.
 */
@Entity
@Table(name = "penjualan")
public class Penjualan {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "penjualan_id")
    private Long id;

    @ManyToOne
    @JoinColumn(nullable = false, name = "karyawan_id")
    private Karyawan karyawan;

    @Column(nullable = false,name = "total")
    private Integer total;

    @Column(nullable = false,length = 200,name = "keterangan")
    @Size(min = 0,max = 200)
    private String keterangan;

    @Column(nullable = false, name = "tanggal")
    @Temporal(value = TemporalType.TIMESTAMP)
    private Calendar tanggal;

    @OneToMany
    @JoinTable(
            name = "detail_penjualan_list",
            joinColumns = {@JoinColumn(name = "penjualan_id")},
            inverseJoinColumns = {@JoinColumn(table = "detail_penjualan", name = "detail_penjualan_id")}
    )
    @LazyCollection(value = LazyCollectionOption.FALSE)
    private List<DetailPenjualan> detailPenjualans;

    @OneToMany
    @JoinTable(
            name = "piutang_list",
            joinColumns = {@JoinColumn(name = "penjualan_id")},
            inverseJoinColumns = {@JoinColumn(table = "piutang", name = "piutang_id")}
    )
    @LazyCollection(value = LazyCollectionOption.FALSE)
    private List<Piutang> piutangs;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Karyawan getKaryawan() {
        return karyawan;
    }

    public void setKaryawan(Karyawan karyawan) {
        this.karyawan = karyawan;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public String getKeterangan() {
        return keterangan;
    }

    public void setKeterangan(String keterangan) {
        this.keterangan = keterangan;
    }

    public Calendar getTanggal() {
        return tanggal;
    }

    public void setTanggal(Calendar tanggal) {
        this.tanggal = tanggal;
    }

    public List<DetailPenjualan> getDetailPenjualans() {
        return detailPenjualans;
    }

    public void setDetailPenjualans(List<DetailPenjualan> detailPenjualans) {
        this.detailPenjualans = detailPenjualans;
    }

    public List<Piutang> getPiutangs() {
        return piutangs;
    }

    public void setPiutangs(List<Piutang> piutangs) {
        this.piutangs = piutangs;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Penjualan penjualan = (Penjualan) o;

        if (id != null ? !id.equals(penjualan.id) : penjualan.id != null) return false;
        if (karyawan != null ? !karyawan.equals(penjualan.karyawan) : penjualan.karyawan != null) return false;
        if (keterangan != null ? !keterangan.equals(penjualan.keterangan) : penjualan.keterangan != null) return false;
        if (tanggal != null ? !tanggal.equals(penjualan.tanggal) : penjualan.tanggal != null) return false;
        if (total != null ? !total.equals(penjualan.total) : penjualan.total != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (karyawan != null ? karyawan.hashCode() : 0);
        result = 31 * result + (total != null ? total.hashCode() : 0);
        result = 31 * result + (keterangan != null ? keterangan.hashCode() : 0);
        result = 31 * result + (tanggal != null ? tanggal.hashCode() : 0);
        return result;
    }
}
