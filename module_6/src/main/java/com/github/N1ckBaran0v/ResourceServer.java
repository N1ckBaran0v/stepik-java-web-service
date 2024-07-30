package com.github.N1ckBaran0v;

import resources.TestResource;

public class ResourceServer implements ResourceServerInterface {
    private TestResource testResource = null;

    @Override
    public TestResource getTestResource() {
        return testResource;
    }

    @Override
    public void setTestResource(TestResource testResource) {
        this.testResource = testResource;
    }
}
