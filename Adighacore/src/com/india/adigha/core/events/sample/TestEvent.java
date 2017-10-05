/**
 *
 */
package com.india.adigha.core.events.sample;

import de.hybris.platform.servicelayer.event.ClusterAwareEvent;
import de.hybris.platform.servicelayer.event.TransactionAwareEvent;
import de.hybris.platform.servicelayer.event.events.AbstractEvent;

import java.io.Serializable;


/**
 * @author santosh.bomma
 *
 */
public class TestEvent extends AbstractEvent implements ClusterAwareEvent, TransactionAwareEvent
{
	Object source;

	public TestEvent(final Serializable source)
	{
		super(source);
		this.source = source;
	}

	/**
	 * ClusterAwareEvent methods Starts
	 */
	/*
	 * (non-Javadoc)
	 *
	 * @see de.hybris.platform.servicelayer.event.ClusterAwareEvent#publish(int, int)
	 */
	@Override
	public boolean publish(final int sourceNodeId, final int targetNodeId)
	{
		//decide from and to which clusternode this event should be sent
		return targetNodeId == 12; //broadcast to cluster node 12 only
		//return sourceNodeId < 5 && targetNodeId >= 5; //broadcast any event from any cluster node 1-4 to the cluster nodes 5-?
		//return true; //broadcast from all to all cluster nodes
	}

	/**
	 * ClusterAwareEvent methods Ends
	 */

	/**
	 * TransactionAwareEvent methods Starts
	 */
	/*
	 * (non-Javadoc)
	 *
	 * @see de.hybris.platform.servicelayer.event.TransactionAwareEvent#getId()
	 */
	@Override
	public Object getId()
	{
		// YTODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see de.hybris.platform.servicelayer.event.TransactionAwareEvent#publishOnCommitOnly()
	 */
	@Override
	public boolean publishOnCommitOnly()
	{
		// YTODO Auto-generated method stub
		return false;
	}
	/**
	 * TransactionAwareEvent methods Ends
	 */
}
