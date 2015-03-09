package com.blung.sikios.service.controller.rest;

import com.blung.sikios.domain.Karyawan;
import com.blung.sikios.service.KaryawanService;
import com.blung.sikios.service.editor.KaryawanEditor;
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
@RequestMapping("/karyawan")
public class KaryawanRestController {

    @Autowired
    @Qualifier("karyawanService")
    private KaryawanService karyawanService;

    /*
     * *** Service Method *******************************************************************************************
     */

    @RequestMapping(value = "/count", method = RequestMethod.GET, headers = "Accept=application/json")
    public
    @ResponseBody
    long count() {
        try {
            return karyawanService.countKaryawans();
        } catch (DataAccessException e) {
            return 0L;
        }
    }

    @RequestMapping(method = RequestMethod.GET, headers = "Accept=application/json")
    public
    @ResponseBody
    List<Karyawan> findAll() {
        try {
            return karyawanService.findKaryawans();
        } catch (DataAccessException e) {
            return new ArrayList<Karyawan>();
        }
    }

    @RequestMapping(method = RequestMethod.GET, params = "id", headers = "Accept=application/json")
    public
    @ResponseBody
    Karyawan findById(@RequestParam("id") Karyawan karyawan) {
        return karyawan;
    }

    @RequestMapping(value = "/search", method = RequestMethod.POST, headers = "Accept=application/json")
    public
    @ResponseBody
    List<Karyawan> find(@RequestBody Karyawan karyawan) {
        try {
            return karyawanService.findKaryawans(karyawan);
        } catch (DataAccessException e) {
            return new ArrayList<Karyawan>();
        }
    }

    @RequestMapping(method = RequestMethod.POST, headers = "Accept=application/json")
    public
    @ResponseBody
    Map<Object, Object> save(@RequestBody Karyawan karyawan) {
        if (karyawan == null) throw new IllegalArgumentException("A Karyawan is required");
        Map<Object, Object> result = new HashMap<Object, Object>();
        try {
            karyawanService.save(karyawan);
            result.put("success", true);
            result.put("data", karyawan);
            result.put("message", "Sukses Save Karyawan " + karyawan);
            result.put("status", "oke");
        } catch (DataAccessException e) {
            result.put("success", false);
            result.put("data", karyawan);
            result.put("exception", e.getMessage());
            result.put("message", "Gagal Save Karyawan " + karyawan);
        }

        return result;
    }

    @RequestMapping(method = RequestMethod.DELETE, headers = "Accept=application/json")
    public
    @ResponseBody
    Map<String, Object> delete(@RequestParam("id") Karyawan karyawan) {
        Map<String, Object> result = new HashMap<String, Object>();
        try {
            karyawanService.delete(karyawan);
            result.put("success", true);
            result.put("message", "Sukses Delete Karyawan " + karyawan);
        } catch (DataAccessException e) {
            result.put("success", false);
            result.put("exception", e.getMessage());
            result.put("message", "Gagal Delete Karyawan " + karyawan);
        }
        return result;
    }

    @RequestMapping(value = "/delete", method = RequestMethod.POST, headers = "Accept=application/json")
    public
    @ResponseBody
    Map<String, Object> deleteMore(@RequestBody Karyawan[] karyawans) {
        Map<String, Object> result = new HashMap<String, Object>();
        try {
            karyawanService.deleteMore(karyawans);
            result.put("success", true);
            result.put("message", "Sukses Delete Karyawan " + karyawans);
        } catch (DataAccessException e) {
            result.put("success", false);
            result.put("exception", e.getMessage());
            result.put("message", "Gagal Delete Karyawan " + karyawans);
        }
        return result;
    }

    @RequestMapping(method = RequestMethod.PUT, headers = "Accept=application/json")
    public
    @ResponseBody
    Map<String, Object> update(@RequestBody Karyawan karyawan) {
        if (karyawan == null) throw new IllegalArgumentException("A Product is required");
        Map<String, Object> result = new HashMap<String, Object>();
        try {
            karyawanService.save(karyawan);
            result.put("success", true);
            result.put("data", karyawan);
            result.put("message", "Sukses Update Karyawan " + karyawan);
        } catch (DataAccessException e) {
            result.put("success", false);
            result.put("data", karyawan);
            result.put("exception", e.getMessage());
            result.put("message", "Gagal update kios " + karyawan);
        }
        return result;
    }

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        binder.registerCustomEditor(Karyawan.class, new KaryawanEditor(karyawanService));
    }
}
