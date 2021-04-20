package com.example.anime_test.controller;

import com.example.anime_test.exception.ModificationAnimeException;
import com.example.anime_test.facade.AnimeFacade;
import com.example.anime_test.modele.Anime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.Collection;
import java.util.HashMap;

@RestController
public class AnimeController {

    @Autowired
    AnimeFacade animeFacade;


    @GetMapping(value = "/animes",
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Collection<Anime>> getAnimes(){
        return ResponseEntity.ok().body(animeFacade.getAnimes().values());
    }

    @PostMapping(value = "/anime",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Anime> ajouteAnime(@RequestBody Anime anime){
        if (anime.getNom().isBlank() || anime.getNom().isEmpty()){
            return ResponseEntity.badRequest().build();
        }
        if (animeFacade.dansBD(anime.getNom())){
            return ResponseEntity.status(HttpStatus.CONFLICT).build();
        }
        animeFacade.ajouterAnime(anime.getNom(),anime);

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest().path("/{nom}")
                .buildAndExpand(anime.getNom()).toUri();

        return ResponseEntity.created(location).body(anime);
    }

    @PatchMapping("/anime/{nom}")
    public ResponseEntity<Anime> modifierMessage(@PathVariable("nom") String nom,@RequestBody Anime anime) throws ModificationAnimeException{
        if (nom.isEmpty() || nom.isBlank() ){
            return ResponseEntity.badRequest().build();
        }
        if (!animeFacade.dansBD(nom)){
            return ResponseEntity.notFound().build();
        }
        try {
            Anime anime_mod = animeFacade.modifier(nom,anime);
            return ResponseEntity.ok().body(anime_mod);
        } catch (ModificationAnimeException e) {
            throw new ModificationAnimeException();
        }
    }

    @DeleteMapping("/anime/{nom}")
    public ResponseEntity<Anime> supprimerAnime(@PathVariable("nom") String nom){
        if (nom.isEmpty() || nom.isBlank()){
            return ResponseEntity.badRequest().build();
        }
        if (animeFacade.getAnime(nom)==null){
            return ResponseEntity.notFound().build();
        }
        animeFacade.deleteAnime(nom);
        return ResponseEntity.noContent().build();
    }
}
