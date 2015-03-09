package com.blung.sikios.domain;

import javax.persistence.*;
import javax.validation.constraints.Size;

/**
 * Created with IntelliJ IDEA.
 * User: saifulbahri
 * Date: 9/17/13
 * Time: 9:08 PM
 * To change this template use File | Settings | File Templates.
 */
@Entity
@Table(name = "barang")
public class Barang {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "barang_id")
    private Long id;

    @ManyToOne
    @JoinColumn(nullable = false, name = "supplier_id")
    private Supplier supplier;

    @Column(nullable =false,length = 100,name = "nama")
    @Size(min = 0,max = 100)
    private String nama;

    @Column(name = "harga_jual")
    private Integer hargaJual;

    @Column(name = "harga_beli")
    private Integer hargaBeli;

    @Column(name = "stok")
    private Integer stok;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Supplier getSupplier() {
        return supplier;
    }

    public void setSupplier(Supplier supplier) {
        this.supplier = supplier;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public Integer getHargaJual() {
        return hargaJual;
    }

    public void setHargaJual(Integer hargaJual) {
        this.hargaJual = hargaJual;
    }

    public Integer getHargaBeli() {
        return hargaBeli;
    }

    public void setHargaBeli(Integer hargaBeli) {
        this.hargaBeli = hargaBeli;
    }

    public Integer getStok() {
        return stok;
    }

    public void setStok(Integer stok) {
        this.stok = stok;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Barang barang = (Barang) o;

        if (hargaBeli != null ? !hargaBeli.equals(barang.hargaBeli) : barang.hargaBeli != null) return false;
        if (hargaJual != null ? !hargaJual.equals(barang.hargaJual) : barang.hargaJual != null) return false;
        if (id != null ? !id.equals(barang.id) : barang.id != null) return false;
        if (nama != null ? !nama.equals(barang.nama) : barang.nama != null) return false;
        if (stok != null ? !stok.equals(barang.stok) : barang.stok != null) return false;
        if (supplier != null ? !supplier.equals(barang.supplier) : barang.supplier != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (supplier != null ? supplier.hashCode() : 0);
        result = 31 * result + (nama != null ? nama.hashCode() : 0);
        result = 31 * result + (hargaJual != null ? hargaJual.hashCode() : 0);
        result = 31 * result + (hargaBeli != null ? hargaBeli.hashCode() : 0);
        result = 31 * result + (stok != null ? stok.hashCode() : 0);
        return result;
    }
}
