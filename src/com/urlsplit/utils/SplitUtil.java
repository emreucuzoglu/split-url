package com.urlsplit.utils;

import static com.urlsplit.utils.Constant.REGEX_MATCH_DOMAIN;
import static com.urlsplit.utils.Constant.REGEX_MATCH_PATH;
import static com.urlsplit.utils.Constant.REGEX_MATCH_PORT;
import static com.urlsplit.utils.Constant.REGEX_MATCH_SCHEME;
import static com.urlsplit.utils.Constant.REGEX_SPLIT_DOMAIN;
import static com.urlsplit.utils.Constant.REGEX_SPLIT_PATH;
import static com.urlsplit.utils.Constant.REGEX_SPLIT_PORT;
import static com.urlsplit.utils.Constant.REGEX_SPLIT_SCHEME;
import static java.util.regex.Pattern.compile;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.urlsplit.assets.Url;
import com.urlsplit.assets.UrlDto;

public class SplitUtil {
    
    // TODO improve regex
    public static final Pattern PATTERN_URL = compile("([a-zA-Z]+)://([a-zA-Z-.]+)(:[0-9]+)?/([a-zA-Z_0-9]+)\\?(.*)");
    
    public static UrlDto splitUrl(String url) {
        Matcher matcher = PATTERN_URL.matcher(url);
        UrlDto result = null;
        if (matcher.find()) {
            result = new UrlDto();
            Url resultUrl = new Url();
            result.setUrl(resultUrl);
            
            resultUrl.setScheme(matcher.group(1));
            resultUrl.setDomain(matcher.group(2));
            resultUrl.setPort(matcher.group(3));
            resultUrl.setPath(matcher.group(4));
            resultUrl.setQueryString(matcher.group(5));
        }

        return result;
    }
    
    public static UrlDto splitScheme(UrlDto urlDto) {
        String[] tmpStringArr = urlDto.getSourceString().split(REGEX_SPLIT_SCHEME);
        if (tmpStringArr != null && tmpStringArr.length == 2) {
            if (tmpStringArr[0].matches(REGEX_MATCH_SCHEME)) {
                urlDto.getUrl().setScheme(tmpStringArr[0]);
                urlDto.setSourceString(tmpStringArr[1]);
                return urlDto;
            }
        }
        throw new RuntimeException("Invalid Url");
    }
    
    public static UrlDto splitDomain(UrlDto urlDto) {
        String[] tmpStringArr = urlDto.getSourceString().split(REGEX_SPLIT_DOMAIN);
        if (tmpStringArr != null && tmpStringArr.length == 1) {
            tmpStringArr = urlDto.getSourceString().split(REGEX_SPLIT_PORT);
        }

        if (tmpStringArr.length == 2 && tmpStringArr[0].matches(REGEX_MATCH_DOMAIN)) {
            urlDto.getUrl().setDomain(tmpStringArr[0]);
            urlDto.setSourceString(tmpStringArr[1]);
            
            return urlDto;
        }

        throw new RuntimeException("Invalid Url");
    }

    public static UrlDto splitPort(UrlDto urlDto) {
        String[] tmpStringArr = urlDto.getSourceString().split(REGEX_SPLIT_PORT);
        if (tmpStringArr != null && tmpStringArr.length == 2) {
            if (tmpStringArr[0].matches(REGEX_MATCH_PORT)) {
                urlDto.getUrl().setPort(tmpStringArr[0]);
                urlDto.setSourceString(tmpStringArr[1]);
            }
        }
        return urlDto;
    }

    public static UrlDto splitPath(UrlDto urlDto) {
        String[] tmpStringArr = urlDto.getSourceString().split(REGEX_SPLIT_PATH);
        if (tmpStringArr != null && tmpStringArr.length > 0 && tmpStringArr[0].matches(REGEX_MATCH_PATH)) {
            urlDto.getUrl().setPath(tmpStringArr[0]);
            urlDto.setSourceString("");
            if (tmpStringArr.length == 2) {
                urlDto.setSourceString(tmpStringArr[1]);
            }
            
            return urlDto;
        }
        throw new RuntimeException("Invalid Url");
    }

    public static UrlDto splitQueryString(UrlDto urlDto) {
        urlDto.getUrl().setQueryString(urlDto.getSourceString());
        urlDto.setSourceString("");

        return urlDto;
    }

}
