class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        
        int[] res=new int[m+n];
        int i=0;
        int j=0;
        int index=0;
        while(i<m && j<n){
    if(nums1[i]<nums2[j]){
        res[index]=nums1[i];
        index++;
        i++;
    }
    else{
        res[index]=nums2[j];
        index++;
        j++;
    }
        }

        while(i<m){
            res[index]=nums1[i];
            index++;
            i++;
        }
          while(j<n){
            res[index]=nums2[j];
            index++;
            j++;
        }
        for(int k=0;k<m+n;k++){
            nums1[k]=res[k];
        }
        
    }
}