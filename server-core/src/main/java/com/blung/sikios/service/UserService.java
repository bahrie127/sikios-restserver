package com.blung.sikios.service;

import com.blung.sikios.domain.User;
import com.blung.sikios.domain.UserKios;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: saifulbahri
 * Date: 9/18/13
 * Time: 6:44 AM
 * To change this template use File | Settings | File Templates.
 */
public interface UserService {

    public void save(User user);

    public void delete(User user);

    public void deleteMore(User[] users);

    public User findUser(Long id);

    public List<User> findUsers();

    public List<User> findUsers(User user);

    public Long countUsers();
    
    /*****************************************/

    public void save(UserKios userKios);

    public void delete(UserKios userKios);

    public void deleteMore(UserKios[] userKioss);

    public UserKios findUserKios(Long id);

    public List<UserKios> findUserKioss();

    public List<UserKios> findUserKioss(UserKios userKios);

    public Long countUserKioss();


}
