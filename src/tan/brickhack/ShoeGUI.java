package tan.brickhack;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.util.Observable;
import java.util.Observer;

/**
 * Created by Ocean on 2/12/17.
 */
public class ShoeGUI extends Application implements Observer {



    /** width of the text region */
    private static final int WIDTH = 600;

    /** height of the text region */
    private static final int HEIGHT = 600;


    public ShoeGUI(){



    }

    public void init(){}

    public void update(Observable t, Object o) {
    }

        public void start(final Stage stage){

            stage.setTitle( "Sneaker Faker" );
            stage.setMinWidth( WIDTH );
            stage.setMinHeight( HEIGHT );


            Button start = new Button("START");
            final Label statement = new Label();
            BorderPane pane = new BorderPane();

            start.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);

            final PersonalAssistant personalAssistant = new PersonalAssistant();

            start.setOnAction(new EventHandler<ActionEvent>() {
                @Override public void handle(ActionEvent e) {
                    personalAssistant.startInteraction();
                    statement.setText(personalAssistant.getText());

                }
            });


            pane.setTop(statement);
            pane.setCenter(start);
            Scene scene = new Scene(pane);
            stage.setScene(scene);
            stage.show();


        }

    public static void main(String[] args){
        Application.launch( args );
    }

    }
