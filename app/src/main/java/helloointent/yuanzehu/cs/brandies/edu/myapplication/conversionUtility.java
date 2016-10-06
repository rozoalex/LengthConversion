package helloointent.yuanzehu.cs.brandies.edu.myapplication;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class conversionUtility extends AppCompatActivity {


    private String result=null;

    //
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_conversion_utility);
        final Button backButton = (Button)findViewById(R.id.backButton);
        final CheckBox infoButton = (CheckBox) findViewById(R.id.checkBox) ;
        final Button clearButton = (Button)findViewById(R.id.clearBut);
        final Button convertButton = (Button)findViewById(R.id.convertButton);


        infoButton.setOnCheckedChangeListener(new CheckBox.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    TextView info = (TextView)findViewById(R.id.infoText);
                    info.setText("1 km = 0.62 miles");
                }else{
                    TextView info = (TextView)findViewById(R.id.infoText);
                    info.setText("");
                }
            }
        }); ;



        clearButton.setOnClickListener(
                new Button.OnClickListener(){
                    public void onClick(View v){
                        TextView ts = (TextView)findViewById(R.id.resultText);
                        ts.setText("");
                        result=null;
                        EditText et =(EditText)findViewById(R.id.editText);
                        et.setText("");
                        Toast ifx = Toast.makeText(getApplicationContext(), "Fields Cleared", Toast.LENGTH_SHORT);
                        ifx.show();
                    }
                }

        );

        convertButton.setOnClickListener(
                new Button.OnClickListener(){
                    public void onClick(View v){
                        EditText et = (EditText)findViewById(R.id.editText);
                        String s = et.getText().toString();


                        if(isNumber(s)){
                           result = " "+ String.valueOf(Math.round (Double.parseDouble(s)*0.62 * 100.0) / 100.0  );
                            TextView ts = (TextView)findViewById(R.id.resultText);
                            ts.setText(result);
                            Toast ifx = Toast.makeText(getApplicationContext(), "Converted Successfully", Toast.LENGTH_SHORT);
                            ifx.show();

                        }else {
                            TextView ts = (TextView)findViewById(R.id.resultText);
                            String temp = "Invalid Input";
                            if(s.isEmpty()){
                                temp="Empty Input";
                            }
                            Toast ifx = Toast.makeText(getApplicationContext(), temp, Toast.LENGTH_SHORT);
                            ifx.show();
                            et.setText("");
                            ts.setText("");
                        }
                    }

                    private boolean isNumber(String s){
                        try{
                            Double.parseDouble(s);
                        }catch (NumberFormatException e){
                            return false;
                        }
                        return true;
                    }
                }
        );






        final Intent i=new Intent(this, MainActivity.class);
        backButton.setOnClickListener(
                new Button.OnClickListener(){
                    public void onClick(View v){
                        i.putExtra("result",result);
                        startActivity(i);
                    }
                }

        );
    }




}
