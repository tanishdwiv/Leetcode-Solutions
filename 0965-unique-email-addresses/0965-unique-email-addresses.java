class Solution {
    public int numUniqueEmails(String[] emails) {
        Set<String> set=new HashSet<>();
        for(String email:emails){
            String[] parts=email.split("@");
            if(parts.length!=2)
            continue;

            String local=parts[0];
            String domain=parts[1];

            //remove dot in local
            local=local.replace(".","");
            //remove everything after + in local
            int plus=local.indexOf("+");
            if(plus!=-1){
                local=local.substring(0,plus);

            }
            String cleanmail=local + "@" + domain;
            set.add(cleanmail);
        }
    
        return set.size();
    }
}