import task.task1.BranchHistory;
import task.task1.FileReaderUtil;
import task.task1.Predictor;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;


public class Main {

private static final int SIZE = 10;

    public static void main(String[] args) {
        String traceFilePath = "docs/gcc-10K.txt";
        FileReaderUtil fileReaderUtil = new FileReaderUtil(traceFilePath);
        BranchHistory branchHistory = new BranchHistory(SIZE);  // History size of 10
        Predictor predictor = new Predictor();

        fileReaderUtil.readFile((branchOutcome) -> {
            boolean prediction = predictor.predict(branchHistory);

            String result = "Prediction: " + (prediction ? "Taken" : "Not Taken") +
                    ", Actual: " + (branchOutcome ? "Taken" : "Not Taken") + "\n";

            System.out.println(result);

            try (BufferedWriter writer = new BufferedWriter(new FileWriter("./docs/trace.txt", true))) {
                writer.write(result);
            } catch (IOException e) {
                e.printStackTrace();
            }

            predictor.update(branchHistory, branchOutcome);
        });
    }
}
