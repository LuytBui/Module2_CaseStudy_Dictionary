package inout;

import controller.DictManagement;
import model.DictionaryEntry;
import utilities.Colors;
import utilities.Printer;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class DataReader extends DataService {
    public static boolean readDictionary() {
        Printer.println("Reading data from file: " + dataFile, Colors.SYSTEM_MSG_COLOR);

        try {
            InputStream is = new FileInputStream(dataFile);
            ObjectInputStream ois = new ObjectInputStream(is);
            Set<DictionaryEntry> dictionary = (Set<DictionaryEntry>) ois.readObject();
            DictManagement.getInstance().setDictionary(dictionary);
            ois.close();
            is.close();
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }

        Printer.println("Success", Colors.GREEN);
        Printer.println();

        return true;
    }

    public static List<DictionaryEntry> readEntryListFromFile(String fileName) {
        List<DictionaryEntry> dictionaryEntryList = new ArrayList<>();
        String delimiter = getDelimiter(fileName);

        try {
            FileReader fileReader = new FileReader(fileName);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String[] split = line.split(delimiter);
                if (split.length < 2)
                    continue;
                String keyword = split[0];
                StringBuilder stringBuilder = new StringBuilder();
                for (int i = 1; i < split.length; i++) {
                    stringBuilder.append(split[i]).append("\n");
                }
                String content = stringBuilder.toString().trim();
                dictionaryEntryList.add(new DictionaryEntry(keyword, content));
            }
            fileReader.close();
        } catch (FileNotFoundException e) {
            Printer.print("File không tồn tại!", Colors.RED);
        } catch (IOException e) {
            Printer.print("Không đọc được.");
        }

        return dictionaryEntryList;
    }

    public static String getExtensionOf(String fileName) {
        String[] split = fileName.split("\\.");
        if (split.length < 2)
            return "";
        return split[split.length - 1];
    }

    public static String getDelimiter(String fileName) {
        String extension = getExtensionOf(fileName);
        String delimiter;

        switch (extension) {
            case "csv":
            case "txt":
            default:
                delimiter = ",";
                break;
            case "xls":
            case "xlsx":
            case "xlsm":
                delimiter = "\t";
                break;
        }
        return delimiter;
    }

}
