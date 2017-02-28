package com.grommitz.twodbs;

import org.glassfish.jersey.jackson.JacksonFeature;
import org.glassfish.jersey.server.ResourceConfig;

import javax.ws.rs.ApplicationPath;


@ApplicationPath("rest")
public class JerseyApp extends ResourceConfig {

	public JerseyApp() {
		super();
		packages(true, "com.grommitz.twodbs");
		register(JacksonFeature.class);
		//register(JsonProvider.class);
		//register(RolesAllowedDynamicFeature.class);
		//register(new AuthorizationFilterFeature());
		//register(new SubjectFactory());
		//register(new AuthInjectionBinder());
	}

}
