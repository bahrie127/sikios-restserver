package com.blung.sikios.domain;

import javax.persistence.*;
import javax.validation.constraints.Size;

/**
 * Created with IntelliJ IDEA.
 * User: saifulbahri
 * Date: 9/9/13
 * Time: 9:31 PM
 * To change this template use File | Settings | File Templates.
 */
@Entity
@Table(name = "cabang")
public class Cabang {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "cabang_id")
    private Long id;

    @Column(nullable =false,length = 40,name = "nama_cabang")
    @Size(min = 0,max = 40)
    private String namaCabang;

    @ManyToOne
    @JoinColumn(nullable = false, name = "kios_id")
    private Kios kios;

    @Column(nullable = true,length = 100,name = "alamat_cabang")
    @Size(min = 0,max = 100)
    private String alamatCabang;

    @Column(nullable = false,length = 1,name = "is_active")
    @Size(min = 0,max = 1)
    private String isActive;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNamaCabang() {
        return namaCabang;
    }

    public void setNamaCabang(String namaCabang) {
        this.namaCabang = namaCabang;
    }

    public Kios getKios() {
        return kios;
    }

    public void setKios(Kios kios) {
        this.kios = kios;
    }

    public String getAlamatCabang() {
        return alamatCabang;
    }

    public void setAlamatCabang(String alamatCabang) {
        this.alamatCabang = alamatCabang;
    }

    public String getActive() {
        return isActive;
    }

    public void setActive(String active) {
        isActive = active;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Cabang cabang = (Cabang) o;

        if (alamatCabang != null ? !alamatCabang.equals(cabang.alamatCabang) : cabang.alamatCabang != null)
            return false;
        if (id != null ? !id.equals(cabang.id) : cabang.id != null) return false;
        if (isActive != null ? !isActive.equals(cabang.isActive) : cabang.isActive != null) return false;
        if (kios != null ? !kios.equals(cabang.kios) : cabang.kios != null) return false;
        if (namaCabang != null ? !namaCabang.equals(cabang.namaCabang) : cabang.namaCabang != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (namaCabang != null ? namaCabang.hashCode() : 0);
        result = 31 * result + (kios != null ? kios.hashCode() : 0);
        result = 31 * result + (alamatCabang != null ? alamatCabang.hashCode() : 0);
        result = 31 * result + (isActive != null ? isActive.hashCode() : 0);
        return result;
    }
}
