package com.example.anime_test.facade;

import com.example.anime_test.modele.Anime;

import java.util.Map;

public interface AnimeFacade {

    Anime modifier(String nom, Anime anime_en_entrer);
    Boolean dansBD(String nom);
    Map<String , Anime> getAnimes();
    void ajouterAnime(String nom,Anime anime);
    Anime getAnime(String nom);
    void deleteAnime(String nom);


}
