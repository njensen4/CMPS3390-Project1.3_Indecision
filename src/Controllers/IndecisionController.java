package Controllers;

import Models.Choice;
import Models.ChoiceData;
import Views.IndecisionGUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class IndecisionController {
    public IndecisionController(ChoiceData model, IndecisionGUI view) {
        view.setAddChoiceListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String enteredChoice = view.getChoice();
                String enteredWeight = view.getWeight();

                if (enteredChoice.isBlank()) {
                    view.showError("Please enter a choice.");
                    return;
                }

                if (enteredWeight.isBlank()) {
                    enteredWeight = "1"; // Default weight
                }

                Choice choice = new Choice(enteredChoice, Integer.parseInt(enteredWeight));

                model.addChoice(choice);
                view.addChoice(choice);
                view.clearInputs();
            }
        });

        view.setRemoveChoiceListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Choice choice = view.getSelectedChoice();

                if (choice == null) {
                    view.showError("Please select a choice to remove.");
                }

                model.removeChoice(choice);
                view.removeChoice(choice);
            }
        });

        view.setMakeChoiceListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Random rand = new Random();
                String choiceDecided = "";
                int weightTotal = 0;
                int cumulativeWeight = 0;

                for(Choice choice : model.getChoices()) {
                    weightTotal += choice.getChoiceWeight();
                }
                int randomChoice = rand.nextInt(weightTotal);

                for(int i = 0; i < model.getChoiceTotal(); i++) {
                    cumulativeWeight += model.getChoices().get(i).getChoiceWeight();
                    if (randomChoice <  cumulativeWeight) {
                        choiceDecided = model.getChoices().get(i).toString();
                        break;
                    }
                }
                view.showError(String.format("Your should:\n %s", choiceDecided));
            }
        });
    }
}
