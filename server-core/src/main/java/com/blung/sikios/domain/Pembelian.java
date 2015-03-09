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
 * Time: 10:32 PM
 * To change this template use File | Settings | File Templates.
 */
@Entity
@Table(name = "pembelian")
public class Pembelian {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "pembelian_id")
    private Long id;

    @ManyToOne
    @JoinColumn(nullable = false, name = "cabang_id")
    private Cabang cabang;

    @Column(nullable = false,name = "total")
    private Integer total;

    @Column(nullable = false,length = 200,name = "keterangan")
    @Size(min = 0,max = 200)
    private String keterangan;

    @Column(nullable = false, name = "tanggal")
    @Temporal(value = TemporalType.TIMESTAMP)
    private Calendar tanggal;

    @ManyToOne
    @JoinColumn(nullable = false, name = "supplier_id")
    private Supplier supplier;

    @OneToMany
    @JoinTable(
            name = "detail_pembelian_list",
            joinColumns = {@JoinColumn(name = "pembelian_id")},
            inverseJoinColumns = {@JoinColumn(table = "detail_pembelian", name = "detail_pembelian_id")}
    )
    @LazyCollection(value = LazyCollectionOption.FALSE)
    private List<DetailPembelian> detailPembelians;

    @OneToMany
    @JoinTable(
            name = "hutang_list",
            joinColumns = {@JoinColumn(name = "pembelian_id")},
            inverseJoinColumns = {@JoinColumn(table = "hutang", name = "hutang_id")}
    )
    @LazyCollection(value = LazyCollectionOption.FALSE)
    private List<Hutang> hutangs;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Cabang getCabang() {
        return cabang;
    }

    public void setCabang(Cabang cabang) {
        this.cabang = cabang;
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

    public Supplier getSupplier() {
        return supplier;
    }

    public void setSupplier(Supplier supplier) {
        this.supplier = supplier;
    }

    public List<DetailPembelian> getDetailPembelians() {
        return detailPembelians;
    }

    public void setDetailPembelians(List<DetailPembelian> detailPembelians) {
        this.detailPembelians = detailPembelians;
    }

    public List<Hutang> getHutangs() {
        return hutangs;
    }

    public void setHutangs(List<Hutang> hutangs) {
        this.hutangs = hutangs;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Pembelian pembelian = (Pembelian) o;

        if (cabang != null ? !cabang.equals(pembelian.cabang) : pembelian.cabang != null) return false;
        if (id != null ? !id.equals(pembelian.id) : pembelian.id != null) return false;
        if (keterangan != null ? !keterangan.equals(pembelian.keterangan) : pembelian.keterangan != null) return false;
        if (supplier != null ? !supplier.equals(pembelian.supplier) : pembelian.supplier != null) return false;
        if (tanggal != null ? !tanggal.equals(pembelian.tanggal) : pembelian.tanggal != null) return false;
        if (total != null ? !total.equals(pembelian.total) : pembelian.total != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (cabang != null ? cabang.hashCode() : 0);
        result = 31 * result + (total != null ? total.hashCode() : 0);
        result = 31 * result + (keterangan != null ? keterangan.hashCode() : 0);
        result = 31 * result + (tanggal != null ? tanggal.hashCode() : 0);
        result = 31 * result + (supplier != null ? supplier.hashCode() : 0);
        return result;
    }
}
