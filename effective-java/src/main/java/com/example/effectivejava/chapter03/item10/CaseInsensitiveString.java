package com.example.effectivejava.chapter03.item10;

import java.util.Objects;

public class CaseInsensitiveString {

    private final String s;

    public CaseInsensitiveString(String s) {
        this.s = Objects.requireNonNull(s);
    }

    @Override
    public boolean equals(Object o) {
        return o instanceof CaseInsensitiveString
                && ((CaseInsensitiveString) o).s.equalsIgnoreCase(s);
    }
}
