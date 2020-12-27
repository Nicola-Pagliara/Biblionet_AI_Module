package it.unisa.c07.biblionet.clubDelLibro.service;

import it.unisa.c07.biblionet.model.entity.ClubDelLibro;
import it.unisa.c07.biblionet.model.entity.Genere;
import it.unisa.c07.biblionet.model.entity.utente.Lettore;

import java.util.List;

/**
 * Implementa l'interfaccia service
 * per il sottosistema ClubDelLibro.
 * @author Viviana Pentangelo, Gianmario Voria
 */
public interface ClubDelLibroService {

    /**
     * Implementa la funzionalità che permette
     * ad un Esperto di creare un Club del Libro.
     * @param club Il Club del Libro da memorizzare
     * @return Il Club del Libro appena creato
     */
    ClubDelLibro creaClubDelLibro(ClubDelLibro club);

    /**
     * Implementa la funzionalità che permette
     * di visualizzare tutti i club del libro.
     * @return La lista dei club
     */
    List<ClubDelLibro> visualizzaClubsDelLibro();

    /**
     * Implementa la funzionalità che permette
     * di recuperare un oggetto
     * della classe genere dato il nome.
     * @param generi Lista dei generi sottoforma di stringa
     * @return Lista dei generi sottoforma di entità
     */
    List<Genere> getGeneri(List<String> generi);

    /**
     * Implementa la funzionalità che permette
     * di modificare ed
     * effettuare l'update di un club.
     * @param club Il club da modificare
     * @return Il club modificato
     */
    ClubDelLibro modificaDatiClub(ClubDelLibro club);

    /**
     * Implementa la funzionalità che permette
     * di recuperare un
     * club dato il suo ID.
     * @param id L'ID del club da recuperare
     * @return Il club recuperato
     */
    ClubDelLibro getClubByID(int id);

    /**
     * Implementa la funzionalità che permette
     * ad un lettore di effettuare
     * l'iscrizione ad un club del libro.
     * @param club Il club al quale iscriversi
     * @param lettore Il lettore che si iscrive
     * @return true se è andato a buon fine, false altrimenti
     */
    Boolean partecipaClub(ClubDelLibro club, Lettore lettore);

}