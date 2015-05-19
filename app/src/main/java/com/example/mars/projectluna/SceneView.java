package com.example.mars.projectluna;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;


public class SceneView extends Activity {

    public static final String PREFS_SCENE = "Scene Preference";

    private ImageView sceneImageView;
    private TextView sceneTextView;
    private Button option1Button;
    private Button option2Button;
    private Button endStoryButton;
    private String scene;
    private String lastScene;
    private String currentScene;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scene_view);

        sceneImageView = (ImageView)findViewById(R.id.sceneImage);
        sceneTextView = (TextView)findViewById(R.id.sceneTextView);
        option1Button = (Button)findViewById(R.id.option1Button);
        option2Button = (Button)findViewById(R.id.option2Button);
        endStoryButton = (Button)findViewById(R.id.endStoryButton);
        scene = "scene1_01";

        option1Button.setOnClickListener(option1Listener);
        option2Button.setOnClickListener(option2Listener);
        endStoryButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent homeView = new Intent(SceneView.this, ProjectLuna.class);
                startActivity(homeView);
            }
        });

        Bundle extras = getIntent().getExtras();

        if(extras == null)//continue button was not clicked
        {
            loadScene(scene);
        }
        else//continue story button clicked load scene from shared preferences
        {
            SharedPreferences scenePref = getSharedPreferences(PREFS_SCENE, 0);
            currentScene = scenePref.getString("savedScene", lastScene);
            loadScene(currentScene);
        }
    }

    //this method loads the scene based on what string is passed in, it sets the details for each indvidual scene
    private void loadScene(String which)
    {
        if(which.equals("scene1_01"))
        {
            sceneImageView.setImageResource(R.drawable.base);
            sceneTextView.setText(R.string.scene1_01_text);
            option1Button.setText(R.string.option1_scene1_01_text);
            option2Button.setText(R.string.option2_scene1_01_text);
            option1Button.setVisibility(View.VISIBLE);
            option2Button.setVisibility(View.VISIBLE);
            endStoryButton.setVisibility(View.GONE);
            getActionBar().setTitle("Outpost Luna");
            scene = "scene1_01";
        }
        else if(which.equals("scene2_01"))
        {
            sceneImageView.setImageResource(R.drawable.base_walk);
            sceneTextView.setText(R.string.scene2_01_text);
            option1Button.setText(R.string.option1_scene2_01);
            option2Button.setText(R.string.option2_scene2_01);
            option1Button.setVisibility(View.VISIBLE);
            option2Button.setVisibility(View.VISIBLE);
            endStoryButton.setVisibility(View.GONE);
            getActionBar().setTitle("Taking in the View");
            scene = "scene2_01";
        }
        else if(which.equals("scene2_02"))
        {
            sceneImageView.setImageResource(R.drawable.base_rover);
            sceneTextView.setText(R.string.scene2_02_text);
            option1Button.setText(R.string.option1_scene2_02);
            option2Button.setText(R.string.option2_scene2_02);
            option1Button.setVisibility(View.VISIBLE);
            option2Button.setVisibility(View.VISIBLE);
            endStoryButton.setVisibility(View.GONE);
            getActionBar().setTitle("Need for Speed");
            scene = "scene2_02";
        }
        else if(which.equals("scene3_01"))
        {
            sceneImageView.setImageResource(R.drawable.walk_ducktape);
            sceneTextView.setText(R.string.scene3_01_text);
            option1Button.setVisibility(View.GONE);
            option2Button.setVisibility(View.GONE);
            endStoryButton.setVisibility(View.VISIBLE);
            getActionBar().setTitle("My Very Own Moon Rock");
            scene = "scene3_01";
        }
        else if(which.equals("scene3_02"))
        {
            sceneImageView.setImageResource(R.drawable.wait);
            sceneTextView.setText(R.string.scene3_02_text);
            option1Button.setVisibility(View.GONE);
            option2Button.setVisibility(View.GONE);
            endStoryButton.setVisibility(View.VISIBLE);
            getActionBar().setTitle("Unhappy Boss");
            scene = "scene3_02";
        }
        else if(which.equals("scene3_03"))
        {
            sceneImageView.setImageResource(R.drawable.rover_jump);
            sceneTextView.setText(R.string.scene3_03_text);
            option1Button.setVisibility(View.GONE);
            option2Button.setVisibility(View.GONE);
            endStoryButton.setVisibility(View.VISIBLE);
            getActionBar().setTitle("Going for Style. Woo!");
            scene = "scene3_03";
        }
        else if(which.equals("scene3_04"))
        {
            sceneImageView.setImageResource(R.drawable.rover_slow);
            sceneTextView.setText(R.string.scene3_04_text);
            option1Button.setVisibility(View.GONE);
            option2Button.setVisibility(View.GONE);
            endStoryButton.setVisibility(View.VISIBLE);
            getActionBar().setTitle("The Turtle Always Wins");
            scene = "scene3_04";
        }

    }//end loadScene method

    //listener for option 1 button in the scene view
    public View.OnClickListener option1Listener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {

            //load next scene based on what scene was before
            if(scene.equals("scene1_01"))
            {
                loadScene("scene2_01");
            }
            else if(scene.equals("scene2_01"))
            {
                loadScene("scene3_01");
            }
            else if(scene.equals("scene2_02"))
            {
                loadScene("scene3_03");
            }

        }
    };//end option1Listener

    //listener for option 2 button in the scene view
    public View.OnClickListener option2Listener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {

            //load next scene based on what scene was before
            if(scene.equals("scene1_01"))
            {
                loadScene("scene2_02");
            }
            else if(scene.equals("scene2_01"))
            {
                loadScene("scene3_02");
            }
            else if(scene.equals("scene2_02"))
            {
                loadScene("scene3_04");
            }

        }
    };//end option2Listener

    //method that will store the current scene to the shared preferences for when the user wants to continue the story
    @Override
    protected void onStop()
    {
        super.onStop();
        lastScene = scene;

        SharedPreferences currentScene = getSharedPreferences(PREFS_SCENE, 0);
        SharedPreferences.Editor editor = currentScene.edit();
        editor.putString("savedScene", lastScene);
        editor.commit();
    }//end onStop method

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_scene_view, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        //create an alert dialog to display the information for about
        if(item.getTitle().equals("About"))
        {
            AlertDialog.Builder aboutBuilder = new AlertDialog.Builder(this);
            aboutBuilder.setTitle(R.string.about_title);
            aboutBuilder.setMessage(R.string.about_message);
            aboutBuilder.setPositiveButton("OK", null);
            AlertDialog aboutDialog = aboutBuilder.create();
            aboutDialog.show();
        }
        else if(item.getTitle().equals("Reset Story"))
        {
            loadScene("scene1_01");
        }

        return super.onOptionsItemSelected(item);
    }
}//end SceneView
