package com.aston.Lesson4;

public class Main {
    public static void main(String[] args) {
        System.out.println("Задание про котиков и собачек");
        Dog dogBobik = new Dog("Бобик");
        dogBobik.run(150);
        dogBobik.run(550);
        dogBobik.swim(8);
        dogBobik.swim(20);

        Cat catBarsik = new Cat("Барсик");
        catBarsik.run(100);
        catBarsik.run(300);
        catBarsik.swim(5);



        // Создаем массив котов
        Cat[] cats = {
                new Cat("Мурзик"),
                new Cat("Васька"),
                new Cat("Пушок"),
                new Cat("Рыжик")
        };

        System.out.println("Всего животных: " + Animal.getAnimalCount());
        System.out.println("Всего собак: " + Dog.getDogCount());
        System.out.println("Всего котов: " + Cat.getCatCount());

        Bowl bowl = new Bowl(10);

        // Попросим всех котов покушать по 3 единицы еды из миски
        for (Cat c : cats) {
            c.eat(bowl, 3);
        }

        // Выведем сытость котов
        System.out.println("\nИнформация о сытости котов:");
        for (Cat c : cats) {
            System.out.println(c.name + " сыт: " + c.isFull());
        }

        // Добавим еды в миску и попросим один из котов попробовать покушать еще раз
        bowl.addFood(5);
        cats[1].eat(bowl, 3);
        System.out.println(cats[1].name + " сыт: " + cats[1].isFull());

        System.out.println("\n" + "Задание про фигуры");

        Shape circle = new Circle(5, "Red", "Black");
        Shape rectangle = new Rectangle(4, 6, "Blue", "Green");
        Shape triangle = new Triangle(3, 4, 5, "Yellow", "Purple");

        printShapeInfo(circle);
        printShapeInfo(rectangle);
        printShapeInfo(triangle);
    }

    private static void printShapeInfo(Shape shape) {
        System.out.println("Фигура: " + shape.getClass().getSimpleName());
        System.out.println("Периметр: " + shape.calculatePerimeter());
        System.out.println("Площадь: " + shape.calculateArea());
        System.out.println("Цвет заливки: " + shape.getFillColor());
        System.out.println("Цвет границы: " + shape.getBorderColor());
        System.out.println();
    }


}

class Animal {
    protected String name;
    private static int animalCount = 0;

    public Animal(String name) {
        this.name = name;
        animalCount++;
    }

    public void run(int distance) {
        System.out.println(name + " пробежал " + distance + " м.");
    }

    public void swim(int distance) {
        System.out.println(name + " проплыл " + distance + " м.");
    }

    public static int getAnimalCount() {
        return animalCount;
    }
}

class Dog extends Animal {
    private static int dogCount = 0;
    private static final int MAX_RUN = 500;
    private static final int MAX_SWIM = 10;

    public Dog(String name) {
        super(name);
        dogCount++;
    }

    @Override
    public void run(int distance) {
        if (distance <= MAX_RUN) {
            System.out.println(name + " пробежал " + distance + " м.");
        } else {
            System.out.println(name + " не может пробежать " + distance + " м. Максимум " + MAX_RUN + " м.");
        }
    }

    @Override
    public void swim(int distance) {
        if (distance <= MAX_SWIM) {
            System.out.println(name + " проплыл " + distance + " м.");
        } else {
            System.out.println(name + " не может проплыть " + distance + " м. Максимум " + MAX_SWIM + " м.");
        }
    }

    public static int getDogCount() {
        return dogCount;
    }
}

class Cat extends Animal {
    private static int catCount = 0;
    private static final int MAX_RUN = 200;
    private static final int MAX_SWIM = 0; // коты не умеют плавать
    private boolean isFull = false;

    public Cat(String name) {
        super(name);
        catCount++;
    }



    @Override
    public void run(int distance) {
        if (distance <= MAX_RUN) {
            System.out.println(name + " пробежал " + distance + " м.");
        } else {
            System.out.println(name + " не может пробежать " + distance + " м. Максимум " + MAX_RUN + " м.");
        }
    }

    @Override
    public void swim(int distance) {
        System.out.println(name + " не умеет плавать.");
    }

    public boolean isFull() {
        return isFull;
    }

    /**
     * Попытка покушать из миски определённым количеством еды.
     * Если еды достаточно, кот ест и становится сытым.
     * Иначе кот не трогает еду.
     */
    public void eat(Bowl bowl, int amount) {
        if (bowl.getFood() >= amount && !isFull) {
            bowl.decreaseFood(amount);
            isFull = true;
            System.out.println(name + " съел " + amount + " единиц еды и теперь сыт.");
        } else if (isFull) {
            System.out.println(name + " уже сыт и не хочет есть.");
        } else {
            System.out.println(name + " не стал есть, потому что в миске недостаточно еды.");
        }
    }
    public static int getCatCount() {
        return catCount;
    }
}

class Bowl {
    private int food;

    public Bowl(int food) {
        this.food = Math.max(food, 0); // не может быть отрицательным
    }

    public int getFood() {
        return food;
    }

    /**
     * Добавляет еду в миску. Количество не может стать отрицательным.
     */
    public void addFood(int amount) {
        if (amount > 0) {
            food += amount;
            System.out.println("В миску добавлено " + amount + " единиц еды. Теперь в миске " + food + ".");
        } else {
            System.out.println("Нельзя добавить отрицательное количество еды.");
        }
    }

    /**
     * Уменьшает количество еды в миске. Если остается меньше 0, ставим 0.
     * Используется, когда кот ест.
     */
    public void decreaseFood(int amount) {
        if (amount > 0) {
            food -= amount;
            if (food < 0) food = 0;
        }
    }
}
interface Shape {
    // Поля для цвета заливки и цвета границы
    String getFillColor();
    String getBorderColor();

    // Дефолтные методы для расчета периметра и площади
    default double calculatePerimeter() {
        return 0;
    }

    default double calculateArea() {
        return 0;
    }
}
class Circle implements Shape {
    private double radius;
    private String fillColor;
    private String borderColor;

    public Circle(double radius, String fillColor, String borderColor) {
        this.radius = radius;
        this.fillColor = fillColor;
        this.borderColor = borderColor;
    }

    @Override
    public double calculatePerimeter() {
        return 2 * Math.PI * radius;
    }

    @Override
    public double calculateArea() {
        return Math.PI * radius * radius;
    }

    @Override
    public String getFillColor() {
        return fillColor;
    }

    @Override
    public String getBorderColor() {
        return borderColor;
    }
}
class Rectangle implements Shape {
    private double width;
    private double height;
    private String fillColor;
    private String borderColor;

    public Rectangle(double width, double height, String fillColor, String borderColor) {
        this.width = width;
        this.height = height;
        this.fillColor = fillColor;
        this.borderColor = borderColor;
    }

    @Override
    public double calculatePerimeter() {
        return 2 * (width + height);
    }

    @Override
    public double calculateArea() {
        return width * height;
    }

    @Override
    public String getFillColor() {
        return fillColor;
    }

    @Override
    public String getBorderColor() {
        return borderColor;
    }
}
class Triangle implements Shape {
    private double sideA;
    private double sideB;
    private double sideC;
    private String fillColor;
    private String borderColor;

    public Triangle(double sideA, double sideB, double sideC, String fillColor, String borderColor) {
        this.sideA = sideA;
        this.sideB = sideB;
        this.sideC = sideC;
        this.fillColor = fillColor;
        this.borderColor = borderColor;
    }

    @Override
    public double calculatePerimeter() {
        return sideA + sideB + sideC;
    }

    @Override
    public double calculateArea() {
        double s = calculatePerimeter() / 2; // Полупериметр
        return Math.sqrt(s * (s - sideA) * (s - sideB) * (s - sideC)); // Формула Герона
    }

    @Override
    public String getFillColor() {
        return fillColor;
    }

    @Override
    public String getBorderColor() {
        return borderColor;
    }
}
