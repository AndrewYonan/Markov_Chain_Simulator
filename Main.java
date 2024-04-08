import java.util.Scanner;
import java.lang.Math;
import java.lang.NumberFormatException;


class Main {
    public static void main(String[] args) {

        // int MAX_STATES = 10;
        // int stateCount;
        // double[][] transitionMatrixData = new double[MAX_STATES][MAX_STATES];
        // String[] states;
        // Scanner scanner = new Scanner(System.in);

        // stateCount = InputHandler.getStateCountFromUser(scanner, MAX_STATES);
        // states = InputHandler.getStatesFromUser(scanner, stateCount);
        // transitionMatrixData = InputHandler.getTransitionMatrixDataFromUser(scanner, stateCount);
        // scanner.close();

        TransitionMatrixBuilder transitionMatrixBuilder = new TransitionMatrixBuilder();
        transitionMatrixBuilder.useExamplePreset10x10();

        TransitionMatrix TM = transitionMatrixBuilder.build();
        MarkovChain markovChain = new MarkovChain(TM);
        MarkovChainObserver markovChainDisplay = new MarkovChainObserver();
        MarkovChainObservable markovChainObservableInterface = new MarkovChainObservable();
        
        markovChainObservableInterface.addObserver(markovChainDisplay);
        markovChain.attachObservableInterface(markovChainObservableInterface);
        markovChain.setInitialState();
        markovChain.printTransitionMatrix();

        int MAX_ITERATIONS = 10000;
        Iterator<String> markovChainIterator = markovChain.createIterator(MAX_ITERATIONS);
        while (markovChainIterator.hasNext()) markovChainIterator.next();
    }
}