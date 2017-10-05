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
package com.india.adigha.service.user;

import de.hybris.platform.core.model.user.UserModel;

import javax.servlet.http.HttpServletRequest;


/**
 *
 */
public interface AdighaUserService
{
	public UserModel fetchCurrentUser(HttpServletRequest request);

	public UserModel fetchUserByEmail(String email);

}
