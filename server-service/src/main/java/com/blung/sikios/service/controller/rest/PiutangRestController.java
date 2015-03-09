package com.blung.sikios.service.controller.rest;

import com.blung.sikios.domain.Piutang;
import com.blung.sikios.service.PiutangService;
import com.blung.sikios.service.editor.PiutangEditor;
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
@RequestMapping("/piutang")
public class PiutangRestController {

    @Autowired
    @Qualifier("piutangService")
    private PiutangService piutangService;

    /*
     * *** Service Method *******************************************************************************************
     */

    @RequestMapping(value = "/count", method = RequestMethod.GET, headers = "Accept=application/json")
    public
    @ResponseBody
    long count() {
        try {
            return piutangService.countPiutangs();
        } catch (DataAccessException e) {
            return 0L;
        }
    }

    @RequestMapping(method = RequestMethod.GET, headers = "Accept=application/json")
    public
    @ResponseBody
    List<Piutang> findAll() {
        try {
            return piutangService.findPiutangs();
        } catch (DataAccessException e) {
            return new ArrayList<Piutang>();
        }
    }

    @RequestMapping(method = RequestMethod.GET, params = "id", headers = "Accept=application/json")
    public
    @ResponseBody
    Piutang findById(@RequestParam("id") Piutang piutang) {
        return piutang;
    }

    @RequestMapping(value = "/search", method = RequestMethod.POST, headers = "Accept=application/json")
    public
    @ResponseBody
    List<Piutang> find(@RequestBody Piutang piutang) {
        try {
            return piutangService.findPiutangs(piutang);
        } catch (DataAccessException e) {
            return new ArrayList<Piutang>();
        }
    }

    @RequestMapping(method = RequestMethod.POST, headers = "Accept=application/json")
    public
    @ResponseBody
    Map<Object, Object> save(@RequestBody Piutang piutang) {
        if (piutang == null) throw new IllegalArgumentException("A Piutang is required");
        Map<Object, Object> result = new HashMap<Object, Object>();
        try {
            piutangService.save(piutang);
            result.put("success", true);
            result.put("data", piutang);
            result.put("message", "Sukses Save Piutang " + piutang);
            result.put("status", "oke");
        } catch (DataAccessException e) {
            result.put("success", false);
            result.put("data", piutang);
            result.put("exception", e.getMessage());
            result.put("message", "Gagal Save Piutang " + piutang);
        }

        return result;
    }

    @RequestMapping(method = RequestMethod.DELETE, headers = "Accept=application/json")
    public
    @ResponseBody
    Map<String, Object> delete(@RequestParam("id") Piutang piutang) {
        Map<String, Object> result = new HashMap<String, Object>();
        try {
            piutangService.delete(piutang);
            result.put("success", true);
            result.put("message", "Sukses Delete Piutang " + piutang);
        } catch (DataAccessException e) {
            result.put("success", false);
            result.put("exception", e.getMessage());
            result.put("message", "Gagal Delete Piutang " + piutang);
        }
        return result;
    }

    @RequestMapping(value = "/delete", method = RequestMethod.POST, headers = "Accept=application/json")
    public
    @ResponseBody
    Map<String, Object> deleteMore(@RequestBody Piutang[] piutangs) {
        Map<String, Object> result = new HashMap<String, Object>();
        try {
            piutangService.deleteMore(piutangs);
            result.put("success", true);
            result.put("message", "Sukses Delete Piutang " + piutangs);
        } catch (DataAccessException e) {
            result.put("success", false);
            result.put("exception", e.getMessage());
            result.put("message", "Gagal Delete Piutang " + piutangs);
        }
        return result;
    }

    @RequestMapping(method = RequestMethod.PUT, headers = "Accept=application/json")
    public
    @ResponseBody
    Map<String, Object> update(@RequestBody Piutang piutang) {
        if (piutang == null) throw new IllegalArgumentException("A Product is required");
        Map<String, Object> result = new HashMap<String, Object>();
        try {
            piutangService.save(piutang);
            result.put("success", true);
            result.put("data", piutang);
            result.put("message", "Sukses Update Piutang " + piutang);
        } catch (DataAccessException e) {
            result.put("success", false);
            result.put("data", piutang);
            result.put("exception", e.getMessage());
            result.put("message", "Gagal update kios " + piutang);
        }
        return result;
    }

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        binder.registerCustomEditor(Piutang.class, new PiutangEditor(piutangService));
    }
}
