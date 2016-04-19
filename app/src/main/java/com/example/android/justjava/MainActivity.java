package com.example.android.justjava;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

/**
 * This app displays an order form to order coffee.
 */
public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    int quantity = 0;
    private EditText editText;

    /**
     * This method is called when the order button is clicked.
     */
    public void submitOrder(View view) {
        // Checkbox for whip cream
        CheckBox checkBoxChecked = (CheckBox)findViewById(R.id.checkBox);
        boolean hasWhippedCream = checkBoxChecked.isChecked();

        // Checkbox for chocolate
        CheckBox chocolateCheckBox = (CheckBox)findViewById(R.id.chocolateCheckBox2);
        boolean hasChocolate = chocolateCheckBox.isChecked();

        editText = (EditText)findViewById(R.id.nameField);
        editText.getText();

        int price = calculatePrice();
        displayMessage(createOrderSummary(price, hasWhippedCream, hasChocolate));

    }

    public void incrementOrder(View view) {
        quantity = quantity + 1;
        display(quantity);
    }

    public void decrementOrder(View view) {
        quantity = quantity - 1;
        display(quantity);
    }

    /**
     * This method displays the given quantity value on the screen.
     */
    private void display(int number) {
        TextView quantityTextView = (TextView) findViewById(
                R.id.quantity_text_view);
        quantityTextView.setText("" + number);
    }

    /**
     * Calculates the price of the order.
     *
     * @param
     */
    private int calculatePrice() {
        return quantity * 5;
    }

    /**
     * This method displays the given text on the screen.
     */
    private void displayMessage(String message) {
        TextView orderSummaryTextView = (TextView) findViewById(R.id.order_summary_text_view);
        orderSummaryTextView.setText(message);
    }

    private String createOrderSummary(int totalPrice, boolean btn, boolean hasChocolate) {
        String name = "Name: Shawn Murray";
        name += "\nQuantity: " + quantity;
        name += "\nAdd chocolate: " + hasChocolate;
        name += "\nWhip Cream Added: " + btn;
        name += "\nTotal: $" + totalPrice;
        name += "\nThank You!";
        return name;
    }
}
