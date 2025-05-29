class Solution {
    public boolean lemonadeChange(int[] bills) {
        int five=0,ten=0;
        for(int i=0;i<bills.length;i++){
            if(bills[i]==5){
                five++;
            }
            else if(bills[i]==10){//10 wale ke liye
                if(five>=1){
                    five--;
                    ten++;
                }
                else{
                return false;
                }
            }
            else {//for 20 wala
                if(five >=1 && ten>=1){
                    five--;
                    ten--;
                }
                else if(five>=3){
                    five=five-3;
                }
                else {
                    return false;
                }
            }
        }
        return true;
    }
}