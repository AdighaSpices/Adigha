/**
 *
 */
package com.india.adigha.core.core.daos.impl;

import de.hybris.platform.core.model.product.ProductModel;
import de.hybris.platform.servicelayer.exceptions.AmbiguousIdentifierException;
import de.hybris.platform.servicelayer.exceptions.UnknownIdentifierException;
import de.hybris.platform.servicelayer.internal.dao.DefaultGenericDao;
import de.hybris.platform.servicelayer.search.FlexibleSearchQuery;
import de.hybris.platform.servicelayer.search.FlexibleSearchService;
import de.hybris.platform.servicelayer.search.SearchResult;

import java.util.List;

import javax.annotation.Resource;

import com.india.adigha.core.core.daos.AdighaProductDao;
import com.india.adigha.core.model.AdighaProductModel;


/**
 * @author santosh.bomma
 *
 */
public class DefaultAdighaProductDao extends DefaultGenericDao<AdighaProductModel> implements AdighaProductDao
{
	@Resource(name = "flexibleSearchService")
	private FlexibleSearchService flexibleSearchService;

	private static final String ISTODAYS_SPECIAL_PRODUCTS = "SELECT {PK} FROM {AdighaProduct} WHERE {isTodaySpecial} = true";

	/**
	 * @param typecode
	 */
	public DefaultAdighaProductDao(final String typecode)
	{
		super(typecode);
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see com.india.adigha.core.core.daos.AdighaProductDao#findAdighaProducts()
	 */
	@Override
	public List<AdighaProductModel> findAdighaProducts()
	{
		//TODO to retrieve products based on Staged or Online CatalogVersion
		return find();
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see com.india.adigha.core.core.daos.AdighaProductDao#findTodaySpecialAdighaProducts()
	 */
	@Override
	public List<AdighaProductModel> findTodaySpecialAdighaProducts()
	{
		final FlexibleSearchQuery query = new FlexibleSearchQuery(ISTODAYS_SPECIAL_PRODUCTS);
		final SearchResult<AdighaProductModel> result = this.flexibleSearchService.search(query);
		final int resultCount = result.getTotalCount();
		if (resultCount == 0)
		{
			throw new UnknownIdentifierException("No special dishes today!");
		}
		else if (resultCount > 1)
		{
			throw new AmbiguousIdentifierException("Product with code is not unique, " + resultCount + " requests found!");
		}
		return result.getResult();
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see com.india.adigha.core.core.daos.AdighaProductDao#findProductForCodeAndName(java.lang.String,
	 * java.lang.String)
	 */
	@Override
	public AdighaProductModel findProductForCodeAndName(final String code, final String name)
	{
		final FlexibleSearchQuery query = new FlexibleSearchQuery(
				"SELECT {pk} FROM {Product} WHERE " + "{code}=?code AND {name} LIKE %?name%");
		query.addQueryParameter(ProductModel.CODE, code);
		query.addQueryParameter(ProductModel.NAME, name);
		final SearchResult<ProductModel> result = this.flexibleSearchService.search(query);
		final int resultCount = result.getTotalCount();
		if (resultCount == 0)
		{
			throw new UnknownIdentifierException("Product not found!");
		}
		else if (resultCount > 1)
		{
			throw new AmbiguousIdentifierException("Product code and name is not unique!");
		}
		return (AdighaProductModel) result.getResult().get(0);
	}

}
