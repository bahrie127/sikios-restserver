package com.blung.sikios.service.editor;

import com.blung.sikios.domain.Penjualan;
import com.blung.sikios.service.PenjualanService;

import java.beans.PropertyEditorSupport;

/**
 * Created with IntelliJ IDEA.
 * User: saifulbahri
 * Date: 9/20/13
 * Time: 8:44 PM
 * To change this template use File | Settings | File Templates.
 */
public class PenjualanEditor extends PropertyEditorSupport {
    private PenjualanService penjualanService;

    public PenjualanEditor(PenjualanService penjualanService) {
        this.penjualanService = penjualanService;
    }

    @Override
    public void setAsText(String text) throws IllegalArgumentException {
        try {
            long id = Long.parseLong(text);

            Penjualan result = penjualanService.findPenjualan(id);

            if (result != null) {
                setValue(result);
            } else {
                throw new IllegalArgumentException("Penjualan with id " + id + " not Found!");
            }

        } catch (NumberFormatException ex) {
            throw new IllegalArgumentException(ex.getMessage());
        }
    }

    @Override
    public String getAsText() {
        if (getValue() != null) {
            Penjualan result = (Penjualan) getValue();
            return result.getId() + "";
        } else {
            return "";
        }
    }
}
