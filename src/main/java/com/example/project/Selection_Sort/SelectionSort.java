package com.example.project.Selection_Sort;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.IOException;
import java.io.File;

public class SelectionSort {

    // PART A. implementing selection sort
    public static int[] selectionSort(int[] elements) {
        int l = elements.length;
        for (int c = 0; c < l; c++) {
            int mini = elements[c];
            int index = c;
            for (int d = 1 + c; d < elements.length; d++) {
                if (mini > elements[d]) {
                    mini = elements[d];
                    index = d;
                }
            }
            elements[index] = elements[c];
            elements[c] = mini;
        }
        return elements;
    }


    // PART B. sorting a 1000-word list
    public static ArrayList<String> selectionSortWordList(ArrayList<String> words) {
        ArrayList<String> sortWords = new ArrayList<String>();
        for (int c = 0; c < words.size(); c++) {
            int index = c;
            String mini = words.get(0);
            for (int d = 1; d < words.size(); d++) {
                if (words.get(d).compareTo(mini) < 0) {
                    mini = words.get(d);
                    index = d;
                }
            }
            sortWords.add(words.remove(index));
        }
        words = sortWords;
        return words;
    }

    //call this method to load 1000 words into list. Use it to test Part B
    public static ArrayList<String> loadWordsInto(ArrayList<String> wordList) {
        try {
            Scanner input = new Scanner(new File("src/main/java/com/example/project/Selection_Sort/words.txt"));
            while (input.hasNext()) {
                String word = input.next();
                wordList.add(word);
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return wordList;
    }
}
