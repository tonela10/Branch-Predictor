package beans.tasks;

public class Predictor {
    private boolean initialPrediction = true;

    public boolean oneBitPredict(BranchHistory history) {
        if (history.getHistory().isEmpty()) {
            return initialPrediction;
        }
        return history.getHistory().getLast();
    }

    public boolean twoBitPredict(BranchHistory history) {
        if (history.getHistoryStates().isEmpty()) {
            return States.getInitialState().getValue();
        }

        States lastState = history.getHistoryStates().getLast();
        System.out.println("Estado:" + lastState);
        return lastState.getValue();
    }

    public void update(BranchHistory history, boolean actualOutcome) {

        history.add(actualOutcome);
    }

    public void updateStates(BranchHistory history, boolean actualOutcome) {
        if (history.getHistoryStates().isEmpty()) {
            history.addState(States.getInitialState());
            return;
        }
        States lastState = history.getHistoryStates().getLast();

        // Probably was better do a switch case O_o
        if (actualOutcome) {
            if (lastState == States.WEAKLY_TAKEN) {
                history.addState(States.STRONGLY_TAKEN);
            } else if (lastState == States.WEAKLY_NOT_TAKEN) {
                history.addState(States.WEAKLY_TAKEN);
            }
        } else {
            if (lastState == States.STRONGLY_TAKEN) {
                history.addState(States.WEAKLY_TAKEN);
            } else if (lastState == States.WEAKLY_TAKEN) {
                history.addState(States.STRONGLY_NOT_TAKEN);
            } else if (lastState == States.WEAKLY_NOT_TAKEN) {
                history.addState(States.STRONGLY_TAKEN);
            } else if (lastState == States.STRONGLY_NOT_TAKEN) {
                history.addState(States.WEAKLY_NOT_TAKEN);
            }
        }
    }
}
