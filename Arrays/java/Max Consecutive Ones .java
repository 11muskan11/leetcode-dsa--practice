class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int l=nums.length;
        int c=0;
        int mc=0;
        for(int i=0;i<l;i++){
            if(nums[i]==1){
                c++;
            
            mc=Math.max(mc,c);
            }
            else{
                c=0;
            }
        }return mc;
    }
}
