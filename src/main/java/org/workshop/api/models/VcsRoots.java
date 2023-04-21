package org.workshop.api.models;

import lombok.Builder;
import lombok.Data;

@Data
@Builder

public class VcsRoots {
    private Integer count;
    private String href;
    private String vcsName;
    private Properties properties;
    private Project project;

}
