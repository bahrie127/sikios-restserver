package com.blung.sikios.domain;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.Calendar;

/**
 * Created with IntelliJ IDEA.
 * User: saifulbahri
 * Date: 9/9/13
 * Time: 8:57 PM
 * To change this template use File | Settings | File Templates.
 */

@Entity
@Table(name="kios")
public class Kios {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "kios_id")
    private Long id;

    @Column(nullable = false,length = 30,name = "nama_kios")
    @Size(min = 0,max = 30)
    private String namaKios;

    @Column(nullable = false, length = 50, name = "nama_pemilik")
    @Size(min = 0,max = 50)
    private String namaPemilik;

    @Column(nullable = false,length = 15,name = "nomor_hp")
    @Size(min = 0,max = 15)
    private String nomorHp;

    @Column(nullable = true,length = 50,name = "email")
    private String email;

    @Column(nullable = true,length = 100,name = "alamat_kios")
    private String alamatKios;

    @Column(nullable = false, name = "expired_date")
    @Temporal(value = TemporalType.DATE)
    private Calendar expiredDate;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNamaKios() {
        return namaKios;
    }

    public void setNamaKios(String namaKios) {
        this.namaKios = namaKios;
    }

    public String getNamaPemilik() {
        return namaPemilik;
    }

    public void setNamaPemilik(String namaPemilik) {
        this.namaPemilik = namaPemilik;
    }

    public String getNomorHp() {
        return nomorHp;
    }

    public void setNomorHp(String nomorHp) {
        this.nomorHp = nomorHp;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAlamatKios() {
        return alamatKios;
    }

    public void setAlamatKios(String alamatKios) {
        this.alamatKios = alamatKios;
    }

    public Calendar getExpiredDate() {
        return expiredDate;
    }

    public void setExpiredDate(Calendar expiredDate) {
        this.expiredDate = expiredDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Kios kios = (Kios) o;

        if (alamatKios != null ? !alamatKios.equals(kios.alamatKios) : kios.alamatKios != null) return false;
        if (email != null ? !email.equals(kios.email) : kios.email != null) return false;
        if (expiredDate != null ? !expiredDate.equals(kios.expiredDate) : kios.expiredDate != null) return false;
        if (id != null ? !id.equals(kios.id) : kios.id != null) return false;
        if (namaKios != null ? !namaKios.equals(kios.namaKios) : kios.namaKios != null) return false;
        if (namaPemilik != null ? !namaPemilik.equals(kios.namaPemilik) : kios.namaPemilik != null) return false;
        if (nomorHp != null ? !nomorHp.equals(kios.nomorHp) : kios.nomorHp != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (namaKios != null ? namaKios.hashCode() : 0);
        result = 31 * result + (namaPemilik != null ? namaPemilik.hashCode() : 0);
        result = 31 * result + (nomorHp != null ? nomorHp.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (alamatKios != null ? alamatKios.hashCode() : 0);
        result = 31 * result + (expiredDate != null ? expiredDate.hashCode() : 0);
        return result;
    }
}
