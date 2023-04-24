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
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.*;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class task1 {
    public static void main(String[] args) throws FileNotFoundException {
        String file = "students-list.txt";
        String txt = jsonString(file);
        System.out.println(txt);
        assert txt != null;
        test(txt);
    }

//
//    static void textToList(String originalString){
//        String Str = originalString.replaceAll("[\\[\\]{} ]", "");
//        Map<String, Object> row1 = new HashMap<String, Object>();
//        Map<String, Object> row2 = new HashMap<String, Object>();
//        Map<String, Object> row3 = new HashMap<String, Object>();
//
//    }



    static void test(String testString) {
        String Str = testString.replaceAll("[\\[\\]\"{} ]", "");
        int stringLines = Str.split(",").length;
        String[][] studentsArray = new String[stringLines][2];
        Hashtable<Object, Hashtable<String, Objects>> students = new Hashtable<Object, Hashtable<String, Objects>>();
        int tempLine = 0;


        for (String reveal: Str.split(",")) {
            for (String i:reveal.split(":")) {
                studentsArray[tempLine] = i;
                temp
            }
            tempLine++;
        }
        System.out.println(Arrays.deepToString(studentsArray));
        for (int i = 1; i < (stringLines/3)+1; i++) {
            students.put(Character.toString((char) i), getDictionary(studentsArray, i));
        }
//        System.out.println(stringLines);
        System.out.println(students);
    }

    static Hashtable getDictionary(String[][] str, int count){
        Hashtable<Object, String> person = new Hashtable<Object, String>();
//        for (int i = 0; i < 3; i++) {
//            person.put();
//        }
        return null;
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
            return stringBuilder.toString();
        } catch (IOException e) {
            logger.log(Level.WARNING, e.getMessage());
        }
        fileHandler.close();
        return null;
    }


}
