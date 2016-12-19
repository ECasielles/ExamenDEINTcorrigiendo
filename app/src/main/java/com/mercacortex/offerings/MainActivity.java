package com.mercacortex.offerings;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView txvTitle;
    Button btnOk;
    CheckBox chbHome, chbElectronics, chbSports, chbRelevant;

    public static final String HOME = "home";
    public static final String ELECTRONICS = "electronics";
    public static final String SPORTS = "sports";
    public static final String RELEVANT = "relevant";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txvTitle = (TextView) findViewById(R.id.appTitle);
        txvTitle.setTypeface(Typeface.createFromAsset(getAssets(), "gloriahallelujah.ttf"));

        chbHome=(CheckBox)findViewById(R.id.chbHomeMain);
        chbElectronics=(CheckBox) findViewById(R.id.chbElectronicsMain);
        chbSports=(CheckBox) findViewById(R.id.chbSportsMain);
        chbRelevant=(CheckBox) findViewById(R.id.chbShowRelevantMain);

        btnOk =(Button)findViewById(R.id.btnOkMain);
        btnOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(chbHome.isChecked() || chbElectronics.isChecked() || chbSports.isChecked()) {
                    Bundle arguments = new Bundle();
                    arguments.putBoolean(HOME, chbHome.isChecked());
                    arguments.putBoolean(ELECTRONICS, chbElectronics.isChecked());
                    arguments.putBoolean(SPORTS, chbSports.isChecked());
                    arguments.putBoolean(RELEVANT, chbRelevant.isChecked());

                    Intent intent = new Intent(MainActivity.this, OfferListActivity.class);
                    intent.putExtras(arguments);
                    startActivity(intent);
                } else {
                    AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                    builder.setMessage(R.string.noOfferDialog);
                    builder.show();
                }
            }
        });
    }
}
