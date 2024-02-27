/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
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

/**
 *
 * @author Enner
 */
public class Admin extends JFrame implements ActionListener, ChangeListener {

    JLabel titulodlbl, tituloplbl, titulomlbl;
    // JButton hace referencia a los botones
    JButton btnd1, btnd2, btnd3, btnp1, btnp2, btnp3, btn7, btn8, btn9, btn10, btn11, btn12;
    //JTabbedPane	
    JTabbedPane panel;
    //JPanels
    JPanel p1, p2, p3, p4;
    //Atributos para la tabla
    JTable tablaPacientes,tablaDoctores, tablaMedicinas;
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
        
        
        
        this.setTitle("Administrador");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setSize(1200, 700);
        this.getContentPane().add(panel);
        this.setVisible(true);
        setLocationRelativeTo(null);
        
    }
    
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource()==btnp1){
            Proyecto1.registrop=true;
            Registro registro=new Registro();
            this.dispose();
        }
        if(ae.getSource()==btnp2){
            String codigo= JOptionPane.showInputDialog("Ingrese el código del paciente");
            Proyecto1.buscarp(codigo);
            if(Proyecto1.found==true){
                ActualizarDatos act=new ActualizarDatos();
                this.dispose();
            }else{
                JOptionPane.showMessageDialog(null, "No se encontró el código ingresado" + codigo,"Codigo no encontrado",JOptionPane.INFORMATION_MESSAGE);
            }
        }
        if(ae.getSource()==btnp3){
            String codigo=JOptionPane.showInputDialog("Ingrese el código del paciente");
            Proyecto1.buscarp(codigo);
            if(Proyecto1.found==true){
                Proyecto1.pacientes.remove(Proyecto1.posicion);
                Admin aa=new Admin();
                this.dispose();
            }else{
                JOptionPane.showMessageDialog(null, "No se encontró el código ingresado" + codigo,"Codigo no encontrado",JOptionPane.INFORMATION_MESSAGE);
            }
        }

    }

    @Override
    public void stateChanged(ChangeEvent e) {

    }
    
    
}
