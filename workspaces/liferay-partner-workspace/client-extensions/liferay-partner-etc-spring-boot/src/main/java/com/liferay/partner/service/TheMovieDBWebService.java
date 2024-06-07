package com.liferay.partner.service;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class TheMovieDBWebService {
    public JSONObject getItems(String uri) throws Exception {

        JSONObject jsonObject;

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(
                        _theMovieDBBaseURL + uri))
                .header("accept", "application/json")
                .header("Authorization",
                        "Bearer " + _theMovieDBAccessTokenAuth)
                .method("GET", HttpRequest.BodyPublishers.noBody())
                .build();
        HttpResponse<String> response = HttpClient.newHttpClient().send(request,
                HttpResponse.BodyHandlers.ofString());
        jsonObject = new JSONObject(response.body());

        return jsonObject;
    }

    @Value("${tmdb.access.token.auth}")
    private String _theMovieDBAccessTokenAuth;

    @Value("${tmdb.base.url}")
    private String _theMovieDBBaseURL;
}
