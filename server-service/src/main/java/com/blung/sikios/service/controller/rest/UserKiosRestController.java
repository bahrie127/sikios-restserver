package com.blung.sikios.service.controller.rest;

import com.blung.sikios.domain.UserKios;
import com.blung.sikios.service.UserService;
import com.blung.sikios.service.editor.UserKiosEditor;
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
@RequestMapping("/userKios")
public class UserKiosRestController {

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
            return userService.countUserKioss();
        } catch (DataAccessException e) {
            return 0L;
        }
    }

    @RequestMapping(method = RequestMethod.GET, headers = "Accept=application/json")
    public
    @ResponseBody
    List<UserKios> findAll() {
        try {
            return userService.findUserKioss();
        } catch (DataAccessException e) {
            return new ArrayList<UserKios>();
        }
    }

    @RequestMapping(method = RequestMethod.GET, params = "id", headers = "Accept=application/json")
    public
    @ResponseBody
    UserKios findById(@RequestParam("id") UserKios userKios) {
        return userKios;
    }

    @RequestMapping(value = "/search", method = RequestMethod.POST, headers = "Accept=application/json")
    public
    @ResponseBody
    List<UserKios> find(@RequestBody UserKios userKios) {
        try {
            return userService.findUserKioss(userKios);
        } catch (DataAccessException e) {
            return new ArrayList<UserKios>();
        }
    }

    @RequestMapping(method = RequestMethod.POST, headers = "Accept=application/json")
    public
    @ResponseBody
    Map<Object, Object> save(@RequestBody UserKios userKios) {
        if (userKios == null) throw new IllegalArgumentException("A User is required");
        Map<Object, Object> result = new HashMap<Object, Object>();
        try {
            userService.save(userKios);
            result.put("success", true);
            result.put("data", userKios);
            result.put("message", "Sukses Save UserKios " + userKios);
            result.put("status", "oke");
        } catch (DataAccessException e) {
            result.put("success", false);
            result.put("data", userKios);
            result.put("exception", e.getMessage());
            result.put("message", "Gagal Save UserKios " + userKios);
        }

        return result;
    }

    @RequestMapping(method = RequestMethod.DELETE, headers = "Accept=application/json")
    public
    @ResponseBody
    Map<String, Object> delete(@RequestParam("id") UserKios userKios) {
        Map<String, Object> result = new HashMap<String, Object>();
        try {
            userService.delete(userKios);
            result.put("success", true);
            result.put("message", "Sukses Delete UserKios " + userKios);
        } catch (DataAccessException e) {
            result.put("success", false);
            result.put("exception", e.getMessage());
            result.put("message", "Gagal Delete UserKios " + userKios);
        }
        return result;
    }

    @RequestMapping(value = "/delete", method = RequestMethod.POST, headers = "Accept=application/json")
    public
    @ResponseBody
    Map<String, Object> deleteMore(@RequestBody UserKios[] userKioss) {
        Map<String, Object> result = new HashMap<String, Object>();
        try {
            userService.deleteMore(userKioss);
            result.put("success", true);
            result.put("message", "Sukses Delete UserKios " + userKioss);
        } catch (DataAccessException e) {
            result.put("success", false);
            result.put("exception", e.getMessage());
            result.put("message", "Gagal Delete UserKios " + userKioss);
        }
        return result;
    }

    @RequestMapping(method = RequestMethod.PUT, headers = "Accept=application/json")
    public
    @ResponseBody
    Map<String, Object> update(@RequestBody UserKios userKios) {
        if (userKios == null) throw new IllegalArgumentException("A Product is required");
        Map<String, Object> result = new HashMap<String, Object>();
        try {
            userService.save(userKios);
            result.put("success", true);
            result.put("data", userKios);
            result.put("message", "Sukses Update UserKios " + userKios);
        } catch (DataAccessException e) {
            result.put("success", false);
            result.put("data", userKios);
            result.put("exception", e.getMessage());
            result.put("message", "Gagal update userkios " + userKios);
        }
        return result;
    }

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        binder.registerCustomEditor(UserKios.class, new UserKiosEditor(userService));
    }
}
