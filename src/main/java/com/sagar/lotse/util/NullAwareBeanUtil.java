package com.sagar.lotse.util;


import org.apache.commons.beanutils.BeanUtilsBean;

import java.lang.reflect.InvocationTargetException;

public class NullAwareBeanUtil extends BeanUtilsBean {

    public void copyProperties(Object target, Object source)
            throws InvocationTargetException, IllegalAccessException {
        if (source == null) return;
        if (source instanceof String) {
            source = String.valueOf(source).trim();
        }
        super.copyProperties(target, source);
    }
}
