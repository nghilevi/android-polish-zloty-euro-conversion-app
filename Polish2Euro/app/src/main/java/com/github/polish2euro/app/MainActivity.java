package com.github.polish2euro.app;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import org.json.JSONException;
import org.json.JSONObject;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends ActionBarActivity{
    private static String url = "http://rate-exchange.appspot.com/currency?from=PLN&to=EUR";
    private static final String PLN_TO_EUR_RATE = "rate";
    Button convertButton = (Button) findViewById(R.id.convert);
    EditText polishCurrency=(EditText)findViewById(R.id.polishCurrency);

    int plnToEurRate;
    int pln;
    int result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /*JSONParser jParser = new JSONParser();

        try {
            // get JSON Object (not JSON Array) data from URL
            JSONObject jsonObject = jParser.getJSONFromUrl(url);
            plnToEurRate = jsonObject.getInt(PLN_TO_EUR_RATE);
        }
        catch (JSONException e) {
            e.printStackTrace();
        }*/

        convertButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /*if(polishCurrency != null) {
                    pln = Integer.parseInt(polishCurrency.getText().toString());
                } else {
                    pln=0;
                }*/
                //result=pln*plnToEurRate;
                result=0;
               // ((TextView)findViewById(R.id.polishCurrency)).setText(result);
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
