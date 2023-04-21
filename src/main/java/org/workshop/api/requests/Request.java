package org.workshop.api.requests;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.workshop.api.models.Build;
import org.workshop.api.models.BuildType;
import org.workshop.api.models.NewProjectDescription;
import org.workshop.api.models.VcsRoots;
import org.workshop.api.specifications.Specifications;

import static io.restassured.RestAssured.given;

public class Request {

    private static String AUTHENTICATION_ENDPOINT = "/authenticationTest.html?csrf";
    private static final String PROJECT_ENDPOINT = "/app/rest/projects";
    private static final String VCS_ROOTS_ENDPOINT = "/app/rest/vcs-roots";
    private static final String BUILD_TYPES_ENDPOINT = "/app/rest/buildTypes";
    private static final String RUN_BUILD_CONFIGURATION_ENDPOINT = "/app/rest/buildQueue";
    private static final String BUILD_STATE = "/app/rest/builds/{id}";


    public final Specifications spec = new Specifications();

    public Response getCsrfToken() {
        return RestAssured.get(AUTHENTICATION_ENDPOINT);
    }

    public Response createProject(NewProjectDescription project) {
        return given().spec(spec.reqSpec()).body(project).post(PROJECT_ENDPOINT);

    }

    public Response createVcsRoots(VcsRoots vcsRoots) {
        return given().spec(spec.reqSpec()).body(vcsRoots).post(VCS_ROOTS_ENDPOINT);
    }

    public Response createBuildConfiguration(BuildType buildType) {
        return given().spec(spec.reqSpec()).body(buildType).post(BUILD_TYPES_ENDPOINT);
    }

    public Response runBuildConfiguration(Build build) {
        return given().spec(spec.reqSpec()).body(build).post(RUN_BUILD_CONFIGURATION_ENDPOINT);
    }

    public Response getState(Long buildId) {
        return given()
                .spec(spec.reqSpec())
                .pathParam("id", buildId)
                .when()
                .get(BUILD_STATE);
    }
}