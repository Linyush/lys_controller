package com.linyus.config;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Pattern;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.core.convert.converter.Converter;

/**
 * create by eason on 2018年5月16日
 */
@SpringBootConfiguration
public class ServerConfig {
	
	private Logger logger = LoggerFactory.getLogger(getClass());

	// ======日期转换器起====== //
	private static Pattern pattern1 = Pattern.compile("\\d{4}-\\d{2}-\\d{2}\\s\\d{2}:\\d{2}:\\d{2}");
	private static Pattern pattern2 = Pattern.compile("\\d{4}-\\d{2}-\\d{2}");
	private static Pattern pattern3 = Pattern.compile("\\d{2}-\\d{2}-\\d{2}");
	@Bean
	public Converter<String, Date> strToDate() {
		return new Converter<String, Date>() {
			@Override
			public Date convert(String dateStr) {
				try {
					if (pattern1.matcher(dateStr).find()) return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(dateStr);
					if (pattern2.matcher(dateStr).find()) return new SimpleDateFormat("yyyy-MM-dd").parse(dateStr);
					if (pattern3.matcher(dateStr).find()) return new SimpleDateFormat("HH:mm:ss").parse(dateStr);
				} catch (Exception e) {
					logger.error("日期格式转换异常(string->date)", e);
				}
				return null;
			}
		};
	}
	@Bean
	public Converter<String, Timestamp> strToTimestamp() {
		return new Converter<String, Timestamp>() {
			@Override
			public Timestamp convert(String dateStr) {
				try {
					if (pattern1.matcher(dateStr).find()) return new Timestamp(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(dateStr).getTime());
					if (pattern2.matcher(dateStr).find()) return new Timestamp(new SimpleDateFormat("yyyy-MM-dd").parse(dateStr).getTime());
					if (pattern3.matcher(dateStr).find()) return new Timestamp(new SimpleDateFormat("HH:mm:ss").parse(dateStr).getTime());
				} catch (Exception e) {
					logger.error("日期格式转换异常(string->timestamp)", e);
				}
				return null;
			}
		};
	}
	// ======日期转换器止====== //
}
