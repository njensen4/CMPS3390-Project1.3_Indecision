package Controllers;

import Models.Choice;
import Models.ChoiceData;
import Views.IndecisionGUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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


            }
        });
    }
}
