package com.rvr.lecture.security.client;

import org.apache.http.HttpHeaders;
import com.jayway.restassured.response.Response;
import org.junit.Test;

import static com.jayway.restassured.RestAssured.given;
import static org.junit.Assert.*;
import static org.hamcrest.Matchers.is;


import static com.rvr.lecture.persistence.setup.SecurityConstants.*;

public class UserLiveTest
{
    @Test
    public void givenNotAuthenticated_whenResourcesAreRetrieved_then401IsReceived() {
        // Given
        // When
        final Response response = given().header(HttpHeaders.ACCEPT, "application/json")
                .get("http://localhost:8080/api/users");

        // Then
        assertThat(response.getStatusCode(), is(401));
    }

    @Test
    public void givenAuthenticatedByBasicAuth_whenResourcesAreRetrieved_then200IsReceived() {
        // Given
        // When
        final Response response = given().auth().preemptive().basic(ADMIN1_USERNAME, ADMIN1_PASS)
                .header(HttpHeaders.ACCEPT, "application/json").get("http://localhost:8080/api/users");

        // Then
        assertThat(response.getStatusCode(), is(200));
    }
}
