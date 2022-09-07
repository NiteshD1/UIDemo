package com.upwards.uidemo;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.upwards.uidemo.adapters.RecyclerViewAdapter;
import com.upwards.uidemo.databinding.ActivityViewDemoBinding;
import com.upwards.uidemo.models.Person;

import java.util.ArrayList;
import java.util.List;

public class ViewDemoActivity extends AppCompatActivity {

    ActivityViewDemoBinding binding;
    String[] countryArray = {"India","USA","Germany","Africa","Iran","China","Pakistan"};
    List<Person> personList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityViewDemoBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        setupListView();
        setupRecyclerView();
    }

    private void setupRecyclerView() {

        personList = new ArrayList<Person>();
        personList.add(new Person("Nitesh yadav","22/01/2000",R.drawable.profile_1));
        personList.add(new Person("Harish yadav","22/01/2000",R.drawable.profile_2));
        personList.add(new Person("Jon yadav","22/01/2000",R.drawable.profile_3));
        personList.add(new Person("Ram yadav","22/01/2000",R.drawable.profile_4));
        personList.add(new Person("Nitesh yadav","22/01/2000",R.drawable.profile_5));
        personList.add(new Person("Sandeep yadav","22/01/2000",R.drawable.profile_6));
        personList.add(new Person("Deepak yadav","22/01/2000",R.drawable.profile_2));
        personList.add(new Person("Jan yadav","22/01/2000",R.drawable.profile_1));
        personList.add(new Person("Jon yadav","22/01/2000",R.drawable.profile_3));
        personList.add(new Person("Harish yadav","22/01/2000",R.drawable.profile_1));

        RecyclerViewAdapter adapter = new RecyclerViewAdapter(personList);
        binding.recyclerView.setHasFixedSize(true);
        binding.recyclerView.setLayoutManager(new LinearLayoutManager(this));
        binding.recyclerView.setAdapter(adapter);
    }

    private void setupListView() {
        String[] resourceCountryArray = getResources().getStringArray(R.array.resource_array_country);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,R.layout.single_list_item,resourceCountryArray);

        binding.listView.setAdapter(adapter);

        binding.listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                String item = adapter.getItem(position);
                showToast(item);
            }
        });

    }

    private void showToast(String s) {
        Toast.makeText(getApplicationContext(),s, Toast.LENGTH_SHORT).show();
    }

}