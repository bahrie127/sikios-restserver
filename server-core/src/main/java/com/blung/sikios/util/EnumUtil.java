package com.secondstack.mgm.util;

import java.util.StringTokenizer;

/**
 * Created by IntelliJ IDEA.
 * User: Latief
 * Date: 10/10/11
 * Time: 11:40 AM
 * To change this template use File | Settings | File Templates.
 */
public final class EnumUtil {

    public static <T extends Enum<T>> T valueOf(Class<T> e, String s) {
        try {
            return Enum.valueOf(e, s);
        } catch (NullPointerException ex) {
            return null;
        } catch (IllegalArgumentException ex) {
            return null;
        }
    }

    public static <T extends Enum<T>> T valueOf(Class<T> e, int index) {
        try {
            return e.getEnumConstants()[index];
        } catch (NullPointerException ex) {
            return null;
        } catch (IllegalArgumentException ex) {
            return null;
        } catch (ArrayIndexOutOfBoundsException ex) {
            return null;
        }
    }

    public static String valueOf(String s) {
        return s.trim().toUpperCase().replace(" ", "_");
    }

    public static String toString(String s) {

        String temp = "";
        StringTokenizer st = new StringTokenizer(s, "_");
        while (st.hasMoreTokens()) {
            String token = st.nextToken();
            temp += " " + token.substring(0, 1).toUpperCase();
            if (token.length() > 1)
                temp += token.substring(1).toLowerCase();
        }

        return temp.trim();
    }
}
