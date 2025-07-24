class Solution {
    public String frequencySort(String s) {
        HashMap<Character,Integer> map = new HashMap<>();
        for(char c : s.toCharArray()){
            map.put(c,map.getOrDefault(c , 0) + 1);
        }
    //     PriorityQueue<Map.Entry<Character,Integer>> pq = new PriorityQueue<>((e1,e2) -> e2.getValue() - e1.getValue());
    //     pq.addAll(map.entrySet());
    //     StringBuilder sb = new StringBuilder();
    //      while (!pq.isEmpty()) {
    //     Map.Entry<Character, Integer> entry = pq.poll();
    //     char character = entry.getKey();
    //     int frequency = entry.getValue();

    //     // Append the character 'frequency' times
    //     for (int i = 0; i < frequency; i++) {
    //         sb.append(character);
    //     }
    // }

    //     return sb.toString();
   StringBuilder answer= new StringBuilder();
    PriorityQueue<Character> maxheap=new PriorityQueue<>((a,b)->map.get(b)-map.get(a));
    maxheap.addAll(map.keySet());
    while(!maxheap.isEmpty()){
        char c=maxheap.poll();
        int frequency=map.get(c);
      for(int i=0;i<frequency;i++){
        answer.append(c);
      }
    }
    return answer.toString();
    }
}