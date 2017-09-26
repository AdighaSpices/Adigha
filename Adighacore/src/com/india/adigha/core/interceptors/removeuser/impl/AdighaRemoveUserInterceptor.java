/**
 *
 */
package com.india.adigha.core.interceptors.removeuser.impl;

import de.hybris.platform.core.model.user.UserModel;
import de.hybris.platform.servicelayer.interceptor.InterceptorContext;
import de.hybris.platform.servicelayer.interceptor.InterceptorException;
import de.hybris.platform.servicelayer.interceptor.PersistenceOperation;
import de.hybris.platform.servicelayer.interceptor.RemoveInterceptor;

import java.util.Date;

import org.apache.log4j.Logger;

import com.india.adigha.core.model.AdighaDeletedUserEntryModel;


/**
 * @author santosh.bomma
 *
 */
public class AdighaRemoveUserInterceptor implements RemoveInterceptor<UserModel>
{
	private static final Logger LOG = Logger.getLogger(AdighaRemoveUserInterceptor.class);

	/*
	 * (non-Javadoc)
	 *
	 * @see de.hybris.platform.servicelayer.interceptor.RemoveInterceptor#onRemove(java.lang.Object,
	 * de.hybris.platform.servicelayer.interceptor.InterceptorContext)
	 */
	@Override
	public void onRemove(final UserModel user, final InterceptorContext context) throws InterceptorException
	{
		LOG.info(":::::::: AdighaRemoveUserInterceptor Starts :::::::::");
		final AdighaDeletedUserEntryModel deletedUserEntry = context.getModelService().create(AdighaDeletedUserEntryModel.class);
		deletedUserEntry.setChangeTimestamp(new Date());
		deletedUserEntry.setDisplayName(user.getDisplayName());
		deletedUserEntry.setName(user.getName());
		deletedUserEntry.setUid(user.getUid());
		context.registerElementFor(deletedUserEntry, PersistenceOperation.SAVE);
		LOG.info(":::::::: AdighaRemoveUserInterceptor Ends :::::::::");

	}
}
