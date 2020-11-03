/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CRUDTaller2;

import Controlador.Controlador;
import Modelo.Equipos;
import Modelo.Operaciones;
import Vista.Listado;


public class CrudTaller2 {
    public static void main(String[] args) {
        
    
        Equipos mod = new Equipos();
        Operaciones modOp = new Operaciones();
        Listado modList = new Listado();
        Controlador ctrl = new Controlador(mod, modOp, modList);
        ctrl.iniciar();
        modList.setVisible(true);    
    }
}
