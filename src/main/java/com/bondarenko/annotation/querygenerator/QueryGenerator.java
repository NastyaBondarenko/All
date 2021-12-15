package com.bondarenko.annotation.querygenerator;

import com.bondarenko.annotation.anotations.Inject;
import com.bondarenko.annotation.anotations.Run;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.StringJoiner;

public class QueryGenerator {
    public String getAll(Class<?> clazz) {
        StringBuilder stringBuilder = new StringBuilder("SELECT ");

        Table annotation = clazz.getAnnotation(Table.class);

        if (annotation == null) {
            throw new IllegalArgumentException("@Table is missing");
        }

        String tableName = annotation.name().isEmpty() ? clazz.getName() : annotation.name();
        StringJoiner stringJoiner = new StringJoiner(", ");

        for (Field declaredField : clazz.getDeclaredFields()) {
            Column columnAnnotation = declaredField.getAnnotation(Column.class);
            if (columnAnnotation != null) {
                String columnName = columnAnnotation.name().isEmpty() ? declaredField.getName() : columnAnnotation.name();
                stringJoiner.add(columnName);
            }
        }
        stringBuilder.append(stringJoiner);
        stringBuilder.append(" FROM ");
        stringBuilder.append(tableName);
        stringBuilder.append(";");

        return stringBuilder.toString();
    }

    public String getById(Class<?> clazz, Object id) {
        StringBuilder stringBuilder = new StringBuilder("SELECT");

        Table annotation = clazz.getAnnotation(Table.class);
        if (annotation == null) {
            throw new IllegalArgumentException("@Table is missing");
        }

        String tableName = annotation.name().isEmpty() ? clazz.getName() : annotation.name();
        StringJoiner stringJoiner = new StringJoiner(" ");
        for (Field declaredField : clazz.getDeclaredFields()) {
            Column columnAnnotation = declaredField.getAnnotation(Column.class);
            if (declaredField.getName() == "id") {
                String ColumnNameId = declaredField.getName();
                stringJoiner.add(ColumnNameId);
            }
        }
        stringBuilder.append(" * ");
        stringBuilder.append("FROM ");
        stringBuilder.append(tableName);
        stringBuilder.append(" WHERE ");
        stringBuilder.append(stringJoiner);
        stringBuilder.append("=");
        stringBuilder.append(id);

        return stringBuilder.toString();
    }

    //insert -Вставляет одну или более строк в таблицу базы данных

    public String insert(Object value) {
        Class<?> clazz = value.getClass();
        clazz = com.bondarenko.annotation.querygenerator.Person.class;
        Table annotation = clazz.getAnnotation(Table.class);

        if (annotation == null) {
            throw new IllegalArgumentException("@Table is missing");
        }
        String tableName = annotation.name().isEmpty() ? clazz.getName() : annotation.name();

        StringJoiner stringJoiner = new StringJoiner(" ");
        for (Field declaredField : clazz.getDeclaredFields()) {
            Column columnAnnotation = declaredField.getAnnotation(Column.class);
            if (declaredField.getName() == "id") {
                String ColumnName = declaredField.getName();
                stringJoiner.add(ColumnName);
            }
        }
        StringBuilder stringBuilder = new StringBuilder("INSERT INTO ");
        stringBuilder.append(tableName);
        stringBuilder.append(" (");
        stringBuilder.append(stringJoiner);
        stringBuilder.append(") VALUES ('");
        stringBuilder.append(value);
        stringBuilder.append("')");

        return stringBuilder.toString();
    }


    //delete-Удаляет одну или более строк из таблицы базы данных
    public String delete(Object value) {
        Class<?> clazz = value.getClass();
        clazz = com.bondarenko.annotation.querygenerator.Person.class;
        Table annotation = clazz.getAnnotation(Table.class);

        if (annotation == null) {
            throw new IllegalArgumentException("@Table is missing");
        }
        String tableName = annotation.name().isEmpty() ? clazz.getName() : annotation.name();

        StringJoiner stringJoiner = new StringJoiner(" ");
        for (Field declaredField : clazz.getDeclaredFields()) {
            Column columnAnnotation = declaredField.getAnnotation(Column.class);
            if (declaredField.getName() == "id") {
                String ColumnName = declaredField.getName();
                stringJoiner.add(ColumnName);
            }
        }
        StringBuilder stringBuilder = new StringBuilder("DELETE ");
        stringBuilder.append("FROM ");
        stringBuilder.append(tableName);
        stringBuilder.append(" WHERE ");
        stringBuilder.append(stringJoiner);
        stringBuilder.append(" = ");
        stringBuilder.append(value);


        return stringBuilder.toString();
    }

    //update-Обновляет значения колонок в таблице базы данных
    public String update(Object value) {
        Class<?> clazz = value.getClass();
        clazz = com.bondarenko.annotation.querygenerator.Person.class;
        Table annotation = clazz.getAnnotation(Table.class);

        if (annotation == null) {
            throw new IllegalArgumentException("@Table is missing");
        }
        String tableName = annotation.name().isEmpty() ? clazz.getName() : annotation.name();

        StringJoiner stringJoiner = new StringJoiner(" ");
        for (Field declaredField : clazz.getDeclaredFields()) {
            Column columnAnnotation = declaredField.getAnnotation(Column.class);
            if (declaredField.getName() == "id") {
                String ColumnName = declaredField.getName();
                stringJoiner.add(ColumnName);
            }
        }
        StringBuilder stringBuilder = new StringBuilder("UPDATE ");
        stringBuilder.append(tableName);
        stringBuilder.append(" SET ");
        stringBuilder.append(stringJoiner);
        stringBuilder.append(" = ");
        stringBuilder.append(value);
        stringBuilder.append(" WHERE ");
        stringBuilder.append(stringJoiner);
        stringBuilder.append(" = ");

        return stringBuilder.toString();
    }
}




