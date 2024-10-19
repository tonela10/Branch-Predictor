package task.task1;

import java.util.LinkedList;

public class BranchHistory {
    private final LinkedList<Boolean> history;
    private final int maxSize;

    public BranchHistory(int size) {
        this.history = new LinkedList<>();
        this.maxSize = size;
    }

    public void add(boolean outcome) {
        if (history.size() >= maxSize) {
            history.removeFirst();
        }
        history.add(outcome);
    }
    public LinkedList<Boolean> getHistory() {
        return new LinkedList<>(history);
    }

}
