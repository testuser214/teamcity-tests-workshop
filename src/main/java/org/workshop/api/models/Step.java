package org.workshop.api.models;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class Step {

    private String name;
    private String type;
    private Properties properties;
}
