package com.ethermiu.enrolmentmanagement.exception;

public class NoSuchResourceException extends Throwable{
    private static final long serialVersionUID = 1L;

    private long resourceId;
    private String resourceType;

    public NoSuchResourceException(String resourceType, long resourceId) {
        super();
        this.resourceType = resourceType;
        this.resourceId = resourceId;
    }

    public long getResourceId() {
        return resourceId;
    }

    public String getResourceType() {
        return resourceType;
    }

}
