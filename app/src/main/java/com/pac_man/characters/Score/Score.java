package com.pac_man.characters.Score;

import com.pac_man.characters.Utils.Text;

public class Score {
    private int amountPoints;
    private Text text;

    public Score(int _amountPoint) {
        this.amountPoints = _amountPoint;
        this.text = new Text("Score: "+ getAmountPoints());
    }

    public int getAmountPoints() {
        return amountPoints;
    }

    public void addPoints(int _amountPoints) {
        this.amountPoints += _amountPoints;
        this.text.setText("Score: "+amountPoints);
    }

    public Text getText() {
        return text;
    }
}