package com.example.vovmusic.activity;

import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.example.vovmusic.R;
import com.ms.square.android.expandabletextview.ExpandableTextView;

public class ChinhSach extends AppCompatActivity {
    private Toolbar chinhsach_toolbar;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.chinhsach);
        chinhsach_toolbar=findViewById(R.id.chinhsach_toolbar);

        setChinhsach_Toolbar();
    }
    public void setChinhsach_Toolbar(){
        setSupportActionBar(chinhsach_toolbar);
        if(getSupportActionBar()!=null){
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId())
        {
            case android.R.id.home:
                onBackPressed();
                return true;
            default:break;
        }
        return super.onOptionsItemSelected(item);
    }
}
