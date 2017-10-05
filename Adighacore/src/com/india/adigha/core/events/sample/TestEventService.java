/**
 *
 */
package com.india.adigha.core.events.sample;

import de.hybris.platform.servicelayer.event.EventService;

import org.springframework.beans.factory.annotation.Autowired;


/**
 * @author santosh.bomma
 *
 */
public class TestEventService
{
	@Autowired
	private EventService eventService;

	protected void something()
	{
		//	    if( something )
		//	    {
		final TestEventListener listener = new TestEventListener();
		eventService.registerEventListener(listener);

		final TestEvent event = new TestEvent("First Event class");
		eventService.publishEvent(event);
		//	    }
	}
}
