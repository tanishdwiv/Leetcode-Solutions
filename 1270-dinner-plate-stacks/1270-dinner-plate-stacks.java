class DinnerPlates {
int capacity;
List<Stack<Integer>> stacks ;
PriorityQueue<Integer> minheap; //i am taking this minheap beacause it will store my stack index of those which are empty and this is minheap so it will store index in sorted way so it will help us in pushing leftmost
    public DinnerPlates(int capacity) {
        
        this.capacity=capacity;
        this.stacks=new ArrayList<>();
        this.minheap=new PriorityQueue<>();
    }
    
    public void push(int val) {
        //first we will remove all the unused  indices from the heap that point to the stack that no longer exist
//         Let's imagine this scenario where capacity = 1:
// State: You push three items. Your stacks list has 3 stacks (at indices 0, 1, and 2).
// stacks: [[10], [20], [30]]
// available (heap): [] (all stacks are full)
// pop() is called: It pops 30 from stacks[2]. The stack at index 2 becomes empty. The pop() method then trims this empty stack from the list.
// stacks: [[10], [20]] (Size is now 2)
// available (heap): [2] (Because we popped from index 2, it's now considered available)
// The Mismatch: Your stacks list only has indices 0 and 1. But your available heap incorrectly claims that index 2 is a valid, open spot.
// The Cleanup Loop in Action: The next time you call push(), this code runs first:

//or there can be this also that in heap can contain an index which ia already filled to its capacity at last
// if(!minheap.isEmpty() && (minheap.peek()>=stacks.size() || stacks.get(minheap.peek()).size()==this.capacity)){
//     minheap.poll();
// }


while (!minheap.isEmpty()) {
            int idx = minheap.peek();
            
            // Condition 1: Is the index out of bounds? (Stack was removed by pop())
            if (idx >= stacks.size()) {
                minheap.poll();
                continue;
            }
            // Condition 2: Is the stack at this index already full?
            if (stacks.get(idx).size() == this.capacity) {
                minheap.poll();
                continue;
            }
            // If we reach here, the index is valid and points to a non-full stack.
            break;
        }
//if my all stacks are full thaan i will create new stack ,i will get to know this if my heap is empty beacause my heap stores the index of stacks which are not full
int index;
if(minheap.isEmpty()){
     index=stacks.size();
    stacks.add(new Stack<>());
}

//if my heap is not empty this means there are stack which are not full and we will pop out which will be my leftmost stack which is not filled with its capacity
else{
     index=minheap.poll();
}
//pushing my value to that stack
stacks.get(index).push(val);
//after pushing there can be possible that my stack capacity is still not full so we will now add it back to heap
      if(stacks.get(index).size()<this.capacity){
        minheap.offer(index);
      }  
    }
    
    public int pop() {
        
        //firstly we will remove empty stacks which will hep me in finding best rightmost
        while(!stacks.isEmpty() && stacks.get(stacks.size()-1).isEmpty()){
            stacks.remove(stacks.size()-1);
        }
       // if by chance my all stacks get removed
        if (stacks.isEmpty()) {
            return -1;
        }

        int index=stacks.size()-1;
        int value=stacks.get(index).pop();
        //now my stacks capacity has reduced so now i will add it to my heap
        minheap.add(index);
        return value;
    }
    
    public int popAtStack(int index) {
        
        //now in this we will check whether my stack at particular index is already emptied or index is out of bound
        if(index>=stacks.size() || stacks.get(index).isEmpty()){
            return -1;
        }
        int value=stacks.get(index).pop();
        //now add this index to our heap as it will be helpful in pushing value to empty stacks first
        minheap.add(index);
        return value;
            }
}

/**
 * Your DinnerPlates object will be instantiated and called as such:
 * DinnerPlates obj = new DinnerPlates(capacity);
 * obj.push(val);
 * int param_2 = obj.pop();
 * int param_3 = obj.popAtStack(index);
 */