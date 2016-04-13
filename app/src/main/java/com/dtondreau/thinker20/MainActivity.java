package com.dtondreau.thinker20;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {


 //   public void fade(View view) {

 //       ImageView obama = (ImageView) findViewById(R.id.obama);

  //      ImageView kennedy = (ImageView) findViewById(R.id.kennedy);

  //      obama.animate().alpha(0f).setDuration(2000);

  //      kennedy.animate().alpha(1f).setDuration(2000);

 //   }

    private static final int MENU_ITEM_EXIT = 1001;
    private CoordinatorLayout coordinatorLayout;

    private static String webUrl = "http://uspresidents.org/";
    private static String email = "dtondreau@helpsupport.com";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        coordinatorLayout = (CoordinatorLayout) findViewById(R.id.coordinator);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Send an email
                String[] addresses = {email};
                Intent intent = new Intent(Intent.ACTION_SENDTO);
                intent.setData(Uri.parse("mailto:"));
                intent.putExtra(Intent.EXTRA_EMAIL, addresses);
                intent.putExtra(Intent.EXTRA_SUBJECT, "Information request");
                intent.putExtra(Intent.EXTRA_TEXT, "Please send some information!");
                if (intent.resolveActivity(getPackageManager()) != null) {
                    startActivity(intent);
                }

            }
        });


    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);

        menu.add(0, MENU_ITEM_EXIT, 101, R.string.End_Game);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        switch (id) {

            case R.id.action_settings:
               Snackbar.make(coordinatorLayout,
                  "You selected settings", Snackbar.LENGTH_LONG)
                   .setAction("Action", null).show();


            return true;
                case  R.id.action_about:
     //           Snackbar.make(coordinatorLayout,
      //                  "You selected About", Snackbar.LENGTH_LONG)
      //                  .setAction("Action", null).show();

                    Intent intent = new Intent(this, AboutActivity.class);
                    startActivity(intent);
                return true;

            case  R.id.action_presidents:
                Snackbar.make(coordinatorLayout,
                        "You selected United States of America Presidents", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
                return true;

            case R.id.action_web:
                //Presidents Website
                Intent webIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(webUrl));
                if (webIntent.resolveActivity(getPackageManager()) != null){
                    startActivity(webIntent);
                }
                return true;

            case  R.id.action_start:
        //        Snackbar.make(coordinatorLayout,
         //               "You selected To Start the Game", Snackbar.LENGTH_LONG)
         //               .setAction("Action", null).show();

                Intent intents = new Intent(this, StartActivity.class);
                startActivity(intents);
                return true;


            case  MENU_ITEM_EXIT:
                Snackbar.make(coordinatorLayout,
                        "You selected to end the game", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
                return true;

                }

                return super.onOptionsItemSelected(item);
            }
        }

