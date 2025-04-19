class Solution {
    public String reverseWords(String s) {
        
        String[] words=s.trim().split(" +");
        StringBuilder sb=new StringBuilder();
        for(int i=words.length-1;i>=0;i--){
            sb.append(words[i]);
           if(i!=0) sb.append(" ");//last wale ko chorh ke sb mai space add krdo beech mai
        }
        return sb.toString();
    }
}