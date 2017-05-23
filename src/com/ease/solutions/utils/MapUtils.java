package com.ease.solutions.utils;

import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

import com.ease.solutions.Main;

public class MapUtils {

    private static boolean[][] visited = new boolean[4][4];

    private List<Integer> st = new ArrayList<Integer>();

    private List<Integer> temp = new ArrayList<Integer>();

    private static List<Integer> max = new ArrayList<Integer>();

    public void traverse(int[][] matrix, Point p) {
        st.add(matrix[p.x][p.y]);

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                visited[i][j] = false;
            }
        }

        visited[p.x][p.y] = true;

        ArrayList<Point> neighbors = getNeighbors(matrix, p);

        for (int i = 0; i < neighbors.size(); i++) {
            int index = (4 * neighbors.get(i).x) + neighbors.get(i).y;
            System.out.println("qwe " + Main.temp);
            if (temp.size() - 1 >= index && Main.temp.get(index) != null) {
                st.addAll(temp);
            } else {
                traverse(matrix, neighbors.get(i));
            }

            if (temp == null) {
                temp = new ArrayList<Integer>(st);
            } else if (temp.size() < st.size()) {
                temp = new ArrayList<Integer>(st);
            } else if (temp.size() == st.size()) {
                int sumSt = 0;
                int sumTemp = 0;

                for (int x = 0; x < st.size(); x++) {
                    sumSt = sumSt + st.get(x);
                }

                for (int x = 0; x < temp.size(); x++) {
                    sumTemp = sumTemp + temp.get(x);
                }

                if (sumTemp < sumSt) {
                    temp = new ArrayList<Integer>(st);
                }
            }

            if (max == null) {
                max = new ArrayList<Integer>(st);
            } else if (max.size() < st.size()) {
                max = new ArrayList<Integer>(st);
            } else if (max.size() == st.size()) {
                int sumMax = 0;
                int sumSt = 0;

                for (int x = 0; x < st.size(); x++) {
                    sumSt = sumSt + st.get(x);
                }

                for (int x = 0; x < max.size(); x++) {
                    sumMax = sumMax + max.get(x);
                }

                if (sumMax < sumSt) {
                    max = new ArrayList<Integer>(st);
                }
            }

            st.remove(st.size() - 1);
        }
    }

    public List<Integer> getMaxPath() {
        return max;
    }

    public List<Integer> getTempPath() {
        return temp;
    }

    public ArrayList<Point> getNeighbors(int[][] maze, Point p) {
        ArrayList<Point> neighbors = new ArrayList<Point>();

        Point left = new Point();
        Point right = new Point();
        Point down = new Point();
        Point up = new Point();

        down.x = p.x - 1;
        down.y = p.y;

        if (valid(maze, down)) {
            neighbors.add(down);
        }

        up.x = p.x + 1;
        up.y = p.y;

        if (valid(maze, up)) {
            neighbors.add(up);
        }

        left.x = p.x;
        left.y = p.y - 1;

        if (valid(maze, left)) {
            neighbors.add(left);
        }

        right.x = p.x;
        right.y = p.y + 1;

        if (valid(maze, right)) {
            neighbors.add(right);
        }

        return neighbors;
    }

    public boolean valid(int[][] matrix, Point p) {
        if (inMatrix(matrix, p) && !visited[p.x][p.y] && st.get(st.size() - 1) > matrix[p.x][p.y]) {
            return true;
        } else {
            return false;
        }
    }

    public boolean inMatrix(int[][] matrix, Point p) {
        if (p.x < matrix[0].length && p.x > -1 && p.y < matrix.length && p.y > -1) {
            return true;
        } else {
            return false;
        }
    }

}
