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

                if (enteredChoice.isBlank()) {
                    view.showError("Please enter a choice.");
                    return;
                }

                Choice choice = new Choice(enteredChoice);

                model.addChoice(choice);
                view.addChoice(choice);
                view.clearInput();
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
                int choiceTotal = model.getChoiceTotal();
                int randomChoice = rand.nextInt(choiceTotal);
                String choiceDecided = view.getRandomizedChoice(randomChoice);
                view.showError(String.format("Your should:\n %s", choiceDecided));
            }
        });
    }
}
