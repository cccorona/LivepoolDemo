package cesar.cabrera.mx.com.livepooldemo.model;

import java.io.Serializable;

public class Historic implements Serializable {

    private String termino;
    private long fecha;


    public Historic(String termino, long fecha) {
        this.termino = termino;
        this.fecha = fecha;
    }

    public String getTermino() {
        return termino;
    }

    public void setTermino(String termino) {
        this.termino = termino;
    }

    public long getFecha() {
        return fecha;
    }

    public void setFecha(long fecha) {
        this.fecha = fecha;
    }
}
