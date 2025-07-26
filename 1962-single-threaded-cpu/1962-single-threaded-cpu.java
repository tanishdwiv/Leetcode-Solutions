class Solution {
    class Task{
        int enqueuetime;
        int processingtime;
        int index;
        Task(int enqueuetime,int processingtime,int index){
            this.enqueuetime=enqueuetime;
            this.processingtime=processingtime;
            this.index=index;
        }
    }
    public int[] getOrder(int[][] tasks) {
        //now i will create the array and store its all 3 constraints
        Task[] sortedtask=new Task[tasks.length];
        for(int i=0;i<tasks.length;i++){
            sortedtask[i]=new Task(tasks[i][0],tasks[i][1],i);
        }
        //will sort the array on the basis of enqueue time 
        Arrays.sort(sortedtask,(a,b)->a.enqueuetime-b.enqueuetime);

        //now making min heap because it will give me the task with minimum process time
        //we will also sort minheap on basis of processing time and if it is same we will check its index 
        PriorityQueue<Task> minheap=new PriorityQueue<>((a,b)->{
            if(a.processingtime != b.processingtime){
                return a.processingtime-b.processingtime;
            }
            else{
                return a.index-b.index;
            }
        });
        int currenttime=0;//for calculating time with adding processingtime of task
        int[] answer=new int[tasks.length];
        int answerindex=0;
        int taskindex=0;
        //we will run our loop until all tasks are done and no element left in queue
        while(taskindex<tasks.length || !minheap.isEmpty()){
            //if my queue is empty and cpu is idle we will proceed to the new taskindex that is 1st one in the sortedtask list with enqueue time
            if(minheap.isEmpty()){
                currenttime=Math.max(currenttime,sortedtask[taskindex].enqueuetime);
            }
            //now add all task in the minheap whose enqueue time is less than currenttime
            while(taskindex<tasks.length && sortedtask[taskindex].enqueuetime<=currenttime){
                minheap.offer(sortedtask[taskindex]);
                taskindex++;
            }

            //now if my queue already has tasks than poll from the minheap this will give me task with minimum process time
            if(!minheap.isEmpty()){
                Task mytask=minheap.poll();
                //now put that index in our result as it will be processed by cpu now
                answer[answerindex++]=mytask.index;
                //now add the process time to currenttime
                currenttime+=mytask.processingtime;
            }
        }
        return answer;
        
    }
}