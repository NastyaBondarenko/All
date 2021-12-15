package com.bondarenko.twentymethods;

public class TwentyMethods {
    public static void main(String[] args) {

        //1)
        char[] array = {'A', 'B', 'C'};
        arrayOfChar(array);

        //2)
        int[] array3 = {1, 2, 3};
        charArrayFromIntArray(array3);

        //3
        maxOfTwoNumerics(5, 1);

        //4
        maxOfThreeNumerics(5, 1, 7);

        //5
        maxOfFiveNumerics(6, 3, 5, 2, 8);

        //6* result = V
        char[] array4 = {'V', 'A', 'L', 'Y', 'A'};
        stringOfCharSymbols(array4);

        //8
        int[] array1 = {3, 4, 2, 3};
        indexOf(array1, 2);

        //9
        lastIndexOf(array1, 3);

        //10
        factorial(3);

        //11
        leapYear(1991);

        //12
        multipleElements(array1, 2);

        //13
        sortArray(array1);

        //14
        byte[] array5 = {4, 5, 1, 4};
        doubleElementsOfArray(array5);

        //15* result=[I@1e643faf
        int array6[] = {4, 2};
        int array7[] = {8, 1};
        multiplyTwoArrays(array6, array7);

        //16* result [I@1e643faf
        arrayWithdifferentElements(array6, array7);

        //17*
        reverse(array6);

        //18*
        randomArray(10, 3, 6);

        //19
        char[] array8 = {'A', 'B', 'D'};
        char[] array9 = {'A', 'B', 'C'};
        checkSubsequenceElementsOfArrays(array8, array9);

    }

    //1) принимает массив чаров, выводит его на экран
    static void arrayOfChar(char[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }

    //2) принимает массив интов, возвращает массив чаров, каждый символ в позиции массива соответствует коду символа передаваемого инта
    static char[] charArrayFromIntArray(int[] array) {
        char[] arrayOfChar = new char[array.length];
        for (int i = 0; i < array.length; i++) {
            char cast = (char) array[i];
            arrayOfChar[i] = cast;
        }
        return arrayOfChar;
    }

    //3) приминает 2 инта, а и б, возвращает большее их этих 2х чисел
    static int maxOfTwoNumerics(int a, int b) {
        return a > b ? a : b;
    }

    //4)принимает 3инта,возвращает большее из них
    static int maxOfThreeNumerics(int a, int b, int c) {
        return maxOfTwoNumerics((maxOfTwoNumerics(a, b)), c);
    }

    //5) приминает 5 интов, возвращает большее из них
    static int maxOfFiveNumerics(int a, int b, int c, int d, int e) {
        return maxOfTwoNumerics(maxOfThreeNumerics(a, b, c), maxOfTwoNumerics(d, e));
    }

    //6) принимает массив чаров, возвращает строку состоящую из символов массива (symbols.toString)
    static String stringOfCharSymbols(char[] array) {
        String symbols = "";
        for (int i = 0; i < array.length; i++) {
            symbols += array[i];
            return symbols;
        }
        return symbols;
    }

    //8) принимает массив интов, и значение типа инт, возвращает индекс массива в котором значение совпадает с передаваемым,
    //начиная с начала массива. Если значения в массиве нет возвращает -1
    static int indexOf(int[] array, int value) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == value) {
                return i;
            }
        }
        return -1;
    }

    //9) принимает массив интов, и значение типа инт, возвращает индекс массива в котором значение
    //совпадает с передаваемым, начиная с конца массива. Если значения в массиве нет возвращает -1
    static int lastIndexOf(int[] array, int value) {
        for (int i = array.length - 1; i >= 0; i--) {
            if (array[i] == value) {
                return i;
            }
        }
        return -1;
    }

    //10) метод принимает инт, и возвращает факториал от заданого инта
    static int factorial(int n) {
        if (n == 1) {
            return 1;
        }
        int result = 1;
        for (int i = 1; i <= n; i++) {
            result = result * i;
        }
        return result;
    }

    //11.принимает инт год, и возвращает тру если год высокосный.Рік вважається високосним, якщо він ділиться на 4.
    // Винятком є роки, які кратні 100 (такі роки є високосними тільки тоді, якщо вони ще діляться на 400).
    static boolean leapYear(int year) {
        return ((year % 4 == 0) && (year % 100 != 0) || (year % 100 == 0 && year % 400 == 0));
    }

    //12) приминает массив интов и число, выводит на екран только елементы массива которые кратны этому числу
    static int multipleElements(int[] array, int n) {

        for (int i = 0; i < array.length; i++) {
            if (array[i] % n == 0) {
                return array[i];
            }
        }
        return 0;
    }

    //13) метод принимает массив интов сортирует его по возрастанию
    static void sortArray(int[] array) {
        int temp = 0;
        for (int i = 0; i < array.length; i++) {
            for (int j = 1; j < (array.length - i); j++) {
                if (array[j - 1] > array[j]) {
                    temp = array[j - 1];
                    array[j - 1] = array[j];
                    array[j] = temp;
                }
            }
        }
    }

    //14) принимает массив байт, если в массиве есть повторяющиеся елементы, возвращает тру
    static boolean doubleElementsOfArray(byte[] array) {
        for (byte i = 0; i < array.length; i++) {
            for (byte j = (byte) (i + 1); j < array.length; j++) {
                if (array[i] == array[j]) {
                    return true;
                }
            }
        }
        return false;
    }

    //15) принимает два массива интов одинаковых по длинне, возращает массив интов который состоит из перемноженных елементов входящих массивов
    static int[] multiplyTwoArrays(int[] array1, int[] array2) {
        int[] multiplyArray = new int[array1.length];
        for (int i = 0; i < array1.length; i++) {
            multiplyArray[i] = array1[i] * array2[i];
        }
        System.out.println(multiplyArray);

        return multiplyArray;
    }

    //16) принимает два массива интов, возвращает массив из елементов которые не совпадают в массивах
    static int[] arrayWithdifferentElements(int[] array1, int[] array2) {
        int[] arrayWithdifferentElements = new int[array1.length + array2.length];
        for (int i = 0; i < array1.length; i++) {
            for (int j = 0; j < array2.length; j++)
                if (array1[i] != array2[j]) {
                    arrayWithdifferentElements[i] = array1[i];
                }
        }
        return arrayWithdifferentElements;
    }

    //17)принимает масив интов, возвращает его же но в реверсном порядке
    static int[] reverse(int[] array) {
        for (int i = 0; i < array.length / 2; i++) {
            int element = array[i];
            array[i] = array[array.length - 1 - i];
            array[array.length - 1 - i] = element;
        }
        return array;
    }

    // 18)принимает 3 инта: -размер выходного массива, -нижняя граница, -верхняя граница
    // возвращает массив интов заданой длинный,который содержит случайные числа от нижней границы до верхней границы"
    static int[] randomArray(int arrayLength, int low, int high) {
        int[] randomArray = new int[arrayLength];
        for (int i = 0; i < arrayLength; i++) {
            randomArray[i] = (int) Math.random();
            if (low < randomArray[i] && (randomArray[i] < high)) {
                return randomArray;
            }
        }
        return randomArray;
    }

    //19)принимает 2 массива чаров, проверяет есть ли в 1 массиве, такая же последовательность символов которую
    // представляет собой второй массив.Возвращает булеан
    static boolean checkSubsequenceElementsOfArrays(char[] array1, char[] array2) {
        for (int i = 0; i < array1.length; i++) {
            for (int j = 0; j < array2.length; j++) {
                if (array1[j] == array2[i]) ;
            }
        }
        return true;
    }
}


