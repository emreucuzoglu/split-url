package com.urlsplit.assets;

import static com.urlsplit.utils.SplitUtil.splitDomain;
import static com.urlsplit.utils.SplitUtil.splitPath;
import static com.urlsplit.utils.SplitUtil.splitPort;
import static com.urlsplit.utils.SplitUtil.splitQueryString;
import static com.urlsplit.utils.SplitUtil.splitScheme;

public enum EStateMachine {
    START {
        @Override
        public UrlDto splitUrl(UrlDto urlDto) {
            urlDto.setState(SCHEME);
            return urlDto;
        }
    },
    SCHEME {
        @Override
        public UrlDto splitUrl(UrlDto urlDto) {
            splitScheme(urlDto);
            urlDto.setState(DOMAIN);
            return urlDto;
        }
    },
    DOMAIN {
        @Override
        public UrlDto splitUrl(UrlDto urlDto) {
            splitDomain(urlDto);
            urlDto.setState(PORT);
            return urlDto;
        }
    },
    PORT {
        @Override
        public UrlDto splitUrl(UrlDto urlDto) {
            splitPort(urlDto);
            urlDto.setState(PATH);
            return urlDto;
        }
    },
    PATH {
        @Override
        public UrlDto splitUrl(UrlDto urlDto) {
            splitPath(urlDto);
            urlDto.setState(QUERY_STRING);
            return urlDto;
        }
    },
    QUERY_STRING {
        @Override
        public UrlDto splitUrl(UrlDto urlDto) {
            splitQueryString(urlDto);
            urlDto.setState(FINAL);
            return urlDto;
        }
    },
    FINAL {
        @Override
        public UrlDto splitUrl(UrlDto urlDto) {
            return urlDto;
        }
    };

    public abstract UrlDto splitUrl(UrlDto urlDto);

}
