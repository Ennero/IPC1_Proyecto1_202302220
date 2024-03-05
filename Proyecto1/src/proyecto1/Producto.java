
package proyecto1;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.HeadlessException;
import java.awt.Image;
import javax.swing.JPanel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.font.TextAttribute;
import java.text.MessageFormat;
import java.util.Map;
import javax.swing.*;
import javax.swing.JTabbedPane;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumnModel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
/**
 *
 * @author Enner
 */
public class Producto {
    private String nombre,precio,descripcion,codigo;
    private int cantidad;
    
    JPanel jp1;
    JLabel lbl1,lbl2, lbl3;

    public Producto(String codigo, String nombre,int cantidad, String descripcion, String precio ) {
        this.nombre = nombre;
        this.precio = precio;
        this.descripcion = descripcion;
        this.codigo = codigo;
        this.cantidad = cantidad;
        initComponents();
    }
    
    
    
    public void initComponents() {
        jp1 = new JPanel();
        jp1.setLayout(null);
        jp1.setBackground(Color.white);
        jp1.setPreferredSize(new Dimension(250, 120));

        // Calcular las coordenadas para centrar horizontalmente y verticalmente
        int ancholbl = 230;
        int altolbl = 30;
        
        lbl1 = new JLabel("Nombre: " + this.getNombre());
        lbl1.setFont(new Font("Arial", Font.BOLD, 15));
        lbl1.setForeground(Color.green);
        lbl1.setBounds(5, 5, ancholbl, altolbl);
        lbl1.setVerticalAlignment(SwingConstants.CENTER);
        lbl1.setHorizontalAlignment(SwingConstants.CENTER);
        jp1.add(lbl1);

        lbl2 = new JLabel("Descripción: " + this.getDescripcion());
        lbl2.setFont(new Font("Arial", Font.BOLD, 9));
        lbl2.setForeground(Color.gray);
        lbl2.setBounds(5, 75, ancholbl, altolbl);
        lbl2.setVerticalAlignment(SwingConstants.CENTER);
        lbl2.setHorizontalAlignment(SwingConstants.CENTER);
        jp1.add(lbl2);
        
        lbl3 = new JLabel("Precio: " + this.getPrecio());
        lbl3.setFont(new Font("Arial", Font.BOLD, 16));
        lbl3.setForeground(Color.red);
        lbl3.setBounds(5, 40, ancholbl, altolbl);
        lbl3.setVerticalAlignment(SwingConstants.CENTER);
        lbl3.setHorizontalAlignment(SwingConstants.CENTER);
        jp1.add(lbl3);

        jp1.setVisible(true);
    }
    public JPanel getPanel(){
        return jp1;
    }
    

    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @return the precio
     */
    public String getPrecio() {
        return precio;
    }

    /**
     * @param precio the precio to set
     */
    public void setPrecio(String precio) {
        this.precio = precio;
    }

    /**
     * @return the descripcion
     */
    public String getDescripcion() {
        return descripcion;
    }

    /**
     * @param descripcion the descripcion to set
     */
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    /**
     * @return the codigo
     */
    public String getCodigo() {
        return codigo;
    }

    /**
     * @param codigo the codigo to set
     */
    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    /**
     * @return the cantidad
     */
    public int getCantidad() {
        return cantidad;
    }

    /**
     * @param cantidad the cantidad to set
     */
    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

  
    
    
    

    
}
