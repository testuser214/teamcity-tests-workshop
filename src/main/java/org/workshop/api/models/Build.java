package org.workshop.api.models;

import lombok.Builder;
import lombok.Data;

@Data
@Builder

public class Build {
   private long id;
   private BuildType buildType;
   private String buildTypeId;
   private String status;
   private String state;

}
