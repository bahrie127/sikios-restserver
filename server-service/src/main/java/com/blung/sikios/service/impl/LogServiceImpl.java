package com.blung.sikios.service.impl;

import com.blung.sikios.domain.LogKios;
import com.blung.sikios.domain.LogSystem;
import com.blung.sikios.service.LogService;
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
@Service("logService")
@Transactional
public class LogServiceImpl implements LogService {

    @Autowired
    private SessionFactory sessionFactory;
    @Override
    public void save(LogSystem logSystem) {
        sessionFactory.getCurrentSession().saveOrUpdate(logSystem);
    }

    @Override
    public void delete(LogSystem logSystem) {
        if(logSystem!=null){
            sessionFactory.getCurrentSession().delete(logSystem);
        }
    }

    @Override
    public void deleteMore(LogSystem[] logSystems) {
        if(logSystems!=null){
            for(LogSystem logSystem:logSystems)
                delete(logSystem);
        }
    }

    @Override
    public LogSystem findLogSystem(Long id) {
        return (LogSystem) sessionFactory.getCurrentSession().get(LogSystem.class,id);
    }

    @Override
    public List<LogSystem> findLogSystems() {
        return sessionFactory.getCurrentSession().createQuery("from LogSystem o " +
                "order by o.id").list();
    }

    @Override
    public List<LogSystem> findLogSystems(LogSystem logSystem) {
        Criteria criteria = sessionFactory.getCurrentSession().createCriteria(LogSystem.class);

        if (logSystem.getId() != null)
            criteria = criteria.add(Restrictions.eq("id", logSystem.getId()));

        return criteria.addOrder(Order.asc("id")).list();
    }

    @Override
    public Long countLogSystems() {
        return (Long) sessionFactory.getCurrentSession().createQuery("select count(o) from LogSystem o").uniqueResult();
    }

    @Override
    public void save(LogKios logKios) {
        sessionFactory.getCurrentSession().saveOrUpdate(logKios);
    }

    @Override
    public void delete(LogKios logKios) {
        if(logKios!=null){
            sessionFactory.getCurrentSession().delete(logKios);
        }
    }

    @Override
    public void deleteMore(LogKios[] logKioss) {
        if(logKioss!=null){
            for(LogKios logKios:logKioss)
                delete(logKios);
        }
    }

    @Override
    public LogKios findLogKios(Long id) {
        return (LogKios) sessionFactory.getCurrentSession().get(LogKios.class,id);
    }

    @Override
    public List<LogKios> findLogKioss() {
        return sessionFactory.getCurrentSession().createQuery("from LogKios o " +
                "order by o.id").list();
    }

    @Override
    public List<LogKios> findLogKioss(LogKios logKios) {
        Criteria criteria = sessionFactory.getCurrentSession().createCriteria(LogKios.class);

        if (logKios.getId() != null)
            criteria = criteria.add(Restrictions.eq("id", logKios.getId()));

        return criteria.addOrder(Order.asc("id")).list();
    }

    @Override
    public Long countLogKioss() {
        return (Long) sessionFactory.getCurrentSession().createQuery("select count(o) from LogKios o").uniqueResult();
    }
}
