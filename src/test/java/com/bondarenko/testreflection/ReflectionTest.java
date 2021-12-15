package com.bondarenko.testreflection;

import com.bondarenko.reflection.Reflection;
import com.bondarenko.testreflection.testClasses.ClassForTest;
import com.bondarenko.testreflection.testClasses.TestClassWithMethodsWithoutParameters;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;


public class ReflectionTest {

    private Reflection reflection = new Reflection();

    @Test
    public void testInvokeMethodsWithoutParameters() {
        TestClassWithMethodsWithoutParameters testObject = new TestClassWithMethodsWithoutParameters();

        List<?> methods = reflection.invokeMethodsWithoutParameters(testObject);

        assertEquals(4, methods.size());
        assertTrue(methods.contains("method1"));
        assertTrue(methods.contains("method3"));
        assertFalse(methods.contains("method2"));

    }

    @Test
    public void testCreateObject() {
        assertEquals("com.bondarenko.testReflection.testClasses.ClassForTest",
                reflection.createObject(ClassForTest.class).getClass().getName());

        Object object = reflection.createObject(String.class);
        assertEquals("", object);
    }

    @Test
    public void testclassWithoutPublicMethods() {

        List<?> methods = reflection.classWithoutPublicMethods(TestClassWithMethodsWithoutParameters.class);

        assertEquals(1, methods.size());

        assertTrue(methods.contains("method4"));

    }

    @Test
    public void testsMethodsWithSignatureContainsFinal() {
        TestClassWithMethodsWithoutParameters testObject = new TestClassWithMethodsWithoutParameters();

        List<?> methods = reflection.methodsWithSignatureContainsFinal(testObject);

        assertEquals(1, methods.size());

        assertTrue(methods.contains("method5"));

    }

    @Test
    public void testMethodReturnAllSuperClassesAndInterfacesOfClass() {

        List<?> ListWithSuperClassesAndInterfaces = reflection.methodReturnAllSuperClassesAndInterfacesOfClass(TestClassWithMethodsWithoutParameters.class);

        assertEquals(2, ListWithSuperClassesAndInterfaces.size());
    }
    @Test
    public void testSetDefaultValues() throws ReflectiveOperationException {
        //prepare
        ClassForTest testClass = new ClassForTest();

        //when
        reflection.setPrivateFieldsToNullFields(testClass);

        //then
//        assertEquals(0, testClass.getPrivateByte());
//        assertEquals(5, testClass.getPublicByte());
        assertEquals(0, testClass.getPrivateInteger());
        assertEquals(5, testClass.getPublicInteger());
        assertEquals(0, testClass.getPrivateShort());
        assertEquals(5, testClass.getPublicShort());
        assertEquals(0, testClass.getPrivateLong());
        assertEquals(5, testClass.getPublicLong());
        assertEquals(0.0, testClass.getPrivateDouble(), 0);
        assertEquals(5.0, testClass.getPublicDouble(), 0);
        assertEquals(0.0, testClass.getPrivateFloat(), 0);
        assertEquals(5.0, testClass.getPublicFloat(), 0);
        assertEquals(0, testClass.getPrivateChar());
        assertEquals('a', testClass.getPublicChar());
        assertFalse(testClass.getPrivateBoolean());
        assertTrue(testClass.getPublicBoolean());
        assertNull(testClass.getPrivateString());
        assertEquals("Hi!", testClass.getPublicString());

    }
    @Test
    public void testInvokeMethodReplacedPrivateFieldsToNullFields() throws IllegalAccessException {
        TestClassWithMethodsWithoutParameters testObject = new TestClassWithMethodsWithoutParameters();

       /* Object object =reflection.invokeMethodReplacedPrivateFieldsToNullFields(testObject);
        List<?> methods = reflection.invokeMethodReplacedPrivateFieldsToNullFields(testObject);
        assertEquals(1, methods.size());
        assertTrue(methods.contains("a"));*/

    }


}



