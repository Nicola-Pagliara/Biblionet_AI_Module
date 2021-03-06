package it.unisa.c07.biblionet.registrazione.service;

import it.unisa.c07.biblionet.autenticazione.service.AutenticazioneService;
import it.unisa.c07.biblionet.model.dao.GenereDAO;
import it.unisa.c07.biblionet.model.dao.utente.BibliotecaDAO;
import it.unisa.c07.biblionet.model.dao.utente.EspertoDAO;
import it.unisa.c07.biblionet.model.dao.utente.LettoreDAO;
import it.unisa.c07.biblionet.model.entity.Genere;
import it.unisa.c07.biblionet.model.entity.utente.Biblioteca;
import it.unisa.c07.biblionet.model.entity.utente.Esperto;
import it.unisa.c07.biblionet.model.entity.utente.Lettore;
import it.unisa.c07.biblionet.model.entity.utente.UtenteRegistrato;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Alessio Casolaro
 * @author Antonio Della Porta.
 */
@Service
@RequiredArgsConstructor
public class RegistrazioneServiceImpl implements RegistrazioneService {

    /**
     * Si occupa di gestire le operazioni CRUD dell'Esperto.
     */
    private final EspertoDAO espertoDAO;

    /**
     * Si occupa di gestire le operazioni CRUD della Biblioteca.
     */
    private final BibliotecaDAO bibliotecaDAO;

    /**
     * Si occupa di gestire le operazioni CRUD del Genere.
     */
    private final GenereDAO genereDAO;

    /**
     * Si occupa delle operazioni CRUD.
     */
    private final LettoreDAO lettoreDAO;

    /**
     * Inject del service per simulare
     * le operazioni.
     */
    private final AutenticazioneService autenticazioneService;

    /**
     * Implementa la funzionalit√† di registrazione un Esperto.
     * @param esperto L'Esperto da registrare
     * @return L'utente registrato
     */
    @Override
    public final UtenteRegistrato registraEsperto(final Esperto esperto) {
        return espertoDAO.save(esperto);
    }

    /**
     * Implementa la funzionalit√† di registrazione una Biblioteca.
     * @param biblioteca La Biblioteca da registrare
     * @return L'utente registrato
     */
    @Override
    public UtenteRegistrato registraBiblioteca(final Biblioteca biblioteca) {
        return bibliotecaDAO.save(biblioteca);
    }

    /**
     * Implementa la funzionalit√† di registrare un Lettore.
     * @param lettore Il lettore da registrare
     * @return Il lettore registrato
     */
    @Override
    public final UtenteRegistrato registraLettore(final Lettore lettore) {
        return lettoreDAO.save(lettore);
    }

    /**
     * Implementa la funzionalit√† di controllare se una mail √®
     * presente gi√† associata ad un altro utente nel database.
     * @param email la mail da controllare
     * @return true se la mail √® gi√† associata, false altrimenti
     */
    @Override
    public boolean isEmailRegistrata(final String email) {

       /*
        * Utilizzo il LettoreDAO, ma potrei usare qualsiasi altro DAO
        * degli utenti, poich√© data la generalizzazione, la findAll
        * restituisce tutti gli utenti del sistema
        */
        for (UtenteRegistrato u: lettoreDAO.findAll()) {
            if (u.getEmail().equals(email)) {
                return true;
            }
        }

        return false;
    }

    /**
     * Implementa la funzionalit√† di trovare dei generi.
     * @param generi Un'array di nomi di generi da trovare
     * @return Una lista contenente i generi trovati
     */
    @Override
    public final List<Genere> findGeneriByName(final String[] generi) {
        List<Genere> toReturn = new ArrayList<>();
        for (String g: generi) {
            Genere gen = genereDAO.findByName(g);
            if (gen != null) {
                toReturn.add(gen);
            }

        }
        return toReturn;
    }

    /**
     * Implementa la funzionalit√† di trovare una biblioteca.
     * @param email La mail della biblioteca
     * @return La biblioteca se c'√®, altrimenti null
     */
    @Override
    public final Biblioteca getBibliotecaByEmail(final String email) {

        return autenticazioneService.findBibliotecaByEmail(email);
    }


}
