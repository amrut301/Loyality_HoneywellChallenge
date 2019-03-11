package com.loyality.bo.listener;

import org.hibernate.HibernateException;
import org.hibernate.event.spi.LoadEvent;
import org.hibernate.event.spi.LoadEventListener;

public class LoadEventListenerLoyality implements LoadEventListener{

	@Override
	public void onLoad(LoadEvent event, LoadType loadType) throws HibernateException {
		
	}

}
