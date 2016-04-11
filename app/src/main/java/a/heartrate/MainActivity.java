package a.heartrate;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {


    private TextView ageVw;
    private TextView targetVw;
    private TextView targCalc;
    private TextView targCalc2;
    private TextView maxVw;
    private TextView mxCalc;
    private TextView title;
    private TextView welcome;
    private TextView warning;
    private EditText ageTx;
    private int age;
    private int targetRateLow;
    private int targetRateHigh;
    private int maxRate;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        title = (TextView) findViewById(R.id.title);
        welcome = (TextView) findViewById(R.id.welcome);
        warning = (TextView) findViewById(R.id.warning);

        ageVw = (TextView) findViewById(R.id.AgeVw);
        targetVw = (TextView) findViewById(R.id.targetVw);
        targCalc= (TextView) findViewById(R.id.targetCalc);
        targCalc2 = (TextView) findViewById(R.id.targetCalc2);
        maxVw = (TextView) findViewById(R.id.maxVw);
        mxCalc = (TextView) findViewById(R.id.maxCalc);

        mxCalc.setText(" ");
        targCalc.setText(" ");
        targCalc2.setText(" ");

        update();
        EditText ageTx = (EditText) findViewById(R.id.ageTx);
        ageTx.addTextChangedListener(ageTxListener);
    } // end onCreate

    private void update()
    {
        maxRate = 220-age;
        targetRateLow= (int) ((double)maxRate*0.5);
        targetRateHigh = (int) ((double)maxRate*0.85);

        mxCalc.setText(String.valueOf(maxRate));
        targCalc.setText(String.valueOf(targetRateLow));
        targCalc2.setText(String.valueOf(targetRateHigh));

    }

    private TextWatcher ageTxListener = new TextWatcher()
    {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {

            try
            {
                age = Integer.parseInt(s.toString());
                mxCalc.setVisibility(View.VISIBLE);
                targCalc.setVisibility(View.VISIBLE);
                targCalc2.setVisibility(View.VISIBLE);

            }
            catch(NumberFormatException e)
            {
                age = 0;
            }

            update();

        }

        @Override
        public void afterTextChanged(Editable s) {

        }

    };




}
