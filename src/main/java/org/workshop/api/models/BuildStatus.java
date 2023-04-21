package org.workshop.api.models;

public enum BuildStatus {
    SUCCESS("SUCCESS");
    private String value;

    BuildStatus(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
