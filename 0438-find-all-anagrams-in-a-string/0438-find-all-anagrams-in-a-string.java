class Solution {
    public List<Integer> findAnagrams(String s, String p) {
       ArrayList<Integer> list =new ArrayList<>();
        int[] sarray=new int[26];
        int[] window=new int[26];
        int low=0;
        int high=p.length();
        for(char c:p.toCharArray()){
            sarray[c-'a']++;
        }
        //i am now sliding through s
        for(int i=0;i<s.length();i++){
            window[s.charAt(i)-'a']++;

            //i am checking if my window exceeds the length of p
            if(i>=p.length()){
                window[s.charAt(i-p.length())-'a']--;
            }
            //and now checking if p array frequency is same with s array
            if(Arrays.equals(sarray,window)){
                list.add(i-p.length()+1);
            }
        }
        return list;

        
    }
}