/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import model.Store;

/**
 *

 */
public interface StoreDAO {
    void insertarStore(Store store);
    void borrarStore(int idPidBo);
    void cambiarStore(Store store);
    
    List<Store> desplegarStore();
    Store elegirStore(int idPidEle);
    
}
