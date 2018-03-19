package uhv1.Vistas;


import java.awt.Frame;
import java.awt.Rectangle;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JList;
import javax.swing.JPanel;
import uhv1.Negocio.Casa;

/** @author Vianey*/
public class DialogoSeleccionCasa extends JDialog {
    private static final long serialVersionUID = 1L;
    private JPanel jContentPane = null;
    private JList jListCasas = null;
    private JButton jButtonAceptar = null;
    private Casa[] casas;

    public DialogoSeleccionCasa(Frame owner, Casa casas[]) {
        super(owner, true);
        initialize();
        DefaultListModel model = new DefaultListModel();
        for (Casa c : casas) {
            model.addElement(c);
        }
        jListCasas.setModel(model);
    }

    /**
     * This method initializes this
     *     
* @return void
     */
    private void initialize() {
        this.setSize(406, 295);
        this.setTitle("Seleccionar Casa");
        this.setContentPane(getJContentPane());
    }

    /**
     * This method initializes jContentPane
     *     
* @return javax.swing.JPanel
     */
    private JPanel getJContentPane() {
        if (jContentPane == null) {
            jContentPane = new JPanel();
            jContentPane.setLayout(null);
            jContentPane.add(getJListCasas(), null);
            jContentPane.add(getJButtonAceptar(), null);
        }
        return jContentPane;
    }

   

    /**
     * This method initializes jListCasas
     *     
* @return javax.swing.JList
     */
    private JList getJListCasas() {
        if (jListCasas == null) {
            jListCasas = new JList();
            jListCasas.setBounds(new Rectangle(15, 15, 362, 190));
        }
        return jListCasas;
    }

    /**
     * This method initializes jButtonAceptar
     *     
* @return javax.swing.JButton
     */
    private JButton getJButtonAceptar() {
        if (jButtonAceptar == null) {
            jButtonAceptar = new JButton();
            jButtonAceptar.setBounds(new Rectangle(240, 214, 138, 28));
            jButtonAceptar.setText("Aceptar");
            jButtonAceptar.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent e) {
                    setVisible(false);
                }
            });
        }
        return jButtonAceptar;
    }

    public Casa getCasaSeleccionada() {
        return (Casa) jListCasas.getSelectedValue();
    }
} // @jve:decl-index=0:visual-constraint="10,10"

