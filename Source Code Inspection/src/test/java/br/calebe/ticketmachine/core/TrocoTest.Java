package br.calebe.ticketmachine.core;

import br.calebe.ticketmachine.core.Troco;
import br.calebe.ticketmachine.core.PapelMoeda;
import org.junit.jupiter.api.Test;

import java.util.Iterator;

import static org.junit.jupiter.api.Assertions.*;

public class TrocoTest {

    @Test
    public void testGetIterator() {
        // Teste de Caminho Base: Verificando o comportamento do iterador
        Troco troco = new Troco(200);
        Iterator<PapelMoeda> it = troco.getIterator();
        assertTrue(it.hasNext());
    }

    @Test
    public void testNextPapelMoeda() {
        // Teste de Integração: Verificando a extração correta das cédulas
        Troco troco = new Troco(100);
        Iterator<PapelMoeda> it = troco.getIterator();
        PapelMoeda papel = it.next();
        assertNotNull(papel);
        assertEquals(100, papel.getValor());
    }

    @Test
    public void testHasNextQuandoNaoTemMaisPapelMoeda() {
        // Teste de Caminho Base: Verificando se o iterador retorna false quando não há mais papel-moeda
        Troco troco = new Troco(0);
        Iterator<PapelMoeda> it = troco.getIterator();
        assertFalse(it.hasNext());
    }
}
