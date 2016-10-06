package helloointent.yuanzehu.cs.brandies.edu.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.content.Intent;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private String result=null;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        final Button gotoButton = (Button)findViewById(R.id.gotoConversionButton);

        final TextView resultText = (TextView)findViewById(R.id.resultText);



        final Intent i=new Intent(this, conversionUtility.class);
        gotoButton.setOnClickListener(
                new Button.OnClickListener(){
                    public void onClick(View v){
                        //go to conversion activity
                        startActivity(i);
                    }
                }

        );

        Bundle resultData = getIntent().getExtras();
        if(resultData==null){
            return;
        }else{
            result=resultData.getString("result");
            if(result!=null){
                resultText.setText("The last conversion was"+result+" miles");
            }



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

    //@Override
    //protected void onActivityResult(int requestCode, int resultCode, Intent data) {
    //    if(requestCode==REQUEST_CODE){
    //        if(resultCode==RESULT_CODE){
    //            resultText.setText(data.getData().toString());
    //        }
    //    }

    //}
}
