package com.stounio.fungame.ui.service;

import junit.framework.Assert;

import org.junit.Test;

import com.stounio.fungame.resource.FunGameConstants;
import com.stounio.fungame.resource.service.ResourceService;

public class ResourceServiceTest {

    @Test
    public void should_retrieve_the_resource_from_the_resource_service() {
        String resource = ResourceService.getService().getResource(FunGameConstants.FUNGAME_TITLE_KEY);
        Assert.assertNotNull(resource);
        Assert.assertNotSame(FunGameConstants.FUNGAME_TITLE_KEY, resource);
    }
}
