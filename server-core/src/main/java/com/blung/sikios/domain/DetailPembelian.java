package com.blung.sikios.domain;

import javax.persistence.*;
import javax.validation.constraints.Size;

/**
 * Created with IntelliJ IDEA.
 * User: saifulbahri
 * Date: 9/17/13
 * Time: 9:31 PM
 * To change this template use File | Settings | File Templates.
 */
@Entity
@Table(name = "detail_pembelian")
public class DetailPembelian {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "detail_pembelian_id")
    private Long id;

    @ManyToOne
    @JoinColumn(nullable = false, name = "barang_id")
    private Barang barang;

    @Column(nullable = false,name = "stok")
    private Integer stok;

    @Column(nullable = false,name = "harga_beli")
    private Integer hargaBeli;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Barang getBarang() {
        return barang;
    }

    public void setBarang(Barang barang) {
        this.barang = barang;
    }

    public Integer getStok() {
        return stok;
    }

    public void setStok(Integer stok) {
        this.stok = stok;
    }

    public Integer getHargaBeli() {
        return hargaBeli;
    }

    public void setHargaBeli(Integer hargaBeli) {
        this.hargaBeli = hargaBeli;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        DetailPembelian that = (DetailPembelian) o;

        if (barang != null ? !barang.equals(that.barang) : that.barang != null) return false;
        if (hargaBeli != null ? !hargaBeli.equals(that.hargaBeli) : that.hargaBeli != null) return false;
        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (stok != null ? !stok.equals(that.stok) : that.stok != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (barang != null ? barang.hashCode() : 0);
        result = 31 * result + (stok != null ? stok.hashCode() : 0);
        result = 31 * result + (hargaBeli != null ? hargaBeli.hashCode() : 0);
        return result;
    }
}
