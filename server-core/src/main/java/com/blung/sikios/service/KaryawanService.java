package com.blung.sikios.service;

import com.blung.sikios.domain.Karyawan;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: saifulbahri
 * Date: 9/18/13
 * Time: 6:32 AM
 * To change this template use File | Settings | File Templates.
 */
public interface KaryawanService {
    public void save(Karyawan karyawan);

    public void delete(Karyawan karyawan);

    public void deleteMore(Karyawan[] karyawans);

    public Karyawan findKaryawan(Long id);

    public List<Karyawan> findKaryawans();

    public List<Karyawan> findKaryawans(Karyawan karyawan);

    public Long countKaryawans();

}
