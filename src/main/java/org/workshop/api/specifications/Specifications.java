package org.workshop.api.specifications;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import org.workshop.api.requests.CheckedRequests;

public class Specifications {
    public static final String CSRF_TOKEN = "X-TC-CSRF-Token";

    public RequestSpecification reqSpec() {
        var csrfToken = new CheckedRequests().getCsrfToken();

        // Create Request Specification
        var requestSpecBuilder = new RequestSpecBuilder();
        requestSpecBuilder.setBaseUri("http://admin:admin@localhost:8111");
        requestSpecBuilder.setContentType(ContentType.JSON);
        requestSpecBuilder.setAccept(ContentType.JSON);
        requestSpecBuilder.addHeader(CSRF_TOKEN, csrfToken);
        return requestSpecBuilder.build();


    }

    public RequestSpecification reqVCSSpec() {
        var csrfToken = new CheckedRequests().getCsrfToken();

        // Create Request Specification
        var requestSpecBuilder = new RequestSpecBuilder();
        requestSpecBuilder.setBaseUri("http://admin:admin@localhost:8111");
        requestSpecBuilder.setContentType(ContentType.JSON);
        requestSpecBuilder.setAccept(ContentType.JSON);
        requestSpecBuilder.addHeader(CSRF_TOKEN, csrfToken);
        return requestSpecBuilder.build();


    }
}
