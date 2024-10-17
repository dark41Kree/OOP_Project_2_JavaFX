package AudioSystem;

import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;

public class Camera {
    private String nume;
    private int volume;
    public Difuzor[] difuzor=new Difuzor[5];
    public int nrdifuzoare=0;


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


    public void changeNumecamera(Camera camera,String nume){
        camera.nume=nume;
    }

    public void changeVolumecamera(Camera camera,int volume){
        camera.volume=volume;
    }

    public void addDifuzor(String poz, String frecv){
        if(nrdifuzoare<=4) {
            difuzor[nrdifuzoare]=new Difuzor(poz,frecv);
            nrdifuzoare=nrdifuzoare+1;
        }

    }


}
