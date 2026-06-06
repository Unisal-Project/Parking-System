package auth;

public class Auth {
    private static Auth instancia;
    private Funcionario usuarioLogado;


    private Auth() {}


    public static Auth getInstancia() {
        if (instancia == null) {
            instancia = new Auth();
        }
        return instancia;
    }

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

    public void logout() {
        System.out.println("Logout: " + usuarioLogado.getNome());
        usuarioLogado = null;
    }

    public Funcionario getUsuarioLogado() { return usuarioLogado; }


    private Funcionario buscarFuncionario(int id) { return null; }
    private boolean senhaCorreta(Funcionario f, String senha) { return true; }
}