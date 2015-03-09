package com.blung.sikios.service.controller.rest;

import com.blung.sikios.domain.User;
import com.blung.sikios.service.UserService;
import com.blung.sikios.service.editor.UserEditor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: saifulbahri
 * Date: 9/21/13
 * Time: 4:41 PM
 * To change this template use File | Settings | File Templates.
 */
@Controller
@RequestMapping("/user")
public class UserRestController {

    @Autowired
    @Qualifier("userService")
    private UserService userService;

    /*
     * *** Service Method *******************************************************************************************
     */

    @RequestMapping(value = "/count", method = RequestMethod.GET, headers = "Accept=application/json")
    public
    @ResponseBody
    long count() {
        try {
            return userService.countUsers();
        } catch (DataAccessException e) {
            return 0L;
        }
    }

    @RequestMapping(method = RequestMethod.GET, headers = "Accept=application/json")
    public
    @ResponseBody
    List<User> findAll() {
        try {
            return userService.findUsers();
        } catch (DataAccessException e) {
            return new ArrayList<User>();
        }
    }

    @RequestMapping(method = RequestMethod.GET, params = "id", headers = "Accept=application/json")
    public
    @ResponseBody
    User findById(@RequestParam("id") User user) {
        return user;
    }

    @RequestMapping(value = "/search", method = RequestMethod.POST, headers = "Accept=application/json")
    public
    @ResponseBody
    List<User> find(@RequestBody User user) {
        try {
            return userService.findUsers(user);
        } catch (DataAccessException e) {
            return new ArrayList<User>();
        }
    }

    @RequestMapping(method = RequestMethod.POST, headers = "Accept=application/json")
    public
    @ResponseBody
    Map<Object, Object> save(@RequestBody User user) {
        if (user == null) throw new IllegalArgumentException("A User is required");
        Map<Object, Object> result = new HashMap<Object, Object>();
        try {
            userService.save(user);
            result.put("success", true);
            result.put("data", user);
            result.put("message", "Sukses Save User " + user);
            result.put("status", "oke");
        } catch (DataAccessException e) {
            result.put("success", false);
            result.put("data", user);
            result.put("exception", e.getMessage());
            result.put("message", "Gagal Save User " + user);
        }

        return result;
    }

    @RequestMapping(method = RequestMethod.DELETE, headers = "Accept=application/json")
    public
    @ResponseBody
    Map<String, Object> delete(@RequestParam("id") User user) {
        Map<String, Object> result = new HashMap<String, Object>();
        try {
            userService.delete(user);
            result.put("success", true);
            result.put("message", "Sukses Delete User " + user);
        } catch (DataAccessException e) {
            result.put("success", false);
            result.put("exception", e.getMessage());
            result.put("message", "Gagal Delete User " + user);
        }
        return result;
    }

    @RequestMapping(value = "/delete", method = RequestMethod.POST, headers = "Accept=application/json")
    public
    @ResponseBody
    Map<String, Object> deleteMore(@RequestBody User[] users) {
        Map<String, Object> result = new HashMap<String, Object>();
        try {
            userService.deleteMore(users);
            result.put("success", true);
            result.put("message", "Sukses Delete User " + users);
        } catch (DataAccessException e) {
            result.put("success", false);
            result.put("exception", e.getMessage());
            result.put("message", "Gagal Delete User " + users);
        }
        return result;
    }

    @RequestMapping(method = RequestMethod.PUT, headers = "Accept=application/json")
    public
    @ResponseBody
    Map<String, Object> update(@RequestBody User user) {
        if (user == null) throw new IllegalArgumentException("A Product is required");
        Map<String, Object> result = new HashMap<String, Object>();
        try {
            userService.save(user);
            result.put("success", true);
            result.put("data", user);
            result.put("message", "Sukses Update User " + user);
        } catch (DataAccessException e) {
            result.put("success", false);
            result.put("data", user);
            result.put("exception", e.getMessage());
            result.put("message", "Gagal update kios " + user);
        }
        return result;
    }

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        binder.registerCustomEditor(User.class, new UserEditor(userService));
    }
}
