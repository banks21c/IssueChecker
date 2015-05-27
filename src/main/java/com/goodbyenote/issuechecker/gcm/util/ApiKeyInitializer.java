package com.goodbyenote.issuechecker.gcm.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import javax.servlet.ServletContextEvent;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.goodbyenote.issuechecker.gcm.service.impl.DatastoreServiceImpl;

public class ApiKeyInitializer {

	public static final String ATTRIBUTE_ACCESS_KEY = "AIzaSyAUTa1H0lJkabHN2xGHQjyVOQdurFNoSSM";

	private static final String PATH = "/api.key";

	private static final Logger logger = LoggerFactory.getLogger(DatastoreServiceImpl.class);

	
	public void contextInitialized(ServletContextEvent event) {
//		logger.info("Reading " + PATH + " from resources (probably from " + "WEB-INF/classes");
//		String key = getKey();
//		event.getServletContext().setAttribute(ATTRIBUTE_ACCESS_KEY, key);
	}

	/**
	 * Gets the access key.
	 */
	protected String getKey() {
		return "AIzaSyAUTa1H0lJkabHN2xGHQjyVOQdurFNoSSM";
//		InputStream stream = Thread.currentThread().getContextClassLoader().getResourceAsStream(PATH);
//		if (stream == null) {
//			throw new IllegalStateException("Could not find file " + PATH + " on web resources)");
//		}
//		BufferedReader reader = new BufferedReader(new InputStreamReader(stream));
//		try {
//			String key = reader.readLine();
//			return key;
//		} catch (IOException e) {
//			throw new RuntimeException("Could not read file " + PATH, e);
//		} finally {
//			try {
//				reader.close();
//			} catch (IOException e) {
//				logger.error("Exception closing " + PATH, e);
//			}
//		}
	}

	public void contextDestroyed(ServletContextEvent event) {
	}
}
