package Online_Space.Apt.Diagonal_Collection;


import Online_Space.Apt.TrappingRainWater_2;

import java.util.PriorityQueue;

public class Solution {

    class Cell implements Comparable<Cell>{
        int row;
        int col;
        int height;

        public Cell(int row, int col, int height) {
            this.row = row;
            this.col = col;
            this.height = height;

        }

        public int compareTo(Cell that) {
            return this.height - that.height;
        }
    }

    public int trapRainWater(int[][] heightMap) {
        if (heightMap == null || heightMap.length == 0 || heightMap[0].length == 0) {
            return 0;
        }

        int m = heightMap.length, n = heightMap[0].length;
        boolean[][] visited = new boolean[m][n];
        PriorityQueue<Cell> queue = new PriorityQueue<>();

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 || i == m - 1 || j == 0 || j == n - 1) {
                    queue.add(new Cell(i, j, heightMap[i][j]));
                    visited[i][j] = true;
                }
            }
        }

        int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        int curMaxHeight = 0;
        int res = 0;

        while (!queue.isEmpty()) {
            Cell curCell = queue.remove();
            curMaxHeight = Math.max(curMaxHeight, curCell.height);

            for (int[] direction : directions) {
                int nextRow = curCell.row + direction[0];
                int nextCol = curCell.col + direction[1];

                if (isValid(heightMap, nextRow, nextCol, visited)) {
                    visited[nextRow][nextCol] = true;
                    queue.add(new Cell(nextRow, nextCol, heightMap[nextRow][nextCol]));

                    if (heightMap[nextRow][nextCol] < curMaxHeight) {
                        res += curMaxHeight - heightMap[nextRow][nextCol];
                    }
                }
            }
        }
        return res;
    }

    public boolean isValid(int[][] heightMap, int row, int col, boolean[][] visited) {
        return row >= 0 && row < heightMap.length && col >= 0 && col < heightMap[0].length && !visited[row][col];
    }
}
