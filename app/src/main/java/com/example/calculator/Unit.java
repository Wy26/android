package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.os.Bundle;

public class Unit extends AppCompatActivity {
    private TextView[] textViews;   //textView表示单位名称
    private EditText[] editTexts;   //editText用来输入
    private Button btDo,btClean;    //Confirm和Clean两个button

    private int a = 0;
    private int a1 = 0;
    private int a2 = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.unit);

        final Intent intent = getIntent();
        textViews = new TextView[4];
        editTexts = new EditText[4];
        btDo = (Button)findViewById(R.id.buttonDo);
        btClean = (Button)findViewById(R.id.buttonClean);

        textViews[0] = (TextView)findViewById(R.id.text1);
        textViews[0].setText(intent.getStringExtra("text1"));
        textViews[1] = (TextView)findViewById(R.id.text2);
        textViews[1].setText(intent.getStringExtra("text2"));
        textViews[2] = (TextView)findViewById(R.id.text3);
        textViews[2].setText(intent.getStringExtra("text3"));
        textViews[3] = (TextView)findViewById(R.id.text4);
        textViews[3].setText(intent.getStringExtra("text4"));

        editTexts[0] = (EditText)findViewById(R.id.edit1);
        editTexts[1] = (EditText)findViewById(R.id.edit2);
        editTexts[2] = (EditText)findViewById(R.id.edit3);
        editTexts[3] = (EditText)findViewById(R.id.edit4);

        a = intent.getIntExtra("a", 0);
        a1 = intent.getIntExtra("a1", 0);
        a2 = intent.getIntExtra("a2", 0);

        btDo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int num = -1;
                for(int i=0; i<editTexts.length; i++){
                    //确定在第几行输入
                    if(!editTexts[i].getText().toString().equals("")){
                        num = i;
                        break;
                    }
                }
                String input = editTexts[num].getText().toString();
                if (!input.matches("[0-9]{1,}")) {
                    Toast.makeText(Unit.this, "Please input correctly!", Toast.LENGTH_SHORT).show();
                }
                else{
                    double d = Double.parseDouble(input);
                    if(num != -1 && a != 0){
                        switch (num){
                            case 0:
                                editTexts[1].setText((d * a) + "");
                                editTexts[2].setText((d * a * a1) + "");
                                editTexts[3].setText((d * a * a1 * a2) + "");
                                break;
                            case 1:
                                editTexts[0].setText((d / a) + "");
                                editTexts[2].setText((d * a1 ) + "");
                                editTexts[3].setText((d * a1 * a2) + "");
                                break;
                            case 2:
                                editTexts[0].setText((d / (a * a1)) + "");
                                editTexts[1].setText((d / a1 ) + "");
                                editTexts[3].setText((d * a2 ) + "");
                                break;
                            case 3:
                                editTexts[0].setText((d / (a * a1 * a2)) + "");
                                editTexts[1].setText((d / (a1 * a2)) + "");
                                editTexts[2].setText((d / a2 ) + "");
                                break;
                        }
                    }
                }
            }
        });

        btClean.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                for(int i=0; i<editTexts.length; i++){
                    editTexts[i].setText("");
                }
            }
        });
    }
}
