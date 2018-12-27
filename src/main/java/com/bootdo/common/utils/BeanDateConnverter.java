package com.bootdo.common.utils;

import org.apache.commons.beanutils.Converter;
import org.apache.commons.lang3.time.DateUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Date;

public class BeanDateConnverter implements Converter {
    private static final Logger logger = LoggerFactory.getLogger(BeanDateConnverter.class);
    public static final String[] ACCEPT_DATE_FORMATS = new String[]{"yyyy-MM-dd HH:mm:ss", "yyyy-MM-dd"};

    public BeanDateConnverter() {
    }

    public Object convert(Class arg0, Object value) {
        if (value instanceof Date) {
            return value;
        } else {
            logger.debug("conver " + value + " to date object");
            if (value == null) {
                return null;
            } else {
                String dateStr = value.toString();
                dateStr = dateStr.replace("T", " ");

                try {
                    return DateUtils.parseDate(dateStr, ACCEPT_DATE_FORMATS);
                } catch (Exception var5) {
                    logger.debug("parse date error:" + var5.getMessage());
                    return null;
                }
            }
        }
    }

}
