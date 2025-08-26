// class Solution {
//     public int mincostTickets(int[] days, int[] costs) {
//         return solve(days,costs,0);

//     }
//   public  int solve(int[] days,int[] costs,int currentindex){
//         if(currentindex>days.length){
//             return 0;
//         }

//         //if i buy one day pass
//         int day1cost=costs[0]+solve(days,costs,currentindex+1);

//         //if i buy 7day pass
//         int nextdayafter7=currentindex;
//         while(nextdayafter7<days.length && days[nextdayafter7]<days[currentindex]+7){
//              nextdayafter7++;
//         }
//         int day7cost=costs[1]+solve(days,costs, nextdayafter7);

//        //if i buy day 30 pass
//         int nextdayafter30=currentindex;
//         while(nextdayafter30<days.length && days[nextdayafter7]<days[currentindex]+30){
//              nextdayafter30++;
//         }
//         int day30cost=costs[2]+solve(days,costs, nextdayafter30);


//         return Math.min(day1cost,Math.min(day7cost,day30cost));

//     }
// }



//memoization
class Solution {
    public int mincostTickets(int[] days, int[] costs) {
        int[] dp=new int[days.length+1];
        Arrays.fill(dp,-1);
        return solve(days,costs,0,dp);

    }
  public  int solve(int[] days,int[] costs,int currentindex,int[] dp){
        if(currentindex>=days.length){
            return 0;
        }

        if(dp[currentindex]!=-1){
            return dp[currentindex];
        }

        //if i buy one day pass
        int day1cost=costs[0]+solve(days,costs,currentindex+1,dp);

        //if i buy 7day pass
        int nextdayafter7=currentindex;
        while(nextdayafter7<days.length && days[nextdayafter7]<days[currentindex]+7){
             nextdayafter7++;
        }
        int day7cost=costs[1]+solve(days,costs, nextdayafter7,dp);

       //if i buy day 30 pass
        int nextdayafter30=currentindex;
        while(nextdayafter30<days.length && days[nextdayafter30]<days[currentindex]+30){
             nextdayafter30++;
        }
        int day30cost=costs[2]+solve(days,costs, nextdayafter30,dp);


        return dp[currentindex]=Math.min(day1cost,Math.min(day7cost,day30cost));

    }
}