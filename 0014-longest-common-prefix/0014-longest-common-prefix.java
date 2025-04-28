public class Solution {
    public String longestCommonPrefix(String[] strs) {
        // if (strs == null || strs.length == 0) return "";
        // String prefix = strs[0];
        // for (String s : strs)
        //     while (s.indexOf(prefix) != 0)
        //         prefix = prefix.substring(0, prefix.length() - 1);
        // return prefix;
        StringBuilder sb=new StringBuilder();
        Arrays.sort(strs);

        char[] first=strs[0].toCharArray();
        char[] second=strs[strs.length-1].toCharArray();

        for(int i=0;i<first.length;i++){
            if(first[i]!=second[i]){
                break;
            }
            sb.append(first[i]);
        }
        return sb.toString();
    }
}