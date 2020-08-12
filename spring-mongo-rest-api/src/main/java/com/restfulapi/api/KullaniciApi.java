package com.restfulapi.api;

import com.restfulapi.entity.Kullanici;
import com.restfulapi.repository.KullaniciRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import java.util.List;

@RestController
@RequestMapping("/kullanici")
public class KullaniciApi {

    @Autowired
    private KullaniciRepository kullaniciRepository;

    /*@PostConstruct
    public void init(){
        Kullanici kullanici = new Kullanici();
        kullanici.setName("Samet");
        kullanici.setLastname("Ozyurek");
        kullanici.setName("Melik");
        kullanici.setLastname("Ozyurek");
        kullaniciRepository.save(kullanici);
    }*/

    @PostMapping
    public ResponseEntity<Kullanici> insert(@RequestBody Kullanici kullanici){
        return ResponseEntity.ok(kullaniciRepository.save(kullanici));
    }

    @GetMapping
    public ResponseEntity<List<Kullanici>>getAllData(){
        return ResponseEntity.ok(kullaniciRepository.findAll());
    }
}
