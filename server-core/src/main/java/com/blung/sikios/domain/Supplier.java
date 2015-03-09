package com.blung.sikios.domain;

import javax.persistence.*;
import javax.validation.constraints.Size;

/**
 * Created with IntelliJ IDEA.
 * User: saifulbahri
 * Date: 9/17/13
 * Time: 9:04 PM
 * To change this template use File | Settings | File Templates.
 */
@Entity
@Table(name = "supplier")
public class Supplier {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "supplier_id")
    private Long id;

    @ManyToOne
    @JoinColumn(nullable = false, name = "kios_id")
    private Kios kios;

    @Column(nullable =false,length = 40,name = "nama")
    @Size(min = 0,max = 40)
    private String nama;

    @Column(nullable =false,length = 200,name = "alamat")
    @Size(min = 0,max = 200)
    private String alamat;

    @Column(nullable =false,length = 15,name = "telp")
    @Size(min = 0,max = 15)
    private String telp;

    @Column(nullable =false,length = 40,name = "contact")
    @Size(min = 0,max = 40)
    private String contact;

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

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public String getTelp() {
        return telp;
    }

    public void setTelp(String telp) {
        this.telp = telp;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Supplier supplier = (Supplier) o;

        if (alamat != null ? !alamat.equals(supplier.alamat) : supplier.alamat != null) return false;
        if (contact != null ? !contact.equals(supplier.contact) : supplier.contact != null) return false;
        if (id != null ? !id.equals(supplier.id) : supplier.id != null) return false;
        if (kios != null ? !kios.equals(supplier.kios) : supplier.kios != null) return false;
        if (nama != null ? !nama.equals(supplier.nama) : supplier.nama != null) return false;
        if (telp != null ? !telp.equals(supplier.telp) : supplier.telp != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (kios != null ? kios.hashCode() : 0);
        result = 31 * result + (nama != null ? nama.hashCode() : 0);
        result = 31 * result + (alamat != null ? alamat.hashCode() : 0);
        result = 31 * result + (telp != null ? telp.hashCode() : 0);
        result = 31 * result + (contact != null ? contact.hashCode() : 0);
        return result;
    }
}
