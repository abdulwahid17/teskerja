/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.teskerja.controller;

import com.teskerja.model.barang;
import com.teskerja.repository.barangrepository;
import java.util.List;
import java.util.Optional;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
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
@RequestMapping("/barang")
public class barangController {
    
    @Autowired
    barangrepository brrepo;
    
    @GetMapping("/")
    public List<barang> getAll() {
        return brrepo.findAll();
    }
    
    @PostMapping("/")
    public barang tambahbarang(@Valid @RequestBody barang br) {
        return brrepo.save(br);
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<barang> updatebarang(@PathVariable(value = "id") Long id, @Valid @RequestBody barang br) {
        Example<barang> match = Example.of(br);
//        Optional<barang> brg = brrepo.findOne(match);
        barang brg = brrepo.getById(id);
        if (brg == null) {
            return ResponseEntity.notFound().build();
        } else {
            brg.setNamaBarang(br.getNamaBarang());
            brg.setHarga(br.getHarga());
            barang updatedBarang = brrepo.save(brg);            
            return ResponseEntity.ok(updatedBarang);
        }
        
    }
    
    @DeleteMapping("/{id}")
    public String deleteBarang(@PathVariable(value = "id") Long id) {
        barang brg = brrepo.getById(id);
        String result = "";
        if (brg == null) {
            result = "id" + id + " tidak ditemukan";
            return result;
        }
        result = "id " + id + " berhasil di hapus";
        brrepo.delete(brg);
        return result;
    }
    
}
