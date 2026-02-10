class Solution {

    class Stack {
        int arr[];
        int top;
        int size;

        Stack(int n) {
            size = n;
            arr = new int[size];
            top = -1;
        }

        void push(int val) {
            arr[++top] = val;
        }

        void pop() {
            top--;
        }

        int peek() {
            return arr[top];
        }

        boolean isEmpty() {
            return top == -1;
        }
    }

    public boolean validateStackSequences(int[] pushed, int[] popped) {
        int n = pushed.length;
        Stack stack = new Stack(n);
        int j = 0;

        for (int i = 0; i < n; i++) {
            stack.push(pushed[i]);

            while (!stack.isEmpty() && stack.peek() == popped[j]) {
                stack.pop();
                j++;
            }
        }

        return stack.isEmpty();
    }
}