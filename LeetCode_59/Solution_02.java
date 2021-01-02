

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class Solution_02 {

    static class MaxQueue {

        public static Queue<Integer> queue;
        public static Deque<Integer> deque;

        public MaxQueue() {

            queue = new LinkedList<>();
            deque = new LinkedList<>();


        }

        public int max_value() {

            if(queue.isEmpty()){
                return -1;
            }

            return deque.peek();

        }

        public void push_back(int value) {

            queue.add(value);

            while((!deque.isEmpty()) && (deque.getLast() < value)){

                deque.pollLast();
            }

            deque.addLast(value);
        }

        public int pop_front() {

            if(queue.isEmpty()){
                return -1;
            }

            int tmpValue = queue.poll();
            if(tmpValue == deque.getFirst()){
                deque.pollFirst();
            }

            return tmpValue;
        }
    }


    public static void main(String[] args) {

        MaxQueue obj = new MaxQueue();

        obj.pop_front();

        obj.pop_front();
        System.out.println("------");
        obj.push_back(15);



        System.out.println(obj.max_value());

        obj.push_back(9);

        obj.max_value();



    }




}
