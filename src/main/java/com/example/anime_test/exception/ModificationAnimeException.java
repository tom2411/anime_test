package com.example.anime_test.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
public class ModificationAnimeException extends RuntimeException{
    public ModificationAnimeException() {
        super("Une erreur est subvenue lors de la modification d'un anime");
    }
}
