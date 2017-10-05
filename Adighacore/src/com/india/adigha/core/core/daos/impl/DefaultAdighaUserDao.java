/**
 *
 */
package com.india.adigha.core.core.daos.impl;

import de.hybris.platform.core.model.user.CustomerModel;
import de.hybris.platform.servicelayer.exceptions.UnknownIdentifierException;
import de.hybris.platform.servicelayer.internal.dao.AbstractItemDao;
import de.hybris.platform.servicelayer.search.FlexibleSearchQuery;
import de.hybris.platform.servicelayer.search.FlexibleSearchService;
import de.hybris.platform.servicelayer.search.SearchResult;

import javax.annotation.Resource;

import org.apache.commons.collections.CollectionUtils;

import com.india.adigha.core.core.daos.AdighaUserDao;


/**
 * @author santosh.bomma
 *
 */
public class DefaultAdighaUserDao extends AbstractItemDao implements AdighaUserDao
{
	@Resource(name = "flexibleSearchService")
	private FlexibleSearchService flexibleSearchService;

	/*
	 * (non-Javadoc)
	 *
	 * @see com.india.adigha.core.core.daos.AdighaUserDao#findByEmailId(java.lang.String)
	 */
	@Override
	public CustomerModel findByEmailId(final String email) throws UnknownIdentifierException
	{
		CustomerModel customer = null;
		final String queryString = String.format("SELECT {%s} FROM {%s} WHERE {%s} = ?sender", CustomerModel.PK, "CustomerModel",
				CustomerModel.CONTACTEMAIL);
		final FlexibleSearchQuery query = new FlexibleSearchQuery(queryString);
		query.addQueryParameter("contactEmail", email);
		final SearchResult<CustomerModel> result = flexibleSearchService.search(query);
		if (CollectionUtils.isNotEmpty(result.getResult()))
		{
			customer = result.getResult().get(0);
		}
		else
		{
			throw new UnknownIdentifierException("Customer with email : '" + email + "' not found");
		}
		return customer;
	}

}
