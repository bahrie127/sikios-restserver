package com.blung.sikios.service.impl;

import com.blung.sikios.domain.Hutang;
import com.blung.sikios.domain.PembayaranHutang;
import com.blung.sikios.service.HutangService;
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
 * Time: 5:26 AM
 * To change this template use File | Settings | File Templates.
 */
@Service("hutangService")
@Transactional
public class HutangServiceImpl implements HutangService {

    @Autowired
    private SessionFactory sessionFactory;
    @Override
    public void save(Hutang hutang) {
        sessionFactory.getCurrentSession().saveOrUpdate(hutang);
    }

    @Override
    public void delete(Hutang hutang) {
        if(hutang!=null){
            sessionFactory.getCurrentSession().delete(hutang);
        }
    }

    @Override
    public void deleteMore(Hutang[] hutangs) {
        if(hutangs!=null){
            for(Hutang hutang:hutangs)
                delete(hutang);
        }
    }

    @Override
    public Hutang findHutang(Long id) {
        return (Hutang) sessionFactory.getCurrentSession().get(Hutang.class,id);
    }

    @Override
    public List<Hutang> findHutangs() {
        return sessionFactory.getCurrentSession().createQuery("from Hutang o " +
                "order by o.id").list();
    }

    @Override
    public List<Hutang> findHutangs(Hutang hutang) {
        Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Hutang.class);

        if (hutang.getId() != null)
            criteria = criteria.add(Restrictions.eq("id", hutang.getId()));

        return criteria.addOrder(Order.asc("id")).list();
    }

    @Override
    public Long countHutangs() {
        return (Long) sessionFactory.getCurrentSession().createQuery("select count(o) from Hutang o").uniqueResult();
    }

    @Override
    public void save(PembayaranHutang pembayaranHutang) {
        sessionFactory.getCurrentSession().saveOrUpdate(pembayaranHutang);
    }

    @Override
    public void delete(PembayaranHutang pembayaranHutang) {
        if(pembayaranHutang!=null){
            sessionFactory.getCurrentSession().delete(pembayaranHutang);
        }
    }

    @Override
    public void deleteMore(PembayaranHutang[] pembayaranHutangs) {
        if(pembayaranHutangs!=null){
            for(PembayaranHutang pembayaranHutang:pembayaranHutangs)
                delete(pembayaranHutang);
        }
    }

    @Override
    public PembayaranHutang findPembayaranHutang(Long id) {
        return (PembayaranHutang) sessionFactory.getCurrentSession().get(PembayaranHutang.class,id);
    }

    @Override
    public List<PembayaranHutang> findPembayaranHutangs() {
        return sessionFactory.getCurrentSession().createQuery("from PembayaranHutang o " +
                "order by o.id").list();
    }

    @Override
    public List<PembayaranHutang> findPembayaranHutangs(PembayaranHutang pembayaranHutang) {
        Criteria criteria = sessionFactory.getCurrentSession().createCriteria(PembayaranHutang.class);

        if (pembayaranHutang.getId() != null)
            criteria = criteria.add(Restrictions.eq("id", pembayaranHutang.getId()));

        return criteria.addOrder(Order.asc("id")).list();
    }

    @Override
    public Long countPembayaranHutangs() {
        return (Long) sessionFactory.getCurrentSession().createQuery("select count(o) from PembayaranHutang o").uniqueResult();
    }
}
