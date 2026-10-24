class Solution {
    public int findGCD(int[] nums) {
        int l=nums.length;
        int min=nums[0];
        int max=nums[0];
        int gcd=0;
        for(int i=1;i<l;i++){
            max=Math.max(max,nums[i]);
            min=Math.min(min,nums[i]);
        }
        for(int i=1;i<=max;i++){
            if(min%i==0 && max%i==0){
                if(i>gcd){
                    gcd=i;
                }
            }
        }
        return gcd;
    }
}
