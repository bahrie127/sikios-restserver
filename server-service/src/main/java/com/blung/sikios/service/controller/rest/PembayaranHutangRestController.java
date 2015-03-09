package com.blung.sikios.service.controller.rest;

import com.blung.sikios.domain.Hutang;
import com.blung.sikios.domain.PembayaranHutang;
import com.blung.sikios.service.HutangService;
import com.blung.sikios.service.editor.HutangEditor;
import com.blung.sikios.service.editor.PembayaranHutangEditor;
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
@RequestMapping("/PembayaranHutang")
public class PembayaranHutangRestController {

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
            return hutangService.countPembayaranHutangs();
        } catch (DataAccessException e) {
            return 0L;
        }
    }

    @RequestMapping(method = RequestMethod.GET, headers = "Accept=application/json")
    public
    @ResponseBody
    List<PembayaranHutang> findAll() {
        try {
            return hutangService.findPembayaranHutangs();
        } catch (DataAccessException e) {
            return new ArrayList<PembayaranHutang>();
        }
    }

    @RequestMapping(method = RequestMethod.GET, params = "id", headers = "Accept=application/json")
    public
    @ResponseBody
    PembayaranHutang findById(@RequestParam("id") PembayaranHutang pembayaranHutang) {
        return pembayaranHutang;
    }

    @RequestMapping(value = "/search", method = RequestMethod.POST, headers = "Accept=application/json")
    public
    @ResponseBody
    List<PembayaranHutang> find(@RequestBody PembayaranHutang pembayaranHutang) {
        try {
            return hutangService.findPembayaranHutangs(pembayaranHutang);
        } catch (DataAccessException e) {
            return new ArrayList<PembayaranHutang>();
        }
    }

    @RequestMapping(method = RequestMethod.POST, headers = "Accept=application/json")
    public
    @ResponseBody
    Map<Object, Object> save(@RequestBody PembayaranHutang pembayaranHutang) {
        if (pembayaranHutang == null) throw new IllegalArgumentException("A PembayaranHutang is required");
        Map<Object, Object> result = new HashMap<Object, Object>();
        try {
            hutangService.save(pembayaranHutang);
            result.put("success", true);
            result.put("data", pembayaranHutang);
            result.put("message", "Sukses Save PembayaranHutang " + pembayaranHutang);
            result.put("status", "oke");
        } catch (DataAccessException e) {
            result.put("success", false);
            result.put("data", pembayaranHutang);
            result.put("exception", e.getMessage());
            result.put("message", "Gagal Save PembayaranHutang " + pembayaranHutang);
        }

        return result;
    }

    @RequestMapping(method = RequestMethod.DELETE, headers = "Accept=application/json")
    public
    @ResponseBody
    Map<String, Object> delete(@RequestParam("id") PembayaranHutang pembayaranHutang) {
        Map<String, Object> result = new HashMap<String, Object>();
        try {
            hutangService.delete(pembayaranHutang);
            result.put("success", true);
            result.put("message", "Sukses Delete PembayaranHutang " + pembayaranHutang);
        } catch (DataAccessException e) {
            result.put("success", false);
            result.put("exception", e.getMessage());
            result.put("message", "Gagal Delete PembayaranHutang " + pembayaranHutang);
        }
        return result;
    }

    @RequestMapping(value = "/delete", method = RequestMethod.POST, headers = "Accept=application/json")
    public
    @ResponseBody
    Map<String, Object> deleteMore(@RequestBody PembayaranHutang[] pembayaranHutangs) {
        Map<String, Object> result = new HashMap<String, Object>();
        try {
            hutangService.deleteMore(pembayaranHutangs);
            result.put("success", true);
            result.put("message", "Sukses Delete PembayaranHutang " + pembayaranHutangs);
        } catch (DataAccessException e) {
            result.put("success", false);
            result.put("exception", e.getMessage());
            result.put("message", "Gagal Delete PembayaranHutang " + pembayaranHutangs);
        }
        return result;
    }

    @RequestMapping(method = RequestMethod.PUT, headers = "Accept=application/json")
    public
    @ResponseBody
    Map<String, Object> update(@RequestBody PembayaranHutang pembayaranHutang) {
        if (pembayaranHutang == null) throw new IllegalArgumentException("A Product is required");
        Map<String, Object> result = new HashMap<String, Object>();
        try {
            hutangService.save(pembayaranHutang);
            result.put("success", true);
            result.put("data", pembayaranHutang);
            result.put("message", "Sukses Update PembayaranHutang " + pembayaranHutang);
        } catch (DataAccessException e) {
            result.put("success", false);
            result.put("data", pembayaranHutang);
            result.put("exception", e.getMessage());
            result.put("message", "Gagal update kios " + pembayaranHutang);
        }
        return result;
    }

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        binder.registerCustomEditor(PembayaranHutang.class, new PembayaranHutangEditor(hutangService));
    }
}
