package com.mercacortex.offerings;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import static com.mercacortex.offerings.MainActivity.ELECTRONICS;
import static com.mercacortex.offerings.MainActivity.HOME;
import static com.mercacortex.offerings.MainActivity.RELEVANT;
import static com.mercacortex.offerings.MainActivity.SPORTS;

public class OfferListActivity extends AppCompatActivity {

    RecyclerView rvwOffers;
    OfferAdapter adapter;
    FloatingActionButton floatingActionButton;
    static boolean showHome, showElectronics, showSports, showRelevant;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_offer_list);

        rvwOffers = (RecyclerView) findViewById(R.id.rvwOfferingsHome);
        adapter = new OfferAdapter(this, showHome, showElectronics, showSports);

        floatingActionButton = (FloatingActionButton) findViewById(R.id.fabAddHome);
        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(OfferListActivity.this, AddOfferActivity.class);
                startActivity(intent);
            }
        });

        rvwOffers.setLayoutManager(new LinearLayoutManager(this));
        rvwOffers.setAdapter(adapter);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        showHome = data.getBooleanExtra(HOME, false);
        showElectronics = data.getBooleanExtra(ELECTRONICS, false);
        showSports = data.getBooleanExtra(SPORTS, false);
        showRelevant = data.getBooleanExtra(RELEVANT, false);
    }

}
