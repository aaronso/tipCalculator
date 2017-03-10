package neverlost.tipcalculator;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.math.BigDecimal;

public class MainActivity extends AppCompatActivity {

    String bill = "";
    String temp;
    int dot = -1;
    int iTip = 15;
    int iSplit = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void on1Click(View view){
        bill+=1;
        displayBill();
    }
    public void on2Click(View view){
        bill+=2;
        displayBill();
    }
    public void on3Click(View view){
        bill+=3;
        displayBill();
    }
    public void on4Click(View view){
        bill+=4;
        displayBill();
    }
    public void on5Click(View view){
        bill+=5;
        displayBill();
    }
    public void on6Click(View view){
        bill+=6;
        displayBill();
    }
    public void on7Click(View view){
        bill+=7;
        displayBill();
    }
    public void on8Click(View view){
        bill+=8;
        displayBill();
    }
    public void on9Click(View view){
        bill+=9;
        displayBill();
    }
    public void onDotClick(View view){
        //if dot = -1 means there are no decimals
        //else cant put another
        if(dot == -1) {
            bill += ".";
            dot = (bill.length());
            displayBill();
        }
    }
    public void on0Click(View view){
        bill+=0;
        displayBill();
    }
    public void onDelClick(View view){
        //if deleting the decimal reset dot to -1
        if(dot == bill.length()){
            dot = -1;
        }

        if(bill != null && bill.length() > 0){
            bill = bill.substring(0,bill.length()-1);
        }
        displayBill();
    }
    public void onClrClick(View view){
        bill = "";
        dot = -1;
        TextView billDisplay = (TextView) findViewById(R.id.bill);
        TextView payDisplay = (TextView) findViewById(R.id.person);
        TextView costDisplay = (TextView) findViewById(R.id.total);

        billDisplay.setText(bill);
        payDisplay.setText(bill);
        costDisplay.setText(bill);
    }
    public void onSPClick(View view){
        iSplit++;
        temp = String.valueOf(iSplit);
        TextView splitDisplay = (TextView) findViewById(R.id.splitText);
        splitDisplay.setText(temp);
    }
    public void onSMClick(View view){
        if(iSplit > 1 ) {
            iSplit--;
        }
        temp = String.valueOf(iSplit);
        TextView splitDisplay = (TextView) findViewById(R.id.splitText);
        splitDisplay.setText(temp);
    }
    public void onTPClick(View view){
        iTip++;
        temp = String.valueOf(iTip);
        TextView tipDisplay = (TextView) findViewById(R.id.tipText);
        tipDisplay.setText(temp);
    }
    public void onTMClick(View view){
        if(iTip > 0) {
            iTip--;
        }
        temp = String.valueOf(iTip);
        TextView tipDisplay = (TextView) findViewById(R.id.tipText);
        tipDisplay.setText(temp);
    }
    public void onCalcClick(View view){

        float cost = Float.parseFloat(bill);

        float total = cost + cost*((float)iTip/100);

        cost = total/iSplit;

        temp = "$"+String.format("%.2f",total);
        TextView totDisplay = (TextView) findViewById(R.id.total);
        totDisplay.setText(temp);

        temp = "$"+String.format("%.2f",cost);
        TextView payDisplay = (TextView) findViewById(R.id.person);
        payDisplay.setText(temp);
    }

    //appens $ to front of string and displays
    public void displayBill(){
        String dispBill = "$"+bill;
        TextView billDisplay = (TextView) findViewById(R.id.bill);
        billDisplay.setText(dispBill);
    }

}
