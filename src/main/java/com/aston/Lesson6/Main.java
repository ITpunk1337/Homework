package com.aston.Lesson6;

public class Main {
    public static void main(String[] args) {
        System.out.println("Задание 1");
        StudentManager studentManager = new StudentManager();

        // Добавляем студентов
        studentManager.addStudent(new Student("Иванов И.И.", "Группа 1", 0, new double[]{4.0, 3.5, 5.0}));
        studentManager.addStudent(new Student("Петров П.П.", "Группа 1", 0, new double[]{5.0, 3.0, 4.5}));
        studentManager.addStudent(new Student("Сидоров С.С.", "Группа 2", 1, new double[]{3.5, 4.0, 4.5}));
        studentManager.addStudent(new Student("Кузнецов К.К.", "Группа 2", 1, new double[]{4.5, 5.0, 5.0}));
        studentManager.addStudent(new Student("Смирнов А.И.", "Группа 3", 2, new double[]{4.0, 3.5, 5.0}));
        studentManager.addStudent(new Student("Петрова П.П.", "Группа 3", 2, new double[]{2.5, 3.0, 2.5}));
        studentManager.addStudent(new Student("Сидоров М.М.", "Группа 4", 3, new double[]{3.5, 4.0, 4.5}));
        studentManager.addStudent(new Student("Кузнец К.Н.", "Группа 4", 3, new double[]{4.5, 5.0, 5.0}));


        // Удаляем студентов с низким средним баллом
        studentManager.removeLowPerformingStudents();

        // Переводим студентов на следующий курс
        studentManager.promoteStudents();

        // Печатаем студентов на 1 курсе
        studentManager.printStudents(1);

        // Печатаем студентов на 2 курсе
        studentManager.printStudents(2);

        studentManager.printStudents(3);

        studentManager.printStudents(4);

        System.out.println("");
        System.out.println("Задание 2");

        PhoneBook phoneBook = new PhoneBook();

        // Добавляем записи
        phoneBook.add("Иванов", "123-456");
        phoneBook.add("Иванов", "789-012");
        phoneBook.add("Петров", "345-678");
        phoneBook.add("Сидоров", "901-234");

        // Получаем номера по фамилии
        System.out.println("Номера для Иванова: " + phoneBook.get("Иванов"));
        System.out.println("Номера для Петрова: " + phoneBook.get("Петров"));
        System.out.println("Номера для Сидорова: " + phoneBook.get("Сидоров"));
        System.out.println("Номера для Смирновой: " + phoneBook.get("Смирнова")); // Не существует

        // Выводим все записи
        System.out.println("\nВсе записи в справочнике:");
        phoneBook.printAll();
    }
}
