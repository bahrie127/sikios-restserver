package com.blung.sikios.service.controller.rest;

import com.blung.sikios.domain.Kios;
import com.blung.sikios.domain.PembayaranKios;
import com.blung.sikios.service.KiosService;
import com.blung.sikios.service.editor.PembayaranKiosEditor;
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
@RequestMapping("/pembayaranKios")
public class PembayaranKiosRestController {

    @Autowired
    @Qualifier("kiosService")
    private KiosService kiosService;

    /*
     * *** Service Method *******************************************************************************************
     */

    @RequestMapping(value = "/count", method = RequestMethod.GET, headers = "Accept=application/json")
    public
    @ResponseBody
    long count() {
        try {
            return kiosService.countPembayaranKioss();
        } catch (DataAccessException e) {
            return 0L;
        }
    }

    @RequestMapping(method = RequestMethod.GET, headers = "Accept=application/json")
    public
    @ResponseBody
    List<PembayaranKios> findAll() {
        try {
            return kiosService.findPembayaranKioss();
        } catch (DataAccessException e) {
            return new ArrayList<PembayaranKios>();
        }
    }

    @RequestMapping(method = RequestMethod.GET, params = "id", headers = "Accept=application/json")
    public
    @ResponseBody
    Kios findById(@RequestParam("id") Kios kios) {
        return kios;
    }

    @RequestMapping(value = "/search", method = RequestMethod.POST, headers = "Accept=application/json")
    public
    @ResponseBody
    List<PembayaranKios> find(@RequestBody PembayaranKios pembayaranKios) {
        try {
            return kiosService.findPembayaranKioss(pembayaranKios);
        } catch (DataAccessException e) {
            return new ArrayList<PembayaranKios>();
        }
    }

    @RequestMapping(method = RequestMethod.POST, headers = "Accept=application/json")
    public
    @ResponseBody
    Map<Object, Object> save(@RequestBody PembayaranKios pembayaranKios) {
        if (pembayaranKios == null) throw new IllegalArgumentException("A PembayaranKios is required");
        Map<Object, Object> result = new HashMap<Object, Object>();
        try {
            kiosService.save(pembayaranKios);
            result.put("success", true);
            result.put("data", pembayaranKios);
            result.put("message", "Sukses Save pembayaranKios " + pembayaranKios);
            result.put("status", "oke");
        } catch (DataAccessException e) {
            result.put("success", false);
            result.put("data", pembayaranKios);
            result.put("exception", e.getMessage());
            result.put("message", "Gagal Save pembayaranKios " + pembayaranKios);
        }

        return result;
    }

    @RequestMapping(method = RequestMethod.DELETE, headers = "Accept=application/json")
    public
    @ResponseBody
    Map<String, Object> delete(@RequestParam("id") PembayaranKios pembayaranKios) {
        Map<String, Object> result = new HashMap<String, Object>();
        try {
            kiosService.delete(pembayaranKios);
            result.put("success", true);
            result.put("message", "Sukses Delete pembayaranKios " + pembayaranKios);
        } catch (DataAccessException e) {
            result.put("success", false);
            result.put("exception", e.getMessage());
            result.put("message", "Gagal Delete pembayaranKios " + pembayaranKios);
        }
        return result;
    }

    @RequestMapping(value = "/delete", method = RequestMethod.POST, headers = "Accept=application/json")
    public
    @ResponseBody
    Map<String, Object> deleteMore(@RequestBody PembayaranKios[] pembayaranKioses) {
        Map<String, Object> result = new HashMap<String, Object>();
        try {
            kiosService.deleteMore(pembayaranKioses);
            result.put("success", true);
            result.put("message", "Sukses Delete pembayaranKioses " + pembayaranKioses);
        } catch (DataAccessException e) {
            result.put("success", false);
            result.put("exception", e.getMessage());
            result.put("message", "Gagal Delete pembayaranKioses " + pembayaranKioses);
        }
        return result;
    }

    @RequestMapping(method = RequestMethod.PUT, headers = "Accept=application/json")
    public
    @ResponseBody
    Map<String, Object> update(@RequestBody PembayaranKios pembayaranKioses) {
        if (pembayaranKioses == null) throw new IllegalArgumentException("A Product is required");
        Map<String, Object> result = new HashMap<String, Object>();
        try {
            kiosService.save(pembayaranKioses);
            result.put("success", true);
            result.put("data", pembayaranKioses);
            result.put("message", "Sukses Update pembayaranKioses " + pembayaranKioses);
        } catch (DataAccessException e) {
            result.put("success", false);
            result.put("data", pembayaranKioses);
            result.put("exception", e.getMessage());
            result.put("message", "Gagal update pembayaranKioses " + pembayaranKioses);
        }
        return result;
    }

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        binder.registerCustomEditor(PembayaranKios.class, new PembayaranKiosEditor(kiosService));
    }
}
