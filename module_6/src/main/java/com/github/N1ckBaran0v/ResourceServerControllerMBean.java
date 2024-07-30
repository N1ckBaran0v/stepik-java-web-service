package com.github.N1ckBaran0v;

import resources.TestResource;

public interface ResourceServerControllerMBean {
    TestResource getTestResource();

    void setTestResource(TestResource testResource);
}
