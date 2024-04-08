public class TransitionMatrix {
    private int size;
    private String states[];
    private double probabilityData[][];
    private TransitionMatrixFormatter transitionMatrixFormatter;
    public TransitionMatrix(double probabilityData_[][], String[] states_, int size_) {
        states = states_;
        size = size_;
        probabilityData = probabilityData_;
        transitionMatrixFormatter = new TransitionMatrixFormatter(this);
    }
    public double get(int i, int j) {
        return probabilityData[i][j];
    }
    public int getSize() {
        return size;
    }
    public double[][] getProbabilityData() {
        return probabilityData;
    }
    public String[] getStates() {
        return states;
    }
    public void print() {
        transitionMatrixFormatter.printWithStates();
    }
} 