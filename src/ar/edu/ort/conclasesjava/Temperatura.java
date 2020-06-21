package ar.edu.ort.conclasesjava;

import java.util.Observable;

//La clase que representa al SujetoConcreto
public class Temperatura extends Observable {

    private double valor;//Temperatura expresada en Kelvin

    public Temperatura() {
        valor = 0;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        // el if evita que haya notificaciones innecesarias
        if (valor != this.valor) {
            this.valor = valor;
            // M�todos de Observable que notifican el cambio de estado. Ambos son necesarios, aunque no
            // necesariamente deben invocarse juntos.
            super.setChanged();
            super.notifyObservers();
            // notifyObservers() puede recibir un objeto de cualquier tipo. Se utiliza as� cuando no se quiere enviar el
            // objeto completo.
            //notifyObservers(new Double(valor));
        }
    }
}