package com.secondstack.mgm.util;

import org.hibernate.Query;

/**
 * Created by IntelliJ IDEA.
 * User: Latief
 * Date: 11/29/11
 * Time: 2:09 PM
 * To change this template use File | Settings | File Templates.
 */
public final class HibernateUtil {
    public static Query createQueryResultPagination(Query query, int first, int max) {
        if (first >= 0) {
            query = query.setFirstResult(first);
        }
        if (max > 0) {
            query = query.setMaxResults(max);
        }
        return query;
    }
}
