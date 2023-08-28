package ru.netology;

import java.net.URI;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;
import org.apache.http.client.utils.URLEncodedUtils;

public class Request {
    private final Map<String, String> queryParams = new HashMap<>();
    String path;
    String requestLine;
    String body;
    private String method;

    public Request(String requestLine) {
        //this.queryParams = queryParams;
        this.requestLine = requestLine;
//        this.headers = headers;
//        this.body = body;
//        this.path = path;
//        this.method = method;
    }


    public String getQueryParam(String name) {
        return queryParams.get(name);
    }

    public Map<String, String> getQueryParams() {
        return queryParams;
    }

    public String getPath() {
        final var parts = requestLine.split("\\s+");
        if (parts.length != 3) {
            throw new IllegalArgumentException("Invalid request string: " + requestLine);
        }
        this.method = parts[0];
        final var uri = URI.create(parts[1]);
        this.path = uri.getPath();
        final var query = uri.getQuery();
        if (query != null) {
            final var params = URLEncodedUtils.parse(query, StandardCharsets.UTF_8);
            for (var param : params) {
                this.queryParams.put(param.getName(), param.getValue());
            }
        }
        return path;
    }
}
