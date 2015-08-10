package com.example.dgonzalez.recyclerviewtest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private List<Person> persons;

    private void initializeData(){
        persons = new ArrayList<>();
        persons.add(new Person("Emma Wilson Emma Wilson", "23 years old", R.mipmap.ic_launcher));
        persons.add(new Person("L M", "25 years old", R.mipmap.ic_launcher));
        persons.add(new Person("Lillie", "35", R.mipmap.ic_launcher));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initializeData();

        RecyclerView rv = (RecyclerView)findViewById(R.id.rv);
        rv.setHasFixedSize(true);
        StaggeredGridLayoutManager llm = new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL);
        rv.setLayoutManager(llm);
        RVAdapter adapter = new RVAdapter(persons);
        rv.setAdapter(adapter);

        rv.addOnItemTouchListener(new RecyclerItemClickListener(this, rv, new RecyclerItemClickListener.OnItemClickListener()
        {
            @Override
            public void onItemClick(View view, int position)
            {
                Toast.makeText(view.getContext(), persons.get(position).name,Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onItemLongClick(View view, int position)
            {
                Toast.makeText(view.getContext(), "LONG LONG LONG",Toast.LENGTH_SHORT).show();
            }
        }));
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
