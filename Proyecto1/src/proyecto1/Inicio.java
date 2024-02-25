
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

public class Inicio extends JFrame implements FocusListener, ActionListener{
    
    private JTextField usuariotxt;
    private JPasswordField areacontrase�a;
    private JButton btnLogin;
    private JButton registerButton;
    private JCheckBox cb1;

    public Inicio() {
        start();
    }
    
    private void start(){
        JLabel titulo = new JLabel("Inicio de sesi�n");//Label del inicio de sesi�n
        titulo.setFont(new Font("Arial", Font.BOLD, 30));
        titulo.setBounds(135, 10, 250, 30); //pos x, pos y, ancho, alto
        this.add(titulo);

        ImageIcon imagenIcono = new ImageIcon(getClass().getResource("./imagenes/usuario.png"));
        Image imageDimension = imagenIcono.getImage().getScaledInstance(120, 110, Image.SCALE_SMOOTH);
        ImageIcon imagenadjustada = new ImageIcon(imageDimension);
        JLabel LabelImagen = new JLabel(imagenadjustada); //Label de la iamgen
        LabelImagen.setBounds(190, 45, 120, 110); 
        this.add(LabelImagen);

        JLabel LabelUsuario = new JLabel("C�digo:");// Label del Usuario
        LabelUsuario.setFont(new Font("Arial", Font.BOLD, 12));
        LabelUsuario.setBounds(70, 160, 80, 25);
        this.add(LabelUsuario);

        usuariotxt = new JTextField("Ingrese el c�digo aqu�");//TextBox del codigo
        usuariotxt.setBounds(130, 160, 260, 25);
        usuariotxt.setForeground(Color.gray);
        usuariotxt.addFocusListener(this);
        this.add(usuariotxt);

        // Etiqueta para la contrase�a
        JLabel lblcontrase�a = new JLabel("Contrase�a:");
        lblcontrase�a.setFont(new Font("Arial", Font.BOLD, 12)); // Establece el tipo de letra y el tama�o
        lblcontrase�a.setBounds(43, 200, 80, 25);
        this.add(lblcontrase�a);

        //Campo de texto para la contrase�a
        areacontrase�a = new JPasswordField("Ingrese la contrase�a aqu�");
        areacontrase�a.setEchoChar((char)0);
        areacontrase�a.setForeground(Color.gray);
        areacontrase�a.setBounds(130, 200, 260, 25);
        areacontrase�a.addFocusListener(this);
        this.add(areacontrase�a);

        // Bot�n de inicio de sesi�n
        btnLogin = new JButton("Iniciar Sesi�n");
        btnLogin.setBounds(160, 260, 180, 40); 
        btnLogin.setForeground(Color.WHITE); 
        btnLogin.setFont(new Font("Arial", Font.BOLD,19));
        btnLogin.setBackground(new Color(75, 193, 31)); // Ajuste de color de boton, con color en RGB
        btnLogin.addActionListener(this); // Agregamos un ActionListener al bot�n
        this.add(btnLogin);
        
       
        
        JLabel lblpregunta=new JLabel("�Sin cuenta a�n?");
        lblpregunta.setFont(new Font("Arial", Font.BOLD, 12)); // Establece el tipo de letra y el tama�o
        lblpregunta.setBounds(130, 310, 120, 25);
        this.add(lblpregunta);

        // Bot�n de Registro
        registerButton = new JButton("Registrarse");
        registerButton.setBounds(235, 310, 140, 25); //Ajuste de posici�n
        registerButton.setBackground(new Color(211, 217, 232)); // Ajuste de color de boton, con color en RGB
        registerButton.addActionListener(this); // Agregamos un ActionListener al bot�n
        this.add(registerButton);

        //SEE PASSWORD
        cb1 = new JCheckBox("Ver Contrase�a");
        cb1.setFont(new Font("Arial", Font.BOLD, 12)); // Establece el tipo de letra y el tama�o
        cb1.setBounds(130, 230, 150, 25);
        cb1.setVisible(true);
        cb1.addActionListener(this);
        this.add(cb1);

        //Creaci�n de la ventana iniciar sesi�n
        this.setTitle("Inicio de Sesi�n");  // T�tulo de la ventana
        this.setLocationRelativeTo(null);
        this.setSize(500, 400);
        setLocationRelativeTo(null);

        this.setLayout(null); // Dise�o nulo (sin dise�o predeterminado), para poder posicionar los componentes donde queramos
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Cierra la aplicaci�n al cerrar la ventana
        this.setResizable(false);  // No permite redimensionar la ventana
        this.setVisible(true); // Hace visible la ventana
        
    }
    
    @Override
    public void focusGained(FocusEvent fe) {
        if(fe.getSource()==usuariotxt){
            usuariotxt.setText("");
            usuariotxt.setForeground(Color.BLACK);
        }else if(fe.getSource()==areacontrase�a){
            areacontrase�a.setForeground(Color.BLACK);
            areacontrase�a.setText("");
            areacontrase�a.setEchoChar(('\u25CF'));
        }
    }

    @Override
    public void focusLost(FocusEvent e) {
        
    
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        //ver la contrase�a
        if(ae.getSource()==cb1){
            if(cb1.isSelected()){
                areacontrase�a.setEchoChar((char)0);
            }else{
                areacontrase�a.setEchoChar(('\u25CF'));
            }
        }else if(ae.getSource()==btnLogin){
            String nombreUsuario=usuariotxt.getText();
            char[] contrase�a=areacontrase�a.getPassword();
            String contra=new String(contrase�a);
        }
        if(ae.getSource()==registerButton){
            Registro registro=new Registro();
            this.dispose();
        }
        
        
    }
    
    
    
}
