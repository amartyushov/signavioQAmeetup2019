package io.mart.guice;

import com.google.inject.AbstractModule;
import com.typesafe.config.Config;
import com.typesafe.config.ConfigFactory;

public class CustomGuiceModule extends AbstractModule {
	
	@Override
	protected void configure() {
		Config config = ConfigFactory.load();
		
		bind(Config.class).toInstance(config);
	}
}
