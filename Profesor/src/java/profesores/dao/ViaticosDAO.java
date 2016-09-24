/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package profesores.dao;

import java.util.List;
import profesores.model.Viaticos;

/**
 *
 * @author Jazmin Salmeron
 */
public interface ViaticosDAO {
    void agregarViaticos(Viaticos viatico);
    void borrarViaticos(int idViaticos);
    void cambiarViaticos(Viaticos viatico);
    
    List<Viaticos> desplegarViaticos();
    Viaticos elegirViaticos (int idViaticos);
    
}
