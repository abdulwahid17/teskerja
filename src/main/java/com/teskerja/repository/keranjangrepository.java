/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.teskerja.repository;

import com.teskerja.model.keranjang;
import java.util.Collection;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 *
 * @author HP
 */
public interface keranjangrepository extends JpaRepository<keranjang, Long>{
    @Query(value = "SELECT SUM(total) FROM `tbl_keranjang` WHERE id_pembeli=?1",nativeQuery = true) long calculateByIdPembeli(long idpembeli);
}
