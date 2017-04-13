/*
 * [y] hybris Platform
 * 
 * Copyright (c) 2000-2016 SAP SE
 * All rights reserved.
 * 
 * This software is the confidential and proprietary information of SAP 
 * Hybris ("Confidential Information"). You shall not disclose such 
 * Confidential Information and shall use it only in accordance with the 
 * terms of the license agreement you entered into with SAP Hybris.
 */
package com.india.setup;

import static com.india.constants.AdighahmcConstants.PLATFORM_LOGO_CODE;

import de.hybris.platform.core.initialization.SystemSetup;

import java.io.InputStream;

import com.india.constants.AdighahmcConstants;
import com.india.service.AdighahmcService;


@SystemSetup(extension = AdighahmcConstants.EXTENSIONNAME)
public class AdighahmcSystemSetup
{
	private final AdighahmcService AdighahmcService;

	public AdighahmcSystemSetup(final AdighahmcService AdighahmcService)
	{
		this.AdighahmcService = AdighahmcService;
	}

	@SystemSetup(process = SystemSetup.Process.INIT, type = SystemSetup.Type.ESSENTIAL)
	public void createEssentialData()
	{
		AdighahmcService.createLogo(PLATFORM_LOGO_CODE);
	}

	private InputStream getImageStream()
	{
		return AdighahmcSystemSetup.class.getResourceAsStream("/Adighahmc/sap-hybris-platform.png");
	}
}
