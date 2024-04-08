public class MarkovChainIterator implements Iterator<String> {
    private String currentState;
    private int currentTimeStep;
    private int maxIterations;
    private MarkovChain markovChain;
    public MarkovChainIterator(MarkovChain markovChain_, int maxIterations_) {
        markovChain = markovChain_;
        maxIterations = maxIterations_;
        currentTimeStep = 0;
        currentState = markovChain.getInitialState();
        System.out.println("CHAIN beginning...");
    }
    public boolean hasNext() {
        return currentTimeStep < maxIterations;
    }
    public String next() {
        currentTimeStep++;
        return markovChain.step();
    }
}