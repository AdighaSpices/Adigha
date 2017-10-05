/*
 * [y] hybris Platform
 *
 * Copyright (c) 2000-2017 SAP SE
 * All rights reserved.
 *
 * This software is the confidential and proprietary information of SAP
 * Hybris ("Confidential Information"). You shall not disclose such
 * Confidential Information and shall use it only in accordance with the
 * terms of the license agreement you entered into with SAP Hybris.
 */
package com.india.adigha.service.user.impl;

import de.hybris.platform.core.model.user.UserGroupModel;
import de.hybris.platform.core.model.user.UserModel;
import de.hybris.platform.servicelayer.user.UserService;

import java.util.Set;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;

import com.india.adigha.core.core.daos.AdighaUserDao;
import com.india.adigha.service.user.AdighaUserService;


/**
 *
 */
public class DefaultAdighaUserService implements AdighaUserService
{
	private static final Logger LOG = Logger.getLogger(DefaultAdighaUserService.class);

	@Resource(name = "userService")
	private UserService userService;

	@Resource(name = "adighaUserDao")
	private AdighaUserDao adighaUserDao;

	@Override
	public UserModel fetchCurrentUser(final HttpServletRequest request)
	{

		final String uid = request.getParameter("uid");
		UserModel user = null;
		if (uid == null)
		{
			user = userService.getCurrentUser();
		}
		else
		{
			user = userService.getUserForUID(uid);
			//user = userService.getUserForUID(uid, UserModel.class);

		}
		final String password = userService.getPassword(user);
		LOG.info("password::: " + password);
		final UserGroupModel userGroup = userService.getUserGroupForUID(uid);
		LOG.info("userGroup::: " + userGroup);
		//final UserGroupModel userGroup = userService.getUserGroupForUID(uid, UserGroupModel.class);
		final Set<UserGroupModel> userGroups = userService.getAllUserGroupsForUser(user);
		LOG.info("userGroups::: " + userGroups);
		//final Set<UserGroupModel> userGroups = userService.getAllUserGroupsForUser(user, UserGroupModel.class);

		return user;
	}

	@Override
	public UserModel fetchUserByEmail(final String email)
	{
		final UserModel user = adighaUserDao.findByEmailId(email);
		return user;
	}

}
