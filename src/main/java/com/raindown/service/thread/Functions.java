package com.raindown.service.thread;

import java.util.List;

public interface Functions<T,R> {
    List<R> apply(List<T> list);
}
