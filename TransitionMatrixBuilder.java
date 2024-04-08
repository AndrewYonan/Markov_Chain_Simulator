public class TransitionMatrixBuilder {
    private TransitionMatrix transitionMatrix;
    public TransitionMatrixBuilder() {
        transitionMatrix = null;
    }
    public void initialize(double probabilityData[][], String[] states, int size) {
        transitionMatrix = new TransitionMatrix(probabilityData, states, size);
    }
    public void useExamplePreset2x2() {
        double[][] probabilityData = {{0.95, 0.05},
                                      {0.05, 0.95}};
        int size = 2;
        String[] states = {"Off", "On"};
        transitionMatrix = new TransitionMatrix(probabilityData, states, size);
    }
    public void useExamplePreset3x3() {
        double[][] probabilityData = {{0.5, 0.1, 0.4},
                                      {0.1, 0.6, 0.3},
                                      {0.5, 0.1, 0.4}};
        int size = 3;
        String[] states = {"Happy", "Sad", "Hungry"};
        transitionMatrix = new TransitionMatrix(probabilityData, states, size);
    }
    public void useExamplePreset4x4() {
        double[][] probabilityData = {{0, 1, 0, 0},
                                      {0, 0, 1, 0},
                                      {0, 0, 0, 1},
                                      {1, 0, 0, 0},};
        int size = 4;
        String[] states = {"January", "February", "March", "April"};
        transitionMatrix = new TransitionMatrix(probabilityData, states, size);
    }
    public void useExamplePreset5x5() {
       double[][] probabilityData = {{0.1, 0.2, 0.3, 0.4, 0},
                                     {0.4, 0.3, 0.2, 0.1, 0},
                                     {0.1, 0.2, 0.3, 0.4, 0},
                                     {0.4, 0.3, 0.2, 0.1, 0},
                                     {0, 0.2, 0.3, 0.4, 0.1}};
        int size = 5;
        String[] states = {"Sunny", "Rainy", "Cloudy", "Thundery", "Earth-quakey"};
        transitionMatrix = new TransitionMatrix(probabilityData, states, size);
    }
    public void useExamplePreset10x10() {
        double[][] probabilityData = {{0.90, 0.10, 0, 0, 0, 0, 0, 0, 0, 0},
                                      {0.10, 0.89, 0.01, 0, 0, 0, 0, 0, 0, 0},
                                      {0, 0.05, 0.55, 0.6, 0, 0, 0, 0, 0, 0},
                                      {0, 0, 0, 0.9, 0.1, 0, 0, 0, 0, 0},
                                      {0, 0, 0, 0, 0.2, 0.8, 0, 0, 0, 0},
                                      {0, 0, 0, 0, 0, 0.2, 0.8, 0, 0, 0},
                                      {0, 0, 0, 0, 0, 0, 0.2, 0.8, 0, 0},
                                      {0.02, 0, 0, 0, 0, 0, 0, 0.9, 0.08, 0},
                                      {0, 0, 0, 0, 0, 0, 0, 0.49, 0.5, 0.01},
                                      {0, 0, 0, 0, 0, 0, 0, 0, 0, 1},};
        int size = 10;
        String[] states = {"Sleepy", "Thoughtful", "Ambitious", "Actionable", "Tired", "Melencholic", "Melodramatic", "Angry", "Vengeful", "Dead"};
        transitionMatrix = new TransitionMatrix(probabilityData, states, size);
    }
    public TransitionMatrix build() {
        return transitionMatrix;
    }
}