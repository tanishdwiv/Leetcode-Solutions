class Solution {
    public boolean arrayStringsAreEqual(String[] word1, String[] word2) {
        StringBuilder sb = new StringBuilder("");
        StringBuilder sv = new StringBuilder("");
        
        for(int i=0;i<word1.length;i++){
            sb.append(word1[i]);
        }

        for(int i=0;i<word2.length;i++){
            sv.append(word2[i]);
        }
        if(sb.toString().equals(sv.toString())){
            return true;
        }

        return false;
    }
}