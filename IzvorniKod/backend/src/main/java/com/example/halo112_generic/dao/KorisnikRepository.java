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

    @Query("SELECT r FROM Korisnik r where r.korisnickoIme = :korisnickoIme")
    Korisnik findKorisnikByKorisnickoIme(@Param("korisnickoIme") String korisnickoIme);

    @Transactional
    @Modifying
    @Query("UPDATE Korisnik k SET k.fotografija = :korisnikFotografija WHERE k.korisnickoIme = :korisnickoIme")
    void editKorisnikFotografija(@Param("korisnickoIme") String korisnickoIme, @Param("korisnikFotografija") String korisnikFotografija);

    @Transactional
    @Modifying
    @Query("UPDATE Korisnik k SET k.ime = :korisnikIme WHERE k.korisnickoIme = :korisnickoIme")
    void editKorisnikIme(@Param("korisnickoIme") String korisnickoIme, @Param("korisnikIme") String korisnikIme);

    @Transactional
    @Modifying
    @Query("UPDATE Korisnik k SET k.prezime = :korisnikPrezime WHERE k.korisnickoIme = :korisnickoIme")
    void editKorisnikPrezime(@Param("korisnickoIme") String korisnickoIme, @Param("korisnikPrezime") String korisnikPrezime);

    @Transactional
    @Modifying
    @Query("UPDATE Korisnik k SET k.brojMobitela = :korisnikBrojMobitela WHERE k.korisnickoIme = :korisnickoIme")
    void editKorisnikBrojMobitela(@Param("korisnickoIme") String korisnickoIme, @Param("korisnikBrojMobitela") String korisnikBrojMobitela);

    @Transactional
    @Modifying
    @Query("UPDATE Korisnik k SET k.email = :korisnikEmail WHERE k.korisnickoIme = :korisnickoIme")
    void editKorisnikEmail(@Param("korisnickoIme") String korisnickoIme, @Param("korisnikEmail") String korisnikEmail);

    @Transactional
    @Modifying
    @Query("UPDATE Korisnik k SET k.uloga = :korisnikUloga WHERE k.korisnickoIme = :korisnickoIme")
    void editKorisnikUloga(@Param("korisnickoIme") String korisnickoIme, @Param("korisnikUloga") String korisnikUloga);


}