import task.task1.BranchHistory;
import task.task1.FileReaderUtil;
import task.task1.Predictor;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Main {

    private static final int SIZE = 10;

    public static void main(String[] args) {
        String traceFilePath = "docs/gcc-8M.txt";
        FileReaderUtil fileReaderUtil = new FileReaderUtil(traceFilePath);
        BranchHistory branchHistory = new BranchHistory(SIZE);
        Predictor predictor = new Predictor();

        fileReaderUtil.readFile((branchOutcome) -> {
            // Usar predicción de 2 bits
            boolean prediction = predictor.twoBitPredict(branchHistory);

            // Formatear el resultado para guardar en el archivo
            String result = "Prediction: " + (prediction ? "Taken" : "Not Taken") +
                    ", Actual: " + (branchOutcome ? "Taken" : "Not Taken") + "\n";

            System.out.println(result);

            // Escribir el resultado en el archivo trace.txt
            try (BufferedWriter writer = new BufferedWriter(new FileWriter("./docs/trace.txt", true))) {
                writer.write(result);
            } catch (IOException e) {
                e.printStackTrace();
            }

            // Actualizar los estados del predictor
            predictor.updateStates(branchHistory, branchOutcome);
        });
    }
}
