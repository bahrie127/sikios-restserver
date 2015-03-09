package com.blung.sikios.service.impl;

import com.blung.sikios.domain.Cabang;
import com.blung.sikios.service.CabangService;
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
 * Time: 5:25 AM
 * To change this template use File | Settings | File Templates.
 */
@Service("cabangService")
@Transactional
public class CabangServiceImpl implements CabangService {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void save(Cabang cabang) {
        sessionFactory.getCurrentSession().saveOrUpdate(cabang);
    }

    @Override
    public void delete(Cabang cabang) {
        if(cabang!=null){
            sessionFactory.getCurrentSession().delete(cabang);
        }
    }

    @Override
    public void deleteMore(Cabang[] cabangs) {
        if(cabangs!=null){
            for(Cabang cabang:cabangs)
                delete(cabang);
        }
    }

    @Override
    public Cabang findCabang(Long id) {
        return (Cabang) sessionFactory.getCurrentSession().get(Cabang.class,id);
    }

    @Override
    public List<Cabang> findCabangs() {
        return sessionFactory.getCurrentSession().createQuery("from Cabang o " +
                "order by o.id").list();
    }

    @Override
    public List<Cabang> findCabangs(Cabang cabang) {
        Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Cabang.class);

        if (cabang.getId() != null)
            criteria = criteria.add(Restrictions.eq("id", cabang.getId()));

        return criteria.addOrder(Order.asc("id")).list();
    }

    @Override
    public Long countCabangs() {
        return (Long) sessionFactory.getCurrentSession().createQuery("select count(o) from Cabang o").uniqueResult();
    }
}
