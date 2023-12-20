package ua.burkavtsov.hw15.Task1;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
public @interface ShowInfo {
    boolean show() default true;
}
