package com.urlsplit.processors;

import com.urlsplit.assets.UrlDto;
import com.urlsplit.utils.SplitUtil;

public class RegexFastProcessor implements IProcessor {

    @Override
    public UrlDto splitUrl(UrlDto urlDto) {
        return SplitUtil.splitUrl(urlDto.getSourceString());
    }

}
