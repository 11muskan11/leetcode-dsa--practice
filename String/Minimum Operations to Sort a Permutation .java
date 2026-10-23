class Solution {
    public int minOperations(int[] nums) {
        int n=nums.length;
        int s=nums[0];
        boolean asc=true, desc=true;
        for(int i=0;i<n;i++){
            if(nums[i]!=(s+i)%n) asc=false;
            if(nums[i]!=((s-i)%n+n)%n) desc=false;
        }
        if (asc){
            if (s==0)
            return 0;
            return Math.min(n-s,s+2);

        }
        if(desc){
            int a=(n-s-1)%n;
            int b=(s+1)%n;
            return 1+Math.min(a,b);

        }
        return -1;
    }
}
