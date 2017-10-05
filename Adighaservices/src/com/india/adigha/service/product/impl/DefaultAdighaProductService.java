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
package com.india.adigha.service.product.impl;

import de.hybris.platform.catalog.CatalogService;
import de.hybris.platform.catalog.CatalogVersionService;
import de.hybris.platform.catalog.model.CatalogModel;
import de.hybris.platform.catalog.model.CatalogVersionModel;
import de.hybris.platform.core.model.product.ProductModel;
import de.hybris.platform.product.ProductService;
import de.hybris.platform.product.impl.DefaultProductService;
import de.hybris.platform.servicelayer.model.ModelService;

import java.util.List;
import java.util.StringTokenizer;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import com.india.adigha.core.core.daos.AdighaProductDao;
import com.india.adigha.core.model.AdighaProductModel;
import com.india.adigha.service.product.AdighaProductService;


/**
 *
 */
public class DefaultAdighaProductService extends DefaultProductService implements AdighaProductService
{
	@Resource(name = "productService")
	private ProductService productService;

	@Resource(name = "catalogService")
	private CatalogService catalogService;

	@Resource(name = "catalogVersionService")
	private CatalogVersionService catalogVersionService;

	@Resource(name = "modelService")
	private ModelService modelService;

	private AdighaProductDao adighaProductDao;


	CatalogModel catalog = null;
	CatalogVersionModel catalogVersion = null;



	@Override
	public AdighaProductModel fetchProductForCode(final HttpServletRequest request)
	{
		catalogVersionService.setSessionCatalogVersion("adighasProductCatalog", "Online");
		catalogVersion = catalogVersionService.getCatalogVersion("adighasProductCatalog", "Online");
		catalogVersion = catalogVersionService.getSessionCatalogVersionForCatalog("adighasProductCatalog");

		catalog = catalogService.getCatalogForId("adighasProductCatalog");
		//final Collection<CatalogModel> catalogs = catalogService.getAllCatalogs();
		catalog = catalogService.getDefaultCatalog();


		final String code = request.getParameter("code");
		AdighaProductModel product = null;
		if (code != null)
		{
			product = (AdighaProductModel) productService.getProductForCode(code);
			//product = productService.getProductForCode(catalogVersion, code);

		}
		return product;
	}


	@Override
	public List<AdighaProductModel> fetchIsTodaySpecialProducts()
	{
		final List<AdighaProductModel> todaysSpecialProducts = getAdighaProductDao().findTodaySpecialAdighaProducts();

		for (final AdighaProductModel adighaProduct : todaysSpecialProducts)
		{
			if (adighaProduct != null)
			{
				modelService.attach(adighaProduct);
				adighaProduct.setDeliveryTime(Double.valueOf(System.currentTimeMillis()));
				modelService.save(adighaProduct);
			}
		}
		return todaysSpecialProducts;
	}


	@Override
	public AdighaProductModel fetchProductForCode(final String code, final String name)
	{
		final AdighaProductModel adighaProduct = getAdighaProductDao().findProductForCodeAndName(code, name);
		return adighaProduct;
	}

	/*
	 * You can override the productService using spring configuration as mentioned in Adighaservices-spring.xml OR Using
	 * code as below.
	 */
	@Override
	public ProductModel getProductForCode(final String codeName)
	{
		final StringTokenizer token = new StringTokenizer(codeName, ":");
		String code = null;
		String name = null;

		while (token.hasMoreTokens())
		{
			code = token.nextToken();
			name = token.nextToken();
		}

		//Calling super class method
		ProductModel product = super.getProductForCode(code);
		if (product == null)
		{
			product = getAdighaProductDao().findProductForCodeAndName(code, name);
		}
		return product;
	}


	/**
	 * @return the adighaProductDao
	 */
	public AdighaProductDao getAdighaProductDao()
	{
		return adighaProductDao;
	}

	/**
	 * @param adighaProductDao
	 *           the adighaProductDao to set
	 */
	public void setAdighaProductDao(final AdighaProductDao adighaProductDao)
	{
		this.adighaProductDao = adighaProductDao;
	}

}
