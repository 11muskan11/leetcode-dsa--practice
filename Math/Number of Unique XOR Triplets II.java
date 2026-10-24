class Solution {
    public int uniqueXorTriplets(int[] nums) {
        final int MAX = 2048;
        boolean[][] dp = new boolean[4][MAX];
        dp[0][0] = true;

        for (int num : nums) {
            for (int cnt = 2; cnt >= 0; cnt--) {
                for (int x = 0; x < MAX; x++) {
                    if (dp[cnt][x]) {
                        dp[cnt + 1][x ^ num] = true;
                    }
                }
            }
        }
        for (int num : nums) {
            dp[3][num] = true;
        }
        int ans = 0;
        for (boolean b : dp[3]) {
            if (b) ans++;
        }
        return ans;
    }
}
