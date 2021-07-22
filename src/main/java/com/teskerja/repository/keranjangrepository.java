/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.teskerja.repository;

import com.teskerja.model.keranjang;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author HP
 */
public interface keranjangrepository extends JpaRepository<keranjang, Long>{
    
}
