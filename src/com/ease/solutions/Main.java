package com.ease.solutions;

import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

import com.ease.solutions.utils.FileUtils;
import com.ease.solutions.utils.MapUtils;

public class Main {

    public static List<List<Integer>> temp = new ArrayList<List<Integer>>();

    public static void main(String[] args) {
        long startTime = System.nanoTime();
        FileUtils file = new FileUtils("map.txt");
        MapUtils map = new MapUtils();

        int[][] matrix = file.getMatrix();

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                map = new MapUtils();

                Point root = new Point();

                root.x = i;
                root.y = j;

                map.traverse(matrix, root);

                temp.add(map.getTempPath());
            }
        }

        System.out.println("Length of calculated path: " + map.getMaxPath().size());
        System.out.println("Drop of calculated path: " + (map.getMaxPath().get(0) - map.getMaxPath().get(map.getMaxPath().size()-1)));
        System.out.println("Calculated Path: " + map.getMaxPath());

        long endTime = System.nanoTime();
        System.out.println("Took " + (endTime - startTime) / 1000000000 + " s");
    }

}
