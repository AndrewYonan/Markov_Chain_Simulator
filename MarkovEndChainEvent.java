public class MarkovEndChainEvent implements MarkovChainEvent {
    private int time;
    public MarkovEndChainEvent(int time_) {
        time = time_;
    }
    public String toString() {
        return "\nCHAIN ending... (" + time + " iterations completed)\n";
    }
}