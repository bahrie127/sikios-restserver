package com.blung.sikios.service.impl;

import com.blung.sikios.domain.PembayaranPiutang;
import com.blung.sikios.domain.Piutang;
import com.blung.sikios.service.PiutangService;
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
 * Time: 5:29 AM
 * To change this template use File | Settings | File Templates.
 */
@Service("piutangService")
@Transactional
public class PiutangServiceImpl implements PiutangService {

    @Autowired
    private SessionFactory sessionFactory;
    @Override
    public void save(Piutang piutang) {
        sessionFactory.getCurrentSession().saveOrUpdate(piutang);
    }

    @Override
    public void delete(Piutang piutang) {
        if(piutang!=null){
            sessionFactory.getCurrentSession().delete(piutang);
        }
    }

    @Override
    public void deleteMore(Piutang[] piutangs) {
        if(piutangs!=null){
            for(Piutang piutang:piutangs)
                delete(piutang);
        }
    }

    @Override
    public Piutang findPiutang(Long id) {
        return (Piutang) sessionFactory.getCurrentSession().get(Piutang.class,id);
    }

    @Override
    public List<Piutang> findPiutangs() {
        return sessionFactory.getCurrentSession().createQuery("from Piutang o " +
                "order by o.id").list();
    }

    @Override
    public List<Piutang> findPiutangs(Piutang piutang) {
        Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Piutang.class);

        if (piutang.getId() != null)
            criteria = criteria.add(Restrictions.eq("id", piutang.getId()));

        return criteria.addOrder(Order.asc("id")).list();
    }

    @Override
    public Long countPiutangs() {
        return (Long) sessionFactory.getCurrentSession().createQuery("select count(o) from Piutang o").uniqueResult();
    }

    @Override
    public void save(PembayaranPiutang pembayaranPiutang) {
        sessionFactory.getCurrentSession().saveOrUpdate(pembayaranPiutang);
    }

    @Override
    public void delete(PembayaranPiutang pembayaranPiutang) {
        if(pembayaranPiutang!=null){
            sessionFactory.getCurrentSession().delete(pembayaranPiutang);
        }
    }

    @Override
    public void deleteMore(PembayaranPiutang[] pembayaranPiutangs) {
        if(pembayaranPiutangs!=null){
                           for(PembayaranPiutang pembayaranPiutang:pembayaranPiutangs)
                               delete(pembayaranPiutang);
        }
    }

    @Override
    public PembayaranPiutang findPembayaranPiutang(Long id) {
        return (PembayaranPiutang) sessionFactory.getCurrentSession().get(PembayaranPiutang.class,id);
    }

    @Override
    public List<PembayaranPiutang> findPembayaranPiutangs() {
        return sessionFactory.getCurrentSession().createQuery("from PembayaranPiutang o " +
                "order by o.id").list();
    }

    @Override
    public List<PembayaranPiutang> findPembayaranPiutangs(PembayaranPiutang pembayaranPiutang) {
        Criteria criteria = sessionFactory.getCurrentSession().createCriteria(PembayaranPiutang.class);

        if (pembayaranPiutang.getId() != null)
            criteria = criteria.add(Restrictions.eq("id", pembayaranPiutang.getId()));

        return criteria.addOrder(Order.asc("id")).list();
    }

    @Override
    public Long countPembayaranPiutangs() {
        return (Long) sessionFactory.getCurrentSession().createQuery("select count(o) from PembayaranPiutang o").uniqueResult();
    }
}
