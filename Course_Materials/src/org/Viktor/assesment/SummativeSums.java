package org.Viktor.assesment;

import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SummativeSums {
    static void summativeSum(Integer[] array, int index) {
        int sum = 0;

        for(int i = 0; i < array.length; i++) {
            sum += array[i];
        }

        System.out.printf("#%d Array Sum: %d\n", index, sum);
    }

    public static void main(String[] args) {
        List<Integer[]> arrays = new ArrayList<>();

        arrays.add(new Integer[]{ 1, 90, -33, -55, 67, -16, 28, -55, 15 });
        arrays.add(new Integer[]{ 999, -60, -77, 14, 160, 301 });
        arrays.add(new Integer[]{ 10, 20, 30, 40, 50, 60, 70, 80, 90, 100, 110, 120, 130, 140, 150, 160, 170, 180, 190, 200, -99 });

        for(int i = 0; i < arrays.size(); i++) {
            summativeSum(arrays.get(i), i + 1);
        }
    }
}
