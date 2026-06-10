package Facade;

import Camera.Andar;

public class Cancela {
    private Andar andar;
    private boolean aberta;

    public Cancela(Andar andar) {
        this.andar = andar;
        this.aberta = false;
    }
    public boolean abrirCancela(){
        this.aberta=true;
        return this.aberta;
    }

    public boolean fecharCancela(){
        this.aberta=false;
        return this.aberta;
    }

    public boolean isAberta() {
        return aberta;
    }

    public Andar getAndar() {
        return andar;
    }
}

