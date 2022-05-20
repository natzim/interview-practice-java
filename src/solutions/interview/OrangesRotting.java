package solutions.interview;

import java.util.HashSet;
import java.util.Set;

public class OrangesRotting {
    public static int minutesTillAllRotten(int[][] grid) {
        Set<String> fresh = new HashSet<>();
        Set<String> rotten = new HashSet<>();

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 1) {
                    fresh.add("" + i + j);
                } else if (grid[i][j] == 2) {
                    rotten.add("" + i + j);
                }
            }
        }

        int minutes = 0;
        int[][] directions = {{0, 1}, {1, 0}, {-1, 0}, {0, -1}};

        while (fresh.size() > 0) {
            Set<String> infected = new HashSet<>();

            for (String coordinates : rotten) {
                int i = Character.getNumericValue(coordinates.charAt(0));
                int j = coordinates.charAt(1) - '0';

                for (int[] direction : directions) {
                    int nextI = i + direction[0];
                    int nextJ = j + direction[1];

                    if (fresh.contains("" + nextI + nextJ)) {
                        fresh.remove("" + nextI + nextJ);
                        infected.add("" + nextI + nextJ);
                    }
                }
            }

            if (infected.size() == 0) {
                return -1;
            }

            rotten = infected;
            minutes++;
        }

        return minutes;
    }
}
