package com.github.fbiville;

import com.google.common.base.Preconditions;

import static com.google.common.base.Preconditions.checkNotNull;

public class PlaneToLong {

    public long convert(String name) {
        checkNotNull(name);
        long total = 0;
        for (char character : name.toCharArray()) {
            total += character;
        }
        return total;
    }
}
