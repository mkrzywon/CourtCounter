package com.example.android.courtcounter;

import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.text.Html;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private static final String KEY_SCORE_LUKE = "LevelScoreLuke";
    private static final String KEY_SCORE_DARTH = "LevelScoreDarth";
    private static final String KEY_LIFE_LUKE = "LevelLifeLuke";
    private static final String KEY_LIFE_DARTH = "LevelLiveDarth";

    private int scoreLuke = 0;
    private int scoreDarth = 0;
    private int lifeLuke = 100;
    private int lifeDarth = 100;

    private static final String KEY_FIVE_SCORE_LUKE = "StatsFiveScoreLuke";
    private static final String KEY_TEN_SCORE_LUKE = "StatsTenScoreLuke";
    private static final String KEY_FIFTEEN_SCORE_LUKE = "StatsFifteenScoreLuke";

    private int addFiveScoreLuke = 0;
    private int addTenScoreLuke = 0;
    private int addFifteenScoreLuke = 0;

    private static final String KEY_FIVE_SCORE_DARTH = "StatsFiveScoreDarth";
    private static final String KEY_TEN_SCORE_DARTH = "StatsTenScoreDarth";
    private static final String KEY_FIFTEEN_SCORE_DARTH = "StatsFifteenScoreDarth";

    private int addFiveScoreDarth = 0;
    private int addTenScoreDarth = 0;
    private int addFifteenScoreDarth = 0;

    private ImageView lukeid;
    private ImageView vaderid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lukeid = findViewById(R.id.lukeid);
        vaderid = findViewById(R.id.vaderid);
    }

    /**
     * Saves the current state to avoid data loss in case of screen rotation.
     */
    @Override
    protected void onSaveInstanceState(Bundle savedInstanceState) {
        super.onSaveInstanceState(savedInstanceState);

        savedInstanceState.putInt(KEY_SCORE_LUKE,scoreLuke);
        savedInstanceState.putInt(KEY_SCORE_DARTH,scoreDarth);
        savedInstanceState.putInt(KEY_LIFE_LUKE,lifeLuke);
        savedInstanceState.putInt(KEY_LIFE_DARTH,lifeDarth);

        savedInstanceState.putInt(KEY_FIVE_SCORE_LUKE,addFiveScoreLuke);
        savedInstanceState.putInt(KEY_TEN_SCORE_LUKE,addTenScoreLuke);
        savedInstanceState.putInt(KEY_FIFTEEN_SCORE_LUKE,addFifteenScoreLuke);

        savedInstanceState.putInt(KEY_FIVE_SCORE_DARTH,addFiveScoreDarth);
        savedInstanceState.putInt(KEY_TEN_SCORE_DARTH,addTenScoreDarth);
        savedInstanceState.putInt(KEY_FIFTEEN_SCORE_DARTH,addFifteenScoreDarth);
    }

    /**
     * Restores the current state in case of screen rotation.
     */
    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
            super.onRestoreInstanceState(savedInstanceState);

            scoreLuke = savedInstanceState.getInt(KEY_SCORE_LUKE);
            scoreDarth = savedInstanceState.getInt(KEY_SCORE_DARTH);
            lifeLuke = savedInstanceState.getInt(KEY_LIFE_LUKE);
            lifeDarth = savedInstanceState.getInt(KEY_LIFE_DARTH);

            addFiveScoreLuke = savedInstanceState.getInt(KEY_FIVE_SCORE_LUKE);
            addTenScoreLuke = savedInstanceState.getInt(KEY_TEN_SCORE_LUKE);
            addFifteenScoreLuke = savedInstanceState.getInt(KEY_FIFTEEN_SCORE_LUKE);

            addFiveScoreDarth = savedInstanceState.getInt(KEY_FIVE_SCORE_DARTH);
            addTenScoreDarth = savedInstanceState.getInt(KEY_TEN_SCORE_DARTH);
            addFifteenScoreDarth = savedInstanceState.getInt(KEY_FIFTEEN_SCORE_DARTH);

            displayScoreForLuke(scoreLuke);
            displayScoreForDarth(scoreDarth);
            displayLifeForLuke(lifeLuke);
            displayLifeForDarth(lifeDarth);
    }

    /**
     * Increase the score for Luke by 5 points.
     * Increase the life level of Luke by 5 points
     */
    public void addFiveForLuke(View v) {

        if (lifeLuke != 0 && lifeDarth != 0) {

            if (lifeLuke < 100) {
                scoreLuke = scoreLuke + 5;
                lifeLuke = lifeLuke + 5;
                addFiveScoreLuke = addFiveScoreLuke + 5;
                if (lifeLuke < 1) {
                    lifeLuke = 0;
                } else {
                    scoreLuke = ((scoreLuke + 5) - 5);
                }
            }

            displayScoreForLuke(scoreLuke);
            displayLifeForLuke(lifeLuke);
        }
    }

    /**
     * Increase the score for Luke by 10 points.
     * Decrease the life level of Darth by 7 points.
     */
    public void addTenForLuke(View v) {

        if (lifeLuke != 0 && lifeDarth != 0) {

            if (lifeDarth > 0) {
                scoreLuke = scoreLuke + 10;
                addTenScoreLuke = addTenScoreLuke + 10;
                if (lifeDarth < 7) {
                    lifeDarth = 0;
                } else {
                    lifeDarth = lifeDarth - 7;
                }
            }

            displayScoreForLuke(scoreLuke);
            displayLifeForDarth(lifeDarth);
            winnerLuke(lifeDarth);
        }
    }

    /**
     * Increase the score for Luke by 15 points.
     * Decrease the life level of Darth by 10 points.
     */
    public void addFifteenForLuke(View v) {

        if (lifeLuke != 0 && lifeDarth != 0) {

            if (lifeDarth > 0) {
                scoreLuke = scoreLuke + 15;
                addFifteenScoreLuke = addFifteenScoreLuke + 15;
                if (lifeDarth < 10) {
                    lifeDarth = 0;
                } else {
                    lifeDarth = lifeDarth - 10;
                }
            }

            displayScoreForLuke(scoreLuke);
            displayLifeForDarth(lifeDarth);
            winnerLuke(lifeDarth);
        }
    }

    /**
     * Increase the score for Darth by 5 point.
     * Increase the life level of Darth by 5 points.
     */
    public void addFiveForDarth(View v) {

        if (lifeLuke != 0 && lifeDarth != 0) {

            if (lifeDarth < 100) {
                scoreDarth = scoreDarth + 5;
                lifeDarth = lifeDarth + 5;
                addFiveScoreDarth = addFiveScoreDarth + 5;
                if (lifeDarth < 1) {
                    lifeDarth = 0;
                } else {
                    scoreDarth = ((scoreDarth + 5) - 5);
                }
            }

            displayScoreForDarth(scoreDarth);
            displayLifeForDarth(lifeDarth);
        }
    }

    /**
     * Increase the score for Darth by 10 points.
     * Decrease the life level of Luke by 7 points.
     */
    public void addTenForDarth(View v) {

        if (lifeLuke != 0 && lifeDarth != 0) {

            if (lifeLuke > 0) {
                scoreDarth = scoreDarth + 10;
                addTenScoreDarth = addTenScoreDarth + 10;
                if (lifeLuke < 7) {
                    lifeLuke = 0;
                } else {
                    lifeLuke = lifeLuke - 7;
                }
            }

            displayScoreForDarth(scoreDarth);
            displayLifeForLuke(lifeLuke);
            winnerDarth(lifeLuke);
        }
    }

    /**
     * Increase the score for Darth by 15 points.
     * Decrease the life level of Luke by 10 points
     */
    public void addFifteenForDarth(View view) {

        if (lifeLuke != 0 && lifeDarth != 0) {

            if (lifeLuke > 0) {
                scoreDarth = scoreDarth + 15;
                addFifteenScoreDarth = addFifteenScoreDarth + 15;
                if (lifeLuke < 10) {
                    lifeLuke = 0;
                } else {
                    lifeLuke = lifeLuke - 10;
                }
            }

            displayScoreForDarth(scoreDarth);
            displayLifeForLuke(lifeLuke);
            winnerDarth(lifeLuke);
        }
    }

    /**
     * Displays the given score for Luke.
     */
    public void displayScoreForLuke(int score) {
        TextView scoreView = findViewById(R.id.luke_score);
        scoreView.setText(String.valueOf(score));

    }

    /**
     * Displays life level of Luke.
     */
    public void displayLifeForLuke(int score) {
        TextView scoreView = findViewById(R.id.luke_life);
        scoreView.setText(String.valueOf(score));

    }

    /**
     * Displays the given score for Darth.
     */
    public void displayScoreForDarth(int score) {
        TextView scoreView = findViewById(R.id.darth_score);
        scoreView.setText(String.valueOf(score));

    }

    /**
     * Displays life level of Darth.
     */
    public void displayLifeForDarth(int score) {
        TextView scoreView = findViewById(R.id.darth_life);
        scoreView.setText(String.valueOf(score));

    }

    /**
     * Resets score and life levels of Luke and Darth to defaults.
     */
    public void reset_button(View v) {
        lukeid.setImageResource(R.drawable.luke);
        vaderid.setImageResource(R.drawable.vader);
        scoreLuke = 0;
        lifeLuke = 100;
        scoreDarth = 0;
        lifeDarth = 100;
        addFiveScoreLuke = 0;
        addFiveScoreDarth = 0;
        addTenScoreLuke = 0;
        addTenScoreDarth = 0;
        addFifteenScoreLuke = 0;
        addFifteenScoreDarth = 0;
        displayScoreForLuke(scoreLuke);
        displayLifeForLuke(lifeLuke);
        displayScoreForDarth(scoreDarth);
        displayLifeForDarth(lifeDarth);
    }

    /**
     * In case of Victory of Darth new image, message and alert dialog with statistics are being displayed.
     */
    public void winnerDarth(int lifeLuke) {

        String statistics = ("<p style=text-align:center><b>Darth received:</b></p>" + addFiveScoreDarth + " points for using shield<br>" + addTenScoreDarth + " points for using sword<br>" + addFifteenScoreDarth + " points for using gun<br>" + "<p style=text-align:center><b>Luke received:</b></p>" + addFiveScoreLuke + " points for using shield<br>" + addTenScoreLuke + " points for using sword<br>" + addFifteenScoreLuke + " points for using gun<br>");
        String title = getString(R.string.titledarth);
        String darth_winner = getString(R.string.winnerdarth);

        if (lifeLuke <= 0) {
            lukeid.setImageResource(R.drawable.luke_defeated);
            Toast toast = Toast.makeText(this, darth_winner, Toast.LENGTH_LONG);
            toast.show();
            AlertDialog.Builder show = new AlertDialog.Builder(this);
                    show.setTitle(title);
                    show.setMessage(Html.fromHtml(statistics));
                    show.setNeutralButton("OK", null);
                    show.show();
        }
    }

    /**
     * In case of Victory of Luke new image, message and alert dialog with statistics are being displayed.
     */
    public void winnerLuke(int lifeDarth) {

        String statistics = ("<p style=text-align:center><b>Luke received:</b></p>" + addFiveScoreLuke + " points for using shield<br>" + addTenScoreLuke + " points for using sword<br>" + addFifteenScoreLuke + " points for using gun<br>" + "<p style=text-align:center><b>Darth received:</b></p>" + addFiveScoreDarth + " points for using shield<br>" + addTenScoreDarth + " points for using sword<br>" + addFifteenScoreDarth + " points for using gun<br>");
        String title = getString(R.string.titleluke);
        String luke_winner = getString(R.string.winnerluke);

        if (lifeDarth <= 0) {
            vaderid.setImageResource(R.drawable.vader_defeated);
            Toast toast = Toast.makeText(this, luke_winner, Toast.LENGTH_LONG);
            toast.show();
            AlertDialog.Builder show = new AlertDialog.Builder(this);
                    show.setTitle(title);
                    show.setMessage(Html.fromHtml(statistics));
                    show.setNeutralButton("OK", null);
                    show.show();
        }
    }
}