package mickey.ogosense.com.calculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    public double firstOperand = 0.0;
    public double secondOperand = 0.0;
    public double result = 0.0;
    public String operator = "";
    public boolean lastNumber = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClickDigit(View v) {
        Button digit = (Button) v;
        TextView display = (TextView) findViewById(R.id.textView2);
        if (lastNumber) {
            if (display.getText().equals("0")) {
                display.setText(digit.getText().toString());
            } else {
                display.setText(display.getText() + digit.getText().toString());
            }
        } else {
            display.setText(digit.getText().toString());
            lastNumber = true;
        }
    }

    public void clearDisplay(View v){
        TextView display = (TextView) findViewById(R.id.textView2);
        display.setText("0");
        operator = "";
        firstOperand = 0.0;
        secondOperand = 0.0;
    }

    public void onDelete(View v){
        TextView display = (TextView) findViewById(R.id.textView2);
        String str = display.getText().toString();
        if (display.getText().equals("0")){
            return;
        }
        if (str.length() == 1){
            display.setText("0");
        } else {
            display.setText(str.substring(0,str.length()-1));
        }
    }

    public void calculate(){
        switch(operator){

            case "+": result = firstOperand + secondOperand;
                break;
            case "-": result = firstOperand - secondOperand;
                break;
            case "/": result = firstOperand / secondOperand;
                break;
            case "X": result = firstOperand * secondOperand;
                break;
            default: result = firstOperand;
                break;
        }
    }

    public void makeSquare(View v){
        TextView display = (TextView) findViewById(R.id.textView2);
        String str = display.getText().toString();
        if (operator.equals("")){
            firstOperand = Double.parseDouble(str);
            result = firstOperand * firstOperand;
            display.setText(String.valueOf(result));
            firstOperand = result;
            secondOperand = 0.0;
            operator = "";
        } else {
            calculate();
            firstOperand = result;
            result = firstOperand * firstOperand;
            display.setText(String.valueOf(result));
            firstOperand = result;
            secondOperand = 0.0;
            operator = "";
        }
        lastNumber = false;
    }

    public void divide (View v){
        TextView display = (TextView) findViewById(R.id.textView2);
        String str = display.getText().toString();
        secondOperand = Double.parseDouble(str);
        display.setText("0");
        if(operator.equals("")){
            firstOperand = secondOperand;
            operator = "/";
            display.setText(String.valueOf(firstOperand));
        } else {
            calculate();
            display.setText(String.valueOf(result));
            firstOperand = result;
            secondOperand = 0.0;
            operator = "/";
        }
        lastNumber = false;

    }

    public void multiply (View v){
        TextView display = (TextView) findViewById(R.id.textView2);
        String str = display.getText().toString();
        if(operator.equals("")){
            firstOperand = Double.parseDouble(str);
            operator = "X";
            display.setText(String.valueOf(firstOperand));
        } else {
            secondOperand = Double.parseDouble(str);
            calculate();
            display.setText(String.valueOf(result));
            firstOperand = result;
            secondOperand = 0.0;
            operator = "X";
        }
        lastNumber = false;
    }

    public void add (View v){
        TextView display = (TextView) findViewById(R.id.textView2);
        String str = display.getText().toString();
        if(operator.equals("")){
            firstOperand = Double.parseDouble(str);
            operator = "+";
            display.setText(String.valueOf(firstOperand));
        } else {
            secondOperand = Double.parseDouble(str);
            calculate();
            display.setText(String.valueOf(result));
            firstOperand = result;
            secondOperand = 0.0;
            operator = "+";
        }
        lastNumber = false;
    }

    public void subtract (View v){
        TextView display = (TextView) findViewById(R.id.textView2);
        String str = display.getText().toString();
        if(operator.equals("")){
            firstOperand = Double.parseDouble(str);
            operator = "-";
            display.setText(String.valueOf(firstOperand));
        } else {
            secondOperand = Double.parseDouble(str);
            calculate();
            display.setText(String.valueOf(result));
            firstOperand = result;
            secondOperand = 0.0;
            operator = "-";
        }
        lastNumber = false;
    }

    public void equals (View v){
        TextView display = (TextView) findViewById(R.id.textView2);
        String str = display.getText().toString();
        if(operator.equals("")){
            firstOperand = Double.parseDouble(str);
            return;
        } else {
            secondOperand = Double.parseDouble(str);
            calculate();
            display.setText(String.valueOf(result));
            firstOperand = result;
            secondOperand = 0.0;
            operator = "";
        }
        lastNumber = false;
    }

    public void separate(View v){
        TextView display = (TextView) findViewById(R.id.textView2);
        String str = display.getText().toString();
        for (int i = 0; i < str.length(); i++){
            if(str.charAt(i)=='.'){
            return;
            }
        }
        if (lastNumber) {
            display.setText(display.getText().toString() + ".");
        } else {
            display.setText("0.");
            lastNumber = true;
        }
    }

}
