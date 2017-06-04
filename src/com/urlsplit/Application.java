package com.urlsplit;

import static com.urlsplit.utils.Constant.COMMAND_SPLIT;
import static java.time.LocalDateTime.now;
import static java.time.temporal.ChronoUnit.MILLIS;

import java.time.LocalDateTime;

import com.urlsplit.assets.UrlDto;
import com.urlsplit.assets.UrlResult;
import com.urlsplit.processors.IProcessor;
import com.urlsplit.processors.RegexFastProcessor;
import com.urlsplit.processors.RegexProcessor;
import com.urlsplit.processors.StateMachineProcessor;

public class Application {
    private static final int NUMBER_ARGS = 2;
    private static final int NUMBER_ITERATIONS = 10000;

    public static void main(String[] args) {
        if (isArgumentsValid(args)) {
            String inputString = args[1];
            
            UrlResult regexResult = runWithRegex(inputString);
            UrlResult regexFastResult = runWithRegexFast(inputString);
            UrlResult stateMachineResult = runWithStateMachine(inputString);
            
            System.out.println(regexResult.getUrl());
            System.out.println("Regex : " + regexResult.getRuntime() + "msec");
            System.out.println("Regex Fast : " + regexFastResult.getRuntime() + "msec");
            System.out.println("State : " + stateMachineResult.getRuntime() + "msec");
        }
    }

    private static final boolean isArgumentsValid(String[] args) {
        return args != null && args.length == NUMBER_ARGS && COMMAND_SPLIT.equals(args[0]);
    }
    
    private static final UrlResult runWithRegexFast(String url) {
        UrlDto tmpUrlDto = null;
        IProcessor processor = new RegexFastProcessor();
        
        LocalDateTime start = now();
        for (int i = 0; i < NUMBER_ITERATIONS; i++) {
            tmpUrlDto = processor.splitUrl(new UrlDto(url));
        }
        LocalDateTime end = now();

        return new UrlResult(tmpUrlDto.getUrl(), start.until(end, MILLIS));
    }

    private static final UrlResult runWithRegex(String url) {
        UrlDto tmpUrlDto = null;
        IProcessor processor = new RegexProcessor();

        LocalDateTime start = now();
        for (int i = 0; i < NUMBER_ITERATIONS; i++) {
            tmpUrlDto = processor.splitUrl(new UrlDto(url));
        }
        LocalDateTime end = now();

        return new UrlResult(tmpUrlDto.getUrl(), start.until(end, MILLIS));
    }
    
    private static final UrlResult runWithStateMachine(String url) {
        UrlDto tmpUrlDto = null;
        IProcessor processor = new StateMachineProcessor();

        LocalDateTime start = now();
        for (int i = 0; i < NUMBER_ITERATIONS; i++) {
            tmpUrlDto = processor.splitUrl(new UrlDto(url));
        }
        LocalDateTime end = now();

        return new UrlResult(tmpUrlDto.getUrl(), start.until(end, MILLIS));
    }

}
