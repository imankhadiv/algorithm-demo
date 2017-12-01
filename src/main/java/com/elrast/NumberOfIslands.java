package com.elrast;

public class NumberOfIslands {


    public int numIslands(byte[][] grid) {

        int sum = 0;
        int rowLength = grid.length;
        int colLength = grid[0].length;
        for (int i = 0; i < rowLength; i++) {
            for (int j = 0; j < colLength; j++) {

                if (grid[i][j] == '1') {
                    markNeighbors(i, j, grid, rowLength, colLength);
                    sum += 1;
                }
            }
        }

        return sum;
    }

    public void markNeighbors(int i, int j, byte[][] grid, int rowSize, int colSize) {

        if (i >= rowSize || i < 0 || j >= colSize || j < 0 || grid[i][j] == '0') return;
        grid[i][j] = 'X';
        markNeighbors(i + 1, j, grid, rowSize, colSize);
        markNeighbors(i - 1, j, grid, rowSize, colSize);
        markNeighbors(i, j + 1, grid, rowSize, colSize);
        markNeighbors(i, j - 1, grid, rowSize, colSize);


    }
}
