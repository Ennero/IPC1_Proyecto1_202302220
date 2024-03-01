
package proyecto1;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import static proyecto1.RegistroDoctores.especialito;

/**
 *
 * @author Enner
 */
public class ActualizarDoctores extends JFrame implements FocusListener,ActionListener {
    
    private JTextField nombretxt,apellidotxt,edadtxt,telefonotxt;
    private JPasswordField contrase�atxt;
    private JComboBox<String> sexo,especialidad;
    private JCheckBox contra;
    private JButton actualizar,especialidadbtn;
    
    private int a=0;
    private int e=0;
    private int i=0;
    private int o=0;
    private int u=0;
    private int q=0;

    public ActualizarDoctores(){
        
        JLabel codigo=new JLabel("C�digo: " + Proyecto1.doctores.get(Proyecto1.posicion).getCodigo());//Da error si se incia directamente porque no se ingresa codigo
        codigo.setBounds(30,55,120,30);
        codigo.setFont(new Font("Arial", Font.CENTER_BASELINE ,17));
        this.add(codigo);
        codigo.setForeground(Color.GREEN);
        
        JLabel titulolbl=new JLabel("Registro de Doctores");
        titulolbl.setBounds(10,15,390,45);
        titulolbl.setFont(new Font("Arial", Font.BOLD, 37));
        this.add(titulolbl);
        
        JLabel nombrelbl=new JLabel("Nombres:");
        nombrelbl.setBounds(30,80,85,30);
        nombrelbl.setFont(new Font("Arial", Font.CENTER_BASELINE ,17));
        this.add(nombrelbl);
        
        nombretxt=new JTextField ("Ingrese los los nombres aqu�");
        nombretxt.setBounds(146,82,180,27);
        nombretxt.addFocusListener(this);
        nombretxt.setForeground(Color.gray);
        this.add(nombretxt);
        
        JLabel apellidoslbl=new JLabel("Apellidos:");
        apellidoslbl.setBounds(30,130,85,30);
        apellidoslbl.setFont(new Font("Arial", Font.CENTER_BASELINE ,17));
        this.add(apellidoslbl);
        

        
        apellidotxt=new JTextField ("Ingrese los apellidos aqu�");
        apellidotxt.setBounds(146,130,180,27);
        apellidotxt.addFocusListener(this);
        apellidotxt.setForeground(Color.gray);
        this.add(apellidotxt);
        
        JLabel contrase�albl=new JLabel("Contrase�a:");
        contrase�albl.setBounds(30,170,110,40);
        contrase�albl.setFont(new Font("Arial", Font.CENTER_BASELINE ,17));
        this.add(contrase�albl);
        
        contra=new JCheckBox("Ver Contrase�a");
        contra.setFont(new Font("Arial", Font.BOLD, 12)); // Establece el tipo de letra y el tama�o
        contra.setBounds(146, 204, 150, 25);
        contra.setVisible(true);
        contra.addActionListener(this);
        this.add(contra);
        
        contrase�atxt=new JPasswordField ("Ingrese la contrase�a aqui");
        contrase�atxt.setBounds(146,177,180,27);
        contrase�atxt.addFocusListener(this);
        contrase�atxt.setEchoChar((char)0);
        contrase�atxt.setForeground(Color.gray);
        this.add(contrase�atxt);
        
        JLabel sexolbl=new JLabel("Sexo:");
        sexolbl.setBounds(30,235,110,25);
        sexolbl.setFont(new Font("Arial", Font.CENTER_BASELINE ,17));
        this.add(sexolbl);
        
        String[] sexos = {"Terreneitor","Masculino","Femenino"};
        sexo=new JComboBox<>(sexos);
        sexo.setBounds(146, 235, 110, 25);
        this.add(sexo);
        
        JLabel edadlbl=new JLabel("Edad:");
        edadlbl.setBounds(30, 280, 110, 20);
        edadlbl.setFont(new Font("Arial", Font.CENTER_BASELINE,17));
        this.add(edadlbl);
        
        edadtxt=new JTextField ("Ingrese la edad aqu�");
        edadtxt.setBounds(146,280,180,27);
        edadtxt.addFocusListener(this);
        edadtxt.setForeground(Color.gray);
        this.add(edadtxt);
        
        especialidadbtn=new JButton("A�adir");
        especialidadbtn.setBounds(280, 330, 80, 25);
        especialidadbtn.setBackground(new Color(211, 217, 232)); // Ajuste de color de boton, con color en RGB
        especialidadbtn.setFont(new Font("Arial",Font.BOLD,16));
        especialidadbtn.addActionListener(this); // Agregamos un ActionListener al bot�n
        this.add(especialidadbtn);
        
        JLabel especialidadlbl=new JLabel("Especialidad:");
        especialidadlbl.setBounds(30, 330, 110, 20);
        especialidadlbl.setFont(new Font("Arial", Font.CENTER_BASELINE,17));
        this.add(especialidadlbl);
        
        especialidad=new JComboBox<>(RegistroDoctores.especialito);
        especialidad.setBounds(146, 330, 110, 25);
        this.add(especialidad);
        
        JLabel telefonolbl=new JLabel("Telefono: ");
        telefonolbl.setBounds(30, 380, 110, 20);
        telefonolbl.setFont(new Font("Arial", Font.CENTER_BASELINE,17));
        this.add(telefonolbl);
        
        telefonotxt=new JTextField ("Ingrese el telefono aqu�");
        telefonotxt.setBounds(146,380,180,27);
        telefonotxt.addFocusListener(this);
        telefonotxt.setForeground(Color.gray);
        this.add(telefonotxt);
        
        actualizar=new JButton("Actualizar");
        actualizar.setBounds(125, 425, 150, 35); //Ajuste de posici�n
        actualizar.setBackground(new Color(211, 217, 232)); // Ajuste de color de boton, con color en RGB
        actualizar.setFont(new Font("Arial",Font.BOLD,20));
        actualizar.addActionListener(this); // Agregamos un ActionListener al bot�n
        this.add(actualizar);
        
                
                
                
        this.setTitle("Actualizaci�n de Datos de Doctores");  // T�tulo de la ventana
        this.setLocationRelativeTo(null);
        this.setSize(400, 500);
        setLocationRelativeTo(null);
        
        this.setLayout(null); // Dise�o nulo (sin dise�o predeterminado), para poder posicionar los componentes donde queramos
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Cierra la aplicaci�n al cerrar la ventana
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
        if (fe.getSource()==contrase�atxt && o==0){
            o++;
            char[] contrase�a=contrase�atxt.getPassword();
            contrase�atxt.setText("");
            contrase�atxt.setForeground(Color.BLACK);
            contrase�atxt.setEchoChar('\u25CF');
        }
        if (fe.getSource()==telefonotxt && u==0){
            u++;
            telefonotxt.setText("");
            telefonotxt.setForeground(Color.BLACK);
            
        }

    }

    @Override
    public void focusLost(FocusEvent e) {

    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource()==contra){
            if(contra.isSelected()){
                contrase�atxt.setEchoChar((char)0);
            }else{
                contrase�atxt.setEchoChar(('\u25CF'));
            }
        }
        if(ae.getSource()==actualizar){
            char[] contrase�ita=contrase�atxt.getPassword();
            String password=new String(contrase�ita);
            String nombre=nombretxt.getText();
            String apellidos=apellidotxt.getText();
            String edad=edadtxt.getText();
            String especializaci�n=(String)especialidad.getSelectedItem();
            String telefono=telefonotxt.getText();
            String genero=(String)sexo.getSelectedItem();
            Proyecto1.doctores.get(Proyecto1.posicion).setApellidos(apellidos);
            Proyecto1.doctores.get(Proyecto1.posicion).setNombres(nombre);
            Proyecto1.doctores.get(Proyecto1.posicion).setEdad(edad);
            Proyecto1.doctores.get(Proyecto1.posicion).setSexo(genero);
            Proyecto1.doctores.get(Proyecto1.posicion).setContrase�a(password);
            Proyecto1.doctores.get(Proyecto1.posicion).setSexo(especializaci�n);
            Proyecto1.doctores.get(Proyecto1.posicion).setContrase�a(telefono);
            JOptionPane.showMessageDialog(null, "Actualizado exitosamente","Proceso exitoso",JOptionPane.INFORMATION_MESSAGE);
            Admin admin=new Admin();
            this.dispose();
        }
        if(ae.getSource()==especialidadbtn){
            String espe=JOptionPane.showInputDialog("Ingrese la especialidad");
            especialito.addElement(espe);
        }

    }
    
}
