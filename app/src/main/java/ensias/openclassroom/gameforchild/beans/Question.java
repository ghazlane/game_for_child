package ensias.openclassroom.gameforchild.beans;

import java.util.ArrayList;

public class Question {
    private int IdImageDrawable ;
    private String questtion ;
    private String reponse;
    private ArrayList<String> listChoix;

    public Question(int idImageDrawable, String questtion, String reponse, ArrayList<String> listChoix) {
        IdImageDrawable = idImageDrawable;
        this.questtion = questtion;
        this.reponse = reponse;
        this.listChoix = listChoix;
    }

    public int getIdImageDrawable() {
        return IdImageDrawable;
    }

    public void setIdImageDrawable(int idImageDrawable) {
        IdImageDrawable = idImageDrawable;
    }

    public String getQuesttion() {
        return questtion;
    }

    public void setQuesttion(String questtion) {
        this.questtion = questtion;
    }

    public String getReponse() {
        return reponse;
    }

    public void setReponse(String reponse) {
        this.reponse = reponse;
    }

    public ArrayList<String> getListChoix() {
        return listChoix;
    }

    public void setListChoix(ArrayList<String> listChoix) {
        this.listChoix = listChoix;
    }
}
