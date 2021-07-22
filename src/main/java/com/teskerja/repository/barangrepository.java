/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.teskerja.repository;

import com.teskerja.model.barang;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author HP
 */
@Repository
public interface barangrepository extends JpaRepository<barang, Long>{
        List<barang> findByNamaBarang(String namaBarang);
}
