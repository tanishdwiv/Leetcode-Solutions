class Solution {
    public int numberOfSubstrings(String s) {
        Map<Character,Integer> map=new HashMap<>();
        int count=0;
        int left=0;
        for(int right=0;right<s.length();right++){
            char current=s.charAt(right);
            map.put(current,map.getOrDefault(current,0)+1);
        
        while(map.containsKey('a')&&map.containsKey('b')&&map.containsKey('c')){
          count+=(s.length()-right);
          char leftchar=s.charAt(left);//shrinking my window
        map.put(leftchar,map.get(leftchar)-1);

        //if my count character is zero i will remove from my map
        if(map.get(leftchar)==0){
            map.remove(leftchar);
        }
        left++;
        }
        }
        return count;
        
    }
}