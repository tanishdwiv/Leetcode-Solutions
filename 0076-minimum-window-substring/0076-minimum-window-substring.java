class Solution {
    public String minWindow(String s, String t) {
          if (s.length() < t.length()) return "";
        Map<Character,Integer> target=new HashMap<>();
        for(char c:t.toCharArray()){
            target.put(c,target.getOrDefault(c,0)+1);
        }
        int left=0,right=0;
        int minlength=Integer.MAX_VALUE;
        int start=0;
        int required=target.size();
        int formed=0;
        Map<Character,Integer> windowmap=new HashMap<>();
        while(right<s.length()){
            char c=s.charAt(right);
            windowmap.put(c,windowmap.getOrDefault(c,0)+1);
            if(target.containsKey(c)&&windowmap.get(c).intValue()==target.get(c).intValue())  {
                formed++;
            }
            while(left<=right&&formed==required){
                if(right-left+1<minlength){
                    minlength=right-left+1;
                    start=left;
                }
                char l=s.charAt(left);
                windowmap.put(l,windowmap.get(l)-1);
                if(target.containsKey(l)&&windowmap.get(l).intValue()<target.get(l).intValue()){
                    formed--;
                }
                left++;
            }
            right++;

        }
        return minlength==Integer.MAX_VALUE?"":s.substring(start,start+minlength);
        
    }
}