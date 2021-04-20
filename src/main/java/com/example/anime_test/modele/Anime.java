package com.example.anime_test.modele;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDate;

public class Anime {
    private String nom;
    private String cover;
    private int nb_episode;
    private int dure_episode;
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate date_debut;

    public Anime(String nom, String cover, int nb_episode, int dure_episode, LocalDate date_debut) {
        this.nom = nom;
        this.cover = cover;
        this.nb_episode = nb_episode;
        this.dure_episode = dure_episode;
        this.date_debut = date_debut;
    }

    public void modifier(Anime anime_en_entre){
        if(anime_en_entre.cover!=null && !anime_en_entre.cover.isEmpty() && !anime_en_entre.cover.isBlank() ){
            System.out.println("cover");
            if (!this.getCover().equals(anime_en_entre.cover)){
                this.cover = anime_en_entre.cover;
            }
        }
        if(anime_en_entre.nb_episode!=0 ){
            System.out.println("nb_episode");
            if (this.getNb_episode()!=anime_en_entre.getNb_episode()){
                this.nb_episode = anime_en_entre.nb_episode;
            }
        }
        if(anime_en_entre.dure_episode!=0 ){
            System.out.println("dure_episode");
            if (this.getDure_episode()!=anime_en_entre.getDure_episode()){
                this.dure_episode = anime_en_entre.dure_episode;
            }
        }
        if(anime_en_entre.date_debut!=null){
            System.out.println("date_debut");
            if (!this.getDate_debut().isEqual(anime_en_entre.date_debut)){
                this.date_debut = anime_en_entre.date_debut;
            }
        }

    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getCover() {
        return cover;
    }

    public void setCover(String cover) {
        this.cover = cover;
    }

    public int getNb_episode() {
        return nb_episode;
    }

    public void setNb_episode(int nb_episode) {
        this.nb_episode = nb_episode;
    }

    public int getDure_episode() {
        return dure_episode;
    }

    public void setDure_episode(int dure_episode) {
        this.dure_episode = dure_episode;
    }

    public LocalDate getDate_debut() {
        return date_debut;
    }

    public void setDate_debut(LocalDate date_debut) {
        this.date_debut = date_debut;
    }
}
