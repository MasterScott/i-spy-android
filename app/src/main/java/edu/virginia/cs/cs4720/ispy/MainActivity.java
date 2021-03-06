package edu.virginia.cs.cs4720.ispy;


import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.parse.Parse;
import com.parse.ParseObject;
import com.parse.ParseUser;

import java.util.List;

public class MainActivity extends Activity {
    Button myImages;
    Button camButt;
    Button galButt;
    Button logout;
    TextView tv;
    EditText et;
    int TAKE_PIC = 1;
    Uri imageUri;
    ImageView ivImage;

    List<String> myList;
    String mCurrentPhotoPath;


    GPS gps;

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ivImage = (ImageView)findViewById(R.id.ivImage);
        //Parse.enableLocalDatastore(this);
        //Parse.initialize(this, "LODmoenJcpDk44AAQzVVXym6wASNhosUAqq5V5JO", "MPq7ajGm8JnFfRJK127nYYTNEjf99RBZ8hKLE8ED");


//        guessButt = (Button)findViewById(R.id.guessButt);
//        guessButt.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//            }
//        });

        logout = (Button)findViewById(R.id.logout);
        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ParseUser.logOut();
                Intent i = new Intent(MainActivity.this, Login.class);
                startActivity(i);
            }
        });

        camButt = (Button)findViewById(R.id.myButt);

        camButt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                Intent i = new Intent(MainActivity.this, CameraPhotoCapture.class);
                startActivity(i);
            }
        });

        galButt = (Button)findViewById(R.id.galButt);
        galButt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                Intent i = new Intent(MainActivity.this, PictureList.class);
                startActivity(i);
            }
        });

        myImages = (Button) findViewById(R.id.myImages);
        myImages.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, myImages.class);
                startActivity(i);
            }
        });
    }



    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}