package com.blung.sikios.domain;

import javax.persistence.*;
import java.util.Calendar;

/**
 * Created with IntelliJ IDEA.
 * User: saifulbahri
 * Date: 9/17/13
 * Time: 9:41 PM
 * To change this template use File | Settings | File Templates.
 */
@Entity
@Table(name = "hutang")
public class Hutang {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "hutang_id")
    private Long id;

    @ManyToOne
    @JoinColumn(nullable = false, name = "supplier_id")
    private Supplier supplier;

    @Column(nullable = false,name = "sisa")
    private Integer sisa;

    @Column(nullable = false, name = "jatuh_tempo")
    @Temporal(value = TemporalType.DATE)
    private Calendar jatuhTempo;

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

    public Integer getSisa() {
        return sisa;
    }

    public void setSisa(Integer sisa) {
        this.sisa = sisa;
    }

    public Calendar getJatuhTempo() {
        return jatuhTempo;
    }

    public void setJatuhTempo(Calendar jatuhTempo) {
        this.jatuhTempo = jatuhTempo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Hutang hutang = (Hutang) o;

        if (id != null ? !id.equals(hutang.id) : hutang.id != null) return false;
        if (jatuhTempo != null ? !jatuhTempo.equals(hutang.jatuhTempo) : hutang.jatuhTempo != null) return false;

        if (sisa != null ? !sisa.equals(hutang.sisa) : hutang.sisa != null) return false;
        if (supplier != null ? !supplier.equals(hutang.supplier) : hutang.supplier != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (supplier != null ? supplier.hashCode() : 0);

        result = 31 * result + (sisa != null ? sisa.hashCode() : 0);
        result = 31 * result + (jatuhTempo != null ? jatuhTempo.hashCode() : 0);
        return result;
    }
}
