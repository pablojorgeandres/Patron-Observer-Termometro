package ar.edu.ort.conclasesjava;

import java.util.Observable;
//Clase que representa un ObservadorConcreto
public class TermometroKelvin extends Termometro {

	public TermometroKelvin(Observable sujeto) {
		super(sujeto);
	}

	@Override
	protected double temperaturaConvertida(double kelvins) {
		return kelvins;
	}

    @Override
    public String toString() {
        return String.format("[%s]: %s", "TermometroKelvin", tempActual);
    }
}
