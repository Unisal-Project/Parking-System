package auth;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Classe responsável por testar os comportamentos da classe Auth (Singleton).
 *
 * Os testes verificam:
 *
 * Instância única do Singleton;
 * Estado inicial do usuário logado;
 * Comportamento do logout.
 *
 *
 * @author Luis Filippe Reis Nogueira
 * @version 1.0
 */
public class AuthTest {

    private Auth auth;

    /**
     * Configura o ambiente de teste antes de cada método.
     */
    @BeforeEach
    void setUp() {
        auth = Auth.getInstancia();
    }

    /**
     * Verifica se a classe Auth segue o padrão Singleton.
     */
    @Test
    void TestarSingleton() {
        Auth outraInstancia = Auth.getInstancia();
        assertSame(auth, outraInstancia, "Ambas as instâncias devem ser a mesma.");
    }

    /**
     * Verifica se inicialmente não há usuário logado ou se o logout limpa o estado.
     */
    @Test
    void TestarLogout() {
        // Garantindo que logout não quebra mesmo se ninguém estiver logado
        auth.logout();
        assertNull(auth.getUsuarioLogado(), "Após o logout, o usuário logado deve ser null.");
    }

    /**
     * Verifica se o login falha para credenciais inexistentes (conforme implementação atual).
     */
    @Test
    void TestarLoginFalho() {
        boolean resultado = auth.login(999, "senha_errada");
        assertFalse(resultado, "O login deve falhar para IDs não cadastrados.");
        assertNull(auth.getUsuarioLogado(), "O usuário logado deve permanecer null após falha no login.");
    }
}
