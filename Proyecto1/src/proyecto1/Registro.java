
package proyecto1;

/**
 *
 * @author Enner
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

public class Registro extends JFrame implements FocusListener,ActionListener {
    
    private JTextField nombretxt,apellidotxt,contrase�atxt;
    private JScrollPane sexoselect;
    
    public Registro(){
        inicio();
    }
    
    private void inicio(){
        JLabel nombrelbl=new JLabel("Nombres:");
        nombrelbl.setBounds(30,20,85,30);
        nombrelbl.setFont(new Font("Arial", Font.CENTER_BASELINE ,17));
        this.add(nombrelbl);
        
        nombretxt=new JTextField ("Ingrese los los nombres aqu�");
        nombretxt.setBounds(146,22,180,27);
        nombretxt.addFocusListener(this);
        nombretxt.setForeground(Color.gray);
        this.add(nombretxt);
        
        JLabel apellidoslbl=new JLabel("Apellidos:");
        apellidoslbl.setBounds(30,70,85,30);
        apellidoslbl.setFont(new Font("Arial", Font.CENTER_BASELINE ,17));
        this.add(apellidoslbl);
        
        apellidotxt=new JTextField ("Ingrese los apellidos aqu�");
        apellidotxt.setBounds(146,70,180,27);
        apellidotxt.addFocusListener(this);
        apellidotxt.setForeground(Color.gray);
        this.add(apellidotxt);
        
        JLabel contrase�albl=new JLabel("Contrase�a:");
        contrase�albl.setBounds(30,110,110,40);
        contrase�albl.setFont(new Font("Arial", Font.CENTER_BASELINE ,17));
        this.add(contrase�albl);
        
        apellidotxt=new JTextField ("Ingrese la contrase�a aqui");
        apellidotxt.setBounds(146,110,180,27);
        apellidotxt.addFocusListener(this);
        apellidotxt.setForeground(Color.gray);
        this.add(apellidotxt);
        
        JLabel sexolbl=new JLabel("Sexo:");
        sexolbl.setBounds(30,145,110,40);
        sexolbl.setFont(new Font("Arial", Font.CENTER_BASELINE ,17));
        this.add(sexolbl);
        
        
                
                
        this.setTitle("Registro");  // T�tulo de la ventana
        this.setLocationRelativeTo(null);
        this.setSize(400, 500);
        setLocationRelativeTo(null);
        
        this.setLayout(null); // Dise�o nulo (sin dise�o predeterminado), para poder posicionar los componentes donde queramos
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Cierra la aplicaci�n al cerrar la ventana
        this.setResizable(false);  // No permite redimensionar la ventana
        this.setVisible(true); // Hace visible la ventana
    }
    

    @Override
    public void focusGained(FocusEvent e) {
        
    }

    @Override
    public void focusLost(FocusEvent e) {
    }

    @Override
    public void actionPerformed(ActionEvent e) {
    }
    
    
    
    
    
}
