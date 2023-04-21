package api;

import org.testng.annotations.Test;
import org.workshop.api.models.BuildStatus;
import org.workshop.api.models.Project;
import org.workshop.api.requests.CheckedRequests;


public class BuildConfigurationTest extends BaseTest {

    private Project createdProject;

    @Test
    public void buildConfigurationTest() {

        CheckedRequests checkedRequest = new CheckedRequests();
        var testData = testDataGenerator.generateProject();
        createdProject = checkedRequest.createProject(testData.getNewProjectDescription());
        // var buildType = testDataGenerator.generateBuildConfiguration(createdProject).getBuildType();
        var vcsData = testDataGenerator.generateVcsRoot(createdProject);
        checkedRequest.createVcsRoots(vcsData.getVcsRoot());
        var buildConfiguration = testDataGenerator.generateBuildConfiguration(createdProject);
        checkedRequest.createBuildConfiguration(buildConfiguration.getBuildType());
        var run = testDataGenerator.generateRunConfiguration(buildConfiguration.getBuildType());
        var build = checkedRequest.runBuildConfiguration(run.getBuild());
        checkedRequest.waitUntilBuildFinished(build.getId());
        build = checkedRequest.getBuild(build.getId());
        softy.assertThat(build.getStatus()).isEqualTo(BuildStatus.SUCCESS.getValue());
    }

}
