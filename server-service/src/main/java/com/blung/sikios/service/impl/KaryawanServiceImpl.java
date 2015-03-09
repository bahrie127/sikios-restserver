package com.blung.sikios.service.impl;

import com.blung.sikios.domain.Karyawan;
import com.blung.sikios.service.KaryawanService;
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
 * Time: 5:27 AM
 * To change this template use File | Settings | File Templates.
 */
@Service("karyawanService")
@Transactional
public class KaryawanServiceImpl implements KaryawanService {

    @Autowired
    private SessionFactory sessionFactory;
    @Override
    public void save(Karyawan karyawan) {
        sessionFactory.getCurrentSession().saveOrUpdate(karyawan);
    }

    @Override
    public void delete(Karyawan karyawan) {
        if(karyawan!=null){
            sessionFactory.getCurrentSession().delete(karyawan);
        }
    }

    @Override
    public void deleteMore(Karyawan[] karyawans) {
        if(karyawans!=null){
            for(Karyawan karyawan:karyawans)
                delete(karyawan);
        }
    }

    @Override
    public Karyawan findKaryawan(Long id) {
        return (Karyawan) sessionFactory.getCurrentSession().get(Karyawan.class,id);
    }

    @Override
    public List<Karyawan> findKaryawans() {
        return sessionFactory.getCurrentSession().createQuery("from Karyawan o " +
                "order by o.id").list();
    }

    @Override
    public List<Karyawan> findKaryawans(Karyawan karyawan) {
        Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Karyawan.class);

        if (karyawan.getId() != null)
            criteria = criteria.add(Restrictions.eq("id", karyawan.getId()));

        return criteria.addOrder(Order.asc("id")).list();
    }

    @Override
    public Long countKaryawans() {
        return (Long) sessionFactory.getCurrentSession().createQuery("select count(o) from Karyawan o").uniqueResult();
    }
}
