package org.workshop.api.generators;

import org.workshop.api.models.*;

public class TestDataGenerator {
    private final RandomData randomData = new RandomData();

    public TestData generateProject(){
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
/*
    public TestData generateBuildConfiguration(Project project) {
        return TestData.builder().buildType(
                        BuildType.builder()
                                .name(randomData.getString())
                                .project(project)
                                .templates(
                                        BuildType.builder()
                                                .id(randomData.getString())
                                                .build())
                                .steps(Steps.builder()
                                        .name(randomData.getString())
                                        .type("simpleRunner")
                                        .properties(
                                                Properties.builder(Property.builder()
                                                                .)
                                                        .name("script.content")
                                                        .value("echo 'Hello World!'")
                                                        .build())
                                        .build())
                                .build())
                .build();

    }
*/
}
