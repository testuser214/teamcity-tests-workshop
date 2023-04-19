package org.workshop.api.models;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Project {
    private String id;
    private String name;
    private String currentProjectId;
    private Boolean virtual;
    private String href;
    private String webUrl;
    private Project parentProject;
    private BuildTypes buildTypes;
    private BuildTypes templates;
    private Properties parameters;
    private VcsRoots vcsRoots;
    private ProjectFeatures projectFeatures;
    private Projects project;


}
