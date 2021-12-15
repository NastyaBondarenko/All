package com.bondarenko.reflection;


import java.lang.reflect.*;
import java.util.ArrayList;
import java.util.List;

public class Reflection {


    //Метод принимает object и вызывает у него все методы без параметров
    public List invokeMethodsWithoutParameters(Object object) {
        List listOfMethods = new ArrayList();

        Class<?> clazz = object.getClass();

        Method[] listMethods = clazz.getDeclaredMethods();//1.2.3

        for (Method method : listMethods) {
            if (method.getParameterCount() == 0) {
                listOfMethods.add(method.getName());//1.3
            }
        }
        return listOfMethods;
    }

    //Метод принимает класс и возвращает созданный объект этого класса
    public Object createObject(Class<?> clazz) {

        try {
            Object newInstance = clazz.getConstructor().newInstance();//створи об"єкт=сущность=інстанс
            return newInstance;
        } catch (InstantiationException | IllegalAccessException | NoSuchMethodException | InvocationTargetException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    //Метод принимает Class и выводит все не публичные методы этого класса
    public List classWithoutPublicMethods(Class<?> clazz) {
        List listWithoutPublicMethods = new ArrayList();
        Method[] allMethods = clazz.getDeclaredMethods();
        for (Method method : allMethods) {
            if (!Modifier.isPublic(method.getModifiers())) {
                listWithoutPublicMethods.add(method.getName());
            }
        }
        return listWithoutPublicMethods;
    }

    //Метод принимает object и выводит на экран все сигнатуры методов в который есть final
    public List<?> methodsWithSignatureContainsFinal(Object object) {
        List listOfMethods = new ArrayList();

        Class<?> clazz = object.getClass();

        Method[] methods = clazz.getDeclaredMethods();
        for (Method method : methods) {
            if (Modifier.isFinal(method.getModifiers())) {
                listOfMethods.add(method.getName());
            }
        }
        for (Method method : methods) {
            Parameter[] parameters = method.getParameters();
            for (Parameter parameter : parameters) {
                if (Modifier.isFinal(parameter.getModifiers())) {
                    listOfMethods.add(method.getName());
                }
            }

        }
        return listOfMethods;
    }

    //    Метод принимает Class и выводит всех предков класса и все интерфейсы которое класс имплементирует
    public List methodReturnAllSuperClassesAndInterfacesOfClass(Class<?> clazz) {
        List ListWithSuperClassesAndInterfaces = new ArrayList();
        Class<?>[] interfaces = clazz.getInterfaces();
        ListWithSuperClassesAndInterfaces.add(interfaces);
        Class<?> superclass = clazz.getSuperclass();
        ListWithSuperClassesAndInterfaces.add(superclass);
        return ListWithSuperClassesAndInterfaces;
    }

    //  Метод принимает объект и меняет всего его приватные поля на их нулевые значение (null, 0, false etc)+
    public void setPrivateFieldsToNullFields(Object object) throws ReflectiveOperationException {

        Class<?> clazz = object.getClass();

        Field[] declaredFields = clazz.getDeclaredFields();//alt+eNTER
        for (Field field : declaredFields) {

            if (Modifier.isPrivate(field.getModifiers())) {
                try {
                    Class<?> type = field.getType();
                    field.setAccessible(true);

                    if (byte.class.equals(type) || int.class.equals(type) || short.class.equals(type) || long.class.equals(type)) {
                        field.set(object, (byte) 0);

                    } else if (float.class.equals(type) || double.class.equals(type)) {
                        field.setFloat(object, 0.0f);
                    } else if (boolean.class.equals(type)) {
                        field.set(object, false);
                    } else if (char.class.equals(type)) {
                        field.set(object, '\u0000');
                    } else {
                        field.set(object, null);
                    }
                    field.setAccessible(false);
                } catch (IllegalAccessException e) {
                    throw new ReflectiveOperationException(e.getCause());
                }
            }
        }
    }
}



/*
   /Метод принимает класс и возвращает созданный объект этого класса
   / Метод принимает object и вызывает у него все методы без параметров
    Метод принимает object и выводит на экран все сигнатуры методов в который есть final
   / Метод принимает Class и выводит все не публичные методы этого класса
    Метод принимает Class и выводит всех предков класса и все интерфейсы которое класс имплементирует
    Метод принимает объект и меняет всего его приватные поля на их нулевые значение (null, 0, false etc)+
*/




