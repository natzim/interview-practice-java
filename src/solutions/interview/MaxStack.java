package solutions.interview;

import java.util.ArrayList;
import java.util.List;

public class MaxStack {
    private final List<Integer> stack;
    private final List<Integer> maxes;

    public MaxStack() {
        this.stack = new ArrayList<>();
        this.maxes = new ArrayList<>();
    }

    public void push(Integer ... values) {
        for (Integer value : values) {
            stack.add(value);

            if (maxes.size() > 0 && maxes.get(maxes.size() - 1) < value) {
                maxes.add(value);
            } else {
                maxes.add(maxes.size() - 1);
            }
        }
    }

    public Integer pop() {
        if (stack.size() == 0) {
            return null;
        }

        Integer output = stack.get(stack.size() - 1);
        stack.remove(stack.size() - 1);
        maxes.remove(maxes.size() - 1);

        return output;
    }

    public Integer max() {
        if (maxes.size() == 0) {
            return null;
        }

        return maxes.get(maxes.size() -1);
    }
}
