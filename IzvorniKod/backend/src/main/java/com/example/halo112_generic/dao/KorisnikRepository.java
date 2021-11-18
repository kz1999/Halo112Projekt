package com.example.halo112_generic.dao;

import com.example.halo112_generic.domain.Korisnik;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
public interface KorisnikRepository
        extends JpaRepository<Korisnik, Long> {

    public int countByKorisnickoIme(String korisnickoIme);

    @Query("SELECT r FROM User r where r.username = :korisnickoIme")
    Korisnik findKorisnikByKorisnickoIme(@Param("korisnickoIme") String korisnickoIme);

    @Transactional
    @Modifying
    @Query("UPDATE User k SET k.PhotoURL = :korisnikFotografija WHERE k.username = :korisnickoIme")
    void editKorisnikFotografija(@Param("korisnickoIme") String korisnickoIme, @Param("korisnikFotografija") String korisnikFotografija);

    @Transactional
    @Modifying
    @Query("UPDATE User k SET k.Name = :korisnikIme WHERE k.username = :korisnickoIme")
    void editKorisnikIme(@Param("korisnickoIme") String korisnickoIme, @Param("korisnikIme") String korisnikIme);

    @Transactional
    @Modifying
    @Query("UPDATE User k SET k.Surname = :korisnikPrezime WHERE k.username = :korisnickoIme")
    void editKorisnikPrezime(@Param("korisnickoIme") String korisnickoIme, @Param("korisnikPrezime") String korisnikPrezime);

    @Transactional
    @Modifying
    @Query("UPDATE User k SET k.PhoneNumber = :korisnikBrojMobitela WHERE k.Username = :korisnickoIme")
    void editKorisnikBrojMobitela(@Param("korisnickoIme") String korisnickoIme, @Param("korisnikBrojMobitela") String korisnikBrojMobitela);

    @Transactional
    @Modifying
    @Query("UPDATE User k SET k.email = :korisnikEmail WHERE k.username = :korisnickoIme")
    void editKorisnikEmail(@Param("korisnickoIme") String korisnickoIme, @Param("korisnikEmail") String korisnikEmail);

    @Transactional
    @Modifying
    @Query("UPDATE User k SET k.role = :korisnikUloga WHERE k.username = :korisnickoIme")
    void editKorisnikUloga(@Param("korisnickoIme") String korisnickoIme, @Param("korisnikUloga") String korisnikUloga);


}