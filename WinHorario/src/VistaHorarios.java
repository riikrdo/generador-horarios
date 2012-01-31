import java.awt.Component;
import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author monkey
 */
public final class VistaHorarios extends javax.swing.JFrame {
    
    static ArrayList <Horario> soluciones;
    static ArrayList<Asignatura> asignaturas;
    static List<String[]> listaTurnos;
    static Component anterior;
    
    DefaultTableModel tablaHorario;  
    DefaultTableModel tablaAsigs;  
    
    Horario horario;
    int horarioDibujado;
    
    public VistaHorarios(ArrayList <Horario> s,ArrayList<Asignatura> a, Component ant) 
    {
        soluciones=s;
        asignaturas=a;
        anterior=ant;
        horarioDibujado=0;
        
        //Carga los elementos del ComboBox de la tabla de asignaturas
        cargaListaTurnos();
        
        //Inicia vista
        initComponents();
        jLabel1.setText("Horarios generados: "+s.size());
        tablaHorario = (DefaultTableModel) jTable1.getModel();
        tablaAsigs = (DefaultTableModel) jTable2.getModel();
        
        //Carga tabla de asignaturas
        actualizaTablaAsigs();
        
        //Centra la ventana
        setLocationRelativeTo(null);
        
        //Dibuja el primer horario (soluciones.size > 0 al invocar)
        horario=soluciones.get(0);
        actualizaHorario();
        
        
//        //Listener para cuando cambie el ComboBox
//        tablaAsigs.addTableModelListener(new TableModelListener() {
//            @Override public void tableChanged(TableModelEvent e) 
//            {
//                cambioCombo();
//            }
//        });
    }
    
    private void cargaListaTurnos(){
        
        listaTurnos = new ArrayList<String[]>();
        
        String[] turnosAux;
        
        for (int i=0; i < asignaturas.size(); i++)
        {
            turnosAux = new String[asignaturas.get(i).clases.size()];
            
            for (int j=0; j < asignaturas.get(i).clases.size(); j++)
            {
                turnosAux[j]= asignaturas.get(i).clases.get(j).toString();
            }
            
            listaTurnos.add(turnosAux);
        }
                
    }
    
    private void actualizaTablaAsigs()
    {
        Object nuevo[];
         for (int i=0; i < asignaturas.size(); i++)
         {
             nuevo = new Object[] {asignaturas.get(i).nombre,""};
             tablaAsigs.addRow(nuevo);
         }
       
    }
    //Comprueba que el contenido de la tabla de asignaturas y el de la tabla
    //de horarios sea el mismo. Si no lo es, hay que refrescar la tablaHorario.
//    public void cambioCombo()
//    {
//        for (int i=0; i < tablaAsigs.getRowCount(); i++)
//        {
//            if (!((String)tablaAsigs.getValueAt(i, 1)).equals(horario.clases[i].toString()))
//            {
//                System.out.println("CAmbio!!!");
//                horarioDibujado=-1;
//                jLabel3.setText("Horario mostrado: manual");
//
//                Clase [] caux = horario.clases.clone();
//
//                String nuevohorario=(String)tablaAsigs.getValueAt(i, 1);
//
//                caux[i].horaini=Main.hora(Double.parseDouble(nuevohorario.substring(2, 7).replace(':','.')));
//                caux[i].horafin=Main.hora(Double.parseDouble(nuevohorario.substring(8, 13).replace(':','.')));
//                caux[i].duracion=caux[i].horafin-caux[i].horaini;
//
//                horario = new Horario(caux);
//
//                Dibuja();
//            }     
//        }
//    }
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jDialog1 = new javax.swing.JDialog();
        jMenuItem1 = new javax.swing.JMenuItem();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        jButton6 = new javax.swing.JButton();

        javax.swing.GroupLayout jDialog1Layout = new javax.swing.GroupLayout(jDialog1.getContentPane());
        jDialog1.getContentPane().setLayout(jDialog1Layout);
        jDialog1Layout.setHorizontalGroup(
            jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        jDialog1Layout.setVerticalGroup(
            jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        jMenuItem1.setText("jMenuItem1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("monkey! Generador de horarios");
        setIconImage(new ImageIcon("monkey.png").getImage());

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"08:00", null, null, null, null, null, null, null},
                {"08:30", null, null, null, null, null, null, null},
                {"09:00", null, null, null, null, null, null, null},
                {"09:30", null, null, null, null, null, null, null},
                {"10:00", null, null, null, null, null, null, null},
                {"10:30", null, null, null, null, null, null, null},
                {"11:00", null, null, null, null, null, null, null},
                {"11:30", null, null, null, null, null, null, null},
                {"12:00", null, null, null, null, null, null, null},
                {"12:30", null, null, null, null, null, null, null},
                {"13:00", null, null, null, null, null, null, null},
                {"13:30", null, null, null, null, null, null, null},
                {"14:00", null, null, null, null, null, null, null},
                {"14:30", null, null, null, null, null, null, null},
                {"15:00", null, null, null, null, null, null, null},
                {"15:30", null, null, null, null, null, null, null},
                {"16:00", null, null, null, null, null, null, null},
                {"16:30", null, null, null, null, null, null, null},
                {"17:00", null, null, null, null, null, null, null},
                {"17:30", null, null, null, null, null, null, null},
                {"18:00", null, null, null, null, null, null, null},
                {"18:30", null, null, null, null, null, null, null},
                {"19:00", null, null, null, null, null, null, null},
                {"19:30", null, null, null, null, null, null, null},
                {"20:00", null, null, null, null, null, null, null},
                {"20:30", null, null, null, null, null, null, null},
                {"21:00", null, null, null, null, null, null, null},
                {"21:30", null, null, null, null, null, null, null},
                {"22:00", null, null, null, null, null, null, null},
                {"22:30", null, null, null, null, null, null, null},
                {"23:00", null, null, null, null, null, null, null}
            },
            new String [] {
                "Hora", "Lunes", "Martes", "Miércoles", "Jueves", "Viernes", "Sábado", "Domingo"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(jTable1);
        jTable1.getColumnModel().getColumn(0).setResizable(false);
        jTable1.getColumnModel().getColumn(1).setResizable(false);
        jTable1.getColumnModel().getColumn(2).setResizable(false);
        jTable1.getColumnModel().getColumn(3).setResizable(false);
        jTable1.getColumnModel().getColumn(4).setResizable(false);
        jTable1.getColumnModel().getColumn(5).setResizable(false);
        jTable1.getColumnModel().getColumn(6).setResizable(false);
        jTable1.getColumnModel().getColumn(7).setResizable(false);

        jLabel1.setText("Horarios generados");

        jLabel2.setText("Mostrar horario:");

        jTextField2.setText("1");
        jTextField2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                CuadroTexto(evt);
            }
        });

        jButton1.setText("Aceptar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonAceptar(evt);
            }
        });

        jButton2.setText("Anterior");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonAnterior(evt);
            }
        });

        jButton3.setText("Siguiente");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonSiguiente(evt);
            }
        });

        jButton4.setText("Exportar este horario");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonExportar(evt);
            }
        });

        jButton5.setText("Volver");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuVolver(evt);
            }
        });

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Asignatura", "Turnos"
            }
        ));
        jTable2.setFocusable(false);
        jTable2.setRequestFocusEnabled(false);
        jTable2.setRowSelectionAllowed(false);
        jScrollPane2.setViewportView(jTable2);
        jTable2.getColumnModel().getColumn(1).setCellEditor(new MyComboEditor(listaTurnos));

        jLabel3.setText("Horario mostrado: ");

        jButton6.setText("Aplicar cambios manuales");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonCambioManual(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton1))
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(jButton2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton3))
                    .addComponent(jButton6, javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(jButton4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton5)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 640, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton1)
                            .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton3)
                            .addComponent(jButton2))
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton6)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton5)
                            .addComponent(jButton4)))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 531, Short.MAX_VALUE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void botonAceptar(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonAceptar
    
        actualizaHorario();
    }//GEN-LAST:event_botonAceptar

    private void CuadroTexto(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_CuadroTexto
       
        actualizaHorario();
//        if (evt.getKeyCode() == KeyEvent.VK_ENTER){
//            actualizaHorario();
//        }
    }//GEN-LAST:event_CuadroTexto

    private void botonAnterior(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonAnterior
      
        int seleccion = Integer.parseInt(jTextField2.getText())-1;
        
        if (seleccion > 0){
            String a="";
            a+=seleccion;
            jTextField2.setText(a);
            actualizaHorario();
        }
    }//GEN-LAST:event_botonAnterior

    private void botonSiguiente(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonSiguiente
        
        int seleccion = Integer.parseInt(jTextField2.getText());
        
        if (seleccion < soluciones.size()){
            seleccion++;
            String a="";
            a+=seleccion;
            jTextField2.setText(a);
            actualizaHorario();
        }
    }//GEN-LAST:event_botonSiguiente
String ExportDia(int d){
        String res;
        switch (d)
        {
                case 1: res="MO"; break;
                case 2: res="TU"; break;
                case 3: res="WE"; break;
                case 4: res="TH"; break;
                case 5: res="FR"; break;
                case 6: res="SA"; break;
               default: res="SU"; break;
        }
        
        return res;
    }
    
    String ExportHora(int h){
        String res; 
        switch (h)
        {
            case  0: res="T080000"; break;
            case  1: res="T083000"; break;
            case  2: res="T090000"; break;
            case  3: res="T093000"; break;
            case  4: res="T100000"; break;
            case  5: res="T103000"; break;
            case  6: res="T110000"; break;
            case  7: res="T113000"; break;
            case  8: res="T120000"; break;
            case  9: res="T123000"; break;
            case 10: res="T130000"; break;
            case 11: res="T133000"; break;
            case 12: res="T140000"; break;
            case 13: res="T143000"; break;
            case 14: res="T150000"; break;
            case 15: res="T153000"; break;
            case 16: res="T160000"; break;
            case 17: res="T163000"; break;
            case 18: res="T170000"; break;
            case 19: res="T173000"; break;
            case 20: res="T180000"; break;
            case 21: res="T183000"; break;
            case 22: res="T190000"; break;
            case 23: res="T193000"; break;
            case 24: res="T200000"; break;
            case 25: res="T203000"; break;
            case 26: res="T210000"; break;
            case 27: res="T213000"; break;
            case 28: res="T220000"; break;
            case 29: res="T223000"; break;
            default: res="T230000"; break;
        }
        return res;
    }
    
    String ExportFecha(int d){
        switch (d) {
            case 1: return "02";
            case 2: return "03";
            case 3: return "04";
            case 4: return "05";
            case 5: return "06";
            case 6: return "07";
           default: return "08";
        }
    }
    private void BotonExportar(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonExportar
      
        //Crea el .ics
        String export="BEGIN:VCALENDAR\r\n";
        for (int i=0; i < horario.clases.length; i++){
            export += "BEGIN:VEVENT\r\nSUMMARY:"+horario.clases[i].asig
                    + "\r\nDTSTART;TZID=Europe/Madrid:201201"+ExportFecha(horario.clases[i].dia)+ExportHora(horario.clases[i].horaini)
                    + "\r\nDTEND;TZID=Europe/Madrid:201201"+ExportFecha(horario.clases[i].dia)+ExportHora(horario.clases[i].horafin)
                    + "\r\nRRULE:FREQ=WEEKLY;BYDAY="+ExportDia(horario.clases[i].dia)+"\r\nEND:VEVENT\r\n";
        }
        export += "END:VCALENDAR";
              
        //Guardar en fichero
//        try{ 
//            javax.swing.JFileChooser jF1=new javax.swing.JFileChooser(); ;
//            String direccion; 
//            FileWriter  Guardx;
//            File f= new File("horario.ics"); 
//            boolean guardado=false;
//
//            while (!guardado)
//            {
//                if(jF1.showSaveDialog(null)==JFileChooser.APPROVE_OPTION)
//                { 
//                    jF1.setSelectedFile(f); 
//                    direccion = jF1.getSelectedFile().getAbsolutePath(); 
//                    Guardx=new FileWriter(direccion);
//                    f = new File(direccion);
//                    
//                    if(f.exists() && (JOptionPane.NO_OPTION == JOptionPane.showConfirmDialog(this,"Ya existe un fichero con este nombre. ¿Deseas reemplazarlo?","Fichero existente",JOptionPane.YES_NO_OPTION)))
//                    {
//                        //nada
//                    }
//                    else
//                    {
//                        Guardx.write(export);
//                        Guardx.close(); 
//                        JOptionPane.showMessageDialog(this,"Exportado correctamente. ","Exportar",JOptionPane.INFORMATION_MESSAGE);
//                        guardado=true;
//                    }
//                }
//            }
        javax.swing.JFileChooser jF1= new javax.swing.JFileChooser(); 
        File f = new File("horario.ics"); 
        jF1.setSelectedFile(f); 
        try{ 
            if(jF1.showSaveDialog(null)==JFileChooser.APPROVE_OPTION)
            { 
                String direccion = jF1.getSelectedFile().getAbsolutePath(); 
                FileWriter  Guardx=new FileWriter(direccion);
                Guardx.write(export);
                Guardx.close(); 
                JOptionPane.showMessageDialog(this,"Horario exportado.","Exportar",JOptionPane.INFORMATION_MESSAGE);
            }
        }catch (Exception ex){ 

            System.err.println("Fallo al guardar.");

        } 
        
    }//GEN-LAST:event_BotonExportar

    private void menuVolver(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuVolver
        
        anterior.setVisible(true);
        this.setEnabled(false);
        this.setVisible(false);
        
    }//GEN-LAST:event_menuVolver
  
    public static int inicial2int(char c) 
    {       
        switch (c)
        {
            case 'L': return 1;
            case 'M': return 2;
            case 'X': return 3;
            case 'J': return 4;
            case 'V': return 5;
            case 'S': return 6;
             default: return 7;            
        }
    }
  
    private void botonCambioManual(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonCambioManual

        Clase [] caux = new Clase [asignaturas.size()];
        String valortabla;
        
        for (int i=0; i < tablaAsigs.getRowCount(); i++)
        {
            valortabla= (String) tablaAsigs.getValueAt(i,1);
            
            caux[i]= new Clase((String)tablaAsigs.getValueAt(i,0),
                               inicial2int(valortabla.substring(0,1).charAt(0)),  
                               Main.hora(Double.parseDouble(valortabla.substring(2, 7).replace(':','.'))),
                               Main.hora(Double.parseDouble(valortabla.substring(8).replace(':','.'))));
            
            System.out.println(caux[i]);
        }
        
        horario = new Horario(caux);

        horarioDibujado=-1; //No me gusta esta variable
        jLabel3.setText("Horario mostrado: manual");
        Dibuja();
    }//GEN-LAST:event_botonCambioManual

    void actualizaHorario(){
        
        int seleccion = Integer.parseInt(jTextField2.getText())-1;
        
        if (seleccion > -1 && seleccion< soluciones.size())
        {
            horarioDibujado=seleccion;
            horario=soluciones.get(seleccion);
            jLabel3.setText("Horario mostrado: "+ (seleccion+1));
            Dibuja();
        }
        
        
    }
         
    
    public void Dibuja(){
        
        //Limpia
        for (int i=1; i < 8; i++){
            for (int j=0; j < 31; j++) {
                tablaHorario.setValueAt("",j,i);
            }
        }
        
        //Dibuja
        for (int i=0; i < horario.clases.length; i++)
        {
            //Escribe el nombre de la asignatura
            if ( "".equals((String) tablaHorario.getValueAt(horario.clases[i].horaini, horario.clases[i].dia)))
            {
                tablaHorario.setValueAt(horario.clases[i].asig, 
                                        horario.clases[i].horaini, 
                                        horario.clases[i].dia);
            }
            else
            {
                tablaHorario.setValueAt(tablaHorario.getValueAt(horario.clases[i].horaini, 
                                                                horario.clases[i].dia)
                                        +" , "+horario.clases[i].asig, 
                                        horario.clases[i].horaini, 
                                        horario.clases[i].dia);                
            }
            
            //Dibuja guiones por debajo
            for (int j=horario.clases[i].horaini+1; j < horario.clases[i].horafin ; j++) 
            {
                if ( "".equals((String) tablaHorario.getValueAt(j, horario.clases[i].dia)))
                {
                    tablaHorario.setValueAt("-", j, horario.clases[i].dia);
                }
                else
                {
                    tablaHorario.setValueAt(tablaHorario.getValueAt(j, horario.clases[i].dia)+" , -",
                                            j, horario.clases[i].dia);
                }
            }
            
            //Actualiza tabla de asignaturas
            tablaAsigs.setValueAt(horario.clases[i].toString(),i,1);
        }
               
        //Salida por terminal
        System.out.println("-----Horario "+(horarioDibujado+1)+"-----\n"
                       +"Dias con clases:\n"
                       +horario.totaldias
                       +"\n\nAsignaturas:\n"
                       +horario.dias[0].numasignaturas+","
                       +horario.dias[1].numasignaturas+","
                       +horario.dias[2].numasignaturas+","
                       +horario.dias[3].numasignaturas+","
                       +horario.dias[4].numasignaturas+","
                       +horario.dias[5].numasignaturas+","
                       +horario.dias[6].numasignaturas
                       +"\n\nMedias-horas en la uni: \n"
                       +horario.dias[0].tiempoEnLaUni+"+"
                       +horario.dias[1].tiempoEnLaUni+"+"
                       +horario.dias[2].tiempoEnLaUni+"+"
                       +horario.dias[3].tiempoEnLaUni+"+"
                       +horario.dias[4].tiempoEnLaUni+"+"
                       +horario.dias[5].tiempoEnLaUni+"+"
                       +horario.dias[6].tiempoEnLaUni+"="
                       +horario.tiempoEnLaUni
                       +"\n\nMedias-horas muertas:\n"
                       +horario.dias[0].horasmuertas+"+"
                       +horario.dias[1].horasmuertas+"+"
                       +horario.dias[2].horasmuertas+"+"
                       +horario.dias[3].horasmuertas+"+"
                       +horario.dias[4].horasmuertas+"+"
                       +horario.dias[5].horasmuertas+"+"
                       +horario.dias[6].horasmuertas+"="
                       +horario.horasmuertas
                       +"\n\nMedia y desviacion hora de entrada;\n"
                       +horario.mediaEntrada+", "+horario.desviacionHoraEntrada
                       +"\n\nMedia y desviacion num asignaturas:\n"
                       +horario.mediasig+", "+horario.desviacionNumAsignaturas
                       +"\n\nDias tiempo para comer:\n"
                       +horario.diasconlahoradelacomidalibre+"\n");
    }
    
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
            java.util.logging.Logger.getLogger(VistaHorarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VistaHorarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VistaHorarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VistaHorarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /*
         * Create and display the form
         */
        java.awt.EventQueue.invokeLater(new Runnable() {

            @Override
            public void run() {
                new VistaHorarios(soluciones,asignaturas,anterior).setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JDialog jDialog1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JTextField jTextField2;
    // End of variables declaration//GEN-END:variables


    //Carga editor de ComboBox para la tabla de asignaturas
    private class MyComboEditor extends DefaultCellEditor{

        List<String[]> values;

        public MyComboEditor(List<String[]> values){
            super(new JComboBox());
            this.values = values;
        }

        @Override
            public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) 
            {
                JComboBox combo = (JComboBox)getComponent();
                combo.removeAllItems();
                String[] valores = values.get(row);

                for(int i=0; i<valores.length; i++){
                        combo.addItem(valores[i]);
                }
                combo.setSelectedItem(value);
                
//                combo.addActionListener (new ActionListener () {
//                        @Override
//                        public void actionPerformed(ActionEvent e) {
//                            cambioCombo();
//                        }
//                        });

                return combo;
            }
    }
}
