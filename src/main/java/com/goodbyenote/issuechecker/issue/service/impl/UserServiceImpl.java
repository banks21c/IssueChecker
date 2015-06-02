package com.goodbyenote.issuechecker.issue.service.impl;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.goodbyenote.issuechecker.issue.dao.UserDAO;
import com.goodbyenote.issuechecker.issue.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserDAO userDAO;

	@Override
	public Map<?, ?> getLoginUser(Map<?, ?> param) {
		return userDAO.getLoginUser(param);
	}

}
