class Solution {
    public long numberOfWeeks(int[] milestones) {
        long total = 0;
        long maxProject = 0;

      
        for (int m : milestones) {
            total += m;
            maxProject = Math.max(maxProject, m);
        }

        if (maxProject <= total - maxProject) {
            return total;
        }
        
      
        return 2 * (total - maxProject) + 1;
    }
}
