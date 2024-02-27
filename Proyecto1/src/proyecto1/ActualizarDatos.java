
package proyecto1;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

/**
 *
 * @author Enner
 */
public class ActualizarDatos extends JFrame implements FocusListener,ActionListener {

    private JTextField nombretxt,apellidotxt,edadtxt;
    private JPasswordField contraseñatxt;
    private JComboBox<String> sexo;
    private JCheckBox contra;
    private JButton actualizar;
    
    private int a=0;
    private int e=0;
    private int i=0;
    private int o=0;
    
    
    public ActualizarDatos() throws HeadlessException {
        JLabel titulolbl=new JLabel("Actualizar Datos");
        titulolbl.setBounds(45,15,370,45);
        titulolbl.setFont(new Font("Arial", Font.BOLD, 37));
        this.add(titulolbl);
        
        JLabel nombrelbl=new JLabel("Nombres:");
        nombrelbl.setBounds(30,80,85,30);
        nombrelbl.setFont(new Font("Arial", Font.CENTER_BASELINE ,17));
        this.add(nombrelbl);
        
        nombretxt=new JTextField ("Ingrese los los nombres aquí");
        nombretxt.setBounds(146,82,180,27);
        nombretxt.addFocusListener(this);
        nombretxt.setForeground(Color.gray);
        this.add(nombretxt);
        
        JLabel apellidoslbl=new JLabel("Apellidos:");
        apellidoslbl.setBounds(30,130,85,30);
        apellidoslbl.setFont(new Font("Arial", Font.CENTER_BASELINE ,17));
        this.add(apellidoslbl);
        
        apellidotxt=new JTextField ("Ingrese los apellidos aquí");
        apellidotxt.setBounds(146,130,180,27);
        apellidotxt.addFocusListener(this);
        apellidotxt.setForeground(Color.gray);
        this.add(apellidotxt);
        
        JLabel contraseñalbl=new JLabel("Contraseña:");
        contraseñalbl.setBounds(30,170,110,40);
        contraseñalbl.setFont(new Font("Arial", Font.CENTER_BASELINE ,17));
        this.add(contraseñalbl);
        
        contra=new JCheckBox("Ver Contraseña");
        contra.setFont(new Font("Arial", Font.BOLD, 12)); // Establece el tipo de letra y el tamaño
        contra.setBounds(146, 204, 150, 25);
        contra.setVisible(true);
        contra.addActionListener(this);
        this.add(contra);
        
        contraseñatxt=new JPasswordField ("Ingrese la contraseña aqui");
        contraseñatxt.setBounds(146,177,180,27);
        contraseñatxt.addFocusListener(this);
        contraseñatxt.setEchoChar((char)0);
        contraseñatxt.setForeground(Color.gray);
        this.add(contraseñatxt);
        
        JLabel sexolbl=new JLabel("Sexo:");
        sexolbl.setBounds(30,235,100,25);
        sexolbl.setFont(new Font("Arial", Font.CENTER_BASELINE ,17));
        this.add(sexolbl);
        
        String[] sexos = {"Terreneitor","Masculino","Femenino"};
        sexo=new JComboBox<>(sexos);
        sexo.setBounds(146, 235, 110, 30);
        this.add(sexo);
        
        JLabel edadlbl=new JLabel("Edad:");
        edadlbl.setBounds(30, 280, 110, 20);
        edadlbl.setFont(new Font("Arial", Font.CENTER_BASELINE,17));
        this.add(edadlbl);
        
        edadtxt=new JTextField ("Ingrese la edad aquí");
        edadtxt.setBounds(146,280,180,27);
        edadtxt.addFocusListener(this);
        edadtxt.setForeground(Color.gray);
        this.add(edadtxt);
        
        actualizar=new JButton("Actualizar");
        actualizar.setBounds(45, 330, 300, 100); //Ajuste de posición
        actualizar.setBackground(new Color(211, 217, 232)); // Ajuste de color de boton, con color en RGB
        actualizar.setFont(new Font("Arial",Font.BOLD,45));
        actualizar.addActionListener(this); // Agregamos un ActionListener al botón
        this.add(actualizar);
        
                
                
                
        this.setTitle("Actualización de datos");  // Título de la ventana
        this.setLocationRelativeTo(null);
        this.setSize(400, 500);
        setLocationRelativeTo(null);
        
        this.setLayout(null); // Diseño nulo (sin diseño predeterminado), para poder posicionar los componentes donde queramos
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Cierra la aplicación al cerrar la ventana
        this.setResizable(false);  // No permite redimensionar la ventana
        this.setVisible(true); // Hace visible la ventana
    
        
        
    }
    
    
     

    @Override
    public void focusGained(FocusEvent fe) {
        if (fe.getSource()==nombretxt && a==0){
            a++;
            nombretxt.setText("");
            nombretxt.setForeground(Color.BLACK);
        }
        if (fe.getSource()==apellidotxt && e==0){
            e++;
            apellidotxt.setText("");
            apellidotxt.setForeground(Color.BLACK);
            
        }
        if (fe.getSource()==edadtxt && i==0){
            i++;
            edadtxt.setText("");
            edadtxt.setForeground(Color.BLACK);
        }
        if (fe.getSource()==contraseñatxt && o==0){
            o++;
            char[] contraseña=contraseñatxt.getPassword();
            contraseñatxt.setText("");
            contraseñatxt.setForeground(Color.BLACK);
            contraseñatxt.setEchoChar('\u25CF');
            
        }
        

    }

    @Override
    public void focusLost(FocusEvent e) {

    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource()==contra){
            if(contra.isSelected()){
                contraseñatxt.setEchoChar((char)0);
            }else{
                contraseñatxt.setEchoChar(('\u25CF'));
            }
        }
        if(ae.getSource()==actualizar){
            char[] contraseñita=contraseñatxt.getPassword();
            String password=new String(contraseñita);
            String nombre=nombretxt.getText();
            String apellidos=apellidotxt.getText();
            String edad=edadtxt.getText();
            String genero=(String)sexo.getSelectedItem();
            Proyecto1.pacientes.get(Proyecto1.posicion).setApellidos(apellidos);
            Proyecto1.pacientes.get(Proyecto1.posicion).setNombres(nombre);
            Proyecto1.pacientes.get(Proyecto1.posicion).setEdad(edad);
            Proyecto1.pacientes.get(Proyecto1.posicion).setSexo(genero);
            Proyecto1.pacientes.get(Proyecto1.posicion).setContraseña(password);
            
            
            Proyecto1.codigo++;
            

            this.dispose();
        }

    }

    
    
    
    
    

    
    
    
    
}
