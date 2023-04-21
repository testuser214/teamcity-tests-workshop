package org.workshop.api.requests;

import org.apache.http.HttpStatus;
import org.workshop.api.models.*;

public class CheckedRequests {
    private static final Request request = new Request();
    private static final long TIMEOUT = 60_000;

    public String getCsrfToken() {
        return request.getCsrfToken().
                then().assertThat().statusCode(HttpStatus.SC_OK)
                .extract().response().asString();
    }

    public Project createProject(NewProjectDescription project) {
        return request.createProject(project).
                then().assertThat().statusCode(HttpStatus.SC_OK)
                .extract().response().as(Project.class);
    }

    public VcsRoots createVcsRoots(VcsRoots vcs) {
        return request.createVcsRoots(vcs).
                then().assertThat().statusCode(HttpStatus.SC_OK)
                .extract().response().as(VcsRoots.class);
    }

    public Project createBuildConfiguration(BuildType buildType) {
        return request.createBuildConfiguration(buildType).
                then().assertThat().statusCode(HttpStatus.SC_OK)
                .extract().response().as(Project.class);
    }

    public Build runBuildConfiguration(Build build) {
        return request.runBuildConfiguration(build).
                then().assertThat().statusCode(HttpStatus.SC_OK)
                .extract().response().as(Build.class);
    }

    public Build getBuild(long buildId) {
        return request.getState(buildId).
                then().assertThat().statusCode(HttpStatus.SC_OK)
                .extract().response().as(Build.class);
    }

    public void waitUntilBuildFinished(Long buildId) {
        var startTime = System.currentTimeMillis();
        while (System.currentTimeMillis() - startTime < TIMEOUT) {
            var build = getBuild(buildId);
            if (build.getState() != null && build.getState().equals(BuildState.FINISHED.getValue())) {
                break;
            }
        }
    }
}
