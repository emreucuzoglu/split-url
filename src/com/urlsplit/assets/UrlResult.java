package com.urlsplit.assets;

public class UrlResult {

    private Url url;

    private long runtime;

    public UrlResult(Url url, long runtime) {
        super();
        this.url = url;
        this.runtime = runtime;
    }

    public Url getUrl() {
        return url;
    }

    public void setUrl(Url url) {
        this.url = url;
    }

    public long getRuntime() {
        return runtime;
    }

    public void setRuntime(long runtime) {
        this.runtime = runtime;
    }

}
