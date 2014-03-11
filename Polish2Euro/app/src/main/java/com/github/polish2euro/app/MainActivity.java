package com.github.polish2euro.app;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends ActionBarActivity{
    private static String URL;
    private static String PLN_TO_EUR_RATE_CODE;
    TextView eurTextView;
    EditText plnEditText;
    double plnDoubleValue;
    double plnToEurRate;
    double eurDoubleValue;
    int iCount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        URL = "http://rate-exchange.appspot.com/currency?from=PLN&to=EUR";
        PLN_TO_EUR_RATE_CODE = "rate";
        plnToEurRate=0.237;
        setContentView(R.layout.activity_main);

        eurTextView =((TextView)findViewById(R.id.result));
        plnEditText =(EditText)findViewById(R.id.polishCurrency);

        final Button convertButton = (Button) findViewById(R.id.convert);
        convertButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                plnDoubleValue =Double.parseDouble(plnEditText.getText().toString());

                //new ProgressTask(MainActivity.this).execute();


                eurDoubleValue= plnDoubleValue *plnToEurRate;

                plnEditText.setText(Double.toString(plnDoubleValue));
                eurTextView.setText(Double.toString( Math.round(eurDoubleValue * 100.0) / 100.0));

                InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                imm.showSoftInput(plnEditText, InputMethodManager.SHOW_IMPLICIT);
            }
        });


    }

    private class ProgressTask extends AsyncTask<String, Void, Boolean> {
        private ProgressDialog dialog;
        private Activity activity;
        private Context context;

        public ProgressTask(Activity activity) {
            this.activity = activity;
            context = activity;
            dialog = new ProgressDialog(context);
        }

        protected void onPreExecute() {
            this.dialog.setMessage("Progress start");
            this.dialog.show();
        }

        @Override
        protected void onPostExecute(final Boolean success) {
            if (dialog.isShowing()) {
                dialog.dismiss();
            }
        }


        @Override
        protected Boolean doInBackground(String... params) {
            /*JSONParser jParser = new JSONParser();
            JSONObject jsonObject = jParser.getJSONFromUrl(URL);
            plnToEurRate=0.237;
            try {
                // get JSON Object (not JSON Array) data from URL
                JSONObject jsonObject = jParser.getJSONFromUrl(URL);
                plnToEurRate = jsonObject.getInt(PLN_TO_EUR_RATE_CODE);
            }
            catch (JSONException e) {
                e.printStackTrace();
            }
            result= plnDoubleValue *plnToEurRate;
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            plnEditText.setText(Double.toString(result) + " PLN");
            eurEditText.setText(Double.toString(plnDoubleValue) + " EUR");*/
            return null;
        }
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

