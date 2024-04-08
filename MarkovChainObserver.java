public class MarkovChainObserver {
    public void notify(MarkovChainEvent event) {
        System.out.print(event.toString());
    }
}