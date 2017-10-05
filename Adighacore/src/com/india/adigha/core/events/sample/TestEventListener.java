/**
 *
 */
package com.india.adigha.core.events.sample;

import de.hybris.platform.servicelayer.event.events.AbstractEvent;
import de.hybris.platform.servicelayer.event.impl.AbstractEventListener;


/**
 * @author santosh.bomma
 *
 */
public class TestEventListener extends AbstractEventListener
{

	/*
	 * (non-Javadoc)
	 *
	 * @see
	 * de.hybris.platform.servicelayer.event.impl.AbstractEventListener#onEvent(de.hybris.platform.servicelayer.event.
	 * events.AbstractEvent)
	 */
	@Override
	protected void onEvent(final AbstractEvent event)
	{
		if (event instanceof TestEvent)
		{
			System.out.println("Got a TestEvent with the object " + event.getSource());
		}
		else
		{
			System.out.println("Found other event object " + event.getSource());
		}

	}

}
