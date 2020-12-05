
package crud;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class Controlador implements ActionListener, MouseListener {
    
    Vista v;
    Producto p, p1;
    daoProducto dao;
    int id = 0;
    
    public static void main (String[] args){
        Controlador c = new Controlador();
    }    
    public Controlador(){
        v = new Vista();
        dao = new daoProducto();
        p1 = new Producto();
        
        v.btnAgregar.addActionListener(this);
        v.btnEliminar.addActionListener(this);
        v.btnGuardar.addActionListener(this);
        v.btnLimpiar.addActionListener(this);
        v.btnPDF.addActionListener(this);
        v.tblDatos.addMouseListener(this);
        refrescarTabla();
        
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == v.btnAgregar){
            p = new Producto();
            p.setNombre(v.txtNombre.getText());
            p.setPrecio(Integer.parseInt(v.spnPrecio.getValue().toString()));
            p.setCantidad(Integer.parseInt(v.spnCantidad.getValue().toString()));
            p.setProveedor(v.cboProveedor.getSelectedItem().toString());
            if(!dao.create(p)){
                JOptionPane.showMessageDialog(this.v, "No se insertó registro");
            }
            limpiarCampos();
        }
        
        if(e.getSource() == v.btnEliminar){
            int x = JOptionPane.showConfirmDialog(this.v, "ESTAS SEGURO DE ELIMINAR ESTE REGISTRO?");
            if(x == 0){
                if(!dao.delete(id)){
                    JOptionPane.showMessageDialog(this.v, "No se pudo eliminar el registro");
                }
            }
        }
        
        if(e.getSource() == v.btnGuardar){
            
            p1.setNombre(v.txtNombre.getText());
            p1.setPrecio(Integer.parseInt(v.spnPrecio.getValue().toString()));
            p1.setCantidad(Integer.parseInt(v.spnCantidad.getValue().toString()));
            p1.setProveedor(v.cboProveedor.getSelectedItem().toString());
            
            if(!dao.update(p1)){
                JOptionPane.showMessageDialog(this.v, "No se actualizó registro");
            }
        }
        
        if(e.getSource() == v.btnLimpiar){
            limpiarCampos();
        }
        
        if(e.getSource() == v.btnPDF){
            
        }
        
        refrescarTabla();
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if(e.getSource() == v.tblDatos){
            int fila = v.tblDatos.getSelectedRow();
            id = Integer.parseInt(v.tblDatos.getValueAt(fila, 0).toString());
            p1 = dao.read(id);
            v.lblIdproducto.setText(""+p1.getIdproducto());
            v.txtNombre.setText(p1.getNombre());
            v.spnPrecio.setValue(p1.getPrecio());
            v.spnCantidad.setValue(p1.getCantidad());
            v.cboProveedor.setSelectedItem(p1.getProveedor());
        }
    }
    
    public void limpiarCampos(){
        v.txtNombre.setText("");
        v.spnPrecio.setValue(0);
        v.spnCantidad.setValue(0);
        v.cboProveedor.setSelectedIndex(0);
        v.lblIdproducto.setText("");
    }
    
    
    public void refrescarTabla(){
        while(v.model.getRowCount()>0){
            v.model.removeRow(0);
        }
        
        ArrayList<Producto> lista = dao.read();
        for(Producto p: lista){
           Object item[] = new Object [5];
           item [0] = p.getIdproducto();
           item [1] = p.getNombre();
           item [2] = p.getPrecio();
           item [3] = p.getCantidad();
           item [4] = p.getProveedor();
           v.model.addRow(item);
        }
        v.tblDatos.setModel(v.model);
    }

    @Override
    public void mousePressed(MouseEvent e) {
        
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        
    }

    @Override
    public void mouseExited(MouseEvent e) {
        
    }
    
}
