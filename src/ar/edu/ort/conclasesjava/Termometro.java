package ar.edu.ort.conclasesjava;

import java.util.Observable;
import java.util.Observer;

//Clase que representa un tipo de ObservadorConcreto
public abstract class Termometro implements Observer {

    private 	Temperatura sujeto;
    protected 	double tempActual;

    public Termometro(Observable sujeto) {
        this.sujeto = (Temperatura) sujeto;
        sujeto.addObserver(this);
        update(sujeto, null);// si fuese necesario, actualizo la primera "vista" del valor.
    }
    
    // servir� para calcular la temperatura en el sistema que corresponda.
    protected abstract double temperaturaConvertida(double kelvins);

    // Implementamos update pensando que el sujeto puede o no enviarnos un segundo par�metro
    // con la informaci�n que estamos escuchando (data).
    // Como la firma del m�todo es gen�rica, siempre deberemos conocer c�mo transformarla en lo que necesitamos.
    @Override
    public void update(Observable sujeto, Object data) {
        if (data != null && data instanceof Double) {
            tempActual = temperaturaConvertida((Double) data);
        } else {
            tempActual = temperaturaConvertida(((Temperatura) sujeto).getValor());
        }
        // actualizamos la "vista"
        show();
    }

    private void show() {
        System.out.println(this);
    }

    public void desuscribir() {
        sujeto.deleteObserver(this);
    }
}