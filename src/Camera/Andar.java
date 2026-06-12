package Camera;

public class Andar{
    private int numero;
    private TipoVaga tipoVaga;

    public Andar(int numero, TipoVaga tipoVaga) {
        this.numero = numero;
        this.tipoVaga = tipoVaga;
    }

    public int  getNumero() {
        return numero;
    }

    public TipoVaga getTipoVaga() {
        return tipoVaga;
    }
}