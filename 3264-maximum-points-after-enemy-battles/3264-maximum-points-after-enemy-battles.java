class Solution {
    public long maximumPoints(int[] enemy, int current) {
        int n = enemy.length;
        long points = 0;
        Arrays.sort(enemy);
        if(enemy[0] > current)
         return 0;
        int i = n-1;
        while(i >= 0)
        {
            if(current >= enemy[0])  //we can use current energy to kill that enemy
            {
                points += current/enemy[0]; // gain points by repeatedly killing while we still can
                current %= enemy[0];
            }
            else  // since we cannot kill enemies cuz energy is less, we use up the biggest enemy and move a step back
            {
                current += enemy[i];
                i--;
            }
        }


        return points;
    }
}