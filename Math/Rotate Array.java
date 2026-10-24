class Solution {
    public void rotate(int[] nums, int k) {
        int l=nums.length;
        k=k%l;
        reverse(nums,0,l-1);
        reverse(nums,0,k-1);
        reverse(nums,k,l-1);

    }
    private void reverse(int[] nums,int left, int right){
        while(left<right){
            int temp=nums[left];
            nums[left]=nums[right];
            nums[right]=temp;
            left++;
            right--;
        }
    }

}
