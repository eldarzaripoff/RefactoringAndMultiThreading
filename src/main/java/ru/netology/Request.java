package ru.netology;

import org.apache.http.NameValuePair;
import org.apache.http.client.utils.URLEncodedUtils;

import java.io.BufferedOutputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class Request {
    private final String path;
    private final List<NameValuePair> queryParams;

    public Request(String requestLine) {
        final var parts = requestLine.split(" ");
        this.path = parts[1];
        this.queryParams = URLEncodedUtils.parse(this.path, StandardCharsets.UTF_8);
    }

    public String getPath() {
        return path;
    }

    public List<NameValuePair> getQueryParams() {
        return queryParams;
    }
}
