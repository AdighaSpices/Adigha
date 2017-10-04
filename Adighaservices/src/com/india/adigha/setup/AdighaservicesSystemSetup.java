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
package com.india.adigha.setup;

import static com.india.adigha.constants.AdighaservicesConstants.PLATFORM_LOGO_CODE;

import de.hybris.platform.core.initialization.SystemSetup;

import java.io.InputStream;

import com.india.adigha.constants.AdighaservicesConstants;
import com.india.adigha.service.AdighaservicesService;


@SystemSetup(extension = AdighaservicesConstants.EXTENSIONNAME)
public class AdighaservicesSystemSetup
{
	private final AdighaservicesService AdighaservicesService;

	public AdighaservicesSystemSetup(final AdighaservicesService AdighaservicesService)
	{
		this.AdighaservicesService = AdighaservicesService;
	}

	@SystemSetup(process = SystemSetup.Process.INIT, type = SystemSetup.Type.ESSENTIAL)
	public void createEssentialData()
	{
		AdighaservicesService.createLogo(PLATFORM_LOGO_CODE);
	}

	private InputStream getImageStream()
	{
		return AdighaservicesSystemSetup.class.getResourceAsStream("/Adighaservices/sap-hybris-platform.png");
	}
}
