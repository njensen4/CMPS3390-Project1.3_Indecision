package Models;

public class Choice {
    private final String choiceName;
    private final int choiceWeight;
    private int timesChosen = 0;

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

    public int getTimesChosen() {
        return timesChosen;
    }

    public void incrementTimesChosen() {
        timesChosen++;
    }
}
