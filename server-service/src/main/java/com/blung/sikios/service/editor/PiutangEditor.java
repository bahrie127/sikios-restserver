package com.blung.sikios.service.editor;

import com.blung.sikios.domain.Piutang;
import com.blung.sikios.service.PiutangService;

import java.beans.PropertyEditorSupport;

/**
 * Created with IntelliJ IDEA.
 * User: saifulbahri
 * Date: 9/20/13
 * Time: 8:46 PM
 * To change this template use File | Settings | File Templates.
 */
public class PiutangEditor extends PropertyEditorSupport {
    private PiutangService piutangService;

    public PiutangEditor(PiutangService piutangService) {
        this.piutangService = piutangService;
    }

    @Override
    public void setAsText(String text) throws IllegalArgumentException {
        try {
            long id = Long.parseLong(text);

            Piutang result = piutangService.findPiutang(id);

            if (result != null) {
                setValue(result);
            } else {
                throw new IllegalArgumentException("Piutang with id " + id + " not Found!");
            }

        } catch (NumberFormatException ex) {
            throw new IllegalArgumentException(ex.getMessage());
        }
    }

    @Override
    public String getAsText() {
        if (getValue() != null) {
            Piutang result = (Piutang) getValue();
            return result.getId() + "";
        } else {
            return "";
        }
    }
}
