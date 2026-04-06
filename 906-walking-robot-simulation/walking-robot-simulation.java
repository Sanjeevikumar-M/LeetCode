import java.util.*;

class Solution {
    public int robotSim(int[] commands, int[][] obstacles) {
        
        // Store obstacles in HashSet
        Set<String> set = new HashSet<>();
        for (int[] obs : obstacles) {
            set.add(obs[0] + "," + obs[1]);
        }

        // Directions: North, East, South, West
        int[] dx = {0, 1, 0, -1};
        int[] dy = {1, 0, -1, 0};

        int dir = 0; // start facing North
        int x = 0, y = 0;
        int maxDist = 0;

        for (int cmd : commands) {
            
            if (cmd == -1) {
                // turn right
                dir = (dir + 1) % 4;
            } 
            else if (cmd == -2) {
                // turn left
                dir = (dir + 3) % 4;
            } 
            else {
                // move step by step
                for (int i = 0; i < cmd; i++) {
                    int nx = x + dx[dir];
                    int ny = y + dy[dir];

                    // check obstacle
                    if (set.contains(nx + "," + ny)) {
                        break;
                    }

                    x = nx;
                    y = ny;

                    // update max distance
                    maxDist = Math.max(maxDist, x * x + y * y);
                }
            }
        }

        return maxDist;
    }
}