/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package informationSystem;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class DataUtils {

    public static String[] getArr(String str) {
        int length = str.length();
        int arrIndex = 0;

        ArrayList<String> valuesArr = new ArrayList();
        String raw = "";

        for (int i = 0; i < length; i++) {

            if (str.charAt(i) == '~') {
                valuesArr.add(raw);
                raw = "";
                arrIndex++;
            }
            else {
                raw = raw + str.charAt(i);
            }
        }
        
        String[] extractedArr = new String[valuesArr.size()];
        for(int i= 0; i < valuesArr.size(); i++){
            extractedArr[i] = valuesArr.get(i);
        }
        
        return extractedArr;
    }

    public static ArrayList<String[]> getStringData(String path) throws FileNotFoundException {
        ArrayList<String[]> fileData = new ArrayList();
        File readFile = new File(path);
        Scanner fileScanner;

        // Scanner will split on spaces if delimiter is not specified. 
        fileScanner = new Scanner(readFile).useDelimiter("\n");
        while (fileScanner.hasNext()) {
            String line = fileScanner.next();
            String[] rowValues = getArr(line);

            fileData.add(rowValues);
        }

        return fileData;
    }

    public static void saveStringData(String value, String path) {
        try {
            FileWriter writer = new FileWriter(path, true);
            writer.write(value);
            writer.close();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}
