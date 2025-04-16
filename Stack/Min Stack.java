// Problem: Min Stack
// Link: https://leetcode.com/problems/min-stack/description/
// Approach: Stack

package Stack;
import java.util.*;

class MinStack {
    Stack<Long> stack;
    long min;

    public MinStack() {
        stack = new Stack<>();
        min = Integer.MAX_VALUE;
    }

    public void push(int val) {
        if (stack.isEmpty()) {
            min = val;
            stack.push((long) val);
        } else {
            if (val < min) {
                stack.push(2L * val - min);  // Store encoded value
                min = val;
            } else {
                stack.push((long) val);
            }
        }
    }

    public void pop() {
        if (stack.isEmpty()) return;

        long top = stack.pop();
        if (top < min) {  // Encoded value detected
            min = 2 * min - top;  // Restore previous min
        }
    }

    public int top() {
        if (stack.isEmpty()) return -1;

        long top = stack.peek();
        return (top < min) ? (int) min : (int) top;
    }

    public int getMin() {
        return (int) min;
    }
}
