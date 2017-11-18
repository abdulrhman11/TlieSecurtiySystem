package saud.abdulrhman.tliesecurtiysystem;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

public class UserAreaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_area);

        ImageButton img =(ImageButton) findViewById(R.id.imageButton5);
        ImageButton img1 =(ImageButton) findViewById(R.id.imageButton2);

        img1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                    Intent intent =null, chooser=null;

                    if(v.getId()==R.id.imageButton2){

                        Intent i = new Intent(Intent.ACTION_SEND);
                        i.setType("message/rfc822");
                        i.putExtra(Intent.EXTRA_EMAIL  , new String[]{"qu_u@hotmail.com"});
                        i.putExtra(Intent.EXTRA_SUBJECT, "tile securtiy system");
                        i.putExtra(Intent.EXTRA_TEXT   , "tile securtiy system");
                        try {
                            startActivity(Intent.createChooser(i, "Send Email"));
                        } catch (android.content.ActivityNotFoundException ex) {
                            Toast.makeText(UserAreaActivity.this, "There are no email clients installed.", Toast.LENGTH_SHORT).show();
                        }
                    }


                }




        });

        img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(UserAreaActivity.this,Alrte_Activity.class);
                UserAreaActivity.this.startActivity(intent);

            }
        });
    }


    }

