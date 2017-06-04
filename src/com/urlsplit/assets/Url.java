package com.urlsplit.assets;

public class Url {

    private String scheme;
    private String domain;
    private String port;
    private String path;
    private String queryString;

    public String getScheme() {
        return scheme;
    }

    public void setScheme(String scheme) {
        this.scheme = scheme;
    }

    public String getDomain() {
        return domain;
    }

    public void setDomain(String domain) {
        this.domain = domain;
    }

    public String getPort() {
        return port;
    }

    public void setPort(String port) {
        this.port = port;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getQueryString() {
        return queryString;
    }

    public void setQueryString(String query_string) {
        this.queryString = query_string;
    }

    @Override
    public String toString() {
        return scheme + "\n" + domain + "\n" + port + "\n" + path + "\n" + queryString;
    }

}
