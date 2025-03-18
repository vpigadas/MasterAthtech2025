package gr.athtech.course.list;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

import gr.athtech.course.databinding.ActivityRecyclerBinding;

public class RecyclerActivity extends AppCompatActivity {

    private ActivityRecyclerBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityRecyclerBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
    }

    @Override
    protected void onPostCreate(@Nullable Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);

        binding.recyclerView.setAdapter(new CustomAdapter(generateDummyData()));
    }

    private List<String> generateDummyData() {
        List<String> array = new ArrayList<>();
        for (int i = 0; i < 999999; i++) {
            array.add(String.valueOf(i));
        }

        return array;
    }
}