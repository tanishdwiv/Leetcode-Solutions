class Solution {
    public int minSetSize(int[] arr) {
        HashMap<Integer,Integer> count=new HashMap<>();
        for(int num:arr){
            count.put(num,count.getOrDefault(num,0)+1);
        }
        PriorityQueue<Integer> maxheap=new PriorityQueue<>((a,b)->b-a);
        maxheap.addAll(count.values());

        int n=arr.length;
        int target=n/2;
        int setsize=0;
        int elementremoved=0;
        while(elementremoved<target){
            setsize++;
            elementremoved+=maxheap.poll();
        }
        return setsize;
        
    }
}