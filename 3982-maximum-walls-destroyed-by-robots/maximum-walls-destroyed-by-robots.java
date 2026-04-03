class Solution {
    public int maxWalls(int[] robots, int[] distance, int[] walls) {
        int n = robots.length;

        int[][] bots = new int[n][2];
        for (int i = 0; i < n; i++) {
            bots[i][0] = robots[i];
            bots[i][1] = distance[i];
        }
        Arrays.sort(bots, (a, b) -> a[0] - b[0]);

        Arrays.sort(walls);
        int m = walls.length;
        int[] prefix = new int[m + 1];
        for (int i = 0; i < m; i++) prefix[i + 1] = prefix[i] + 1;

        // For each gap between adjacent robots (and beyond boundaries),
        // precompute how many walls each robot can reach into that gap.
        //
        // dp[i][0] = max walls if robot i fires LEFT
        // dp[i][1] = max walls if robot i fires RIGHT
        //
        // The gap between robot[i] and robot[i+1]:
        //   - robot[i] can claim it by firing RIGHT  → gapRight[i]
        //   - robot[i+1] can claim it by firing LEFT → gapLeft[i+1]
        //   But NOT both — it's an exclusive choice for that gap.
        //
        // Transition (key: the gap between i-1 and i is contested):
        //   dp[i][LEFT]  = max(
        //       dp[i-1][LEFT]  + 0,           // i-1 fired left  (gap unclaimed, i fires left)
        //       dp[i-1][RIGHT] + gapLeft[i]   // i-1 fired right (i also fires left → conflict!)
        //   )
        //
        // Actually the correct formulation:
        //   dp[i][RIGHT] = max(dp[i-1][0], dp[i-1][1]) + rightWalls(i)
        //     is WRONG because right[i] and left[i+1] would double count the gap.
        //
        // Correct DP: the gap walls between robot i and i+1 go to exactly one.
        //   dp[i][0] = robot i fires LEFT  = walls in [capped-left, pos_i]
        //   dp[i][1] = robot i fires RIGHT = walls in [pos_i, capped-right]
        //
        //   dp[i][0] = dp[i-1][0] + leftWalls[i]   // i-1 LEFT,  i LEFT  → gap between skipped
        //            OR dp[i-1][1] + leftWalls[i]   // i-1 RIGHT, i LEFT  → GAP DOUBLE COUNTED ✗
        //
        // The REAL correct DP must account for the gap between i-1 and i being
        // assigned to EITHER i-1 (right) OR i (left), not both:
        //
        //   Let gap[i] = walls strictly between robot[i-1] and robot[i]
        //   Let farLeft[i]  = walls robot i can reach to its left  (beyond gap, at boundary)
        //   Let farRight[i] = walls robot i can reach to its right (beyond gap, at boundary)
        //
        // Simpler decomposition:
        //   wallsLeft[i]  = walls in [max(pos-dist, prevPos+1), pos]
        //   wallsRight[i] = walls in [pos, min(pos+dist, nextPos-1)]
        //
        //   The gap between robot i and i+1 is covered by EITHER wallsRight[i] OR wallsLeft[i+1].
        //
        // dp[i][0] = robot i fires left
        //          = best outcome for robots 0..i where i fires left
        //          Robot i-1 could have fired LEFT or RIGHT, but if i fires LEFT,
        //          the gap (i-1 to i) is NOT covered by i (leftWalls[i] is capped at prevPos+1).
        //          So gap is only coverable by i-1 firing RIGHT.
        //
        //   dp[i][0] = max(
        //       dp[i-1][0],          // i-1 fired left  → gap unclaimed
        //       dp[i-1][1]           // i-1 fired right → gap claimed by i-1 (wallsRight[i-1])
        //   ) + wallsLeft[i]        // i fires left (no gap overlap)
        //
        //   dp[i][1] = max(
        //       dp[i-1][0],          // i-1 fired left  → gap unclaimed (i fires right, gap claimed by i)
        //       dp[i-1][1]           // i-1 fired right → gap already claimed by i-1, i's right doesn't recount
        //   ) + wallsRight[i]
        //
        // BUT this is still wrong because wallsRight[i-1] and wallsLeft[i] can overlap
        // if both robots reach into the same gap region!
        //
        // FINAL correct approach:
        // Split the gap between robot[i] and robot[i+1] explicitly.
        // wallsRight[i] only goes up to min(pos+dist, nextPos-1) -- already capped.
        // wallsLeft[i+1] only goes down to max(pos-dist, prevPos+1) -- already capped.
        // These two ranges are DISJOINT (right[i] ends before nextPos, left[i+1] starts after prevPos).
        // So actually there's NO double counting of individual walls!
        //
        // The real bug: when BOTH right[i] and left[i+1] fire into the same gap,
        // a wall in the MIDDLE of the gap could be in BOTH ranges.
        // Example: robots at 2 and 10, wall at 6.
        //   right[0]: [2, min(2+dist, 9)] — if dist>=4, includes wall 6
        //   left[1]:  [max(10-dist, 3), 10] — if dist>=4, includes wall 6
        // BOTH claim wall 6! This is the double count.
        //
        // The gap between robots i and i+1 must be PARTITIONED.
        // We need to decide: does the gap go to robot i (fires right) or robot i+1 (fires left)?

        // Precompute for each gap between consecutive robots:
        // gapWalls[i] = total walls strictly between robot[i] and robot[i+1]
        // reachRight[i] = walls robot[i] can reach in gap i (firing right), capped by dist
        // reachLeft[i+1] = walls robot[i+1] can reach in gap i (firing left), capped by dist

        // dp[i][0] = best walls for robots 0..i, robot i fires LEFT
        // dp[i][1] = best walls for robots 0..i, robot i fires RIGHT
        //
        // For the gap between i and i+1:
        //   If robot i   fires RIGHT and robot i+1 fires LEFT  → pick max of their gap coverage
        //   If robot i   fires RIGHT and robot i+1 fires RIGHT → robot i covers its part of gap
        //   If robot i   fires LEFT  and robot i+1 fires LEFT  → robot i+1 covers its part of gap
        //   If robot i   fires LEFT  and robot i+1 fires RIGHT → neither covers the gap
        //
        // Let's define:
        //   R[i] = walls robot i reaches to its RIGHT (capped at nextRobot-1)
        //   L[i] = walls robot i reaches to its LEFT  (capped at prevRobot+1)
        //
        // When robot i fires RIGHT and robot i+1 fires LEFT, they both try to cover gap i.
        // We must ensure no wall in gap i is counted twice.
        // 
        // Solution: split gap at the boundary of whoever reaches further.
        // Actually simpler: the constraint already caps them. Robot i's right range ends at
        // min(pos_i + dist_i, pos_{i+1} - 1), and robot i+1's left range starts at
        // max(pos_{i+1} - dist_{i+1}, pos_i + 1). These CAN overlap!
        //
        // THE FIX: When both fire into the gap, only one gets to claim it.
        // We need an additional DP state or gap partition.

        // =====================================================================
        // CORRECT DP with gap partitioning
        // =====================================================================
        // For each consecutive pair (i, i+1), define the "contest gap":
        //   All walls strictly between pos[i] and pos[i+1].
        //
        // A wall w in the gap is reachable by robot i  firing right iff pos[i]+dist[i]  >= w
        //                         by robot i+1 firing left  iff pos[i+1]-dist[i+1] <= w
        //
        // We introduce gap walls counts:
        //   rOnly[i]  = walls in gap reachable by i firing right but NOT by i+1 firing left
        //   lOnly[i]  = walls in gap reachable by i+1 firing left but NOT by i firing right  
        //   both[i]   = walls in gap reachable by BOTH
        //   neither[i]= walls in gap reachable by NEITHER
        //
        // Then:
        //   if i fires RIGHT, i+1 fires LEFT:  rOnly[i] + lOnly[i] + both[i]  (union)
        //   if i fires RIGHT, i+1 fires RIGHT: rOnly[i] + both[i]... wait, i+1 fires right
        //                                       so i+1 doesn't take from gap → just rOnly+both? No.
        //
        // Let me redefine cleanly:
        //   gR[i]  = walls in gap[i] that robot i   can reach firing right
        //   gL[i+1]= walls in gap[i] that robot i+1 can reach firing left
        //
        // dp transitions for gap between robot i and robot i+1:
        //   dp[i+1][L] from dp[i][L]: i fires left,  i+1 fires left  → i+1 gets gL[i+1]
        //   dp[i+1][L] from dp[i][R]: i fires right, i+1 fires left  → together get union(gR[i], gL[i+1])
        //                                                                but i already counted gR[i] in dp[i][R]!
        //                                                                so i+1 gets only gL[i+1] - overlap
        //   dp[i+1][R] from dp[i][L]: i fires left,  i+1 fires right → i gets nothing from gap, i+1 gets nothing from gap
        //   dp[i+1][R] from dp[i][R]: i fires right, i+1 fires right → i already got gR[i], i+1 gets nothing from gap

        // So:
        //   wallsLeft[i]  = L[i] (walls robot i reaches LEFT of itself, capped by prev robot)
        //   wallsRight[i] = gR[i] + walls at pos[i] itself if any (walls robot i reaches RIGHT, capped)
        //
        //   dp[i+1][L] = max(
        //       dp[i][L] + wallsLeft[i+1],                              // i fired left,  i+1 fires left
        //       dp[i][R] + (wallsLeft[i+1] - overlap(gR[i], gL[i+1]))  // i fired right, i+1 fires left → subtract overlap
        //   )
        //   dp[i+1][R] = max(dp[i][L], dp[i][R]) + wallsRight[i+1]
        //   (i's direction doesn't affect i+1 firing right, since right is capped at next robot)

        // overlap(gR[i], gL[i+1]):
        //   gR[i]   covers [pos[i], min(pos[i]+dist[i], pos[i+1]-1)]
        //   gL[i+1] covers [max(pos[i+1]-dist[i+1], pos[i]+1), pos[i+1]]
        //   overlap = [max(pos[i], max(pos[i+1]-dist[i+1], pos[i]+1)),
        //              min(min(pos[i]+dist[i], pos[i+1]-1), pos[i+1])]
        //           = [max(pos[i+1]-dist[i+1], pos[i]+1),   ← left of overlap (>pos[i] always)
        //              min(pos[i]+dist[i], pos[i+1]-1)]      ← right of overlap (<pos[i+1] always)

        long[] dpL = new long[n]; // dp[i][fire LEFT]
        long[] dpR = new long[n]; // dp[i][fire RIGHT]

        // Walls strictly to the LEFT of robot 0 (no prev robot blocking)
        int pos0 = bots[0][0], dist0 = bots[0][1];
        int nextPos0 = (n > 1) ? bots[1][0] : Integer.MAX_VALUE;
        dpL[0] = countWalls(walls, prefix, pos0 - dist0, pos0);
        dpR[0] = countWalls(walls, prefix, pos0, Math.min((long)pos0 + dist0, (long)nextPos0 - 1));

        for (int i = 1; i < n; i++) {
            int pos  = bots[i][0],  dist  = bots[i][1];
            int ppos = bots[i-1][0], pdist = bots[i-1][1];
            int nextPos = (i + 1 < n) ? bots[i+1][0] : Integer.MAX_VALUE;

            // wallsLeft[i]: walls robot i reaches LEFT, capped at ppos+1
            long wL = countWalls(walls, prefix, Math.max((long)pos - dist, (long)ppos + 1), pos);

            // wallsRight[i]: walls robot i reaches RIGHT, capped at nextPos-1
            long wR = countWalls(walls, prefix, pos, Math.min((long)pos + dist, (long)nextPos - 1));

            // overlap between gR[i-1] and gL[i]:
            // gR[i-1] = [ppos, min(ppos+pdist, pos-1)]
            // gL[i]   = [max(pos-dist, ppos+1), pos]
            long gRright = Math.min((long)ppos + pdist, (long)pos - 1);
            long gLleft  = Math.max((long)pos - dist, (long)ppos + 1);
            long overlapL = gLleft;
            long overlapR = gRright;
            long overlap = (overlapL <= overlapR) ? countWalls(walls, prefix, overlapL, overlapR) : 0;

            // dp[i][LEFT]:
            //   from dp[i-1][LEFT]:  prev fired left, i fires left → no contest in gap, i gets wL
            //   from dp[i-1][RIGHT]: prev fired right (already counted gR), i fires left → i gets wL - overlap
            dpL[i] = Math.max(
                dpL[i-1] + wL,
                dpR[i-1] + wL - overlap
            );

            // dp[i][RIGHT]:
            //   prev direction doesn't matter for i's right shot (no overlap with prev's ranges)
            dpR[i] = Math.max(dpL[i-1], dpR[i-1]) + wR;
        }

        return (int) Math.max(dpL[n-1], dpR[n-1]);
    }

    private long countWalls(int[] walls, int[] prefix, long lo, long hi) {
        if (lo > hi) return 0;
        int l = lowerBound(walls, (int) Math.max(lo, Integer.MIN_VALUE));
        int r = upperBound(walls, (int) Math.min(hi, Integer.MAX_VALUE));
        return prefix[r] - prefix[l];
    }

    private int lowerBound(int[] arr, int target) {
        int lo = 0, hi = arr.length;
        while (lo < hi) {
            int mid = (lo + hi) >>> 1;
            if (arr[mid] < target) lo = mid + 1;
            else hi = mid;
        }
        return lo;
    }

    private int upperBound(int[] arr, int target) {
        int lo = 0, hi = arr.length;
        while (lo < hi) {
            int mid = (lo + hi) >>> 1;
            if (arr[mid] <= target) lo = mid + 1;
            else hi = mid;
        }
        return lo;
    }
}