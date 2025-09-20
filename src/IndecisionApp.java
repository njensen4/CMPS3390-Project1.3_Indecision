import Controllers.IndecisionController;
import Models.ChoiceData;
import Views.IndecisionGUI;

public class IndecisionApp {
    static void main(String[] args) {
        IndecisionGUI view = new IndecisionGUI();
        ChoiceData model = new ChoiceData();
        new IndecisionController(model, view);

        view.setVisible(true);
        view.setLocationRelativeTo(null);
    }
}
