package com.example.yangyaochia.mycalculator;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.TextView;


public class MyCalculatorActivity extends AppCompatActivity {

    private TextView textView01;

    private Button button0c; // reset C
    private Button button0s; // signed
    private Button button0p;
    private Button button0percent;

    private double result;
    private boolean plusEvent;
    private boolean minusEvent;
    private boolean mulEvent;
    private boolean divideEvent;
    private boolean firstTimeEnterEvent;


    private Button button0plus; // plus
    private Button button0minus; // minus
    private Button button0mul;
    private Button button0divide; //
    private Button button0equal;

    private Button button00;
    private Button button01;
    private Button button02;
    private Button button03;
    private Button button04;
    private Button button05;
    private Button button06;
    private Button button07;
    private Button button08;
    private Button button09;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_calculator);

        textView01 = (TextView)findViewById(R.id.textView);

        button0c = (Button)findViewById(R.id.buttonc);
        button0s = (Button)findViewById(R.id.buttons);
        button0p = (Button)findViewById(R.id.buttonp);
        button0percent = (Button)findViewById(R.id.buttonpercent);

        result = 0;
        plusEvent = false;
        minusEvent = false;
        mulEvent = false;
        divideEvent = false;
        firstTimeEnterEvent = false;

        button0plus = (Button)findViewById(R.id.buttonplus);
        button0minus = (Button)findViewById(R.id.buttonminus);
        button0mul = (Button)findViewById(R.id.buttonmul);
        button0divide = (Button)findViewById(R.id.buttondivide);
        button0equal = (Button)findViewById(R.id.buttonequal);

        button00 = (Button)findViewById(R.id.button0);
        button01 = (Button)findViewById(R.id.button1);
        button02 = (Button)findViewById(R.id.button2);
        button03 = (Button)findViewById(R.id.button3);
        button04 = (Button)findViewById(R.id.button4);
        button05 = (Button)findViewById(R.id.button5);
        button06 = (Button)findViewById(R.id.button6);
        button07 = (Button)findViewById(R.id.button7);
        button08 = (Button)findViewById(R.id.button8);
        button09 = (Button)findViewById(R.id.button9);

        button0c.setOnClickListener(new Button.OnClickListener(){

            @Override

            public void onClick(View v) {

                // TODO Auto-generated method stub
                result = 0;
                textView01.setText("0");

            }
        });
        button0s.setOnClickListener(new Button.OnClickListener(){

            @Override

            public void onClick(View v) {

                // TODO Auto-generated method stub

                //textView01.setText( toString(-1 * Integer.valueOf(textView01.getText())) );
                String origin = textView01.getText().toString();
                double temp = -1 * Double.valueOf(origin);

                if (( temp == Math.floor(temp)))
                {
                    int intTemp = (int) temp;
                    textView01.setText(String.valueOf(intTemp));
                }
                else
                    textView01.setText(Double.toString(temp) );

            }
        });



        button0p.setOnClickListener(new Button.OnClickListener(){

            @Override

            public void onClick(View v) {

                // TODO Auto-generated method stub


                String origin = textView01.getText().toString();
                String after = origin.concat(".");
                textView01.setText(after);

            }
        });

        button0percent.setOnClickListener(new Button.OnClickListener(){

            @Override

            public void onClick(View v) {

                // TODO Auto-generated method stub

                String origin = textView01.getText().toString();
                double temp = Double.valueOf(origin) / 100;

                String[] splitter = String.valueOf(temp).split("\\.");

                if ((temp == Math.floor(temp)))
                {
                    int intTemp = (int) temp;
                    textView01.setText(String.valueOf(intTemp));
                }
                else if ( splitter[1].length() > 5 )
                {
                    textView01.setText(String.format("%.5g%n", temp));
                }
                else
                    textView01.setText(String.valueOf(temp));

            }
        });

        button0plus.setOnClickListener(new Button.OnClickListener(){

            @Override

            public void onClick(View v) {

                // TODO Auto-generated method stub

                String origin = textView01.getText().toString();
                result  += Double.valueOf(origin);
                plusEvent = true;
                firstTimeEnterEvent = true;

            }
        });

        button0minus.setOnClickListener(new Button.OnClickListener(){

            @Override

            public void onClick(View v) {

                // TODO Auto-generated method stub

                String origin = textView01.getText().toString();
                result  += Double.valueOf(origin);
                minusEvent = true;
                firstTimeEnterEvent = true;

            }
        });

        button0mul.setOnClickListener(new Button.OnClickListener(){

            @Override

            public void onClick(View v) {

                // TODO Auto-generated method stub
                String origin = textView01.getText().toString();
                result  += Double.valueOf(origin);
                mulEvent = true;
                firstTimeEnterEvent = true;

            }
        });

        button0divide.setOnClickListener(new Button.OnClickListener(){

            @Override

            public void onClick(View v) {

                // TODO Auto-generated method stub

                String origin = textView01.getText().toString();
                result  += Double.valueOf(origin);
                divideEvent = true;
                firstTimeEnterEvent = true;

            }
        });

        button0equal.setOnClickListener(new Button.OnClickListener(){

            @Override

            public void onClick(View v) {

                // TODO Auto-generated method stub

                //textView01.setText( toString(-1 * Integer.valueOf(textView01.getText())) );

                if (plusEvent)
                {
                    String origin = textView01.getText().toString();
                    result  += Double.valueOf(origin);
                    plusEvent = false;
                }
                else if (minusEvent)
                {
                    String origin = textView01.getText().toString();
                    result  -= Double.valueOf(origin);
                    minusEvent = false;
                }
                else if (mulEvent)
                {
                    String origin = textView01.getText().toString();
                    result  *= Double.valueOf(origin);
                    mulEvent = false;
                }
                else if (divideEvent)
                {
                    String origin = textView01.getText().toString();
                    result  /= Double.valueOf(origin);
                    divideEvent = false;
                }

                String[] splitter = String.valueOf(result).split("\\.");

                if ((result == Math.floor(result)))
                {
                    int temp = (int) result;
                    textView01.setText(String.valueOf(temp));
                }
                else if ( splitter[1].length() > 5 )
                {
                    textView01.setText(String.format("%.5g%n", result));
                }
                else
                    textView01.setText(String.valueOf(result));

                result = 0;

            }
        });


        button00.setOnClickListener(new Button.OnClickListener(){

            @Override

            public void onClick(View v) {

                // TODO Auto-generated method stub

                String origin = textView01.getText().toString();
                String last = origin.substring(origin.length()-1);

                if ( (plusEvent || minusEvent || mulEvent || divideEvent) && firstTimeEnterEvent )
                {
                    textView01.setText(button00.getText().toString());
                    firstTimeEnterEvent = false;
                }
                else if ( last.equals("0") && origin.length()  == 1  )
                    textView01.setText(button00.getText().toString());
                else if ( origin.length() < 10)
                {
                    String after = origin.concat(button00.getText().toString());
                    textView01.setText(after);
                }
            }
        });

        button01.setOnClickListener(new Button.OnClickListener(){

            @Override

            public void onClick(View v) {

                // TODO Auto-generated method stub
                String origin = textView01.getText().toString();
                String last = origin.substring(origin.length()-1);

                if ( (plusEvent || minusEvent || mulEvent || divideEvent) && firstTimeEnterEvent )
                {
                    textView01.setText(button01.getText().toString());
                    firstTimeEnterEvent = false;
                }
                else if ( last.equals("0") && origin.length() == 1  )
                    textView01.setText(button01.getText().toString());
                else if ( origin.length() < 10)
                {
                    String after = origin.concat(button01.getText().toString());
                    textView01.setText(after);
                }

            }
        });
        button02.setOnClickListener(new Button.OnClickListener(){

            @Override

            public void onClick(View v) {

                // TODO Auto-generated method stub
                String origin = textView01.getText().toString();
                String last = origin.substring(origin.length()-1);

                if ( (plusEvent || minusEvent || mulEvent || divideEvent) && firstTimeEnterEvent )
                {
                    textView01.setText(button02.getText().toString());
                    firstTimeEnterEvent = false;
                }
                else if ( last.equals("0") && origin.length()  == 1  )
                    textView01.setText(button02.getText().toString());
                else if ( origin.length() < 10)
                {
                    String after = origin.concat(button02.getText().toString());
                    textView01.setText(after);
                }


            }
        });
        button03.setOnClickListener(new Button.OnClickListener(){

            @Override

            public void onClick(View v) {

                // TODO Auto-generated method stub

                String origin = textView01.getText().toString();
                String last = origin.substring(origin.length()-1);

                if ( (plusEvent || minusEvent || mulEvent || divideEvent) && firstTimeEnterEvent )
                {
                    textView01.setText(button03.getText().toString());
                    firstTimeEnterEvent = false;
                }
                else if ( last.equals("0") && origin.length()  == 1  )
                    textView01.setText(button03.getText().toString());
                else if ( origin.length() < 10)
                {
                    String after = origin.concat(button03.getText().toString());
                    textView01.setText(after);
                }


            }
        });
        button04.setOnClickListener(new Button.OnClickListener(){

            @Override

            public void onClick(View v) {

                // TODO Auto-generated method stub

                String origin = textView01.getText().toString();
                String last = origin.substring(origin.length()-1);

                if ( (plusEvent || minusEvent || mulEvent || divideEvent) && firstTimeEnterEvent )
                {
                    textView01.setText(button04.getText().toString());
                    firstTimeEnterEvent = false;
                }
                else if ( last.equals("0") && origin.length() == 1  )
                    textView01.setText(button04.getText().toString());
                else if ( origin.length() < 10)
                {
                    String after = origin.concat(button04.getText().toString());
                    textView01.setText(after);
                }


            }
        });
        button05.setOnClickListener(new Button.OnClickListener(){

            @Override

            public void onClick(View v) {

                // TODO Auto-generated method stub

                String origin = textView01.getText().toString();
                String last = origin.substring(origin.length()-1);

                if ( (plusEvent || minusEvent || mulEvent || divideEvent) && firstTimeEnterEvent )
                {
                    textView01.setText(button05.getText().toString());
                    firstTimeEnterEvent = false;
                }
                else if ( last.equals("0") && origin.length()  == 1 )
                    textView01.setText(button05.getText().toString());
                else if ( origin.length() < 10)
                {
                    String after = origin.concat(button05.getText().toString());
                    textView01.setText(after);
                }


            }
        });
        button06.setOnClickListener(new Button.OnClickListener(){

            @Override

            public void onClick(View v) {

                // TODO Auto-generated method stub

                String origin = textView01.getText().toString();
                String last = origin.substring(origin.length()-1);

                if ( (plusEvent || minusEvent || mulEvent || divideEvent) && firstTimeEnterEvent )
                {
                    textView01.setText(button06.getText().toString());
                    firstTimeEnterEvent = false;
                }
                else if ( plusEvent || minusEvent || mulEvent || divideEvent && firstTimeEnterEvent )
                {
                    String after = origin.concat(button06.getText().toString());
                    textView01.setText(after);
                }
                else if ( last.equals("0") && origin.length()  == 1  )
                    textView01.setText(button06.getText().toString());
                else if ( origin.length() < 10)
                {
                    String after = origin.concat(button06.getText().toString());
                    textView01.setText(after);
                }


            }
        });
        button07.setOnClickListener(new Button.OnClickListener(){

            @Override

            public void onClick(View v) {

                // TODO Auto-generated method stub

                String origin = textView01.getText().toString();
                String last = origin.substring(origin.length()-1);

                if ( (plusEvent || minusEvent || mulEvent || divideEvent) && firstTimeEnterEvent )
                {
                    textView01.setText(button07.getText().toString());
                    firstTimeEnterEvent = false;
                }
                else if ( last.equals("0") && origin.length()  == 1  )
                    textView01.setText(button07.getText().toString());
                else if ( origin.length() < 10)
                {
                    String after = origin.concat(button07.getText().toString());
                    textView01.setText(after);
                }


            }
        });
        button08.setOnClickListener(new Button.OnClickListener(){

            @Override

            public void onClick(View v) {

                // TODO Auto-generated method stub

                String origin = textView01.getText().toString();
                String last = origin.substring(origin.length()-1);

                if ( (plusEvent || minusEvent || mulEvent || divideEvent) && firstTimeEnterEvent )
                {
                    textView01.setText(button08.getText().toString());
                    firstTimeEnterEvent = false;
                }
                else if ( last.equals("0") && origin.length()  == 1 )
                    textView01.setText(button08.getText().toString());
                else if ( origin.length() < 10)
                {
                    String after = origin.concat(button08.getText().toString());
                    textView01.setText(after);
                }


            }
        });
        button09.setOnClickListener(new Button.OnClickListener(){

            @Override

            public void onClick(View v) {

                // TODO Auto-generated method stub

                String origin = textView01.getText().toString();
                String last = origin.substring(origin.length()-1);

                if ( (plusEvent || minusEvent || mulEvent || divideEvent) && firstTimeEnterEvent )
                {
                    textView01.setText(button09.getText().toString());
                    firstTimeEnterEvent = false;
                }
                else if ( last.equals("0") && origin.length() == 1 )
                    textView01.setText(button09.getText().toString());
                else if ( origin.length() < 10)
                {
                    String after = origin.concat(button09.getText().toString());
                    textView01.setText(after);
                }


            }
        });

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        /*FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });*/
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_my_calculator, menu);
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
