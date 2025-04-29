package gr.athtech.course.viewmodel.database;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import java.util.List;

@Dao
public interface CourseDAO {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    public void save(CourseEntity entity);

    @Delete
    public void delete(CourseEntity entity);

    @Query("SELECT * FROM CourseEntity")
    public List<CourseEntity> read();
}
