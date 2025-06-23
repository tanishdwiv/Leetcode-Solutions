class Solution {
    public int numRescueBoats(int[] people, int limit) {

        Arrays.sort(people);

        int boatcount = 0; 

        int lightweight = 0; 
        int heavyweight = people.length - 1; 

        while (lightweight <= heavyweight) {
            //  If the lightest + heaviest can share a boat:
            if (people[lightweight] + people[heavyweight] <= limit) {
                lightweight++; // Move light pointer (used person)
            }

            //  the heavier person always takes a boat:
            heavyweight--; // Move heavy pointer
            boatcount++;   // One boat is used
        }

        return boatcount; 
    }
}
