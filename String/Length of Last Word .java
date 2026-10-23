class Solution {
    public int lengthOfLastWord(String s) {
        
        int c=0;
        int l=s.length();
        int i=l-1;
        while(i>=0&&s.charAt(i) == ' '){
            i--;
        }
        for(;i>=0;i--){
            char ch=s.charAt(i);
            if(ch == ' '){
                break;
            }
            c++;
        }
        return c;
    }
}
