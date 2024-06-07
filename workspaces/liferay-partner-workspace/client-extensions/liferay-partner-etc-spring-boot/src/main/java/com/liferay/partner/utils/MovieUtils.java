package com.liferay.partner.utils;

import org.json.JSONObject;

public class MovieUtils {

    public static JSONObject getMovieDTO(JSONObject movieJsonObject) {
        JSONObject movieDTOJsonObject = new JSONObject();

        movieDTOJsonObject.put("adult", movieJsonObject.getBoolean("adult"));

        movieDTOJsonObject.put("backdrop",
                "https://image.tmdb.org/t/p/original" + movieJsonObject.getString("backdrop_path"));

        movieDTOJsonObject.put("externalReferenceCode", movieJsonObject.getInt("id"));
        movieDTOJsonObject.put("erc", movieJsonObject.getInt("id"));

        movieDTOJsonObject.put("genres",
                movieJsonObject.has("genre_ids") ? movieJsonObject.getJSONArray("genre_ids")
                        : movieJsonObject.getJSONArray("genres").toString());

        movieDTOJsonObject.put("id", movieJsonObject.getInt("id"));

        movieDTOJsonObject.put("language", movieJsonObject.getString("original_language"));

        movieDTOJsonObject.put("originalTitle", movieJsonObject.getString("original_title"));
        movieDTOJsonObject.put("overview", movieJsonObject.getString("overview"));

        movieDTOJsonObject.put("popularity", movieJsonObject.getDouble("popularity"));
        movieDTOJsonObject.put("poster",
                "https://image.tmdb.org/t/p/original" + movieJsonObject.getString("poster_path"));

        movieDTOJsonObject.put("rate", movieJsonObject.getDouble("vote_average"));
        movieDTOJsonObject.put("release", movieJsonObject.getString("release_date"));

        movieDTOJsonObject.put("title", movieJsonObject.getString("title"));

        movieDTOJsonObject.put("video", movieJsonObject.getBoolean("video"));
        movieDTOJsonObject.put("votes", movieJsonObject.getInt("vote_count"));

        return movieDTOJsonObject;
    }

}
