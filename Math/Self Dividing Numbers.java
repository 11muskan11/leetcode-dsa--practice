class Solution {
    private boolean isSelfDividingInteger(int n){
        int num=n;
        while(num>0){
            int rem= num%10;
            num/=10;
            if(rem==0 || n%rem !=0){
                return false;
            }
        }
        return true;
    }
    public List<Integer> selfDividingNumbers(int left, int right) {
        List<Integer> result = new ArrayList<>();
        for(int i=left;i<=right;i++){
            if(isSelfDividingInteger(i)==true){
                result.add(i);
            }
        }
        return result;
    }
}
