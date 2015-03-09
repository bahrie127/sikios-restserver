package com.blung.sikios.service.impl;

import com.blung.sikios.domain.DetailPembelian;
import com.blung.sikios.domain.Hutang;
import com.blung.sikios.domain.Pembelian;
import com.blung.sikios.service.HutangService;
import com.blung.sikios.service.PembelianService;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: saifulbahri
 * Date: 9/19/13
 * Time: 5:28 AM
 * To change this template use File | Settings | File Templates.
 */
@Service("pembelianService")
@Transactional
public class PembelianServiceImpl implements PembelianService {

    @Autowired
    private SessionFactory sessionFactory;


    @Autowired
    @Qualifier("hutangService")
    private HutangService hutangService;

    @Override
    public void save(Pembelian pembelian) {
        List<Hutang> hutangs=new ArrayList<Hutang>();
        List<DetailPembelian> detailPembelians=new ArrayList<DetailPembelian>();
        if(pembelian.getHutangs()!=null){
            for(Hutang hutang : pembelian.getHutangs()){
                hutangService.save(hutang);
                hutangs.add(hutang);
            }
            pembelian.setHutangs(hutangs);
        }
        if(pembelian.getDetailPembelians()!=null){
            for(DetailPembelian detailPembelian:pembelian.getDetailPembelians()){
                save(detailPembelian);
                detailPembelians.add(detailPembelian);
            }
            pembelian.setDetailPembelians(detailPembelians);
        }
        sessionFactory.getCurrentSession().saveOrUpdate(pembelian);
    }

    @Override
    public void delete(Pembelian pembelian) {
        if(pembelian!=null){
            sessionFactory.getCurrentSession().delete(pembelian);
        }
    }

    @Override
    public void deleteMore(Pembelian[] pembelians) {
        if(pembelians!=null){
            for(Pembelian pembelian:pembelians)
                delete(pembelian);
        }
    }

    @Override
    public Pembelian findPembelian(Long id) {
        return (Pembelian) sessionFactory.getCurrentSession().get(Pembelian.class,id);
    }

    @Override
    public List<Pembelian> findPembelians() {
        return sessionFactory.getCurrentSession().createQuery("from Pembelian o " +
                "order by o.id").list();
    }

    @Override
    public List<Pembelian> findPembelians(Pembelian pembelian) {
        Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Pembelian.class);

        if (pembelian.getId() != null)
            criteria = criteria.add(Restrictions.eq("id", pembelian.getId()));

        return criteria.addOrder(Order.asc("id")).list();
    }


    @Override
    public Long countPembelians() {
        return (Long) sessionFactory.getCurrentSession().createQuery("select count(o) from Pembelian o").uniqueResult();
    }

    @Override
    public void save(DetailPembelian detailPembelian) {
        sessionFactory.getCurrentSession().saveOrUpdate(detailPembelian);
    }

    @Override
    public void delete(DetailPembelian detailPembelian) {
        if(detailPembelian!=null){
            sessionFactory.getCurrentSession().delete(detailPembelian);
        }
    }

    @Override
    public void deleteMore(DetailPembelian[] detailPembelians) {
        if(detailPembelians!=null){
            for(DetailPembelian detailPembelian:detailPembelians)
                delete(detailPembelian);
        }
    }

    @Override
    public DetailPembelian findDetailPembelian(Long id) {
        return (DetailPembelian) sessionFactory.getCurrentSession().get(DetailPembelian.class,id);
    }

    @Override
    public List<DetailPembelian> findDetailPembelians() {
        return sessionFactory.getCurrentSession().createQuery("from DetailPembelian o " +
                "order by o.id").list();
    }

    @Override
    public List<DetailPembelian> findDetailPembelians(DetailPembelian detailPembelian) {
        Criteria criteria = sessionFactory.getCurrentSession().createCriteria(DetailPembelian.class);

        if (detailPembelian.getId() != null)
            criteria = criteria.add(Restrictions.eq("id", detailPembelian.getId()));

        return criteria.addOrder(Order.asc("id")).list();
    }

    @Override
    public Long countDetailPembelians() {
        return (Long) sessionFactory.getCurrentSession().createQuery("select count(o) from DetailPenjualan o").uniqueResult();
    }
}

