package com.urlsplit.utils;

public class Constant {
    public static final String COMMAND_SPLIT = "splitUrl";
    
    public static final String REGEX_SPLIT_SCHEME = "://";
    public static final String REGEX_MATCH_SCHEME = "[a-zA-Z]+";
    public static final String REGEX_SPLIT_DOMAIN = ":";
    public static final String REGEX_MATCH_DOMAIN = "[a-zA-Z-.]+";
    public static final String REGEX_SPLIT_PORT = "/";
    public static final String REGEX_MATCH_PORT = "[0-9]+";
    public static final String REGEX_SPLIT_PATH = "\\?";
    public static final String REGEX_MATCH_PATH = "[a-zA-Z_0-9]+";
}
