package api;
import org.testng.annotations.Test;
import org.workshop.api.models.Project;
import org.workshop.api.requests.CheckedRequests;


public class BuildConfigurationTest extends BaseTest {

   private Project createdProject;

    @Test
        public void buildConfigurationTest() {
            var testData = testDataGenerator.generateProject();
            createdProject = new CheckedRequests().createProject(testData.getNewProjectDescription());
          //  var buildType = testDataGenerator.generateBuildConfiguration(createdProject);
            softy.assertThat(createdProject.getId()).isEqualTo(testData.getNewProjectDescription().getId());
            var vcsData = testDataGenerator.generateVcsRoot(createdProject);
            new CheckedRequests().createVcsRoots(vcsData.getVcsRoot());
        //    var buildConfiguration = new CheckedRequests().createBuildConfiguration(testData.getBuildType());
        }

    }

