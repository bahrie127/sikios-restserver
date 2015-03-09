package com.blung.sikios.service.impl;

import com.blung.sikios.domain.Barang;
import com.blung.sikios.domain.Supplier;
import com.blung.sikios.service.BarangService;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.MatchMode;
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
 * Time: 5:12 AM
 * To change this template use File | Settings | File Templates.
 */
@Service("barangService")
@Transactional
public class BarangServiceImpl implements BarangService{

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void save(Barang barang) {
        sessionFactory.getCurrentSession().saveOrUpdate(barang);
    }

    @Override
    public void delete(Barang barang) {
        if(barang!=null){
            sessionFactory.getCurrentSession().delete(barang);
        }
    }

    @Override
    public void deleteMore(Barang[] barangs) {
        if(barangs!=null){
            for(Barang barang:barangs){
                delete(barang);
            }
        }
    }

    @Override
    public Barang findBarang(Long id) {
        return (Barang) sessionFactory.getCurrentSession().get(Barang.class,id);
    }

    @Override
    public List<Barang> findBarangs() {
        return sessionFactory.getCurrentSession().createQuery("from Barang o " +
                "order by o.id").list();
    }

    @Override
    public List<Barang> findBarangs(Barang barang) {
        Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Barang.class);

        if (barang.getId() != null)
            criteria = criteria.add(Restrictions.eq("id", barang.getId()));
        if (barang.getNama() != null && !barang.getNama().isEmpty())
            criteria = criteria.add(Restrictions.like("nama", barang.getNama(), MatchMode.ANYWHERE));

        return criteria.addOrder(Order.asc("nama")).list();
    }

    @Override
    public Long countBarangs() {
        return (Long) sessionFactory.getCurrentSession().createQuery("select count(o) from Barang o").uniqueResult();
    }

    @Override
    public void save(Supplier supplier) {
        sessionFactory.getCurrentSession().saveOrUpdate(supplier);
    }

    @Override
    public void delete(Supplier supplier) {
        if(supplier!=null)
            sessionFactory.getCurrentSession().delete(supplier);
    }

    @Override
    public void deleteMore(Supplier[] suppliers) {
        if(suppliers!=null){
            for(Supplier supplier:suppliers)
                delete(supplier);
        }
    }

    @Override
    public Supplier findSupplier(Long id) {
        return (Supplier) sessionFactory.getCurrentSession().get(Supplier.class,id);
    }

    @Override
    public List<Supplier> findSuppliers() {
        return sessionFactory.getCurrentSession().createQuery("from Supplier o " +
                "order by o.id").list();
    }

    @Override
    public List<Supplier> findSuppliers(Supplier supplier) {
        Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Supplier.class);

        if (supplier.getId() != null)
            criteria = criteria.add(Restrictions.eq("id", supplier.getId()));

        return criteria.addOrder(Order.asc("id")).list();
    }

    @Override
    public Long countSuppliers() {
        return (Long) sessionFactory.getCurrentSession().createQuery("select count(o) from Supplier o").uniqueResult();
    }
}
