package A4_StackOfStrings;

import java.util.*;

public class StackOfStrings {

    private List<String> data;

    public StackOfStrings() {
        this.data = new ArrayList<>();
    }

    public void push(String item) {
        data.add(item);
    }

    public String pop() {
        return data.remove(data.size() - 1);
    }

    public String peek() {
        return data.get(data.size() - 1);
    }

    public boolean isEmpty() {
        return data.isEmpty();
    }
}
