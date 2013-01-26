package com.gpichot.fungame.resource.service;

import static com.gpichot.fungame.resource.service.ResourceConstants.RESOURCE_BUNDLE_NAME;

import java.util.Locale;
import java.util.ResourceBundle;

/**
 * Service that handles the internationalization of resources.
 */
public class ResourceService {

	private static final ResourceService service = new ResourceService();
	
	private ResourceBundle resourceBundle;
	
	private ResourceService(){
		Locale defaultLocale = Locale.getDefault();
		resourceBundle = ResourceBundle.getBundle(RESOURCE_BUNDLE_NAME, defaultLocale);
	}
	
	public static final ResourceService getService(){
		return service;
	}

	public String getResource(String resourceKey) {
		return resourceBundle.getString(resourceKey);
	}
}
