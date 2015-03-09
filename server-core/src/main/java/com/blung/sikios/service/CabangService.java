package com.blung.sikios.service;

import com.blung.sikios.domain.Cabang;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: saifulbahri
 * Date: 9/18/13
 * Time: 6:31 AM
 * To change this template use File | Settings | File Templates.
 */
public interface CabangService {
    public void save(Cabang cabang);

    public void delete(Cabang cabang);

    public void deleteMore(Cabang[] cabangs);

    public Cabang findCabang(Long id);

    public List<Cabang> findCabangs();

    public List<Cabang> findCabangs(Cabang cabang);

    public Long countCabangs();

}
