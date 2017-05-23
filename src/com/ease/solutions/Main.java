package com.ease.solutions;

import com.ease.solutions.utils.FileUtils;

public class Main {

    public static void main(String[] args) {
        FileUtils map = new FileUtils("map.txt");
        System.out.println(map.toString());
    }

}
