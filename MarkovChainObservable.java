import java.util.ArrayList;
import java.util.List;

public class MarkovChainObservable {
    private List<MarkovChainObserver> markovChainObservers;
    public MarkovChainObservable() {
        markovChainObservers = new ArrayList<>();
    }
    public void addObserver(MarkovChainObserver markovChainObserver) {
        markovChainObservers.add(markovChainObserver);
    }
    public void notifyObservers(MarkovChainEvent event) {
        for (MarkovChainObserver observer : markovChainObservers) {
            observer.notify(event);
        }
    }
    public void notifyStateChange(int time, String from, String to) {
        notifyObservers(new MarkovStateChangeEvent(time, from, to));
    }
    public void notifyEndChain(int time) {
        notifyObservers(new MarkovEndChainEvent(time));
    }
}