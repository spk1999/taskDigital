package com.sujan.task.repo;

import com.sujan.task.model.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends JpaRepository<UserModel, Integer> {

    @Query(value = "SELECT uid , enabled ,password , role , username from user where username=?1 and password=?2 ", nativeQuery = true)
    UserModel getUserByUsernameAndPassword(String username, String password);


}
