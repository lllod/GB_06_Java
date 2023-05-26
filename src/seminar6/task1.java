/*
Подумать над структурой класса Ноутбук для магазина техники - выделить поля и методы. Реализовать в java.
Создать множество ноутбуков.
Написать метод, который будет запрашивать у пользователя критерий (или критерии) фильтрации и выведет ноутбуки,
отвечающие фильтру. Критерии фильтрации можно хранить в Map. Например: “Введите цифру, соответствующую необходимому
критерию:
1 - ОЗУ
2 - Объем ЖД
3 - Операционная система
4 - Цвет …
Далее нужно запросить минимальные значения для указанных критериев - сохранить параметры фильтрации можно также в Map.
Отфильтровать ноутбуки из первоначального множества и вывести проходящие по условиям.
 */


package seminar6;

public class task1 {
    public static void main(String[] args) {
        LaptopsStore laptopsStore = new LaptopsStore();

        Laptop laptop1 = new Laptop(8, 512, "Windows", "Red");
        Laptop laptop2 = new Laptop(12, 1024, "Linux", "Black");
        Laptop laptop3 = new Laptop(4, 2048, "Windows", "Blue");
        Laptop laptop4 = new Laptop(16, 1024, "Mac", "Black");
        Laptop laptop5 = new Laptop(32, 512, "Linux", "Orange");
        Laptop laptop6 = new Laptop(64, 1536, "Windows", "Black");
        Laptop laptop7 = new Laptop(12, 1024, "Mac", "Gray");
        Laptop laptop8 = new Laptop(24, 4096, "Linux", "Blue");
        Laptop laptop9 = new Laptop(128, 8192, "Windows", "Orange");

        laptopsStore.addLaptop(laptop1);
        laptopsStore.addLaptop(laptop2);
        laptopsStore.addLaptop(laptop3);
        laptopsStore.addLaptop(laptop4);
        laptopsStore.addLaptop(laptop5);
        laptopsStore.addLaptop(laptop6);
        laptopsStore.addLaptop(laptop7);
        laptopsStore.addLaptop(laptop8);
        laptopsStore.addLaptop(laptop9);

        laptopsStore.filter();
    }
}
