import java.util.Scanner;

public class InputHandler {
    public static int getStateCountFromUser(Scanner scanner, int MAX_STATES) {
        String line;
        int states = 0;
        while (states < 1 || states > MAX_STATES) {
            System.out.println("Enter number of states (MAX: " + MAX_STATES + " states):");
            line = scanner.nextLine();
            if (line.length() > (int)Math.log10(MAX_STATES) + 1) {
                states = -1;
            }
            try {states = Integer.parseInt(line);}
            catch (NumberFormatException E) {
                states = -1;
            }
            if (states < 1 || states > MAX_STATES) {
                System.out.println("Please enter an integer between 1 and " + MAX_STATES);
            }
        }
        System.out.println("STATES: " + states);
        return states;
    }
    public static String[] getStatesFromUser(Scanner scanner, int stateCount) {
        String line = "";
        String[] states = {"A"};
        boolean inputValid = false;
        while (!inputValid) {
            System.out.println("Input " + stateCount + " space-separated states:");
            line = scanner.nextLine();

            states = line.split(" ");
            if (states.length != stateCount) {
                inputValid = false;
            }
            else {
                inputValid = true;
            }
        }
        System.out.println("input states : " + line);
        return states;
    }
    public static double[][] getTransitionMatrixDataFromUser(Scanner scanner, int states) {
        String line;
        int transitionMatrixRow = 1;
        double[][] transitionMatrixData = new double[states][states];
        String[] probabilityInputs = new String[states];

        while (transitionMatrixRow <= states) {
            System.out.println("Input row " + transitionMatrixRow + " of transition matrix: (" + states + " space-separated probabilities)");

            boolean inputValid = false;
            double rowSumProbability = 0;
            double errBound = 0.001;

            while (!inputValid) {
                line = scanner.nextLine();
                probabilityInputs = line.split(" ");

                if (probabilityInputs.length != states) {
                    inputValid = false;
                    System.out.println("Please enter " + states + " space-separated values");
                    continue;
                }
                else {
                    inputValid = true;
                }

                for (int j = 0; j < states; ++j) { 
                    try {
                        double probability = Double.parseDouble(probabilityInputs[j]);
                        transitionMatrixData[transitionMatrixRow-1][j] = probability;
                    }
                    catch (NumberFormatException E) {
                        System.out.println("Must enter value between 0 and 1");
                        inputValid = false;
                        break;
                    }
                }

                for (int j = 0; j < states; ++j) {
                    rowSumProbability += Double.parseDouble(probabilityInputs[j]);
                }
            
                if (rowSumProbability < 1 - errBound || rowSumProbability > 1 + errBound) {
                    System.out.println("Sum of probabilities must be equal to 1\nPlease re-enter probabilities for row " + transitionMatrixRow + ":");
                    rowSumProbability = 0;
                    inputValid = false;
                }
            }
            transitionMatrixRow++;
        }
        return transitionMatrixData;
    }
}