class Solution {
    public int pivotInteger(int n) {
        int total=n*(n+1)/2;
        int leftsum=0;
        int rightsum=0;
        for(int i=0;i<=n;i++){
            leftsum+=i;
            rightsum=total-leftsum+i;
            if(rightsum==leftsum){
                return i;
            }
        }
        return -1;
    }
}
