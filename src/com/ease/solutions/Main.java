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
        FileUtils file = new FileUtils("temp.txt");
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
                
                System.out.println();

                System.out.println(temp);
            }
        }
        
        System.out.println("Max: " + map.getMaxPath());

        long endTime = System.nanoTime();
        System.out.println("Took " + (endTime - startTime) + " ns");
    }

}
