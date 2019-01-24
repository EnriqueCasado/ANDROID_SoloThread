package com.example.solothread;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {

    Button startBtn;
    TextView txtView;
    int segundos=10;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        startBtn=findViewById(R.id.button);
        txtView=findViewById(R.id.textView);



        startBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                runThread();

            }
        });

    }

    private void runThread() {

        new Thread() {
            public void run() {
                {
                    do  {
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                txtView.setText(String.valueOf(segundos));
                                if(segundos==0){
                                    Toast.makeText(MainActivity.this,"Se acabo la cuenta atrás",Toast.LENGTH_LONG).show();
                                }
                            }
                        });

                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        segundos -= 1;



                    }
                    while (segundos >=0);


                }
            }
        }.start();
    }


}

