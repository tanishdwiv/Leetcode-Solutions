class Solution {
    public int[] topKFrequent(int[] nums, int k) {
         HashMap<Integer,Integer> map=new HashMap<>();
        // for(int num:nums){
        //     map.put(num,map.getOrDefault(num,0)+1);
        // }
        // PriorityQueue<Integer> maxheap=new PriorityQueue<>((a,b)->map.get(b)-map.get(a));
        // maxheap.addAll(map.keySet());

        // int[] ans=new int[k];
        // for(int i=0;i<k;i++){
        //     ans[i]=maxheap.poll();
        // }
        // return ans; 
         //using priority queue it is o(nlogn)



         //using bucket sort where index will act as my frequency and will put number with that frequency index

         for(int num:nums){
            map.put(num,map.getOrDefault(num,0)+1);
        }

        List<Integer>[] bucket=new List[nums.length+1];
        for(int num:map.keySet()){
            int frequency=map.get(num);
            if(bucket[frequency]==null)//by default in array all values will be null so if we add something we will create a list at particular index than add
            {
                bucket[frequency]=new ArrayList<>();
            }
            bucket[frequency].add(num);
        }

        int[] result = new int[k];
        int index = 0;
        for(int i=bucket.length-1;i>=0 && index<k;i--){
            if(bucket[i]!=null){
                for(int num:bucket[i]){
                    result[index]=num;
                    index++;
                    if(index==k)
                    break;
                }

            }
        }
        return result;
    }
}