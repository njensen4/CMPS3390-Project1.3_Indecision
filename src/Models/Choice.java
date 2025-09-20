package Models;

public class Choice {
    private final String choiceName;
    private final int choiceWeight;

    public Choice(String inputChoice, int inputWeight) {
        this.choiceName = inputChoice;
        this.choiceWeight = inputWeight;
    }

    public String toString() {
        return String.format("%s (%d)", choiceName, choiceWeight);
    }

    public int getChoiceWeight() {
        return choiceWeight;
    }
}
