package pattern.model;

public class Audio {
    private int idAudio;
    private String audio;
    private int idPregunta;

    public Audio() {
    }

    public Audio(int idAudio, String audio, int idPregunta) {
        this.idAudio = idAudio;
        this.audio = audio;
        this.idPregunta = idPregunta;
    }

    public int getIdAudio() {
        return idAudio;
    }

    public void setIdAudio(int idAudio) {
        this.idAudio = idAudio;
    }

    public String getAudio() {
        return audio;
    }

    public void setAudio(String audio) {
        this.audio = audio;
    }

    public int getIdPregunta() {
        return idPregunta;
    }

    public void setIdPregunta(int idPregunta) {
        this.idPregunta = idPregunta;
    }
}
