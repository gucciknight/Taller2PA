package Controlador;

import Modelo.Equipos;
import Modelo.Operaciones;
import Vista.Listado;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

public class Controlador implements ActionListener {
    
    private Equipos mod;
    private Operaciones modOp;
    private Listado modList;
    
    public Controlador(Equipos mod, Operaciones modOp, Listado modList){
        this.mod = mod;
        this.modOp = modOp;
        this.modList = modList;
        this.modList.btnBuscar.addActionListener(this);
        this.modList.btnGuardar.addActionListener(this);
        this.modList.btnModificar.addActionListener(this);
        this.modList.btnEliminar.addActionListener(this);
        this.modList.btnLimpiar.addActionListener(this);
    }
    
    public void iniciar() {
        
        modList.setTitle("Listado de Equipos");
        modList.setLocationRelativeTo(null);
    }
    
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == modList.btnGuardar) {
            mod.setTipoEquipo(modList.txtEquipo.getText());
            mod.setMarca(modList.txtMarca.getText());
            mod.setNroSerie(Integer.parseInt(modList.txtNroSerie.getText()));
            mod.setAñoFab(Integer.parseInt(modList.txtAñoFab.getText()));
            mod.setEstado(modList.txtEstado.getText());
            
            if (modOp.guardar(mod)) {
                JOptionPane.showMessageDialog(null, "Equipo Guardado");
                limpiar();
            } else {
                JOptionPane.showMessageDialog(null, "Error al guardar");
                limpiar();
            }
        }

        if (e.getSource() == modList.btnModificar) {
            mod.setTipoEquipo(modList.txtEquipo.getText());
            mod.setMarca(modList.txtMarca.getText());
            mod.setNroSerie(Integer.parseInt(modList.txtNroSerie.getText()));
            mod.setAñoFab(Integer.parseInt(modList.txtAñoFab.getText()));
            mod.setEstado(modList.txtEstado.getText());
            
            if (modOp.modificar(mod)) {
                JOptionPane.showMessageDialog(null, "Equipo Modificado");
                limpiar();
            } else {
                JOptionPane.showMessageDialog(null, "Error al Modificar");
                limpiar();
            }
        }

        if (e.getSource() == modList.btnEliminar) {
            mod.setNroSerie(Integer.parseInt(modList.txtNroSerie.getText()));
            
            if (modOp.eliminar(mod)) {
                JOptionPane.showMessageDialog(null, "Equipo Eliminado");
                limpiar();
            } else {
                JOptionPane.showMessageDialog(null, "Error al eliminar");
                limpiar();
            }
        }

        if (e.getSource() == modList.btnBuscar) {
            mod.setNroSerie(Integer.parseInt(modList.txtNroSerie.getText()));
            
            if (modOp.buscar(mod)) {
                mod.setTipoEquipo(modList.txtEquipo.getText());
                mod.setMarca(modList.txtMarca.getText());
                mod.setNroSerie(Integer.parseInt(modList.txtNroSerie.getText()));
                mod.setAñoFab(Integer.parseInt(modList.txtAñoFab.getText()));
                mod.setEstado(modList.txtEstado.getText());
            } else {
                JOptionPane.showMessageDialog(null, "No se encontró el Equipo");
                limpiar();
            }
        }
        
        if (e.getSource() == modList.btnLimpiar) {
            limpiar();
        }
    }
    
    public void limpiar() {

        modList.txtEquipo.setText(null);
        modList.txtMarca.setText(null);
        modList.txtNroSerie.setText(null);
        modList.txtAñoFab.setText(null);
        modList.txtEstado.setText(null);
    } 
}
