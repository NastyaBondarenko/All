package com.bondarenko.annotation.anotations;

import com.bondarenko.annotation.anotations.Inject;
import com.bondarenko.annotation.anotations.MessagePrint;
import com.bondarenko.annotation.anotations.Run;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;


public class AnnotationTest {
    public static void main(String[] args) throws Exception {
        MessagePrint messagePrint = new MessagePrint();

        messagePrint.setMessage("Name");

        invokeMethodsWithAnnotationRun(messagePrint);
        fillFieldsWithAnnotationInjectByObjectOfAnnotationClazz(messagePrint);
        messagePrint.printObject();


    }

    //Принимает объект и вызывает методы проанотированные аннотацией @Run (аннотация Ваша, написать самим)
    static void invokeMethodsWithAnnotationRun(Object object) throws IllegalAccessException, InvocationTargetException, InstantiationException {

        Class<?> clazz = object.getClass();
        for (Method method : clazz.getDeclaredMethods()) {
            Run annotation = method.getAnnotation(Run.class);
            if (annotation != null) {
                // Object object =clazz.newInstance();
                method.setAccessible(true);
                method.invoke(object);
                method.setAccessible(false);
                // int[] Random= new Random().nextBytes(array.length);
            }
        }
    }

    /*- Принимает объект. Поля проаннотиваные аннотацией @Inject заполняет объектом того класса который находиться
     в поле аннотации Class clazz(). Если поле аннотации содержит ссылку на Void.class.
     Создает пустой экзепляр класса, базируясь на типе поля (аннотация Ваша, написать самим)*/

    static void fillFieldsWithAnnotationInjectByObjectOfAnnotationClazz(Object object) throws IllegalAccessException, InstantiationException {
        Class<?> clazz = object.getClass();
        for (Field field : clazz.getDeclaredFields()) {
            Inject annotation = field.getAnnotation(Inject.class);
            if (annotation != null) {
                Class objectClazz = annotation.clazz();
                Object newObject = objectClazz.newInstance();
                field.setAccessible(true);
                field.set(object, newObject);
                field.setAccessible(false);
            }
        }
    }

   // Пишем квери генератор основываясь на инструкциях в видео
}

/*- Принимает объект и вызывает методы проанотированные аннотацией @Run (аннотация Ваша, написать самим)
- Принимает объект. Поля проаннотиваные аннотацией @Inject заполняет объектом того класса который находиться в поле аннотации Class clazz(). Если поле аннотации содержит ссылку на Void.class. Создает пустой экзепляр класса, базируясь на типе поля (аннотация Ваша, написать самим)
- Пишем квери генератор основываясь на инструкциях в видео
*/
