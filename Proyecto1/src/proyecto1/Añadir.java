
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
public class A�adir extends JFrame implements FocusListener,ActionListener {
    
    private JTextField cantidadtxt,descripciontxt,preciotxt;
    private JComboBox<String> nombre;
    private JButton a�adir, nonobtn;
    
    private int a=0;
    private int e=0;
    private int i=0;
    public static DefaultComboBoxModel<String> productito=new DefaultComboBoxModel<>();

    public A�adir() throws HeadlessException {
        

        
        JLabel titulolbl=new JLabel("A�adir Producto");
        titulolbl.setBounds(15,15,370,45);
        titulolbl.setFont(new Font("Arial", Font.BOLD, 37));
        this.add(titulolbl);
        
        JLabel nombrelbl=new JLabel("Cantidad:");
        nombrelbl.setBounds(30,80,85,30);
        nombrelbl.setFont(new Font("Arial", Font.CENTER_BASELINE ,17));
        this.add(nombrelbl);
        
        cantidadtxt=new JTextField ("Ingrese la cantidad aqu�");
        cantidadtxt.setBounds(146,82,180,27);
        cantidadtxt.addFocusListener(this);
        cantidadtxt.setForeground(Color.gray);
        this.add(cantidadtxt);
        
        JLabel apellidoslbl=new JLabel("Descripci�n:");
        apellidoslbl.setBounds(30,130,85,30);
        apellidoslbl.setFont(new Font("Arial", Font.CENTER_BASELINE ,17));
        this.add(apellidoslbl);
        
        descripciontxt=new JTextField ("Ingrese la descripci�n aqu�");
        descripciontxt.setBounds(146,130,180,27);
        descripciontxt.addFocusListener(this);
        descripciontxt.setForeground(Color.gray);
        this.add(descripciontxt);
        
        JLabel sexolbl=new JLabel("Nombre:");
        sexolbl.setBounds(30,165,110,25);
        sexolbl.setFont(new Font("Arial", Font.CENTER_BASELINE ,17));
        this.add(sexolbl);
        
        nombre=new JComboBox<>(productito);
        nombre.setBounds(146, 165, 110, 25);
        this.add(nombre);
        
        nonobtn=new JButton("A�adir");
        nonobtn.setBounds(280, 165, 80, 25);
        nonobtn.setBackground(new Color(211, 217, 232)); // Ajuste de color de boton, con color en RGB
        nonobtn.setFont(new Font("Arial",Font.BOLD,16));
        nonobtn.addActionListener(this); // Agregamos un ActionListener al bot�n
        this.add(nonobtn);
        
        JLabel edadlbl=new JLabel("Precio:");
        edadlbl.setBounds(30, 210, 110, 20);
        edadlbl.setFont(new Font("Arial", Font.CENTER_BASELINE,17));
        this.add(edadlbl);
        
        preciotxt=new JTextField ("Ingrese el precio aqu�");
        preciotxt.setBounds(146,210,180,27);
        preciotxt.addFocusListener(this);
        preciotxt.setForeground(Color.gray);
        this.add(preciotxt);
        
        a�adir=new JButton("A�adir");
        a�adir.setBounds(45, 260, 300, 100); //Ajuste de posici�n
        a�adir.setBackground(new Color(211, 217, 232)); // Ajuste de color de boton, con color en RGB
        a�adir.setFont(new Font("Arial",Font.BOLD,45));
        a�adir.addActionListener(this); // Agregamos un ActionListener al bot�n
        this.add(a�adir);
        
        this.setTitle("A�adir Producto");  // T�tulo de la ventana
        this.setLocationRelativeTo(null);
        this.setSize(400, 400);
        setLocationRelativeTo(null);
        
        this.setLayout(null); // Dise�o nulo (sin dise�o predeterminado), para poder posicionar los componentes donde queramos
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Cierra la aplicaci�n al cerrar la ventana
        this.setResizable(false);  // No permite redimensionar la ventana
        this.setVisible(true); // Hace visible la ventana
    }
    
    
    
    
    
    

    @Override
    public void focusGained(FocusEvent fe) {
        if (fe.getSource()==cantidadtxt && a==0){
            a++;
            cantidadtxt.setText("");
            cantidadtxt.setForeground(Color.BLACK);
        }
        if (fe.getSource()==preciotxt && e==0){
            e++;
            preciotxt.setText("");
            preciotxt.setForeground(Color.BLACK);
            
        }
        if (fe.getSource()==descripciontxt && i==0){
            i++;
            descripciontxt.setText("");
            descripciontxt.setForeground(Color.BLACK);
        }

    }

    @Override
    public void focusLost(FocusEvent e) {


    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource()==a�adir){
            String descripcion=descripciontxt.getText();
            String precio=preciotxt.getText();
            String cantidad=cantidadtxt.getText();
            int cantidadita=Integer.parseInt(cantidad);
            String nombres=(String)nombre.getSelectedItem();
            String codigo=String.valueOf(Proyecto1.codigoP);
            Proyecto1.nuevoProducto(codigo, nombres, cantidadita, descripcion, precio);
            Proyecto1.codigoP++;
            Admin admin=new Admin();
            JOptionPane.showMessageDialog(null, "A�adido exitosamente","Proceso exitoso",JOptionPane.INFORMATION_MESSAGE);
            this.dispose();
        }
        if(ae.getSource()==nonobtn){
            String espe=JOptionPane.showInputDialog("Ingrese el nombre del producto");
            productito.addElement(espe);
        }



    }
    
    
}
