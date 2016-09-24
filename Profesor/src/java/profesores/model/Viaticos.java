/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package profesores.model;

/**
 *
 * @author Jazmin Salmeron
 */
public class Viaticos {

    private int idViaticos;
    private int montoSolicitado;
    private int montoOtorgado;
    private int montoComprobado;
    private String comprobacionValida;
    

    public Viaticos(int idViaticos, int montoSolicitado, int montoOtorgado, int montoComprobado, String comprobacionValida ) {
        this.idViaticos = idViaticos;
        this.montoSolicitado = montoSolicitado;
        this.montoOtorgado = montoOtorgado;
        this.montoComprobado = montoComprobado;
        this.comprobacionValida = comprobacionValida;
       
    }

    public Viaticos() {
        this(0, 0, 0, 0, "");
    }

    public int getIdViaticos() {
        return idViaticos;
    }

    public void setIdViaticos(int idViaticos) {
        this.idViaticos = idViaticos;
    }

    public int getMontoSolicitado() {
        return montoSolicitado;
    }

    public void setMontoSolicitado(int montoSolicitado) {
        this.montoSolicitado = montoSolicitado;
    }

    public int getMontoOtorgado() {
        return montoOtorgado;
    }

    public void setMontoOtorgado(int montoOtorgado) {
        this.montoOtorgado = montoOtorgado;
    }

    public int getMontoComprobado() {
        return montoComprobado;
    }

    public void setMontoComprobado(int montoComprobado) {
        this.montoComprobado = montoComprobado;
    }

    public String getComprobacionValida() {
        return comprobacionValida;
    }

    public void setComprobacionValida(String comprobacionValida) {
        this.comprobacionValida = comprobacionValida;
    }

    @Override
    public String toString() {
        return "Viaticos{" + "idViaticos=" + idViaticos + ", montoSolicitado=" + montoSolicitado + ", montoOtorgado=" + montoOtorgado + ", montoComprobado=" + montoComprobado + ", comprobacionValida=" + comprobacionValida + '}';
    }

    
    

    

}
