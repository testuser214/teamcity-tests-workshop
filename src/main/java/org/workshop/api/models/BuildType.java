package org.workshop.api.models;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class BuildType {
    private String id;
    private String name;
    private Project project;
    private List<BuildTypes> templates;
    private Properties parameters;
    private Steps steps;

}
