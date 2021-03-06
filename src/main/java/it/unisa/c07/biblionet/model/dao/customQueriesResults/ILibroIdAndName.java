package it.unisa.c07.biblionet.model.dao.customQueriesResults;

/**
 * Implementa la custom query result per la ricerca dei Libri per nome.
 */
public interface ILibroIdAndName {
    /**
     * Implementa la funzionalit√† di ottenimento dell'id di un libro.
     * @return L'id del libro
     */
    Integer getIdLibro();

    /**
     * Implementa la funzionalit√† di ottenutmento del titolo di un libro.
     * @return il titolo di un libro.
     */
    String getTitolo();
}
