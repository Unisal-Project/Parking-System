package auth;

/**
 * Classe responsável pelo gerenciamento de autenticação do sistema.
 * Implementa o padrão Singleton para garantir que haja apenas uma instância
 * controlando o usuário logado no sistema.
 *
 * @author Luis Filippe Reis Nogueira
 * @version 1.1
 */
public class Auth {
    private static Auth instancia;
    private Funcionario usuarioLogado;

    /**
     * Construtor privado para impedir a instanciação externa (Padrão Singleton).
     */
    private Auth() {}

    /**
     * Retorna a instância única da classe Auth.
     * Caso a instância ainda não exista, ela é criada.
     *
     * @return A instância única de Auth.
     */
    public static Auth getInstancia() {
        if (instancia == null) {
            instancia = new Auth();
        }
        return instancia;
    }

    /**
     * Realiza o login de um funcionário no sistema.
     *
     * @param id O identificador do funcionário.
     * @param senha A senha para autenticação.
     * @return true se o login for bem-sucedido, false caso contrário.
     */
    public boolean login(int id, String senha) {
        Funcionario f = buscarFuncionario(id);

        if (f != null && senhaCorreta(f, senha)) {
            usuarioLogado = f;
            System.out.println("Login OK: " + f.getNome());
            return true;
        }

        System.out.println("Login falhou!");
        return false;
    }

    /**
     * Realiza o logout do usuário atualmente logado.
     * Caso não haja usuário logado, exibe uma mensagem informativa.
     */
    public void logout() {
        if (usuarioLogado != null) {
            System.out.println("Logout: " + usuarioLogado.getNome());
            usuarioLogado = null;
        } else {
            System.out.println("Nenhum usuário logado para realizar logout.");
        }
    }

    /**
     * Retorna o funcionário que está atualmente autenticado no sistema.
     *
     * @return O objeto Funcionario logado, ou null se não houver ninguém autenticado.
     */
    public Funcionario getUsuarioLogado() { 
        return usuarioLogado; 
    }

    /**
     * Busca um funcionário na base de dados (simulado).
     *
     * @param id ID do funcionário.
     * @return O funcionário encontrado ou null.
     */
    private Funcionario buscarFuncionario(int id) { 
        return null; 
    }

    /**
     * Valida se a senha informada está correta para o funcionário.
     *
     * @param f O funcionário a ser validado.
     * @param senha A senha informada.
     * @return true se a senha estiver correta.
     */
    private boolean senhaCorreta(Funcionario f, String senha) { 
        return true; 
    }
}
