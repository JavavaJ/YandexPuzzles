package task1;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

public class Puzzle2 {

    public static int[] parseDissimilaritiesString(String dissimilaritiesStr) {
        String[] dissimilaritiesStrArray = dissimilaritiesStr.split(" ");
        int[] dissimilarityValues = new int[dissimilaritiesStrArray.length];
        int arrayLen = dissimilaritiesStrArray.length;
        for (int i = 0; i < arrayLen; i++) {
            int currInt = Integer.parseInt(dissimilaritiesStrArray[i]);
            dissimilarityValues[i] = currInt;
        }
        return dissimilarityValues;
    }

    public static int findMinDissimilarityIndex(int[] intArray) {
        List<Integer> values = new ArrayList<>();
        int arrLen = intArray.length;

        //
        for (int i = 0; i < arrLen-1; i++) {
            int num1 = intArray[i];
            for (int j = i + 1; j < arrLen; j++) {
                int num2 = intArray[j];
                values.add(num1 ^ num2);
            }
        }

        if (arrLen == 2) {
            values.add(intArray[0] ^ intArray[1]);
        }

        return Collections.min(values);
    }

    public static List<String> initInput() {
        List<String> linesList = new ArrayList<>();
        String fileName = "input.txt";

        try (Stream<String> stream = Files.lines(Paths.get(fileName))) {
            stream.forEach(el -> linesList.add(el));
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        return linesList;
    }

    public static void createOutputFile(String content, boolean isBullshit) {
        String outputFileName = "output.txt";

        FileOutputStream fop = null;
        File file;

        try {

            file = new File(outputFileName);
            fop = new FileOutputStream(file);

            // if file doesnt exists, then create it
            if (!file.exists()) {
                file.createNewFile();
            }

            // get the content in bytes
            byte[] contentInBytes = content.getBytes();

            fop.write(contentInBytes);
            fop.flush();
            fop.close();

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (fop != null) {
                    fop.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    public static void main(String[] args) {
        String outputStr = "";
        List<String> linesList = initInput();
        int testNum = Integer.parseInt(linesList.get(0));

        int wardrobeNum;

        int currIndex = 1;

        for (int i = 0; i < testNum; i++) {
            wardrobeNum = Integer.parseInt(linesList.get(currIndex));
            currIndex++;
            String valuesString = linesList.get(currIndex);
            int[] intArray = parseDissimilaritiesString(valuesString);
            int minIndex = findMinDissimilarityIndex(intArray);

            currIndex++;
            outputStr += minIndex;
            outputStr += System.lineSeparator();
        }
        createOutputFile(outputStr, false);
    }



}
