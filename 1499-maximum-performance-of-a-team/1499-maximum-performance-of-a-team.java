class Solution {
      public int maxPerformance(int n, int[] speed, int[] efficiency, int k) {
      int[][] engineers = new int[n][2];
        for (int i = 0; i < n; i++) {
            engineers[i][0] = speed[i];
            engineers[i][1] = efficiency[i];
    }
    Arrays.sort(engineers, (a, b) -> b[1] - a[1]);
    PriorityQueue<Integer> speedheap = new PriorityQueue<>(k);
    long totalspeed = 0;
    long maxperformance = 0;
   int MOD = 1_000_000_007;
    for (int[] engineer : engineers) {
    
     int currentefficiency = engineer[1];
     int currentspeed = engineer[0];
     speedheap.add(currentspeed);
    totalspeed += currentspeed;
    if (speedheap.size() > k) {
        totalspeed -= speedheap.poll();
        }
         long currentperformance = totalspeed * currentefficiency;
            maxperformance = Math.max(maxperformance, currentperformance);
        }
        return (int)(maxperformance % MOD);
}
}