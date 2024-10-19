package task.task1;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.function.Consumer;

public class FileReaderUtil {
    private final String filePath;

    public FileReaderUtil(String filePath) {

        this.filePath = filePath;
    }

    public void readFile(Consumer<Boolean> outcomeConsumer) {

        //try-with-resources make that the resorces used, in this case BufferReader are auto close at the end of the try
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                outcomeConsumer.accept(line.trim().endsWith("T"));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }}
