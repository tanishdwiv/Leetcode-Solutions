class Solution {
    public int mincostTickets(int[] days, int[] costs) {
        Map<Integer, Integer> memo = new HashMap<>();
        return minCost(0, days, costs, memo);
    }
    private int minCost(int dayIndex, int[] days, int[] costs, Map<Integer, Integer> memo) {
        if (dayIndex >= days.length) {
            return 0;
        }
        if (memo.containsKey(dayIndex)) {
            return memo.get(dayIndex);
        }
        int cost1Day = costs[0] + minCost(dayIndex + 1, days, costs, memo);
        int nextDayFor7DayPass = dayIndex;
        while (nextDayFor7DayPass < days.length && days[nextDayFor7DayPass] < days[dayIndex] + 7) {
            nextDayFor7DayPass++;
        }
        int cost7Day = costs[1] + minCost(nextDayFor7DayPass, days, costs, memo);
   int nextDayFor30DayPass = dayIndex;
        while (nextDayFor30DayPass < days.length && days[nextDayFor30DayPass] < days[dayIndex] + 30) {
            nextDayFor30DayPass++;
        }
        int cost30Day = costs[2] + minCost(nextDayFor30DayPass, days, costs, memo);
        int minCost = Math.min(cost1Day, Math.min(cost7Day, cost30Day));
        memo.put(dayIndex, minCost);
        return minCost;
    }
}