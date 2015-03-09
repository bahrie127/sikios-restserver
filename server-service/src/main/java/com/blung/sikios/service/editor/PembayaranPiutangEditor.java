package com.blung.sikios.service.editor;

import com.blung.sikios.domain.PembayaranPiutang;
import com.blung.sikios.service.PiutangService;

import java.beans.PropertyEditorSupport;

/**
 * Created with IntelliJ IDEA.
 * User: saifulbahri
 * Date: 9/20/13
 * Time: 8:41 PM
 * To change this template use File | Settings | File Templates.
 */
public class PembayaranPiutangEditor extends PropertyEditorSupport {
    private PiutangService piutangService;

    public PembayaranPiutangEditor(PiutangService piutangService) {
        this.piutangService = piutangService;
    }

    @Override
    public void setAsText(String text) throws IllegalArgumentException {
        try {
            long id = Long.parseLong(text);

            PembayaranPiutang result = piutangService.findPembayaranPiutang(id);

            if (result != null) {
                setValue(result);
            } else {
                throw new IllegalArgumentException("PembayaranPiutang with id " + id + " not Found!");
            }

        } catch (NumberFormatException ex) {
            throw new IllegalArgumentException(ex.getMessage());
        }
    }

    @Override
    public String getAsText() {
        if (getValue() != null) {
            PembayaranPiutang result = (PembayaranPiutang) getValue();
            return result.getId() + "";
        } else {
            return "";
        }
    }
}
