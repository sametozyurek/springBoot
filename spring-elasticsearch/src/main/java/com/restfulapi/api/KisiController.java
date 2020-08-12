package com.restfulapi.api;

import com.restfulapi.entitiy.Kisi;
import com.restfulapi.repository.KisiRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.annotation.PostConstruct;
import java.util.Calendar;
import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/kisi")
public class KisiController {

    private final KisiRepository kisiRepository;

    public KisiController(KisiRepository kisiRepository) {
        this.kisiRepository = kisiRepository;
    }

   /* @PostConstruct
    public void init(){
        Kisi kisi = new Kisi();
        kisi.setAd("Elastic");
        kisi.setSoyad("Search");
        kisi.setAdres("test");
        kisi.setDogumTarihi(Calendar.getInstance().getTime());
        kisi.setId("K0001");
        kisiRepository.save(kisi);
    }*/

    @GetMapping("/{search}")
    public ResponseEntity<List<Kisi>> getKisi(@PathVariable String search){
        List<Kisi> kisiler = kisiRepository.getByCustomQuery(search);
        return ResponseEntity.ok(kisiler);
    }
}
