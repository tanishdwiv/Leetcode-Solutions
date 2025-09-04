class Solution {
    public int minDistance(String word1, String word2) {
        int i=word1.length()-1;
    int j=word2.length()-1;
    int[][] memo=new int[i+1][j+1];
    for(int[] row:memo){
        Arrays.fill(row,-1);
    }
    
        return solve(word1,word2,i,j,memo);
    }
    int solve(String w1,String w2,int i,int j,int[][] memo){
        if(i<0){ //if w1 is empty we will add all characters of w2 to w1
             return j+1;
        }
        if(j<0){ //if w2 is empty we will remove all characters from w1
            return i+1;
        }
        if(memo[i][j]!=-1){
            return memo[i][j];
        }

        if(w1.charAt(i)==w2.charAt(j)){
            return solve(w1,w2,i-1,j-1,memo);
        }
        else{
            int insert=1+solve(w1,w2,i,j-1,memo);//because we have inserted in w1 and hanled the last character from word2 so we move 1 step less from word 2
            int delete=1+solve(w1,w2,i-1,j,memo);//because we have deleted onr character from w1
            int replace=1+solve(w1,w2,i-1,j-1,memo);//replaced from both sides so moving in both
            return memo[i][j]=Math.min(insert,Math.min(delete,replace));
        }
    }
}