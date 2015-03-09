package com.blung.sikios.service;

import com.blung.sikios.domain.Kios;
import com.blung.sikios.domain.PembayaranKios;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: saifulbahri
 * Date: 9/18/13
 * Time: 6:31 AM
 * To change this template use File | Settings | File Templates.
 */
public interface KiosService {
    public void save(Kios kios);

    public void delete(Kios kios);

    public void deleteMore(Kios[] kioss);

    public Kios findKios(Long id);

    public List<Kios> findKioss();

    public List<Kios> findKioss(Kios kios);

    public Long countKioss();
    
    /*****************************************/

    public void save(PembayaranKios pembayaranKios);

    public void delete(PembayaranKios pembayaranKios);

    public void deleteMore(PembayaranKios[] pembayaranKioss);

    public PembayaranKios findPembayaranKios(Long id);

    public List<PembayaranKios> findPembayaranKioss();

    public List<PembayaranKios> findPembayaranKioss(PembayaranKios pembayaranKios);

    public Long countPembayaranKioss();



}
