package edu.ags.optionsdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.Toast;


//Extends = Inheritance
//Implements = Implementing an interface
public class MainActivity extends AppCompatActivity implements CompoundButton.OnCheckedChangeListener {

    private static final String TAG =  "myDebug";
    RadioButton rbtnRock;
    RadioButton rbtnPaper;
    RadioButton rbtnScissors;
    CheckBox chkStatus;
    WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        try{
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);

            initOptions();

            //get the webview
            webView = findViewById(R.id.webView);
            webView.setWebViewClient(new WebViewClient());
            //webView.loadUrl("https://playvalorant.com/en-us");


            //Show HTML example
            String html = "<html><body style='background-color:yellow'></body><html>";
            webView.loadData(html,"text/html","UTF-8");

            Log.d(TAG, "Finished OnCreate");
        }
        catch (Exception e) {
            Log.d(TAG, "onCreate Error: " + e.getMessage());
        }
    }

    private void initOptions() {
        //Create the instance variables for the controls in the xml
        rbtnRock = findViewById(R.id.rbtnRock);
        rbtnPaper = findViewById(R.id.rbtnPaper);
        rbtnScissors = findViewById(R.id.rbtnScissors);

        chkStatus = findViewById(R.id.chkStatus);

        //Add a listener of this to the radio button
        rbtnRock.setOnCheckedChangeListener(this);
        rbtnPaper.setOnCheckedChangeListener(this);
        rbtnScissors.setOnCheckedChangeListener(this);

        chkStatus.setOnCheckedChangeListener(this);




    }

    @Override
    public void onCheckedChanged(CompoundButton compoundButton, boolean b) {



        try {


            if(b){

                Log.d(TAG, "onCheckedChanged: " + compoundButton.getText() + " is checked. ");

            }

            if (compoundButton.getId() == R.id.chkStatus)
            {
                if(b)
                    chkStatus.setText("Checked");

                else
                    chkStatus.setText("Unchecked");
            }


            switch (compoundButton.getId())
            {
                case R.id.rbtnRock:
                    if(b)
                    {
                        Toast.makeText(this, compoundButton.getText(), Toast.LENGTH_LONG).show();
                    }
                    break;
                case R.id.rbtnPaper:
                    if(b)
                    {
                        Toast.makeText(this, compoundButton.getText(), Toast.LENGTH_LONG).show();
                    }
                case R.id.rbtnScissors:
                    if(b)
                    {
                        Toast.makeText(this, compoundButton.getText(), Toast.LENGTH_LONG).show();
                    }

            }
        }

 catch (Exception e)
        {
            Log.d(TAG, "onCheckedChanged: " + e.getMessage());
        }

    }
}