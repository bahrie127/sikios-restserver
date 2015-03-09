package com.blung.sikios.service.impl;

import com.blung.sikios.domain.DetailPenjualan;
import com.blung.sikios.domain.Penjualan;
import com.blung.sikios.domain.Piutang;
import com.blung.sikios.service.PenjualanService;
import com.blung.sikios.service.PiutangService;
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
@Service("penjualanService")
@Transactional
public class PenjualanServiceImpl implements PenjualanService {

    @Autowired
    private SessionFactory sessionFactory;

    @Autowired
    @Qualifier("piutangService")
    private PiutangService piutangService;

    @Override
    public void save(Penjualan penjualan) {
        List<Piutang> piutangs=new ArrayList<Piutang>();
        List<DetailPenjualan> detailPenjualans=new ArrayList<DetailPenjualan>();
        if(penjualan.getPiutangs()!=null){
            for(Piutang piutang : penjualan.getPiutangs()){
                piutangService.save(piutang);
                piutangs.add(piutang);
            }
            penjualan.setPiutangs(piutangs);
        }
        if(penjualan.getDetailPenjualans()!=null){
            for(DetailPenjualan detailPenjualan:penjualan.getDetailPenjualans()){
                save(detailPenjualan);
                detailPenjualans.add(detailPenjualan);
            }
            penjualan.setDetailPenjualans(detailPenjualans);
        }
        sessionFactory.getCurrentSession().saveOrUpdate(penjualan);
    }

    @Override
    public void delete(Penjualan penjualan) {
        if(penjualan!=null){
            sessionFactory.getCurrentSession().delete(penjualan);
        }
    }

    @Override
    public void deleteMore(Penjualan[] penjualans) {
        if(penjualans!=null){
            for(Penjualan penjualan:penjualans)
                delete(penjualan);
        }
    }

    @Override
    public Penjualan findPenjualan(Long id) {
        return (Penjualan) sessionFactory.getCurrentSession().get(Penjualan.class,id);
    }

    @Override
    public List<Penjualan> findPenjualans() {
        return sessionFactory.getCurrentSession().createQuery("from Penjualan o " +
                "order by o.id").list();
    }

    @Override
    public List<Penjualan> findPenjualans(Penjualan penjualan) {
        Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Penjualan.class);

        if (penjualan.getId() != null)
            criteria = criteria.add(Restrictions.eq("id", penjualan.getId()));

        return criteria.addOrder(Order.asc("id")).list();
    }

    @Override
    public Long countPenjualans() {
        return (Long) sessionFactory.getCurrentSession().createQuery("select count(o) from Penjualan o").uniqueResult();
    }

    @Override
    public void save(DetailPenjualan detailPenjualan) {
        sessionFactory.getCurrentSession().saveOrUpdate(detailPenjualan);
    }

    @Override
    public void delete(DetailPenjualan detailPenjualan) {
        if(detailPenjualan!=null){
            sessionFactory.getCurrentSession().delete(detailPenjualan);
        }
    }

    @Override
    public void deleteMore(DetailPenjualan[] detailPenjualans) {
        if(detailPenjualans!=null){
            for(DetailPenjualan detailPenjualan:detailPenjualans)
                delete(detailPenjualan);
        }
    }

    @Override
    public DetailPenjualan findDetailPenjualan(Long id) {
        return (DetailPenjualan) sessionFactory.getCurrentSession().get(DetailPenjualan.class,id);
    }

    @Override
    public List<DetailPenjualan> findDetailPenjualans() {
        return sessionFactory.getCurrentSession().createQuery("from DetailPenjualan o " +
                "order by o.id").list();
    }

    @Override
    public List<DetailPenjualan> findDetailPenjualans(DetailPenjualan detailPenjualan) {
        Criteria criteria = sessionFactory.getCurrentSession().createCriteria(DetailPenjualan.class);

        if (detailPenjualan.getId() != null)
            criteria = criteria.add(Restrictions.eq("id", detailPenjualan.getId()));

        return criteria.addOrder(Order.asc("id")).list();
    }

    @Override
    public Long countDetailPenjualans() {
        return (Long) sessionFactory.getCurrentSession().createQuery("select count(o) from DetailPenjualan o").uniqueResult();
    }
}
