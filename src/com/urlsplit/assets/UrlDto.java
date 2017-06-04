package com.urlsplit.assets;

public class UrlDto {

    private Url url;

    private String sourceString;
    
    private EStateMachine state;
    
    public UrlDto() {
        super();
    }
    
    public UrlDto(String sourceString) {
        super();
        this.url = new Url();
        this.sourceString = sourceString;
    }

    public UrlDto(Url url, String sourceString) {
        super();
        this.url = url;
        this.sourceString = sourceString;
    }

    public Url getUrl() {
        return url;
    }

    public void setUrl(Url url) {
        this.url = url;
    }

    public String getSourceString() {
        return sourceString;
    }

    public void setSourceString(String sourceString) {
        this.sourceString = sourceString;
    }

    public EStateMachine getState() {
        return state;
    }

    public void setState(EStateMachine state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return "UrlDto [url=" + url + ", sourceString=" + sourceString + ", state=" + state + "]";
    }

}
