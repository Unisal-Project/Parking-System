package Camera;
import Factory.*;

public class CameraReconhecimento {
    private String loc;
    private Andar andar;

    public CameraReconhecimento(String loc, Andar andar){
        this.loc = loc;
        this.andar = andar;
    }

    public String identificarPlaca(Veiculo veiculo) {
        return veiculo.getPlaca();
    }

    public Andar getAndar() {
        return andar;
    }

    public String getLocaizacao() {
        return loc;
    }
}