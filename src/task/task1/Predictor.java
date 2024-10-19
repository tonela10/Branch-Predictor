package task.task1;

import javax.swing.text.DefaultEditorKit;

import static task.task1.States.getInitialState;

public class Predictor {
    private boolean initialPrediction = true;

    public boolean oneBitPredict(BranchHistory history) {
        if (history.getHistory().isEmpty()) {
            return initialPrediction;
        }
        return history.getHistory().get(history.getHistory().size() - 1);  // Acceso al último elemento
    }

    public boolean twoBitPredict(BranchHistory history) {
        if (history.getHistoryStates().isEmpty()) {
            return States.getInitialState().getValue();
        }

        // Asegúrate de que haya al menos un estado antes de acceder al último
        States lastState = history.getHistoryStates().get(history.getHistoryStates().size() - 1);
        System.out.println("Estado:" + lastState);
        return lastState.getValue();
    }

    public void update(BranchHistory history, boolean actualOutcome) {

        history.add(actualOutcome);
    }

    public void updateStates(BranchHistory history, boolean actualOutcome) {
        // Asegúrate de que hay al menos un estado antes de acceder
        if (history.getHistoryStates().isEmpty()) {
            history.addState(States.getInitialState());
            return;
        }

        // Obtener el último estado
        States lastState = history.getHistoryStates().get(history.getHistoryStates().size() - 1);


        // Actualizar el estado según el resultado real
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
