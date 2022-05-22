package solutions.interview;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class MatrixTraversal {
    public static int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

    public static String bfsTraversalIterative(int[][] grid) {
        if (grid.length == 0) return "";

        StringBuilder output = new StringBuilder();

        int height = grid.length;
        int length = grid[0].length;

        boolean[][] visited = new boolean[height][length];

        Queue<String> que = new LinkedList<>();
        que.add(0 + "," + 0);

        while (!que.isEmpty()) {
            String coordinates = que.remove();
            int row = Integer.parseInt(coordinates.split(",")[0]);
            int col = Integer.parseInt(coordinates.split(",")[1]);

            if (row < 0 || col < 0 || row >= height || col >= length || visited[row][col])
                continue;

            visited[row][col] = true;
            output.append(grid[row][col]).append(" ");

            for (int[] direction : directions) {
                que.add((row + direction[0]) + "," + (col + direction[1]));
            }
        }

        return output.toString();
    }

    public static String dfsTraversalIterative(int[][] grid) {
        if (grid.length == 0) return "";

        StringBuilder output = new StringBuilder();

        int height = grid.length;
        int length = grid[0].length;

        boolean[][] visited = new boolean[height][length];

        Stack<String> stack = new Stack<>();
        stack.push(0 + "," + 0);

        while (!stack.isEmpty()) {
            String coordinates = stack.pop();
            int row = Integer.parseInt(coordinates.split(",")[0]);
            int col = Integer.parseInt(coordinates.split(",")[1]);

            visited[row][col] = true;
            output.append(grid[row][col]).append(" ");

            for (int[] direction : directions) {
                // Try direction.
                int nextRow = row + direction[0];
                int nextCol = col + direction[1];

                if (nextRow < 0 || nextCol < 0 || nextRow >= height || nextCol >= length || visited[nextRow][nextCol]) {
                    continue;
                }

                stack.push(nextRow + "," + nextCol);
                break;
            }
        }

        return output.toString();
    }

    public static String dfsTraversalRecursive(int[][] grid) {
        if (grid.length == 0) return "";

        StringBuilder output = new StringBuilder();

        int height = grid.length;
        int length = grid[0].length;
        boolean[][] visited = new boolean[height][length];

        dfsRecursive(grid, visited, 0, 0, output);
        return output.toString();
    }

    private static void dfsRecursive(int[][] grid, boolean[][] visited, int row, int col, StringBuilder output) {
        if (row < 0 || col < 0 || row >= grid.length || col >= grid[row].length || visited[row][col]) {
            return;
        }

        output.append(grid[row][col]).append(" ");
        visited[row][col] = true;

        for (int[] direction : directions) {
            dfsRecursive(grid, visited, row + direction[0], col + direction[1], output);
        }
    }
}
