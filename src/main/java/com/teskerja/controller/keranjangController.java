/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.teskerja.controller;

import com.teskerja.model.keranjang;
import com.teskerja.repository.keranjangrepository;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author HP
 */

@RestController
@RequestMapping("/keranjang")
public class keranjangController {
    @Autowired
    keranjangrepository krrepo;
    
    
    @PostMapping("/")
    public keranjang tambah(@Valid @RequestBody keranjang kr) {
        return krrepo.save(kr);
    }
    
    @PutMapping("/tambah1/{id}")
    public ResponseEntity<keranjang> tambahjml(@PathVariable(value = "id") Long id) {
        keranjang krj = krrepo.getById(id);
        if (krj == null) {
            return ResponseEntity.notFound().build();
        } else {
            krj.setIdPembeli(krj.getIdPembeli());
            krj.setIdbarang(krj.getIdbarang());
            krj.setJumlah(krj.getJumlah()+1);
            krj.setTotal(krj.getTotal());
            keranjang updatedBarang = krrepo.save(krj);            
            return ResponseEntity.ok(updatedBarang);
        }
        
    }
    
    @PutMapping("/kurang1/{id}")
    public ResponseEntity<keranjang> kurangijml(@PathVariable(value = "id") Long id) {
        keranjang krj = krrepo.getById(id);
        if (krj == null) {
            return ResponseEntity.notFound().build();
        } else {
            krj.setIdPembeli(krj.getIdPembeli());
            krj.setIdbarang(krj.getIdbarang());
            krj.setJumlah(krj.getJumlah()-1);
            krj.setTotal(krj.getTotal());
            keranjang updatedBarang = krrepo.save(krj);            
            return ResponseEntity.ok(updatedBarang);
        }
        
    }
    
     @DeleteMapping("/{id}")
    public String deletekeranjang(@PathVariable(value = "id") Long id) {
        keranjang krj = krrepo.getById(id);
        String result = "";
        if (krj == null) {
            result = "id" + id + " tidak ditemukan";
            return result;
        }
        result = "id " + id + " berhasil di hapus";
        krrepo.delete(krj);
        return result;
    }
    
}
