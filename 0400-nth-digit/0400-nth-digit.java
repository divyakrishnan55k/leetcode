class Solution {
    public int findNthDigit(int n) {
        int len=1;
        long count=9;
        int start=1;
        while(n>len*count){
            n-=len*count;
            len++;
            count*=10;
            start*=10;
        }
        int number=start+(n-1)/len;
        String s=Integer.toString(number);
        return s.charAt((n-1)%len)-'0';
            }
        }        
        
    
