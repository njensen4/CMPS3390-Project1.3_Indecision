package Views;

import Models.Choice;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class IndecisionGUI extends JFrame {
    private JPanel panel1;
    private JList<Choice> listChoices;
    private JButton buttonMakeChoice;
    private JLabel labelOption;
    private JTextField inputChoice;
    private JButton buttonAddChoice;
    private JButton buttonRemoveChoice;

    DefaultListModel<Choice> choiceListData;

    public IndecisionGUI() {
        this.setContentPane(panel1);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(800, 400);
        this.setTitle("Indecision Machine");

        choiceListData = new DefaultListModel<>();
        listChoices.setModel(choiceListData);
    }

    public void setAddChoiceListener(ActionListener listener) {
        buttonAddChoice.addActionListener(listener);
    }

    public void setRemoveChoiceListener(ActionListener listener) {
        buttonRemoveChoice.addActionListener(listener);
    }

    public String getChoice() {
        return inputChoice.getText();
    }

    public Choice getSelectedChoice() {
        return listChoices.getSelectedValue();
    }

    public void addChoice(Choice choice) {
        choiceListData.addElement(choice);
    }

    public void removeChoice(Choice choice) {
        choiceListData.removeElement(choice);
    }

    public void clearInput() {
        inputChoice.setText("");
    }

    public void showError(String error) {
        JOptionPane.showMessageDialog(null, error);
    }
}
