package gr.athtech.course.dastabase;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface UserDao {

    @Insert
    public void insert(UserEntity data) throws Exception;

    @Update
    public void update(UserEntity data) throws Exception;

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    public void save(UserEntity data);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    public void save(UserEntity[] data);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    public void save(List<UserEntity> data);

    @Delete
    public void delete(UserEntity data);

    @Delete
    public void delete(UserEntity[] data);

    @Query("SELECT * FROM UserEntity")
    @NonNull
    public List<UserEntity> read();

    @Query("SELECT * FROM UserEntity LIMIT 1")
    @Nullable
    public UserEntity readFirst();

    @Query("SELECT * FROM UserEntity WHERE full_name LIKE :name")
    @NonNull
    public List<UserEntity> readByName(String name);


}
