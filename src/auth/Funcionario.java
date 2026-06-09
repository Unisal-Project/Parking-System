package auth;

public class Funcionario {
    private String nome;
    private String cpf;
    private int id;
    private Cargo cargo;


    public Funcionario(String nome, String cpf, int id, Cargo cargo) {
        this.nome = nome;
        this.cpf = cpf;
        this.id = id;
        this.cargo = cargo;
    }

    public boolean validarTicket(Ticket ticket) {
        return ticket != null && ticket.isValido();
    }

    public String getNome() {
        return nome;
    }

    public String getCpf() {
        return cpf;
    }

    public int getId() {
        return id;
    }

    public Cargo getCargo() {
        return cargo;
    }

}
