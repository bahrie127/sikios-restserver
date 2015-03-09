package com.blung.sikios.service.controller.rest;

import com.blung.sikios.domain.Penjualan;
import com.blung.sikios.service.PenjualanService;
import com.blung.sikios.service.editor.PenjualanEditor;
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
@RequestMapping("/penjualan")
public class PenjualanRestController {

    @Autowired
    @Qualifier("penjualanService")
    private PenjualanService penjualanService;

    /*
     * *** Service Method *******************************************************************************************
     */

    @RequestMapping(value = "/count", method = RequestMethod.GET, headers = "Accept=application/json")
    public
    @ResponseBody
    long count() {
        try {
            return penjualanService.countPenjualans();
        } catch (DataAccessException e) {
            return 0L;
        }
    }

    @RequestMapping(method = RequestMethod.GET, headers = "Accept=application/json")
    public
    @ResponseBody
    List<Penjualan> findAll() {
        try {
            return penjualanService.findPenjualans();
        } catch (DataAccessException e) {
            return new ArrayList<Penjualan>();
        }
    }

    @RequestMapping(method = RequestMethod.GET, params = "id", headers = "Accept=application/json")
    public
    @ResponseBody
    Penjualan findById(@RequestParam("id") Penjualan penjualan) {
        return penjualan;
    }

    @RequestMapping(value = "/search", method = RequestMethod.POST, headers = "Accept=application/json")
    public
    @ResponseBody
    List<Penjualan> find(@RequestBody Penjualan penjualan) {
        try {
            return penjualanService.findPenjualans(penjualan);
        } catch (DataAccessException e) {
            return new ArrayList<Penjualan>();
        }
    }

    @RequestMapping(method = RequestMethod.POST, headers = "Accept=application/json")
    public
    @ResponseBody
    Map<Object, Object> save(@RequestBody Penjualan penjualan) {
        if (penjualan == null) throw new IllegalArgumentException("A Penjualan is required");
        Map<Object, Object> result = new HashMap<Object, Object>();
        try {
            penjualanService.save(penjualan);
            result.put("success", true);
            result.put("data", penjualan);
            result.put("message", "Sukses Save Penjualan " + penjualan);
            result.put("status", "oke");
        } catch (DataAccessException e) {
            result.put("success", false);
            result.put("data", penjualan);
            result.put("exception", e.getMessage());
            result.put("message", "Gagal Save Penjualan " + penjualan);
        }

        return result;
    }

    @RequestMapping(method = RequestMethod.DELETE, headers = "Accept=application/json")
    public
    @ResponseBody
    Map<String, Object> delete(@RequestParam("id") Penjualan penjualan) {
        Map<String, Object> result = new HashMap<String, Object>();
        try {
            penjualanService.delete(penjualan);
            result.put("success", true);
            result.put("message", "Sukses Delete Penjualan " + penjualan);
        } catch (DataAccessException e) {
            result.put("success", false);
            result.put("exception", e.getMessage());
            result.put("message", "Gagal Delete Penjualan " + penjualan);
        }
        return result;
    }

    @RequestMapping(value = "/delete", method = RequestMethod.POST, headers = "Accept=application/json")
    public
    @ResponseBody
    Map<String, Object> deleteMore(@RequestBody Penjualan[] penjualans) {
        Map<String, Object> result = new HashMap<String, Object>();
        try {
            penjualanService.deleteMore(penjualans);
            result.put("success", true);
            result.put("message", "Sukses Delete Penjualan " + penjualans);
        } catch (DataAccessException e) {
            result.put("success", false);
            result.put("exception", e.getMessage());
            result.put("message", "Gagal Delete Penjualan " + penjualans);
        }
        return result;
    }

    @RequestMapping(method = RequestMethod.PUT, headers = "Accept=application/json")
    public
    @ResponseBody
    Map<String, Object> update(@RequestBody Penjualan penjualan) {
        if (penjualan == null) throw new IllegalArgumentException("A Product is required");
        Map<String, Object> result = new HashMap<String, Object>();
        try {
            penjualanService.save(penjualan);
            result.put("success", true);
            result.put("data", penjualan);
            result.put("message", "Sukses Update Penjualan " + penjualan);
        } catch (DataAccessException e) {
            result.put("success", false);
            result.put("data", penjualan);
            result.put("exception", e.getMessage());
            result.put("message", "Gagal update kios " + penjualan);
        }
        return result;
    }

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        binder.registerCustomEditor(Penjualan.class, new PenjualanEditor(penjualanService));
    }
}
