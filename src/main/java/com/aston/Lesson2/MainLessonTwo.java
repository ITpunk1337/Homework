package com.aston.Lesson2;
import java.util.Scanner;

public class MainLessonTwo {
    public static void main(String[] args) {
        System.out.println("Задание 1");
        printThreeWords();

        System.out.println("Задание 2");
        checkSumSign();

        System.out.println("Задание 3");
        printColor();

        System.out.println("Задание 4");
        compareNumbers();

        System.out.println("Задание 5");
        boolean result = isSumInRange();
        System.out.println("Результат: " + result);

        System.out.println("Задание 6");
        naturalChar();

        System.out.println("Задание 7");
        boolean result1 = trueFalseChar();
        System.out.println("Результат: " + result1);

        System.out.println("Задание 8");
        printString("Hello, World!", 5);

        System.out.println("Задание 9");
        int year = 2023;
        boolean isLeapYear = isLeapYear(year);
        System.out.println("Год " + year + " " + isLeapYear);

        System.out.println("Задание 10");
        int[] array = {1, 1, 0, 0, 1, 0, 1, 1, 0, 0};
        System.out.print("Исходный массив: ");
        printArray(array);
        for (int i = 0; i < array.length; i++) {
            if (array[i] == 0) {
                array[i] = 1;
            } else {
                array[i] = 0;
            }
        }
        System.out.print("Измененный массив: ");
        printArray(array);

        System.out.println("Задание 11");
        int[] array1 = new int[100];
        for (int i = 0; i < array1.length; i++) {
            array1[i] = i + 1;
        }
        System.out.print("Заполненный массив: ");
        printArray11(array1);

        System.out.println("Задание 12");
        int[] array2 = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        System.out.print("Исходный массив: ");
        printArray12(array2);
        for (int i = 0; i < array2.length; i++) {
            if (array2[i] < 6) {
                array2[i] *= 2;
            }
        }
        System.out.print("Измененный массив: ");
        printArray12(array2);

        System.out.println("Задание 13");
        int size = 5;
        int[][] array3 = new int[size][size];
        for (int i = 0; i < size; i++) {
            array3[i][i] = 1;
        }
        printArray13(array3);

        System.out.println("Задание 14");
        int len = 5;
        int initialValue = 10;
        int[] array5 = createArray(len, initialValue);
        System.out.print("Созданный массив: ");
        printArray14(array5);
    }

    public static void printThreeWords() {
        System.out.println("Orange");
        System.out.println("Banana");
        System.out.println("Apple");
    }

    public static void checkSumSign() {
        int a = 5;
        int b = 7;
        int c = a + b;
        if (c >= 0) {
            System.out.println("Сумма положительная");
        } else {
            System.out.println("Сумма отрицательная");
        }
    }

    public static void printColor() {
        int value = 101;
        if (value <= 0) {
            System.out.println("Красный");
        } else if (value > 0 && value <= 100) {
            System.out.println("Жёлтый");
        } else if (value > 100) {
            System.out.println("Зелёный");
        }
    }

    public static void compareNumbers() {
        int a = 5;
        int b = 7;
        if (a > b) {
            System.out.println("a>=b");
        } else if (a < b) {
            System.out.println("a<b");
        } else if (a == b) {
            System.out.println("ОШИБКА, ЧИСЛА ОДИНАКОВЫЕ");
        }
    }

    public static boolean isSumInRange() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите числа а и б");
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        int sum = a + b;
        if (sum >= 10 && sum <= 20) {
            return true;
        } else {
            return false;
        }
    }

    public static void naturalChar() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите число");
        int m = scanner.nextInt();
        if (m >= 0) {
            System.out.println("Число положительное");
        }
        else {
            System.out.println("Число отрицательное");
        }
    }
    public static boolean trueFalseChar() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите число");
        int n = scanner.nextInt();
        if (n >= 0) {
            return false;
        } else {
            return true;
        }
    }


    public static void printString(String str, int count) {
        for (int i = 0; i < count; i++) {
            System.out.println(str);
        }
    }
    public static boolean isLeapYear(int year) {
        if (year % 4 == 0) {
            if (year % 100 == 0) {
                if (year % 400 == 0) {
                    return true;
                } else {
                    return false;
                }
            } else {
                return true;
            }
        } else {
            return false;
        }
    }
    public static void printArray(int[] array) {
        for (int value : array) {
            System.out.print(value + " ");
        }
        System.out.println();
    }
    public static void printArray11(int[] array) {
        for (int value : array) {
            System.out.print(value + " ");
        }
        System.out.println();
    }
    public static void printArray12(int[] array) {
        for (int value : array) {
            System.out.print(value + " ");
        }
        System.out.println();
    }
    public static void printArray13(int[][] array) {
        for (int[] row : array) {
            for (int value : row) {
                System.out.print(value + " ");
            }
            System.out.println();
        }
    }
    public static int[] createArray(int len, int initialValue) {
        int[] array4 = new int[len];
        for (int i = 0; i < len; i++) {
            array4[i] = initialValue;
        }
        return array4;
    }
    public static void printArray14(int[] array) {
        for (int value : array) {
            System.out.print(value + " ");
        }
        System.out.println();
    }
}
