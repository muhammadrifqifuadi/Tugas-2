package generic;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.io.File;
import java.text.DecimalFormat;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;


public class Playlist extends javax.swing.JFrame {
    KoleksiMusik koleksi = new KoleksiMusik();
    private Object popupTombol;
    private Object btnPlaylist;
    private Object PopupTombol;

private void resizeListener() {
    addComponentListener(new ComponentAdapter() {
        @Override
        public void componentResized(ComponentEvent e) {
            resizeColumns();
        }
    });
}

private void resizeColumns() {
    float[] columnWidthPercentage = {70.0f, 20.0f, 10.0f}; // Sesuaikan ukuran
    int tW = tb1Playlist.getWidth();
    TableColumnModel jTableColumnModel = tb1Playlist.getColumnModel();
    
    for (int i = 0; i < columnWidthPercentage.length; i++) {
        TableColumn column = jTableColumnModel.getColumn(i);
        int pWidth = Math.round(columnWidthPercentage[i] * tW);
        column.setPreferredWidth(pWidth);
    }
    tb1Playlist.setRowHeight(27);
}
 
private String fileSizeOf(File file){
 DecimalFormat format = new DecimalFormat("#.##");
 long MB = 1024 * 1024;
 long KB = 1024;
 final double length = file.length();
 if (length > MB) {
 return format.format(length / MB) + " MB";
 }
 if (length > KB) {
 return format.format(length / KB) + " KB";
 }
 return format.format(length) + " B";
}
 
private String extensionOf(File file) {
    String fileExtension="";
    String fileName=file.getName();
    if(fileName.contains(".") && fileName.lastIndexOf(".")!= 0){
        fileExtension =
        fileName.substring(fileName.lastIndexOf(".")+1);
    }
    return fileExtension;
}

private void addFiles(File[] files){
    for (File file : files) {
        String path = file.getAbsolutePath();
        String fn = file.getName();
        String fileName = fn.substring(0, fn.length()-4);
        String fileSize = fileSizeOf(file);
        String extension = "";
        int i = path.lastIndexOf('.');
        if (i > 0) {
            extension = extensionOf(file);
        }
        Musik m = new Musik(path,fileName,fileSize,extension);
        koleksi.add(m);
    }
}


private void addFolder(File dir){
    File[] listOfFiles = dir.listFiles();
    for (File listOfFile : listOfFiles) {
        if (listOfFile.isFile()) {
            String path = listOfFile.getAbsolutePath();
            String fn = listOfFile.getName();
            String fileName = fn.substring(0, fn.length()-4);
            String fileSize = fileSizeOf(listOfFile);
            String extension;
            int i = path.lastIndexOf('.');
            if (i > 0) {
                extension = extensionOf(listOfFile);
                if("mp3".equalsIgnoreCase(extension)){
                    Musik m = new
                    Musik(path,fileName,fileSize,extension);
                    koleksi.add(m);
                }
            }
        } else if (listOfFile.isDirectory()) {
            addFolder(listOfFile);
        }
    }
}

public Playlist() {
    initComponents();
    tb1Playlist.setModel(koleksi); // Gunakan koleksi sebagai model JTable
    resizeColumns(); // Perbaiki nama method yang dipanggil
    resizeListener();
}    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        popuptombol = new javax.swing.JPopupMenu();
        addFile = new javax.swing.JMenuItem();
        addFolder = new javax.swing.JMenuItem();
        clearplaylist = new javax.swing.JMenuItem();
        pnFooter = new javax.swing.JPanel();
        btnplaylist = new java.awt.Button();
        jScrollPane1 = new javax.swing.JScrollPane();
        tb1Playlist = new javax.swing.JTable();

        addFile.setText("Addfiles");
        addFile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addFileActionPerformed(evt);
            }
        });

        addFolder.setText("addFolder");
        addFolder.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addFolderActionPerformed(evt);
            }
        });

        clearplaylist.setText("Clearplaylist");
        clearplaylist.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearplaylistActionPerformed(evt);
            }
        });

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        btnplaylist.setLabel("Playlist");
        btnplaylist.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnplaylistActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnFooterLayout = new javax.swing.GroupLayout(pnFooter);
        pnFooter.setLayout(pnFooterLayout);
        pnFooterLayout.setHorizontalGroup(
            pnFooterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnFooterLayout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addComponent(btnplaylist, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(769, Short.MAX_VALUE))
        );
        pnFooterLayout.setVerticalGroup(
            pnFooterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnFooterLayout.createSequentialGroup()
                .addContainerGap(49, Short.MAX_VALUE)
                .addComponent(btnplaylist, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(44, 44, 44))
        );

        getContentPane().add(pnFooter, java.awt.BorderLayout.CENTER);

        tb1Playlist.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tb1Playlist.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tb1PlaylistMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tb1Playlist);

        getContentPane().add(jScrollPane1, java.awt.BorderLayout.PAGE_START);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnplaylistActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnplaylistActionPerformed
            PopupTombol.show(btnPlaylist,
                btnPlaylist.getwidth(),
                btnPlaylist.getHeight()/2);
    }//GEN-LAST:event_btnplaylistActionPerformed

    private void addFileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addFileActionPerformed
            JFileChooser fc = new JFileChooser();
            fc.setDialogType (JFileChooser.FILES_ONLY);
            fc.setMultiSelectionEnabled(true);
            fc.setDialogTitle("Add Files");
            fc.setAcceptAllFileFilterUsed(false);
            fc.setFileFilter (new FileNameExtensionFilter ("MP3 File (.mp3)","mp3"));
            fc.setApproveButtonText ("Add Files");
            int show = fc.showOpenDialog(this);
            if (show == JFileChooser.APPROVE_OPTION) {
                File[] files = fc.getSelectedFiles();
                addFiles (files);
        }
    }//GEN-LAST:event_addFileActionPerformed

    private void addFolderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addFolderActionPerformed
        JFileChooser fc = new JFileChooser();
        fc.setDialogType(JFileChooser.DIRECTORIES_ONLY);
        fc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        fc.setDialogTitle("Add Folder");
        fc.setApproveButtonText("Add Folder");
        int show = fc.showOpenDialog(this);
        if(show == JFileChooser.APPROVE_OPTION){
            File file = fc.getSelectedFile();
            addFolder(file);
        }
    }//GEN-LAST:event_addFolderActionPerformed

    private void clearplaylistActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearplaylistActionPerformed
        koleksi.clear();
    }//GEN-LAST:event_clearplaylistActionPerformed

    private void tb1PlaylistMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tb1PlaylistMouseClicked
        int i = tb1Playlist.getSelectedRow();
        if (evt.getClickCount() == 2 && i != -1) {
            Musik m = koleksi.get(i);
            JOptionPane.showMessageDialog(this,
            "<html>"
            + "<head>"
            + "<style>"
            + "table {border-collapse: collaspse; border 1px solid blue; }"
            + "tr { border-bottom:1pt solid black; }"
            +"</style>"
            +"</head>"
            +"<body>"
            +"<h3>Detail Musik:<h3>"
            +"<table border='1'>"
            +"<tr><td>Lokasi</td><td>:</td><td>" + m.getPath() + "</td></tr>"
            +"<tr><td>Nama File</td><td>:</td><td>" + m.getFileName() + "</td></tr>"
            +"<tr><td>Ukuran</td><td>:</td><td>" + m.getFileSize() + "</td></tr>"
            +"<tr><td>Ekstensi</td><td>:</td><td>" + m.getExtension() + "</td></tr>"
            +"</table>"
            +"</body>"
            +"</html>");
  
    
    }//GEN-LAST:event_tb1PlaylistMouseClicked

    
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Playlist.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Playlist.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Playlist.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Playlist.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Playlist().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem addFile;
    private javax.swing.JMenuItem addFolder;
    private java.awt.Button btnplaylist;
    private javax.swing.JMenuItem clearplaylist;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel pnFooter;
    public javax.swing.JPopupMenu popuptombol;
    private javax.swing.JTable tb1Playlist;
    // End of variables declaration//GEN-END:variables
}
