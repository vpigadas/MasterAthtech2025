package gr.athtech.course.viewmodel.database;

import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = {CourseEntity.class}, version = 1)
public abstract class CourseDbInstance extends RoomDatabase {

    public abstract CourseDAO getCourseDao();
}
