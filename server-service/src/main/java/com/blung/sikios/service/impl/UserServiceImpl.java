package com.blung.sikios.service.impl;

import com.blung.sikios.domain.User;
import com.blung.sikios.domain.UserKios;
import com.blung.sikios.service.UserService;
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
 * Time: 5:30 AM
 * To change this template use File | Settings | File Templates.
 */
@Service("userService")
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private SessionFactory sessionFactory;
    @Override
    public void save(User user) {
        sessionFactory.getCurrentSession().saveOrUpdate(user);
    }

    @Override
    public void delete(User user) {
        if(user!=null){
            sessionFactory.getCurrentSession().delete(user);
        }
    }

    @Override
    public void deleteMore(User[] users) {
        if(users!=null){
            for(User user:users){
                delete(user);
            }
        }
    }

    @Override
    public User findUser(Long id) {
        return (User) sessionFactory.getCurrentSession().get(User.class,id);
    }

    @Override
    public List<User> findUsers() {
        return sessionFactory.getCurrentSession().createQuery("from User o " +
                "order by o.id").list();
    }

    @Override
    public List<User> findUsers(User user) {
        Criteria criteria = sessionFactory.getCurrentSession().createCriteria(User.class);

        if (user.getId() != null)
            criteria = criteria.add(Restrictions.eq("id", user.getId()));

        return criteria.addOrder(Order.asc("id")).list();
    }

    @Override
    public Long countUsers() {
        return (Long) sessionFactory.getCurrentSession().createQuery("select count(o) from User o").uniqueResult();
    }

    @Override
    public void save(UserKios userKios) {
        sessionFactory.getCurrentSession().saveOrUpdate(userKios);
    }

    @Override
    public void delete(UserKios userKios) {
        if(userKios!=null){
            sessionFactory.getCurrentSession().delete(userKios);
        }
    }

    @Override
    public void deleteMore(UserKios[] userKioss) {
        if(userKioss!=null){
            for(UserKios userKios:userKioss){
                delete(userKios);
            }
        }
    }

    @Override
    public UserKios findUserKios(Long id) {
        return (UserKios) sessionFactory.getCurrentSession().get(UserKios.class,id);
    }

    @Override
    public List<UserKios> findUserKioss() {
        return sessionFactory.getCurrentSession().createQuery("from UserKios o " +
                "order by o.id").list();
    }

    @Override
    public List<UserKios> findUserKioss(UserKios userKios) {
        Criteria criteria = sessionFactory.getCurrentSession().createCriteria(UserKios.class);

        if (userKios.getId() != null)
            criteria = criteria.add(Restrictions.eq("id", userKios.getId()));

        return criteria.addOrder(Order.asc("id")).list();
    }

    @Override
    public Long countUserKioss() {
        return (Long) sessionFactory.getCurrentSession().createQuery("select count(o) from UserKios o").uniqueResult();
    }
}
