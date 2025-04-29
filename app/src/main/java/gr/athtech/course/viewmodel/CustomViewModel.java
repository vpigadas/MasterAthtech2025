package gr.athtech.course.viewmodel;

import android.content.Context;

import androidx.lifecycle.ViewModel;
import androidx.room.Room;

import gr.athtech.course.viewmodel.database.CourseDbInstance;
import gr.athtech.course.viewmodel.database.CourseEntity;

public class CustomViewModel extends ViewModel {

    private CourseDbInstance database;

    public void initialization(Context context) {
        database = Room.databaseBuilder(context, CourseDbInstance.class, "Course Database").build();
    }

    public void readData() {
        database.getCourseDao().read();
    }

    public void saveData(CourseEntity course) {
        database.getCourseDao().save(course);
    }
}
