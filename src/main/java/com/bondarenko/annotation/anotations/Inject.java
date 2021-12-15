package com.bondarenko.annotation.anotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)//@Target i @Retention - это метаанотации, то есть аннотации, которые применяются к аннотации.
public @interface Inject {
Class clazz();
}
