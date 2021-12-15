package com.bondarenko.queryGeneratorTest;

import com.bondarenko.annotation.querygenerator.Person;
import com.bondarenko.annotation.querygenerator.QueryGenerator;
import com.bondarenko.annotation.querygenerator.Table;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class QueryGeneratorTest {

    @Test
    public void testGetAll() {
        QueryGenerator queryGenerator = new QueryGenerator();
        String getAllSql = queryGenerator.getAll(Person.class);

        String expectedSql = "SELECT id, person_name, salary FROM persons;";

        assertEquals(expectedSql, getAllSql);
    }

    @Test
    public void testGetById() {
        QueryGenerator queryGenerator = new QueryGenerator();
        String getById = queryGenerator.getById(Person.class, 10);

        String expectedSql = "SELECT * FROM persons WHERE id=10";
        assertEquals(expectedSql, getById);
    }

    @Test
    public void testInsert() {
        QueryGenerator queryGenerator = new QueryGenerator();
        Object value = "12456";
        String insert = queryGenerator.insert(value);
        Class<?> clazz = value.getClass();

        String expectedSql = "INSERT INTO persons (id) VALUES ('12456')";
        assertEquals(expectedSql, insert);
    }

    @Test
    public void delete() {
        QueryGenerator queryGenerator = new QueryGenerator();
        Object value = "12456";
        String delete = queryGenerator.delete(value);
        Class<?> clazz = value.getClass();

        String expectedSql = "DELETE FROM persons WHERE id = 12456";
        assertEquals(expectedSql, delete);
    }

    @Test
    public void update() {
        QueryGenerator queryGenerator = new QueryGenerator();
        Object value = "12456";
        String update = queryGenerator.delete(value);
        Class<?> clazz = value.getClass();

        String expectedSql = "UPDATE persons SET id = 3 WHERE id = 12456";
        assertEquals(expectedSql, update);
    }
}
