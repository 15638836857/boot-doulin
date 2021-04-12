package com.doulin.admin.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.convert.converter.Converter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author malingbing
 */
@Configuration
@Slf4j
public class DateConverConfig {
    @Bean
    public Converter<String, Date> stringDateConvert() {
        return new Converter<String, Date>() {
            @Override
            public Date convert(String source) {
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                Date date = null;
                try {
                    date = sdf.parse((String) source);
                } catch (Exception e) {
                    SimpleDateFormat sdfday = new SimpleDateFormat("yyyy-MM-dd");
                    try {
                        date = sdfday.parse((String) source);
                    } catch (ParseException e1) {
                       log.error(e1.getMessage());
                    }
                }
                return date;
            }
        };
    }

}
