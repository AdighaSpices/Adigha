/**
 *
 */
package com.india.adigha.storefront.filters;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.apache.log4j.Logger;
import org.springframework.web.filter.GenericFilterBean;


/**
 * @author santosh.bomma
 *
 */
public class AdighasTestFilter extends GenericFilterBean
{
	private static final Logger LOG = Logger.getLogger(AdighasTestFilter.class);

	/*
	 * ################# Important ####################
	 *
	 * It is important to call the filterChain.doFilter() method, as without it the filter chain is going to break. A
	 * good practice in some cases could be wrapping the filerChain.doFilter() call in try block and put some required
	 * actions also in finally block: 
	 * 	1. Everything you put before the filterChain.doFilter() method is executed before
	 * the request is finished.
	 * 	2. Everything after that method is executed after the request is finished. It is useful
	 * for deactivating tenants, session, and other.
	 */

	/*
	 * (non-Javadoc)
	 *
	 * @see javax.servlet.Filter#doFilter(javax.servlet.ServletRequest, javax.servlet.ServletResponse,
	 * javax.servlet.FilterChain)
	 */
	@Override
	public void doFilter(final ServletRequest request, final ServletResponse response, final FilterChain filterChain)
			throws IOException, ServletException
	{
		LOG.info("############ Pre Request actions from AdighasTestFilter....   ##############");

		filterChain.doFilter(request, response);

		LOG.info("############ Post request actions from AdighasTestFilter....   ##############...");
	}

}
