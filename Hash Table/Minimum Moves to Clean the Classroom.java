import java.util.*;

class Solution {
    public int minMoves(String[] classroom, int energy) {

        int m = classroom.length;
        int n = classroom[0].length();
        int[][] litterIndex = new int[m][n];

        int startX = 0;
        int startY = 0;
        int litterCount = 0;

        // Find starting position and number/index of litter
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

                char ch = classroom[i].charAt(j);

                if (ch == 'S') {
                    startX = i;
                    startY = j;
                } 
                else if (ch == 'L') {
                    litterIndex[i][j] = litterCount;
                    litterCount++;
                }
            }
        }

        // No litter to collect
        if (litterCount == 0) {
            return 0;
        }

        /*
         * State:
         * x       -> row
         * y       -> column
         * energy  -> remaining energy
         * mask    -> which litter is still left
         */

        int totalMasks = 1 << litterCount;

        boolean[][][][] visited =
                new boolean[m][n][energy + 1][totalMasks];

        // Initially all litter is uncollected.
        int initialMask = (1 << litterCount) - 1;

        Queue<int[]> queue = new LinkedList<>();

        queue.offer(new int[]{
                startX,
                startY,
                energy,
                initialMask
        });

        visited[startX][startY][energy][initialMask] = true;

        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};

        int moves = 0;

        while (!queue.isEmpty()) {

            int size = queue.size();

            // Process one BFS level
            while (size-- > 0) {

                int[] current = queue.poll();

                int x = current[0];
                int y = current[1];
                int currEnergy = current[2];
                int mask = current[3];

                // All litter collected
                if (mask == 0) {
                    return moves;
                }

                // Cannot move without energy
                if (currEnergy == 0) {
                    continue;
                }

                // Try all four directions
                for (int dir = 0; dir < 4; dir++) {

                    int nx = x + dx[dir];
                    int ny = y + dy[dir];

                    // Outside grid
                    if (nx < 0 || nx >= m ||
                        ny < 0 || ny >= n) {
                        continue;
                    }

                    // Obstacle
                    if (classroom[nx].charAt(ny) == 'X') {
                        continue;
                    }

                    char nextCell = classroom[nx].charAt(ny);

                    int nextEnergy;

                    // Reset cell
                    if (nextCell == 'R') {
                        nextEnergy = energy;
                    } 
                    else {
                        nextEnergy = currEnergy - 1;
                    }

                    int nextMask = mask;

                    // If we reach litter, mark it collected
                    if (nextCell == 'L') {

                        int index = litterIndex[nx][ny];

                        nextMask = nextMask & ~(1 << index);
                    }

                    // Avoid visiting the same state again
                    if (!visited[nx][ny][nextEnergy][nextMask]) {

                        visited[nx][ny][nextEnergy][nextMask] = true;

                        queue.offer(new int[]{
                                nx,
                                ny,
                                nextEnergy,
                                nextMask
                        });
                    }
                }
            }

            moves++;
        }

        return -1;
    }
}
