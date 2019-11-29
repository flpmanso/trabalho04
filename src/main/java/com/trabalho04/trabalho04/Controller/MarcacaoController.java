package com.trabalho04.trabalho04.Controller;

import com.trabalho04.trabalho04.DAO.MarcacaoDAO;
import com.trabalho04.trabalho04.model.Marcacao;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping({"/marcacao"})
public class MarcacaoController {

    private MarcacaoDAO marcacao;

    MarcacaoController(MarcacaoDAO marcacaoDAO) {
        this.marcacao = marcacaoDAO;
    }

    //metodos do crud aqui
    @GetMapping
    public List todasMarcacoes() {
        return marcacao.findAll();
    }

    @GetMapping(path = {"/{id}"})
    public ResponseEntity idMarcacao(@PathVariable int id) {
        return marcacao.findById(id)
                .map(record -> ResponseEntity.ok().body(record))
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Marcacao create(@RequestBody Marcacao marcacao1) {
        return marcacao.save(marcacao1);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity update(@PathVariable("id") int id, @RequestBody Marcacao marcacao1) {
        return marcacao.findById(id)
                .map(record -> {
                    record.setNome(marcacao1.getNome());
                    record.setLatitude(marcacao1.getLatitude());
                    record.setLongitude(marcacao1.getLongitude());
                    record.setDataInclusao(marcacao1.getDataInclusao());
                    Marcacao updated = marcacao.save(record);
                    return ResponseEntity.ok().body(updated);
                }).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping(path = {"/{id"})
    public ResponseEntity<?> delete(@PathVariable int id) {
        return marcacao.findById(id)
                .map(record -> {
                    marcacao.deleteById(id);
                    return ResponseEntity.ok().build();
                }).orElse(ResponseEntity.notFound().build());
    }
}
