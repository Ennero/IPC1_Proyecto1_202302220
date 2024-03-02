
package proyecto1;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.HeadlessException;
import java.awt.Image;
import javax.swing.JPanel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
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

/**
 *
 * @author Enner
 */
public class PacienteM extends JFrame implements ChangeListener,ActionListener,FocusListener {
    
    JLabel titulodlbl, tituloplbl, titulomlbl;
    // JButton hace referencia a los botones
    JButton editarbtn,regresar;
    //JTabbedPane	
    JTabbedPane panel;
    //JPanels
    JPanel p1, p2, p3;
    //Atributos para la tabla
    JTable tablaPacientes,tablaDoctores, tablaProductos;
    JScrollPane sp1,sp2,sp3;
    JTextArea motivo;
    JComboBox especialidad,doctor,fecha,hora;

    public PacienteM() throws HeadlessException {
        panel=new JTabbedPane(JTabbedPane.TOP);
        p1=new JPanel(null);
        panel.addTab("Solicitar Cita",p1);
        p2=new JPanel();
        p2.setLayout(null);
        panel.addTab("Ver estado de cita", p2);
        p3=new JPanel();
        p3.setLayout(null);
        panel.addTab("Farmacia",p3);
        panel.addChangeListener(this);
        
        editarbtn=new JButton("Editar perfil");
        editarbtn.setBounds(670,0,100,25);
        editarbtn.addActionListener(this);
        this.add(editarbtn);
        
        regresar=new JButton("Regresar");
        regresar.setBounds(550,0,100,25);
        regresar.addActionListener(this);
        this.add(regresar);
        //***************************************************************************************************************************************
        //Lo de las pestaña solicitar cita
        titulodlbl = new JLabel("Motivo de la cita:");
        titulodlbl.setBounds(0, 0, 300, 50);
        this.titulodlbl.setOpaque(true);
        titulodlbl.setVerticalAlignment(SwingConstants.CENTER);
        titulodlbl.setHorizontalAlignment(SwingConstants.CENTER);
        titulodlbl.setFont(new Font(titulodlbl.getFont().getFontName(), Font.BOLD, 24));
        Font font = titulodlbl.getFont();
        Map attributes = font.getAttributes();
        titulodlbl.setFont(font.deriveFont(attributes));
        titulodlbl.setVisible(true);
        p1.add(titulodlbl);
        
        motivo = new JTextArea();//TextBox del codigo
        motivo.setBounds(55,65, 690, 150);
        motivo.setForeground(Color.gray);
        motivo.addFocusListener(this);
        p1.add(motivo);
        
        JLabel espe=new JLabel("Especialidad:");
        espe.setFont(new Font("Arial", Font.BOLD, 16));
        espe.setBounds(55, 225, 125, 25);
        p1.add(espe);
        
        especialidad=new JComboBox<>(RegistroDoctores.especialito);
        especialidad.setBounds(170, 225, 110, 25);
        p1.add(especialidad);
        
        JLabel doc=new JLabel("Doctor:");
        espe.setFont(new Font("Arial", Font.BOLD, 16));
        espe.setBounds(55, 225, 125, 25);
        p1.add(espe);
        
        
        
        //*******************************************************************************************************************************************
        this.setTitle("Paciente");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setSize(800, 500);
        this.getContentPane().add(panel);
        this.setVisible(true);
        setLocationRelativeTo(null);
        
        
    }

    @Override
    public void stateChanged(ChangeEvent e) {

    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource()==editarbtn){
            Proyecto1.buscarp(Proyecto1.pacientes.get(Proyecto1.indice).getCodigo());
            Proyecto1.irAdmin=false;
            if(Proyecto1.found==true){
                ActualizarDatos actM=new ActualizarDatos();
                this.dispose();
            }else{
                JOptionPane.showMessageDialog(null, "No se encontró el código ","Codigo no encontrado",JOptionPane.INFORMATION_MESSAGE);
            }
        }
        if(ae.getSource()==regresar){
            Inicio ini=new Inicio();
            this.dispose();
        }

    }

    @Override
    public void focusGained(FocusEvent e) {

    }

    @Override
    public void focusLost(FocusEvent e) {

    }

    
    
    
    
    
    
    
    
    
    
   
    
    
    
    
}
