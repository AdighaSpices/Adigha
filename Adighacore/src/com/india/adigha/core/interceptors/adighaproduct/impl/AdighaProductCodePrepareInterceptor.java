/**
 *
 */
package com.india.adigha.core.interceptors.adighaproduct.impl;

import de.hybris.platform.servicelayer.interceptor.InterceptorContext;
import de.hybris.platform.servicelayer.interceptor.InterceptorException;
import de.hybris.platform.servicelayer.interceptor.PrepareInterceptor;
import de.hybris.platform.servicelayer.interceptor.ValidateInterceptor;

import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;

import com.india.adigha.core.core.daos.AdighaProductDao;
import com.india.adigha.core.model.AdighaProductModel;


/**
 * @author santosh.bomma
 *
 */
public class AdighaProductCodePrepareInterceptor
		implements PrepareInterceptor<AdighaProductModel>, ValidateInterceptor<AdighaProductModel>
{
	private static final Logger LOG = Logger.getLogger(AdighaProductCodePrepareInterceptor.class);

	private static final String PRODUCT_PREFIX = "P";

	@Resource(name = "adighaProductDao")
	AdighaProductDao adighaProductDao;

	/*
	 * (non-Javadoc)
	 *
	 * @see de.hybris.platform.servicelayer.interceptor.PrepareInterceptor#onPrepare(java.lang.Object,
	 * de.hybris.platform.servicelayer.interceptor.InterceptorContext)
	 */
	@Override
	public void onPrepare(final AdighaProductModel adighaProduct, final InterceptorContext context) throws InterceptorException
	{
		LOG.info(":::::::: AdighaProductCodePrepareInterceptor onPrepare method Starts :::::::::");

		if (StringUtils.isBlank(adighaProduct.getCode()) || StringUtils.isBlank(adighaProduct.getName()))
		{
			final StringBuffer productCode = new StringBuffer();

			final List<AdighaProductModel> products = adighaProductDao.findAdighaProducts();
			int numberOfProducts = 0;
			if (CollectionUtils.isNotEmpty(products))
			{
				numberOfProducts = products.size() / 2; //Retrieving products from both Staged and Online CatalogVersion
				//TODO Should work on retrieving only products from Staged CatalogVersion
				LOG.debug("numberOfProducts/2 = " + numberOfProducts);
			}

			productCode.append(PRODUCT_PREFIX).append(++numberOfProducts);
			if (StringUtils.isBlank(adighaProduct.getCode()))
			{
				adighaProduct.setCode(productCode.toString());
			}
			if (StringUtils.isBlank(adighaProduct.getName()))
			{
				adighaProduct.setName(productCode.toString());
			}
			LOG.info(":::::::: AdighaProductCodePrepareInterceptor onPrepare method Ends :::::::::");

		}
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see de.hybris.platform.servicelayer.interceptor.ValidateInterceptor#onValidate(java.lang.Object,
	 * de.hybris.platform.servicelayer.interceptor.InterceptorContext)
	 */
	@Override
	public void onValidate(final AdighaProductModel adighaProduct, final InterceptorContext context) throws InterceptorException
	{
		LOG.info(":::::::: AdighaProductCodePrepareInterceptor onValidate method Starts :::::::::");

		if (StringUtils.isEmpty(adighaProduct.getCode()))
		{
			throw new InterceptorException("Product code cannot be empty....");
		}
		LOG.info(":::::::: AdighaProductCodePrepareInterceptor onValidate method Ends :::::::::");

	}

}
