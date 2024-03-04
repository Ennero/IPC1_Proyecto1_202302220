
package proyecto1;
import java.awt.Color;
import java.awt.Component;
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
import java.util.HashMap;
import java.util.List;
import java.util.Map;



/**
 *
 * @author Enner
 */
public class Admin extends JFrame implements ActionListener, ChangeListener {

    JLabel titulodlbl, tituloplbl, titulomlbl;
    // JButton hace referencia a los botones
    JButton btnd1, btnd2, btnd3, btnp1, btnp2, btnp3, btnm1, btnm2, btnm3,regresar;
    //JTabbedPane	
    JTabbedPane panel;
    //JPanels
    JPanel p1, p2, p3, p4;
    //Atributos para la tabla
    JTable tablaPacientes,tablaDoctores, tablaProductos;
    JScrollPane sp1,sp2,sp3;
    
    
    public Admin() throws HeadlessException {
        panel=new JTabbedPane(JTabbedPane.TOP);
        p1=new JPanel(null);
        panel.addTab("Doctores",p1);
        p2=new JPanel();
        p2.setLayout(null);
        panel.addTab("Pacientes", p2);
        p3=new JPanel();
        p3.setLayout(null);
        panel.addTab("Productos",p3);
        p4=new JPanel();
        panel.addTab("Volver",p4);
        panel.addChangeListener(this);
        //**********************************************************************************************************************************************
        //Lo de la pestaña de doctores
        titulodlbl = new JLabel("Listado de doctores");
        titulodlbl.setBounds(45, 25, 750, 50);
        titulodlbl.setBorder(BorderFactory.createLineBorder(Color.black, 2));
        this.titulodlbl.setBackground(Color.LIGHT_GRAY);
        this.titulodlbl.setOpaque(true);
        titulodlbl.setVerticalAlignment(SwingConstants.CENTER);
        titulodlbl.setHorizontalAlignment(SwingConstants.CENTER);
        titulodlbl.setFont(new Font(titulodlbl.getFont().getFontName(), Font.BOLD, 24));
        Font font = titulodlbl.getFont();
        Map attributes = font.getAttributes();
        attributes.put(TextAttribute.UNDERLINE, TextAttribute.UNDERLINE_ON);
        titulodlbl.setFont(font.deriveFont(attributes));
        titulodlbl.setVisible(true);
        p1.add(titulodlbl);
        
        btnd1=new JButton("Crear Doctor");
        btnd1.setBounds(890,50,150,30);
        btnd1.addActionListener(this);
        p1.add(btnd1);
        
        btnd2=new JButton("Actualizar Doctor");
        btnd2.setBounds(890,100,150,30);
        btnd2.addActionListener(this);
        p1.add(btnd2);
        
        btnd3=new JButton("Eliminar Doctor");
        btnd3.setBounds(890,150,150,30);
        btnd3.addActionListener(this);
        p1.add(btnd3);
        
        String[] titulos_d = {"Nombres", "Apellidos", "Edad", "Sexo", "Código","Especialidad","Teléfono"};
        tablaDoctores = new JTable(Proyecto1.tablearD(), titulos_d);
        DefaultTableCellRenderer Alineard = new DefaultTableCellRenderer();
        Alineard.setHorizontalAlignment(SwingConstants.CENTER);
        for (int i = 0; i < titulos_d.length; i++) {
            tablaDoctores.getColumnModel().getColumn(i).setCellRenderer(Alineard);
        }
       
        tablaDoctores.setEnabled(false);
        sp1 = new JScrollPane(tablaDoctores);
        sp1.setBounds(45, 80, 750, 570);
        sp1.setVisible(true);
        p1.add(sp1);
        
        String[][] espC=Proyecto1.contarespecialidad(); 
        DefaultCategoryDataset datos=new DefaultCategoryDataset();
        try{
            for(int i=0; i<espC.length;i++){
                if(i<5){
                    datos.addValue(Integer.parseInt(espC[i][1]),"Especialidad" , espC[i][0]);
                }else{
                    break;
                }
        }
        }catch(Exception e){
        }
        JFreeChart grafica=ChartFactory.createBarChart("Top Especialidades","Especialidad","",datos,PlotOrientation.VERTICAL,false,true,false);
        ChartPanel pana=new ChartPanel(grafica);
        pana.setBounds(815, 250, 360, 300);
        p1.add(pana);
        
        
        
        //********************************************************************************************************************************************
        //Lo de la pestaña de pacientes
        tituloplbl = new JLabel("Listado de Pacientes");
        tituloplbl.setBounds(45, 25, 750, 50);
        tituloplbl.setBorder(BorderFactory.createLineBorder(Color.black, 2));
        this.tituloplbl.setBackground(Color.LIGHT_GRAY);
        this.tituloplbl.setOpaque(true);
        tituloplbl.setVerticalAlignment(SwingConstants.CENTER);
        tituloplbl.setHorizontalAlignment(SwingConstants.CENTER);
        tituloplbl.setFont(new Font(tituloplbl.getFont().getFontName(), Font.BOLD, 24));
        Font font2 = tituloplbl.getFont();
        Map attributes2 = font2.getAttributes();
        attributes2.put(TextAttribute.UNDERLINE, TextAttribute.UNDERLINE_ON);
        tituloplbl.setFont(font.deriveFont(attributes2));
        tituloplbl.setVisible(true);
        p2.add(tituloplbl);
        
        btnp1=new JButton("Crear Paciente");
        btnp1.setBounds(890,50,150,30);
        btnp1.addActionListener(this);
        p2.add(btnp1);
        
        btnp2=new JButton("Actualizar Paciente");
        btnp2.setBounds(890,100,150,30);
        btnp2.addActionListener(this);
        p2.add(btnp2);
        
        btnp3=new JButton("Eliminar Paciente");
        btnp3.setBounds(890,150,150,30);
        btnp3.addActionListener(this);
        p2.add(btnp3);
        
        
        String[] titulos_c = {"Nombres", "Apellidos", "Edad", "Sexo", "Código"};
        tablaPacientes = new JTable(Proyecto1.tablear(), titulos_c);
        DefaultTableCellRenderer Alinear = new DefaultTableCellRenderer();
        Alinear.setHorizontalAlignment(SwingConstants.CENTER);
        for (int i = 0; i < titulos_c.length; i++) {
            tablaPacientes.getColumnModel().getColumn(i).setCellRenderer(Alinear);
        }
        tablaPacientes.setEnabled(false);

        sp2 = new JScrollPane(tablaPacientes);
        sp2.setBounds(45, 80, 750, 570);
        sp2.setVisible(true);
        p2.add(sp2);
        
        //******************************************************************************************************************************************
        //Lo de las medicinas
        titulomlbl = new JLabel("Listado de Productos");
        titulomlbl.setBounds(45, 25, 750, 50);
        titulomlbl.setBorder(BorderFactory.createLineBorder(Color.black, 2));
        this.titulomlbl.setBackground(Color.LIGHT_GRAY);
        this.titulomlbl.setOpaque(true);
        titulomlbl.setVerticalAlignment(SwingConstants.CENTER);
        titulomlbl.setHorizontalAlignment(SwingConstants.CENTER);
        titulomlbl.setFont(new Font(titulomlbl.getFont().getFontName(), Font.BOLD, 24));
        Font font3 = titulomlbl.getFont();
        Map attributes3 = font3.getAttributes();
        attributes3.put(TextAttribute.UNDERLINE, TextAttribute.UNDERLINE_ON);
        titulomlbl.setFont(font.deriveFont(attributes2));
        titulomlbl.setVisible(true);
        p3.add(titulomlbl);
        
        btnm1=new JButton("Añadir Producto");
        btnm1.setBounds(890,50,150,30);
        btnm1.addActionListener(this);
        p3.add(btnm1);
        
        btnm2=new JButton("Actualizar Producto");
        btnm2.setBounds(890,100,150,30);
        btnm2.addActionListener(this);
        p3.add(btnm2);
        
        btnm3=new JButton("Eliminar Producto");
        btnm3.setBounds(890,150,150,30);
        btnm3.addActionListener(this);
        p3.add(btnm3);
        
        String[] titulos_M = {"Codigo", "Nombre", "Cantidad", "Descripción", "Precio"};
        tablaProductos = new JTable(Proyecto1.tablearM(), titulos_M);
        DefaultTableCellRenderer AlinearM = new DefaultTableCellRenderer();
        AlinearM.setHorizontalAlignment(SwingConstants.CENTER);
        for (int i = 0; i < titulos_M.length; i++) {
            tablaProductos.getColumnModel().getColumn(i).setCellRenderer(AlinearM);
        }
        tablaProductos.setEnabled(false);
        sp3 = new JScrollPane(tablaProductos);
        sp3.setBounds(45, 80, 750, 570);
        sp3.setVisible(true);
        p3.add(sp3);
        
        int[] productoN=Proyecto1.contarproductos();
        DefaultCategoryDataset datos3=new DefaultCategoryDataset();
        try{
            for(int i=0; i<productoN.length;i++){
                if(i<3){
                    Proyecto1.buscarMNCantidad(productoN[i]);
                    datos3.addValue(productoN[i],"Producto" , Proyecto1.productos.get(Proyecto1.posicion).getNombre());
                }else{
                    break;
                }
        }
        }catch(Exception e){
            System.out.println("Pudo explotar pero lo evite con el try-catch, denada :)");
        }
        JFreeChart grafica2=ChartFactory.createBarChart("Top Productos","Productos","",datos3,PlotOrientation.VERTICAL,false,true,false);
        ChartPanel pana2=new ChartPanel(grafica2);
        pana2.setBounds(815, 250, 360, 300);
        p3.add(pana2);
                
        //*******************************************************************************************************************************************
        this.setTitle("Administrador");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setSize(1200, 700);
        this.getContentPane().add(panel);
        this.setVisible(true);
        setLocationRelativeTo(null);
        
        regresar=new JButton("Regresar");
        regresar.setBounds(100,400,800,300);
        regresar.setFont(new Font("Arial",Font.CENTER_BASELINE,250));
        regresar.addActionListener(this);
        p4.add(regresar);
        
    }
    
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        //********************************************************************************************************************************/////
        //Lo de los lindos doctores
        if(ae.getSource()==btnd1){
            Proyecto1.registro=true;
            RegistroDoctores registroD=new RegistroDoctores();
            this.dispose();
        }
        if(ae.getSource()==btnd2){
            String codigod= JOptionPane.showInputDialog("Ingrese el código del Doctor");
            Proyecto1.buscard (codigod);
            if(Proyecto1.found==true){
                ActualizarDoctores acti=new ActualizarDoctores();
                this.dispose();
            }else{
                JOptionPane.showMessageDialog(null, "No se encontró el código " + codigod+ " dentro del listado de doctores","Codigo no encontrado",JOptionPane.INFORMATION_MESSAGE);
            }
        }
        if(ae.getSource()==btnd3){
            String codigod=JOptionPane.showInputDialog("Ingrese el código del Doctor");
            Proyecto1.buscard(codigod);
            if(Proyecto1.found==true){
                Proyecto1.doctores.remove(Proyecto1.posicion);
                Admin aes=new Admin();
                this.dispose();
            }else{
                JOptionPane.showMessageDialog(null, "No se encontró el código " + codigod + " dentro del listado de doctores","Codigo no encontrado",JOptionPane.INFORMATION_MESSAGE);
            }
        }
        
        //***********************************************************************************************************************************************
        if(ae.getSource()==btnp1){
            Proyecto1.registro=true;//Se pode true para que regrese a admin después o, sino, regrese al inicio
            Registro registro=new Registro();
            this.dispose();
        }
        if(ae.getSource()==btnp2){
            String codigo= JOptionPane.showInputDialog("Ingrese el código del paciente");
            Proyecto1.buscarp(codigo);
            if(Proyecto1.found==true){
                Proyecto1.irAdmin=true;
                ActualizarDatos act=new ActualizarDatos();
                this.dispose();
            }else{
                JOptionPane.showMessageDialog(null, "No se encontró el código " + codigo + " dentro del listado de pacientes","Codigo no encontrado",JOptionPane.INFORMATION_MESSAGE);
            }
        }
        if(ae.getSource()==btnp3){
            String codigo=JOptionPane.showInputDialog("Ingrese el código del paciente");
            Proyecto1.buscarp(codigo);
            if(Proyecto1.found==true){
                Proyecto1.pacientes.remove(Proyecto1.posicion);
                JOptionPane.showMessageDialog(null, "Paciente eliminado exitosamente","Eliminación exitosa",JOptionPane.INFORMATION_MESSAGE);
                Admin aa=new Admin();
                this.dispose();
            }else{
                JOptionPane.showMessageDialog(null, "No se encontró el código " + codigo + " dentro del listado de pacientes","Codigo no encontrado",JOptionPane.INFORMATION_MESSAGE);
            }
        }
//*******************************************************************************************************************************************************
        if(ae.getSource()==btnm1){
            Proyecto1.registro=true;//Se pone true para que regrese a admin después o, sino, regrese al inicio
            Añadir registrom=new Añadir();
            this.dispose();
        }
        if(ae.getSource()==btnm2){
            String codigoM= JOptionPane.showInputDialog("Ingrese el código del producto");
            Proyecto1.buscarm(codigoM);
            if(Proyecto1.found==true){
                ActualizarProducto actM=new ActualizarProducto();
                this.dispose();
            }else{
                JOptionPane.showMessageDialog(null, "No se encontró el código " + codigoM + " dentro del listado de productos","Codigo no encontrado",JOptionPane.INFORMATION_MESSAGE);
            }
        }
        if(ae.getSource()==btnm3){
            String codigoM=JOptionPane.showInputDialog("Ingrese el código del producto");
            Proyecto1.buscarm(codigoM);
            if(Proyecto1.found==true){
                Proyecto1.irAdmin=true;
                Proyecto1.productos.remove(Proyecto1.posicion);
                JOptionPane.showMessageDialog(null, "Producto eliminado exitosamente","Eliminación exitosa",JOptionPane.INFORMATION_MESSAGE);
                Admin aa=new Admin();
                this.dispose();
            }else{
                JOptionPane.showMessageDialog(null, "No se encontró el código " + codigoM + " dentro del listado de productos","Codigo no encontrado",JOptionPane.INFORMATION_MESSAGE);
            }
        }
        if(ae.getSource()==regresar){
            Inicio aaa=new Inicio();
            this.dispose();
        }
        










    }

    @Override
    public void stateChanged(ChangeEvent e) {
             

    }
    
    
    
    
}
