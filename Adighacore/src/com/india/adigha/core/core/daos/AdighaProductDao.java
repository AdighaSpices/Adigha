/**
 *
 */
package com.india.adigha.core.core.daos;

import de.hybris.platform.servicelayer.internal.dao.GenericDao;

import java.util.List;

import com.india.adigha.core.model.AdighaProductModel;


/**
 * @author santosh.bomma
 *
 */
public interface AdighaProductDao extends GenericDao<AdighaProductModel>
{
	/**
	 * Finds the list of all AdighaProducts
	 *
	 * @return
	 *
	 */
	List<AdighaProductModel> findAdighaProducts();

	List<AdighaProductModel> findTodaySpecialAdighaProducts();

	AdighaProductModel findProductForCodeAndName(String code, String name);

}
