package com.evilcorp.bartosh.draggablelist;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;

import java.util.ArrayList;

import com.evilcorp.bartosh.draggablelistview.DraggableListView;
import com.evilcorp.bartosh.draggablelistview.StableArrayAdapter;


public class Main extends ActionBarActivity {

    public String[] items;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        items = getResources().getStringArray(R.array.presidents);

        ArrayList<String> list = new ArrayList<String>();
        for (int i = 0; i < items.length; ++i) {
            list.add(items[i]);
        }

        StableArrayAdapter adapter = new StableArrayAdapter(this, R.layout.item_view, R.id.textView, list);
        DraggableListView listView = (DraggableListView) findViewById(R.id.listview);

        listView.setList(list);
        listView.setAdapter(adapter);
        listView.setHandle(R.id.handle);
        listView.setChoiceMode(ListView.CHOICE_MODE_SINGLE);

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
