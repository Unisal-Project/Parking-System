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
 * @version 1.0
 */
public class CancelaTest {

    /**
     * Caso de Teste: Criação de Cancela Fechada
     *
     * Resumo:
     * Verifica se uma nova cancela é criada inicialmente fechada.
     *
     * Pré-condição:
     * - Um objeto Andar deve estar instanciado.
     *
     * Entradas:
     * - Andar número 1.
     * - Tipo de vaga COBERTA.
     *
     * Ação:
     * - Criar uma nova instância de Cancela.
     *
     * Resultado Esperado:
     * - O método isAberta() deve retornar false.
     *
     * Pós-condição:
     * - A cancela permanece fechada após sua criação.
     */
    @Test
    void CriarCancelaFechada() {
        Andar andar = new Andar(1, TipoVaga.COBERTA);
        Cancela cancela = new Cancela(andar);

        assertFalse(cancela.isAberta());
    }

    /**
     * Caso de Teste: Abertura da Cancela
     *
     * Resumo:
     * Verifica se a cancela é aberta corretamente
     * após a execução do método abrirCancela().
     *
     * Pré-condição:
     * - Uma cancela deve estar instanciada.
     * - A cancela deve estar inicialmente fechada.
     *
     * Entradas:
     * - Objeto Cancela associado ao andar 1.
     *
     * Ação:
     * - Executar o método abrirCancela().
     *
     * Resultado Esperado:
     * - O método abrirCancela() deve retornar true.
     * - O método isAberta() deve retornar true.
     *
     * Pós-condição:
     * - A cancela permanece aberta.
     */
    @Test
    void AbrirCancela() {
        Andar andar = new Andar(1, TipoVaga.COBERTA);
        Cancela cancela = new Cancela(andar);

        boolean resultado = cancela.abrirCancela();

        assertTrue(resultado);
        assertTrue(cancela.isAberta());
    }

    /**
     * Caso de Teste: Fechamento da Cancela
     *
     * Resumo:
     * Verifica se a cancela é fechada corretamente
     * após a execução do método fecharCancela().
     *
     * Pré-condição:
     * - Uma cancela deve estar instanciada.
     * - A cancela deve estar fechada ou aberta conforme
     *   implementação da classe.
     *
     * Entradas:
     * - Objeto Cancela associado ao andar 1.
     *
     * Ação:
     * - Executar o método fecharCancela().
     *
     * Resultado Esperado:
     * - O método deve retornar false.
     * - O método isAberta() deve retornar false.
     *
     * Pós-condição:
     * - A cancela encontra-se fechada.
     */
    @Test
    void FecharCancela() {
        Andar andar = new Andar(1, TipoVaga.COBERTA);
        Cancela cancela = new Cancela(andar);

        boolean resultado = cancela.fecharCancela();

        assertFalse(resultado);
        assertFalse(cancela.isAberta());
    }

    /**
     * Caso de Teste: Associação da Cancela ao Andar
     *
     * Resumo:
     * Verifica se a cancela mantém corretamente a referência
     * ao andar informado durante sua criação.
     *
     * Pré-condição:
     * - Um objeto Andar deve estar instanciado.
     *
     * Entradas:
     * - Andar número 2.
     * - Tipo de vaga DESCOBERTA.
     *
     * Ação:
     * - Criar uma nova instância de Cancela associada ao andar.
     * - Executar o método getAndar().
     *
     * Resultado Esperado:
     * - O andar retornado deve ser o mesmo informado no construtor.
     * - O número do andar deve ser igual a 2.
     *
     * Pós-condição:
     * - A associação entre cancela e andar permanece válida.
     */
    @Test
    void RetornarAndarDaCancela() {
        Andar andar = new Andar(2, TipoVaga.DESCOBERTA);
        Cancela cancela = new Cancela(andar);

        assertEquals(andar, cancela.getAndar());
        assertEquals(2, cancela.getAndar().getNumero());
    }
}