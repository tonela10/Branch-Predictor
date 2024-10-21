package beans.tasks;

import java.util.LinkedList;

public class BranchHistory {
    private final LinkedList<Boolean> history;
    private final LinkedList<States> historyState;
    private final int maxSize;

    public BranchHistory(int size) {
        this.history = new LinkedList<>();
        this.maxSize = size;
        this.historyState = new LinkedList<>();
        this.historyState.add(States.getInitialState());
    }

    public void add(boolean outcome) {
        if (history.size() >= maxSize) {
            history.removeFirst();  // Delete the first in case is full
        }
        history.add(outcome);
    }

    public void addState(States outcome) {
        if (historyState.size() >= maxSize) {
            historyState.removeFirst();
        }
        historyState.add(outcome);
    }

    public LinkedList<Boolean> getHistory() {
        return history;
    }

    public LinkedList<States> getHistoryStates() {
        return historyState;
    }
}
