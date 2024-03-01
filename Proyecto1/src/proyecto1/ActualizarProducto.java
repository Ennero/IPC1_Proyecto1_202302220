
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
public class ActualizarProducto extends JFrame implements FocusListener,ActionListener {
    
    
    private JTextField cantidadtxt,descripciontxt,preciotxt;
    private JComboBox<String> nombre;
    private JButton a�adir,nonobtn;
    
    private int a=0;
    private int e=0;
    private int i=0;

    public ActualizarProducto() throws HeadlessException {
        
        JLabel codigo=new JLabel("C�digo: " + Proyecto1.productos.get(Proyecto1.posicion).getCodigo());//Da error si se incia directamente porque no se ingresa codigo
        codigo.setBounds(30,55,120,30);
        codigo.setFont(new Font("Arial", Font.CENTER_BASELINE ,17));
        this.add(codigo);
        codigo.setForeground(Color.GREEN);
        
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
        
        nonobtn=new JButton("A�adir");
        nonobtn.setBounds(280, 165, 80, 25);
        nonobtn.setBackground(new Color(211, 217, 232)); // Ajuste de color de boton, con color en RGB
        nonobtn.setFont(new Font("Arial",Font.BOLD,16));
        nonobtn.addActionListener(this); // Agregamos un ActionListener al bot�n
        this.add(nonobtn);
        
        nombre=new JComboBox<>(A�adir.productito);
        nombre.setBounds(146, 165, 110, 25);
        this.add(nombre);
        
        JLabel edadlbl=new JLabel("Precio:");
        edadlbl.setBounds(30, 210, 110, 20);
        edadlbl.setFont(new Font("Arial", Font.CENTER_BASELINE,17));
        this.add(edadlbl);
        
        preciotxt=new JTextField ("Ingrese el precio aqu�");
        preciotxt.setBounds(146,210,180,27);
        preciotxt.addFocusListener(this);
        preciotxt.setForeground(Color.gray);
        this.add(preciotxt);
        
        a�adir=new JButton("Actualizar");
        a�adir.setBounds(45, 260, 300, 100); //Ajuste de posici�n
        a�adir.setBackground(new Color(211, 217, 232)); // Ajuste de color de boton, con color en RGB
        a�adir.setFont(new Font("Arial",Font.BOLD,45));
        a�adir.addActionListener(this); // Agregamos un ActionListener al bot�n
        this.add(a�adir);
        
        this.setTitle("Actualizar Producto");  // T�tulo de la ventana
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
            Proyecto1.productos.get(Proyecto1.posicion).setDescripcion(descripcion);
            Proyecto1.productos.get(Proyecto1.posicion).setPrecio(precio);
            Proyecto1.productos.get(Proyecto1.posicion).setCantidad(cantidadita);
            Proyecto1.productos.get(Proyecto1.posicion).setNombre(nombres);
            JOptionPane.showMessageDialog(null, "Actualizado exitosamente","Proceso exitoso",JOptionPane.INFORMATION_MESSAGE);
            Admin admin=new Admin();
            this.dispose();
        }
        if(ae.getSource()==nonobtn){
            String espe=JOptionPane.showInputDialog("Ingrese el nombre del producto");
            A�adir.productito.addElement(espe);
        }

    }
    
    
}
