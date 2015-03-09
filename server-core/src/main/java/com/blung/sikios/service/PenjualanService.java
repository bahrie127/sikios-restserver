package com.blung.sikios.service;

import com.blung.sikios.domain.DetailPenjualan;
import com.blung.sikios.domain.Penjualan;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: saifulbahri
 * Date: 9/18/13
 * Time: 6:36 AM
 * To change this template use File | Settings | File Templates.
 */
public interface PenjualanService {
    public void save(Penjualan penjualan);

    public void delete(Penjualan penjualan);

    public void deleteMore(Penjualan[] penjualans);

    public Penjualan findPenjualan(Long id);

    public List<Penjualan> findPenjualans();

    public List<Penjualan> findPenjualans(Penjualan penjualan);

    public Long countPenjualans();

    /************************************************/

    public void save(DetailPenjualan detailPenjualan);

    public void delete(DetailPenjualan detailPenjualan);

    public void deleteMore(DetailPenjualan[] detailPenjualans);

    public DetailPenjualan findDetailPenjualan(Long id);

    public List<DetailPenjualan> findDetailPenjualans();

    public List<DetailPenjualan> findDetailPenjualans(DetailPenjualan detailPenjualan);

    public Long countDetailPenjualans();


}
