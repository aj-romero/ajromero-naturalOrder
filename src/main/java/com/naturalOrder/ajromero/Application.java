package com.naturalOrder.ajromero;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Application {
    public static void main(String[] args)
    {
        String[] strings = new String[] { "1-2", "1-02", "1-20", "10-20", "fred", "jane", "pic01",
                "pic2", "pic02", "pic02a", "pic3", "pic4", "pic 4 else", "pic 5", "pic05", "pic 5",
                "pic 5 something", "pic 6", "pic   7", "pic100", "pic100a", "pic120", "pic121",
                "pic02000", "tom", "x2-g8", "x2-y7", "x2-y08", "x8-y8" };

        List orig = Arrays.asList(strings);

        System.out.println("Original: " + orig);

        List scrambled = Arrays.asList(strings);
        Collections.shuffle(scrambled);

        System.out.println("Scrambled: " + scrambled);

        Collections.sort(scrambled, new NaturalOrderComparator());

        System.out.println("Sorted: " + scrambled);

        shuffle3000(scrambled);

        compareSymmetric();

        floatsWithCommas();
    }

    static void shuffle3000(List<String> scrambled) {
        Collections.shuffle(scrambled, new Random(3000));
        Collections.sort(scrambled, new NaturalOrderComparator());

        System.out.println("Sorted: " + scrambled);
    }

    static void compareSymmetric() {
        NaturalOrderComparator naturalOrderComparator = new NaturalOrderComparator();

        int compare1 = naturalOrderComparator.compare("1-2", "1-02");
        int compare2 = naturalOrderComparator.compare("1", "2");

        System.out.println(compare1 + " == " + compare2);

        compare1 = naturalOrderComparator.compare("pic 5", "pic05");
        compare2 = naturalOrderComparator.compare("pic05", "pic 5");

        System.out.println(compare1 + " == " + compare2);
    }

    static void floatsWithCommas() {
        List<String> unSorted = Arrays.asList("0.9", "1.0c", "1.2", "1.3", "0.6", "1.1", "0.7", "0.3", "1.0b", "1.0", "0.8", "1.0c11", "1.0c2");

        System.out.println("Unsorted: " + unSorted);

        unSorted.sort(new NaturalOrderComparator());

        System.out.println("Sorted: " + unSorted);
    }
}
