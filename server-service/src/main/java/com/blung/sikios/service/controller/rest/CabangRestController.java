package com.blung.sikios.service.controller.rest;

import com.blung.sikios.domain.Cabang;
import com.blung.sikios.service.CabangService;
import com.blung.sikios.service.editor.CabangEditor;
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
@RequestMapping("/cabang")
public class CabangRestController {

    @Autowired
    @Qualifier("cabangService")
    private CabangService cabangService;

    /*
     * *** Service Method *******************************************************************************************
     */

    @RequestMapping(value = "/count", method = RequestMethod.GET, headers = "Accept=application/json")
    public
    @ResponseBody
    long count() {
        try {
            return cabangService.countCabangs();
        } catch (DataAccessException e) {
            return 0L;
        }
    }

    @RequestMapping(method = RequestMethod.GET, headers = "Accept=application/json")
    public
    @ResponseBody
    List<Cabang> findAll() {
        try {
            return cabangService.findCabangs();
        } catch (DataAccessException e) {
            return new ArrayList<Cabang>();
        }
    }

    @RequestMapping(method = RequestMethod.GET, params = "id", headers = "Accept=application/json")
    public
    @ResponseBody
    Cabang findById(@RequestParam("id") Cabang cabang) {
        return cabang;
    }

    @RequestMapping(value = "/search", method = RequestMethod.POST, headers = "Accept=application/json")
    public
    @ResponseBody
    List<Cabang> find(@RequestBody Cabang cabang) {
        try {
            return cabangService.findCabangs(cabang);
        } catch (DataAccessException e) {
            return new ArrayList<Cabang>();
        }
    }

    @RequestMapping(method = RequestMethod.POST, headers = "Accept=application/json")
    public
    @ResponseBody
    Map<Object, Object> save(@RequestBody Cabang cabang) {
        if (cabang == null) throw new IllegalArgumentException("A Cabang is required");
        Map<Object, Object> result = new HashMap<Object, Object>();
        try {
            cabangService.save(cabang);
            result.put("success", true);
            result.put("data", cabang);
            result.put("message", "Sukses Save Cabang " + cabang);
            result.put("status", "oke");
        } catch (DataAccessException e) {
            result.put("success", false);
            result.put("data", cabang);
            result.put("exception", e.getMessage());
            result.put("message", "Gagal Save Cabang " + cabang);
        }

        return result;
    }

    @RequestMapping(method = RequestMethod.DELETE, headers = "Accept=application/json")
    public
    @ResponseBody
    Map<String, Object> delete(@RequestParam("id") Cabang cabang) {
        Map<String, Object> result = new HashMap<String, Object>();
        try {
            cabangService.delete(cabang);
            result.put("success", true);
            result.put("message", "Sukses Delete Cabang " + cabang);
        } catch (DataAccessException e) {
            result.put("success", false);
            result.put("exception", e.getMessage());
            result.put("message", "Gagal Delete Cabang " + cabang);
        }
        return result;
    }

    @RequestMapping(value = "/delete", method = RequestMethod.POST, headers = "Accept=application/json")
    public
    @ResponseBody
    Map<String, Object> deleteMore(@RequestBody Cabang[] cabangs) {
        Map<String, Object> result = new HashMap<String, Object>();
        try {
            cabangService.deleteMore(cabangs);
            result.put("success", true);
            result.put("message", "Sukses Delete Cabang " + cabangs);
        } catch (DataAccessException e) {
            result.put("success", false);
            result.put("exception", e.getMessage());
            result.put("message", "Gagal Delete Cabang " + cabangs);
        }
        return result;
    }

    @RequestMapping(method = RequestMethod.PUT, headers = "Accept=application/json")
    public
    @ResponseBody
    Map<String, Object> update(@RequestBody Cabang cabang) {
        if (cabang == null) throw new IllegalArgumentException("A Product is required");
        Map<String, Object> result = new HashMap<String, Object>();
        try {
            cabangService.save(cabang);
            result.put("success", true);
            result.put("data", cabang);
            result.put("message", "Sukses Update Cabang " + cabang);
        } catch (DataAccessException e) {
            result.put("success", false);
            result.put("data", cabang);
            result.put("exception", e.getMessage());
            result.put("message", "Gagal update kios " + cabang);
        }
        return result;
    }

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        binder.registerCustomEditor(Cabang.class, new CabangEditor(cabangService));
    }
}
