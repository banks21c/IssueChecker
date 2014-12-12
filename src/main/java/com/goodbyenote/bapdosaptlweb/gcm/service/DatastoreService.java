package com.goodbyenote.bapdosaptlweb.gcm.service;

import java.util.ArrayList;
import java.util.List;

public interface DatastoreService {
	public void register(String regId);
	public void unregister(String regId);
	public void updateRegistration(String oldId, String newId);
	public List<String> getDevices();

}
