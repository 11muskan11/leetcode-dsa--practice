class Solution {
    public int findNumbers(int[] nums) {
        int r=0;
        int e=0;
        for(int i=0;i<nums.length;i++){
            int c=0;
            while(nums[i]!=0){
                r=nums[i]%10;
                c++;
                nums[i]=nums[i]/10;

            }
            if(c%2==0){
                e++;
            }
        }
        return e;
    }
}
