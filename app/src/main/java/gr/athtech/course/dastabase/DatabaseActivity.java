package gr.athtech.course.dastabase;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import gr.athtech.course.databinding.ActivityDatabaseBinding;

public class DatabaseActivity extends AppCompatActivity {

    private ActivityDatabaseBinding binding;
    private CustomDBInstance dbInstance;

    private Executor executor = new ThreadPoolExecutor(1, 5, 10, TimeUnit.SECONDS, new LinkedBlockingQueue<Runnable>());

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityDatabaseBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

//        SharedPreferences preferences = getPreferences(MODE_PRIVATE);
        SharedPreferences preferences = getSharedPreferences("mypreferences", MODE_PRIVATE);
        int savedCounter = preferences.getInt("counter", 0);
        binding.dbTxtPreference.setText(String.valueOf(savedCounter));

        dbInstance = Room.databaseBuilder(this, CustomDBInstance.class, "MyDatabaseInstance")
//                .allowMainThreadQueries()
                .build();

        refreshList();
    }

    @Override
    protected void onPostCreate(@Nullable Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);

        binding.dbBtnPreference.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //SharedPreferences preferences = getPreferences(MODE_PRIVATE);
                SharedPreferences preferences = getSharedPreferences("mypreferences", MODE_PRIVATE);
                int savedCounter = preferences.getInt("counter", 0);
                int currentValue = savedCounter + 1;

                SharedPreferences.Editor editor = preferences.edit();
                editor.putInt("counter", currentValue);
                //editor.commit();
                editor.apply();
                binding.dbTxtPreference.setText(String.valueOf(currentValue));
            }
        });

        binding.dbBtnDatabase.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                SharedPreferences preferences = getSharedPreferences("mypreferences", MODE_PRIVATE);
                int savedCounter = preferences.getInt("counter", 0);

                UserEntity user = new UserEntity();
                user.setId(String.valueOf(savedCounter));
                user.setName("User " + savedCounter);
                user.setEmail("user" + savedCounter + "@example.com");

                executor.execute(new Runnable() {
                    @Override
                    public void run() {
                        dbInstance.getUserDao().save(user);
                    }
                });
            }
        });
    }

    private void refreshList() {
        executor.execute(new Runnable() {
            @Override
            public void run() {
                List<UserEntity> dataList = dbInstance.getUserDao().read();
                StringBuilder stringBuilder = new StringBuilder();
                for (UserEntity user : dataList) {
                    stringBuilder.append(user.toString()).append("\n");
                }

                binding.dbTxtMain.setText(stringBuilder.toString());
            }
        });
    }
}