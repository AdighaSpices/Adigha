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
package com.india.adigha.service.product;

import de.hybris.platform.core.model.product.ProductModel;
import de.hybris.platform.product.ProductService;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.india.adigha.core.model.AdighaProductModel;


/**
 *
 */
public interface AdighaProductService extends ProductService
{
	AdighaProductModel fetchProductForCode(HttpServletRequest request);

	List<AdighaProductModel> fetchIsTodaySpecialProducts();

	AdighaProductModel fetchProductForCode(String code, String name);

	@Override
	ProductModel getProductForCode(String code);

}
