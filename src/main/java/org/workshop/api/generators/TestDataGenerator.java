package org.workshop.api.generators;

import org.workshop.api.models.*;

import java.util.List;

public class TestDataGenerator {
    private final RandomData randomData = new RandomData();

    public TestData generateProject() {
        return TestData.builder().newProjectDescription(
                        NewProjectDescription.builder()
                                .name(randomData.getString())
                                .id(randomData.getString())
                                .parentProject(
                                        ParentProject.builder()
                                                .locator("_Root")
                                                .build())
                                .copyAllAssociatedSettings(randomData.getBoolean())
                                .build())
                .build();

    }

    public TestData generateVcsRoot(Project project) {
        return TestData.builder().vcsRoot(
                        VcsRoots.builder()
                                .count(randomData.getInteger())
                                .href(randomData.getString())
                                .vcsName("jetbrains.git")
                                .properties(
                                        Properties.builder()
                                                .count(randomData.getInteger())
                                                .href(randomData.getString())
                                                .build())
                                .project(project)
                                .build())
                .build();

    }

    public TestData generateBuildConfiguration(Project project) {
        return TestData
                .builder()
                .buildType(BuildType.builder()
                        .id(randomData.getString())
                        .name(randomData.getString())
                        .project(Project.builder()
                                .id(project.getId())
                                .build())
                        .steps(Steps.builder()
                                .step(List.of(
                                        Step.builder()
                                                .name(randomData.getString())
                                                .type("simpleRunner")
                                                .properties(Properties.builder()
                                                        .property(
                                                                List.of(
                                                                        Property.builder()
                                                                                .name("script.content")
                                                                                .value("echo 'Hello World!'")
                                                                                .build(),
                                                                        Property.builder()
                                                                                .name("teamcity.step.mode")
                                                                                .value("default")
                                                                                .build(),
                                                                        Property.builder()
                                                                                .name("use.custom.script")
                                                                                .value("true")
                                                                                .build()
                                                                )
                                                        )
                                                        .build())
                                                .build()
                                ))
                                .build())

                        .build()
                )
                .build();
    }

    public TestData generateRunConfiguration(BuildType buildType) {
        return TestData.builder().build(
                        Build.builder()
                                .buildType(BuildType.builder()
                                        .id(buildType.getId())
                                        .build())
                                .build())
                .build();

    }


}
