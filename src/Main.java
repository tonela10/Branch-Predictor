import beans.tasks.BranchHistory;
import beans.tasks.FileReaderUtil;
import beans.tasks.Predictor;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Main {

    private static final int SIZE = 10;

    public static void main(String[] args) {
        String traceFilePath = "docs/gcc-10K.txt";
        FileReaderUtil fileReaderUtil = new FileReaderUtil(traceFilePath);
        BranchHistory branchHistory = new BranchHistory(SIZE);
        Predictor predictor = new Predictor();

        /* Another possible implementation instead of use the readFile class and method
        Files.readAllLines(Paths.get(traceFilePath)).stream()
                .filter(l -> !l.endsWith("T"))
                        .forEach(l -> System.out.println(l));

                        ...

                        //I am learning about functional programming :)
*/

    // 1-bit predictor
        fileReaderUtil.readFile((branchOutcome) -> {
            boolean prediction = predictor.oneBitPredict(branchHistory);

            String result = "Prediction: " + (prediction ? "Taken" : "Not Taken") +
                    ", Actual: " + (branchOutcome ? "Taken" : "Not Taken") + "\n";

            System.out.println(result);

            // Write the result
            try (BufferedWriter writer = new BufferedWriter(new FileWriter("./docs/trace-1-bit.txt", true))) {
                writer.write(result);
            } catch (IOException e) {
                e.printStackTrace();
            }

            // update the history
            predictor.update(branchHistory, branchOutcome);
        });

        // 2-bit predictor
        fileReaderUtil.readFile((branchOutcome) -> {
            boolean prediction = predictor.twoBitPredict(branchHistory);

            String result = "Prediction: " + (prediction ? "Taken" : "Not Taken") +
                    ", Actual: " + (branchOutcome ? "Taken" : "Not Taken") + "\n";

            System.out.println(result);

            try (BufferedWriter writer = new BufferedWriter(new FileWriter("./docs/trace-2-bit.txt", true))) {
                writer.write(result);
            } catch (IOException e) {
                e.printStackTrace();
            }

            // update the history of States
            predictor.updateStates(branchHistory, branchOutcome);
        });
    }
}
