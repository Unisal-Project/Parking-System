package builder;

/**
 * Define os possíveis estados de um ticket no sistema.
 */
public enum StatusTicket {
    /** O ticket foi gerado mas ainda não foi pago. */
    PENDENTE_PAGAMENTO,
    /** O pagamento do ticket foi confirmado. */
    PAGO,
    /** O veículo já saiu e o processo do ticket foi encerrado. */
    FINALIZADO;
}
