package com.kyle.heap;

import java.util.Arrays;
import java.util.PriorityQueue;

//https://leetcode.com/problems/kth-largest-element-in-a-stream/
public class KthLargestElement {

    static class KthLargest {

        private PriorityQueue<Integer> heap;
        private int k;

        public KthLargest(int k, int[] nums) {
            this.k = k;
            heap = new PriorityQueue<>(k);
            Arrays.stream(nums).forEach(this::add);
        }

        public int add(int val) {

            heap.add(val);
            if (heap.size() > k)
                heap.poll();

            return heap.peek();
        }
    }

    public static void main(String[] args) {
        KthLargest solution = new KthLargest(3, new int[] {4, 5, 8, 2});
        System.out.println(solution.add(3));   // returns 4
        System.out.println(solution.add(5));   // returns 5
        System.out.println(solution.add(10));  // returns 5
        System.out.println(solution.add(9));   // returns 8
        System.out.println(solution.add(4));   // returns 8
    }

}
