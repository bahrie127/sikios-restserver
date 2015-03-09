package com.blung.sikios.service.impl;

import com.blung.sikios.domain.Kios;
import com.blung.sikios.domain.PembayaranKios;
import com.blung.sikios.service.KiosService;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: saifulbahri
 * Date: 9/19/13
 * Time: 5:24 AM
 * To change this template use File | Settings | File Templates.
 */
@Service("kiosService")
@Transactional
public class KiosServiceImpl implements KiosService{

    @Autowired
    private SessionFactory sessionFactory;
    @Override
    public void save(Kios kios) {
        sessionFactory.getCurrentSession().saveOrUpdate(kios);
    }

    @Override
    public void delete(Kios kios) {
        if(kios!=null){
            sessionFactory.getCurrentSession().delete(kios);
        }
    }

    @Override
    public void deleteMore(Kios[] kioss) {
        if(kioss!=null){
            for(Kios kios:kioss)
                delete(kios);
        }
    }

    @Override
    public Kios findKios(Long id) {
        return (Kios) sessionFactory.getCurrentSession().get(Kios.class,id);
    }

    @Override
    public List<Kios> findKioss() {
        return sessionFactory.getCurrentSession().createQuery("from Kios o " +
                "order by o.id").list();
    }

    @Override
    public List<Kios> findKioss(Kios kios) {
        Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Kios.class);

        if (kios.getId() != null)
            criteria = criteria.add(Restrictions.eq("id", kios.getId()));

        return criteria.addOrder(Order.asc("id")).list();
    }

    @Override
    public Long countKioss() {
        return (Long) sessionFactory.getCurrentSession().createQuery("select count(o) from Kios o").uniqueResult();
    }

    @Override
    public void save(PembayaranKios pembayaranKios) {
        sessionFactory.getCurrentSession().saveOrUpdate(pembayaranKios);
    }

    @Override
    public void delete(PembayaranKios pembayaranKios) {
        if(pembayaranKios!=null){
            sessionFactory.getCurrentSession().delete(pembayaranKios);
        }
    }

    @Override
    public void deleteMore(PembayaranKios[] pembayaranKioss) {
        if(pembayaranKioss!=null){
            for(PembayaranKios pembayaranKios:pembayaranKioss)
                delete(pembayaranKios);
        }
    }

    @Override
    public PembayaranKios findPembayaranKios(Long id) {
        return (PembayaranKios) sessionFactory.getCurrentSession().get(PembayaranKios.class,id);
    }

    @Override
    public List<PembayaranKios> findPembayaranKioss() {
        return sessionFactory.getCurrentSession().createQuery("from PembayaranKios o " +
                "order by o.id").list();
    }

    @Override
    public List<PembayaranKios> findPembayaranKioss(PembayaranKios pembayaranKios) {
        Criteria criteria = sessionFactory.getCurrentSession().createCriteria(PembayaranKios.class);

        if (pembayaranKios.getId() != null)
            criteria = criteria.add(Restrictions.eq("id", pembayaranKios.getId()));

        return criteria.addOrder(Order.asc("id")).list();
    }

    @Override
    public Long countPembayaranKioss() {
        return (Long) sessionFactory.getCurrentSession().createQuery("select count(o) from PembayaranKios o").uniqueResult();
    }
}
