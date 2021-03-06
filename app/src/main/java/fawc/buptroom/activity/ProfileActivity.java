package fawc.buptroom.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.widget.Toolbar;
import androidx.appcompat.app.AppCompatActivity;
import fawc.buptroom.R;


public class ProfileActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.profile);
        Toolbar toolbar = findViewById(R.id.toolbar_profile);
        toolbar.setTitle("个人首页");
        Intent intent = getIntent();
        int startCounts = intent.getIntExtra("StartCounts", 1);
        Button startCountsBtn = findViewById(R.id.startcountsbt);
        startCountsBtn.setText(String.format("%s%s", getString(R.string.usetimes), startCounts));
        setSupportActionBar(toolbar);
        toolbar.setNavigationIcon(R.drawable.arrow_back);
        toolbar.setNavigationOnClickListener(view -> finish());
    }
}
