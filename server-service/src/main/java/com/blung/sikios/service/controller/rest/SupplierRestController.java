package com.blung.sikios.service.controller.rest;

import com.blung.sikios.domain.Barang;
import com.blung.sikios.domain.Supplier;
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
@RequestMapping("/supplier")
public class SupplierRestController {
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
            return barangService.countSuppliers();
        } catch (DataAccessException e) {
            return 0L;
        }
    }

    @RequestMapping(method = RequestMethod.GET, headers = "Accept=application/json")
    public
    @ResponseBody
    List<Supplier> findAll() {
        try {
            return barangService.findSuppliers();
        } catch (DataAccessException e) {
            return new ArrayList<Supplier>();
        }
    }

    @RequestMapping(method = RequestMethod.GET, params = "id", headers = "Accept=application/json")
    public
    @ResponseBody
    Supplier findById(@RequestParam("id") Supplier supplier) {
        return supplier;
    }

    @RequestMapping(value = "/search", method = RequestMethod.POST, headers = "Accept=application/json")
    public
    @ResponseBody
    List<Supplier> find(@RequestBody Supplier supplier) {
        try {
            return barangService.findSuppliers(supplier);
        } catch (DataAccessException e) {
            return new ArrayList<Supplier>();
        }
    }

    @RequestMapping(method = RequestMethod.POST, headers = "Accept=application/json")
    public
    @ResponseBody
    Map<Object, Object> save(@RequestBody Supplier supplier) {
        if (supplier == null) throw new IllegalArgumentException("A Supplier is required");
        Map<Object, Object> result = new HashMap<Object, Object>();
        try {
            barangService.save(supplier);
            result.put("success", true);
            result.put("data", supplier);
            result.put("message", "Sukses Save supplier " + supplier);
            result.put("status", "oke");
        } catch (DataAccessException e) {
            result.put("success", false);
            result.put("data", supplier);
            result.put("exception", e.getMessage());
            result.put("message", "Gagal Save supplier " + supplier);
        }

        return result;
    }

    @RequestMapping(method = RequestMethod.DELETE, headers = "Accept=application/json")
    public
    @ResponseBody
    Map<String, Object> delete(@RequestParam("id") Supplier supplier) {
        Map<String, Object> result = new HashMap<String, Object>();
        try {
            barangService.delete(supplier);
            result.put("success", true);
            result.put("message", "Sukses Delete supplier " + supplier);
        } catch (DataAccessException e) {
            result.put("success", false);
            result.put("exception", e.getMessage());
            result.put("message", "Gagal Delete supplier " + supplier);
        }
        return result;
    }

    @RequestMapping(value = "/delete", method = RequestMethod.POST, headers = "Accept=application/json")
    public
    @ResponseBody
    Map<String, Object> deleteMore(@RequestBody Supplier[] suppliers) {
        Map<String, Object> result = new HashMap<String, Object>();
        try {
            barangService.deleteMore(suppliers);
            result.put("success", true);
            result.put("message", "Sukses Delete suppliers " + suppliers);
        } catch (DataAccessException e) {
            result.put("success", false);
            result.put("exception", e.getMessage());
            result.put("message", "Gagal Delete suppliers " + suppliers);
        }
        return result;
    }

    @RequestMapping(method = RequestMethod.PUT, headers = "Accept=application/json")
    public
    @ResponseBody
    Map<String, Object> update(@RequestBody Supplier supplier) {
        if (supplier == null) throw new IllegalArgumentException("A Product is required");
        Map<String, Object> result = new HashMap<String, Object>();
        try {
            barangService.save(supplier);
            result.put("success", true);
            result.put("data", supplier);
            result.put("message", "Sukses Update supplier " + supplier);
        } catch (DataAccessException e) {
            result.put("success", false);
            result.put("data", supplier);
            result.put("exception", e.getMessage());
            result.put("message", "Gagal update supplier " + supplier);
        }
        return result;
    }

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        binder.registerCustomEditor(Barang.class, new BarangEditor(barangService));
    }
}
