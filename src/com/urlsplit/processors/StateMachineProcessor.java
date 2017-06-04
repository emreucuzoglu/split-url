package com.urlsplit.processors;

import static com.urlsplit.assets.EStateMachine.FINAL;
import static com.urlsplit.assets.EStateMachine.START;

import com.urlsplit.assets.UrlDto;

public class StateMachineProcessor implements IProcessor {
    
    @Override
    public UrlDto splitUrl(UrlDto urlDto) {
        START.splitUrl(urlDto);
        urlDto.getState().splitUrl(urlDto);
        urlDto.getState().splitUrl(urlDto);
        urlDto.getState().splitUrl(urlDto);
        urlDto.getState().splitUrl(urlDto);
        urlDto.getState().splitUrl(urlDto);
        
        if(FINAL != urlDto.getState()){
            throw new RuntimeException("Invalid Url");
        }
        
        return urlDto;
    }

}
