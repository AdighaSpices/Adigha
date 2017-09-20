/**
 *
 */
package com.india.adigha.test.groovyscript;

import de.hybris.platform.scripting.engine.ScriptExecutable;
import de.hybris.platform.scripting.engine.ScriptExecutionResult;
import de.hybris.platform.scripting.engine.ScriptingLanguagesService;
import de.hybris.platform.scripting.engine.content.ScriptContent;
import de.hybris.platform.scripting.engine.content.impl.ModelScriptContent;
import de.hybris.platform.scripting.engine.content.impl.ResourceScriptContent;
import de.hybris.platform.scripting.engine.content.impl.SimpleScriptContent;
import de.hybris.platform.scripting.enums.ScriptType;
import de.hybris.platform.scripting.model.ScriptModel;
import de.hybris.platform.servicelayer.model.ModelService;

import java.net.MalformedURLException;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.UrlResource;


/**
 * @author santosh.bomma
 *
 */
public class SampleGroovyScriptClass
{
	
	//Sample Groovy Script
	/*
	 import de.hybris.platform.servicelayer.search.FlexibleSearchQuery

	flexibleSearchService = spring.getBean "flexibleSearchService"
	mimeService = spring.getBean "mimeService"
	modelService = spring.getBean "modelService"
	def findMediasWithoutMime() {
		query = new FlexibleSearchQuery("SELECT {PK} FROM {AdighaProductModel} WHERE {ISTODAYSPECIAL} IS NULL")
		
		flexibleSearchService.search(query).result
	}
	findMediasWithoutMime().each {
		it.mime = mimeService.getMimeFromFileExtension(it.name)
		
		modelService.save it
	}
	*/

	final String content = "import de.hybris.platform.servicelayer.search.FlexibleSearchQuery"
			+ "flexibleSearchService = spring.getBean \"flexibleSearchService\""
			+ "mimeService = spring.getBean \"mimeService\""
			+ "modelService = spring.getBean \"modelService\""
			+ "def findMediasWithoutMime() {"
			+ "query = new FlexibleSearchQuery(\"SELECT {PK} FROM {AdighaProductModel} WHERE {ISTODAYSPECIAL} IS NULL\")"
			+ "flexibleSearchService.search(query).result"
			+ "}"
			+ "findMediasWithoutMime().each {"
			+ "it.mime = mimeService.getMimeFromFileExtension(it.name)"
			+ "modelService.save it";
	
	@Resource(name = "scriptingLanguagesService")
	private ScriptingLanguagesService scriptingLanguagesService;

	@Resource(name = "modelService")
	private ModelService modelService;

	/*
	 * Method 1: using SimpleScriptContent class
	 */
	public void testAdighasProductNameUsingSimpleScriptContent()
	{
		final String engineName = "groovy";

		// Let's assume we have scriptingLanguagesService injected by Spring
		final ScriptContent scriptContent = new SimpleScriptContent(engineName, content);
		final ScriptExecutable executable = scriptingLanguagesService.getExecutableByContent(scriptContent);

		// now we can execute script
		final ScriptExecutionResult result = executable.execute();

		// to obtain result of execution
		System.out.println(result.getScriptResult());
	}
	
	

	/*
	 * Method 2: using ResourceScriptContent class
	 */
	public void testAdighasProductNameUsingResourceScriptContent()
	{
		final org.springframework.core.io.Resource resource = new FileSystemResource("getAdighasProductNames.groovy");
		

		// Let's assume we have scriptingLanguagesService injected by the Spring
		final ScriptContent scriptContent = new ResourceScriptContent(resource);
		final ScriptExecutable executable = scriptingLanguagesService.getExecutableByContent(scriptContent);
		 
		// now we can execute script
		final ScriptExecutionResult result = executable.execute();
		 
		// to obtain result of execution 
		System.out.println(result.getScriptResult());
	}
	
	

	/*
	 * Method 3: using ClassPathResource class
	 */
	public void testAdighasProductNameUsingClassPathResource()
	{
		final org.springframework.core.io.Resource resource = new ClassPathResource("getAdighasProductNames.groovy");

		// Let's assume we have scriptingLanguagesService injected by the Spring
		final ScriptContent scriptContent = new ResourceScriptContent(resource);
		final ScriptExecutable executable = scriptingLanguagesService.getExecutableByContent(scriptContent);
		 
		// now we can execute script
		final ScriptExecutionResult result = executable.execute();
		 
		// to obtain result of execution 
		System.out.println(result.getScriptResult());
	}
	

	/*
	 * Method 4: Executing Scripts Stored Remotely
	 */
	public void testAdighasProductNameStoredRemotely() throws MalformedURLException
	{
		final org.springframework.core.io.Resource resource = new UrlResource("https://github.com/AdighaSpices/Adigha/getAdighasProductNames.groovy");

		// Let's assume we have scriptingLanguagesService injected by the Spring
		final ScriptContent scriptContent = new ResourceScriptContent(resource);
		final ScriptExecutable executable = scriptingLanguagesService.getExecutableByContent(scriptContent);
		 
		// now we can execute script
		final ScriptExecutionResult result = executable.execute();
		 
		// to obtain result of execution 
		System.out.println(result.getScriptResult());
	}
	
	/*
	 * Method 5: using ModelScriptContent class
	 * 
	 * Model-based scripts can be autodisabled. This comes in handy if a script throws an execution exception. 
	 * In that case, the status of an autodisabling script changes to disabled. 
	 * Otherwise, a faulty script would endlessly throw execution exceptions.
	 * 
	 * ScriptModel has two boolean properties: autodisabling and disabled. Both are by default set to false. To enable the auto-disabling feature, 
	 * set ScriptModel#autodisabling item property to true. You can also use the HMC to set Autodisabling to True.
	 * 
	 * If you want to re-enable the script for execution, go to the HMC, find the corresponding ScriptModel in Scripts section and change the flag disabled to false.
	 */
	public void testAdighasProductNameUsingModelScriptContent()
	{
	// Let's assume we have modelService injected by the Spring
		final ScriptModel script = modelService.create(ScriptModel.class);
		script.setScriptType(ScriptType.GROOVY);
		script.setContent(".... content of the script ...");
		// code must be unique
		script.setCode("setMimesForMedias");
		modelService.save(script);
		 
		// now having our model we can wrap it using ModelScriptContent
		final ScriptContent scriptContent = new ModelScriptContent(script);
		final ScriptExecutable executable = scriptingLanguagesService.getExecutableByContent(scriptContent);
		 
		// now we can execute script
		final ScriptExecutionResult result = executable.execute();
		 
		// to obtain result of execution 
		System.out.println(result.getScriptResult());
	}
	
	/*
	 * Method 6: using scriptURI - Script Repository
	 * 
	 * Writing only sudo code
	 */
	public void testAdighasProductNameUsingscriptURI()
	{
		
		//ModelScriptsRepository
		//model://uniqueCodeOfScript
		final ScriptExecutable executable = scriptingLanguagesService.getExecutableByURI("model://getAdighasProductNames");	

		//ClasspathScriptsRepository
		//classpath://path/to/uniqueCodeOfScript.groovy
		final ScriptExecutable executable1 = scriptingLanguagesService.getExecutableByURI("classpath://scripts/getAdighasProductNames.groovy");	

		//FileSystemScriptsRepository
		//file://c:/absolute/path/to/uniqueCodeOfScript.groovy
		final ScriptExecutable executable2 = scriptingLanguagesService.getExecutableByURI("file:///Users/zeus/scripts/getAdighasProductNames.groovy");	

		//RemoteScriptsRepository
		//http:///server.com/path/to/uniqueCodeOfScript.groovy
		//https:///server.com/path/to/uniqueCodeOfScript.groovy
		//ftp:///server.com/path/to/uniqueCodeOfScript.groovy
		final ScriptExecutable executable3 = scriptingLanguagesService.getExecutableByURI("http:///server.com/scripts/getAdighasProductNames.groovy");

		System.out.println(executable);
		System.out.println(executable1);
		System.out.println(executable2);
		System.out.println(executable3);
		
		// now we can execute script
		final ScriptExecutionResult result = executable.execute();
		 
		// to obtain result of execution 
		System.out.println(result.getScriptResult());
	
	}
	
	/*
	 * Method 7: using Arguments 
	 */
	public void testAdighasProductNameUsingArguments()
	{
		final ScriptExecutable executable = scriptingLanguagesService.getExecutableByURI("classpath://scripts/setMimesForMedias.groovy");
		final Map<String, Object> params = new HashMap<>();
		// here we pass arguments into the hashmap. 
		params.put("realfilename", "%.xml"); 
		// now we can execute script
		final ScriptExecutionResult result = executable.execute(params);
		 
		// to obtain result of execution 
		System.out.println(result.getScriptResult());
	}
}
