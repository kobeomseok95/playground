package com.example.advanced.trace.callback;

import com.example.advanced.trace.TraceStatus;
import com.example.advanced.trace.logtrace.LogTrace;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class TraceTemplate {

    private final LogTrace logTrace;

    public <T> T execute(String message, TraceCallback<T> callback) {
        TraceStatus status = null;
        try {
            status = logTrace.begin(message);
            T result = callback.call();
            logTrace.end(status);
            return result;
        } catch (Exception e) {
            throw e;
        }
    }
}
