package com.urlsplit.processors;

import static com.urlsplit.utils.SplitUtil.splitDomain;
import static com.urlsplit.utils.SplitUtil.splitPath;
import static com.urlsplit.utils.SplitUtil.splitPort;
import static com.urlsplit.utils.SplitUtil.splitQueryString;
import static com.urlsplit.utils.SplitUtil.splitScheme;

import com.urlsplit.assets.UrlDto;

public class RegexProcessor implements IProcessor {

    @Override
    public UrlDto splitUrl(UrlDto urlDto) {
        return splitQueryString(splitPath(splitPort(splitDomain(splitScheme(urlDto)))));
    }

}
