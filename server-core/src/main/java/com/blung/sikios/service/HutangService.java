package com.blung.sikios.service;

import com.blung.sikios.domain.Hutang;
import com.blung.sikios.domain.PembayaranHutang;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: saifulbahri
 * Date: 9/18/13
 * Time: 6:39 AM
 * To change this template use File | Settings | File Templates.
 */
public interface HutangService {
    public void save(Hutang hutang);

    public void delete(Hutang hutang);

    public void deleteMore(Hutang[] hutangs);

    public Hutang findHutang(Long id);

    public List<Hutang> findHutangs();

    public List<Hutang> findHutangs(Hutang hutang);

    public Long countHutangs();
    
    /***************************************/

    public void save(PembayaranHutang pembayaranHutang);

    public void delete(PembayaranHutang pembayaranHutang);

    public void deleteMore(PembayaranHutang[] pembayaranHutangs);

    public PembayaranHutang findPembayaranHutang(Long id);

    public List<PembayaranHutang> findPembayaranHutangs();

    public List<PembayaranHutang> findPembayaranHutangs(PembayaranHutang pembayaranHutang);

    public Long countPembayaranHutangs();
    

}
