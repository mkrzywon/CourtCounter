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
    private static final String KEY_FIVE_SCORE_LUKE = "StatsFiveScoreLuke";
    private static final String KEY_TEN_SCORE_LUKE = "StatsTenScoreLuke";
    private static final String KEY_FIFTEEN_SCORE_LUKE = "StatsFifteenScoreLuke";
    private static final String KEY_FIVE_SCORE_DARTH = "StatsFiveScoreDarth";
    private static final String KEY_TEN_SCORE_DARTH = "StatsTenScoreDarth";
    private static final String KEY_FIFTEEN_SCORE_DARTH = "StatsFifteenScoreDarth";
    private int scoreLuke = 0;
    private int scoreDarth = 0;
    private int lifeLuke = 100;
    private int lifeDarth = 100;
    private int addFiveScoreLuke = 0;
    private int addTenScoreLuke = 0;
    private int addFifteenScoreLuke = 0;
    private int addFiveScoreDarth = 0;
    private int addTenScoreDarth = 0;
    private int addFifteenScoreDarth = 0;

    private ImageView lukeid;
    private ImageView vaderid;

    private String titleDarth;
    private String titleLuke;
    private String statisticsDarth;
    private String statisticsLuke;
    private String darthWinner;
    private String lukeWinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        viewComponents();
    }

    /**
     * Saves the current state to avoid data loss in case of screen rotation.
     */
    @Override
    protected void onSaveInstanceState(Bundle savedInstanceState) {
        super.onSaveInstanceState(savedInstanceState);

        savedInstanceState.putInt(KEY_SCORE_LUKE, scoreLuke);
        savedInstanceState.putInt(KEY_SCORE_DARTH, scoreDarth);
        savedInstanceState.putInt(KEY_LIFE_LUKE, lifeLuke);
        savedInstanceState.putInt(KEY_LIFE_DARTH, lifeDarth);

        savedInstanceState.putInt(KEY_FIVE_SCORE_LUKE, addFiveScoreLuke);
        savedInstanceState.putInt(KEY_TEN_SCORE_LUKE, addTenScoreLuke);
        savedInstanceState.putInt(KEY_FIFTEEN_SCORE_LUKE, addFifteenScoreLuke);

        savedInstanceState.putInt(KEY_FIVE_SCORE_DARTH, addFiveScoreDarth);
        savedInstanceState.putInt(KEY_TEN_SCORE_DARTH, addTenScoreDarth);
        savedInstanceState.putInt(KEY_FIFTEEN_SCORE_DARTH, addFifteenScoreDarth);
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
     * This method determines the path and strings for final message of both players.
     */
    public void viewComponents() {

        lukeid = findViewById(R.id.lukeid);
        vaderid = findViewById(R.id.vaderid);

        titleDarth = getString(R.string.titledarth);
        titleLuke = getString(R.string.titleluke);

        statisticsDarth = (getString(R.string.darth_received) + addFiveScoreDarth + getString(R.string.points_shield) + addTenScoreDarth + getString(R.string.points_sword) + addFifteenScoreDarth + getString(R.string.points_gun) + getString(R.string.luke_received) + addFiveScoreLuke + getString(R.string.points_shield) + addTenScoreLuke + getString(R.string.points_sword) + addFifteenScoreLuke + getString(R.string.points_gun));
        statisticsLuke = (getString(R.string.luke_received) + addFiveScoreLuke + getString(R.string.points_shield) + addTenScoreLuke + getString(R.string.points_sword) + addFifteenScoreLuke + getString(R.string.points_gun) + getString(R.string.darth_received) + addFiveScoreDarth + getString(R.string.points_shield) + addTenScoreDarth + getString(R.string.points_sword) + addFifteenScoreDarth + getString(R.string.points_gun));

        darthWinner = getString(R.string.winnerdarth);
        lukeWinner = getString(R.string.winnerluke);

    }

    /**
     * Increase the score for Luke by 5 points.
     * Increase the life level of Luke by 5 points
     */
    public void addFiveForLuke(View v) {

        if (lifeLuke > 0 && lifeLuke < 100 && lifeDarth > 0 && lifeDarth < 100) {

            scoreLuke += 5;
            lifeLuke += 5;
            addFiveScoreLuke += 5;

        } else {

            if (lifeLuke <= 0) {

                lifeLuke = 0;
            }

            if (lifeLuke >= 100) {

                lifeLuke = 100;
            }

        }

        displayScoreForLuke(scoreLuke);
        displayLifeForLuke(lifeLuke);

    }

    /**
     * Increase the score for Luke by 10 points.
     * Decrease the life level of Darth by 7 points.
     */
    public void addTenForLuke(View v) {

        if (lifeLuke > 0 && lifeLuke <= 100 && lifeDarth > 0 && lifeDarth <= 100) {

            scoreLuke += 10;
            lifeDarth -= 7;
            addTenScoreLuke += 10;
            winnerLuke();

        } else {

            if (lifeDarth <= 0) {

                lifeDarth = 0;
                scoreLuke += 0;
                addTenScoreLuke += 0;

            }

            if (lifeDarth == 100) {

                lifeDarth = 100;
                scoreLuke += 0;
                addFifteenScoreLuke += 0;

            }
        }

        displayScoreForLuke(scoreLuke);
        displayLifeForDarth(lifeDarth);

    }

    /**
     * Increase the score for Luke by 15 points.
     * Decrease the life level of Darth by 10 points.
     */
    public void addFifteenForLuke(View v) {

        if (lifeLuke > 0 && lifeLuke <= 100 && lifeDarth > 0 && lifeDarth <= 100) {

            scoreLuke += 15;
            lifeDarth -= 10;
            addFifteenScoreLuke += 15;
            winnerLuke();

        } else {

            if (lifeDarth <= 0) {

                lifeDarth = 0;
                scoreLuke += 0;
                addFifteenScoreLuke += 0;

            }

            if (lifeDarth == 100) {

                lifeDarth = 100;
                scoreLuke += 0;
                addFifteenScoreLuke += 0;

            }
        }

        displayScoreForLuke(scoreLuke);
        displayLifeForDarth(lifeDarth);

    }

    /**
     * Increase the score for Darth by 5 point.
     * Increase the life level of Darth by 5 points.
     */
    public void addFiveForDarth(View v) {

        if (lifeDarth > 0 && lifeDarth < 100 && lifeLuke > 0 && lifeLuke < 100) {

            scoreDarth += 5;
            lifeDarth += 5;
            addFiveScoreDarth += 5;

        } else {

            if (lifeDarth <= 0) {

                lifeDarth = 0;

            }

            if (lifeDarth >= 100) {

                lifeDarth = 100;
            }
        }

        displayScoreForDarth(scoreDarth);
        displayLifeForDarth(lifeDarth);

    }

    /**
     * Increase the score for Darth by 10 points.
     * Decrease the life level of Luke by 7 points.
     */
    public void addTenForDarth(View v) {

        if (lifeDarth > 0 && lifeDarth <= 100 && lifeLuke > 0 && lifeLuke <= 100) {

            scoreDarth += 10;
            lifeLuke -= 7;
            addTenScoreDarth += 10;
            winnerDarth();

        } else {

            if (lifeLuke <= 0) {

                lifeLuke = 0;
                scoreDarth += 0;
                addTenScoreDarth += 0;

            }

            if (lifeLuke == 100) {

                lifeLuke = 100;
                scoreDarth += 0;
                addFifteenScoreDarth += 0;

            }
        }

        displayScoreForDarth(scoreDarth);
        displayLifeForLuke(lifeLuke);

    }

    /**
     * Increase the score for Darth by 15 points.
     * Decrease the life level of Luke by 10 points
     */
    public void addFifteenForDarth(View view) {

        if (lifeDarth > 0 && lifeDarth <= 100 && lifeLuke > 0 && lifeLuke <= 100) {

            scoreDarth += 15;
            lifeLuke -= 10;
            addFifteenScoreDarth += 15;
            winnerDarth();

        } else {

            if (lifeLuke <= 0) {

                lifeLuke = 0;
                scoreDarth += 0;
                addFifteenScoreDarth += 0;

            }

            if (lifeLuke == 100) {

                lifeLuke = 100;
                scoreDarth += 0;
                addFifteenScoreDarth += 0;

            }
        }

        displayScoreForDarth(scoreDarth);
        displayLifeForLuke(lifeLuke);

    }

    /**
     * In case of Victory of Darth new image, message and alert dialog with statistics are being displayed.
     */
    public void winnerDarth() {

        if (lifeLuke <= 0) {
            lukeid.setImageResource(R.drawable.luke_defeated);
            Toast toast = Toast.makeText(this, darthWinner, Toast.LENGTH_LONG);
            toast.show();
            AlertDialog.Builder show = new AlertDialog.Builder(this);
            show.setTitle(titleDarth);
            show.setMessage(Html.fromHtml(statisticsDarth));
            show.setNeutralButton("OK", null);
            show.show();
        }
    }

    /**
     * In case of Victory of Luke new image, message and alert dialog with statistics are being displayed.
     */
    public void winnerLuke() {

        if (lifeDarth <= 0) {
            vaderid.setImageResource(R.drawable.vader_defeated);
            Toast toast = Toast.makeText(this, lukeWinner, Toast.LENGTH_LONG);
            toast.show();
            AlertDialog.Builder show = new AlertDialog.Builder(this);
            show.setTitle(titleLuke);
            show.setMessage(Html.fromHtml(statisticsLuke));
            show.setNeutralButton("OK", null);
            show.show();
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
}
