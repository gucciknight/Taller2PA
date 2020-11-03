package Modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class Operaciones extends Conexion {
    private int rs;
    
    public boolean guardar (Equipos eq){
        PreparedStatement ps = null;
        Connection con = getConexion();
        String sql = "INSERT INTO `equipo`(`nroserie`, `marca`, `tipoEquipo`, `anoFab`, `estado`) VALUES ('"+ eq.getNroSerie() +"','"+ eq.getMarca() +"','"+ eq.getTipoEquipo() +"',"+ eq.getAñoFab() +",'"+ eq.getEstado() +"')";      
        try{
            ps = con.prepareStatement(sql);
            rs = ps.executeUpdate(sql);
            System.out.println(eq.añoFab);
            System.out.println("Data from online Database :");
            return true;
            
        } catch (SQLException e) {
            System.err.println(e);
            return false;
            
        } finally {
            try {
                con.close();
            } catch (SQLException e) {
                System.err.println(e);
            }
        }
    }
    
    public boolean modificar(Equipos eq) {
        PreparedStatement ps = null;
        Connection con = getConexion();
        String sql = "UPDATE producto SET tipoEquipo=?, marca=?, nroSerie=?, añoFab=?, estado=? WHERE codigo = ?)";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, eq.getTipoEquipo());
            ps.setString(2, eq.getMarca());
            ps.setInt(3, eq.getNroSerie());
            ps.setInt(4, eq.getAñoFab());
            ps.setString(5, eq.getEstado());
            ps.execute();
            return true;
        } catch (SQLException e) {
            System.err.println(e);
            return false;
        } finally {
            try {
                con.close();
            } catch (SQLException e) {
                System.err.println(e);
            }
        }
    }
    
    public boolean eliminar(Equipos eq) {
        PreparedStatement ps = null;
        Connection con = getConexion();
        String sql = "DELETE FROM producto WHERE nroSerie = ?)";
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, eq.getNroSerie());
            ps.execute();
            return true;
        } catch (SQLException e) {
            System.err.println(e);
            return false;
        } finally {
            try {
                con.close();
            } catch (SQLException e) {
                System.err.println(e);
            }
        }
    }
    
    public boolean buscar(Equipos eq) {
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection con = getConexion();
        String sql = "SELECT * FROM producto WHERE nroSerie = ?)";
        try{
            ps = con.prepareStatement(sql);
            ps.setInt(1, eq.getNroSerie());
            rs = ps.executeQuery();
            if (rs.next())
            {
               eq.setTipoEquipo(rs.getString("tipo equipo"));
               eq.setMarca(rs.getString("marca"));
               eq.setNroSerie(Integer.parseInt(rs.getString("nro serie")));
               eq.setAñoFab(Integer.parseInt(rs.getString("año fab")));
               eq.setEstado(rs.getString(rs.getString("estado"))); 
               return true;
        } 
            return false;       
        }catch (SQLException e) {
            System.err.println(e);
            return false;
        } finally {
            try {
                con.close();
            } catch (SQLException e) {
                System.err.println(e);
            }
        }
    }
}
