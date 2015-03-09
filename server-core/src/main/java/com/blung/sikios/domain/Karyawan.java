package com.blung.sikios.domain;

import com.blung.sikios.model.enums.Jabatan;

import javax.persistence.*;
import javax.validation.constraints.Size;

/**
 * Created with IntelliJ IDEA.
 * User: saifulbahri
 * Date: 9/9/13
 * Time: 9:51 PM
 * To change this template use File | Settings | File Templates.
 */
@Entity
@Table(name = "karyawan")
public class Karyawan {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "karyawan_id")
    private Long id;

    @Column(nullable = false,length = 50,name = "nama_karyawan")
    @Size(min = 0,max = 50)
    private String namaKaryawan;

    @Column(nullable = false,length = 15,name = "nomor_hp")
    @Size(min = 0,max = 50)
    private String nomorHp;

    @ManyToOne
    @JoinColumn(nullable = false, name = "cabang_id")
    private Cabang cabang;

    @Column(nullable = false,length = 30,name = "password")
    @Size(min = 0,max = 30)
    private String password;

    @Column(nullable = false,length = 1,name = "is_active")
    @Size(min = 0,max = 1)
    private String isActive;

    @Column(nullable = false,name = "jabatan")
    private Jabatan jabatan;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNamaKaryawan() {
        return namaKaryawan;
    }

    public void setNamaKaryawan(String namaKaryawan) {
        this.namaKaryawan = namaKaryawan;
    }

    public String getNomorHp() {
        return nomorHp;
    }

    public void setNomorHp(String nomorHp) {
        this.nomorHp = nomorHp;
    }

    public Cabang getCabang() {
        return cabang;
    }

    public void setCabang(Cabang cabang) {
        this.cabang = cabang;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getActive() {
        return isActive;
    }

    public void setActive(String active) {
        isActive = active;
    }

    public Jabatan getJabatan() {
        return jabatan;
    }

    public void setJabatan(Jabatan jabatan) {
        this.jabatan = jabatan;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Karyawan karyawan = (Karyawan) o;

        if (cabang != null ? !cabang.equals(karyawan.cabang) : karyawan.cabang != null) return false;
        if (id != null ? !id.equals(karyawan.id) : karyawan.id != null) return false;
        if (isActive != null ? !isActive.equals(karyawan.isActive) : karyawan.isActive != null) return false;
        if (jabatan != karyawan.jabatan) return false;
        if (namaKaryawan != null ? !namaKaryawan.equals(karyawan.namaKaryawan) : karyawan.namaKaryawan != null)
            return false;
        if (nomorHp != null ? !nomorHp.equals(karyawan.nomorHp) : karyawan.nomorHp != null) return false;
        if (password != null ? !password.equals(karyawan.password) : karyawan.password != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (namaKaryawan != null ? namaKaryawan.hashCode() : 0);
        result = 31 * result + (nomorHp != null ? nomorHp.hashCode() : 0);
        result = 31 * result + (cabang != null ? cabang.hashCode() : 0);
        result = 31 * result + (password != null ? password.hashCode() : 0);
        result = 31 * result + (isActive != null ? isActive.hashCode() : 0);
        result = 31 * result + (jabatan != null ? jabatan.hashCode() : 0);
        return result;
    }
}
