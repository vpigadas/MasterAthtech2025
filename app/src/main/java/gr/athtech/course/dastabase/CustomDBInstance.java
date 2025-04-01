package gr.athtech.course.dastabase;

import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = {UserEntity.class}, version = 1)
public abstract class CustomDBInstance extends RoomDatabase {

    public abstract UserDao getUserDao();
}
