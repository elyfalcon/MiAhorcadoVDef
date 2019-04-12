package miahorcadov2;

import Entidades.Diccionario;
import Entidades.Palabras;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.xml.stream.events.Characters;

/**
 *
 * @author Eli
 */
public class MiAhorcadoV extends javax.swing.JFrame
{

    /**
     * Creates new form MiAhorcadoV
     */
    public ImageIcon imgs[];
    public JButton btns[];
    public String msgs[];
    public int ran;
    public int err;
    public String res[];
    Diccionario lista;

    int acierto = 0;

    String[] pal;
    String mascara;
    // Diccionario lista = new Diccionario();

    public MiAhorcadoV()
    {
        this.setContentPane(new JLabel(new ImageIcon("fondo.jpg")));
        initComponents();

        imgs = new ImageIcon[6];
        btns = new JButton[27];
        msgs = new String[20];
        iniciar();
        this.setTitle("El ahorcado de Pinky");
        super.setIconImage(new ImageIcon(getClass().getResource("/imagenes/infinito.gif")).getImage());

    }

    public void iniciarABC()
    {

        if (this.panelTeclado != null)
        {
            this.panelTeclado.removeAll();
        }

        JButton[] botones;
        Container cp = this.panelTeclado;
        GridLayout gl = new GridLayout(3, 7);
        gl.setHgap(2);
        gl.setVgap(2);
        cp.setLayout(gl);
        String letras = "ABCDEFGHIJKLMNÑOPQRSTUVWXYZ";

        botones = new JButton[letras.length()];

        for (int i = 0; i < letras.length(); i++)
        {
            botones[i] = new JButton();
            cp.add(botones[i]);
            botones[i].setText(String.valueOf(letras.charAt(i)));
            botones[i].setFont(new Font("Tahoma", 0, 20));
            botones[i].setVisible(true);
            botones[i].addActionListener(new ActionListener()
            {
                public void actionPerformed(java.awt.event.ActionEvent evt)
                {
                    VerificarLetra(evt);// como fucniona el juego

                }
            });

        }
    }

    //funcion para comenzar los parametros del juego o iniciar una nueva partida
    public void iniciar()
    {
        iniciarABC();
        //ERRORES EN 0
        err = 0;
        acierto = 0;
        actualizarImagen(err + 1);
        mascaraPalabra.setText("");

        //para generar una palabra aleatoriamente
        //SEPARA EL MENSAJE POR PALABRAS
        //ACA DEBO PONER EL ARRAY DE LA LISTA DEL DICCIONARIO PERO NO ME SALE  
        this.lista = Diccionario.cargarDiccionario("diccionario.xml");

        //AJUSTES DE PISTA
        jScrollPane1.setBackground(new Color(0, 0, 0));
        jScrollPane1.setOpaque(false);
        jScrollPane1.getViewport().setOpaque(false);

        this.pal = new String[this.lista.getLista().size()];

        for (int i = 0; i < pal.length; i++)
        {
            pal[i] = this.lista.getLista().get(i).getPalabra();
        }
        ran = (int) (Math.random() * ((pal.length - 1) + 1));

        //   res = new String[pal[ran].length()];
        // res=new String[]
        int j = 0;
        // seran los guiones que van debajo de las letras como una separacion_

        System.out.println("Palabra es: " + pal[ran]);

        // seran los guiones que van debajo de las letras como una separacion_
        generaMascara(pal[ran]);
    }

    //al presionar una letra, esta se buscara si pertenece a la palabra, de lo contrario la marcara como error 
    public void VerificarLetra(ActionEvent e)
    {

        JButton bt = (JButton) e.getSource();
        char c;

        boolean esta = false;
        //la tecla es inicializada
        System.out.println("letra presionda" + bt.getText());

        c = bt.getText().toLowerCase().charAt(0);
        //busca si la letra esta en la frase
        StringBuilder resp = new StringBuilder();

        for (int i = 0; i < pal[ran].length(); i++)
        {
            if (c == pal[ran].charAt(i))
            {
                resp.append(bt.getText());
                acierto++;
                esta = true;
            }
            else
            {
                if (this.mascara.charAt(i) != '*')
                {
                    resp.append(this.mascara.charAt(i));
                }
                else
                {
                    resp.append("*");
                }
            }

        }
        this.mascara = resp.toString();
        mascaraPalabra.setText(resp.toString());

        //SI LA LETRA ESTA EN EL MENSAJE SE MUESTRA EN EL TEXTPANEL
        if (esta)
        {
            System.out.println("Acierto" + acierto);
            System.out.println("mascara" + this.mascara.length());
            if (acierto == this.mascara.length())
            {
                //al ser correcta se muestra un mensaje y se reinicia el juego
                JOptionPane.showMessageDialog(this, "Ganaste xD!!!");
                iniciar();
                //SI LA LETRA NO ESTA EN EL MENSAGE, SE INCREMENTA EL ERROR Y SE CAMBIA LA IMAGEN
            }
            else
            {
                esta = false;
            }

        }
        else
        {
            err++;
            actualizarImagen(err);
            if (err == 7)
            {
                JOptionPane.showMessageDialog(this, "Proba con otra palabra la respuesta es: \n" + pal[ran]);
                iniciar();
                return;
            }
        }

        //SI SE LLEGA A LOS 5 ERRORES ENTONCES SE PIERDE EL JUEGO Y SE MANDA EL MENSAGE DE:
        //esta es la linea que desactiva las letras despues de ser usadas :3
        bt.setEnabled(false);
    }

    public void actualizarImagen(int intento)
    {
        this.lblImagen.setVisible(true);
        this.lblImagen.setIcon(new ImageIcon("Aho" + intento + ".gif"));
    }

    //  }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    //  @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents()
    {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        mascaraPalabra = new javax.swing.JTextPane();
        jButton2 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jButton28 = new javax.swing.JButton();
        panelTeclado = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        lblImagen = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(204, 102, 255));

        jPanel1.setBackground(new java.awt.Color(204, 102, 255));
        jPanel1.setForeground(new java.awt.Color(204, 0, 204));
        jPanel1.setMaximumSize(new java.awt.Dimension(889, 579));
        jPanel1.setMinimumSize(new java.awt.Dimension(889, 579));
        jPanel1.setOpaque(false);

        jScrollPane1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane1.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
        jScrollPane1.setMaximumSize(new java.awt.Dimension(440, 75));
        jScrollPane1.setMinimumSize(new java.awt.Dimension(440, 75));
        jScrollPane1.setOpaque(false);
        jScrollPane1.setPreferredSize(new java.awt.Dimension(440, 75));

        mascaraPalabra.setBackground(null);
        mascaraPalabra.setBorder(null);
        mascaraPalabra.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        mascaraPalabra.setOpaque(false);
        jScrollPane1.setViewportView(mascaraPalabra);

        jButton2.setBackground(new java.awt.Color(204, 51, 255));
        jButton2.setText("Nueva Partida");
        jButton2.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Bahnschrift", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("AHORCADO");

        jButton28.setText("Salir");
        jButton28.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                jButton28ActionPerformed(evt);
            }
        });

        panelTeclado.setOpaque(false);

        javax.swing.GroupLayout panelTecladoLayout = new javax.swing.GroupLayout(panelTeclado);
        panelTeclado.setLayout(panelTecladoLayout);
        panelTecladoLayout.setHorizontalGroup(
            panelTecladoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 440, Short.MAX_VALUE)
        );
        panelTecladoLayout.setVerticalGroup(
            panelTecladoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 183, Short.MAX_VALUE)
        );

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Pinky.png"))); // NOI18N
        jLabel2.setMaximumSize(new java.awt.Dimension(139, 174));
        jLabel2.setMinimumSize(new java.awt.Dimension(139, 174));
        jLabel2.setName(""); // NOI18N
        jLabel2.setPreferredSize(new java.awt.Dimension(139, 174));

        jLabel4.setFont(new java.awt.Font("Bahnschrift", 1, 36)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("DE PINKY");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(62, 62, 62)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 261, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 261, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(panelTeclado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 440, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 46, Short.MAX_VALUE)
                        .addComponent(lblImagen, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(111, 111, 111))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(68, 68, 68)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton28, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(32, 32, 32)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(40, 40, 40)
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(38, 38, 38)
                        .addComponent(lblImagen, javax.swing.GroupLayout.PREFERRED_SIZE, 273, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addComponent(panelTeclado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(45, 45, 45)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton28, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(121, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton28ActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jButton28ActionPerformed
    {//GEN-HEADEREND:event_jButton28ActionPerformed
        System.exit(0);
    }//GEN-LAST:event_jButton28ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jButton2ActionPerformed
    {//GEN-HEADEREND:event_jButton2ActionPerformed
        // TODO add your handling code here:
        iniciar();
    }//GEN-LAST:event_jButton2ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[])
    {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try
        {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels())
            {
                if ("Nimbus".equals(info.getName()))
                {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        }
        catch (ClassNotFoundException ex)
        {
            java.util.logging.Logger.getLogger(MiAhorcadoV.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        catch (InstantiationException ex)
        {
            java.util.logging.Logger.getLogger(MiAhorcadoV.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        catch (IllegalAccessException ex)
        {
            java.util.logging.Logger.getLogger(MiAhorcadoV.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        catch (javax.swing.UnsupportedLookAndFeelException ex)
        {
            java.util.logging.Logger.getLogger(MiAhorcadoV.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable()
        {
            public void run()
            {
                new MiAhorcadoV().setVisible(true);
            }
        });
    }

    private void generaMascara(String aux)
    {
        StringBuilder masc = new StringBuilder();
        for (int i = 0; i < aux.length(); i++)
        {
            masc.append('*');
        }
        this.mascara = masc.toString();

        mascaraPalabra.setText(this.mascara);
    }

    public boolean BuscaLetraEnPalabra(char letra, String palabra)
    {
        StringBuilder buffer = new StringBuilder(palabra);
        boolean resp = false;
        String retorno = Character.toString(letra);

        for (int i = 0; i < palabra.length(); i++)
        {
            if (retorno.equals(palabra.charAt(i)))
            {//la encontro, aca copio la letra en la posicion de la palabra encontrada
                buffer.setCharAt(i, letra);
                resp = true;
            }
        }
        System.out.println(palabra);
        return resp;
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton28;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblImagen;
    private javax.swing.JTextPane mascaraPalabra;
    private javax.swing.JPanel panelTeclado;
    // End of variables declaration//GEN-END:variables
}
