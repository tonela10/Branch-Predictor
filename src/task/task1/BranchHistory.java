package task.task1;

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
            history.removeFirst();  // Eliminar el primer elemento si excede el tamaño máximo
        }
        history.add(outcome);
    }

    public void addState(States outcome) {
        if (historyState.size() >= maxSize) {
            historyState.removeFirst();  // Eliminar el primer elemento si excede el tamaño máximo
        }
        historyState.add(outcome);
    }

    public LinkedList<Boolean> getHistory() {
        return history;  // Devuelve la lista original en lugar de una copia
    }

    public LinkedList<States> getHistoryStates() {
        return historyState;  // Devuelve la lista original en lugar de una copia
    }
}
