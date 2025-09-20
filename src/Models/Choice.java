package Models;

public class Choice {
    private final String choiceName;

    public Choice(String inputChoice) {
        this.choiceName = inputChoice;
    }

    public String toString() {

        return String.format("%s", choiceName);
    }
}
