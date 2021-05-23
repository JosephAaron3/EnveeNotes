package enveenotes;

import enveenotes.notes.Note;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.util.ArrayList;

public class Main extends Application {
    private ArrayList<Note> notes = new ArrayList<>(); //Initializing empty for now - remove this later
    private Stage primaryStage;

    @Override
    public void start(Stage baseStage) {
        this.primaryStage = baseStage;
        primaryStage.initStyle(StageStyle.UTILITY);
        primaryStage.setOpacity(0);
        primaryStage.show();

        //load notes here

        if (notes.isEmpty()) {
            notes.add(new Note(this, primaryStage));
            notes.get(0).show();
        }
    }

    public EventHandler<ActionEvent> addNewNote() {
        return actionEvent -> {
            Note newNote = new Note(this, primaryStage);
            notes.add(newNote);
            newNote.show();
        };
    }

    public EventHandler<ActionEvent> closeNote(Stage noteStage) {
        return actionEvent -> {
            noteStage.close();
        };
    }

    public static void main(String[] args) {
        Application.launch(Main.class, args);
    }
}