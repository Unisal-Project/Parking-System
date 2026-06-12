package auth;

import builder.Ticket;

/**
 * Representa um funcionário do estacionamento.
 * Contém informações básicas e permissões para validar tickets.
 *
 * @author Luis Filippe Reis Nogueira
 * @version 1.0
 */
public class Funcionario {
    private String nome;
    private String cpf;
    private int id;
    private Cargo cargo;

    /**
     * Construtor da classe Funcionario.
     *
     * @param nome Nome completo do funcionário.
     * @param cpf CPF do funcionário.
     * @param id Identificador único.
     * @param cargo Cargo ocupado (GERENTE ou ATENDENTE).
     */
    public Funcionario(String nome, String cpf, int id, Cargo cargo) {
        this.nome = nome;
        this.cpf = cpf;
        this.id = id;
        this.cargo = cargo;
    }

    /**
     * Valida se um ticket de estacionamento pode permitir a saída.
     * Um ticket é válido se não for nulo e já tiver sido pago.
     *
     * @param ticket O ticket a ser validado.
     * @return true se o ticket estiver pago, false caso contrário.
     */
    public boolean validarTicket(Ticket ticket) {
        return ticket != null && ticket.estaPago();
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
