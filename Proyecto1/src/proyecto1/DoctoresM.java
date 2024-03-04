
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
public class DoctoresM extends JFrame implements ChangeListener,ActionListener,FocusListener {

    JLabel titulodlbl, tituloplbl, titulomlbl;
    // JButton hace referencia a los botones
    JButton editarbtn, btnm3,regresar,añadir;
    //JTabbedPane	
    JTabbedPane panel;
    //JPanels
    JPanel p1, p2, p3;
    //Atributos para la tabla
    JTable tablacitas,tablacitas2;
    JScrollPane sp1,sp2;
    JTextField horariotxt;
    JComboBox date;
    public static DefaultComboBoxModel<String> fecha=new DefaultComboBoxModel<>();
    

    public DoctoresM() throws HeadlessException {
        panel=new JTabbedPane(JTabbedPane.TOP);
        p1=new JPanel(null);
        panel.addTab("Citas",p1);
        p2=new JPanel();
        p2.setLayout(null);
        panel.addTab("Asignar Horario", p2);
        panel.addChangeListener(this);
        
        editarbtn=new JButton("Editar perfil");
        editarbtn.setBounds(670,0,100,25);
        editarbtn.addActionListener(this);
        this.add(editarbtn);
        
        regresar=new JButton("Regresar");
        regresar.setBounds(550,0,100,25);
        regresar.addActionListener(this);
        this.add(regresar);
        //*********************************************************************************************************************************************
        
        
        
        
        
        
        
        
        
        
        
        
        //*********************************************************************************************************************************************
        tituloplbl = new JLabel("Horario");
        tituloplbl.setBounds(0, 0, 300, 30);
        this.tituloplbl.setOpaque(true);
        tituloplbl.setVerticalAlignment(SwingConstants.CENTER);
        tituloplbl.setHorizontalAlignment(SwingConstants.CENTER);
        tituloplbl.setFont(new Font(tituloplbl.getFont().getFontName(), Font.BOLD, 24));
        Font font = tituloplbl.getFont();
        Map attributes = font.getAttributes();
        tituloplbl.setFont(font.deriveFont(attributes));
        tituloplbl.setVisible(true);
        p2.add(tituloplbl);
        
        JLabel espe=new JLabel("Horario de citas:");
        espe.setFont(new Font("Arial", Font.BOLD, 16));
        espe.setBounds(100, 30, 165, 30);
        p2.add(espe);
        
        horariotxt = new JTextField("");//TextBox del codigo
        horariotxt.setBounds(230, 30, 200, 30);
        horariotxt.setForeground(Color.black);
        horariotxt.addFocusListener(this);
        p2.add(horariotxt);
        
        btnm3=new JButton("Asignar");
        btnm3.setBounds(440,30,60,30);
        btnm3.addActionListener(this);
        btnm3.setBackground(Color.green);
        p2.add(btnm3);
        
        JLabel fechalbl=new JLabel("Fecha de Citas:");
        fechalbl.setFont(new Font("Arial", Font.BOLD, 16));
        fechalbl.setBounds(100, 65, 165, 30);
        p2.add(fechalbl);
        
        date=new JComboBox<>(fecha);
        date.setBounds(230, 65, 200, 30);
        p2.add(date);
        
        
        añadir=new JButton("Añadir");
        añadir.setBounds(440,65,60,30);
        añadir.addActionListener(this);
        p2.add(añadir);
        
        JLabel citiii=new JLabel("Mi horario disponible para citas:");
        citiii.setFont(new Font("Arial", Font.BOLD, 16));
        citiii.setBounds(160, 100, 300, 30);
        citiii.setVerticalAlignment(SwingConstants.CENTER);
        citiii.setHorizontalAlignment(SwingConstants.CENTER);
        p2.add(citiii);
        
        String[] titulos_d2 = {"No.", "Horario de cita","Fecha de cita"};
        tablacitas2 = new JTable(Proyecto1.tablearHorario(), titulos_d2);
        DefaultTableCellRenderer Alineard2 = new DefaultTableCellRenderer();
        Alineard2.setHorizontalAlignment(SwingConstants.CENTER);
        for (int i = 0; i < titulos_d2.length; i++) {
            tablacitas2.getColumnModel().getColumn(i).setCellRenderer(Alineard2);
        }
        tablacitas2.setEnabled(false);
        sp2 = new JScrollPane(tablacitas);
        sp2.setBounds(45, 160, 700, 240);
        sp2.setVisible(true);
        p2.add(sp2);

        
        
        //**************************************************************************************************************************************
        this.setTitle("Doctor");
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
        if(ae.getSource()==btnm3){
            String horariito=horariotxt.getText();
            String fechita=(String)fecha.getSelectedItem();
            Proyecto1.doctores.get(Proyecto1.indice).getHorario().add(horariito);
            Proyecto1.doctores.get(Proyecto1.indice).getFecha().add(fechita);
            Proyecto1.tablearHorario();
            JOptionPane.showMessageDialog(null, "Horario ingresado exitosamente","Nuevo horario ingresado",JOptionPane.INFORMATION_MESSAGE);
            this.dispose();
            Proyecto1.refresD();
        }
        if(ae.getSource()==editarbtn){
            Proyecto1.buscard(Proyecto1.doctores.get(Proyecto1.indice).getCodigo());
            Proyecto1.irAdmin=false;
            if(Proyecto1.found==true){
                ActualizarDoctores actM=new ActualizarDoctores();
                this.dispose();
            }else{
                JOptionPane.showMessageDialog(null, "No se encontró el código ","Codigo no encontrado",JOptionPane.INFORMATION_MESSAGE);
            }
        }
        if(ae.getSource()==regresar){
            Inicio ini=new Inicio();
            this.dispose();
        }
        if(ae.getSource()==añadir){
            String dia=JOptionPane.showInputDialog("Ingrese la nueva fecha");
            date.addItem(dia);
        }

    }

    @Override
    public void focusGained(FocusEvent e) {


    }

    @Override
    public void focusLost(FocusEvent fe) {

    }
    
    
    
}
