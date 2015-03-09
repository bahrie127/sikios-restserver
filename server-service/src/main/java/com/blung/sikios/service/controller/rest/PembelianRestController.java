package com.blung.sikios.service.controller.rest;

import com.blung.sikios.domain.DetailPembelian;
import com.blung.sikios.domain.Pembelian;
import com.blung.sikios.service.PembelianService;
import com.blung.sikios.service.editor.PembelianEditor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.xml.soap.Detail;
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
@RequestMapping("/pembelian")
public class PembelianRestController {

    @Autowired
    @Qualifier("pembelianService")
    private PembelianService pembelianService;


    /*
     * *** Service Method *******************************************************************************************
     */

    @RequestMapping(value = "/count", method = RequestMethod.GET, headers = "Accept=application/json")
    public
    @ResponseBody
    long count() {
        try {
            return pembelianService.countPembelians();
        } catch (DataAccessException e) {
            return 0L;
        }
    }

    @RequestMapping(method = RequestMethod.GET, headers = "Accept=application/json")
    public
    @ResponseBody
    List<Pembelian> findAll() {
        try {
            return pembelianService.findPembelians();
        } catch (DataAccessException e) {
            return new ArrayList<Pembelian>();
        }
    }

    @RequestMapping(method = RequestMethod.GET, params = "id", headers = "Accept=application/json")
    public
    @ResponseBody
    Pembelian findById(@RequestParam("id") Pembelian pembelian) {
        return pembelian;
    }

    @RequestMapping(value = "/search", method = RequestMethod.POST, headers = "Accept=application/json")
    public
    @ResponseBody
    List<Pembelian> find(@RequestBody Pembelian pembelian) {
        try {
            return pembelianService.findPembelians(pembelian);
        } catch (DataAccessException e) {
            return new ArrayList<Pembelian>();
        }
    }

    @RequestMapping(method = RequestMethod.POST, headers = "Accept=application/json")
    public
    @ResponseBody
    Map<Object, Object> save(@RequestBody Pembelian pembelian) {
        if (pembelian == null) throw new IllegalArgumentException("A Pembelian is required");
        Map<Object, Object> result = new HashMap<Object, Object>();
        try {
            pembelianService.save(pembelian);
            result.put("success", true);
            result.put("data", pembelian);
            result.put("message", "Sukses Save Pembelian " + pembelian);
            result.put("status", "oke");
        } catch (DataAccessException e) {
            result.put("success", false);
            result.put("data", pembelian);
            result.put("exception", e.getMessage());
            result.put("message", "Gagal Save Pembelian " + pembelian);
        }

        return result;
    }

    @RequestMapping(method = RequestMethod.DELETE, headers = "Accept=application/json")
    public
    @ResponseBody
    Map<String, Object> delete(@RequestParam("id") Pembelian pembelian) {
        Map<String, Object> result = new HashMap<String, Object>();
        try {
            pembelianService.delete(pembelian);
            result.put("success", true);
            result.put("message", "Sukses Delete Pembelian " + pembelian);
        } catch (DataAccessException e) {
            result.put("success", false);
            result.put("exception", e.getMessage());
            result.put("message", "Gagal Delete Pembelian " + pembelian);
        }
        return result;
    }

    @RequestMapping(value = "/delete", method = RequestMethod.POST, headers = "Accept=application/json")
    public
    @ResponseBody
    Map<String, Object> deleteMore(@RequestBody Pembelian[] pembelians) {
        Map<String, Object> result = new HashMap<String, Object>();
        try {
            pembelianService.deleteMore(pembelians);
            result.put("success", true);
            result.put("message", "Sukses Delete Pembelian " + pembelians);
        } catch (DataAccessException e) {
            result.put("success", false);
            result.put("exception", e.getMessage());
            result.put("message", "Gagal Delete Pembelian " + pembelians);
        }
        return result;
    }

    @RequestMapping(method = RequestMethod.PUT, headers = "Accept=application/json")
    public
    @ResponseBody
    Map<String, Object> update(@RequestBody Pembelian pembelian) {
        if (pembelian == null) throw new IllegalArgumentException("A Product is required");
        Map<String, Object> result = new HashMap<String, Object>();
        try {
            pembelianService.save(pembelian);
            result.put("success", true);
            result.put("data", pembelian);
            result.put("message", "Sukses Update Pembelian " + pembelian);
        } catch (DataAccessException e) {
            result.put("success", false);
            result.put("data", pembelian);
            result.put("exception", e.getMessage());
            result.put("message", "Gagal update kios " + pembelian);
        }
        return result;
    }

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        binder.registerCustomEditor(Pembelian.class, new PembelianEditor(pembelianService));
    }
}
