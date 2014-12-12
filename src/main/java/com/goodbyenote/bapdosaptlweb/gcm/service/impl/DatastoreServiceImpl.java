package com.goodbyenote.bapdosaptlweb.gcm.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.goodbyenote.bapdosaptlweb.gcm.service.DatastoreService;

@Service
public class DatastoreServiceImpl implements DatastoreService {
	
	private static final Logger logger = LoggerFactory.getLogger(DatastoreServiceImpl.class);

	private static final List<String> regIds = new ArrayList<String>();
	
	@Override
	public void register(String regId) {
		logger.info("Registering " + regId);
		synchronized (regIds) {
			regIds.add(regId);
		}
	}	
	
	@Override
	public void unregister(String regId) {
		logger.info("Unregistering " + regId);
		synchronized (regIds) {
			regIds.remove(regId);
		}
	}
	
	@Override
	public void updateRegistration(String oldId, String newId) {
		logger.info("Updating " + oldId + " to " + newId);
		synchronized (regIds) {
			regIds.remove(oldId);
			regIds.add(newId);
		}
	}
	
	@Override
	public List<String> getDevices() {
		synchronized (regIds) {
			return new ArrayList<String>(regIds);
		}
	}

}
