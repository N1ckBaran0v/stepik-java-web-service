package com.github.N1ckBaran0v;

import resources.TestResource;

public class ResourceServerController implements ResourceServerControllerMBean {
    private final ResourceServerInterface resourceServer;

    public ResourceServerController(ResourceServerInterface resourceServer) {
        this.resourceServer = resourceServer;
    }

    @Override
    public TestResource getTestResource() {
        return resourceServer.getTestResource();
    }

    @Override
    public void setTestResource(TestResource testResource) {
        resourceServer.setTestResource(testResource);
    }
}
