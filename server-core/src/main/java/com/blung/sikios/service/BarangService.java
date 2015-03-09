package com.blung.sikios.service;

import com.blung.sikios.domain.Barang;
import com.blung.sikios.domain.Supplier;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: saifulbahri
 * Date: 9/18/13
 * Time: 6:38 AM
 * To change this template use File | Settings | File Templates.
 */
public interface BarangService {
    public void save(Barang barang);

    public void delete(Barang barang);

    public void deleteMore(Barang[] barangs);

    public Barang findBarang(Long id);

    public List<Barang> findBarangs();

    public List<Barang> findBarangs(Barang barang);

    public Long countBarangs();
    
    /***********************************/

    public void save(Supplier supplier);

    public void delete(Supplier supplier);

    public void deleteMore(Supplier[] suppliers);

    public Supplier findSupplier(Long id);

    public List<Supplier> findSuppliers();

    public List<Supplier> findSuppliers(Supplier supplier);

    public Long countSuppliers();


}
