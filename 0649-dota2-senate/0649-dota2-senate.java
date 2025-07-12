class Solution {
    public String predictPartyVictory(String senate) {
         Queue<Integer> rad = new LinkedList<>();
        Queue<Integer> dir = new LinkedList<>();
         int n = senate.length();
         for (int i = 0; i < n; i++) {
            if (senate.charAt(i) == 'R') {
                rad.add(i);
            } else {
                dir.add(i);
            }
        }

        while(!rad.isEmpty() && !dir.isEmpty()){
            int i=rad.poll();
            int j=dir.poll();
            if(i<j){
                rad.add(i+n);
            }
            else{
                dir.add(i+n);
            }
        }
        return rad.isEmpty()?"Dire":"Radiant";
        
    }
}