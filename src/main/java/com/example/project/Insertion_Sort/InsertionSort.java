package com.example.project.Insertion_Sort;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class InsertionSort {

    // PART A. implementing insertion sort
    public static int[] insertionSort(int[] elements) {
        int a = 0;
        for (int c = 1; c < elements.length; c++) {
            boolean b = true;
            int d = c;
            while (b) { 
                if (elements[d - 1] > elements[d]) {
                    a ++;
                    int temp = elements[d];
                    elements[d] = elements[d - 1];
                    elements[d - 1] = temp;
                } else {
                    b = false;
                }
                d--;
                if (d == 0) {
                    b = false;
                }
            }
        }
        System.out.println("Insert: "+ a);

        return elements;
    }

   
    public static void selectionSort(int[] elements) {
        int a = 0;
        int l = elements.length;
        for (int c = 0; c < l; c++) {
            int mini = elements[c];
            int index = c;
            for (int d = 1 + c; d < elements.length; d++) {
                a++;
                if (mini > elements[d]) {
                    mini = elements[d];
                    index = d;
                }
            }
            elements[index] = elements[c];
            elements[c] = mini;
        }
        System.out.println("Selection: "+ a);
    }

    // PART B. sorting a 1000-word list
    public static ArrayList<String> insertionSortWordList(ArrayList<String> words) {
        int count = 0;
        for (int c = 1; c < words.size(); c++) {
            boolean b = true;
            int d = c;
            while (b) {
                if (words.get(d - 1).compareTo(words.get(d)) > 0) {
                    count++;
                    words.add(d - 1, words.remove(d));
                } else {
                    b = false;
                }
                d--;
                if (d < 1) {
                    b = false;
                }
            }
        }
        System.out.println("Insertion: " + count);
        return words;
    }

    public static void selectionSortWordList(ArrayList<String> words) {
        int count = 0;
        for (int c = 0; c < words.size() - 1; c++) {
            int index = c;
            for (int d = index + 1; d < words.size(); d++) {
                count++;
                if (words.get(d).compareTo(words.get(d)) < 0) {
                    index = d;
                }
            }
            words.add(index, words.remove(index));
        }
        System.out.println("Selection: " + count);
    }

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

   public static void main(String[] args) {
    ArrayList<String> words = InsertionSort.loadWordsInto(new ArrayList<String>());
    selectionSortWordList(words);
    ArrayList<String> words1 = InsertionSort.loadWordsInto(new ArrayList<String>());
    insertionSortWordList(words1);
    
    
    

   }
}