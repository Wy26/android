package com.example.calculator;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity{
    Button bn1;
    Button bn2;
    Button bn3;
    Button bn0;
    Button bnEq;
    Button bn6;
    Button bn7;
    Button bnMu;
    Button bnSub;
    Button bnAdd;
    Button bn4;
    Button bn5;
    Button bn8;
    Button bn9;
    Button bnL;
    Button bnR;
    Button bnCE;
    Button bnD;
    Button bnCos;
    Button bnSin;
    Button bnDiv;
    Button bnB;
    Button bnC;
    Button bnd;
    Button bnE;
    Button bnF;
    Button bn_ten_two;
    Button bn_ten_eight;
    Button bn_ten_sixteen;
    Button bn_two_ten;
    Button bn_eight_ten;
    Button bn_sixteen_ten;
    Button bnPo;
    Button bnSc;
    Button bnPow;
    Button bnUnit;
    Button bnTan;
    Button bnA;
    Button bn_eight_two;
    Button bn_eight_sixteen;
    Button bn_two_eight;
    Button bn_two_sixteen;
    Button bn_sixteen_two;
    Button bn_sixteen_eight;
    Button bnln;
    TextView tv;
    boolean clear;

    private StringBuilder pending = new StringBuilder();//存储所有输入
    private int FLAG =0;   //这个是用于二次计算的标记

    /*private int FLAG2 = 0;  //这个是检测括号输入的标记 输入一个左括号+1 输入一个右括号-1
    //要注意的就是要是有删除、清空、计算结果时要改变这个的值*/


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bn1=(Button)findViewById(R.id.button1);
        bn2=(Button)findViewById(R.id.button2);
        bn3=(Button)findViewById(R.id.button3);
        bn0=(Button)findViewById(R.id.button0);
        bnEq=(Button)findViewById(R.id.buttonEq);
        bn6=(Button)findViewById(R.id.button6);
        bn7=(Button)findViewById(R.id.button7);
        bnMu=(Button)findViewById(R.id.buttonMu);
        bnSub=(Button)findViewById(R.id.buttonSub);
        bnAdd=(Button)findViewById(R.id.buttonAdd);
        bn4=(Button)findViewById(R.id.button4);
        bn5=(Button)findViewById(R.id.button5);
        bn8=(Button)findViewById(R.id.button8);
        bn9=(Button)findViewById(R.id.button9);
        bnB=(Button)findViewById(R.id.buttonB);
        bnC=(Button)findViewById(R.id.buttonC);
        bnd=(Button)findViewById(R.id.buttond);
        bnE=(Button)findViewById(R.id.buttonE);
        bnF=(Button)findViewById(R.id.buttonF);
        bnCE=(Button)findViewById(R.id.buttonCE);
        bnD=(Button)findViewById(R.id.buttonD);
        bnL=(Button)findViewById(R.id.buttonLeft);
        bnR=(Button)findViewById(R.id.buttonRight);
        bnPo=(Button)findViewById(R.id.buttonPo);
        bnSin=(Button)findViewById(R.id.buttonSin);
        bnCos=(Button)findViewById(R.id.buttonCos);
        bnSc=(Button)findViewById(R.id.buttonSc);
        bnPow=(Button)findViewById(R.id.buttonPow);
        bnDiv=(Button)findViewById(R.id.buttonDiv);
        bnUnit=(Button)findViewById(R.id.buttonUnit);
        bnTan=(Button)findViewById(R.id.buttonTan);
        bnln=(Button)findViewById(R.id.buttonln);
        bnA=(Button)findViewById(R.id.buttonA);
        bn_ten_two=(Button)findViewById(R.id.button_ten_two);
        bn_ten_eight=(Button)findViewById(R.id.button_ten_eight);
        bn_ten_sixteen=(Button)findViewById(R.id.button_ten_sixteen);
        bn_two_ten=(Button)findViewById(R.id.button_two_ten);
        bn_eight_ten=(Button)findViewById(R.id.button_eight_ten);
        bn_sixteen_ten=(Button)findViewById(R.id.button_sixteen_ten);
        bn_two_eight=(Button)findViewById(R.id.button_two_eight);
        bn_two_sixteen=(Button)findViewById(R.id.button_two_sixteen);
        bn_eight_sixteen=(Button)findViewById(R.id.button_eight_sixteen);
        bn_eight_two=(Button)findViewById(R.id.button_eight_two);
        bn_sixteen_eight=(Button)findViewById(R.id.button_sixteen_eight);
        bn_sixteen_two=(Button)findViewById(R.id.button_sixteen_two);
        tv=(TextView)findViewById(R.id.textview);


        bn0.setOnClickListener(new myButton());
        bn1.setOnClickListener(new myButton());
        bn2.setOnClickListener(new myButton());
        bn3.setOnClickListener(new myButton());
        bn4.setOnClickListener(new myButton());
        bn5.setOnClickListener(new myButton());
        bn6.setOnClickListener(new myButton());
        bn7.setOnClickListener(new myButton());
        bn8.setOnClickListener(new myButton());
        bn9.setOnClickListener(new myButton());
        bnEq.setOnClickListener(new myButton());
        bnD.setOnClickListener(new myButton());
        bnL.setOnClickListener(new myButton());
        bnR.setOnClickListener(new myButton());
        bnMu.setOnClickListener(new myButton());
        bnSub.setOnClickListener(new myButton());
        bnAdd.setOnClickListener(new myButton());
        bnCE.setOnClickListener(new myButton());
        bnD.setOnClickListener(new myButton());
        bnPo.setOnClickListener(new myButton());
        bnSin.setOnClickListener(new myButton());
        bnCos.setOnClickListener(new myButton());
        bnSc.setOnClickListener(new myButton());
        bnPow.setOnClickListener(new myButton());
        bnDiv.setOnClickListener(new myButton());
        bnUnit.setOnClickListener(new myButton());
        bnTan.setOnClickListener(new myButton());
        bnln.setOnClickListener(new myButton());
        bnA.setOnClickListener(new myButton());
        bnB.setOnClickListener(new myButton());
        bnC.setOnClickListener(new myButton());
        bnd.setOnClickListener(new myButton());
        bnE.setOnClickListener(new myButton());
        bnF.setOnClickListener(new myButton());
        bn_ten_sixteen.setOnClickListener(new myButton());
        bn_ten_eight.setOnClickListener(new myButton());
        bn_ten_two.setOnClickListener(new myButton());
        bn_two_ten.setOnClickListener(new myButton());
        bn_eight_ten.setOnClickListener(new myButton());
        bn_sixteen_ten.setOnClickListener(new myButton());
        bn_two_sixteen.setOnClickListener(new myButton());
        bn_two_eight.setOnClickListener(new myButton());
        bn_sixteen_two.setOnClickListener(new myButton());
        bn_sixteen_eight.setOnClickListener(new myButton());
        bn_eight_two.setOnClickListener(new myButton());
        bn_eight_sixteen.setOnClickListener(new myButton());
    }
    private class myButton implements View.OnClickListener{
        public void onClick(View v){

            String str=(String)tv.getText();

            switch(v.getId()){
                case R.id.button1:
                    changeFlag();
                    if (haveBrac()) break;// 数字不能加在右括号后面，下同
                    pending=pending.append("1");
                    tv.setText(pending);
                    break;
                case R.id.button2:
                    changeFlag();
                    if (haveBrac()) break;
                    pending=pending.append("2");
                    tv.setText(pending);
                    break;
                case R.id.button3:
                    changeFlag();
                    if (haveBrac()) break;
                    pending=pending.append("3");
                    tv.setText(pending);
                    break;
                case R.id.button0:
                    changeFlag();
                    if (pending.length()==0) {
                        tv.setText("0"); //这个是用于处理不断输入0的时候屏幕上会一直显示0的问题
                    } else {
                        pending.append("0"); //如果长度不为零那么就显示0 并加在sb后面
                        tv.setText(pending);
                    }
                    if (haveBrac()) break;
                    break;
                    /*pending=pending.append("0");
                    tv.setText(pending);
                    break;*/
                case R.id.button4:
                    if (haveBrac()) break;
                    pending=pending.append("4");
                    tv.setText(pending);
                    break;
                case R.id.button5:
                    if (haveBrac()) break;
                    pending=pending.append("5");
                    tv.setText(pending);
                    break;
                case R.id.button6:
                    if (haveBrac()) break;
                    pending=pending.append("6");
                    tv.setText(pending);
                    break;
                case R.id.button7:
                    if (haveBrac()) break;
                    pending=pending.append("7");
                    tv.setText(pending);
                    break;
                case R.id.button8:
                    if (haveBrac()) break;
                    pending=pending.append("8");
                    tv.setText(pending);
                    break;
                case R.id.button9:
                    if (haveBrac()) break;
                    pending=pending.append("9");
                    tv.setText(pending);
                    break;
                case R.id.buttonAdd:
                    changeFlagByMethod();   //计算完一次后 会改变FLAG的值
                    // 当再次输入运算符号时会改变这个标记的值
                    if (pending.length() == 0)//无数时不显示加号
                        break;
                    String s=pending.substring(pending.length()-1,pending.length());
                    if (couldAdd(s)) {      //还是检测能不能添加这个 小数点
                        pending.delete(pending.length() - 1, pending.length());
                    }
                    if (s.equals("("))      //加号不能加在左括号后面
                        break;

                    pending=pending.append("+");
                    tv.setText(pending);
                    break;
                case R.id.buttonCE:
                    /*clear=false;
                    str="";*/
                    //FLAG2 = 0;//清空字符串缓冲区
                    pending=pending.delete(0,pending.length());
                    tv.setText("");
                    break;
                case R.id.buttonD:
                    char c = pending.charAt(pending.length() - 1);
                    //if (c == ')') FLAG2++;  //这里要注意 如果遇到删除左右括号要改变标记的值
                    //if (c == '(') FLAG2--;
                    if(pending.length()!=0)
                    {
                        pending=pending.delete(pending.length()-1,pending.length());
                        tv.setText(pending);
                    }
                    break;
                case R.id.buttonDiv:
                    changeFlagByMethod();
                    if (pending.length() == 0)
                        break;
                    s = pending.substring(pending.length() - 1, pending.length());
                    if (couldAdd(s)) {      //还是检测能不能添加这个 小数点
                        pending.delete(pending.length() - 1, pending.length());
                    }
                    if (s.equals("("))
                        break;
                    if (pending.length() == 0)
                        break;
                    pending=pending.append("/");
                    tv.setText(pending);
                    break;
                case R.id.buttonEq:
                    //FLAG2 = 0;
                    //getResult();
                    FLAG = 1;   //这个这个是用于下次计算的标记
                    String end = jisuan.dealEquation(jisuan.toSuffix(pending));
                    //这个是将中缀表达式转为后缀表达式 并求值
                    pending.delete(0, pending.length()); //清空字符串缓冲
                    pending.append(end); //把结果添加到字符串缓冲
                    tv.setText(end);
                    break;
                case R.id.buttonMu:
                    changeFlagByMethod();
                    if (pending.length() == 0)
                        break;
                    s = pending.substring(pending.length() - 1, pending.length());
                    if (couldAdd(s)) {      //还是检测能不能添加这个 小数点
                        pending.delete(pending.length() - 1, pending.length());
                    }
                    if (s.equals("("))
                        break;
                    if (pending.length() == 0)
                        break;
                    pending=pending.append("×");
                    tv.setText(pending);
                    break;
                case R.id.buttonPo:
                    /*if(clear){
                        clear=false;
                        str="";
                        tv.setText("");
                    }*/
                    //tv.setText(str+" "+((Button)v).getText()+" ");
                    if (pending.length() == 0) {     //如果这个长度为0 而且还直接输入了. 那么就直接变为0.
                        pending.append("0.");
                        tv.setText(pending);
                        break;
                    }
                    if (havePoint())        //这个是检测如果输入了一个小数 那么就不能再输入小数点了
                        break;
                    pending=pending.append(".");
                    tv.setText(pending);
                    break;
                case R.id.buttonSub:
                    changeFlagByMethod();
                    if (pending.length() == 0) {
                        pending.append("-");
                        break;
                    }
                    s = pending.substring(pending.length() - 1, pending.length());
                    if (couldAdd(s)) {      //还是检测能不能添加这个 小数点
                        pending.delete(pending.length() - 1, pending.length());
                    }
                    if (s.equals("("))
                        break;

                    pending=pending.append("-");
                    tv.setText(pending);
                    break;
                case R.id.buttonLeft:
                    //FLAG2++;
                    pending=pending.append("(");
                    tv.setText(pending);
                    break;
                case R.id.buttonRight:
                    //FLAG2--;
                    pending=pending.append(")");
                    tv.setText(pending);
                    break;
                case R.id.button_ten_two://二进制转换
                    int a=Integer.parseInt(str);
                    tv.setText(Integer.toBinaryString(a)+"");
                    pending=pending.delete(0,pending.length());
                    break;
                case R.id.button_ten_eight://八进制
                    int b=Integer.parseInt(str);
                    tv.setText(Integer.toOctalString(b)+"");
                    pending=pending.delete(0,pending.length());
                    break;
                case R.id.button_ten_sixteen://十六进制
                    int u=Integer.valueOf(str).intValue();
                    tv.setText(Integer.toHexString(u)+"");
                    pending=pending.delete(0,pending.length());
                    break;
                case R.id.button_two_ten:
                    int q=Integer.parseInt(str,2);
                    String aa=q+"";
                    tv.setText(aa);
                    pending=pending.delete(0,pending.length());
                    break;
                case R.id.button_eight_ten:
                    tv.setText(Integer.parseInt(str,8)+"");
                    pending=pending.delete(0,pending.length());
                    break;
                case R.id.button_sixteen_ten:
                    tv.setText(Integer.parseInt(str,16)+"");
                    pending=pending.delete(0,pending.length());
                    break;
                case R.id.buttonSin:
                    FLAG = 1;
                    double n=Double.valueOf(str.toString());
                    double w = Math.toRadians(n);
                    double k=Math.sin(w);
                    String t=String.format("%.2f", k);
                    tv.setText(t);
                    pending=pending.delete(0,pending.length());
                    break;
                case R.id.buttonCos:
                    double o=Double.valueOf(str.toString());
                    double m=Math.toRadians(o);
                    double l=Math.cos(m);
                    String y=String.format("%.2f",l);
                    tv.setText(y);
                    pending=pending.delete(0,pending.length());
                    break;
                case R.id.buttonTan:
                    double o1=Double.valueOf(str.toString());
                    double m1=Math.toRadians(o1);
                    double l1=Math.tan(m1);
                    String y1=String.format("%.2f",l1);
                    tv.setText(y1);
                    pending=pending.delete(0,pending.length());
                    break;
                case R.id.buttonSc:
                    double p=Double.valueOf(str.toString());

                    tv.setText(Math.sqrt(p)+"");
                    pending=pending.delete(0,pending.length());
                    break;
                case R.id.buttonPow:
                    changeFlagByMethod();
                    if (pending.length() == 0)
                        break;
                    pending=pending.append("^");
                    tv.setText(pending);
                    //Pow();
                    break;
                    /*String s1 = str.substring(0,str.indexOf(" "));
                    String s2 = str.substring(str.indexOf(" ")+3);
                    double a1=Double.valueOf(s1.toString());
                    double a2=Double.valueOf(s2.toString());
                    tv.setText(str+'\n'+Math.pow(a1,a2));
                    pending=pending.delete(0,pending.length());
                    break;*/
                case R.id.button_eight_sixteen:
                    String a1=Integer.parseInt(str,8)+"";
                    int u1=Integer.valueOf(a1).intValue();
                    tv.setText(Integer.toHexString(u1)+"");
                    pending=pending.delete(0,pending.length());
                    break;

                case R.id.button_eight_two:
                    String a2=Integer.parseInt(str,8)+"";
                    int a3=Integer.parseInt(a2);
                    tv.setText(Integer.toBinaryString(a3)+"");
                    pending=pending.delete(0,pending.length());
                    break;

                case R.id.button_two_eight:
                    int q1=Integer.parseInt(str,2);
                    String aa1=q1+"";
                    int b1=Integer.parseInt(aa1);
                    tv.setText(Integer.toOctalString(b1)+"");
                    pending=pending.delete(0,pending.length());
                    break;


                case R.id.button_two_sixteen:
                    int q2=Integer.parseInt(str,2);
                    String aa2=q2+"";
                    int u2=Integer.valueOf(aa2).intValue();
                    tv.setText(Integer.toHexString(u2)+"");
                    pending=pending.delete(0,pending.length());
                    break;


                case R.id.button_sixteen_eight:
                    String a4=Integer.parseInt(str,16)+"";
                    int b3=Integer.parseInt(a4);
                    tv.setText(Integer.toOctalString(b3)+"");
                    pending=pending.delete(0,pending.length());
                    break;


                case R.id.button_sixteen_two:
                    String a5=Integer.parseInt(str,16)+"";
                    int a6=Integer.parseInt(a5);
                    tv.setText(Integer.toBinaryString(a6)+"");
                    pending=pending.delete(0,pending.length());
                    break;

                case R.id.buttonln:
                    double w1=Math.log(Double.parseDouble(str));
                    tv.setText(w1+"");
                    break;

                case R.id.buttonA:
                    if (haveBrac()) break;
                    pending=pending.append("a");
                    tv.setText(pending);
                    break;

                case R.id.buttonB:
                    if (haveBrac()) break;
                    pending=pending.append("b");
                    tv.setText(pending);
                    break;

                case R.id.buttonC:
                    if (haveBrac()) break;
                    pending=pending.append("c");
                    tv.setText(pending);
                    break;

                case R.id.buttond:
                    if (haveBrac()) break;
                    pending=pending.append("d");
                    tv.setText(pending);
                    break;

                case R.id.buttonE:
                    if (haveBrac()) break;
                    pending=pending.append("e");
                    tv.setText(pending);
                    break;

                case R.id.buttonF:
                    if (haveBrac()) break;
                    pending=pending.append("f");
                    tv.setText(pending);
                    break;

               /* case R.id.buttonA:
                    if (haveBrac()) break;
                    pending=pending.append("a");
                    tv.setText(pending);
                    break;*/

                case R.id.buttonUnit:
                    final CharSequence[] items = {"长度","质量","体积","时间"};
                    AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                    builder.setTitle("单位换算")
                            .setItems(items, new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialogInterface, int i) {
                                    Intent intent = new Intent(MainActivity.this, Unit.class);
                                    switch (i){
                                        case 0:
                                            intent.putExtra("text1", "千米");
                                            intent.putExtra("text2", "米");
                                            intent.putExtra("text3", "厘米");
                                            intent.putExtra("text4", "毫米");
                                            intent.putExtra("a", 1000);
                                            intent.putExtra("a1", 100);
                                            intent.putExtra("a2", 10);

                                            break;
                                        case 1:
                                            intent.putExtra("text1", "吨");
                                            intent.putExtra("text2", "千克");
                                            intent.putExtra("text3", "克");
                                            intent.putExtra("text4", "毫克");
                                            intent.putExtra("a", 1000);
                                            intent.putExtra("a1", 1000);
                                            intent.putExtra("a2", 1000);
                                            break;
                                        case 2:
                                            intent.putExtra("text1", "立方米");
                                            intent.putExtra("text2", "立方分米");
                                            intent.putExtra("text3", "立方厘米");
                                            intent.putExtra("text4", "立方毫米");
                                            intent.putExtra("a", 1000);
                                            intent.putExtra("a1", 1000);
                                            intent.putExtra("a2", 1000);
                                            break;
                                        case 3:
                                            intent.putExtra("text1","天");
                                            intent.putExtra("text2","小时");
                                            intent.putExtra("text3","分钟");
                                            intent.putExtra("text4","秒");
                                            intent.putExtra("a",24);
                                            intent.putExtra("a1",60);
                                            intent.putExtra("a2",60);
                                            break;
                                    }
                                    Toast.makeText(MainActivity.this, "你点击了" + items[i], Toast.LENGTH_SHORT).show();
                                    startActivity(intent);
                                }
                            });
                    builder.show();
            }
        }
    }
    /*public void Pow(){
        String str=tv.getText().toString();
        String[] strs=str.split("^");
        Double[] ds=new Double[strs.length];
        for(int i=0;i<strs.length;i++){
            ds[i]=Double.valueOf(strs[i].toString());


        }
        tv.setText(str+'\n'+Math.pow(ds[0],ds[1]));
        pending=pending.delete(0,pending.length());
    }
   */

    private boolean havePoint() {//一组数不能出现多个小数点
        boolean b = false;
        int i;
        char[] c = pending.toString().toCharArray();
        for (i = c.length - 1; i >= 0 && (c[i] >= '0' && c[i] <= '9'); i--) {
        }
        if (i != -1) {
            if (c[i] == '.')
                b = true;
        }
        return b;
    }

    private boolean haveBrac() {//右括号后不能直接加数字
        char[] c = pending.toString().toCharArray();
        boolean b = false;
        if (c.length == 0)
            return b;
        if (c[c.length - 1] == ')')
            b = true;
        return b;
    }

    private void changeFlag() {
        if (FLAG == 1) {
            pending.delete(0, pending.length());
            FLAG = 0;
        }
    }

    private void changeFlagByMethod() {
        if (FLAG == 1) {
            FLAG = 0;
        }
    }

    private boolean couldAdd(String s) {
        boolean b = false;
        if (s.equals("+")) b = true;
        if (s.equals("-")) b = true;
        if (s.equals("×")) b = true;
        if (s.equals("/")) b = true;
        if (s.equals(".")) b = true;
        if (s.equals("(")) b = true;
        return b;
    }

    public boolean onCreateOptionsMenu(Menu menu){//添加菜单
        getMenuInflater().inflate(R.menu.menu,menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item) {//菜单点击事件
        switch (item.getItemId()) {
            case R.id.help:
                Toast.makeText(this, "这是帮助", Toast.LENGTH_LONG).show();
                break;
            case R.id.exit:
                Toast.makeText(this,"您已退出",Toast.LENGTH_LONG).show();
                this.finish();
                break;
        }
        return true;
    }
}
