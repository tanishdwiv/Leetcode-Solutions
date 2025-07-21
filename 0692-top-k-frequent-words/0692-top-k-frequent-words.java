class Solution {
    public List<String> topKFrequent(String[] words, int k) {
    //     HashMap<String,Integer> map=new HashMap<>();
    //     for(String word:words){
    //         map.put(word,map.getOrDefault(word,0)+1);
    //     }

    //     PriorityQueue<String> maxheap=new PriorityQueue<>((a,b)->{
    //         int freqcompare = map.get(b) - map.get(a);
    //         if (freqcompare == 0) {//if same frequency
    //             return a.compareTo(b); // alphabetically smaller comes first
    //         }
    //         return freqcompare;
    //     });;
    //     maxheap.addAll(map.keySet());

    //    List<String> ans=new ArrayList<>();
    //     for(int i=0;i<k;i++){
    //         ans.add(maxheap.poll());
    //     }
    //     return ans;

    // using priority queue o(nlogn)

    //now using priorityqueue

         HashMap<String,Integer> map=new HashMap<>();
        for(String word:words){
            map.put(word,map.getOrDefault(word,0)+1);
        }
        

    List<String>[] buckets = new List[words.length + 1];

        for (String word : map.keySet()) {
            int frequency = map.get(word);
            if (buckets[frequency] == null) {
                buckets[frequency] = new ArrayList<>();
            }
            buckets[frequency].add(word);
        }
        List<String> result = new ArrayList<>();
       

        for (int i = buckets.length - 1; i >= 0 && result.size() < k; i--) {
            if (buckets[i] != null) {
                 Collections.sort(buckets[i]);
                for (String word : buckets[i]) {
                    result.add(word);
                    if (result.size()== k) {
                        break;
                    }
                }
            }
        }
        
        return result;
    }
}