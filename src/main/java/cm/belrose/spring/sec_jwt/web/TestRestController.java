/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cm.belrose.spring.sec_jwt.web;

import cm.belrose.spring.sec_jwt.dao.TachesRepository;
import cm.belrose.spring.sec_jwt.entities.Taches;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Ngnawen
 */
@RestController
public class TestRestController {
    @Autowired
    private TachesRepository tachesRepository;
    
    @GetMapping("/taches")
    public List<Taches> listeTaches (){
        return tachesRepository.findAll();
    }
    
    @PostMapping("/tache")
      public Taches save(@RequestBody Taches t){
          return tachesRepository.save(t);
      }
    
    
}
