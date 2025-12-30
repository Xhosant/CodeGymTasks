package com.codegym.task.task32.task3209;

import com.codegym.task.task32.task3209.listeners.UndoListener;

import javax.swing.*;
import javax.swing.text.BadLocationException;
import javax.swing.text.Document;
import javax.swing.text.html.HTMLDocument;
import javax.swing.text.html.HTMLEditorKit;
import javax.swing.undo.UndoManager;
import java.io.*;

public class Controller {
    private View view;
    private HTMLDocument document;
    private File currentFile;

    public Controller(View view) {
        this.view = view;
    }

    public HTMLDocument getDocument() {
        return document;
    }

    public static void main(String[] args) {
        View v = new View();
        Controller c = new Controller(v);
        v.setController(c);
        v.init();
        c.init();
    }
    public void resetDocument(){
        if (document!=null){
            document.removeUndoableEditListener(view.getUndoListener());
        }
        document  = (HTMLDocument) new HTMLEditorKit().createDefaultDocument();
        document.addUndoableEditListener(view.getUndoListener());
        view.update();
    }
    public void setPlainText(String text){
        resetDocument();
        StringReader reader = new StringReader(text);
        try {
            new HTMLEditorKit().read(reader, document, 0);
        } catch (IOException | BadLocationException e) {
            ExceptionHandler.log(e);
        }
    }
    public String getPlainText(){
        StringWriter writer = new StringWriter();
        try {
            new HTMLEditorKit().write(writer, document, 0, document.getLength());

        } catch (IOException | BadLocationException e) {
            ExceptionHandler.log(e);
        }
        return writer.toString();
    }
    public void init(){
        createNewDocument();
    }
    public void exit(){
        System.exit(0);
    }

    public void createNewDocument() {
        view.selectHtmlTab();
        resetDocument();
        view.setTitle("HTML editor");
        view.resetUndo();
        currentFile = null;
    }

    public void openDocument() {
        view.selectHtmlTab();
        JFileChooser chooser = new JFileChooser();
        chooser.setFileFilter(new HTMLFileFilter());
        if (chooser.showOpenDialog(view)==JFileChooser.APPROVE_OPTION) {
            currentFile = chooser.getSelectedFile();
            resetDocument();
            view.setTitle(currentFile.getName());

            try (FileReader fileReader = new FileReader(currentFile)) {
                new HTMLEditorKit().read(fileReader, document, 0);
            } catch (IOException | BadLocationException e) {
                ExceptionHandler.log(e);
            }
            view.resetUndo();
        }
    }

    public void saveDocument() {
        view.selectHtmlTab();
        if (currentFile==null) saveDocumentAs();
        else{
            try {
                FileWriter writer = new FileWriter(currentFile);
                new HTMLEditorKit().write(writer, document, 0,document.getLength());
            } catch (IOException | BadLocationException e) {
                ExceptionHandler.log(e);
            }
        }
    }

    public void saveDocumentAs() {
        view.selectHtmlTab();
        JFileChooser chooser = new JFileChooser();
        chooser.setFileFilter(new HTMLFileFilter());
        if (chooser.showSaveDialog(view)==JFileChooser.APPROVE_OPTION){
            currentFile = chooser.getSelectedFile();
            view.setTitle(currentFile.getName());
            try {
                FileWriter writer = new FileWriter(currentFile);
                new HTMLEditorKit().write(writer, document, 0,document.getLength());
            } catch (IOException | BadLocationException e) {
                ExceptionHandler.log(e);
            }
        }
    }
}
