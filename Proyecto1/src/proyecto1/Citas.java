
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

public class Citas implements ActionListener{
    
   private String nombreP, hora,fecha,motivo;
   private int doctor, paciente;
    private JButton verMas;
    private JButton atender;
    private JButton rechazar;
    private JPanel jp;
    private JLabel nombrelbl,horalbl,fechalbl;

    public Citas(String nombreP, String hora, String fecha,int doctor,int paciente,String motivo) {
        this.nombreP = nombreP;
        this.hora = hora;
        this.fecha = fecha;
        this.doctor=doctor;
        this.paciente=paciente;
        this.motivo=motivo;
        initComponents();
    }
    public void initComponents() {
        jp = new JPanel();
        jp.setLayout(null);
        jp.setBackground(Color.yellow); 
        jp.setPreferredSize(new Dimension(770, 70));

        // Calcular las coordenadas para centrar horizontalmente y verticalmente
        int ancholbl = 180;
        int altolbl = 50;
        
        nombrelbl = new JLabel(this.getNombreP());
        nombrelbl.setFont(new Font("Arial", Font.BOLD, 14));
        nombrelbl.setForeground(Color.black);
        nombrelbl.setBounds(0, 5, ancholbl, altolbl);
        nombrelbl.setVerticalAlignment(SwingConstants.CENTER);
        nombrelbl.setHorizontalAlignment(SwingConstants.CENTER);
        jp.add(nombrelbl);

        horalbl = new JLabel(this.getHora());
        horalbl.setFont(new Font("Arial", Font.BOLD, 14));
        horalbl.setForeground(Color.blue);
        horalbl.setBounds(180, 5, ancholbl, altolbl);
        horalbl.setVerticalAlignment(SwingConstants.CENTER);
        horalbl.setHorizontalAlignment(SwingConstants.CENTER);
        jp.add(horalbl);
        
        fechalbl = new JLabel(this.getFecha());
        fechalbl.setFont(new Font("Arial", Font.BOLD, 14));
        fechalbl.setForeground(Color.blue);
        fechalbl.setBounds(360, 5, ancholbl, altolbl);
        fechalbl.setVerticalAlignment(SwingConstants.CENTER);
        fechalbl.setHorizontalAlignment(SwingConstants.CENTER);
        jp.add(fechalbl);
        
        verMas=new JButton("Ver Más");
        verMas.setBounds(540, 5, 65, altolbl);
        verMas.setVisible(true);
        verMas.setEnabled(true);
        verMas.addActionListener(this);
        jp.add(verMas);
        
        atender=new JButton("Atender");
        atender.setBounds(610, 5, 65, altolbl);
        atender.setVisible(true);
        atender.setEnabled(true);
        atender.addActionListener(this);
        jp.add(atender);
        
        rechazar=new JButton("Rechazar");
        rechazar.setBounds(680, 5, 72, altolbl);
        rechazar.setVisible(true);
        rechazar.setEnabled(true);
        rechazar.addActionListener(this);
        jp.add(rechazar);
        

        jp.setVisible(true);
    }
    public JPanel getPanel(){
        return jp;
    }
    

    /**
     * @return the nombreP
     */
    public String getNombreP() {
        return nombreP;
    }

    /**
     * @param nombreP the nombreP to set
     */
    public void setNombreP(String nombreP) {
        this.nombreP = nombreP;
    }

    /**
     * @return the hora
     */
    public String getHora() {
        return hora;
    }

    /**
     * @param hora the hora to set
     */
    public void setHora(String hora) {
        this.hora = hora;
    }

    /**
     * @return the fecha
     */
    public String getFecha() {
        return fecha;
    }

    /**
     * @param fecha the fecha to set
     */
    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    /**
     * @return the motivo
     */
    public String getMotivo() {
        return motivo;
    }

    /**
     * @param motivo the motivo to set
     */
    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }

    /**
     * @return the doctor
     */
    public int getDoctor() {
        return doctor;
    }

    /**
     * @param doctor the doctor to set
     */
    public void setDoctor(int doctor) {
        this.doctor = doctor;
    }

    /**
     * @return the paciente
     */
    public int getPaciente() {
        return paciente;
    }

    /**
     * @param paciente the paciente to set
     */
    public void setPaciente(int paciente) {
        this.paciente = paciente;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        

    }

    
   
   
    
}
