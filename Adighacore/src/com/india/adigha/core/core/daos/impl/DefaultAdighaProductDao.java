/**
 *
 */
package com.india.adigha.core.core.daos.impl;

import de.hybris.platform.servicelayer.internal.dao.DefaultGenericDao;

import java.util.List;

import com.india.adigha.core.core.daos.AdighaProductDao;
import com.india.adigha.core.model.AdighaProductModel;


/**
 * @author santosh.bomma
 *
 */
public class DefaultAdighaProductDao extends DefaultGenericDao<AdighaProductModel> implements AdighaProductDao
{

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
		return find();

	}

}
