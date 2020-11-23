package crud;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import org.netbeans.lib.awtextra.*;

public class Vista extends JFrame {
    JLabel lblId, lblNombre, lblPrecio, lblCantidad, lblProveedor, lblIdproducto;
    JTextField txtNombre;
    JSpinner spnPrecio, spnCantidad;
    JComboBox cboProveedor;
    JScrollPane scroll;
    DefaultTableModel model;
    JTable tblDatos;
    JButton btnAgregar, btnEliminar, btnGuardar, btnLimpiar, btnPDF;
    
    public Vista(){
        this.setTitle("CRUD Java MariaDB");
        this.setSize(550, 600);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setLayout(new AbsoluteLayout());
        
        lblId = new JLabel("ID Producto");
        this.getContentPane().add(lblId, new AbsoluteConstraints(10, 10, 100, 20));
        
        lblNombre = new JLabel("Nombre");
        this.getContentPane().add(lblNombre, new AbsoluteConstraints(10, 40, 100, 20));
        
        lblPrecio = new JLabel("Precio");
        this.getContentPane().add(lblPrecio, new AbsoluteConstraints(10, 70, 100, 20));
        
        lblCantidad = new JLabel("Cantidad");
        this.getContentPane().add(lblCantidad, new AbsoluteConstraints(10, 100, 100, 20));
        
        lblProveedor = new JLabel("Proveedor");
        this.getContentPane().add(lblProveedor, new AbsoluteConstraints(10, 130, 100, 20));
        
        lblIdproducto = new JLabel("ID");
        this.getContentPane().add(lblIdproducto, new AbsoluteConstraints(120, 10, 100, 20));
        
        txtNombre = new JTextField();
        this.getContentPane().add(txtNombre, new AbsoluteConstraints(120, 40, 100, 20));
        
        spnPrecio = new JSpinner();
        this.getContentPane().add(spnPrecio, new AbsoluteConstraints(120, 70, 100, 20));
        
        spnCantidad = new JSpinner();
        this.getContentPane().add(spnCantidad, new AbsoluteConstraints(120, 100, 100, 20));
        
        Object items[] = new Object [4];
        items[0]="HP";
        items[1]="Lenovo";
        items[2]="Asus";
        items[3]="Toshiba";
        
        cboProveedor = new JComboBox(items);
        this.getContentPane().add(cboProveedor, new AbsoluteConstraints(120, 130, 100, 20));
        
        btnAgregar = new JButton("Agregar");
        this.getContentPane().add(btnAgregar, new AbsoluteConstraints(300, 10, 100, 20));
        
        btnEliminar = new JButton("Eliminar");
        this.getContentPane().add(btnEliminar, new AbsoluteConstraints(300, 40, 100, 20));
        
        btnGuardar = new JButton("Guardar");
        this.getContentPane().add(btnGuardar, new AbsoluteConstraints(300, 70, 100, 20));
        
        btnLimpiar = new JButton("Limpiar");
        this.getContentPane().add(btnLimpiar, new AbsoluteConstraints(300, 100, 100, 20));
        
        btnPDF = new JButton("Ver PDF");
        this.getContentPane().add(btnPDF, new AbsoluteConstraints(300, 130, 100, 20));
        
        tblDatos = new JTable();
        scroll = new JScrollPane();
        model = new DefaultTableModel();
        model.addColumn("Id Producto");
        model.addColumn("Nombre");
        model.addColumn("Precio");
        model.addColumn("Cantidad");
        model.addColumn("Proveedor");
        tblDatos.setModel(model);
        scroll.setViewportView(tblDatos);
        this.getContentPane().add(scroll, new AbsoluteConstraints(10, 200, 500, 300));
        this.setVisible(true);
    }
}
