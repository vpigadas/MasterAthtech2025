package gr.athtech.course.viewmodel;

import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import gr.athtech.course.databinding.ActivityViewModelBinding;
import gr.athtech.course.viewmodel.database.CourseEntity;

public class ViewModelActivity extends AppCompatActivity {

    private ActivityViewModelBinding binding;
    private CustomViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityViewModelBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        viewModel = new ViewModelProvider(this).get(CustomViewModel.class);
        viewModel.initialization(this);
    }

    @Override
    protected void onPostCreate(@Nullable Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);


        binding.viewmodelSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CourseEntity course = new CourseEntity();
                course.setName("Mobile Development");

                String timestamp = new SimpleDateFormat("dd/MM/yyyy HH::mm", Locale.getDefault()).format(new Date(System.currentTimeMillis()));
                course.setTimestamp(timestamp);

                viewModel.saveData(course);
            }
        });

        binding.viewmodelRead.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                viewModel.readData();
            }
        });
    }
}













