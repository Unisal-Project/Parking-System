package Facade;
/**
 *  responsável por controlar o acesso de entrada e saída de veículos.
 *  @author Pedro Monteiro
 *  @Verson 1.0
 */

import Camera.Andar;

public class Cancela {
    /**
     *  Andar ao qual esta cancela está associada.
     *  estado da cancela se true aberta se false fechado
     */
    private Andar andar;
    private boolean aberta;

    /**
     * constroi a cancela com base no andar
     * @param andar o andar a qual a cancela pertence
     */
    public Cancela(Andar andar) {
        this.andar = andar;
        this.aberta = false;
    }

    /**
     * abre a cancela
     * @return true cancela está aberta
     */

    public boolean abrirCancela(){
        this.aberta=true;
        return this.aberta;
    }

    /**
     * fecha a cancela
     * @return false cancela está fechada
     */

    public boolean fecharCancela(){
        this.aberta=false;
        return this.aberta;
    }

    /**
     * verifica o estado da cancela
     * @return estado da cancela se true aberta se false fechado
     */
    public boolean isAberta() {
        return aberta;
    }

    /**
     * qual andar a cancela está localizada
     * @return o andar da cancela 
     */
    public Andar getAndar() {
        return andar;
    }
}

