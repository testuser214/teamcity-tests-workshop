package org.workshop.api.models;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class BuildType {
    private String id;
    private String name;
    private Project project;
    private BuildType templates;
    private Properties parameters;
    private Step steps;

}
