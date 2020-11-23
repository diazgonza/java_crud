
package crud;

import java.sql.*;
import java.util.ArrayList;

public class daoProducto {
    Conexion c;
    
    public daoProducto(){
        c = new Conexion();
    }
    
    public boolean create (Producto p){
        try {
            String sql = "INSERT INTO producto (nombre, precio, cantidad, proveedor) VALUES (?,?,?,?)";
            PreparedStatement ps = c.conectar().prepareStatement(sql);
            ps.setString(1, p.getNombre());
            ps.setInt(2, p.getPrecio());
            ps.setInt(3, p.getCantidad());
            ps.setString(4, p.getProveedor());
            ps.execute();
            ps.close();
            ps = null;
            c.desconectar();
            return true;
        } catch (SQLException ex) {
            System.out.println("No se insertó registro");
            return false;
        }
    }
    
    public ArrayList<Producto> read(){
        
        ArrayList<Producto> lista = new ArrayList<Producto>();
        
        try {
            String sql = "SELECT * FROM producto";
            PreparedStatement ps = c.conectar().prepareStatement(sql);
            ResultSet rs = ps.executeQuery(sql);
            while (rs.next()){
                Producto p = new Producto();
                p.setIdproducto(rs.getInt("idproducto"));
                p.setNombre(rs.getString("nombre"));
                p.setPrecio(rs.getInt("precio"));
                p.setCantidad(rs.getInt("cantidad"));
                p.setProveedor(rs.getString("proveedor"));
                lista.add(p);
            }
            ps.close();
            ps = null;
            c.desconectar();            
        } catch (SQLException ex) {
            System.out.println("Falló método read");
        }
        return lista;        
    }
    
    public boolean delete(int id){
        try {
            String sql = "DELETE FROM producto WHERE idproducto=?";
            PreparedStatement ps = c.conectar().prepareStatement(sql);
            ps.setInt(1, id);
            ps.execute();
            ps.close();
            ps = null;
            c.desconectar();
            return true;
        } catch (SQLException ex) {
            return false;
        }  
    }
    
    public boolean update(Producto p){
        try {
            String sql = "UPDATE producto SET nombre=?, precio=?, cantidad=?, proveedor=? WHERE idproducto =?";
            PreparedStatement ps = c.conectar().prepareStatement(sql);
            ps.setString(1, p.getNombre());
            ps.setInt(2, p.getPrecio());
            ps.setInt(3, p.getCantidad());
            ps.setString(4, p.getProveedor());
            ps.setInt(5, p.getIdproducto());
            ps.execute();
            ps.close();
            ps = null;
            c.desconectar();
            return true;
        } catch (SQLException ex) {
            return false;
        }
    }
    
    public Producto read(int id){
        
        Producto p = new Producto();
        
        try {
            String sql = "SELECT * FROM producto WHERE idproducto=?";
            PreparedStatement ps = c.conectar().prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                p.setIdproducto(rs.getInt("idproducto"));
                p.setNombre(rs.getString("nombre"));
                p.setPrecio(rs.getInt("precio"));
                p.setCantidad(rs.getInt("cantidad"));
                p.setProveedor(rs.getString("proveedor"));
            }
            ps.close();
            ps = null;
            c.desconectar();            
        } catch (SQLException ex) {
            System.out.println("Falló método read producto");
        }
        return p;        
    }
}
