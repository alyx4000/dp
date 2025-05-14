package com.cossacklabs.themis;

/* loaded from: classes.dex */
public class InvalidArgumentException extends IllegalArgumentException {
    public InvalidArgumentException(String str) {
        super("Invalid argument: " + str);
    }
}
