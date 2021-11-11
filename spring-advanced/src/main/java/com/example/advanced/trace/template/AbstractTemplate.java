package com.example.advanced.trace.template;

import com.example.advanced.trace.TraceStatus;
import com.example.advanced.trace.logtrace.LogTrace;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public abstract class AbstractTemplate<T> {

    private final LogTrace logTrace;

    public T execute(String message) {
        TraceStatus status = null;
        try {
            status = logTrace.begin(message);
            T result = call();
            logTrace.end(status);
            return result;
        } catch (Exception e) {
            throw e;
        }
    }

    protected abstract T call();
}
