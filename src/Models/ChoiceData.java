package Models;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ChoiceData {
    private final List<Choice> choices;
    private int choiceTotal = 0;

    public ChoiceData() {
        choices = new ArrayList<>();
    }

    public void addChoice(Choice choice) {
        choices.add(choice);
        choiceTotal++;
    }

    public void removeChoice(Choice choice) {
        choices.remove(choice);
        choiceTotal--;
    }

    public List<Choice> getChoices() {
        return choices;
    }

    public int getChoiceTotal() {
        return choiceTotal;
    }
}
