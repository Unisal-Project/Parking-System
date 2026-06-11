package Facade;

import Camera.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Classe responsável por testar os comportamentos da classe Cancela.
 *
 * Os testes verificam:
 * <ul>
 *     <li>Estado inicial da cancela;</li>
 *     <li>Abertura da cancela;</li>
 *     <li>Fechamento da cancela;</li>
 *     <li>Associação correta da cancela com um andar.</li>
 * </ul>
 *
 * @author Pedro Fonseca Martins
 */
public class CancelaTest {

    /**
     * Verifica se uma nova cancela é criada inicialmente fechada.
     */
    @Test
    void CriarCancelaFechada(){
        Andar andar = new Andar(1, TipoVaga.COBERTA);
        Cancela cancela = new Cancela(andar);
        assertFalse(cancela.isAberta());
    }

    /**
     * Verifica se a cancela é aberta corretamente
     * após a chamada do método abrirCancela().
     */
    @Test
    void AbrirCancela(){
        Andar andar = new Andar(1, TipoVaga.COBERTA);
        Cancela cancela = new Cancela(andar);

        boolean resultado = cancela.abrirCancela();

        assertTrue(resultado);
        assertTrue(cancela.isAberta());
    }

    /**
     * Verifica se a cancela é fechada corretamente
     * após a chamada do método fecharCancela().
     */
    @Test
    void FecharCancela(){
        Andar andar = new Andar(1, TipoVaga.COBERTA);
        Cancela cancela = new Cancela(andar);

        boolean resultado = cancela.fecharCancela();

        assertFalse(resultado);
        assertFalse(cancela.isAberta());
    }

    /**
     * Verifica se a cancela mantém a referência
     * correta ao andar informado no construtor.
     */
    @Test
    void RetornarAndarDaCancela (){
        Andar andar = new Andar(2, TipoVaga.DESCOBERTA);
        Cancela cancela = new Cancela(andar);

        assertEquals(andar, cancela.getAndar());
        assertEquals(2, cancela.getAndar().getNumero());
    }
}