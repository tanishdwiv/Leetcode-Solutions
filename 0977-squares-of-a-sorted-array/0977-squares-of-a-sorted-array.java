class Solution {
    public int[] sortedSquares(int[] nums) {
        int n=nums.length;
        List<Integer> neg=new ArrayList<>();
        List<Integer> pos=new ArrayList<>();


        //separating negative and positive
        for(int num:nums){
            if(num<0)
            neg.add(num);
            else
            pos.add(num);
        }

        //case 1 no negative
        if(neg.size()==0){
            for(int i=0;i<pos.size();i++){
            pos.set(i,pos.get(i)*pos.get(i));
            }
            return pos.stream().mapToInt(Integer::intValue).toArray();

        }

        //case 2 no positive 
        if(pos.size()==0){
            for(int i=0;i<neg.size();i++){
                neg.set(i,neg.get(i)*neg.get(i));
            }
            Collections.reverse(neg);
             return neg.stream().mapToInt(Integer::intValue).toArray();
            
        }

        //case3 both neg and pos
        int i=0;
        int j=0;
        int id=0;
         int n1=neg.size();
         int n2=pos.size();
         int[] res=new int[n1+n2];

         //squares negative and reverse them 
         for(i=0;i<n1;i++){
             neg.set(i,neg.get(i)*neg.get(i));
         }
         Collections.reverse(neg);


         //squares positives
         for( i=0;i<n2;i++){
             pos.set(i,pos.get(i)*pos.get(i));
    
         }
         //merge two sorted list
         i=0;
         while(i<n1 && j<n2){
            if(neg.get(i)<=pos.get(j)){
                res[id++]=neg.get(i++);
            }
            else{
                res[id++]=pos.get(j++);
            }
         }

         while(i<n1){
            res[id++]=neg.get(i++);
         }
         while(j<n2){
            res[id++]=pos.get(j++);
         }
         return res;
        
    }
}