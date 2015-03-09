package com.blung.sikios.service.editor;

import com.blung.sikios.domain.Hutang;
import com.blung.sikios.service.HutangService;

import java.beans.PropertyEditorSupport;

/**
 * Created with IntelliJ IDEA.
 * User: saifulbahri
 * Date: 9/19/13
 * Time: 10:03 PM
 * To change this template use File | Settings | File Templates.
 */
public class HutangEditor extends PropertyEditorSupport {
    private HutangService hutangService;

    public HutangEditor(HutangService hutangService) {
        this.hutangService = hutangService;
    }

    @Override
    public void setAsText(String text) throws IllegalArgumentException {
        try {
            long id = Long.parseLong(text);

            Hutang result = hutangService.findHutang(id);

            if (result != null) {
                setValue(result);
            } else {
                throw new IllegalArgumentException("Hutang with id " + id + " not Found!");
            }

        } catch (NumberFormatException ex) {
            throw new IllegalArgumentException(ex.getMessage());
        }
    }

    @Override
    public String getAsText() {
        if (getValue() != null) {
            Hutang result = (Hutang) getValue();
            return result.getId() + "";
        } else {
            return "";
        }
    }
}
