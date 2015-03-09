package com.blung.sikios.service;

import com.blung.sikios.domain.DetailPembelian;
import com.blung.sikios.domain.Pembelian;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: saifulbahri
 * Date: 9/18/13
 * Time: 6:35 AM
 * To change this template use File | Settings | File Templates.
 */
public interface PembelianService {

    public void save(Pembelian pembelian);

    public void delete(Pembelian pembelian);

    public void deleteMore(Pembelian[] pembelians);

    public Pembelian findPembelian(Long id);

    public List<Pembelian> findPembelians();

    public List<Pembelian> findPembelians(Pembelian pembelian);

    public Long countPembelians();

    /***********************************/

    public void save(DetailPembelian detailPembelian);

    public void delete(DetailPembelian detailPembelian);

    public void deleteMore(DetailPembelian[] detailPembelians);

    public DetailPembelian findDetailPembelian(Long id);

    public List<DetailPembelian> findDetailPembelians();

    public List<DetailPembelian> findDetailPembelians(DetailPembelian detailPembelian);

    public Long countDetailPembelians();


}
