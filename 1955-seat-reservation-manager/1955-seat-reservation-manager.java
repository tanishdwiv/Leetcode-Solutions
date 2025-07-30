class SeatManager {
    int number;
    PriorityQueue<Integer> minheap;

    public SeatManager(int n) {
        this.number=n;
        this.minheap=new PriorityQueue<>();
        for(int i=1;i<=this.number;i++){
            minheap.offer(i);
        }
    }
    
    public int reserve() {
       
        return minheap.poll();
    }
    
    public void unreserve(int seatNumber) {
        minheap.offer(seatNumber);
        
    }
}

/**
 * Your SeatManager object will be instantiated and called as such:
 * SeatManager obj = new SeatManager(n);
 * int param_1 = obj.reserve();
 * obj.unreserve(seatNumber);
 */