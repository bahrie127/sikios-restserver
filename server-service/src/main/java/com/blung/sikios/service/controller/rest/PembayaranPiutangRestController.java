package com.blung.sikios.service.controller.rest;

import com.blung.sikios.domain.PembayaranPiutang;
import com.blung.sikios.domain.Piutang;
import com.blung.sikios.service.PiutangService;
import com.blung.sikios.service.editor.PembayaranPiutangEditor;
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
@RequestMapping("/pembayaranPiutang")
public class PembayaranPiutangRestController {

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
            return piutangService.countPembayaranPiutangs();
        } catch (DataAccessException e) {
            return 0L;
        }
    }

    @RequestMapping(method = RequestMethod.GET, headers = "Accept=application/json")
    public
    @ResponseBody
    List<PembayaranPiutang> findAll() {
        try {
            return piutangService.findPembayaranPiutangs();
        } catch (DataAccessException e) {
            return new ArrayList<PembayaranPiutang>();
        }
    }

    @RequestMapping(method = RequestMethod.GET, params = "id", headers = "Accept=application/json")
    public
    @ResponseBody
    PembayaranPiutang findById(@RequestParam("id") PembayaranPiutang pembayaranPiutang) {
        return pembayaranPiutang;
    }

    @RequestMapping(value = "/search", method = RequestMethod.POST, headers = "Accept=application/json")
    public
    @ResponseBody
    List<PembayaranPiutang> find(@RequestBody PembayaranPiutang pembayaranPiutang) {
        try {
            return piutangService.findPembayaranPiutangs(pembayaranPiutang);
        } catch (DataAccessException e) {
            return new ArrayList<PembayaranPiutang>();
        }
    }

    @RequestMapping(method = RequestMethod.POST, headers = "Accept=application/json")
    public
    @ResponseBody
    Map<Object, Object> save(@RequestBody PembayaranPiutang pembayaranPiutang) {
        if (pembayaranPiutang == null) throw new IllegalArgumentException("A PembayaranPiutang is required");
        Map<Object, Object> result = new HashMap<Object, Object>();
        try {
            piutangService.save(pembayaranPiutang);
            result.put("success", true);
            result.put("data", pembayaranPiutang);
            result.put("message", "Sukses Save PembayaranPiutang " + pembayaranPiutang);
            result.put("status", "oke");
        } catch (DataAccessException e) {
            result.put("success", false);
            result.put("data", pembayaranPiutang);
            result.put("exception", e.getMessage());
            result.put("message", "Gagal Save PembayaranPiutang " + pembayaranPiutang);
        }

        return result;
    }

    @RequestMapping(method = RequestMethod.DELETE, headers = "Accept=application/json")
    public
    @ResponseBody
    Map<String, Object> delete(@RequestParam("id") PembayaranPiutang pembayaranPiutang) {
        Map<String, Object> result = new HashMap<String, Object>();
        try {
            piutangService.delete(pembayaranPiutang);
            result.put("success", true);
            result.put("message", "Sukses Delete PembayaranPiutang " + pembayaranPiutang);
        } catch (DataAccessException e) {
            result.put("success", false);
            result.put("exception", e.getMessage());
            result.put("message", "Gagal Delete PembayaranPiutang " + pembayaranPiutang);
        }
        return result;
    }

    @RequestMapping(value = "/delete", method = RequestMethod.POST, headers = "Accept=application/json")
    public
    @ResponseBody
    Map<String, Object> deleteMore(@RequestBody PembayaranPiutang[] pembayaranPiutangs) {
        Map<String, Object> result = new HashMap<String, Object>();
        try {
            piutangService.deleteMore(pembayaranPiutangs);
            result.put("success", true);
            result.put("message", "Sukses Delete PembayaranPiutang " + pembayaranPiutangs);
        } catch (DataAccessException e) {
            result.put("success", false);
            result.put("exception", e.getMessage());
            result.put("message", "Gagal Delete PembayaranPiutang " + pembayaranPiutangs);
        }
        return result;
    }

    @RequestMapping(method = RequestMethod.PUT, headers = "Accept=application/json")
    public
    @ResponseBody
    Map<String, Object> update(@RequestBody PembayaranPiutang pembayaranPiutang) {
        if (pembayaranPiutang == null) throw new IllegalArgumentException("A Product is required");
        Map<String, Object> result = new HashMap<String, Object>();
        try {
            piutangService.save(pembayaranPiutang);
            result.put("success", true);
            result.put("data", pembayaranPiutang);
            result.put("message", "Sukses Update PembayaranPiutang " + pembayaranPiutang);
        } catch (DataAccessException e) {
            result.put("success", false);
            result.put("data", pembayaranPiutang);
            result.put("exception", e.getMessage());
            result.put("message", "Gagal update kios " + pembayaranPiutang);
        }
        return result;
    }

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        binder.registerCustomEditor(PembayaranPiutang.class, new PembayaranPiutangEditor(piutangService));
    }
}
