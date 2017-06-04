package com.urlsplit.processors;

import com.urlsplit.assets.UrlDto;

public interface IProcessor {

    UrlDto splitUrl(UrlDto urlDto);

}
