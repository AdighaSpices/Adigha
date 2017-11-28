/*
 * [y] hybris Platform
 *
 * Copyright (c) 2000-2016 SAP SE or an SAP affiliate company.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information of SAP
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with SAP.
 */
package com.india.adigha.initialdata.setup;

import de.hybris.platform.commerceservices.dataimport.impl.CoreDataImportService;
import de.hybris.platform.commerceservices.dataimport.impl.SampleDataImportService;
import de.hybris.platform.commerceservices.setup.AbstractSystemSetup;
import de.hybris.platform.commerceservices.setup.data.ImportData;
import de.hybris.platform.commerceservices.setup.events.CoreDataImportedEvent;
import de.hybris.platform.constants.CoreConstants;
import de.hybris.platform.core.initialization.SystemSetup;
import de.hybris.platform.core.initialization.SystemSetup.Process;
import de.hybris.platform.core.initialization.SystemSetup.Type;
import de.hybris.platform.core.initialization.SystemSetupContext;
import de.hybris.platform.core.initialization.SystemSetupParameter;
import de.hybris.platform.core.initialization.SystemSetupParameterMethod;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Required;

import com.india.adigha.initialdata.constants.AdighaInitialDataConstants;


/**
 * This class provides hooks into the system's initialization and update processes.
 *
 * @see "https://wiki.hybris.com/display/release4/Hooks+for+Initialization+and+Update+Process"
 */
@SystemSetup(extension = AdighaInitialDataConstants.EXTENSIONNAME)
public class InitialDataSystemSetup extends AbstractSystemSetup
{
	@SuppressWarnings("unused")
	private static final Logger LOG = Logger.getLogger(InitialDataSystemSetup.class);

	private static final String IMPORT_CORE_DATA = "importCoreData";
	private static final String IMPORT_SAMPLE_DATA = "importSampleData";
	//private static final String ACTIVATE_SOLR_CRON_JOBS = "activateSolrCronJobs";

	private static final String IMPORT_SYNC_CATALOGS = "syncProducts&ContentCatalogs";
	private static final String ADIGHA = "adighas";

	private CoreDataImportService coreDataImportService;
	private SampleDataImportService sampleDataImportService;



	/**
	 * Generates the Dropdown and Multi-select boxes for the project data import
	 */
	@Override
	@SystemSetupParameterMethod
	public List<SystemSetupParameter> getInitializationOptions()
	{
		final List<SystemSetupParameter> params = new ArrayList<SystemSetupParameter>();

		params.add(createBooleanSystemSetupParameter(IMPORT_CORE_DATA, "Import Core Data", true));
		params.add(createBooleanSystemSetupParameter(IMPORT_SYNC_CATALOGS, "Sync Products & Content Catalogs", true));

		params.add(createBooleanSystemSetupParameter(IMPORT_SAMPLE_DATA, "Import Sample Data", true));
		//params.add(createBooleanSystemSetupParameter(ACTIVATE_SOLR_CRON_JOBS, "Activate Solr Cron Jobs", true));
		// Add more Parameters here as you require

		return params;
	}

	@SystemSetupParameterMethod
	public List<SystemSetupParameter> getSystemSetupParameters()
	{
		final List<SystemSetupParameter> params = new ArrayList<SystemSetupParameter>();

		final SystemSetupParameter customDataParameter = new SystemSetupParameter("createCustomData"); //Single selection box: true/false
		customDataParameter.setLabel("Create custom data?");
		customDataParameter.addValue("true");
		customDataParameter.addValue("false", true);
		params.add(customDataParameter);

		final SystemSetupParameter imports = new SystemSetupParameter("imports"); //Single selection box: list[Strings]
		imports.setMultiSelect(true);
		imports.setLabel("Data to import : ");
		imports.addValue("users", true);
		imports.addValues(new String[]
		{ "groups", "tenants", "grandmas", "grandpas", "uncles" });
		params.add(imports);

		return params;
	}

	/**
	 * Implement this method to create initial objects. This method will be called by system creator during
	 * initialization and system update. Be sure that this method can be called repeatedly.
	 *
	 * @param context
	 *           the context provides the selected parameters and values
	 */
	@SystemSetup(type = Type.ESSENTIAL, process = Process.ALL)
	public void createEssentialData(final SystemSetupContext context)
	{
		// Add Essential Data here as you require

		//The parameters are stored in the map with the prefix <extension>_ to avoid having duplicate parameters.
		LOG.info("-----> createCustomData : " + context.getParameter(CoreConstants.EXTENSIONNAME + "_createCustomData"));
		final boolean customDataParameterTesting = getBooleanSystemSetupParameter(context, "_createCustomData");
		if (customDataParameterTesting)
		{
			//Import necessary impex here
			LOG.info("-----> createCustomData : " + "selected true ::::::: " + customDataParameterTesting);
		}
		else
		{
			LOG.info("-----> createCustomData : " + "selected false ::::::: " + customDataParameterTesting);
		}

		LOG.info("-----> imports :");
		for (final String imp : context.getParameters(context.getExtensionName() + "_core_imports"))
		{
			LOG.info("------------------> " + imp);
		}
	}

	/**
	 * Implement this method to create data that is used in your project. This method will be called during the system
	 * initialization. <br>
	 * Add import data for each site you have configured
	 *
	 * <pre>
	 * final List<ImportData> importData = new ArrayList<ImportData>();
	 *
	 * final ImportData sampleImportData = new ImportData();
	 * sampleImportData.setProductCatalogName(SAMPLE_PRODUCT_CATALOG_NAME);
	 * sampleImportData.setContentCatalogNames(Arrays.asList(SAMPLE_CONTENT_CATALOG_NAME));
	 * sampleImportData.setStoreNames(Arrays.asList(SAMPLE_STORE_NAME));
	 * importData.add(sampleImportData);
	 *
	 * getCoreDataImportService().execute(this, context, importData);
	 * getEventService().publishEvent(new CoreDataImportedEvent(context, importData));
	 *
	 * getSampleDataImportService().execute(this, context, importData);
	 * getEventService().publishEvent(new SampleDataImportedEvent(context, importData));
	 * </pre>
	 *
	 * @param context
	 *           the context provides the selected parameters and values
	 */
	@SystemSetup(type = Type.PROJECT, process = Process.ALL)
	public void createProjectData(final SystemSetupContext context)
	{
		final boolean syncCatalogs = getBooleanSystemSetupParameter(context, IMPORT_SYNC_CATALOGS);

		/*
		 * Add import data for each site you have configured
		 */
		final List<ImportData> importData = new ArrayList<ImportData>();

		final ImportData adighasImportData = new ImportData();
		adighasImportData.setProductCatalogName(ADIGHA);
		adighasImportData.setContentCatalogNames(Arrays.asList(ADIGHA));
		adighasImportData.setStoreNames(Arrays.asList(ADIGHA));
		importData.add(adighasImportData);

		if (getBooleanSystemSetupParameter(context, IMPORT_CORE_DATA))
		{
			getCoreDataImportService().execute(this, context, importData);
			getEventService().publishEvent(new CoreDataImportedEvent(context, importData));

			super.createContentCatalogSyncJob(context, "adighasContentCatalog");
			importImpexFile(context, "/Adighainitialdata/import/coredata/stores/adighas/solr.impex");
			//importImpexFile(context, "/Adighainitialdata/import/coredata/stores/adighas/cart-removal-trigger.impex");
		}

		if (getBooleanSystemSetupParameter(context, IMPORT_SAMPLE_DATA))
		{
			getSampleDataImportService().execute(this, context, importData);
		}

		//		if (getBooleanSystemSetupParameter(context, IMPORT_SAMPLE_CUSTOMER))
		//		{
		//			importCustomerArchive(context);
		//		}

		//		if (getBooleanSystemSetupParameter(context, IMPORT_SAMPLE_PRODUCT))
		//		{
		//			importProductArchive(context);
		//		}

		if (syncCatalogs)
		{
			syncProductCatalog(context, adighasImportData.getProductCatalogName());

			for (final String contentCatalogName : adighasImportData.getContentCatalogNames())
			{
				syncContentCatalog(context, contentCatalogName);
			}
		}
	}

	/**
	 * fires product catalog with synchronization with respect for a dependent CatalogVersionSyncJob
	 */
	private void syncProductCatalog(final SystemSetupContext context, final String productCatalogName)
	{
		executeCatalogSyncJob(context, productCatalogName + "ProductCatalog");
	}

	/**
	 * fires content catalog with synchronization with respect for a depends on CatalogVersionSyncJob
	 *
	 */
	private void syncContentCatalog(final SystemSetupContext context, final String contentCatalogName)
	{
		executeCatalogSyncJob(context, contentCatalogName + "ContentCatalog");
	}


	public CoreDataImportService getCoreDataImportService()
	{
		return coreDataImportService;
	}

	@Required
	public void setCoreDataImportService(final CoreDataImportService coreDataImportService)
	{
		this.coreDataImportService = coreDataImportService;
	}

	public SampleDataImportService getSampleDataImportService()
	{
		return sampleDataImportService;
	}

	@Required
	public void setSampleDataImportService(final SampleDataImportService sampleDataImportService)
	{
		this.sampleDataImportService = sampleDataImportService;
	}
}
