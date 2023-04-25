/*
1. Дана json строка [{ "фамилия":"Иванов","оценка":"5","предмет":"Математика"},
{"фамилия":"Петрова","оценка":"4","предмет":"Информатика"},{"фамилия":"Краснов","оценка":"5","предмет":"Физика"}]
Задача написать метод(ы), который распарсит строку и выдаст ответ вида:
Студент Иванов получил 5 по предмету Математика.
Студент Петрова получил 4 по предмету Информатика.
Студент Краснов получил 5 по предмету Физика.
Используйте StringBuilder для подготовки ответа
Исходная json строка это просто String !!! Для работы используйте методы String, такие как replace, split,
substring и т.д. по необходимости
Создать метод, который запишет результат работы в файл. Обработайте исключения и запишите ошибки в лог файл.
2. *Получить исходную json строку из файла, используя FileReader или Scanner
*/

package seminar2;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class task1 {
    public static void main(String[] args) throws FileNotFoundException {
        String file = "students-list.txt";
        String jsonString = jsonString(file);
        assert jsonString != null;
        savetoFile(createStrings(jsonString));
    }


    static String createStrings(String testString) {
        String Str = testString.replaceAll("[\\[\\]\"{} ]", "");
        int stringLines = Str.split(",").length;
        String[][] studentsArray = new String[stringLines][2];
        int tempLine = 0;

        for (String reveal : Str.split(",")) {
            int tempSubLine = 0;
            for (String i : reveal.split(":")) {
                studentsArray[tempLine][tempSubLine] = i;
                tempSubLine++;
            }
            tempLine++;
        }

        String[] t = new String[]{"Студент ", " получил ", " по предмету "};
        StringBuilder result = new StringBuilder();

        int i = 0;
        for (String[] j : studentsArray) {
            result.append(t[i]);
            result.append(j[1]);
            i++;
            if (i > 2) {
                result.append(".\n");
                i = 0;
            }
        }

        return result.toString();
    }


    static void savetoFile(String result) {
        Logger logger = Logger.getAnonymousLogger();
        FileHandler fileHandler = null;

        try {
            fileHandler = new FileHandler("log_saveToFile.txt");
            logger.addHandler(fileHandler);
        } catch (IOException e) {
            e.printStackTrace();
        }

        SimpleFormatter formatter = new SimpleFormatter();
        assert fileHandler != null;
        fileHandler.setFormatter(formatter);

        try (FileWriter saveFile = new FileWriter("result-list.txt", false)) {
            saveFile.append(result);
            saveFile.flush();
            logger.log(Level.INFO, "Данные успешно записаны в файл!");
        } catch (IOException e) {
            logger.log(Level.WARNING, e.getMessage());
        }

        fileHandler.close();
    }

    static String jsonString(String studentsList) throws FileNotFoundException {
        Logger logger = Logger.getAnonymousLogger();
        FileHandler fileHandler = null;

        try {
            fileHandler = new FileHandler("log.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }

        SimpleFormatter formatter = new SimpleFormatter();
        assert fileHandler != null;
        fileHandler.setFormatter(formatter);
        logger.addHandler(fileHandler);
        StringBuilder stringBuilder = new StringBuilder();

        try (FileReader fileReader = new FileReader(studentsList)) {
            int letter;
            while ((letter = fileReader.read()) > 0) {
                stringBuilder.append((char) letter);
            }
            fileHandler.close();
            return stringBuilder.toString();
        } catch (IOException e) {
            logger.log(Level.WARNING, e.getMessage());
            return null;
        }
    }


}
