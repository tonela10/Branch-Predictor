# Branch Prediction Simulator

This Java program simulates branch prediction using both 1-bit and 2-bit predictors. It reads a trace file of branch outcomes, makes predictions, and logs the results to files. The simulator allows you to easily modify the trace file by changing the file path in the source code.

## Features

- **1-bit Predictor**: Keeps track of the last outcome of a branch and predicts that the next outcome will be the same.
- **2-bit Predictor**: Uses a finite state machine to allow two wrong predictions before it changes the prediction.
- **Customizable Input**: The file path of the trace can be modified in the `Main` class.

## Requirements

- **Java 21**: The program requires Java 21. If you don’t have it installed, you can download it from the [official Java website](https://www.oracle.com/java/technologies/javase-downloads.html).

## How to Run

1. Clone the repository or download the source code. The git repository does not allow big files so if you take this option
    you should have the files to process.
    ``git clone``
    ```bash
   git clone https://github.com/tonela10/Branch-Predictor.git
2. Ensure you have **Java 21** installed. You can check your version by running:
   ```bash
   java -version
