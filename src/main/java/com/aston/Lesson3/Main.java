package com.aston.Lesson3;

public class Main {
    public static void main(String[] args) {
        System.out.println("Задание с Продуктами");
        // Создаем массив объектов Product
        Product[] productsArray = new Product[5];

        // Заполняем массив товарами
        productsArray[0] = new Product("Samsung S25 Ultra", "01.02.2025", "Samsung Corp.", "Korea", 5599, true);
        productsArray[1] = new Product("iPhone 14", "15.09.2022", "Apple Inc.", "USA", 999, false);
        productsArray[2] = new Product("Sony WH-1000XM4", "01.08.2021", "Sony", "Japan", 349, true);
        productsArray[3] = new Product("Dell XPS 13", "10.01.2023", "Dell", "USA", 1299, false);
        productsArray[4] = new Product("Xbox Series X", "10.11.2020", "Microsoft", "USA", 600, true);

        // Выводим информацию о каждом товаре
        for (Product product : productsArray) {
            product.displayInfo();
        }

        System.out.println("Задание с Парками");

        // Создаем парк
        Park park = new Park("Сказочный парк", 3);

        // Добавляем аттракционы
        park.addAttraction(0, "Американские горки", "10:00 - 22:00", 10);
        park.addAttraction(1, "Колесо обозрения", "10:00 - 20:00", 20);
        park.addAttraction(2, "Поездка на поезде", "10:00 - 18:00", 30);

        // Выводим информацию о парке и аттракционах
        park.displayParkInfo();
    }
}
class Product {
    // Поля класса
    private String name;                // Название товара
    private String productionDate;      // Дата производства
    private String manufacturer;         // Производитель
    private String countryOfOrigin;      // Страна происхождения
    private int price;                // Цена
    private boolean isReserved;          // Состояние бронирования

    // Конструктор класса
    public Product(String name, String productionDate, String manufacturer, String countryOfOrigin, int price, boolean isReserved) {
        this.name = name;
        this.productionDate = productionDate;
        this.manufacturer = manufacturer;
        this.countryOfOrigin = countryOfOrigin;
        this.price = price;
        this.isReserved = isReserved;
    }

    // Метод для вывода информации о товаре
    public void displayInfo() {
        System.out.println("Название: " + name);
        System.out.println("Дата производства: " + productionDate);
        System.out.println("Производитель: " + manufacturer);
        System.out.println("Страна происхождения: " + countryOfOrigin);
        System.out.println("Цена: " + price);
        System.out.println("Состояние бронирования: " + (isReserved ? "Забронирован" : "Не забронирован"));
        System.out.println(); // Переход на новую строку
    }
}

class Park {
    private String name; // Название парка
    private Attraction[] attractions; // Массив аттракционов

    // Конструктор класса Park
    public Park(String name, int numberOfAttractions) {
        this.name = name;
        this.attractions = new Attraction[numberOfAttractions];
    }

    // Внутренний класс Attraction
    class Attraction {
        private String attractionName; // Название аттракциона
        private String workingHours; // Время работы
        private double ticketPrice; // Цена билета

        // Конструктор класса Attraction
        public Attraction(String attractionName, String workingHours, double ticketPrice) {
            this.attractionName = attractionName;
            this.workingHours = workingHours;
            this.ticketPrice = ticketPrice;
        }

        // Метод для вывода информации об аттракционе
        public void displayAttractionInfo() {
            System.out.println("Аттракцион: " + attractionName);
            System.out.println("Время работы: " + workingHours);
            System.out.println("Цена билета: " + ticketPrice);
            System.out.println();
        }
    }

    // Метод для добавления аттракциона
    public void addAttraction(int index, String name, String hours, int price) {
        if (index >= 0 && index < attractions.length) {
            attractions[index] = new Attraction(name, hours, price);
        } else {
            System.out.println("Индекс вне диапазона.");
        }
    }
    // Метод для вывода информации о парке и его аттракционах
    public void displayParkInfo() {
        System.out.println("Парк: " + name);
        System.out.println("Аттракционы:");
        for (Attraction attraction : attractions) {
            if (attraction != null) {
                attraction.displayAttractionInfo();
            }
        }
    }
}