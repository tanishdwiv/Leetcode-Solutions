class Solution {
    public int maxTaskAssign(int[] tasks, int[] workers, int pills, int strength) {
        Arrays.sort(tasks);
        Arrays.sort(workers);

        int taskcount=tasks.length;
        int workerscount=workers.length;

        int start=0;int end=Math.min(taskcount,workerscount);
        while(start<end){
            int mid=(start+end+1)/2;
            if(check(tasks,  workers,  pills, strength,mid)){
                start=mid;//agar true hai toh aage ke check kro
            }
            else{
                 end=mid-1;
            }
        }
        return start;
    }

    boolean check(int[] tasks, int[] workers, int pills, int strength,int mid){
        Deque<Integer> queue=new ArrayDeque<>();
        int taskindex=0;
        int remainingpills=pills;
        int workercount=workers.length;
         for (int workerIdx = workercount - mid; workerIdx < workercount; ++workerIdx) {
            // with or without a pill ,add tasks to queue
            while (taskindex < mid && tasks[taskindex] <= workers[workerIdx] + strength) {
                queue.offer(tasks[taskindex++]);
            }
            if(queue.isEmpty()){
            return false;
            }
            
            if (queue.peekFirst() <= workers[workerIdx]) {
                queue.pollFirst(); 
            } else if (remainingpills > 0) {
                queue.pollLast();  // task with pill
                --remainingpills;
            } else {
                return false; // No pill and strength can do the task
            }
    }
    return true;
}
}