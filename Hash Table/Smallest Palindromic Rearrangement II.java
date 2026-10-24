class Solution {
    static final long LIMIT = 1_000_001L;
    long gcd(long a, long b) {
        while (b != 0) {
            long t = a % b;
            a = b;
            b = t;
        }
        return a;
    }
    // Computes C(n,r), capped at LIMIT
    long comb(int n, int r) {
        if (r < 0 || r > n) return 0;
        r = Math.min(r, n - r);
        long res = 1;
        for (int i = 1; i <= r; i++) {
            long num = n - r + i;
            long den = i;
            long g = gcd(num, den);
            num /= g;
            den /= g;

            g = gcd(res, den);
            res /= g;
            den /= g;

            if (res > LIMIT / num) return LIMIT;
            res *= num;
            res /= den;

            if (res > LIMIT) return LIMIT;
        }

        return Math.min(res, LIMIT);
    }

    // Number of distinct permutations of multiset
    long countWays(int[] cnt) {
        int total = 0;
        for (int x : cnt) total += x;

        long ways = 1;
        int rem = total;

        for (int f : cnt) {
            if (f == 0) continue;

            long c = comb(rem, f);

            if (ways > LIMIT / c)
                ways = LIMIT;
            else
                ways *= c;

            if (ways > LIMIT)
                ways = LIMIT;

            rem -= f;
        }

        return ways;
    }

    public String smallestPalindrome(String s, int k) {

        int[] freq = new int[26];

        for (char c : s.toCharArray())
            freq[c - 'a']++;

        int[] half = new int[26];
        char mid = 0;

        for (int i = 0; i < 26; i++) {
            half[i] = freq[i] / 2;
            if ((freq[i] & 1) == 1)
                mid = (char) ('a' + i);
        }

        if (countWays(half) < k)
            return "";

        StringBuilder left = new StringBuilder();

        int len = s.length() / 2;

        for (int pos = 0; pos < len; pos++) {

            for (int c = 0; c < 26; c++) {

                if (half[c] == 0)
                    continue;

                half[c]--;

                long ways = countWays(half);

                if (ways >= k) {
                    left.append((char) ('a' + c));
                    break;
                }

                k -= ways;
                half[c]++;
            }
        }

        StringBuilder ans = new StringBuilder(left);

        if ((s.length() & 1) == 1)
            ans.append(mid);

        ans.append(new StringBuilder(left).reverse());

        return ans.toString();
    }
}
