package com.enderlord.vaultmapper.shapes;

import java.util.ArrayList;
import java.util.List;

import static java.lang.Math.*;

public class VaultShapes {

    public static List<boolean[][]> possibleShapes() {
        List<boolean[][]> shapes = new ArrayList<>();

        shapes.add(VaultShapes.generateDiamond(3));
        shapes.add(VaultShapes.generateDiamond(4));
        shapes.add(VaultShapes.generateDiamond(5));
        shapes.add(VaultShapes.generateDiamond(6));
        shapes.add(VaultShapes.generateSquare(6));
        shapes.add(VaultShapes.generateDiamond(7));
        shapes.add(VaultShapes.generateSquare(7));
        shapes.add(VaultShapes.generateCircle(8));
        shapes.add(VaultShapes.generateSquare(8));

        return shapes;
    }

    public static boolean[][] generateDiamond(int size) {
        boolean[][] shape = new boolean[17][17];
        for (int x = 0; x < 17; x++) {
            for (int y = 0; y < 17; y++) {
                if (abs(x - 8) + abs(y - 8) <= size) {
                    shape[x][y] = true;
                } else {
                    shape[x][y] = false;
                }
            }
        }
        return shape;
    }

    public static boolean[][] generateSquare(int size) {
        boolean[][] shape = new boolean[17][17];
        for (int x = 0; x < 17; x++) {
            for (int y = 0; y < 17; y++) {
                if (abs(x - 8)  <= size && abs(y - 8) <= size) {
                    shape[x][y] = true;
                } else {
                    shape[x][y] = false;
                }
            }
        }
        return shape;
    }

    public static boolean[][] generateCircle(int size) {
        boolean[][] shape = new boolean[17][17];
        for (int x = 0; x < 17; x++) {
            for (int y = 0; y < 17; y++) {
                if (sqrt(pow(x - 8,2) + pow(y - 8,2)) <= size) {
                    shape[x][y] = true;
                } else {
                    shape[x][y] = false;
                }
            }
        }
        return shape;
    }
    public static boolean[][] DIAMOND1 = new boolean[][]{
             {false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false},
             {false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false},
             {false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false},
             {false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false},
             {false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false},
             {false, false, false, false, false, false, false, false, true , false, false, false, false, false, false, false, false},
             {false, false, false, false, false, false, false, true , true , true , false, false, false, false, false, false, false},
             {false, false, false, false, false, false, true , true , true , true , true , false, false, false, false, false, false},
             {false, false, false, false, false, true , true , true , true , true , true , true , false, false, false, false, false},
             {false, false, false, false, false, false, true , true , true , true , true , false, false, false, false, false, false},
             {false, false, false, false, false, false, false, true , true , true , false, false, false, false, false, false, false},
             {false, false, false, false, false, false, false, false, true , false, false, false, false, false, false, false, false},
             {false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false},
             {false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false},
             {false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false},
             {false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false},
             {false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false}
     };
    public static boolean[][] DIAMOND2 = new boolean[][]{
        {false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false},
        {false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false},
        {false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false},
        {false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false},
        {false, false, false, false, false, false, false, false, true , false, false, false, false, false, false, false, false},
        {false, false, false, false, false, false, false, true , true , true , false, false, false, false, false, false, false},
        {false, false, false, false, false, false, true , true , true , true , true , false, false, false, false, false, false},
        {false, false, false, false, false, true , true , true , true , true , true , true , false, false, false, false, false},
        {false, false, false, false, true , true , true , true , true , true , true , true , true , false, false, false, false},
        {false, false, false, false, false, true , true , true , true , true , true , true , false, false, false, false, false},
        {false, false, false, false, false, false, true , true , true , true , true , false, false, false, false, false, false},
        {false, false, false, false, false, false, false, true , true , true , false, false, false, false, false, false, false},
        {false, false, false, false, false, false, false, false, true , false, false, false, false, false, false, false, false},
        {false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false},
        {false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false},
        {false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false},
        {false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false}
    };
    public static boolean[][] DIAMOND3 = new boolean[][]{
        {false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false},
        {false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false},
        {false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false},
        {false, false, false, false, false, false, false, false, true , false, false, false, false, false, false, false, false},
        {false, false, false, false, false, false, false, true , true , true , false, false, false, false, false, false, false},
        {false, false, false, false, false, false, true , true , true , true , true , false, false, false, false, false, false},
        {false, false, false, false, false, true , true , true , true , true , true , true , false, false, false, false, false},
        {false, false, false, false, true , true , true , true , true , true , true , true , true , false, false, false, false},
        {false, false, false, true , true , true , true , true , true , true , true , true , true , true , false, false, false},
        {false, false, false, false, true , true , true , true , true , true , true , true , true , false, false, false, false},
        {false, false, false, false, false, true , true , true , true , true , true , true , false, false, false, false, false},
        {false, false, false, false, false, false, true , true , true , true , true , false, false, false, false, false, false},
        {false, false, false, false, false, false, false, true , true , true , false, false, false, false, false, false, false},
        {false, false, false, false, false, false, false, false, true , false, false, false, false, false, false, false, false},
        {false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false},
        {false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false},
        {false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false}
    };
    public static boolean[][] DIAMOND4 = new boolean[][]{
        {false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false},
        {false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false},
        {false, false, false, false, false, false, false, false, true , false, false, false, false, false, false, false, false},
        {false, false, false, false, false, false, false, true , true , true , false, false, false, false, false, false, false},
        {false, false, false, false, false, false, true , true , true , true , true , false, false, false, false, false, false},
        {false, false, false, false, false, true , true , true , true , true , true , true , false, false, false, false, false},
        {false, false, false, false, true , true , true , true , true , true , true , true , true , false, false, false, false},
        {false, false, false, true , true , true , true , true , true , true , true , true , true , true , false, false, false},
        {false, false, true , true , true , true , true , true , true , true , true , true , true , true , true , false, false},
        {false, false, false, true , true , true , true , true , true , true , true , true , true , true , false, false, false},
        {false, false, false, false, true , true , true , true , true , true , true , true , true , false, false, false, false},
        {false, false, false, false, false, true , true , true , true , true , true , true , false, false, false, false, false},
        {false, false, false, false, false, false, true , true , true , true , true , false, false, false, false, false, false},
        {false, false, false, false, false, false, false, true , true , true , false, false, false, false, false, false, false},
        {false, false, false, false, false, false, false, false, true , false, false, false, false, false, false, false, false},
        {false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false},
        {false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false}
    };
    public static boolean[][] DIAMOND5 = new boolean[][]{
        {false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false},
        {false, false, false, false, false, false, false, false, true , false, false, false, false, false, false, false, false},
        {false, false, false, false, false, false, false, true , true , true , false, false, false, false, false, false, false},
        {false, false, false, false, false, false, true , true , true , true , true , false, false, false, false, false, false},
        {false, false, false, false, false, true , true , true , true , true , true , true , false, false, false, false, false},
        {false, false, false, false, true , true , true , true , true , true , true , true , true , false, false, false, false},
        {false, false, false, true , true , true , true , true , true , true , true , true , true , true , false, false, false},
        {false, false, true , true , true , true , true , true , true , true , true , true , true , true , true , false, false},
        {false, true , true , true , true , true , true , true , true , true , true , true , true , true , true , true , false},
        {false, false, true , true , true , true , true , true , true , true , true , true , true , true , true , false, false},
        {false, false, false, true , true , true , true , true , true , true , true , true , true , true , false, false, false},
        {false, false, false, false, true , true , true , true , true , true , true , true , true , false, false, false, false},
        {false, false, false, false, false, true , true , true , true , true , true , true , false, false, false, false, false},
        {false, false, false, false, false, false, true , true , true , true , true , false, false, false, false, false, false},
        {false, false, false, false, false, false, false, true , true , true , false, false, false, false, false, false, false},
        {false, false, false, false, false, false, false, false, true , false, false, false, false, false, false, false, false},
        {false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false}
    };
    public static boolean[][] BIGSQUARE = new boolean[][]{
            {true , true , true , true , true , true , true , true , true , true , true , true , true , true , true , true , true },
            {true , true , true , true , true , true , true , true , true , true , true , true , true , true , true , true , true },
            {true , true , true , true , true , true , true , true , true , true , true , true , true , true , true , true , true },
            {true , true , true , true , true , true , true , true , true , true , true , true , true , true , true , true , true },
            {true , true , true , true , true , true , true , true , true , true , true , true , true , true , true , true , true },
            {true , true , true , true , true , true , true , true , true , true , true , true , true , true , true , true , true },
            {true , true , true , true , true , true , true , true , true , true , true , true , true , true , true , true , true },
            {true , true , true , true , true , true , true , true , true , true , true , true , true , true , true , true , true },
            {true , true , true , true , true , true , true , true , true , true , true , true , true , true , true , true , true },
            {true , true , true , true , true , true , true , true , true , true , true , true , true , true , true , true , true },
            {true , true , true , true , true , true , true , true , true , true , true , true , true , true , true , true , true },
            {true , true , true , true , true , true , true , true , true , true , true , true , true , true , true , true , true },
            {true , true , true , true , true , true , true , true , true , true , true , true , true , true , true , true , true },
            {true , true , true , true , true , true , true , true , true , true , true , true , true , true , true , true , true },
            {true , true , true , true , true , true , true , true , true , true , true , true , true , true , true , true , true },
            {true , true , true , true , true , true , true , true , true , true , true , true , true , true , true , true , true },
            {true , true , true , true , true , true , true , true , true , true , true , true , true , true , true , true , true },
    };
}
