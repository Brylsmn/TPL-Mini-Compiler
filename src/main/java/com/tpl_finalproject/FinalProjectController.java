package com.tpl_finalproject;

import javafx.css.PseudoClass;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import java.net.URL;
import java.util.Arrays;
import java.util.List;
import java.util.ResourceBundle;

public class FinalProjectController implements Initializable {
    @FXML
    private Label resultText, codeTextArea;
    @FXML
    private TextArea textArea;
    @FXML
    private Button openFileButton, lexicalButton, syntaxButton, semanticButton, clearButton;

    public void initialize(URL url, ResourceBundle resourceBundle) {
        resultText.setText("Result: ");
        lexicalButton.setDisable(true);
        syntaxButton.setDisable(true);
        semanticButton.setDisable(true);
        clearButton.setDisable(true);
        textArea.setVisible(false);
    }
    @FXML
    protected void onOpenFileButtonClick() {
        textArea.setVisible(true);
        clearButton.setDisable(false);
        openFileButton.setDisable(true);
        lexicalButton.setDisable(false);
    }
    @FXML
    protected void onLexicalButtonClick() {
        String lexicalInput = textArea.getText();
        List<String> lexicalLines = Arrays.asList(lexicalInput.split("\\n"));
        if (FinalProjectMethods.areLinesLexicallyCorrect(lexicalLines)) {
            resultText.setText("Result: Lexical Analysis Phase Successful!");
            lexicalButton.setDisable(true);
            syntaxButton.setDisable(false);
            clearButton.setDisable(false);
        } else {
            resultText.setText("Result: Lexical Analysis Phase Not Successful!");
            lexicalButton.setDisable(true);
            clearButton.setDisable(false);
        }
    }
    @FXML
    protected void onSyntaxButtonClick() {
        String syntaxInput = textArea.getText();
        List<String> syntaxLines = Arrays.asList(syntaxInput.split("\\n"));
        if (FinalProjectMethods.isSyntaxCorrect(syntaxLines)) {
            resultText.setText("Result: Syntax Analysis Phase Successful!");
            syntaxButton.setDisable(true);
            semanticButton.setDisable(false);
            clearButton.setDisable(false);
        } else {
            resultText.setText("Result: Syntax Analysis Phase Not Successful!");
            syntaxButton.setDisable(true);
            clearButton.setDisable(false);
        }
    }
    @FXML
    protected void onSemanticButtonClick() {
        String semanticInput = textArea.getText();
        List<String> semanticLines = Arrays.asList(semanticInput.split("\\n"));
        if (FinalProjectMethods.isSemanticallyCorrect(semanticLines)) {
            resultText.setText("Result: Semantic Analysis Phase Successful!");
            semanticButton.setDisable(true);
            clearButton.setDisable(false);
        } else {
            resultText.setText("Result: Semantic Analysis Phase Not Successful!");
            semanticButton.setDisable(true);
            clearButton.setDisable(false);
        }
    }
    @FXML
    protected void onClearButtonClick() {
        resultText.setText("Result: ");
        codeTextArea.setText("Code Text Area");
        textArea.clear();
        textArea.setVisible(false);
        openFileButton.setDisable(false);
        lexicalButton.setDisable(true);
        syntaxButton.setDisable(true);
        semanticButton.setDisable(true);
        clearButton.setDisable(true);
    }
}
