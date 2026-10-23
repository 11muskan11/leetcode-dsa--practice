class Solution {
    public int removeDuplicates(int[] nums) {
        int l=nums.length;
        int k=2;
        for(int i=2;i<l;i++){
            if(nums[i]!=nums[k-2]){
                nums[k]=nums[i];
                k++;
            }
        }return k;
    }
}
