package com.example.halo112_generic.dao;

import com.example.halo112_generic.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.Optional;

@Repository
public interface UserRepository
        extends JpaRepository<User, Long> {

    int countByUserName(String userName);

    @Query("SELECT r FROM User r where r.userName = :userName")
    Optional<User> findUserByUserName(@Param("userName") String userName);

    @Transactional
    @Modifying
    @Query("UPDATE User k SET k.photo = :userPhoto WHERE k.userName = :userName")
    void editUserPhoto(@Param("userName") String userName, @Param("userPhoto") String userPhoto);

    @Transactional
    @Modifying
    @Query("UPDATE User k SET k.name = :nameUser WHERE k.userName = :userName")
    void editNameUser(@Param("userName") String userName, @Param("nameUser") String nameUser);

    @Transactional
    @Modifying
    @Query("UPDATE User k SET k.surname = :surnameUser WHERE k.userName = :userName")
    void editSurnameUser(@Param("userName") String userName, @Param("surnameUser") String surnameUser);

    @Transactional
    @Modifying
    @Query("UPDATE User k SET k.phoneNumber = :userPhoneNumber WHERE k.userName = :userName")
    void editUserPhoneNumber(@Param("userName") String userName, @Param("userPhoneNumber") String userPhoneNumber);

    @Transactional
    @Modifying
    @Query("UPDATE User k SET k.email = :userEmail WHERE k.userName = :userName")
    void editUserEmail(@Param("userName") String userName, @Param("userEmail") String userEmail);

    @Transactional
    @Modifying
    @Query("UPDATE User k SET k.role = :userRole WHERE k.userName = :userName")
    void editUserRole(@Param("userName") String userName, @Param("userRole") String userRole);

    @Transactional
    @Modifying
    @Query("UPDATE User k SET k.confirmed = :userConfirmed WHERE k.userName = :userName")
    void editUserConfirmed(@Param("userName") String userName, @Param("userConfirmed") boolean userConfirmed);

    @Transactional
    @Modifying
    @Query("UPDATE User k SET k.passwordHash = :userPasswordHash WHERE k.userName = :userName")
    void editUserPasswordHash(@Param("userName") String userName, @Param("userPasswordHash") String userPasswordHash);


}