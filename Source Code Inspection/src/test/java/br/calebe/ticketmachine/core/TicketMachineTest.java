package br.calebe.ticketmachine.core;

import br.calebe.ticketmachine.exception.PapelMoedaInvalidaException;
import br.calebe.ticketmachine.exception.SaldoInsuficienteException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TicketMachineTest {

    @Test
    public void testInserirPapelMoedaValida() throws PapelMoedaInvalidaException {
        // Particionamento de Equivalência: Testando com valores válidos
        TicketMachine tm = new TicketMachine(5);
        tm.inserir(5);
        assertEquals(5, tm.getSaldo());
    }

    @Test
    public void testInserirPapelMoedaInvalida() {
        // Particionamento de Equivalência: Testando com valores inválidos
        TicketMachine tm = new TicketMachine(5);
        assertThrows(PapelMoedaInvalidaException.class, () -> tm.inserir(3));
    }

    @Test
    public void testImprimirComSaldoInsuficiente() {
        // Teste de Caminho Base: Testando o fluxo onde o saldo é insuficiente
        TicketMachine tm = new TicketMachine(10);
        assertThrows(SaldoInsuficienteException.class, () -> tm.imprimir());
    }

    @Test
    public void testImprimirComSaldoSuficiente() throws SaldoInsuficienteException, PapelMoedaInvalidaException {
        // Teste de Caminho Base: Testando o fluxo onde o saldo é suficiente
        // Neste teste um erro ocorreu por conta do inserir(int quantia) da classe TicketMachine
        TicketMachine tm = new TicketMachine(10);
        tm.inserir(10);
        String output = tm.imprimir();
        assertEquals("*****************\n*** R$ 10,00 ****\n*****************\n", output);
    }

    @Test
    public void testGetTroco() {
        // Teste de Integração: Testando o retorno de troco (ainda não implementado)
        TicketMachine tm = new TicketMachine(10);
        assertNull(tm.getTroco());
    }
}
