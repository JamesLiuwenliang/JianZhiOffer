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

        if(stack_Attach.size() ==0 ){
            while(stack_main.size() != 0 ){
                stack_Attach.push(stack_main.pop());
            }
        }

        if(stack_Attach.size()==0){
            return -1;
        }
        return stack_Attach.pop();

    }
}

/**
 * Your CQueue object will be instantiated and called as such:
 * CQueue obj = new CQueue();
 * obj.appendTail(value);
 * int param_2 = obj.deleteHead();
 */