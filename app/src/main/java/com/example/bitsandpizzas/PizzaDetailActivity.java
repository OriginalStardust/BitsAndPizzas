package com.example.bitsandpizzas;

import android.app.Activity;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.ShareActionProvider;
import android.widget.TextView;

public class PizzaDetailActivity extends Activity {

    private ShareActionProvider shareActionProvider;

    public static final String EXTRA_PIZZANO = "pizzaNo";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pizza_detail);

        this.getActionBar().setDisplayHomeAsUpEnabled(true);

        TextView textView = (TextView) this.findViewById(R.id.pizza_text);
        ImageView imageView = (ImageView) this.findViewById(R.id.pizza_image);
        int pizzaNo = this.getIntent().getIntExtra(this.EXTRA_PIZZANO, 0);
        String pizzaName = Pizza.pizzas[pizzaNo].getName();
        int pizzaImage = Pizza.pizzas[pizzaNo].getImageResourceId();
        Drawable drawable = ContextCompat.getDrawable(this, pizzaImage);
        textView.setText(pizzaName);
        imageView.setImageDrawable(drawable);
        imageView.setContentDescription(pizzaName);

        this.getActionBar().setTitle(pizzaName);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        this.getMenuInflater().inflate(R.menu.menu_main, menu);
        TextView textView = (TextView) this.findViewById(R.id.pizza_text);
        String pizzaName = textView.getText().toString();
        MenuItem item = menu.findItem(R.id.action_share);
        shareActionProvider = (ShareActionProvider) item.getActionProvider();
        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("text/plain");
        intent.putExtra(Intent.EXTRA_TEXT, pizzaName);
        shareActionProvider.setShareIntent(intent);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_create_order:
                Intent intent = new Intent(this, OrderActivity.class);
                this.startActivity(intent);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
