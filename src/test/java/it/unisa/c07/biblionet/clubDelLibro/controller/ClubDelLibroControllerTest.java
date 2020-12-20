package it.unisa.c07.biblionet.clubDelLibro.controller;

import it.unisa.c07.biblionet.clubDelLibro.service.ClubDelLibroService;
import it.unisa.c07.biblionet.model.entity.ClubDelLibro;
import it.unisa.c07.biblionet.model.entity.utente.Biblioteca;
import it.unisa.c07.biblionet.model.entity.utente.Esperto;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import java.util.stream.Stream;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

/**
 * @author Viviana Pentangelo, Gianmario Voria
 */
@SpringBootTest
@AutoConfigureMockMvc
public class ClubDelLibroControllerTest {

    /**
     * Mock del service per simulare
     * le operazioni dei metodi.
     */
    @MockBean
    private ClubDelLibroService clubService;

    /**
     * Inject di MockMvc per simulare
     * le richieste http.
     */
    @Autowired
    private MockMvc mockMvc;

    /**
     * Metodo che testa la funzionalità gestita dal
     * controller per la creazione di un club
     * simulando la richiesta http.
     * @param club Il club da creare
     * @throws Exception Eccezione per MovkMvc
     */
    @ParameterizedTest
    @MethodSource("provideCreaClubDelLibro")
    public void creaClubDelLibro(final ClubDelLibro club) throws Exception {
        when(clubService.creaClubDelLibro(club)).thenReturn(club);
        this.mockMvc.perform(post("/club-del-libro/crea"))
                .andExpect(view().name("visualizza-club"));
    }

    /**
     * Simula i dati inviati da una POST
     * http attraverso uno stream.
     * @return Lo stream di dati.
     */
    private static Stream<Arguments> provideCreaClubDelLibro() {
        return Stream.of(
                Arguments.of(new ClubDelLibro("Club1",
                        "descrizione1",
                        new Esperto("drink@home.com",
                            "ALotOfBeerInMyLife",
                            "Salerno",
                            "Salerno",
                            "Via vicino casa di Stefano 2",
                            "3694578963",
                            "mrDuff",
                            "Nicola",
                            "Pagliara",
                            new Biblioteca("gmail@gmail.com",
                                    "Ueuagliobellstuorolog69",
                                    "Napoli",
                                    "Scampia",
                                    "Via Portici 47",
                                    "3341278415",
                                    "Vieni che non ti faccio niente"))))
        );
    }

}
