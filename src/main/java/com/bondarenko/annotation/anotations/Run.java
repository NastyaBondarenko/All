package com.bondarenko.annotation.anotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)//@Target i @Retention - это метаанотации, то есть аннотации, которые применяются к аннотации.
@Target(ElementType.METHOD)//аннотация @Run применима к методам, то есть с помощью нее можно аннотировать только метод:
public @interface Run {

}
