package com.example.anime_test.facade;

import com.example.anime_test.modele.Anime;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component("AnimeFacade")
public class AnimeFacadeImpl implements AnimeFacade{
    private final HashMap<String, Anime> animes = new HashMap<>();


    @Override
    public Map<String, Anime> getAnimes() {
        return this.animes;
    }

    @Override
    public void ajouterAnime(String nom, Anime anime) {
        this.animes.put(nom, anime);
    }

    @Override
    public Anime modifier(String nom, Anime anime_en_entrer) {
        Anime anime_src = animes.get(nom);
        if(anime_en_entrer.getCover()!=null && !anime_en_entrer.getCover().isEmpty() && !anime_en_entrer.getCover().isBlank() ){
            System.out.println("cover");
            if (!anime_src.getCover().equals(anime_en_entrer.getCover())){
                anime_src.setCover(anime_en_entrer.getCover());
            }
        }
        if(anime_en_entrer.getNb_episode()!=0 ){
            System.out.println("nb_episode");
            if (anime_src.getNb_episode()!=anime_en_entrer.getNb_episode()){
                anime_src.setNb_episode(anime_en_entrer.getNb_episode());
            }
        }
        if(anime_en_entrer.getDure_episode()!=0 ){
            System.out.println("dure_episode");
            if (anime_src.getDure_episode()!=anime_en_entrer.getDure_episode()){
                anime_src.setDure_episode(anime_en_entrer.getDure_episode());
            }
        }
        if(anime_en_entrer.getDate_debut()!=null){
            System.out.println("date_debut");
            if (!anime_src.getDate_debut().isEqual(anime_en_entrer.getDate_debut())){
                anime_src.setDate_debut(anime_en_entrer.getDate_debut());
            }
        }
        //this.animes.replace(nom, anime_src);
        return anime_src;
    }

    @Override
    public Boolean dansBD(String nom) {
        return this.animes.containsKey(nom);
    }

    @Override
    public Anime getAnime(String nom) {
        return this.animes.get(nom);
    }

    @Override
    public void deleteAnime(String nom) {
        this.animes.remove(nom);
    }




}
