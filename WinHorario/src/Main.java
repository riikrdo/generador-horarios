import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class Main extends javax.swing.JFrame {

    DefaultTableModel tabla;
    
    ArrayList<Asignatura> Asignaturas = new ArrayList<Asignatura>();
    int maxTurnos=0;
    int[] horarioBT; //Se emplea en el Backtracking
    public ArrayList <Horario> soluciones = new ArrayList <Horario>  ();
        
    boolean sustituidoPorDuracion=false;
    
    public Main() {
        //Inicializa componentes
        initComponents();
        
        //Centra la ventana
        setLocationRelativeTo (null);
        
        //Crea el modelo de la tabla
        tabla = (DefaultTableModel) jTable1.getModel();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jToolBar1 = new javax.swing.JToolBar();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jComboBox1 = new javax.swing.JComboBox();
        jTextField1 = new javax.swing.JTextField();
        jComboBox2 = new javax.swing.JComboBox();
        jComboBox3 = new javax.swing.JComboBox();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem2 = new javax.swing.JMenuItem();

        jToolBar1.setRollover(true);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("monkey! Generador de horarios");
        setIconImage(new ImageIcon("monkey.png").getImage());

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Asignatura", "Día", "Hora inicial", "Hora final", "Seleccionar"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Boolean.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(jTable1);

        jButton1.setText("Insertar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonInsertarFila(evt);
            }
        });

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Lunes", "Martes", "Miércoles", "Jueves", "Viernes", "Sábado", "Domingo" }));

        jComboBox2.setEditable(true);
        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "08:00", "08:30", "09:00", "09:30", "10:00", "10:30", "11:00", "11:30", "12:00", "12:30", "13:00", "13:30", "14:00", "14:30", "15:00", "15:30", "16:00", "16:30", "17:00", "17:30", "18:00", "18:30", "19:00", "19:30", "20:00", "20:30", "21:00", "21:30", "22:00", "22:30", "23:00" }));

        jComboBox3.setEditable(true);
        jComboBox3.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "08:00", "08:30", "09:00", "09:30", "10:00", "10:30", "11:00", "11:30", "12:00", "12:30", "13:00", "13:30", "14:00", "14:30", "15:00", "15:30", "16:00", "16:30", "17:00", "17:30", "18:00", "18:30", "19:00", "19:30", "20:00", "20:30", "21:00", "21:30", "22:00", "22:30", "23:00" }));
        jComboBox3.setSelectedIndex(2);

        jLabel1.setText("Asignatura");

        jLabel2.setText("Día");

        jLabel3.setText("Hora inicial");

        jLabel4.setText("Hora final");

        jButton2.setText("Generar horarios");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonGenerarHorarios(evt);
            }
        });

        jButton3.setText("Eliminar selección");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonEliminarSeleccion(evt);
            }
        });

        jMenu1.setText("Archivo");

        jMenuItem1.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_I, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem1.setText("Importar desde fichero");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenuImportar(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        jMenuItem3.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_D, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem3.setText("Sustituir hora final por duración");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenuSustituir(evt);
            }
        });
        jMenu1.add(jMenuItem3);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Ayuda");

        jMenuItem2.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F1, 0));
        jMenuItem2.setText("Acerca de");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenuAbout(evt);
            }
        });
        jMenu2.add(jMenuItem2);

        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jTextField1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(99, 99, 99)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jComboBox3, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jButton1))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(450, 450, 450)
                        .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, 55, Short.MAX_VALUE)
                        .addGap(178, 178, 178))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton3)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel2))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel4)
                        .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jComboBox1)
                        .addComponent(jComboBox2)
                        .addComponent(jComboBox3)
                        .addComponent(jButton1))
                    .addComponent(jTextField1, javax.swing.GroupLayout.Alignment.LEADING))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 503, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton3))
                .addGap(21, 21, 21)
                .addComponent(jLabel5))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
      
    
    private void BotonInsertarFila(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonInsertarFila

        String fin=(String) jComboBox3.getSelectedItem();
                
        if (!fin.contains(":"))
        {
            double ini= Double.parseDouble(((String) jComboBox2.getSelectedItem() ).replace(":", ".")) + Double.parseDouble(fin);
            
            int partentera = (int) ini;
            double pdecimal =  ini - partentera;
            
            
            if (pdecimal > .5){
                fin="00";
                partentera++;
            }
            else if (pdecimal > .2){
                fin="30";
            }
            else{
                fin="00";
            }
               
                        
            if (partentera < 10){
                fin="0"+partentera+":"+fin;
            }
            else
            {
                fin=partentera+":"+fin;
            }
        }
        
        Object nuevo[]= {jTextField1.getText(),
                         jComboBox1.getSelectedItem(),
                         jComboBox2.getSelectedItem(), 
                         fin, false};
        tabla.addRow(nuevo);
    }//GEN-LAST:event_BotonInsertarFila

    private void BotonEliminarSeleccion(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonEliminarSeleccion
        for (int i=0; i < tabla.getRowCount(); i++){
            if ((Boolean) tabla.getValueAt(i, 4) == true ){
                tabla.removeRow(i);
                i--;
            }
        }
    }//GEN-LAST:event_BotonEliminarSeleccion

    int dia2int ( String dia){
        if      (dia.equals("Lunes"))     return 1;
        else if (dia.equals("Martes"))    return 2;
        else if (dia.equals("Miércoles")) return 3;
        else if (dia.equals("Jueves"))    return 4;
        else if (dia.equals("Viernes"))   return 5;
        else if (dia.equals("Sábado"))    return 6;
        else                              return 7;
    }
    
    //Esta función tiene traca. 
    // Las horas tienen un rango de [8,23], donde pueden haber valores medios (8:30)
    // Si lo desplazamos -8, el rango es [0-15], 
    // Pero cada hora puede ser en punto, o y media, es decir, 2 valores
    // Entonces, lo que devuelve esta en el rango [0-30]
    // Donde 8->0, 8:30->1, 9->2, 9:30->3 ... 23:00->30
    public int hora(double h)
    {
        h= (h-8)*2;
        int res= (int) h;
        
        if (h == res) return res;
        else          return res+1;
        
    }
    
    private void BotonGenerarHorarios(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonGenerarHorarios
     if (tabla.getRowCount() > 0){
        ArrayList <Clase> filas = new ArrayList <Clase> ();
        int horaini;
        for (int i=0; i< tabla.getRowCount(); i++)
        {
//            horaini=hora(Double.parseDouble(((String) tabla.getValueAt(i, 2)).replace(':','.')));
            filas.add(new Clase((String) tabla.getValueAt(i, 0) ,
                                dia2int((String) tabla.getValueAt(i, 1)),
                                hora(Double.parseDouble(((String) tabla.getValueAt(i, 2)).replace(':','.'))),
                                hora(Double.parseDouble(((String) tabla.getValueAt(i, 3)).replace(':','.')))));
        }
        Collections.sort(filas);
                
        String aux="/&@FC7)VYclëÎ=ñO?¿OL*";
        
        int mt=0;
        for (int i=0; i<filas.size(); i++){
            if (!aux.equals(filas.get(i).asig))
            {
                Asignaturas.add(new Asignatura(filas.get(i).asig));
                Asignaturas.get(Asignaturas.size()-1).add(filas.get(i));
                mt=1;
                if (mt>maxTurnos){
                    maxTurnos=mt;
                }
            }
            else
            {
                Asignaturas.get(Asignaturas.size()-1).add(filas.get(i));
                mt++;
                if (mt>maxTurnos){
                    maxTurnos=mt;
                }
            }
            aux=filas.get(i).asig;
        }
        
        generaHorarios();
     }  
    }//GEN-LAST:event_BotonGenerarHorarios

    void generaHorarios()
    {
        //Realiza backtracking
        horarioBT = new int[Asignaturas.size()];
        backtrack(0);
        
        //Carga vista de horarios
        VistaHorarios res=new VistaHorarios();
        res.setVisible(true);
        res.ejecuta(soluciones);
        this.setVisible(false);
    }
     void IncluyeEnSoluciones() {
        
        Clase [] temp = new Clase[Asignaturas.size()];
        
        for (int i=0; i < Asignaturas.size(); i++)
        {
           temp[i]=Asignaturas.get(i).clases.get(horarioBT[i]);
        } 
        
        soluciones.add(new Horario(temp));
    }
   
    boolean Coincide(Clase c, int k){
        
        for (int j=0; j<k; j++){
            if (c.Coincide(Asignaturas.get(j).clases.get(horarioBT[j]))){
                return true;
            }
        }
        
        return false;
    }
    
    public void backtrack(int k) {
        for (int i = 0; i <= maxTurnos; i++) {
            if (i< Asignaturas.get(k).clases.size() && !Coincide(Asignaturas.get(k).clases.get(i),k)) {
                
                horarioBT[k]=i;
                
                if (k == Asignaturas.size()-1) {
                      IncluyeEnSoluciones();
                } else {
                    backtrack(k + 1);
                }
            }
        }
    }
    
    private void MenuImportar(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuImportar
        
        //Muestra cuadro selector de archivos
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.showOpenDialog(this);
        File ruta = fileChooser.getSelectedFile();
        
        //Extrae datos del fichero
        if (ruta != null){
            try {
                    BufferedReader br = new BufferedReader(new FileReader(ruta));
                    String linea, a1, aux;
        
                    int dia, i,mt=0, horaini,horafin;
        
                    while ( (linea = br.readLine()) != null) 
                    {
                        i=0; 
                        a1="";
            
                        while (i < linea.length() && linea.charAt(i)!=' ')
                        {
                            a1+=linea.charAt(i);
                            i++;
                        }
            
                        while (i < linea.length() && linea.charAt(i)==' ') i++;
            
            
                        if (i == linea.length())
                        {
                            if (!a1.equals(""))
                            {
                                Asignaturas.add(new Asignatura(a1));
                                mt=0;
                            }
                        }
                        else
                        {
                            aux="";
                            while (i < linea.length() && linea.charAt(i)!=' '){
                                aux+=linea.charAt(i);
                                i++;
                            }
                            while (i < linea.length() && linea.charAt(i)==' ') i++;
                            horaini=hora(Double.parseDouble(aux));
                            
                            aux="";
                            while (i < linea.length() && linea.charAt(i)!=' ')
                            {
                                aux+=linea.charAt(i);
                                i++;
                            }
                            horafin=hora(Double.parseDouble(aux));
                
                            if      (a1.equals("L")) dia=1;
                            else if (a1.equals("M")) dia=2;
                            else if (a1.equals("X")) dia=3;
                            else if (a1.equals("J")) dia=4;
                            else if (a1.equals("V")) dia=5;
                            else if (a1.equals("S")) dia=6;
                            else                     dia=7;
                
                            Asignaturas.get(Asignaturas.size()-1).Clase(dia,horaini,horafin);
                
                            mt++;
                            if (mt>maxTurnos) maxTurnos=mt;
            
                        }   
                    }
                    
                    generaHorarios();
            
            } catch (IOException ex) {
                    System.err.println("Fichero no encontrado.");
            }
        }
    }//GEN-LAST:event_MenuImportar

    private void MenuAbout(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuAbout
       JOptionPane.showMessageDialog(this,
"Autores:\n Arturo Serna León \n Esther Marta Vicente Marrana\n\nDudas: arturoserna@gmail.com\n\n Licencia GNU GPL v3",
"Acerca de",
JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_MenuAbout

    private void MenuSustituir(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuSustituir
        // TODO add your handling code here:
        
        if (sustituidoPorDuracion){
            sustituidoPorDuracion=false;
            jLabel4.setText("Hora final");
            jComboBox3.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "08:00", "08:30", "09:00", "09:30", "10:00", "10:30", "11:00", "11:30", "12:00", "12:30", "13:00", "13:30", "14:00", "14:30", "15:00", "15:30", "16:00", "16:30", "17:00", "17:30", "18:00", "18:30", "19:00", "19:30", "20:00", "20:30", "21:00", "21:30", "22:00", "22:30", "23:00" }));
            jComboBox3.setSelectedIndex(2);
            jMenuItem3.setText("Sustituir hora final por duración");
        }
        else
        {
            sustituidoPorDuracion=true;
            jLabel4.setText("Duración");
            jComboBox3.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "0.30","1.00","1.30","2.00", "2.30", "3.00", "3.30", "4.00", "4.30", "5.00", "5.30", "6.00", "6.30", "7.00", "7.30", "8.00", "8.30", "9.00"} ));
            jComboBox3.setSelectedIndex(3);
            jMenuItem3.setText("Sustituir duración por hora final");
        }
    }//GEN-LAST:event_MenuSustituir

    
    public static void main(String args[]) {
        /*
         * Set the Nimbus look and feel
         */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /*
         * If Nimbus (introduced in Java SE 6) is not available, stay with the
         * default look and feel. For details see
         * http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /*
         * Create and display the form
         */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Main().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JComboBox jComboBox2;
    private javax.swing.JComboBox jComboBox3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JToolBar jToolBar1;
    // End of variables declaration//GEN-END:variables
}
