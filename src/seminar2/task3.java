/*
3. *Реализуйте алгоритм сортировки пузырьком числового массива, результат после каждой итерации запишите в лог-файл.
 */


package seminar2;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class task3 {
    public static void main(String[] args) {
        int[] array = new int[] {1, 3, 6, -2, 9, 0, 5, -5};
        bubbleSort(array);
    }

    static void bubbleSort(int[] inArray){
        int temp;
        saveToFile(inArray);

        for (int i = 0; i < inArray.length - 1; i++) {
            for (int j = 0; j < inArray.length - 1; j++) {
                if (inArray[j] > inArray[j + 1]) {
                    temp = inArray[j];
                    inArray[j] = inArray[j + 1];
                    inArray[j + 1] = temp;
                }
            }
            saveToFile(inArray);
        }
    }

    static void saveToFile(int[] resultArray) {
        Logger logger = Logger.getAnonymousLogger();
        FileHandler fileHandler = null;

        try {
            fileHandler = new FileHandler("log_saveToFile_task3.txt");
            logger.addHandler(fileHandler);
        } catch (IOException e) {
            e.printStackTrace();
        }

        SimpleFormatter formatter = new SimpleFormatter();
        assert fileHandler != null;
        fileHandler.setFormatter(formatter);

        try (FileWriter saveFile = new FileWriter("result_task3.txt", true)) {
            saveFile.append(Arrays.toString(resultArray));
            saveFile.append("\n");
            saveFile.flush();
            logger.log(Level.INFO, "Данные успешно записаны в файл!");
        } catch (IOException e) {
            logger.log(Level.WARNING, e.getMessage());
        }

        fileHandler.close();
    }
}
