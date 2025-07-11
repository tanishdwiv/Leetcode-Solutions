class Solution {
    public int countStudents(int[] students, int[] sandwiches) {
        
        int countcircular=0;
        int countsquare=0;
        for(int choice:students){
            if(choice==0){
                countcircular++;
            }
            else{
                countsquare++;
            }
        }
        for(int sandwich:sandwiches){
            if(sandwich==0 && countcircular==0){
                return countsquare;
            }
             if(sandwich==1 && countsquare==0){
                return countcircular;
            }
            if(sandwich==0){
                countcircular--;
            }
             if(sandwich==1){
                countsquare--;
            }
        }
        return 0;
    }
}