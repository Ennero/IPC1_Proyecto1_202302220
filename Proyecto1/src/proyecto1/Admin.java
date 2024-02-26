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

    JLabel titulo1lbl, lbl2, lbl3, lbl4, lbl5, lbl6;
    // JButton hace referencia a los botones
    JButton btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9, btn10, btn11, btn12;
    //JTabbedPane	
    JTabbedPane panel;
    //JPanels
    JPanel p1, p2, p3, p4;
    //Atributos para la tabla
    JTable tabla_oficial;
    JScrollPane sp1;
    
    
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
        btn1=new JButton("Crear Doctor");
        btn1.setBounds(1000,50,100,30);
        btn1.addActionListener(this);
        p1.add(btn1);
        
        
        
        
        titulo1lbl=new JLabel("Listado de doctores");
        
        
        
        
        this.setTitle("MÓDULO DE ESTUDIANTES");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setSize(1200, 700);
        this.getContentPane().add(panel);
        this.setVisible(true);
        setLocationRelativeTo(null);
        
    }
    
    
    @Override
    public void actionPerformed(ActionEvent e) {

    }

    @Override
    public void stateChanged(ChangeEvent e) {

    }
    
    
}
