/**
 *
 */
package com.india.adigha.core.core.daos;

import de.hybris.platform.core.model.user.CustomerModel;
import de.hybris.platform.servicelayer.exceptions.UnknownIdentifierException;
import de.hybris.platform.servicelayer.internal.dao.Dao;


/**
 * @author santosh.bomma
 *
 */
public interface AdighaUserDao extends Dao
{

	public CustomerModel findByEmailId(String email) throws UnknownIdentifierException;

}
