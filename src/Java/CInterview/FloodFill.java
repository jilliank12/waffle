package CInterview;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Jilliankim on 10/26/15.
 */
    /*
    * points to consider
    * 1. take M and N as parameters MxN - created a global static int for these variables, but deleted them
    *    (maybe create them if the matrix is read by System.in?)
    * 2. How big can the matrix be? - implemented recursion for this.
    * 3. What are A, B, C.. etc? : graph traversal iterations
    * 4. edge case with a single 1 island (so all 1s and just a single 0)
    *
    * How to solve this problem??
    * 1. Make a hashset and return it ( O(MN) is the runtime & storage complexity)
    *   method for search and mark it visited
    *   method for linear scan for the ones that are not visited
    *
    * 2. or do a 2D array dfs
    *   what is the runtime & storage complexity for this one?
    *
    *
    * so.. the step is
    * 1. scan for 1 cell by cell
    * 2. do recursion if you find 1
    * 3. store the location somehow (tuple if Scala, but for java...) to print out later
    * 4. store the graph traversal iteration location (where the isolated 0 is!!)
    * 5. scan for the "unseen" ones
    *
    * comments for the entire file-----
    * I originally started with a 2D & DFS method,
    * then realized that storing points require a vector, and the "A:" part could be a key,
    * so I implemented hashmap with <Integer, List(of points)>.
    * But that slows down the program a lot more; instead I got rid of list & hashmap,
    * and decided to print out the points for each graph traversal iteration.
    *
    * */

public class FloodFill {

    //hashmap to store a vertex and its points

    public static void main(String[] args) {
        FloodFill floodFill = new FloodFill();

        int map[][] = {{1, 1, 0, 1, 0, 1},
                       {1, 1, 1, 1, 0, 1},
                       {0, 0, 0, 0, 1, 1},
                       {1, 0, 1, 0, 1, 0}

        };
        int mapLength = map.length;
        int mapWidth = mapLength > 0? map[0].length : 0;
        for (int i = 0; i < mapLength; i++) {
            for (int j = 0; j < mapWidth; j++) {
                connected(i, j, map);
            }
        }

//        floodFill.countVertex(map);

    }

    //recursive step to find 1s and turning them into -1 once it's visited
    static void connected(int row, int col, int[][] map) {
        int mapLength = map.length;
        int mapWidth = mapLength > 0? map[0].length : 0;
        if (!isValidCell(row, col, mapLength, mapWidth)) {
            return;
        }
        if (map[row][col] == 1) {
            //assuming -1 is safer to use than switching to 0
            map[row][col] = -1;
            //checking to see if there are any adjacent 1s
            connected(row, col - 1, map);
            connected(row + 1, col, map);
            connected(row, col + 1, map);
            connected(row - 1, col, map);
//            points.add(new CInterview.Pair(row, col));
            System.out.print("(" + row + ", " + col + ")");
        }
    }

    //checks if the cell is within the matrix
    static boolean isValidCell(int row, int col, int mapLength, int mapWidth) {
        if (row >= mapLength || row < 0 || col >= mapWidth || col < 0) {
            return false;
        }
        return true;
    }



}
