public class MarkovStateChangeEvent implements MarkovChainEvent {
    private String from;
    private String to;
    private int time;
    private int printWrap = 5;
    private int displayClampTime = 200;
    private String arrow = " ---> ";
    public MarkovStateChangeEvent(int time_, String from_, String to_) {
        from = from_;
        to = to_;
        time = time_;
    }
    public String toString() {
        if (time == 0) return (from + arrow + to);
        if (time == displayClampTime) return "\n.......\n.......\n.......\n";
        if (time > displayClampTime) return "";
        return (time % printWrap == 0) ? ("\n" + arrow + to) : (arrow + to); 
    }
}