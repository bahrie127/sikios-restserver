package com.blung.sikios.service.controller.rest;

import com.blung.sikios.domain.Hutang;
import com.blung.sikios.service.HutangService;
import com.blung.sikios.service.editor.HutangEditor;
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
@RequestMapping("/hutang")
public class HutangRestController {

    @Autowired
    @Qualifier("hutangService")
    private HutangService hutangService;

    /*
     * *** Service Method *******************************************************************************************
     */

    @RequestMapping(value = "/count", method = RequestMethod.GET, headers = "Accept=application/json")
    public
    @ResponseBody
    long count() {
        try {
            return hutangService.countHutangs();
        } catch (DataAccessException e) {
            return 0L;
        }
    }

    @RequestMapping(method = RequestMethod.GET, headers = "Accept=application/json")
    public
    @ResponseBody
    List<Hutang> findAll() {
        try {
            return hutangService.findHutangs();
        } catch (DataAccessException e) {
            return new ArrayList<Hutang>();
        }
    }

    @RequestMapping(method = RequestMethod.GET, params = "id", headers = "Accept=application/json")
    public
    @ResponseBody
    Hutang findById(@RequestParam("id") Hutang hutang) {
        return hutang;
    }

    @RequestMapping(value = "/search", method = RequestMethod.POST, headers = "Accept=application/json")
    public
    @ResponseBody
    List<Hutang> find(@RequestBody Hutang hutang) {
        try {
            return hutangService.findHutangs(hutang);
        } catch (DataAccessException e) {
            return new ArrayList<Hutang>();
        }
    }

    @RequestMapping(method = RequestMethod.POST, headers = "Accept=application/json")
    public
    @ResponseBody
    Map<Object, Object> save(@RequestBody Hutang hutang) {
        if (hutang == null) throw new IllegalArgumentException("A Hutang is required");
        Map<Object, Object> result = new HashMap<Object, Object>();
        try {
            hutangService.save(hutang);
            result.put("success", true);
            result.put("data", hutang);
            result.put("message", "Sukses Save Hutang " + hutang);
            result.put("status", "oke");
        } catch (DataAccessException e) {
            result.put("success", false);
            result.put("data", hutang);
            result.put("exception", e.getMessage());
            result.put("message", "Gagal Save Hutang " + hutang);
        }

        return result;
    }

    @RequestMapping(method = RequestMethod.DELETE, headers = "Accept=application/json")
    public
    @ResponseBody
    Map<String, Object> delete(@RequestParam("id") Hutang hutang) {
        Map<String, Object> result = new HashMap<String, Object>();
        try {
            hutangService.delete(hutang);
            result.put("success", true);
            result.put("message", "Sukses Delete Hutang " + hutang);
        } catch (DataAccessException e) {
            result.put("success", false);
            result.put("exception", e.getMessage());
            result.put("message", "Gagal Delete Hutang " + hutang);
        }
        return result;
    }

    @RequestMapping(value = "/delete", method = RequestMethod.POST, headers = "Accept=application/json")
    public
    @ResponseBody
    Map<String, Object> deleteMore(@RequestBody Hutang[] hutangs) {
        Map<String, Object> result = new HashMap<String, Object>();
        try {
            hutangService.deleteMore(hutangs);
            result.put("success", true);
            result.put("message", "Sukses Delete Hutang " + hutangs);
        } catch (DataAccessException e) {
            result.put("success", false);
            result.put("exception", e.getMessage());
            result.put("message", "Gagal Delete Hutang " + hutangs);
        }
        return result;
    }

    @RequestMapping(method = RequestMethod.PUT, headers = "Accept=application/json")
    public
    @ResponseBody
    Map<String, Object> update(@RequestBody Hutang hutang) {
        if (hutang == null) throw new IllegalArgumentException("A Product is required");
        Map<String, Object> result = new HashMap<String, Object>();
        try {
            hutangService.save(hutang);
            result.put("success", true);
            result.put("data", hutang);
            result.put("message", "Sukses Update Hutang " + hutang);
        } catch (DataAccessException e) {
            result.put("success", false);
            result.put("data", hutang);
            result.put("exception", e.getMessage());
            result.put("message", "Gagal update kios " + hutang);
        }
        return result;
    }

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        binder.registerCustomEditor(Hutang.class, new HutangEditor(hutangService));
    }
}
