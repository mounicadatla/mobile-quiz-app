package com.example.mdatla1.mymobilepopquiz;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import butterknife.ButterKnife;

public class ListViewActivity extends AppCompatActivity {
    ListView lv;
    String[] tvEpisodes={"Greys Anatomy ","Arrow","Prision Break","BatMan","SuperMan", "Game Of Thrones","WonderWomen","Monk","Friends","Once upon a time","Quantico", "Avatar","Person of Interest","American Idol"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view);

        lv = (ListView) findViewById(R.id.idListView);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,tvEpisodes);
        lv.setAdapter(adapter); //Setting onClickListener on ListView
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
            @Override public void onItemClick(AdapterView<?> adapterView, View view, int i, long l)
            { Toast.makeText(getApplicationContext(),
                    "Item Clicked: "+i,Toast.LENGTH_SHORT).show(); } });

        ButterKnife.bind(this);

    }
}
