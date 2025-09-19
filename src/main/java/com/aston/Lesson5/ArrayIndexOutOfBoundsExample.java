package com.aston.Lesson5;

public class ArrayIndexOutOfBoundsExample {
    public static void main(String[] args) {
        int[] array = {1, 2, 3};

        try {
            // Попытка доступа к элементу за пределами массива
            System.out.println(array[5]);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Ошибка: " + e.getMessage());
        }
    }
}
