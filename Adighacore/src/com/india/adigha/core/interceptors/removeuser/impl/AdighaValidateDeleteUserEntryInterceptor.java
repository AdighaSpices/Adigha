/**
 *
 */
package com.india.adigha.core.interceptors.removeuser.impl;

import de.hybris.platform.servicelayer.interceptor.InterceptorContext;
import de.hybris.platform.servicelayer.interceptor.InterceptorException;
import de.hybris.platform.servicelayer.interceptor.ValidateInterceptor;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;

import com.india.adigha.core.model.AdighaDeletedUserEntryModel;


/**
 * @author santosh.bomma
 *
 */
public class AdighaValidateDeleteUserEntryInterceptor implements ValidateInterceptor<AdighaDeletedUserEntryModel>
{
	private static final Logger LOG = Logger.getLogger(AdighaValidateDeleteUserEntryInterceptor.class);

	/*
	 * (non-Javadoc)
	 *
	 * @see de.hybris.platform.servicelayer.interceptor.ValidateInterceptor#onValidate(java.lang.Object,
	 * de.hybris.platform.servicelayer.interceptor.InterceptorContext)
	 */
	@Override
	public void onValidate(final AdighaDeletedUserEntryModel deletedUserEntry, final InterceptorContext context)
			throws InterceptorException
	{
		LOG.info(":::::::: AdighaValidateDeleteUserEntryInterceptor Starts :::::::::");

		final AdighaDeletedUserEntryModel auditEntry = deletedUserEntry;
		if (StringUtils.isEmpty(auditEntry.getUid()))
		{
			LOG.error("Exception caught due to empty userId...");
			throw new InterceptorException("Deleted User entries cannot have empty userId");
		}
		LOG.info(":::::::: AdighaValidateDeleteUserEntryInterceptor Ends :::::::::");

	}
}
