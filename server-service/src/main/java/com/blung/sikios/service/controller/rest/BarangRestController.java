package com.blung.sikios.service.controller.rest;

import com.blung.sikios.domain.Barang;
import com.blung.sikios.service.BarangService;
import com.blung.sikios.service.editor.BarangEditor;
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
@RequestMapping("/barang")
public class BarangRestController {
    @Autowired
    @Qualifier("barangService")
    private BarangService barangService;

    /*
     * *** Service Method *******************************************************************************************
     */

    @RequestMapping(value = "/count", method = RequestMethod.GET, headers = "Accept=application/json")
    public
    @ResponseBody
    long count() {
        try {
            return barangService.countBarangs();
        } catch (DataAccessException e) {
            return 0L;
        }
    }

    @RequestMapping(method = RequestMethod.GET, headers = "Accept=application/json")
    public
    @ResponseBody
    List<Barang> findAll() {
        try {
            return barangService.findBarangs();
        } catch (DataAccessException e) {
            return new ArrayList<Barang>();
        }
    }

    @RequestMapping(method = RequestMethod.GET, params = "id", headers = "Accept=application/json")
    public
    @ResponseBody
    Barang findById(@RequestParam("id") Barang barang) {
        return barang;
    }

    @RequestMapping(value = "/search", method = RequestMethod.POST, headers = "Accept=application/json")
    public
    @ResponseBody
    List<Barang> find(@RequestBody Barang barang) {
        try {
            return barangService.findBarangs(barang);
        } catch (DataAccessException e) {
            return new ArrayList<Barang>();
        }
    }

    @RequestMapping(method = RequestMethod.POST, headers = "Accept=application/json")
    public
    @ResponseBody
    Map<Object, Object> save(@RequestBody Barang barang) {
        if (barang == null) throw new IllegalArgumentException("A Barang is required");
        Map<Object, Object> result = new HashMap<Object, Object>();
        try {
            barangService.save(barang);
            result.put("success", true);
            result.put("data", barang);
            result.put("message", "Sukses Save Barang " + barang);
            result.put("status", "oke");
        } catch (DataAccessException e) {
            result.put("success", false);
            result.put("data", barang);
            result.put("exception", e.getMessage());
            result.put("message", "Gagal Save Barang " + barang);
        }

        return result;
    }

    @RequestMapping(method = RequestMethod.DELETE, headers = "Accept=application/json")
    public
    @ResponseBody
    Map<String, Object> delete(@RequestParam("id") Barang barang) {
        Map<String, Object> result = new HashMap<String, Object>();
        try {
            barangService.delete(barang);
            result.put("success", true);
            result.put("message", "Sukses Delete Barang " + barang);
        } catch (DataAccessException e) {
            result.put("success", false);
            result.put("exception", e.getMessage());
            result.put("message", "Gagal Delete Barang " + barang);
        }
        return result;
    }

    @RequestMapping(value = "/delete", method = RequestMethod.POST, headers = "Accept=application/json")
    public
    @ResponseBody
    Map<String, Object> deleteMore(@RequestBody Barang[] barangs) {
        Map<String, Object> result = new HashMap<String, Object>();
        try {
            barangService.deleteMore(barangs);
            result.put("success", true);
            result.put("message", "Sukses Delete Barang " + barangs);
        } catch (DataAccessException e) {
            result.put("success", false);
            result.put("exception", e.getMessage());
            result.put("message", "Gagal Delete Barang " + barangs);
        }
        return result;
    }

    @RequestMapping(method = RequestMethod.PUT, headers = "Accept=application/json")
    public
    @ResponseBody
    Map<String, Object> update(@RequestBody Barang barang) {
        if (barang == null) throw new IllegalArgumentException("A Product is required");
        Map<String, Object> result = new HashMap<String, Object>();
        try {
            barangService.save(barang);
            result.put("success", true);
            result.put("data", barang);
            result.put("message", "Sukses Update Barang " + barang);
        } catch (DataAccessException e) {
            result.put("success", false);
            result.put("data", barang);
            result.put("exception", e.getMessage());
            result.put("message", "Gagal update kios " + barang);
        }
        return result;
    }

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        binder.registerCustomEditor(Barang.class, new BarangEditor(barangService));
    }
}
