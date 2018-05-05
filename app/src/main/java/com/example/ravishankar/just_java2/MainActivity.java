package com.example.ravishankar.just_java2;
import android.content.Context;
import android.content.Intent;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.ravishankar.just_java2.R;
import com.example.ravishankar.just_java2.orderSummary;

import java.text.NumberFormat;

public class MainActivity extends AppCompatActivity {

    int cquantity = 0, equantity = 0, mquantity = 0, rquantity = 0;
    String name="";
    int price;
    boolean isfilled, iswritten;
    String message;
    Toast toast;
    public static final String EXTRA_MESSAGE = "com.example.myfirstapp.MESSAGE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("cq",cquantity);
        outState.putInt("eq",equantity);
        outState.putInt("mq",mquantity);
        outState.putInt("rq",rquantity);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        cquantity = savedInstanceState.getInt("cq");
        equantity = savedInstanceState.getInt("eq");
        mquantity = savedInstanceState.getInt("mq");
        rquantity = savedInstanceState.getInt("rq");
        display1(cquantity);
        display2(equantity);
        display3(mquantity);
        display4(rquantity);


    }

    public void increment1(View view) {
        if (cquantity < 15) {
            cquantity = cquantity + 1;
            display1(cquantity);
        } else {
            String text = "Maximum limit is 15 coffees";
            display_toasts(text);
        }
    }

    public void increment2(View view) {
        if (equantity < 15) {
            equantity = equantity + 1;
            display2(equantity);
        } else {
            String text = "Maximum limit is 15 coffees";
            display_toasts(text);
        }
    }

    public void increment3(View view) {
        if (mquantity < 15) {
            mquantity = mquantity + 1;
            display3(mquantity);
        } else {
            String text = "Maximum limit is 15 coffees";
            display_toasts(text);
        }
    }

    public void increment4(View view) {
        if (rquantity < 15) {
            rquantity = rquantity + 1;
            display4(rquantity);
        } else {

            String text = "Maximum limit is 15 coffees";
            display_toasts(text);
        }
    }

    public void decrement1(View view) {
        if (cquantity > 0) {
            cquantity = cquantity - 1;
            display1(cquantity);
        } else {
            String text = "Value cannot be less than 0";
            display_toasts(text);
        }

    }

    public void decrement2(View view) {
        if (equantity > 0) {
            equantity = equantity - 1;
            display2(equantity);
        } else {
            String text = "Value cannot be less than 0";
            display_toasts(text);
        }

    }

    public void decrement3(View view) {
        if (mquantity > 0) {
            mquantity = mquantity - 1;
            display3(mquantity);
        } else {
            String text = "Value cannot be less than 0";
            display_toasts(text);
        }

    }

    public void decrement4(View view) {
        if (rquantity > 0) {
            rquantity = rquantity - 1;
            display4(rquantity);
        } else {
            String text = "Value cannot be less than 0";
            display_toasts(text);

        }

    }

    private void display1(int number) {
        TextView textView = (TextView) findViewById(R.id.quantity_text_view1);
        textView.setText("" + number);

    }

    private void display2(int number) {
        TextView textView = (TextView) findViewById(R.id.quantity_text_view2);
        textView.setText("" + number);

    }

    private void display3(int number) {
        TextView textView = (TextView) findViewById(R.id.quantity_text_view3);
        textView.setText("" + number);

    }

    private void display4(int number) {
        TextView textView = (TextView) findViewById(R.id.quantity_text_view4);
        textView.setText("" + number);

    }

    public void checkOrder(View view) {
        CheckBox checkBox1 = (CheckBox) findViewById(R.id.chocolate_checkbox);
        boolean check_for_chocolate = checkBox1.isChecked();
        CheckBox checkBox2 = (CheckBox) findViewById(R.id.vanilla_checkbox);
        boolean check_for_vanilla = checkBox2.isChecked();
        CheckBox checkBox3 = (CheckBox) findViewById(R.id.whippedcream_checkbox);
        boolean check_for_whip = checkBox3.isChecked();
        CheckBox checkBox4 = (CheckBox) findViewById(R.id.mint_checkbox);
        boolean check_for_mint = checkBox4.isChecked();
        price = calculatePrice(check_for_chocolate, check_for_vanilla, check_for_whip, check_for_mint);
        EditText editText = (EditText) findViewById(R.id.name_field);
        name = editText.getText().toString();
        message = "Hi " + name;
        if (cquantity > 0)
            message = message + "\nNo. Of Cappuccino Ordered: " + cquantity;
        if (equantity > 0)
            message = message + "\nNo. Of Expresso Ordered: " + equantity;
        if (mquantity > 0)
            message = message + "\nNo. Of Macchiato: " + mquantity;
        if (rquantity > 0)
            message = message + "\nNo. Of Ristretto: " + rquantity;
        if (check_for_chocolate)
            message = message + "\nAdded Chocolate";
        if (check_for_vanilla)
            message = message + "\nAdded Vanilla";
        if (check_for_mint)
            message = message + "\nAdded Mint";
        if (check_for_whip)
            message = message + "\nAdded Whipped Cream";
        message = message +"\nTotal Amount is $"+price;
        displayPrice(message);
    }

    private int calculatePrice(boolean check_for_chocolate, boolean check_for_vanilla, boolean check_for_whip, boolean check_for_mint) {
        int baseprice = (cquantity * 5) + (equantity * 10) + (mquantity * 15) + (rquantity * 20);
        if (check_for_chocolate)
            baseprice = baseprice + 1;
        if (check_for_vanilla)
            baseprice = baseprice + 2;
        if (check_for_whip)
            baseprice = baseprice + 3;
        if (check_for_mint)
            baseprice = baseprice + 3;

        return baseprice;
    }

    private void displayPrice(String message) {
        EditText editText = (EditText) findViewById(R.id.name_field);
        if(editText.getText().toString().length()==0)
        {
            String mess =" Name field is empty";
            display_toasts(mess);
        }
        else {
            Intent myIntent = new Intent(MainActivity.this,
                    orderSummary.class);
            myIntent.putExtra(EXTRA_MESSAGE, message);
            startActivity(myIntent);
        }
    }



    public void display_toasts(String toast_message) {
        Context context = getApplicationContext();
        int duration = Toast.LENGTH_SHORT;

        if (toast != null) {
            toast.cancel();
        }
        toast = Toast.makeText(context, toast_message, duration);
        toast.show();

    }


}
