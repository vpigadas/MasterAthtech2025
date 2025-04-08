package gr.athtech.course.list;

import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

import gr.athtech.course.databinding.ActivityRecyclerBinding;

public class RecyclerActivity extends AppCompatActivity {

    private ActivityRecyclerBinding binding;
    private CustomListAdapter adapter = new CustomListAdapter();

    private int counter = 10;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityRecyclerBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
    }

    @Override
    protected void onPostCreate(@Nullable Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);

        binding.recyclerView.setAdapter(adapter);

        binding.recyclerBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                binding.recyclerView.setAdapter(new CustomAdapter(generateDummyData()));
                adapter.submitList(generateDummyData());
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    private List<String> generateDummyData() {
        List<String> array = new ArrayList<>();
        counter = counter + 10;
        for (int i = 0; i < counter; i++) {
            array.add(String.valueOf(i));
        }

        return array;
    }
}