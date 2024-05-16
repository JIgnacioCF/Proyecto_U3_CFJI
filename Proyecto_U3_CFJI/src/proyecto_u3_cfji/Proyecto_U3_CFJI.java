package proyecto_u3_cfji;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class Proyecto_U3_CFJI {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Ventana();
            }
        });
    }
}

class Hilo implements Runnable {

    Thread t;
    String nombre;
    JLabel personaje;
    JLabel lfinal;
    static int lugar;

    public Hilo(String nombre, JLabel personaje, JLabel lfinal) {
        this.nombre = nombre;
        this.lfinal = lfinal;
        this.personaje = personaje;
    }

    @Override
    public void run() {
        int tiempo;
        lugar = 1;
        tiempo = (int) (Math.random() * 15) + 1;
        lfinal.setVisible(false);
        personaje.setVisible(true);

        try {
            for (int i = 50; i < 500; i++) {
                personaje.setLocation(i, personaje.getY());
                Thread.sleep(tiempo);
            }

            personaje.setVisible(false);
            lfinal.setVisible(true);
            lfinal.setText(nombre + " termino su comida y quedo en : " + lugar + " lugar");
            lugar++;
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void start() {
        t = new Thread(this);
        t.start();
    }
}

class Ventana extends JFrame {

    public Ventana() {
        super("Carrera de Glotones");
        JLabel patricio, cartman, gatito, pat_posicion, cart_posicion, gat_posicion, meta, fondo;
        JButton btnIniciar;
        setSize(500, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel panel = new JPanel();
        panel.setLayout(null);        

        Image imagen_fondo = new ImageIcon("C:\\Users\\nacho\\OneDrive\\Documentos\\NetBeansProjects\\Proyecto_U3_CFJI\\src\\proyecto_u3_cfji\\fondo.jpg").getImage();
        ImageIcon Icon_fondo = new ImageIcon(imagen_fondo.getScaledInstance(500, 300, Image.SCALE_DEFAULT));
        fondo = new JLabel();
        fondo.setIcon(Icon_fondo);
        fondo.setBounds(0,0, 500, 300);
        
        Image imagen_meta = new ImageIcon("C:\\Users\\nacho\\OneDrive\\Documentos\\NetBeansProjects\\Proyecto_U3_CFJI\\src\\proyecto_u3_cfji\\meta.jpg").getImage();
        ImageIcon Icon_meta = new ImageIcon(imagen_meta.getScaledInstance(500, 300, Image.SCALE_DEFAULT));
        meta = new JLabel();
        meta.setIcon(Icon_meta);
        meta.setBounds(450, -150, 100, 500);
        
        Image imagen_gatito = new ImageIcon("C:\\Users\\nacho\\OneDrive\\Documentos\\NetBeansProjects\\Proyecto_U3_CFJI\\src\\proyecto_u3_cfji\\gatito.gif").getImage();
        ImageIcon Icon_gatito = new ImageIcon(imagen_gatito.getScaledInstance(50, 50, Image.SCALE_DEFAULT));
        gatito = new JLabel();
        gatito.setIcon(Icon_gatito);
        gatito.setBounds(50, 50, 50, 50);

        Image imagen_cartman = new ImageIcon("C:\\Users\\nacho\\OneDrive\\Documentos\\NetBeansProjects\\Proyecto_U3_CFJI\\src\\proyecto_u3_cfji\\cartman.gif").getImage();
        ImageIcon Icon_cartman = new ImageIcon(imagen_cartman.getScaledInstance(50, 50, Image.SCALE_DEFAULT));
        cartman = new JLabel();
        cartman.setIcon(Icon_cartman);
        cartman.setBounds(50, 100, 50, 50);

        Image imagen_patricio = new ImageIcon("C:\\Users\\nacho\\OneDrive\\Documentos\\NetBeansProjects\\Proyecto_U3_CFJI\\src\\proyecto_u3_cfji\\patricio.gif").getImage();
        ImageIcon Icon_patricio = new ImageIcon(imagen_patricio.getScaledInstance(50, 50, Image.SCALE_DEFAULT));
        patricio = new JLabel();
        patricio.setIcon(Icon_patricio);
        patricio.setBounds(50, 150, 50, 50);

        gat_posicion = new JLabel();
        gat_posicion.setBounds(50, 50, 350, 50);

        cart_posicion = new JLabel();
        cart_posicion.setBounds(50, 100, 350, 50);

        pat_posicion = new JLabel();
        pat_posicion.setBounds(50, 150, 350, 50);

        btnIniciar = new JButton("Iniciar Carrera");
        btnIniciar.setBounds(150, 200, 150, 50);

        btnIniciar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Hilo tgatito = new Hilo("Gatito", gatito, gat_posicion);
                Hilo tcartman = new Hilo("Cartman", cartman, cart_posicion);
                Hilo tpatricio = new Hilo("Patricio", patricio, pat_posicion);
                tgatito.start();
                tcartman.start();
                tpatricio.start();
            }
        });

        panel.add(gatito);
        panel.add(gat_posicion);
        panel.add(cartman);
        panel.add(cart_posicion);
        panel.add(patricio);
        panel.add(pat_posicion);
        panel.add(btnIniciar);
        panel.add(meta);
        panel.add(fondo);

        add(panel);
        setVisible(true);
    }
}
