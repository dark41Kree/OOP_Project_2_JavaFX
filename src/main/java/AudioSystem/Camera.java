package AudioSystem;

import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;

public class Camera {
    private String nume;
    private int volume;
    public int index;
    public Difuzor[] difuzor=new Difuzor[5];
    private int nrdifuzoare=-1;


    public Camera(String nume, int volume){
        setNume(nume);
        setVolume(volume);
    }

    private void setNume(String nume){
        this.nume=nume;
    }
    public String getNume(){
        return this.nume;
    }
    private void setVolume(int volume){
        this.volume=volume;

    }
    public int getVolume(){
        return this.volume;
    }

    public int getIndex(){
        return this.index;
    }

    public void changeNumecamera(Camera camera,String nume){
        camera.nume=nume;
    }

    public void changeVolumecamera(Camera camera,int volume){
        camera.volume=volume;
    }

    public void addDifuzor(String poz, String frecv){
        if(nrdifuzoare<4) {
            nrdifuzoare=nrdifuzoare+1;
            difuzor[nrdifuzoare]=new Difuzor(poz,frecv);
        }else new Alert(Alert.AlertType.INFORMATION,"Aveti deja nr. maxim de difuzoare in camera care este 5 !" , ButtonType.OK).showAndWait();

    }

    public void getToateDifuzoarele(){
        if(nrdifuzoare>(-1)) {
            for (int i = 0; i <= nrdifuzoare; i++) {
                System.out.println("Difuzorul " + (i + 1));
                System.out.println("Pozitia: " + difuzor[i].getPozitie());
                System.out.println("Frecventa: " + difuzor[i].getFrecventa());
                System.out.println();
            }
        }else new Alert(Alert.AlertType.INFORMATION,"Nu aveti difuzoare instalate in aceasta camera!" , ButtonType.OK).showAndWait();
    }


}
