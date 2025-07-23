class Solution {
    public int[] rearrangeBarcodes(int[] barcodes) {
        int[] frequencies=new int[10001];
        for (int barcode : barcodes) {
          ++frequencies[barcode];
}

PriorityQueue<Integer> maxheap=new PriorityQueue<>((barcode1,barcode2)->frequencies[barcode2]-frequencies[barcode1]);
for(int barcode=1;barcode<=10000;barcode++){
    if(frequencies[barcode]!=0){
        maxheap.offer(barcode);
    }
}
int index=0;
while (!maxheap.isEmpty()) {
    int barcode = maxheap.poll();
    int freq = frequencies[barcode];

    while (freq-- != 0) {
        barcodes[index] = barcode;
        index += 2;

        if (index >= barcodes.length) {
            index = 1; 
        }
    }
    
}
return barcodes;

}
}