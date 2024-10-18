package AudioSystem;

public class AudioSystem {

    public static AudioSystem sistem=null;
    private String nume_audioSystem;
    public Camera[] camera=new Camera[10];
    public int nrcamere;



    private AudioSystem(String nume_audioSystem){
        setNumeSistem(nume_audioSystem);
        nrcamere=0;
    }

    public static AudioSystem get_System(String nume_audioSystem){
        if(sistem==null){
            sistem=new AudioSystem(nume_audioSystem);
            return sistem;
        } else return sistem;
    }

    private void setNumeSistem(String nume_audioSystem){
        this.nume_audioSystem =nume_audioSystem;
    }

    public String getNumeSistem(){
        return sistem.nume_audioSystem;
    }

    public int getNumarcamere(){
        return sistem.nrcamere;
    }

    public void addcamera(String nume, int volume){
        sistem.camera[nrcamere]= new Camera(nume,volume);
        sistem.nrcamere=sistem.nrcamere+1;
    }

}

