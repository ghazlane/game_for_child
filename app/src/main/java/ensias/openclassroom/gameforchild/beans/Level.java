package ensias.openclassroom.gameforchild.beans;

import java.util.ArrayList;

public class Level {
    private  ArrayList<Question> listQuestion  ;

    public Level(ArrayList<Question> listQuestion) {
        this.listQuestion = listQuestion;
    }

    public ArrayList<Question> getListQuestion() {
        return listQuestion;
    }

    public void setListQuestion(ArrayList<Question> listQuestion) {
        this.listQuestion = listQuestion;
    }
}
