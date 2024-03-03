
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
    
    JLabel titulodlbl ,titulomlbl,horalbl,datelbl,doc,horariolbl;
    // JButton hace referencia a los botones
    JButton editarbtn,regresar,mostrarDbtn,mostrarHbtn,mostrarhorasbtn,generar,historialbtn;
    //JTabbedPane	
    JTabbedPane panel;
    //JPanels
    JPanel p1, p2, p3;
    //Atributos para la tabla
    JTable tablaPacientes,tablaDoctores, tablaProductos;
    JScrollPane sp1,sp2,sp3;
    JTextArea motivo;
    JTable tablacitas;
    JComboBox date,time,especialidad,doctoradd;
    public static DefaultComboBoxModel<String> doctor=new DefaultComboBoxModel<>();
    public static DefaultComboBoxModel<String> fecha=new DefaultComboBoxModel<>();
    public static DefaultComboBoxModel<String> hora=new DefaultComboBoxModel<>();

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
        //Lo de las pestaña de solicitar cita
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
        
        mostrarDbtn=new JButton("Mostrar doctores");
        mostrarDbtn.setBounds(300,225,130,25);
        mostrarDbtn.addActionListener(this);
        p1.add(mostrarDbtn);
        
         doc=new JLabel("Doctor:");
            doc.setFont(new Font("Arial", Font.BOLD, 16));
            doc.setBounds(55, 265, 125, 25);
            doc.setEnabled(false);
            p1.add(doc);
        
        doctoradd=new JComboBox<>(doctor);
        doctoradd.setBounds(170, 265, 110, 25);
        doctoradd.setEnabled(false);
        p1.add(doctoradd);
        
        mostrarHbtn=new JButton("Mostrar horarios");
        mostrarHbtn.setBounds(300,265,130,25);
        mostrarHbtn.addActionListener(this);
        mostrarHbtn.setEnabled(false);
        p1.add(mostrarHbtn);
        
        horariolbl=new JLabel("Horarios de citas disponibles");
        horariolbl.setFont(new Font("Arial", Font.BOLD, 16));
        horariolbl.setBounds(55, 295, 230, 25);
        horariolbl.setEnabled(false);
        p1.add(horariolbl);
        
        JLabel datelbl=new JLabel("Fecha:");
        datelbl.setFont(new Font("Arial", Font.BOLD, 16));
        datelbl.setBounds(55, 325, 145, 25);
        datelbl.setEnabled(false);
        p1.add(datelbl);

        date=new JComboBox<>(fecha);
        date.setBounds(130, 325, 145, 25);
        date.setEnabled(false);
        p1.add(date);
        
        mostrarhorasbtn=new JButton("Mostrar Horas disponibles");
        mostrarhorasbtn.setBounds(280,325,160,25);
        mostrarhorasbtn.addActionListener(this);
        mostrarhorasbtn.setEnabled(false);
        p1.add(mostrarhorasbtn);
        
        JLabel horalbl=new JLabel("Hora:");
        horalbl.setFont(new Font("Arial", Font.BOLD, 16));
        horalbl.setBounds(55, 355, 145, 25);
        horalbl.setEnabled(false);
        p1.add(horalbl);
        
        time=new JComboBox<>(hora);
        time.setBounds(130, 355, 145, 25);
        time.setEnabled(false);
        p1.add(time);
        
        generar=new JButton("Generar");
        generar.setBounds(450,225,320,80);
        generar.setFont(new Font("Arial",Font.CENTER_BASELINE,50));
        generar.addActionListener(this);
        p1.add(generar);
        
        //*******************************************************************************************************************************************

        
        historialbtn=new JButton("Generar Historial de citas");
        historialbtn.setBounds(10, 10, 320, 50);
        historialbtn.setFont(new Font(titulodlbl.getFont().getFontName(), Font.BOLD, 24));
        p2.add(historialbtn);
        historialbtn.addActionListener(this);
        
        
        //******************************************************************************************************************************************
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
        if(ae.getSource()==mostrarDbtn){
            String especialidadita= (String)especialidad.getSelectedItem();
            Proyecto1.buscaraldoc(especialidadita);
            doctoradd.setEnabled(true);
            especialidad.setEnabled(false);
            mostrarDbtn.setEnabled(false);
            doc.setEnabled(true);
            mostrarHbtn.setEnabled(true);
            motivo.setEnabled(false);
        }
        if(ae.getSource()==mostrarHbtn){
            String nombrecito=(String) doctoradd.getSelectedItem();
            Proyecto1.buscardNombre(nombrecito);
            int pre=0;
            for(int j=0;j<Proyecto1.doctores.get(Proyecto1.posicion).getFecha().size();j++){
                if(j>0){
                    if(!(Proyecto1.doctores.get(Proyecto1.posicion).getFecha().get(j)).equals((date.getItemAt(pre)))){
                                        date.addItem(Proyecto1.doctores.get(Proyecto1.posicion).getFecha().get(j));
                                        pre=j;
                    }
                }else{
                    date.addItem(Proyecto1.doctores.get(Proyecto1.posicion).getFecha().get(j));
                                        pre=j;
                }

        }
            date.setEnabled(true);
            mostrarHbtn.setEnabled(false);
            doctoradd.setEnabled(false);
            horariolbl.setEnabled(true);
            mostrarhorasbtn.setEnabled(true);
        }
        
        if(ae.getSource()==mostrarhorasbtn){
            String fechita=(String) date.getSelectedItem();
            for(int j=0;j<Proyecto1.doctores.get(Proyecto1.posicion).getHorario().size();j++){
            if(fechita.equals(Proyecto1.doctores.get(Proyecto1.posicion).getFecha().get(j))){
                time.addItem(Proyecto1.doctores.get(Proyecto1.posicion).getHorario().get(j));
            }
        }
            time.setEnabled(true);
            date.setEnabled(false);
            mostrarhorasbtn.setEnabled(false);
        }
        if(ae.getSource()==generar){
            generar.setEnabled(false);
            time.setEnabled(false);
            String nomecito=Proyecto1.pacientes.get(Proyecto1.indice).getNombres();
            String motivos=motivo.getText();
            String fech=(String)date.getSelectedItem();
            String hor=(String)time.getSelectedItem();
            Proyecto1.doctores.get(Proyecto1.posicion).getPaciente().add(nomecito);
            Proyecto1.doctores.get(Proyecto1.posicion).getHorario().add(hor);
            Proyecto1.doctores.get(Proyecto1.posicion).getFecha().add(fech);
            Proyecto1.doctores.get(Proyecto1.posicion).getIndicePacientes().add(Proyecto1.indice);
            Proyecto1.pacientes.get(Proyecto1.indice).getEstado().add("Pendiente");
            Proyecto1.pacientes.get(Proyecto1.indice).getFecha().add(fech);
            Proyecto1.pacientes.get(Proyecto1.indice).getHorario().add(hor);
            Proyecto1.pacientes.get(Proyecto1.indice).getMotivo().add(motivos);                                   
        }
        if (ae.getSource()==historialbtn){
            String[] titulos_d = {"No.", "Estado","Fecha","Hora"};
            tablacitas = new JTable(Proyecto1.tablearCitasP(), titulos_d);
            DefaultTableCellRenderer Alineard = new DefaultTableCellRenderer();
            Alineard.setHorizontalAlignment(SwingConstants.CENTER);
            for (int i = 0; i < titulos_d.length; i++) {
                tablacitas.getColumnModel().getColumn(i).setCellRenderer(Alineard);
            }
            tablacitas.setEnabled(false);
            sp1 = new JScrollPane(tablacitas);
            sp1.setBounds(45, 60, 700, 370);
            sp1.setVisible(true);
            p2.add(sp1);
        }
        

    }

    @Override
    public void focusGained(FocusEvent fe) {
        

    }

    @Override
    public void focusLost(FocusEvent e) {

    }

    
    
    
    
    
    
    
    
    
    
   
    
    
    
    
}
