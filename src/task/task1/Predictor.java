package task.task1;

public class Predictor {
    private boolean initialPrediction = true;  // Default initial prediction, hardcodeado que da gusto

    public boolean predict(BranchHistory history) {
        if (history.getHistory().isEmpty()) {
            return initialPrediction; // Si no hay historial, usamos la predicción inicial
        }

        //Takes last result of the history.
        return history.getHistory().get(history.getHistory().size() - 1);
    }


    public void update(BranchHistory history, boolean actualOutcome) {

        history.add(actualOutcome);
    }
}