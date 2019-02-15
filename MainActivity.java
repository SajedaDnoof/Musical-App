package com.example.sajeda.musical;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView liseView = (ListView) findViewById(R.id.listView);
        CustomAdapter customAdapter = new CustomAdapter();
        liseView.setAdapter(customAdapter);
        liseView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent i = new Intent(MainActivity.this, Main2Activity.class);
                i.putExtra("position",position);
                startActivity(i);
            }
        });


    }

    class CustomAdapter extends BaseAdapter {

        @Override
        public int getCount() {
            return Songs.getSongs().size();
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {
            view = getLayoutInflater().inflate(R.layout.customlayout, null);
            TextView artist = (TextView) view.findViewById(R.id.artist);
            TextView song = (TextView) view.findViewById(R.id.song);
            TextView year = (TextView) view.findViewById(R.id.year);

            artist.setText(Songs.getSongs().get(i).getArtistname());
            song.setText(Songs.getSongs().get(i).getSongname());
            year.setText(Songs.getSongs().get(i).getYear() + "");
            return view;
        }
    }
}
