class CQueue {

    Stack<Integer> stack_main ;
    Stack<Integer> stack_Attach ;

    public CQueue(){
        stack_main = new Stack();
        stack_Attach = new Stack<>();
    }

    public void appendTail(int value) {
        stack_main.push(value);
    }

    public int deleteHead() {
        if(stack_main.size() == 0) {
            return -1;
        }

        while(stack_main.size() !=1){
            stack_Attach.push(stack_main.pop());
        }

        int tmp = stack_main.pop();

        while(stack_Attach.size() != 0){
            stack_main.push(stack_Attach.pop());
        }



        return tmp;


    }

}

/**
 * Your CQueue object will be instantiated and called as such:
 * CQueue obj = new CQueue();
 * obj.appendTail(value);
 * int param_2 = obj.deleteHead();
 */