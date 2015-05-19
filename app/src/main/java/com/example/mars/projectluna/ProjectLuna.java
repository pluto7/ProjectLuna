package com.example.mars.projectluna;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.app.FragmentTransaction;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import android.view.View.OnClickListener;

public class ProjectLuna extends Activity {

    private Button newStoryButton;
    private Button continueStoryButton;

    //create constants for menu ids
    private final int ABOUT_MENU_ID = Menu.FIRST;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_project_luna);

        newStoryButton = (Button)findViewById(R.id.newStoryButton);
        newStoryButton.setOnClickListener(newStoryListener);

        continueStoryButton = (Button)findViewById(R.id.continueStoryButton);
        continueStoryButton.setOnClickListener(continueStoryListener);
    }

    //listener for new story button
    public OnClickListener newStoryListener = new OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent newScene = new Intent(ProjectLuna.this, SceneView.class);
            startActivity(newScene);
        }
    };//end newStoryListener

    //listener for continue story button
    public OnClickListener continueStoryListener = new OnClickListener() {
        @Override
        public void onClick(View view) {
            Intent continueScene = new Intent(ProjectLuna.this, SceneView.class);
            continueScene.putExtra("continue", true);
            startActivity(continueScene);
        }
    };//end continueStoryListener

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        //add the about option to the menu
        //menu.add(Menu.NONE, ABOUT_MENU_ID, Menu.NONE, R.string.about);;
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_project_luna, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.

        //create an alert dialog to display the information for about
        AlertDialog.Builder aboutBuilder = new AlertDialog.Builder(this);
        aboutBuilder.setTitle(R.string.about_title);
        aboutBuilder.setMessage(R.string.about_message);
        aboutBuilder.setPositiveButton("OK", null);
        AlertDialog aboutDialog = aboutBuilder.create();
        aboutDialog.show();

        return super.onOptionsItemSelected(item);
    }
}//end ProjectLuna class
