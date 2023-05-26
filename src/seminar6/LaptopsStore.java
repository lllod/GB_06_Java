package seminar6;

import java.util.*;

public class LaptopsStore {

    private final Map<Integer, String> criterias;
    private Set<Laptop> dataBase;
    private StringBuilder stringBuilder;
    private Map<Integer, String> userCriterias;
    private String userChoice;

    public LaptopsStore(){
        this.dataBase = new HashSet<>();
        this.criterias = new TreeMap<>();
    }

    public void addLaptop(Laptop newLaptop){
        dataBase.add(newLaptop);
    }

    public Set<Laptop> iterator(){
        return dataBase;
    }

    private void printCriterias(){
        criterias.put(1, "Объем ОЗУ");
        criterias.put(2, "Объем HDD");
        criterias.put(3, "Операционная система");
        criterias.put(4, "Цвет");
        criterias.put(0, "Закончить");
        for (int i = 0; i < criterias.size(); i++) {
            int key = (int) criterias.keySet().toArray()[i];
            stringBuilder = new StringBuilder();
            stringBuilder.append(key).append(": ").append(criterias.get(key));
            System.out.println(stringBuilder.toString());
        }
    }

    private void mainMenu(){
        userCriterias = new HashMap<>();
        Scanner scanner = new Scanner(System.in);
        while (!scanner.toString().equals("0")){
            if (userCriterias.size() == 4){
                System.out.println("<!-- Вы выбрали все доступные критерии! --!>");
                break;
            }
            System.out.println("<!-- Выберите критерий, по которому требуется осуществить поиск:  --!>");
            printCriterias();
            int userNum = scanner.nextInt();
            if (userNum == 1){
                System.out.println("Введите минимальное значение ОЗУ в Гб:");
                userChoice = scanner.next();
                userCriterias.put(1, userChoice);
            } else if (userNum == 2) {
                System.out.println("Введите минимальный объем HDD в Мб:");
                userChoice = scanner.next();
                userCriterias.put(2, userChoice);
            } else if (userNum == 3) {
                System.out.println("Введите тип операционной системы (Windows, Linux, Mac):");
                userChoice = scanner.next();
                userCriterias.put(3, userChoice.substring(0, 1).toUpperCase() + userChoice.substring(1));
            } else if (userNum == 4) {
                System.out.println("Введите цвет корпуса ноутбука (Red, Black, Blue, Orange, Gray):");
                userChoice = scanner.next();
                userCriterias.put(4, userChoice.substring(0, 1).toUpperCase() + userChoice.substring(1));
            } else if (userNum == 0){
                break;
            } else {
                System.out.println("<!-- Выбран некорректный пункт меню! Повторите выбор --!>");
            }
        }
    }

    public void filter() {
        Set<Laptop> filteredLaptops = new HashSet<>();

        mainMenu();
        userCriterias.putIfAbsent(1, null);
        userCriterias.putIfAbsent(2, null);
        userCriterias.putIfAbsent(3, null);
        userCriterias.putIfAbsent(4, null);

        for (Laptop laptop: dataBase) {
            if (userCriterias.get(1) == null && userCriterias.get(2) == null && userCriterias.get(3) == null &&
                    userCriterias.get(4) == null) {
                System.out.println("<!-- Критерии для поиска не выбраны! --!>");
                break;
            }

            if (userCriterias.get(1) == null ||
                    Integer.parseInt(userCriterias.get(1)) <= laptop.getRam()) {
                if (userCriterias.get(2) == null ||
                        Integer.parseInt(userCriterias.get(2)) <= laptop.getHdd()) {
                    if (userCriterias.get(3) == null ||
                            Objects.equals(userCriterias.get(3), laptop.getOperatingSystem())) {
                        if (userCriterias.get(4) == null ||
                                Objects.equals(userCriterias.get(4), laptop.getColor())) {
                            filteredLaptops.add(laptop);
                        }
                    }
                }
            }
        }
        if (filteredLaptops.isEmpty()) {
            System.out.println("\n");
            System.out.println("<!-- Ноутбуки, подходящие под заданные параметры, не найдены! --!>");
            System.out.println("\n");
        } else {
            System.out.println("\n");
            System.out.println("<!-- Ноутбуки, подходящие под заданные параметры: --!>");
            System.out.println("\n");
            for (Laptop laptop: filteredLaptops) {
                System.out.println(laptop);
            }
        }
    }
}

/*
мейби, отдельные менюшки для ОС и цвета, чтобы пользователь печатал не наименования, а цифру, как в основном меню
 */
