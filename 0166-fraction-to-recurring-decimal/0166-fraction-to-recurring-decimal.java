class Solution {
    public String fractionToDecimal(int numerator, int denominator) {
        
        if(numerator==0){
            return "0";
        }
        StringBuilder answer=new StringBuilder();
        boolean sign=(numerator<0) ^ (denominator<0) ;
        if(sign){
            answer.append("-");
        }

        long num=Math.abs((long) numerator);
        long deno=Math.abs((long) denominator);
        long remainder=num % deno *10;

        answer.append(num/deno);
        if(remainder !=0){
            answer.append(".");
        }

        HashMap<Long,Integer> map=new HashMap<Long,Integer>();
        while(remainder!=0){
            if(map.containsKey(remainder)){
                answer.insert(map.get(remainder),"(");
                answer.append(")");
                break;
            }
            map.put(remainder,answer.length());
            answer.append(remainder/deno);
            remainder=remainder%deno *10;
        }
        return answer.toString();
    }
}