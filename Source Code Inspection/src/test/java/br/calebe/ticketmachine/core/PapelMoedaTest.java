package br.calebe.ticketmachine.core;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PapelMoedaTest {

    @Test
    public void testGetValor() {
        // Análise de Valor-Limite: Testando um valor válido para o papel-moeda
        PapelMoeda papel = new PapelMoeda(5, 1);
        assertEquals(5, papel.getValor());
    }

    @Test
    public void testGetQuantidade() {
        // Particionamento de Equivalência: Testando a quantidade de cédulas
        PapelMoeda papel = new PapelMoeda(10, 3);
        assertEquals(3, papel.getQuantidade());
    }
}
