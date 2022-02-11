package controller;


import model.DictionaryEntry;
import org.jetbrains.annotations.NotNull;
import utilities.Colors;
import utilities.Printer;

import java.util.*;

public class DictManagement {
    private static DictManagement instance;
    private Set<DictionaryEntry> dictionary;

    private DictManagement() {
        dictionary = new TreeSet<>();
    }

    public static DictManagement getInstance() {
        if (instance == null)
            instance = new DictManagement();
        return instance;
    }

    public void showAll() {

        for (DictionaryEntry entry : dictionary)
            printEntry(entry);
        if (dictionary.size() == 0)
            Printer.println("Không có chỉ mục nào trong thư viện", Colors.RED);
        else
            Printer.println("Có " + dictionary.size() + " chỉ mục.", Colors.RED);
    }

    public void printEntry(DictionaryEntry entry) {
        Printer.println("--------------------");
        Printer.printIndent("Từ khóa: ");
        Printer.println(entry.getKeyword(), Colors.KEYWORD_COLOR);
        Printer.println("Nội dung: ");
        Printer.print(entry.getContent(), Colors.CONTENT_COLOR);
        Printer.println();
        Printer.println("--------------------");
    }


    public DictionaryEntry findEntry(String keyword) {
        DictionaryEntry result = null;
        for (DictionaryEntry entry : dictionary) {
            boolean sameKey = entry.getKeyword().equalsIgnoreCase(keyword);
            if (sameKey) {
                result = entry;
                break;
            }
        }
        return result;
    }

    public boolean setEntry(DictionaryEntry entry) {
        boolean keywordExisted;
        DictionaryEntry target = findEntry(entry.getKeyword());
        if (target == null) {
            keywordExisted = false;
            dictionary.add(entry);
        } else {
            keywordExisted = true;
            target.setContent(entry.getContent());
        }
        return keywordExisted;
    }

    public void importList(@NotNull List<DictionaryEntry> list) {
        for (DictionaryEntry entry : list) {
            setEntry(entry);
        }
    }

    public List<DictionaryEntry> search(String keyword) {
        LinkedList<DictionaryEntry> result = new LinkedList<>();
        for (DictionaryEntry entry : dictionary) {

            // check #1: exact match
            boolean exactMatch =
                    entry.getKeyword().equalsIgnoreCase(keyword);
            if (exactMatch) {
                result.addLast(entry);
                continue;
            }

            // check #2: partial match
            boolean partialMatch =
                    entry.getKeyword().toLowerCase().contains(keyword.toLowerCase());
            if (partialMatch) {
                result.addFirst(entry);
//                continue;
            }

            //

        }
        return result;
    }

    public DictionaryEntry lookup(String keyword) {
        List<DictionaryEntry> searchResult = search(keyword);
        int length = searchResult.size();
        if (length == 0)
            return null;
        return searchResult.get(length - 1);
    }

    public void deleteEntry(DictionaryEntry entry) {
        dictionary.remove(entry);
    }

    public void printListEntry(List<DictionaryEntry> list) {
        for (DictionaryEntry entry : list) {
            printEntry(entry);
        }
    }

    public void printListKeyword(List<DictionaryEntry> list, String msg) {
        String MARKER = " * ";
        Printer.println(msg);

        if (list.size() == 0) {
            Printer.println("Không có từ khóa nào!");
            return;
        }
        for (DictionaryEntry entry : list) {
            Printer.print(MARKER);
            Printer.println(entry.getKeyword(), Colors.KEYWORD_COLOR);
        }
        Printer.println("Có " + list.size() + " từ khóa. ");
        Helper.printLookUpInstruction();
    }

    public Set<DictionaryEntry> getDictionary() {
        return dictionary;
    }

    public void setDictionary(Set<DictionaryEntry> dictionary) {
        this.dictionary = dictionary;
    }
}
