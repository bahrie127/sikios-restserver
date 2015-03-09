package com.blung.sikios.service.controller.rest;

import com.blung.sikios.domain.Kios;
import com.blung.sikios.service.KiosService;
import com.blung.sikios.service.editor.KiosEditor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.*;

/**
 * Created with IntelliJ IDEA.
 * User: saifulbahri
 * Date: 9/21/13
 * Time: 4:41 PM
 * To change this template use File | Settings | File Templates.
 */
@Controller
@RequestMapping("/kios")
public class KiosRestController {

    @Autowired
    @Qualifier("kiosService")
    private KiosService kiosService;

    /*
     * *** Service Method *******************************************************************************************
     */

    @RequestMapping(value = "/count", method = RequestMethod.GET, headers = "Accept=application/json")
    public
    @ResponseBody
    long count() {
        try {
            return kiosService.countKioss();
        } catch (DataAccessException e) {
            return 0L;
        }
    }

    @RequestMapping(method = RequestMethod.GET, headers = "Accept=application/json")
    public
    @ResponseBody
    List<Kios> findAll() {
        try {
            return kiosService.findKioss();
        } catch (DataAccessException e) {
            return new ArrayList<Kios>();
        }
    }

    @RequestMapping(method = RequestMethod.GET, params = "id", headers = "Accept=application/json")
    public
    @ResponseBody
    Kios findById(@RequestParam("id") Kios kios) {
        return kios;
    }

    @RequestMapping(value = "/search", method = RequestMethod.POST, headers = "Accept=application/json")
    public
    @ResponseBody
    List<Kios> find(@RequestBody Kios kios) {
        try {
            return kiosService.findKioss(kios);
        } catch (DataAccessException e) {
            return new ArrayList<Kios>();
        }
    }

    @RequestMapping(method = RequestMethod.POST, headers = "Accept=application/json")
    public
    @ResponseBody
    Map<Object, Object> save(@RequestBody Kios kios) {
        if (kios == null) throw new IllegalArgumentException("A Kios is required");
        Map<Object, Object> result = new HashMap<Object, Object>();
        try {
            kiosService.save(kios);
            result.put("success", true);
            result.put("data", kios);
            result.put("message", "Sukses Save Kios " + kios);
            result.put("status", "oke");
        } catch (DataAccessException e) {
            result.put("success", false);
            result.put("data", kios);
            result.put("exception", e.getMessage());
            result.put("message", "Gagal Save Kios " + kios);
        }

        return result;
    }

    @RequestMapping(method = RequestMethod.DELETE, headers = "Accept=application/json")
    public
    @ResponseBody
    Map<String, Object> delete(@RequestParam("id") Kios kios) {
        Map<String, Object> result = new HashMap<String, Object>();
        try {
            kiosService.delete(kios);
            result.put("success", true);
            result.put("message", "Sukses Delete Kios " + kios);
        } catch (DataAccessException e) {
            result.put("success", false);
            result.put("exception", e.getMessage());
            result.put("message", "Gagal Delete Kios " + kios);
        }
        return result;
    }

    @RequestMapping(value = "/delete", method = RequestMethod.POST, headers = "Accept=application/json")
    public
    @ResponseBody
    Map<String, Object> deleteMore(@RequestBody Kios[] countries) {
        Map<String, Object> result = new HashMap<String, Object>();
        try {
            kiosService.deleteMore(countries);
            result.put("success", true);
            result.put("message", "Sukses Delete Kios " + countries);
        } catch (DataAccessException e) {
            result.put("success", false);
            result.put("exception", e.getMessage());
            result.put("message", "Gagal Delete Kios " + countries);
        }
        return result;
    }

    @RequestMapping(method = RequestMethod.PUT, headers = "Accept=application/json")
    public
    @ResponseBody
    Map<String, Object> update(@RequestBody Kios kios) {
        if (kios == null) throw new IllegalArgumentException("A Product is required");
        Map<String, Object> result = new HashMap<String, Object>();
        try {
            kiosService.save(kios);
            result.put("success", true);
            result.put("data", kios);
            result.put("message", "Sukses Update Kios " + kios);
        } catch (DataAccessException e) {
            result.put("success", false);
            result.put("data", kios);
            result.put("exception", e.getMessage());
            result.put("message", "Gagal update kios " + kios);
        }
        return result;
    }

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        binder.registerCustomEditor(Kios.class, new KiosEditor(kiosService));
    }
}
