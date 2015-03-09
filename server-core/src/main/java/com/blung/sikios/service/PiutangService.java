package com.blung.sikios.service;

import com.blung.sikios.domain.PembayaranPiutang;
import com.blung.sikios.domain.Piutang;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: saifulbahri
 * Date: 9/18/13
 * Time: 6:41 AM
 * To change this template use File | Settings | File Templates.
 */
public interface PiutangService {
    public void save(Piutang piutang);

    public void delete(Piutang piutang);

    public void deleteMore(Piutang[] piutangs);

    public Piutang findPiutang(Long id);

    public List<Piutang> findPiutangs();

    public List<Piutang> findPiutangs(Piutang piutang);

    public Long countPiutangs();
    
    /*************************************************/

    public void save(PembayaranPiutang pembayaranPiutang);

    public void delete(PembayaranPiutang pembayaranPiutang);

    public void deleteMore(PembayaranPiutang[] pembayaranPiutangs);

    public PembayaranPiutang findPembayaranPiutang(Long id);

    public List<PembayaranPiutang> findPembayaranPiutangs();

    public List<PembayaranPiutang> findPembayaranPiutangs(PembayaranPiutang pembayaranPiutang);

    public Long countPembayaranPiutangs();


}
