public class TransitionMatrixFormatter {
    private TransitionMatrix TM;
    private int initialSpacing = 5;
    private int verticalSpacing = 1;
    private int horizontalSpacing = 2;
    public TransitionMatrixFormatter(TransitionMatrix TM_) {
        TM = TM_;
    }
    private int getMaxCharacterLength(String[] states) {
        int max = 0;
        for (String s : states) {
            if (s.length() > max) {
                max = s.length();
            }
        }
        return max;
    }
    private int getMaxColumnCharacterLength(int column) {
        String states[] = TM.getStates();
        int max = states[column].length();
        for (int i = 0; i < TM.getSize(); ++i) {
            int charLen = Double.toString(TM.get(i, column)).length();
            if (charLen > max) {
                max = charLen;
            }
        }
        return max;
    }
    private String formatTitle(int size) {
        return "\n\nCHAIN has " + size + "x" + size + " TRANSITION MATRIX (\'-\' indicates 0 probability):\n";
    }
    private String formatMatrixRow(int row, int rowSize) {
        double[] rowData = TM.getProbabilityData()[row];
        String[] states = TM.getStates();
        int maxStateCharLength = getMaxCharacterLength(states);
        int matrixStart = maxStateCharLength + verticalSpacing;
        String res = "";
        res += (" ".repeat(initialSpacing) + states[row] + " ".repeat(matrixStart - states[row].length()) + " |");
        for (int i = 0; i < rowSize; ++i) {
            int maxColumCharLen = getMaxColumnCharacterLength(i);
            String elem = (rowData[i] == 0) ? "-" : Double.toString(rowData[i]);
            if (i == rowSize - 1) {
                res += (elem +  " ".repeat(maxColumCharLen - elem.length()));
            }
            else {
                res += (elem + " ".repeat(horizontalSpacing) + " ".repeat(maxColumCharLen - elem.length()));
            }
        }
        return res;
    }
    private int getMaxRowLen() {
        int maxRowLen = 0;
        for (int i = 0; i < TM.getSize(); ++i) {
            String row = formatMatrixRow(i, TM.getSize());
            if (row.length() > maxRowLen) {
                maxRowLen = row.length();
            }
        }
        return maxRowLen;
    }
    private String formatColumnStates() {
        String res = "";
        String[] states = TM.getStates();
        int maxStateCharLength = getMaxCharacterLength(states);
        int matrixStart = maxStateCharLength + verticalSpacing;
        res += (" ".repeat(matrixStart) + " ".repeat(initialSpacing + 2));
        for (int i = 0; i < TM.getSize(); ++i) {
            res += (states[i] + " ".repeat(getMaxColumnCharacterLength(i) - states[i].length()) + " ".repeat(horizontalSpacing));
        }
        return res + "\n".repeat(verticalSpacing);
    }
    private String formatMatrix() {
        String res = "";
        String[] states = TM.getStates();
        int maxStateCharLength = getMaxCharacterLength(states);
        int maxRowLen = getMaxRowLen();
        for (int i = 0; i < TM.getSize(); ++i) {
            String row = formatMatrixRow(i, TM.getSize());
            res += (row + " ".repeat(maxRowLen - row.length()) + "|");
            res += "\n";
            if (i == TM.getSize()-1) break;
            for (int j = 0; j < verticalSpacing; ++j) {
                String rowData =  " ".repeat(initialSpacing) + " ".repeat(maxStateCharLength) + " ".repeat(verticalSpacing) + " |";
                res += rowData;
                res += (" ".repeat(maxRowLen - rowData.length()) + "|" + "\n");
            }
        }
        return formatColumnStates() + res;
    }
    public void printWithStates() {
        System.out.println(formatTitle(TM.getSize()));
        System.out.println(formatMatrix());
    }   
}
