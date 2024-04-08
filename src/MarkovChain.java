import java.lang.Math;

public class MarkovChain {
    private TransitionMatrix transitionMatrix;
    private String currentState;
    private int currentTime;
    private int maxIterations;
    private MarkovChainObservable observableInterface;
    public MarkovChain(TransitionMatrix transitionMatrix_) {
        transitionMatrix = transitionMatrix_;
        currentState = getInitialState();
        currentTime = 0;
        maxIterations = 0;
    }
    public void attachObservableInterface(MarkovChainObservable observableInterface_) {
        observableInterface = observableInterface_;
    }
    public Iterator<String> createIterator(int maxIterations_) {
        maxIterations = maxIterations_;
        return new MarkovChainIterator(this, maxIterations_);
    }
    public String getInitialState() {
        return transitionMatrix.getStates()[0];
    }
    public void setInitialState() {
        currentState = getInitialState();
    }
    public void printTransitionMatrix() {
        transitionMatrix.print();
    }
    public String step() {
        String prevState = currentState;
        currentState = calculateNextState(currentState);
        notifyStateChange(currentTime, prevState, currentState);
        currentTime++;
        if (currentTime == maxIterations) notifyChainEnd(currentTime);
        return currentState;
    }
    private int rowOf(String currentState) {
        for (int i = 0; i < transitionMatrix.getSize(); ++i) {
            String state = transitionMatrix.getStates()[i];
            if (state == currentState) return i;
        }
        return -1;
    }
    private boolean inRange(double d, double min, double max) {
        return d >= min && d <= max;
    }
    public String calculateNextState(String currentState) {
        String nextState = "ABCDEFG";
        int size = transitionMatrix.getSize();
        int row = rowOf(currentState);
        int column = 0;
        double rand = Math.random();
        double min = 0;
        double max = 0;
        while (column < size) {
            max += transitionMatrix.get(row, column);
            if (inRange(rand, min, max)) {
                nextState = transitionMatrix.getStates()[column];
                break;
            }
            min = max;
            column++;
        }
        return nextState;
    }
    public void notifyStateChange(int currentTime, String prevState, String currentState) {
        if (observableInterface != null ) {
            observableInterface.notifyStateChange(currentTime, prevState, currentState);
        }
    }
    public void notifyChainEnd(int time) {
        if (observableInterface != null) {
            observableInterface.notifyEndChain(time);
        }
    }
}