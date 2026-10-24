class Solution {
    private int[][] memo;
    private int[] suffixSum;

    public int stoneGameII(int[] piles) {
        int n = piles.length;
        memo = new int[n][n + 1];
        suffixSum = new int[n];
        
        suffixSum[n - 1] = piles[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            suffixSum[i] = suffixSum[i + 1] + piles[i];
        }
        
        return dp(0, 1);
    }

    private int dp(int i, int M) {
        if (i + 2 * M >= suffixSum.length) {
            return suffixSum[i];
        }
        if (memo[i][M] != 0) {
            return memo[i][M];
        }

        int maxStones = 0;
        for (int x = 1; x <= 2 * M; x++) {
            int opponentStones = dp(i + x, Math.max(M, x));
            maxStones = Math.max(maxStones, suffixSum[i] - opponentStones);
        }

        memo[i][M] = maxStones;
        return maxStones;
    }
}
