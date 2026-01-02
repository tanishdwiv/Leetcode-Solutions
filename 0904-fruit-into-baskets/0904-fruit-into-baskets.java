class Solution {
    public int totalFruit(int[] fruits) {
        HashMap<Integer,Integer> freq=new HashMap<>();
int low=0;
int res=-1;
    for(int high=0;high<fruits.length;high++){
        freq.put(fruits[high],freq.getOrDefault(fruits[high],0)+1);
        
        //if my freq increse beyond k
        while(freq.size()>2){
            //i will have to remove my leftmost character
            freq.put(fruits[low],freq.get(fruits[low])-1);
            //now if my leftmost character frequency becomes 0
            if(freq.get(fruits[low])==0){
                freq.remove(fruits[low]);
            }
            low++;
        }
        //atmost 2
        if(freq.size()<=2){
            res=Math.max(res,high-low+1);
        }
        
    }
    return res;

        
    }
}