package view;

import connectionDB.koneksi;
import java.awt.Color;
import java.awt.event.KeyEvent;
import java.io.File;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;

public class mainmenu extends javax.swing.JFrame {
    
    private Connection conn = new koneksi().connect();
    private DefaultTableModel tabmode;
    private DefaultTableModel tabmode1;
    private DefaultTableModel tabmode2;
    private DefaultTableModel tabmode3;
    private DefaultTableModel tabmode4;
    private DefaultTableModel tabmode5;
    private DefaultTableModel tabmode6;
    
    public void tanggal(){
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        Date currentDate = new Date();
        tgl.setText(dateFormat.format(currentDate));
    }
    
    private void autoNumber1(){
        try{
            String sql = "select max(right(id,3)) as no from tbpendaftaran";
            java.sql.Statement stat = conn.createStatement();
            ResultSet rs = stat.executeQuery(sql);
            while (rs.next()){
                if(rs.first() == false){
                    tidpendaftaran.setText("PD001");
                }else{
                    rs.last();
                    int set_id = rs.getInt(1)+1;
                    String no = String.valueOf(set_id);
                    int id_next = no.length();
                    for (int a = 0; a <3 - id_next; a++){
                        no = "0" + no;
                    }
                    tidpendaftaran.setText("PD" + no);
                }
            }
        }catch (SQLException ex){
            Logger.getLogger(mainmenu.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void autoNumber2(){
        try{
            String sql = "select max(right(id,3)) as no from tbdataanak";
            java.sql.Statement stat = conn.createStatement();
            ResultSet rs = stat.executeQuery(sql);
            while (rs.next()){
                if(rs.first() == false){
                    tidanak.setText("DA001");
                }else{
                    rs.last();
                    int set_id = rs.getInt(1)+1;
                    String no = String.valueOf(set_id);
                    int id_next = no.length();
                    for (int a = 0; a <3 - id_next; a++){
                        no = "0" + no;
                    }
                    tidanak.setText("DA" + no);
                }
            }
        }catch (SQLException ex){
            Logger.getLogger(mainmenu.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void autoNumber3(){
        try{
            String sql = "select max(right(id,3)) as no from tbkunjungan";
            java.sql.Statement stat = conn.createStatement();
            ResultSet rs = stat.executeQuery(sql);
            while (rs.next()){
                if(rs.first() == false){
                    tidkunjungan.setText("KJ001");
                }else{
                    rs.last();
                    int set_id = rs.getInt(1)+1;
                    String no = String.valueOf(set_id);
                    int id_next = no.length();
                    for (int a = 0; a <3 - id_next; a++){
                        no = "0" + no;
                    }
                    tidkunjungan.setText("KJ" + no);
                }
            }
        }catch (SQLException ex){
            Logger.getLogger(mainmenu.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void autoNumber4(){
        try{
            String sql = "select max(right(id,3)) as no from tbkondisi";
            java.sql.Statement stat = conn.createStatement();
            ResultSet rs = stat.executeQuery(sql);
            while (rs.next()){
                if(rs.first() == false){
                    tidkondisi.setText("KA001");
                }else{
                    rs.last();
                    int set_id = rs.getInt(1)+1;
                    String no = String.valueOf(set_id);
                    int id_next = no.length();
                    for (int a = 0; a <3 - id_next; a++){
                        no = "0" + no;
                    }
                    tidkondisi.setText("KA" + no);
                }
            }
        }catch (SQLException ex){
            Logger.getLogger(mainmenu.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void autoNumber6(){
        try{
            String sql = "select max(right(id,3)) as no from tbjadwal";
            java.sql.Statement stat = conn.createStatement();
            ResultSet rs = stat.executeQuery(sql);
            while (rs.next()){
                if(rs.first() == false){
                    tidjadwal.setText("JD001");
                }else{
                    rs.last();
                    int set_id = rs.getInt(1)+1;
                    String no = String.valueOf(set_id);
                    int id_next = no.length();
                    for (int a = 0; a <3 - id_next; a++){
                        no = "0" + no;
                    }
                    tidjadwal.setText("JD" + no);
                }
            }
        }catch (SQLException ex){
            Logger.getLogger(mainmenu.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void autoNumber7(){
        try{
            String sql = "select max(right(id,3)) as no from tbbidan";
            java.sql.Statement stat = conn.createStatement();
            ResultSet rs = stat.executeQuery(sql);
            while (rs.next()){
                if(rs.first() == false){
                    tidbidan.setText("BD001");
                }else{
                    rs.last();
                    int set_id = rs.getInt(1)+1;
                    String no = String.valueOf(set_id);
                    int id_next = no.length();
                    for (int a = 0; a <3 - id_next; a++){
                        no = "0" + no;
                    }
                    tidbidan.setText("BD" + no);
                }
            }
        }catch (SQLException ex){
            Logger.getLogger(mainmenu.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void tanggal_lahir_anak() {
        try {
            String sql = "Select * from tbdataanak where id='"+tidanak.getText()+"'";
            java.sql.Statement stat = conn.createStatement();
            ResultSet hasil = stat.executeQuery(sql);
            while (hasil.next()){
                tgllahiranak.setDate(hasil.getDate("tanggallahir"));
            }
        }catch (SQLException ex){}
    }
    
    protected void kosong1(){
        tnikanakpendaftaran.setText("");
        tnamaanak.setText("");
        tusiaanak.setText("");
        tnamaorangtua.setText("");
        tnohp.setText("");
        talamat.setText("");
        cbjeniskb.setSelectedIndex(0);
        cbimunisasi.setSelectedIndex(0);
        cbvitamin.setSelectedIndex(0);
        tcaripendaftaran.setText("");
    }
    
    protected void kosong2(){
        tnama.setText("");
        tnik.setText("");
        tgllahiranak.setDate(null);
        cbgolongandarah.setSelectedIndex(0);
        rj1.setSelected(false);
        rj2.setSelected(false);
        tberatlahir.setText("");
        ttinggilahir.setText("");
        
        tcaridataanak.setText("");
    }
    
    protected void kosong3(){
        tglkunjungan.setDate(null);
        tcarikunjungan.setText("");
        tnamaorangtuakunjungan.setText("");
        trt.setText("");
    }
    
    protected void kosong4(){
        tnamaanak.setText("");
        tlingkar.setText("");
        tlengan.setText("");
        tusia.setText("");
        tberat.setText("");
        ttinggi.setText("");
        tkondisi.setText("");
        tcarikondisi.setText("");
    }
    
    protected void kosong6(){
        tnikjadwal.setText("");
        jdwl.setDate(null);
        twaktu.setText("");
    }
    
    protected void kosong7(){
        tnikbidan.setText("");
        tnamabidan.setText("");
        talamatbidan.setText("");
        tnohpbidan.setText("");
    }
    
    protected void datatable1(){
    Object [] Baris = {"TANGGAL","ID PENDAFTARAN","NIK ANAK","NAMA ANAK","USIA ANAK","IMUNISASI","VITAMIN","NAMA ORANG TUA","NO HP","ALAMAT","JENIS KB"};
    tabmode = new DefaultTableModel(null, Baris);
    tabelpendaftaran.setModel(tabmode);
    try {  
        String sql = "Select DATE_FORMAT(tgl, '%d-%m-%Y') AS myDate,id,nik_anak,nama_anak,usia,imunisasi,vitamin,nama_orangtua,nohp,alamat,jenis_kb  from tbpendaftaran";
    
        java.sql.Statement stat = conn.createStatement();
        ResultSet hasil = stat.executeQuery(sql);
        while (hasil.next()){
            String a = hasil.getString("myDate");
            String b = hasil.getString("id");
            String c = hasil.getString("nik_anak");
            String d = hasil.getString("nama_anak");
            String e = hasil.getString("usia");
            String f = hasil.getString("imunisasi");
            String g = hasil.getString("vitamin");
            String h = hasil.getString("nama_orangtua");
            String i = hasil.getString("nohp");
            String j = hasil.getString("alamat");
            String k = hasil.getString("jenis_kb");
            
            String[] data={a,b,c,d,e,f,g,h,i,j,k};
            tabmode.addRow(data);
        }
    }catch (Exception e){
        }
    }
    
    protected void datatable2(){
    Object [] Baris = {"ID ANAK","NAMA ANAK","NIK","TANGGAL LAHIR","GOLONGAN DARAH","JENIS KELAMIN","BERAT BADAN LAHIR","TINGGI BADAN LAHIR"};
    tabmode1 = new DefaultTableModel(null, Baris);
    tabeldataanak.setModel(tabmode1);
    try {  
        String sql = "Select id, nama_anak, nik, DATE_FORMAT(tanggallahir, '%d-%m-%Y') AS myDate, golongandarah, kelamin, berat, tinggi from tbdataanak";
    
        java.sql.Statement stat = conn.createStatement();
        ResultSet hasil = stat.executeQuery(sql);
        while (hasil.next()){
            String a = hasil.getString("id");
            String b = hasil.getString("nama_anak");
            String c = hasil.getString("nik");
            String d = hasil.getString("myDate");
            String e = hasil.getString("golongandarah");
            String f = hasil.getString("kelamin");
            String g = hasil.getString("berat");
            String h = hasil.getString("tinggi");
            
            String[] data={a,b,c,d,e,f,g,h};
            tabmode1.addRow(data);
        }
    }catch (Exception e){
        }
    }
    
    protected void datatable3(){
    Object [] Baris = {"TANGGAL KUNJUNGAN","ID KUNJUNGAN","NAMA ANAK","NAMA ORANG TUA/WALI","RT"};
    tabmode2 = new DefaultTableModel(null, Baris);
    tabelkunjungan.setModel(tabmode2);
    try {  
        String sql = "Select DATE_FORMAT(tgl, '%d-%m-%Y') AS myDate, id, nama_anak, nama_orangtua, rt from tbkunjungan";
    
        java.sql.Statement stat = conn.createStatement();
        ResultSet hasil = stat.executeQuery(sql);
        while (hasil.next()){
            String a = hasil.getString("myDate");
            String b = hasil.getString("id");
            String c = hasil.getString("nama_anak");
            String d = hasil.getString("nama_orangtua");
            String e = hasil.getString("rt");
            
            String[] data={a,b,c,d,e};
            tabmode2.addRow(data);
        }
    }catch (Exception e){
        }
    }
    
    protected void datatable4(){
    Object [] Baris = {"ID PEMERIKSAAN","ID KUNJUNGAN","NAMA ANAK","BIDAN","USIA ANAK","LK","LL","BB","TB","KONDISI"};
    tabmode3 = new DefaultTableModel(null, Baris);
    tabelkondisi.setModel(tabmode3);
    String cari = tcarikondisi.getText();
    try {  
        String sql = "SELECT * FROM tbkondisi " +
             "WHERE id LIKE '%" + cari + "%' " +
             "OR idkunjungan LIKE '%" + cari + "%' " +
             "OR nama_anak LIKE '%" + cari + "%' " +
             "OR nama_bidan LIKE '%" + cari + "%' " +
             "OR usia LIKE '%" + cari + "%' " +
             "OR lingkarkepala LIKE '%" + cari + "%' " +
             "OR lingkarlengan LIKE '%" + cari + "%' " +
             "OR berat LIKE '%" + cari + "%' " +
             "OR tinggi LIKE '%" + cari + "%' " +
             "OR kondisi LIKE '%" + cari + "%' " +
             "ORDER BY id";
    
        java.sql.Statement stat = conn.createStatement();
        ResultSet hasil = stat.executeQuery(sql);
        while (hasil.next()){
            String a = hasil.getString("id");
            String b = hasil.getString("idkunjungan");
            String c = hasil.getString("nama_anak");
            String d = hasil.getString("nama_bidan");
            String e = hasil.getString("usia");
            String f = hasil.getString("lingkarkepala");
            String g = hasil.getString("lingkarlengan");
            String h = hasil.getString("berat");
            String i = hasil.getString("tinggi");
            String j = hasil.getString("kondisi");
            
            String[] data={a,b,c,d,e,f,g,h,i,j};
            tabmode3.addRow(data);
        }
    }catch (Exception e){
        }
    }
    
    protected void datatable6(){
    Object [] Baris = {"ID","NAMA BIDAN","KODE BIDAN","HARI/TANGGAL","WAKTU"};
    tabmode5 = new DefaultTableModel(null, Baris);
    tabeljadwal.setModel(tabmode5);
    try {  
        String sql = "Select * from tbjadwal";
    
        java.sql.Statement stat = conn.createStatement();
        ResultSet hasil = stat.executeQuery(sql);
        while (hasil.next()){
            String a = hasil.getString("id");
            String b = hasil.getString("bidan");
            String c = hasil.getString("nik_bidan");
            String d = hasil.getString("tanggal");
            String e = hasil.getString("waktu");
            
            String[] data={a,b,c,d,e};
            tabmode5.addRow(data);
        }
    }catch (Exception e){
        }
    }
    
    protected void datatable7(){
    Object [] Baris = {"ID","KODE BIDAN","NAMA","ALAMAT","NO HP"};
    tabmode6 = new DefaultTableModel(null, Baris);
    tabelbidan.setModel(tabmode6);
    try {  
        String sql = "Select * from tbbidan";
    
        java.sql.Statement stat = conn.createStatement();
        ResultSet hasil = stat.executeQuery(sql);
        while (hasil.next()){
            String a = hasil.getString("id");
            String b = hasil.getString("nik_bidan");
            String c = hasil.getString("nama_bidan");
            String d = hasil.getString("alamat");
            String e = hasil.getString("telp");
            
            String[] data={a,b,c,d,e};
            tabmode6.addRow(data);
        }
    }catch (Exception e){
        }
    }
    
    public void idkunjungan(){
        try{
            cbidkunjungan.removeAllItems();
            String sqlf = "select * from tbkunjungan";
            java.sql.Statement stat = conn.createStatement();
            ResultSet hasil = stat.executeQuery(sqlf);
            while(hasil.next()){
                cbidkunjungan.addItem(hasil.getString("id"));
            }
            hasil.last();
            int jumlahdata = hasil.getRow();
            hasil.first();
        }catch(Exception e){
        }
    }
    
    public void cbidkunjungan(){
        try{
            String sql = "select * from tbkunjungan where id = '"+cbidkunjungan.getSelectedItem().toString()+"'";
            java.sql.Statement stat = conn.createStatement();
            ResultSet hasil = stat.executeQuery(sql);
            while(hasil.next()){
                String nama = hasil.getString("nama_anak");
                tnamaanakkondisi.setText(nama);
            }
        } catch (Exception e) {}
    }
    
    public void nikbidan(){
        try{
            cbnamabidanjadwal.removeAllItems();
            String sqlf = "select * from tbbidan";
            java.sql.Statement stat = conn.createStatement();
            ResultSet hasil = stat.executeQuery(sqlf);
            while(hasil.next()){
                cbnamabidanjadwal.addItem(hasil.getString("nama_bidan"));
            }
            hasil.last();
            int jumlahdata = hasil.getRow();
            hasil.first();
        }catch(Exception e){
        }
    }
    
    public void cbnamabidan(){
        try{
            String sql = "select * from tbbidan where nama_bidan = '"+cbnamabidanjadwal.getSelectedItem().toString()+"'";
            java.sql.Statement stat = conn.createStatement();
            ResultSet hasil = stat.executeQuery(sql);
            while(hasil.next()){
                String nik = hasil.getString("nik_bidan");
                tnikjadwal.setText(nik);
            }
        } catch (Exception e) {}
    }
    
    public void namaanakkunjungan(){
        try{
            cbnamaanakkunjungan.removeAllItems();
            String sqlf = "select * from tbdataanak";
            java.sql.Statement stat = conn.createStatement();
            ResultSet hasil = stat.executeQuery(sqlf);
            while(hasil.next()){
                cbnamaanakkunjungan.addItem(hasil.getString("nama_anak"));
            }
            hasil.last();
            int jumlahdata = hasil.getRow();
            hasil.first();
        }catch(Exception e){
        }
    }
    
    public void bidanbertugas(){
        try{
            cbbidantugas.removeAllItems();
            String sqlf = "select * from tbbidan";
            java.sql.Statement stat = conn.createStatement();
            ResultSet hasil = stat.executeQuery(sqlf);
            while(hasil.next()){
                cbbidantugas.addItem(hasil.getString("nama_bidan"));
            }
            hasil.last();
            int jumlahdata = hasil.getRow();
            hasil.first();
        }catch(Exception e){
        }
    }
    
    public mainmenu() {
        initComponents();
        tanggal();
        cbidkunjungan();
        cbnamabidan();
//        namaAnak(); //optional 
        autoNumber1();
        autoNumber2();
        autoNumber3();
        autoNumber4();
        autoNumber6();
        autoNumber7();
        datatable1();
        datatable2();
        datatable3();
        datatable4();
        datatable6();
        datatable7();
        tidpendaftaran.setEnabled(false);
        tidanak.setEnabled(false);
        tidkunjungan.setEnabled(false);
        tidkondisi.setEnabled(false);
        tidjadwal.setEnabled(false);
        tidbidan.setEnabled(false);
        tnikjadwal.setEnabled(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelutama = new javax.swing.JPanel();
        panelheader = new javax.swing.JPanel();
        logo = new javax.swing.JLabel();
        judul1 = new javax.swing.JLabel();
        judul2 = new javax.swing.JLabel();
        panelmenu = new javax.swing.JPanel();
        bjadwal = new javax.swing.JButton();
        bdasboard = new javax.swing.JButton();
        bpendaftaran = new javax.swing.JButton();
        bdataanak = new javax.swing.JButton();
        bkunjungan = new javax.swing.JButton();
        bkondisi = new javax.swing.JButton();
        bkeluar = new javax.swing.JButton();
        paneltanggal = new javax.swing.JPanel();
        tgl = new javax.swing.JLabel();
        bbidan = new javax.swing.JButton();
        panelmain = new javax.swing.JPanel();
        paneldasboard = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        panelpendaftaran = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelpendaftaran = new javax.swing.JTable();
        labelid = new javax.swing.JLabel();
        tidpendaftaran = new javax.swing.JTextField();
        tnamaanak = new javax.swing.JTextField();
        labelnama = new javax.swing.JLabel();
        labelu = new javax.swing.JLabel();
        tnamaorangtua = new javax.swing.JTextField();
        labelgih = new javax.swing.JLabel();
        tnohp = new javax.swing.JTextField();
        bsimpan = new javax.swing.JButton();
        bubah = new javax.swing.JButton();
        bhapus = new javax.swing.JButton();
        bbersih = new javax.swing.JButton();
        tcaripendaftaran = new javax.swing.JTextField();
        bcaripendaftaran = new javax.swing.JButton();
        bcetak1 = new javax.swing.JButton();
        labelnama8 = new javax.swing.JLabel();
        cbjeniskb = new javax.swing.JComboBox<>();
        labelnama4 = new javax.swing.JLabel();
        tnikanakpendaftaran = new javax.swing.JTextField();
        labelu6 = new javax.swing.JLabel();
        tusiaanak = new javax.swing.JTextField();
        labelu7 = new javax.swing.JLabel();
        labelnama9 = new javax.swing.JLabel();
        cbimunisasi = new javax.swing.JComboBox<>();
        cbvitamin = new javax.swing.JComboBox<>();
        labelnama10 = new javax.swing.JLabel();
        labelgih6 = new javax.swing.JLabel();
        talamat = new javax.swing.JTextField();
        paneldataanak = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        labelid1 = new javax.swing.JLabel();
        tidanak = new javax.swing.JTextField();
        labelnama1 = new javax.swing.JLabel();
        labelu1 = new javax.swing.JLabel();
        tnik = new javax.swing.JTextField();
        labelaja1 = new javax.swing.JLabel();
        labelgih1 = new javax.swing.JLabel();
        bsimpan1 = new javax.swing.JButton();
        bubah1 = new javax.swing.JButton();
        bhapus1 = new javax.swing.JButton();
        bbersih1 = new javax.swing.JButton();
        tcaridataanak = new javax.swing.JTextField();
        bcaridataanak = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tabeldataanak = new javax.swing.JTable();
        tgllahiranak = new com.toedter.calendar.JDateChooser();
        labeljk = new javax.swing.JLabel();
        labelee = new javax.swing.JLabel();
        labelu2 = new javax.swing.JLabel();
        rj1 = new javax.swing.JRadioButton();
        rj2 = new javax.swing.JRadioButton();
        tberatlahir = new javax.swing.JTextField();
        ttinggilahir = new javax.swing.JTextField();
        labelgih2 = new javax.swing.JLabel();
        labelgih3 = new javax.swing.JLabel();
        cbgolongandarah = new javax.swing.JComboBox<>();
        bcetak2 = new javax.swing.JButton();
        tnama = new javax.swing.JTextField();
        panelkunjungan = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        labelnama2 = new javax.swing.JLabel();
        labelaja2 = new javax.swing.JLabel();
        tglkunjungan = new com.toedter.calendar.JDateChooser();
        cbnamaanakkunjungan = new javax.swing.JComboBox<>();
        tidkunjungan = new javax.swing.JTextField();
        labelid2 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tabelkunjungan = new javax.swing.JTable();
        bsimpan2 = new javax.swing.JButton();
        bubah2 = new javax.swing.JButton();
        bhapus2 = new javax.swing.JButton();
        bbersih2 = new javax.swing.JButton();
        tcarikunjungan = new javax.swing.JTextField();
        bcarikunjungan = new javax.swing.JButton();
        labelnama5 = new javax.swing.JLabel();
        tnamaorangtuakunjungan = new javax.swing.JTextField();
        trt = new javax.swing.JTextField();
        labelnama7 = new javax.swing.JLabel();
        bcetak3 = new javax.swing.JButton();
        panelkondisi = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jLabel15 = new javax.swing.JLabel();
        tidkondisi = new javax.swing.JTextField();
        tusia = new javax.swing.JTextField();
        tberat = new javax.swing.JTextField();
        ttinggi = new javax.swing.JTextField();
        labelgih4 = new javax.swing.JLabel();
        labelu3 = new javax.swing.JLabel();
        labelnama3 = new javax.swing.JLabel();
        labelid3 = new javax.swing.JLabel();
        labelee1 = new javax.swing.JLabel();
        labelu4 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        tabelkondisi = new javax.swing.JTable();
        bsimpan3 = new javax.swing.JButton();
        bubah3 = new javax.swing.JButton();
        bhapus3 = new javax.swing.JButton();
        bbersih3 = new javax.swing.JButton();
        tcarikondisi = new javax.swing.JTextField();
        bcarikondisi = new javax.swing.JButton();
        labelee2 = new javax.swing.JLabel();
        labelu5 = new javax.swing.JLabel();
        labelgih5 = new javax.swing.JLabel();
        bcetak4 = new javax.swing.JButton();
        labelnama6 = new javax.swing.JLabel();
        cbidkunjungan = new javax.swing.JComboBox<>();
        tnamaanakkondisi = new javax.swing.JTextField();
        labelee3 = new javax.swing.JLabel();
        tlingkar = new javax.swing.JTextField();
        labelee4 = new javax.swing.JLabel();
        labelee5 = new javax.swing.JLabel();
        tlengan = new javax.swing.JTextField();
        labelee6 = new javax.swing.JLabel();
        labelnama11 = new javax.swing.JLabel();
        jScrollPane5 = new javax.swing.JScrollPane();
        tkondisi = new javax.swing.JTextArea();
        cbbidantugas = new javax.swing.JComboBox<>();
        paneljadwal = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        jLabel17 = new javax.swing.JLabel();
        labelid7 = new javax.swing.JLabel();
        jScrollPane7 = new javax.swing.JScrollPane();
        tabeljadwal = new javax.swing.JTable();
        bsimpan5 = new javax.swing.JButton();
        bubah5 = new javax.swing.JButton();
        bhapus5 = new javax.swing.JButton();
        bbersih5 = new javax.swing.JButton();
        labelu9 = new javax.swing.JLabel();
        jdwl = new com.toedter.calendar.JDateChooser();
        twaktu = new javax.swing.JTextField();
        tidjadwal = new javax.swing.JTextField();
        labelu10 = new javax.swing.JLabel();
        bcetak6 = new javax.swing.JButton();
        labelid8 = new javax.swing.JLabel();
        tnikjadwal = new javax.swing.JTextField();
        labelu11 = new javax.swing.JLabel();
        cbnamabidanjadwal = new javax.swing.JComboBox<>();
        panelbidan = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        jLabel18 = new javax.swing.JLabel();
        labelu12 = new javax.swing.JLabel();
        tidbidan = new javax.swing.JTextField();
        labelu13 = new javax.swing.JLabel();
        tnamabidan = new javax.swing.JTextField();
        labelu14 = new javax.swing.JLabel();
        talamatbidan = new javax.swing.JTextField();
        jScrollPane8 = new javax.swing.JScrollPane();
        tabelbidan = new javax.swing.JTable();
        bsimpan6 = new javax.swing.JButton();
        bubah6 = new javax.swing.JButton();
        bhapus6 = new javax.swing.JButton();
        bbersih6 = new javax.swing.JButton();
        labelu15 = new javax.swing.JLabel();
        tnohpbidan = new javax.swing.JTextField();
        bcetak7 = new javax.swing.JButton();
        tnikbidan = new javax.swing.JTextField();
        labelu16 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                formMouseDragged(evt);
            }
        });
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                formMousePressed(evt);
            }
        });

        panelutama.setBackground(new java.awt.Color(148, 123, 192));

        panelheader.setBackground(new java.awt.Color(148, 123, 192));

        logo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar2/logohanna-removebg-preview.png"))); // NOI18N

        judul1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        judul1.setForeground(new java.awt.Color(255, 255, 255));
        judul1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        judul1.setText("POSYANDU ANYELIR");

        judul2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        judul2.setForeground(new java.awt.Color(255, 255, 255));
        judul2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        judul2.setText("SEKRETARIAT : JL. DANAU TEMPE RAYA RW 06 KELURAHAN ABADIJAYA KECAMATAN SUKMAJAYA");

        javax.swing.GroupLayout panelheaderLayout = new javax.swing.GroupLayout(panelheader);
        panelheader.setLayout(panelheaderLayout);
        panelheaderLayout.setHorizontalGroup(
            panelheaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelheaderLayout.createSequentialGroup()
                .addGap(63, 63, 63)
                .addComponent(logo, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addGroup(panelheaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(judul1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(judul2, javax.swing.GroupLayout.DEFAULT_SIZE, 728, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelheaderLayout.setVerticalGroup(
            panelheaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelheaderLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelheaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelheaderLayout.createSequentialGroup()
                        .addGap(11, 11, 11)
                        .addComponent(judul1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(judul2, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(logo, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        panelmenu.setBackground(new java.awt.Color(255, 153, 153));
        panelmenu.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(255, 153, 153), new java.awt.Color(255, 153, 153), new java.awt.Color(255, 153, 153), new java.awt.Color(255, 153, 153)));

        bjadwal.setBackground(new java.awt.Color(148, 123, 192));
        bjadwal.setText("DATA JADWAL");
        bjadwal.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                bjadwalMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                bjadwalMouseExited(evt);
            }
        });
        bjadwal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bjadwalActionPerformed(evt);
            }
        });

        bdasboard.setBackground(new java.awt.Color(148, 123, 192));
        bdasboard.setText("DASHBOARD");
        bdasboard.setBorder(null);
        bdasboard.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                bdasboardMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                bdasboardMouseExited(evt);
            }
        });
        bdasboard.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bdasboardActionPerformed(evt);
            }
        });

        bpendaftaran.setBackground(new java.awt.Color(148, 123, 192));
        bpendaftaran.setText("PENDAFATARAN LAYANAN");
        bpendaftaran.setBorder(null);
        bpendaftaran.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                bpendaftaranMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                bpendaftaranMouseExited(evt);
            }
        });
        bpendaftaran.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bpendaftaranActionPerformed(evt);
            }
        });

        bdataanak.setBackground(new java.awt.Color(148, 123, 192));
        bdataanak.setText("DATA ANAK");
        bdataanak.setBorder(null);
        bdataanak.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                bdataanakMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                bdataanakMouseExited(evt);
            }
        });
        bdataanak.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bdataanakActionPerformed(evt);
            }
        });

        bkunjungan.setBackground(new java.awt.Color(148, 123, 192));
        bkunjungan.setText("KUNJUNGAN");
        bkunjungan.setBorder(null);
        bkunjungan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                bkunjunganMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                bkunjunganMouseExited(evt);
            }
        });
        bkunjungan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bkunjunganActionPerformed(evt);
            }
        });

        bkondisi.setBackground(new java.awt.Color(148, 123, 192));
        bkondisi.setText("HASIL PEMERIKSAAN");
        bkondisi.setBorder(null);
        bkondisi.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                bkondisiMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                bkondisiMouseExited(evt);
            }
        });
        bkondisi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bkondisiActionPerformed(evt);
            }
        });

        bkeluar.setBackground(new java.awt.Color(148, 123, 192));
        bkeluar.setText("KELUAR");
        bkeluar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                bkeluarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                bkeluarMouseExited(evt);
            }
        });
        bkeluar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bkeluarActionPerformed(evt);
            }
        });

        paneltanggal.setBackground(new java.awt.Color(255, 0, 0));

        tgl.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        tgl.setForeground(new java.awt.Color(255, 255, 255));
        tgl.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        tgl.setText("TANGGAL SEKARANG");

        javax.swing.GroupLayout paneltanggalLayout = new javax.swing.GroupLayout(paneltanggal);
        paneltanggal.setLayout(paneltanggalLayout);
        paneltanggalLayout.setHorizontalGroup(
            paneltanggalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(tgl, javax.swing.GroupLayout.DEFAULT_SIZE, 153, Short.MAX_VALUE)
        );
        paneltanggalLayout.setVerticalGroup(
            paneltanggalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(tgl, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
        );

        bbidan.setBackground(new java.awt.Color(148, 123, 192));
        bbidan.setText("DATA BIDAN");
        bbidan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                bbidanMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                bbidanMouseExited(evt);
            }
        });
        bbidan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bbidanActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelmenuLayout = new javax.swing.GroupLayout(panelmenu);
        panelmenu.setLayout(panelmenuLayout);
        panelmenuLayout.setHorizontalGroup(
            panelmenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelmenuLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(paneltanggal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24))
            .addGroup(panelmenuLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelmenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelmenuLayout.createSequentialGroup()
                        .addGroup(panelmenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(bkondisi, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(bkunjungan, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(bpendaftaran, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelmenuLayout.createSequentialGroup()
                        .addGap(0, 45, Short.MAX_VALUE)
                        .addComponent(bkeluar, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(53, 53, 53))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelmenuLayout.createSequentialGroup()
                        .addGroup(panelmenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(bjadwal, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(bdataanak, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(bdasboard, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(bbidan, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addContainerGap())))
        );
        panelmenuLayout.setVerticalGroup(
            panelmenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelmenuLayout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(paneltanggal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addComponent(bdasboard, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(bdataanak, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(bbidan, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(bjadwal, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(42, 42, 42)
                .addComponent(bpendaftaran, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(bkunjungan, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(bkondisi, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(44, 44, 44)
                .addComponent(bkeluar)
                .addGap(19, 19, 19))
        );

        panelmain.setBackground(new java.awt.Color(102, 255, 204));
        panelmain.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(255, 153, 153), new java.awt.Color(255, 153, 153), new java.awt.Color(255, 153, 153), new java.awt.Color(255, 153, 153)));
        panelmain.setLayout(new java.awt.CardLayout());

        paneldasboard.setBackground(new java.awt.Color(255, 153, 153));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel12.setText("DASHBOARD");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel12, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 171, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel12, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
        );

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Selamat Datang di Dashboard Posyandu!");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel3.setText("<html><p style=\"text-align:justify;\">Inilah pusat informasi terkini yang menyajikan data kesehatan masyarakat.\nDashboard ini tidak hanya mencerminkan komitmen kami terhadap kesejahteraan,\ntetapi juga dirancang untuk memudahkan pencarian dan akses data yang Anda\nbutuhkan. Dengan adanya dashboard ini, data-data kesehatan masyarakat akan\ntersimpan rapih dan lebih efektif, memungkinkan kita untuk membuat keputusan\nyang lebih tepat dan memajukan layanan kesehatan. Mari bersama-sama \nmenjelajahi informasi yang bermanfaat, membangun masyarakat yang sehat, dan\nmeningkatkan kualitas hidup. Terima kasih atas partisipasi Anda dalam membentuk\nmasa depan kesehatan bersama Posyandu!\n");

        javax.swing.GroupLayout paneldasboardLayout = new javax.swing.GroupLayout(paneldasboard);
        paneldasboard.setLayout(paneldasboardLayout);
        paneldasboardLayout.setHorizontalGroup(
            paneldasboardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(paneldasboardLayout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 650, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, paneldasboardLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(paneldasboardLayout.createSequentialGroup()
                .addGap(124, 124, 124)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 572, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        paneldasboardLayout.setVerticalGroup(
            paneldasboardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(paneldasboardLayout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(53, 53, 53)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 234, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(97, Short.MAX_VALUE))
        );

        panelmain.add(paneldasboard, "card2");

        panelpendaftaran.setBackground(new java.awt.Color(255, 153, 153));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel11.setText("PENDAFTARAN LAYANAN");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel11, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 224, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
        );

        tabelpendaftaran.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        tabelpendaftaran.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4", "Title 5", "Title 6"
            }
        ));
        tabelpendaftaran.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        tabelpendaftaran.setRowHeight(24);
        tabelpendaftaran.setRowMargin(2);
        tabelpendaftaran.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelpendaftaranMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabelpendaftaran);

        labelid.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        labelid.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        labelid.setText("ID PENDAFTARAN");
        labelid.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        tidpendaftaran.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        tidpendaftaran.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tidpendaftaranActionPerformed(evt);
            }
        });

        tnamaanak.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        tnamaanak.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tnamaanakActionPerformed(evt);
            }
        });

        labelnama.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        labelnama.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        labelnama.setText("NAMA ANAK");
        labelnama.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        labelu.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        labelu.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        labelu.setText("NAMA ORANG TUA");
        labelu.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        tnamaorangtua.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        tnamaorangtua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tnamaorangtuaActionPerformed(evt);
            }
        });

        labelgih.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        labelgih.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        labelgih.setText("NO HP");
        labelgih.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        tnohp.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        tnohp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tnohpActionPerformed(evt);
            }
        });
        tnohp.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tnohpKeyTyped(evt);
            }
        });

        bsimpan.setBackground(new java.awt.Color(204, 204, 204));
        bsimpan.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        bsimpan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar2/save-30-w11.png"))); // NOI18N
        bsimpan.setText("SIMPAN");
        bsimpan.setContentAreaFilled(false);
        bsimpan.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        bsimpan.setOpaque(true);
        bsimpan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                bsimpanMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                bsimpanMouseExited(evt);
            }
        });
        bsimpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bsimpanActionPerformed(evt);
            }
        });

        bubah.setBackground(new java.awt.Color(204, 204, 204));
        bubah.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        bubah.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar2/edit-30-w11.png"))); // NOI18N
        bubah.setText("UBAH");
        bubah.setContentAreaFilled(false);
        bubah.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        bubah.setOpaque(true);
        bubah.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                bubahMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                bubahMouseExited(evt);
            }
        });
        bubah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bubahActionPerformed(evt);
            }
        });

        bhapus.setBackground(new java.awt.Color(204, 204, 204));
        bhapus.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        bhapus.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar2/delete-30-w11.png"))); // NOI18N
        bhapus.setText("HAPUS");
        bhapus.setContentAreaFilled(false);
        bhapus.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        bhapus.setOpaque(true);
        bhapus.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                bhapusMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                bhapusMouseExited(evt);
            }
        });
        bhapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bhapusActionPerformed(evt);
            }
        });

        bbersih.setBackground(new java.awt.Color(204, 204, 204));
        bbersih.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        bbersih.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar2/icons8-refresh-30.png"))); // NOI18N
        bbersih.setContentAreaFilled(false);
        bbersih.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        bbersih.setOpaque(true);
        bbersih.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                bbersihMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                bbersihMouseExited(evt);
            }
        });
        bbersih.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bbersihActionPerformed(evt);
            }
        });

        tcaripendaftaran.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        tcaripendaftaran.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tcaripendaftaranActionPerformed(evt);
            }
        });

        bcaripendaftaran.setBackground(new java.awt.Color(204, 204, 204));
        bcaripendaftaran.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        bcaripendaftaran.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar2/icons8-search-24.png"))); // NOI18N
        bcaripendaftaran.setText("CARI");
        bcaripendaftaran.setContentAreaFilled(false);
        bcaripendaftaran.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        bcaripendaftaran.setOpaque(true);
        bcaripendaftaran.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                bcaripendaftaranMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                bcaripendaftaranMouseExited(evt);
            }
        });
        bcaripendaftaran.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bcaripendaftaranActionPerformed(evt);
            }
        });

        bcetak1.setBackground(new java.awt.Color(204, 204, 204));
        bcetak1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        bcetak1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar2/hasil-transformed.png"))); // NOI18N
        bcetak1.setText("CETAK");
        bcetak1.setContentAreaFilled(false);
        bcetak1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        bcetak1.setOpaque(true);
        bcetak1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                bcetak1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                bcetak1MouseExited(evt);
            }
        });
        bcetak1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bcetak1ActionPerformed(evt);
            }
        });

        labelnama8.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        labelnama8.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        labelnama8.setText("JENIS KB");
        labelnama8.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        cbjeniskb.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        cbjeniskb.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Spiral", "Suntik", "Implan" }));

        labelnama4.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        labelnama4.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        labelnama4.setText("NIK ANAK");
        labelnama4.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        tnikanakpendaftaran.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        tnikanakpendaftaran.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tnikanakpendaftaranActionPerformed(evt);
            }
        });
        tnikanakpendaftaran.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tnikanakpendaftaranKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tnikanakpendaftaranKeyTyped(evt);
            }
        });

        labelu6.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        labelu6.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        labelu6.setText("USIA ANAK");
        labelu6.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        tusiaanak.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        tusiaanak.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tusiaanakActionPerformed(evt);
            }
        });
        tusiaanak.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tusiaanakKeyTyped(evt);
            }
        });

        labelu7.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        labelu7.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        labelu7.setText("BULAN");
        labelu7.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        labelnama9.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        labelnama9.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        labelnama9.setText("IMUNISASI");
        labelnama9.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        cbimunisasi.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        cbimunisasi.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-", "BCG", "DPT", "POLIO", "CAMPAK", "HEPATITIS", " " }));

        cbvitamin.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        cbvitamin.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-", "SIRUP BESI", "VITAMIN A", "ORALIT BLN" }));

        labelnama10.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        labelnama10.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        labelnama10.setText("VITAMIN");
        labelnama10.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        labelgih6.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        labelgih6.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        labelgih6.setText("ALAMAT");
        labelgih6.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        talamat.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        talamat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                talamatActionPerformed(evt);
            }
        });
        talamat.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                talamatKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout panelpendaftaranLayout = new javax.swing.GroupLayout(panelpendaftaran);
        panelpendaftaran.setLayout(panelpendaftaranLayout);
        panelpendaftaranLayout.setHorizontalGroup(
            panelpendaftaranLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelpendaftaranLayout.createSequentialGroup()
                .addGroup(panelpendaftaranLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(panelpendaftaranLayout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addGroup(panelpendaftaranLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 766, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, panelpendaftaranLayout.createSequentialGroup()
                                .addComponent(bsimpan)
                                .addGap(18, 18, 18)
                                .addComponent(bubah)
                                .addGap(18, 18, 18)
                                .addComponent(bhapus)
                                .addGap(18, 18, 18)
                                .addComponent(bbersih)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(tcaripendaftaran, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(bcaripendaftaran))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, panelpendaftaranLayout.createSequentialGroup()
                                .addGroup(panelpendaftaranLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(panelpendaftaranLayout.createSequentialGroup()
                                        .addComponent(labelid, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(tidpendaftaran, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(panelpendaftaranLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(panelpendaftaranLayout.createSequentialGroup()
                                            .addComponent(labelnama4, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(tnikanakpendaftaran, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelpendaftaranLayout.createSequentialGroup()
                                            .addComponent(labelnama, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(tnamaanak, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(panelpendaftaranLayout.createSequentialGroup()
                                        .addComponent(labelu6, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(tusiaanak, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(labelu7, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(panelpendaftaranLayout.createSequentialGroup()
                                        .addComponent(labelnama9, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(cbimunisasi, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(panelpendaftaranLayout.createSequentialGroup()
                                        .addComponent(labelnama10, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(cbvitamin, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(106, 106, 106)
                                .addGroup(panelpendaftaranLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(panelpendaftaranLayout.createSequentialGroup()
                                        .addComponent(labelnama8, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(cbjeniskb, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(panelpendaftaranLayout.createSequentialGroup()
                                        .addComponent(labelgih, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(tnohp, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(panelpendaftaranLayout.createSequentialGroup()
                                        .addComponent(labelu, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(tnamaorangtua, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(panelpendaftaranLayout.createSequentialGroup()
                                        .addComponent(labelgih6, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(talamat, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                    .addGroup(panelpendaftaranLayout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(bcetak1)))
                .addContainerGap(27, Short.MAX_VALUE))
        );
        panelpendaftaranLayout.setVerticalGroup(
            panelpendaftaranLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelpendaftaranLayout.createSequentialGroup()
                .addGroup(panelpendaftaranLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bcetak1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelpendaftaranLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelid, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tidpendaftaran, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelu, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tnamaorangtua, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelpendaftaranLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelpendaftaranLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(labelgih, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(tnohp, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelpendaftaranLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(labelnama4, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(tnikanakpendaftaran, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelpendaftaranLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelpendaftaranLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(labelgih6, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(talamat, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelpendaftaranLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(labelnama, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(tnamaanak, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelpendaftaranLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelpendaftaranLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(cbjeniskb, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(labelnama8, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelpendaftaranLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(labelu6, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(tusiaanak, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(labelu7, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelpendaftaranLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbimunisasi, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelnama9, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 10, Short.MAX_VALUE)
                .addGroup(panelpendaftaranLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbvitamin, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelnama10, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panelpendaftaranLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bsimpan, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bubah, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bbersih, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bhapus, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bcaripendaftaran, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tcaripendaftaran, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        panelmain.add(panelpendaftaran, "card3");

        paneldataanak.setBackground(new java.awt.Color(255, 153, 153));

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel13.setText("DATA ANAK");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel13, javax.swing.GroupLayout.DEFAULT_SIZE, 171, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel13, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
        );

        labelid1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        labelid1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        labelid1.setText("ID ANAK");
        labelid1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        tidanak.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        tidanak.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tidanakActionPerformed(evt);
            }
        });

        labelnama1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        labelnama1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        labelnama1.setText("NAMA ANAK");
        labelnama1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        labelu1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        labelu1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        labelu1.setText("NIK");
        labelu1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        tnik.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        tnik.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tnikActionPerformed(evt);
            }
        });
        tnik.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tnikKeyTyped(evt);
            }
        });

        labelaja1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        labelaja1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        labelaja1.setText("TANGGAL LAHIR");
        labelaja1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        labelgih1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        labelgih1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        labelgih1.setText("GOLONGAN DARAH");
        labelgih1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        bsimpan1.setBackground(new java.awt.Color(204, 204, 204));
        bsimpan1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        bsimpan1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar2/save-30-w11.png"))); // NOI18N
        bsimpan1.setText("SIMPAN");
        bsimpan1.setContentAreaFilled(false);
        bsimpan1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        bsimpan1.setOpaque(true);
        bsimpan1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                bsimpan1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                bsimpan1MouseExited(evt);
            }
        });
        bsimpan1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bsimpan1ActionPerformed(evt);
            }
        });

        bubah1.setBackground(new java.awt.Color(204, 204, 204));
        bubah1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        bubah1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar2/edit-30-w11.png"))); // NOI18N
        bubah1.setText("UBAH");
        bubah1.setContentAreaFilled(false);
        bubah1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        bubah1.setOpaque(true);
        bubah1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                bubah1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                bubah1MouseExited(evt);
            }
        });
        bubah1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bubah1ActionPerformed(evt);
            }
        });

        bhapus1.setBackground(new java.awt.Color(204, 204, 204));
        bhapus1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        bhapus1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar2/delete-30-w11.png"))); // NOI18N
        bhapus1.setText("HAPUS");
        bhapus1.setContentAreaFilled(false);
        bhapus1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        bhapus1.setOpaque(true);
        bhapus1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                bhapus1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                bhapus1MouseExited(evt);
            }
        });
        bhapus1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bhapus1ActionPerformed(evt);
            }
        });

        bbersih1.setBackground(new java.awt.Color(204, 204, 204));
        bbersih1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        bbersih1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar2/icons8-refresh-30.png"))); // NOI18N
        bbersih1.setContentAreaFilled(false);
        bbersih1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        bbersih1.setOpaque(true);
        bbersih1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                bbersih1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                bbersih1MouseExited(evt);
            }
        });
        bbersih1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bbersih1ActionPerformed(evt);
            }
        });

        tcaridataanak.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        tcaridataanak.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tcaridataanakActionPerformed(evt);
            }
        });

        bcaridataanak.setBackground(new java.awt.Color(204, 204, 204));
        bcaridataanak.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        bcaridataanak.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar2/icons8-search-24.png"))); // NOI18N
        bcaridataanak.setText("CARI");
        bcaridataanak.setContentAreaFilled(false);
        bcaridataanak.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        bcaridataanak.setOpaque(true);
        bcaridataanak.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                bcaridataanakMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                bcaridataanakMouseExited(evt);
            }
        });
        bcaridataanak.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bcaridataanakActionPerformed(evt);
            }
        });

        tabeldataanak.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        tabeldataanak.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4", "Title 5", "Title 6"
            }
        ));
        tabeldataanak.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        tabeldataanak.setRowHeight(24);
        tabeldataanak.setRowMargin(2);
        tabeldataanak.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabeldataanakMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tabeldataanak);

        tgllahiranak.setBackground(new java.awt.Color(255, 255, 255));
        tgllahiranak.setDateFormatString("d, MMM, yyyy");

        labeljk.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        labeljk.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        labeljk.setText("JENIS KELAMIN");
        labeljk.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        labelee.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        labelee.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        labelee.setText("BERAT BADAN LAHIR");
        labelee.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        labelu2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        labelu2.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        labelu2.setText("TINGGI BADAN LAHIR");
        labelu2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        rj1.setText("Laki-Laki");

        rj2.setText("Perempuan");
        rj2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rj2ActionPerformed(evt);
            }
        });

        tberatlahir.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        tberatlahir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tberatlahirActionPerformed(evt);
            }
        });
        tberatlahir.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tberatlahirKeyTyped(evt);
            }
        });

        ttinggilahir.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        ttinggilahir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ttinggilahirActionPerformed(evt);
            }
        });
        ttinggilahir.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                ttinggilahirKeyTyped(evt);
            }
        });

        labelgih2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        labelgih2.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        labelgih2.setText("KG");
        labelgih2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        labelgih3.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        labelgih3.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        labelgih3.setText("CM");
        labelgih3.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        cbgolongandarah.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        cbgolongandarah.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "A", "B", "AB", "O" }));

        bcetak2.setBackground(new java.awt.Color(204, 204, 204));
        bcetak2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        bcetak2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar2/hasil-transformed.png"))); // NOI18N
        bcetak2.setText("CETAK");
        bcetak2.setContentAreaFilled(false);
        bcetak2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        bcetak2.setOpaque(true);
        bcetak2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                bcetak2MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                bcetak2MouseExited(evt);
            }
        });
        bcetak2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bcetak2ActionPerformed(evt);
            }
        });

        tnama.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        tnama.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tnamaActionPerformed(evt);
            }
        });
        tnama.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tnamaKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout paneldataanakLayout = new javax.swing.GroupLayout(paneldataanak);
        paneldataanak.setLayout(paneldataanakLayout);
        paneldataanakLayout.setHorizontalGroup(
            paneldataanakLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(paneldataanakLayout.createSequentialGroup()
                .addGroup(paneldataanakLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(paneldataanakLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 766, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, paneldataanakLayout.createSequentialGroup()
                            .addGroup(paneldataanakLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, paneldataanakLayout.createSequentialGroup()
                                    .addComponent(labelnama1, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(tnama, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, paneldataanakLayout.createSequentialGroup()
                                    .addComponent(labelu1, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(tnik, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(paneldataanakLayout.createSequentialGroup()
                                    .addComponent(labelaja1, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(tgllahiranak, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, paneldataanakLayout.createSequentialGroup()
                                    .addComponent(labelgih1, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(cbgolongandarah, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(paneldataanakLayout.createSequentialGroup()
                                    .addComponent(labelid1, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(tidanak, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(130, 130, 130)))
                            .addGap(59, 59, 59)
                            .addGroup(paneldataanakLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(labelu2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(labelee, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(labeljk, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(paneldataanakLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(paneldataanakLayout.createSequentialGroup()
                                    .addGap(31, 31, 31)
                                    .addGroup(paneldataanakLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(tberatlahir, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 80, Short.MAX_VALUE)
                                        .addComponent(ttinggilahir))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addGroup(paneldataanakLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(labelgih2, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(labelgih3, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, paneldataanakLayout.createSequentialGroup()
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(rj1, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(29, 29, 29))))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, paneldataanakLayout.createSequentialGroup()
                            .addComponent(bsimpan1)
                            .addGap(18, 18, 18)
                            .addComponent(bubah1)
                            .addGap(18, 18, 18)
                            .addComponent(bhapus1)
                            .addGap(18, 18, 18)
                            .addComponent(bbersih1)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(tcaridataanak, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(bcaridataanak)))
                    .addGroup(paneldataanakLayout.createSequentialGroup()
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(518, 518, 518)
                        .addGroup(paneldataanakLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(rj2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(bcetak2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap(29, Short.MAX_VALUE))
        );
        paneldataanakLayout.setVerticalGroup(
            paneldataanakLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(paneldataanakLayout.createSequentialGroup()
                .addGroup(paneldataanakLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bcetak2, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(paneldataanakLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(paneldataanakLayout.createSequentialGroup()
                        .addGroup(paneldataanakLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(labelid1, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tidanak, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(paneldataanakLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(labelnama1, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tnama, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(paneldataanakLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(labelu1, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tnik, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(paneldataanakLayout.createSequentialGroup()
                        .addGroup(paneldataanakLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(labeljk, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(rj1)
                            .addComponent(rj2))
                        .addGap(18, 18, 18)
                        .addGroup(paneldataanakLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(labelee, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tberatlahir, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(labelgih2, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(paneldataanakLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(labelu2, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(ttinggilahir, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(labelgih3, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(18, 18, 18)
                .addGroup(paneldataanakLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(labelaja1, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tgllahiranak, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(paneldataanakLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelgih1, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbgolongandarah, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 22, Short.MAX_VALUE)
                .addGroup(paneldataanakLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bsimpan1, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bubah1, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bbersih1, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bhapus1, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bcaridataanak, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tcaridataanak, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        panelmain.add(paneldataanak, "card4");

        panelkunjungan.setBackground(new java.awt.Color(255, 153, 153));

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));

        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel14.setText("KUNJUNGAN");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel14, javax.swing.GroupLayout.DEFAULT_SIZE, 171, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel14, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
        );

        labelnama2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        labelnama2.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        labelnama2.setText("NAMA ANAK");
        labelnama2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        labelaja2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        labelaja2.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        labelaja2.setText("TANGGAL KUNJUNGAN");
        labelaja2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        tglkunjungan.setBackground(new java.awt.Color(255, 255, 255));
        tglkunjungan.setDateFormatString("d, MMM, yyyy");

        cbnamaanakkunjungan.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        tidkunjungan.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        tidkunjungan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tidkunjunganActionPerformed(evt);
            }
        });

        labelid2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        labelid2.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        labelid2.setText("ID KUNJUNGAN");
        labelid2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        tabelkunjungan.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        tabelkunjungan.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4", "Title 5", "Title 6"
            }
        ));
        tabelkunjungan.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        tabelkunjungan.setRowHeight(24);
        tabelkunjungan.setRowMargin(2);
        tabelkunjungan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelkunjunganMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tabelkunjungan);

        bsimpan2.setBackground(new java.awt.Color(204, 204, 204));
        bsimpan2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        bsimpan2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar2/save-30-w11.png"))); // NOI18N
        bsimpan2.setText("SIMPAN");
        bsimpan2.setContentAreaFilled(false);
        bsimpan2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        bsimpan2.setOpaque(true);
        bsimpan2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                bsimpan2MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                bsimpan2MouseExited(evt);
            }
        });
        bsimpan2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bsimpan2ActionPerformed(evt);
            }
        });

        bubah2.setBackground(new java.awt.Color(204, 204, 204));
        bubah2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        bubah2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar2/edit-30-w11.png"))); // NOI18N
        bubah2.setText("UBAH");
        bubah2.setContentAreaFilled(false);
        bubah2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        bubah2.setOpaque(true);
        bubah2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                bubah2MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                bubah2MouseExited(evt);
            }
        });
        bubah2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bubah2ActionPerformed(evt);
            }
        });

        bhapus2.setBackground(new java.awt.Color(204, 204, 204));
        bhapus2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        bhapus2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar2/delete-30-w11.png"))); // NOI18N
        bhapus2.setText("HAPUS");
        bhapus2.setContentAreaFilled(false);
        bhapus2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        bhapus2.setOpaque(true);
        bhapus2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                bhapus2MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                bhapus2MouseExited(evt);
            }
        });
        bhapus2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bhapus2ActionPerformed(evt);
            }
        });

        bbersih2.setBackground(new java.awt.Color(204, 204, 204));
        bbersih2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        bbersih2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar2/icons8-refresh-30.png"))); // NOI18N
        bbersih2.setContentAreaFilled(false);
        bbersih2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        bbersih2.setOpaque(true);
        bbersih2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                bbersih2MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                bbersih2MouseExited(evt);
            }
        });
        bbersih2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bbersih2ActionPerformed(evt);
            }
        });

        tcarikunjungan.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        tcarikunjungan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tcarikunjunganActionPerformed(evt);
            }
        });

        bcarikunjungan.setBackground(new java.awt.Color(204, 204, 204));
        bcarikunjungan.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        bcarikunjungan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar2/icons8-search-24.png"))); // NOI18N
        bcarikunjungan.setText("CARI");
        bcarikunjungan.setContentAreaFilled(false);
        bcarikunjungan.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        bcarikunjungan.setOpaque(true);
        bcarikunjungan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                bcarikunjunganMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                bcarikunjunganMouseExited(evt);
            }
        });
        bcarikunjungan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bcarikunjunganActionPerformed(evt);
            }
        });

        labelnama5.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        labelnama5.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        labelnama5.setText("NAMA ORANG TUA/WALI");
        labelnama5.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        tnamaorangtuakunjungan.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        tnamaorangtuakunjungan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tnamaorangtuakunjunganActionPerformed(evt);
            }
        });

        trt.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        trt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                trtActionPerformed(evt);
            }
        });
        trt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                trtKeyTyped(evt);
            }
        });

        labelnama7.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        labelnama7.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        labelnama7.setText("RT");
        labelnama7.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        bcetak3.setBackground(new java.awt.Color(204, 204, 204));
        bcetak3.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        bcetak3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar2/hasil-transformed.png"))); // NOI18N
        bcetak3.setText("CETAK");
        bcetak3.setContentAreaFilled(false);
        bcetak3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        bcetak3.setOpaque(true);
        bcetak3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                bcetak3MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                bcetak3MouseExited(evt);
            }
        });
        bcetak3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bcetak3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelkunjunganLayout = new javax.swing.GroupLayout(panelkunjungan);
        panelkunjungan.setLayout(panelkunjunganLayout);
        panelkunjunganLayout.setHorizontalGroup(
            panelkunjunganLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelkunjunganLayout.createSequentialGroup()
                .addGroup(panelkunjunganLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelkunjunganLayout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addGroup(panelkunjunganLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(bcetak3)
                            .addGroup(panelkunjunganLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(panelkunjunganLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(panelkunjunganLayout.createSequentialGroup()
                                        .addGroup(panelkunjunganLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(labelid2, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(labelaja2))
                                        .addGap(45, 45, 45)
                                        .addGroup(panelkunjunganLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(tidkunjungan, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(tglkunjungan, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelkunjunganLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(panelkunjunganLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                            .addGroup(panelkunjunganLayout.createSequentialGroup()
                                                .addComponent(labelnama5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addGap(18, 18, 18)
                                                .addComponent(tnamaorangtuakunjungan, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(panelkunjunganLayout.createSequentialGroup()
                                                .addComponent(labelnama2, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(53, 53, 53)
                                                .addComponent(cbnamaanakkunjungan, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addGroup(panelkunjunganLayout.createSequentialGroup()
                                            .addComponent(labelnama7, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(18, 18, 18)
                                            .addComponent(trt, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addGroup(panelkunjunganLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 766, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelkunjunganLayout.createSequentialGroup()
                                        .addComponent(bsimpan2)
                                        .addGap(18, 18, 18)
                                        .addComponent(bubah2)
                                        .addGap(18, 18, 18)
                                        .addComponent(bhapus2)
                                        .addGap(18, 18, 18)
                                        .addComponent(bbersih2)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(tcarikunjungan, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(bcarikunjungan))))))
                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(28, Short.MAX_VALUE))
        );
        panelkunjunganLayout.setVerticalGroup(
            panelkunjunganLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelkunjunganLayout.createSequentialGroup()
                .addGroup(panelkunjunganLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bcetak3, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 42, Short.MAX_VALUE)
                .addGroup(panelkunjunganLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(labelaja2, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tglkunjungan, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addGroup(panelkunjunganLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelid2, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tidkunjungan, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelkunjunganLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cbnamaanakkunjungan, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelnama2, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelkunjunganLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelnama5, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tnamaorangtuakunjungan, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelkunjunganLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelnama7, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(trt, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(32, 32, 32)
                .addGroup(panelkunjunganLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bsimpan2, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bubah2, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bbersih2, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bhapus2, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bcarikunjungan, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tcarikunjungan, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        panelmain.add(panelkunjungan, "card5");

        panelkondisi.setBackground(new java.awt.Color(255, 153, 153));

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));

        jLabel15.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel15.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel15.setText("HASIL PEMERIKSAAN");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel15, javax.swing.GroupLayout.DEFAULT_SIZE, 171, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel15, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
        );

        tidkondisi.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        tidkondisi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tidkondisiActionPerformed(evt);
            }
        });

        tusia.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        tusia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tusiaActionPerformed(evt);
            }
        });
        tusia.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tusiaKeyTyped(evt);
            }
        });

        tberat.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        tberat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tberatActionPerformed(evt);
            }
        });
        tberat.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tberatKeyTyped(evt);
            }
        });

        ttinggi.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        ttinggi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ttinggiActionPerformed(evt);
            }
        });
        ttinggi.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                ttinggiKeyTyped(evt);
            }
        });

        labelgih4.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        labelgih4.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        labelgih4.setText("KONDISI");
        labelgih4.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        labelu3.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        labelu3.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        labelu3.setText("USIA ANAK");
        labelu3.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        labelnama3.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        labelnama3.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        labelnama3.setText("NAMA ANAK");
        labelnama3.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        labelid3.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        labelid3.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        labelid3.setText("ID PEMERIKSAAN");
        labelid3.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        labelee1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        labelee1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        labelee1.setText("BERAT");
        labelee1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        labelu4.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        labelu4.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        labelu4.setText("TINGGI");
        labelu4.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        tabelkondisi.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        tabelkondisi.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4", "Title 5", "Title 6"
            }
        ));
        tabelkondisi.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        tabelkondisi.setRowHeight(24);
        tabelkondisi.setRowMargin(2);
        tabelkondisi.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelkondisiMouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(tabelkondisi);

        bsimpan3.setBackground(new java.awt.Color(204, 204, 204));
        bsimpan3.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        bsimpan3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar2/save-30-w11.png"))); // NOI18N
        bsimpan3.setText("SIMPAN");
        bsimpan3.setContentAreaFilled(false);
        bsimpan3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        bsimpan3.setOpaque(true);
        bsimpan3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                bsimpan3MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                bsimpan3MouseExited(evt);
            }
        });
        bsimpan3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bsimpan3ActionPerformed(evt);
            }
        });

        bubah3.setBackground(new java.awt.Color(204, 204, 204));
        bubah3.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        bubah3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar2/edit-30-w11.png"))); // NOI18N
        bubah3.setText("UBAH");
        bubah3.setContentAreaFilled(false);
        bubah3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        bubah3.setOpaque(true);
        bubah3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                bubah3MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                bubah3MouseExited(evt);
            }
        });
        bubah3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bubah3ActionPerformed(evt);
            }
        });

        bhapus3.setBackground(new java.awt.Color(204, 204, 204));
        bhapus3.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        bhapus3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar2/delete-30-w11.png"))); // NOI18N
        bhapus3.setText("HAPUS");
        bhapus3.setContentAreaFilled(false);
        bhapus3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        bhapus3.setOpaque(true);
        bhapus3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                bhapus3MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                bhapus3MouseExited(evt);
            }
        });
        bhapus3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bhapus3ActionPerformed(evt);
            }
        });

        bbersih3.setBackground(new java.awt.Color(204, 204, 204));
        bbersih3.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        bbersih3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar2/icons8-refresh-30.png"))); // NOI18N
        bbersih3.setContentAreaFilled(false);
        bbersih3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        bbersih3.setOpaque(true);
        bbersih3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                bbersih3MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                bbersih3MouseExited(evt);
            }
        });
        bbersih3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bbersih3ActionPerformed(evt);
            }
        });

        tcarikondisi.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        tcarikondisi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tcarikondisiActionPerformed(evt);
            }
        });

        bcarikondisi.setBackground(new java.awt.Color(204, 204, 204));
        bcarikondisi.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        bcarikondisi.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar2/icons8-search-24.png"))); // NOI18N
        bcarikondisi.setText("CARI");
        bcarikondisi.setContentAreaFilled(false);
        bcarikondisi.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        bcarikondisi.setOpaque(true);
        bcarikondisi.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                bcarikondisiMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                bcarikondisiMouseExited(evt);
            }
        });
        bcarikondisi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bcarikondisiActionPerformed(evt);
            }
        });

        labelee2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        labelee2.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        labelee2.setText("KG");
        labelee2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        labelu5.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        labelu5.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        labelu5.setText("CM");
        labelu5.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        labelgih5.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        labelgih5.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        labelgih5.setText("Bulan");
        labelgih5.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        bcetak4.setBackground(new java.awt.Color(204, 204, 204));
        bcetak4.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        bcetak4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar2/hasil-transformed.png"))); // NOI18N
        bcetak4.setText("CETAK");
        bcetak4.setContentAreaFilled(false);
        bcetak4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        bcetak4.setOpaque(true);
        bcetak4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                bcetak4MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                bcetak4MouseExited(evt);
            }
        });
        bcetak4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bcetak4ActionPerformed(evt);
            }
        });

        labelnama6.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        labelnama6.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        labelnama6.setText("ID KUNJUNGAN");
        labelnama6.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        cbidkunjungan.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        cbidkunjungan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbidkunjunganActionPerformed(evt);
            }
        });

        tnamaanakkondisi.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        tnamaanakkondisi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tnamaanakkondisiActionPerformed(evt);
            }
        });

        labelee3.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        labelee3.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        labelee3.setText("LINGKAR KEPALA");
        labelee3.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        tlingkar.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        tlingkar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tlingkarActionPerformed(evt);
            }
        });
        tlingkar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tlingkarKeyTyped(evt);
            }
        });

        labelee4.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        labelee4.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        labelee4.setText("CM");
        labelee4.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        labelee5.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        labelee5.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        labelee5.setText("LINGKAR LENGAN");
        labelee5.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        tlengan.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        tlengan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tlenganActionPerformed(evt);
            }
        });
        tlengan.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tlenganKeyTyped(evt);
            }
        });

        labelee6.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        labelee6.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        labelee6.setText("CM");
        labelee6.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        labelnama11.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        labelnama11.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        labelnama11.setText("BIDAN YANG BERTUGAS");
        labelnama11.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        tkondisi.setColumns(20);
        tkondisi.setRows(5);
        jScrollPane5.setViewportView(tkondisi);

        javax.swing.GroupLayout panelkondisiLayout = new javax.swing.GroupLayout(panelkondisi);
        panelkondisi.setLayout(panelkondisiLayout);
        panelkondisiLayout.setHorizontalGroup(
            panelkondisiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelkondisiLayout.createSequentialGroup()
                .addGroup(panelkondisiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(panelkondisiLayout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addGroup(panelkondisiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(bcetak4)
                            .addGroup(panelkondisiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jScrollPane4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 766, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(panelkondisiLayout.createSequentialGroup()
                                    .addGroup(panelkondisiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(panelkondisiLayout.createSequentialGroup()
                                            .addComponent(bsimpan3)
                                            .addGap(18, 18, 18)
                                            .addComponent(bubah3)
                                            .addGap(18, 18, 18)
                                            .addComponent(bhapus3)
                                            .addGap(18, 18, 18)
                                            .addComponent(bbersih3))
                                        .addGroup(panelkondisiLayout.createSequentialGroup()
                                            .addGroup(panelkondisiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(panelkondisiLayout.createSequentialGroup()
                                                    .addGroup(panelkondisiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(labelnama6, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(labelid3, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(labelu3, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                                .addGroup(panelkondisiLayout.createSequentialGroup()
                                                    .addGroup(panelkondisiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(labelnama3, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(labelnama11))
                                                    .addGap(0, 0, Short.MAX_VALUE)))
                                            .addGroup(panelkondisiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelkondisiLayout.createSequentialGroup()
                                                    .addComponent(tusia, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                    .addComponent(labelgih5, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addGap(55, 55, 55))
                                                .addComponent(cbidkunjungan, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(tidkondisi, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGroup(panelkondisiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                    .addComponent(cbbidantugas, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                    .addComponent(tnamaanakkondisi, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                            .addGap(85, 85, 85)))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGroup(panelkondisiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(panelkondisiLayout.createSequentialGroup()
                                            .addComponent(tcarikondisi, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(18, 18, 18)
                                            .addComponent(bcarikondisi))
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelkondisiLayout.createSequentialGroup()
                                            .addGroup(panelkondisiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelkondisiLayout.createSequentialGroup()
                                                    .addGroup(panelkondisiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                        .addComponent(labelee3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(labelee5, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                                                .addGroup(panelkondisiLayout.createSequentialGroup()
                                                    .addComponent(labelgih4, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addGap(33, 33, 33)))
                                            .addGroup(panelkondisiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                .addComponent(jScrollPane5)
                                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelkondisiLayout.createSequentialGroup()
                                                    .addGroup(panelkondisiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                        .addGroup(panelkondisiLayout.createSequentialGroup()
                                                            .addComponent(tlengan, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                            .addComponent(labelee6, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelkondisiLayout.createSequentialGroup()
                                                            .addComponent(tlingkar, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                            .addGap(10, 10, 10)
                                                            .addComponent(labelee4, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                    .addGroup(panelkondisiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                        .addGroup(panelkondisiLayout.createSequentialGroup()
                                                            .addComponent(labelu4)
                                                            .addGap(1, 1, 1))
                                                        .addComponent(labelee1))
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                    .addGroup(panelkondisiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                        .addGroup(panelkondisiLayout.createSequentialGroup()
                                                            .addComponent(ttinggi, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                            .addComponent(labelu5))
                                                        .addGroup(panelkondisiLayout.createSequentialGroup()
                                                            .addComponent(tberat, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                            .addComponent(labelee2))))))))))))
                .addContainerGap(28, Short.MAX_VALUE))
        );
        panelkondisiLayout.setVerticalGroup(
            panelkondisiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelkondisiLayout.createSequentialGroup()
                .addGroup(panelkondisiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bcetak4, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panelkondisiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(panelkondisiLayout.createSequentialGroup()
                        .addGroup(panelkondisiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelkondisiLayout.createSequentialGroup()
                                .addGroup(panelkondisiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(panelkondisiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(labelee3, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(tlingkar, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(panelkondisiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(labelee4, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(ttinggi, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(labelu5, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(18, 18, 18)
                                .addGroup(panelkondisiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(labelee5, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(panelkondisiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(tlengan, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(labelee6, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(tberat, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(labelee2, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(panelkondisiLayout.createSequentialGroup()
                                .addComponent(labelu4, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(labelee1, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addGroup(panelkondisiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane5)
                            .addGroup(panelkondisiLayout.createSequentialGroup()
                                .addComponent(labelgih4, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(panelkondisiLayout.createSequentialGroup()
                        .addGroup(panelkondisiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(labelid3, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tidkondisi, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(panelkondisiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(labelnama6, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbidkunjungan, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(panelkondisiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(labelnama3, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tnamaanakkondisi, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(panelkondisiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(labelnama11, javax.swing.GroupLayout.DEFAULT_SIZE, 28, Short.MAX_VALUE)
                            .addComponent(cbbidantugas))
                        .addGap(11, 11, 11)
                        .addGroup(panelkondisiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(labelu3, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tusia, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(labelgih5, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
                .addGroup(panelkondisiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bsimpan3, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bubah3, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bbersih3, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bhapus3, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bcarikondisi, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tcarikondisi, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(38, 38, 38)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        panelmain.add(panelkondisi, "card6");

        paneljadwal.setBackground(new java.awt.Color(255, 153, 153));

        jPanel7.setBackground(new java.awt.Color(255, 255, 255));

        jLabel17.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel17.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel17.setText("DATA JADWAL");

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel17, javax.swing.GroupLayout.DEFAULT_SIZE, 171, Short.MAX_VALUE)
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel17, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
        );

        labelid7.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        labelid7.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        labelid7.setText("HARI/TANGGAL");
        labelid7.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        tabeljadwal.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        tabeljadwal.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4", "Title 5", "Title 6"
            }
        ));
        tabeljadwal.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        tabeljadwal.setRowHeight(24);
        tabeljadwal.setRowMargin(2);
        tabeljadwal.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabeljadwalMouseClicked(evt);
            }
        });
        jScrollPane7.setViewportView(tabeljadwal);

        bsimpan5.setBackground(new java.awt.Color(204, 204, 204));
        bsimpan5.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        bsimpan5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar2/save-30-w11.png"))); // NOI18N
        bsimpan5.setText("SIMPAN");
        bsimpan5.setContentAreaFilled(false);
        bsimpan5.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        bsimpan5.setOpaque(true);
        bsimpan5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                bsimpan5MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                bsimpan5MouseExited(evt);
            }
        });
        bsimpan5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bsimpan5ActionPerformed(evt);
            }
        });

        bubah5.setBackground(new java.awt.Color(204, 204, 204));
        bubah5.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        bubah5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar2/edit-30-w11.png"))); // NOI18N
        bubah5.setText("UBAH");
        bubah5.setContentAreaFilled(false);
        bubah5.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        bubah5.setOpaque(true);
        bubah5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                bubah5MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                bubah5MouseExited(evt);
            }
        });
        bubah5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bubah5ActionPerformed(evt);
            }
        });

        bhapus5.setBackground(new java.awt.Color(204, 204, 204));
        bhapus5.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        bhapus5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar2/delete-30-w11.png"))); // NOI18N
        bhapus5.setText("HAPUS");
        bhapus5.setContentAreaFilled(false);
        bhapus5.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        bhapus5.setOpaque(true);
        bhapus5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                bhapus5MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                bhapus5MouseExited(evt);
            }
        });
        bhapus5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bhapus5ActionPerformed(evt);
            }
        });

        bbersih5.setBackground(new java.awt.Color(204, 204, 204));
        bbersih5.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        bbersih5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar2/icons8-refresh-30.png"))); // NOI18N
        bbersih5.setContentAreaFilled(false);
        bbersih5.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        bbersih5.setOpaque(true);
        bbersih5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                bbersih5MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                bbersih5MouseExited(evt);
            }
        });
        bbersih5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bbersih5ActionPerformed(evt);
            }
        });

        labelu9.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        labelu9.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        labelu9.setText("WAKTU");
        labelu9.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        jdwl.setDateFormatString("EEEE, dd MMMM yyyy");

        twaktu.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        twaktu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                twaktuActionPerformed(evt);
            }
        });

        tidjadwal.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        tidjadwal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tidjadwalActionPerformed(evt);
            }
        });

        labelu10.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        labelu10.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        labelu10.setText("ID");
        labelu10.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        bcetak6.setBackground(new java.awt.Color(204, 204, 204));
        bcetak6.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        bcetak6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar2/hasil-transformed.png"))); // NOI18N
        bcetak6.setText("CETAK");
        bcetak6.setContentAreaFilled(false);
        bcetak6.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        bcetak6.setOpaque(true);
        bcetak6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                bcetak6MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                bcetak6MouseExited(evt);
            }
        });
        bcetak6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bcetak6ActionPerformed(evt);
            }
        });

        labelid8.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        labelid8.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        labelid8.setText("NAMA BIDAN");
        labelid8.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        tnikjadwal.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        tnikjadwal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tnikjadwalActionPerformed(evt);
            }
        });
        tnikjadwal.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tnikjadwalKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tnikjadwalKeyTyped(evt);
            }
        });

        labelu11.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        labelu11.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        labelu11.setText("KODE BIDAN");
        labelu11.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        cbnamabidanjadwal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbnamabidanjadwalActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout paneljadwalLayout = new javax.swing.GroupLayout(paneljadwal);
        paneljadwal.setLayout(paneljadwalLayout);
        paneljadwalLayout.setHorizontalGroup(
            paneljadwalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(paneljadwalLayout.createSequentialGroup()
                .addGroup(paneljadwalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(paneljadwalLayout.createSequentialGroup()
                        .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(519, 519, 519)
                        .addComponent(bcetak6))
                    .addGroup(paneljadwalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(paneljadwalLayout.createSequentialGroup()
                            .addComponent(bsimpan5)
                            .addGap(18, 18, 18)
                            .addComponent(bubah5)
                            .addGap(18, 18, 18)
                            .addComponent(bhapus5)
                            .addGap(18, 18, 18)
                            .addComponent(bbersih5))
                        .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 766, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(paneljadwalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, paneljadwalLayout.createSequentialGroup()
                                .addComponent(labelu9, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(twaktu))
                            .addGroup(paneljadwalLayout.createSequentialGroup()
                                .addComponent(labelu10, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(tidjadwal, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(121, 121, 121)))
                        .addGroup(paneljadwalLayout.createSequentialGroup()
                            .addComponent(labelid7, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jdwl, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(paneljadwalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, paneljadwalLayout.createSequentialGroup()
                                .addComponent(labelid8, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cbnamabidanjadwal, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, paneljadwalLayout.createSequentialGroup()
                                .addComponent(labelu11, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(tnikjadwal, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(28, Short.MAX_VALUE))
        );
        paneljadwalLayout.setVerticalGroup(
            paneljadwalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(paneljadwalLayout.createSequentialGroup()
                .addGroup(paneljadwalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bcetak6, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(38, 38, 38)
                .addGroup(paneljadwalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tidjadwal, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelu10, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(paneljadwalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(labelid8, javax.swing.GroupLayout.DEFAULT_SIZE, 29, Short.MAX_VALUE)
                    .addComponent(cbnamabidanjadwal, javax.swing.GroupLayout.DEFAULT_SIZE, 29, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(paneljadwalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tnikjadwal, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelu11, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15)
                .addGroup(paneljadwalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(labelid7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jdwl, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(paneljadwalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelu9, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(twaktu, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25)
                .addGroup(paneljadwalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bsimpan5, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bubah5, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bbersih5, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bhapus5, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jdwl.setLocale(new Locale("in", "ID"));
        jdwl.setDateFormatString("EEEE, dd MMMM yyyy");

        panelmain.add(paneljadwal, "card8");

        panelbidan.setBackground(new java.awt.Color(255, 153, 153));

        jPanel8.setBackground(new java.awt.Color(255, 255, 255));

        jLabel18.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel18.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel18.setText("BIDAN");

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel18, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 171, Short.MAX_VALUE)
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel18, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
        );

        labelu12.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        labelu12.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        labelu12.setText("ID");
        labelu12.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        tidbidan.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        tidbidan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tidbidanActionPerformed(evt);
            }
        });

        labelu13.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        labelu13.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        labelu13.setText("NAMA");
        labelu13.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        tnamabidan.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        tnamabidan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tnamabidanActionPerformed(evt);
            }
        });

        labelu14.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        labelu14.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        labelu14.setText("ALAMAT");
        labelu14.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        talamatbidan.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        talamatbidan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                talamatbidanActionPerformed(evt);
            }
        });

        tabelbidan.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        tabelbidan.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4", "Title 5", "Title 6"
            }
        ));
        tabelbidan.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        tabelbidan.setRowHeight(24);
        tabelbidan.setRowMargin(2);
        tabelbidan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelbidanMouseClicked(evt);
            }
        });
        jScrollPane8.setViewportView(tabelbidan);

        bsimpan6.setBackground(new java.awt.Color(204, 204, 204));
        bsimpan6.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        bsimpan6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar2/save-30-w11.png"))); // NOI18N
        bsimpan6.setText("SIMPAN");
        bsimpan6.setContentAreaFilled(false);
        bsimpan6.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        bsimpan6.setOpaque(true);
        bsimpan6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                bsimpan6MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                bsimpan6MouseExited(evt);
            }
        });
        bsimpan6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bsimpan6ActionPerformed(evt);
            }
        });

        bubah6.setBackground(new java.awt.Color(204, 204, 204));
        bubah6.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        bubah6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar2/edit-30-w11.png"))); // NOI18N
        bubah6.setText("UBAH");
        bubah6.setContentAreaFilled(false);
        bubah6.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        bubah6.setOpaque(true);
        bubah6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                bubah6MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                bubah6MouseExited(evt);
            }
        });
        bubah6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bubah6ActionPerformed(evt);
            }
        });

        bhapus6.setBackground(new java.awt.Color(204, 204, 204));
        bhapus6.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        bhapus6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar2/delete-30-w11.png"))); // NOI18N
        bhapus6.setText("HAPUS");
        bhapus6.setContentAreaFilled(false);
        bhapus6.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        bhapus6.setOpaque(true);
        bhapus6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                bhapus6MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                bhapus6MouseExited(evt);
            }
        });
        bhapus6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bhapus6ActionPerformed(evt);
            }
        });

        bbersih6.setBackground(new java.awt.Color(204, 204, 204));
        bbersih6.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        bbersih6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar2/icons8-refresh-30.png"))); // NOI18N
        bbersih6.setContentAreaFilled(false);
        bbersih6.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        bbersih6.setOpaque(true);
        bbersih6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                bbersih6MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                bbersih6MouseExited(evt);
            }
        });
        bbersih6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bbersih6ActionPerformed(evt);
            }
        });

        labelu15.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        labelu15.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        labelu15.setText("NO HP");
        labelu15.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        tnohpbidan.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        tnohpbidan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tnohpbidanActionPerformed(evt);
            }
        });
        tnohpbidan.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tnohpbidanKeyTyped(evt);
            }
        });

        bcetak7.setBackground(new java.awt.Color(204, 204, 204));
        bcetak7.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        bcetak7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar2/hasil-transformed.png"))); // NOI18N
        bcetak7.setText("CETAK");
        bcetak7.setContentAreaFilled(false);
        bcetak7.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        bcetak7.setOpaque(true);
        bcetak7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                bcetak7MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                bcetak7MouseExited(evt);
            }
        });
        bcetak7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bcetak7ActionPerformed(evt);
            }
        });

        tnikbidan.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        tnikbidan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tnikbidanActionPerformed(evt);
            }
        });
        tnikbidan.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tnikbidanKeyTyped(evt);
            }
        });

        labelu16.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        labelu16.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        labelu16.setText("KODE BIDAN");
        labelu16.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout panelbidanLayout = new javax.swing.GroupLayout(panelbidan);
        panelbidan.setLayout(panelbidanLayout);
        panelbidanLayout.setHorizontalGroup(
            panelbidanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelbidanLayout.createSequentialGroup()
                .addGroup(panelbidanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(panelbidanLayout.createSequentialGroup()
                        .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(526, 526, 526)
                        .addComponent(bcetak7))
                    .addGroup(panelbidanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(panelbidanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, panelbidanLayout.createSequentialGroup()
                                .addComponent(labelu14, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(talamatbidan))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, panelbidanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(panelbidanLayout.createSequentialGroup()
                                    .addComponent(labelu13, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(tnamabidan, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(panelbidanLayout.createSequentialGroup()
                                    .addComponent(labelu12, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(tidbidan, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(121, 121, 121))
                                .addGroup(panelbidanLayout.createSequentialGroup()
                                    .addComponent(labelu16, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(tnikbidan, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGroup(panelbidanLayout.createSequentialGroup()
                            .addComponent(bsimpan6)
                            .addGap(18, 18, 18)
                            .addComponent(bubah6)
                            .addGap(18, 18, 18)
                            .addComponent(bhapus6)
                            .addGap(18, 18, 18)
                            .addComponent(bbersih6))
                        .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 780, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(panelbidanLayout.createSequentialGroup()
                            .addComponent(labelu15, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(tnohpbidan, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(21, Short.MAX_VALUE))
        );
        panelbidanLayout.setVerticalGroup(
            panelbidanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelbidanLayout.createSequentialGroup()
                .addGroup(panelbidanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bcetak7, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(37, 37, 37)
                .addGroup(panelbidanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tidbidan, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelu12, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelbidanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tnikbidan, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelu16, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 13, Short.MAX_VALUE)
                .addGroup(panelbidanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tnamabidan, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelu13, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelbidanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelu14, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(talamatbidan, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelbidanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelu15, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tnohpbidan, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panelbidanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bsimpan6, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bubah6, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bbersih6, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bhapus6, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20))
        );

        panelmain.add(panelbidan, "card9");

        javax.swing.GroupLayout panelutamaLayout = new javax.swing.GroupLayout(panelutama);
        panelutama.setLayout(panelutamaLayout);
        panelutamaLayout.setHorizontalGroup(
            panelutamaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelutamaLayout.createSequentialGroup()
                .addComponent(panelmenu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelmain, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(panelheader, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        panelutamaLayout.setVerticalGroup(
            panelutamaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelutamaLayout.createSequentialGroup()
                .addComponent(panelheader, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(2, 2, 2)
                .addGroup(panelutamaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panelmenu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panelmain, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelutama, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelutama, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void bpendaftaranActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bpendaftaranActionPerformed
        panelmain.removeAll();
        panelmain.repaint();
        panelmain.revalidate();
        //add panel
        panelmain.add(panelpendaftaran);
        panelmain.repaint();
        panelmain.revalidate();
    }//GEN-LAST:event_bpendaftaranActionPerformed

    private void bdasboardActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bdasboardActionPerformed
        //remove panel
        panelmain.removeAll();
        panelmain.repaint();
        panelmain.revalidate();
        //add panel
        panelmain.add(paneldasboard);
        panelmain.repaint();
        panelmain.revalidate();
    }//GEN-LAST:event_bdasboardActionPerformed

    private void bdasboardMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bdasboardMouseEntered
        bdasboard.setBackground(new Color(153,51,255));
    }//GEN-LAST:event_bdasboardMouseEntered

    private void bpendaftaranMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bpendaftaranMouseEntered
        bpendaftaran.setBackground(new Color(153,51,255));
    }//GEN-LAST:event_bpendaftaranMouseEntered

    private void bdataanakMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bdataanakMouseEntered
        bdataanak.setBackground(new Color(153,51,255));
    }//GEN-LAST:event_bdataanakMouseEntered

    private void bkunjunganMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bkunjunganMouseEntered
        bkunjungan.setBackground(new Color(153,51,255));
    }//GEN-LAST:event_bkunjunganMouseEntered

    private void bkondisiMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bkondisiMouseEntered
        bkondisi.setBackground(new Color(153,51,255));
    }//GEN-LAST:event_bkondisiMouseEntered

    private void bjadwalMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bjadwalMouseEntered
        bjadwal.setBackground(new Color(153,51,255));
    }//GEN-LAST:event_bjadwalMouseEntered

    private void bdasboardMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bdasboardMouseExited
        bdasboard.setBackground(new Color(148,123,192));
    }//GEN-LAST:event_bdasboardMouseExited

    private void bpendaftaranMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bpendaftaranMouseExited
        bpendaftaran.setBackground(new Color(148,123,192));
    }//GEN-LAST:event_bpendaftaranMouseExited

    private void bdataanakMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bdataanakMouseExited
        bdataanak.setBackground(new Color(148,123,192));
    }//GEN-LAST:event_bdataanakMouseExited

    private void bkunjunganMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bkunjunganMouseExited
        bkunjungan.setBackground(new Color(148,123,192));
    }//GEN-LAST:event_bkunjunganMouseExited

    private void bkondisiMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bkondisiMouseExited
        bkondisi.setBackground(new Color(148,123,192));
    }//GEN-LAST:event_bkondisiMouseExited

    private void bjadwalMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bjadwalMouseExited
        bjadwal.setBackground(new Color(148,123,192));
    }//GEN-LAST:event_bjadwalMouseExited

    private void bdataanakActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bdataanakActionPerformed
        panelmain.removeAll();
        panelmain.repaint();
        panelmain.revalidate();
        //add panel
        panelmain.add(paneldataanak);
        panelmain.repaint();
        panelmain.revalidate();
    }//GEN-LAST:event_bdataanakActionPerformed

    private void bkunjunganActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bkunjunganActionPerformed
        panelmain.removeAll();
        panelmain.repaint();
        panelmain.revalidate();
        //add panel
        panelmain.add(panelkunjungan);
        panelmain.repaint();
        panelmain.revalidate();
        namaanakkunjungan();
    }//GEN-LAST:event_bkunjunganActionPerformed

    private void bkondisiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bkondisiActionPerformed
        panelmain.removeAll();
        panelmain.repaint();
        panelmain.revalidate();
        //add panel
        panelmain.add(panelkondisi);
        panelmain.repaint();
        panelmain.revalidate();
        idkunjungan();
        bidanbertugas();
    }//GEN-LAST:event_bkondisiActionPerformed

    private void bjadwalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bjadwalActionPerformed
        panelmain.removeAll();
        panelmain.repaint();
        panelmain.revalidate();
        //add panel
        panelmain.add(paneljadwal);
        panelmain.repaint();
        panelmain.revalidate();
        nikbidan();
    }//GEN-LAST:event_bjadwalActionPerformed

    private void bkeluarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bkeluarMouseEntered
        bkeluar.setBackground(new Color(255,0,0));
    }//GEN-LAST:event_bkeluarMouseEntered

    private void bkeluarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bkeluarMouseExited
        bkeluar.setBackground(new Color(148,123,192));
    }//GEN-LAST:event_bkeluarMouseExited

    private void bkeluarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bkeluarActionPerformed
//        dispose();
        login lg = new login();
        lg.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_bkeluarActionPerformed

    private void tidanakActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tidanakActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tidanakActionPerformed

    private void tnikActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tnikActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tnikActionPerformed

    private void bsimpan1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bsimpan1MouseEntered
        bsimpan1.setBackground(new Color(0,0,204));
        bsimpan1.setForeground(Color.white);
    }//GEN-LAST:event_bsimpan1MouseEntered

    private void bsimpan1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bsimpan1MouseExited
        bsimpan1.setBackground(new Color(204,204,204));
        bsimpan1.setForeground(Color.black);
    }//GEN-LAST:event_bsimpan1MouseExited

    private void bsimpan1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bsimpan1ActionPerformed
        String tampilan = "yyyy-MM-dd";
        SimpleDateFormat fm = new SimpleDateFormat(tampilan);
        if (tgllahiranak.getDate() == null) {
            JOptionPane.showMessageDialog(null, "Semua data harus terisi", "Notice !!!", JOptionPane.WARNING_MESSAGE);
        } else {
            String tanggal = String.valueOf(fm.format(tgllahiranak.getDate()));
            String sql = "INSERT INTO tbdataanak VALUES (?,?,?,?,?,?,?,?)";
            String checkSql = "SELECT COUNT(*) FROM tbdataanak WHERE nik = ?";
            try {
                PreparedStatement checkStat = conn.prepareStatement(checkSql);
                checkStat.setString(1, tnik.getText());
                ResultSet rs = checkStat.executeQuery();
                rs.next();
                int count = rs.getInt(1);
                if (count > 0) {
                    JOptionPane.showMessageDialog(null, "NIK tidak boleh sama", "Notice !!!", JOptionPane.WARNING_MESSAGE);
                } else {
                    PreparedStatement stat = conn.prepareStatement(sql);
                    if (tidanak.getText().isEmpty() || tnama.getText().isEmpty() || tnik.getText().isEmpty()
                            || cbgolongandarah.getSelectedItem() == null || (!rj1.isSelected() && !rj2.isSelected())
                            || tberatlahir.getText().isEmpty() || ttinggilahir.getText().isEmpty()) {
                        JOptionPane.showMessageDialog(null, "Semua data harus terisi", "Notice !!!", JOptionPane.WARNING_MESSAGE);
                    } else {
                        stat.setString(1, tidanak.getText());
                        stat.setString(2, tnama.getText());
                        stat.setString(3, tnik.getText());
                        stat.setString(4, tanggal);
                        stat.setString(5, cbgolongandarah.getSelectedItem().toString());

                        String jkel = "";
                        if (rj1.isSelected()) jkel = "Laki-Laki";
                        else jkel = "Perempuan";
                        stat.setString(6, jkel);

                        String beratkg = tberatlahir.getText() + "KG";
                        stat.setString(7, beratkg);
                        String tinggicm = ttinggilahir.getText() + "CM";
                        stat.setString(8, tinggicm);
                        stat.executeUpdate();
                        JOptionPane.showMessageDialog(null, "Data Berhasil Disimpan");
                        kosong2();
                        tnama.requestFocus();
                        datatable2();
                        autoNumber2();
                        tidanak.setEnabled(false);
                    }
                }
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Data Gagal Disimpan" + e);
            }
        }
    }//GEN-LAST:event_bsimpan1ActionPerformed

    private void bubah1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bubah1MouseEntered
        bubah1.setBackground(new Color(0,0,204));
        bubah1.setForeground(Color.white);
    }//GEN-LAST:event_bubah1MouseEntered

    private void bubah1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bubah1MouseExited
        bubah1.setBackground(new Color(204,204,204));
        bubah1.setForeground(Color.black);
    }//GEN-LAST:event_bubah1MouseExited

    private void bubah1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bubah1ActionPerformed
        String tampilan = "yyyy-MM-dd";
        SimpleDateFormat fm = new SimpleDateFormat(tampilan);
        String tanggal  = String.valueOf(fm.format(tgllahiranak.getDate()));
        if (tnama.getText().isEmpty() || tnik.getText().isEmpty() || tanggal.isEmpty() ||
            cbgolongandarah.getSelectedItem() == null || (!rj1.isSelected() && !rj2.isSelected()) ||
            tberatlahir.getText().isEmpty() || ttinggilahir.getText().isEmpty() || tidanak.getText().isEmpty()) {

            JOptionPane.showMessageDialog(null, "Semua data harus terisi", "Notice !!!", JOptionPane.WARNING_MESSAGE);
        } else {
            try {
                String sql = "update tbdataanak set nama_anak=?,nik=?,tanggallahir=?,golongandarah=?,kelamin=?,berat=?,tinggi=? where id=?";
                PreparedStatement stat = conn.prepareStatement(sql);
                stat.setString(1, tnama.getText());
                stat.setString(2, tnik.getText());
                stat.setString(3, tanggal);
                stat.setString(4, cbgolongandarah.getSelectedItem().toString());

                String jkel="";
                if (rj1.isSelected()) jkel="Laki-Laki";
                else jkel="Perempuan";
                stat.setString(5, jkel);
                
                String beratkg = tberatlahir.getText() + "KG";
                stat.setString(6, beratkg);
                String tinggicm = ttinggilahir.getText() + "CM";
                stat.setString(7, tinggicm);

                stat.setString(8, tidanak.getText());

                stat.executeUpdate();
                JOptionPane.showMessageDialog(null,"Data Berhasil diubah");
                kosong2();
                tnama.requestFocus();
                datatable2();
                autoNumber2();
            }catch (SQLException e){
                JOptionPane.showMessageDialog(null, "Data Gagal Diubah"+e);
            }
        }
    }//GEN-LAST:event_bubah1ActionPerformed

    private void bhapus1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bhapus1MouseEntered
        bhapus1.setBackground(new Color(0,0,204));
        bhapus1.setForeground(Color.white);
    }//GEN-LAST:event_bhapus1MouseEntered

    private void bhapus1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bhapus1MouseExited
        bhapus1.setBackground(new Color(204,204,204));
        bhapus1.setForeground(Color.black);
    }//GEN-LAST:event_bhapus1MouseExited

    private void bhapus1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bhapus1ActionPerformed
        int ok = JOptionPane.showConfirmDialog(null,"hapus","Konfirmasi Dialog", JOptionPane.YES_NO_CANCEL_OPTION);
        if (ok==0){
            String sql="delete from tbdataanak where id='"+tidanak.getText()+"'";
            try {
                PreparedStatement stat = conn.prepareStatement(sql);
                stat.executeUpdate();
                JOptionPane.showMessageDialog(null, "data berhasil dihapus");
                kosong2();
                tnama.requestFocus();
                datatable2();
                autoNumber2();
            } catch (SQLException e){
                JOptionPane.showMessageDialog(null, "Data gagal dihapus"+e);
            }
        }
    }//GEN-LAST:event_bhapus1ActionPerformed

    private void bbersih1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bbersih1MouseEntered
        bbersih1.setBackground(new Color(0,0,204));
        bbersih1.setForeground(Color.white);
    }//GEN-LAST:event_bbersih1MouseEntered

    private void bbersih1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bbersih1MouseExited
        bbersih1.setBackground(new Color(204,204,204));
        bbersih1.setForeground(Color.black);
    }//GEN-LAST:event_bbersih1MouseExited

    private void bbersih1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bbersih1ActionPerformed
        kosong2();
        autoNumber2();
        datatable2();
    }//GEN-LAST:event_bbersih1ActionPerformed

    private void tcaridataanakActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tcaridataanakActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tcaridataanakActionPerformed

    private void bcaridataanakMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bcaridataanakMouseEntered
        bcaridataanak.setBackground(new Color(0,0,204));
        bcaridataanak.setForeground(Color.white);
    }//GEN-LAST:event_bcaridataanakMouseEntered

    private void bcaridataanakMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bcaridataanakMouseExited
        bcaridataanak.setBackground(new Color(204,204,204));
        bcaridataanak.setForeground(Color.black);
    }//GEN-LAST:event_bcaridataanakMouseExited

    private void bcaridataanakActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bcaridataanakActionPerformed
        Object [] Baris = {"ID ANAK","NAMA ANAK","NIK","TANGGAL LAHIR","GOLONGAN DARAH","JENIS KELAMIN","BERAT BADAN LAHIR","TINGGI BADAN LAHIR"};
            tabmode1 = new DefaultTableModel(null, Baris);
            tabeldataanak.setModel(tabmode1);
            String cari = tcaridataanak.getText();
            tcaridataanak.setText("");
            try {
                String sql = "SELECT id, nama_anak, nik, DATE_FORMAT(tanggallahir, '%d-%m-%Y') AS myDate, golongandarah, kelamin, berat, tinggi FROM tbdataanak "
                            + "WHERE id LIKE '%" + cari + "%' " 
                            + "OR DATE_FORMAT(tanggallahir, '%d-%m-%Y') LIKE '%" + cari + "%' " 
                            + "OR nama_anak LIKE '%" + cari + "%' "
                            + "OR golongandarah LIKE '%" + cari + "%' "
                            + "OR kelamin LIKE '%" + cari + "%' "
                            + "OR nik LIKE '%" + cari + "%' "
                            + "OR berat LIKE '%" + cari + "%' " 
                            + "OR tinggi LIKE '%" + cari + "%' " 
                            + "ORDER BY id";


                java.sql.Statement stat = conn.createStatement();
                ResultSet hasil = stat.executeQuery(sql);
                while (hasil.next()){
                    String a = hasil.getString("id");
                    String b = hasil.getString("nama_anak");
                    String c = hasil.getString("nik");
                    String d = hasil.getString("myDate");
                    String e = hasil.getString("golongandarah");
                    String f = hasil.getString("kelamin");
                    String g = hasil.getString("berat");
                    String h = hasil.getString("tinggi");

                    String[] data={a,b,c,d,e,f,g,h};
                    tabmode1.addRow(data);
                }
            }catch (Exception e){
                }
    }//GEN-LAST:event_bcaridataanakActionPerformed

    private void tabeldataanakMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabeldataanakMouseClicked
        int bar = tabeldataanak.getSelectedRow();
        String a = tabmode1.getValueAt (bar, 0).toString();
        String b = tabmode1.getValueAt (bar, 1).toString();
        String c = tabmode1.getValueAt (bar, 2).toString();
        String d = tabmode1.getValueAt (bar, 3).toString();
        String e = tabmode1.getValueAt (bar, 4).toString();
        String f = tabmode1.getValueAt (bar, 5).toString();
        String g = tabmode1.getValueAt (bar, 6).toString();
        String h = tabmode1.getValueAt (bar, 7).toString();
        
        tidanak.setText(a);
        tnama.setText(b);
        tnik.setText(c);
        tanggal_lahir_anak();
        cbgolongandarah.setSelectedItem(e);
        
        if(f.equals("Laki-Laki")) {rj1.setSelected(true); rj2.setSelected(false);}
        else {rj1.setSelected(false); rj2.setSelected(true);}
        
        String beratAngka = g.replaceAll("[^0-9.,]", "");
        String tinggiAngka = h.replaceAll("[^0-9.,]", "");
        tberatlahir.setText(beratAngka);
        ttinggilahir.setText(tinggiAngka);
    }//GEN-LAST:event_tabeldataanakMouseClicked

    private void rj2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rj2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rj2ActionPerformed

    private void tberatlahirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tberatlahirActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tberatlahirActionPerformed

    private void ttinggilahirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ttinggilahirActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ttinggilahirActionPerformed

    private void tidkunjunganActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tidkunjunganActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tidkunjunganActionPerformed

    private void tabelkunjunganMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelkunjunganMouseClicked
        int bar = tabelkunjungan.getSelectedRow();
        String a = tabmode2.getValueAt (bar, 0).toString();
        String b = tabmode2.getValueAt (bar, 1).toString();
        String c = tabmode2.getValueAt (bar, 2).toString();
        String d = tabmode2.getValueAt (bar, 3).toString();
        String e = tabmode2.getValueAt (bar, 4).toString();
        
        String tanggalString = a;

        Date tanggal = null;
        try {
            tanggal = new SimpleDateFormat("dd-MM-yyyy").parse(tanggalString);
        } catch (ParseException ex) {
            ex.printStackTrace();
        }
        tglkunjungan.setDate(tanggal);
        tidkunjungan.setText(b);
        cbnamaanakkunjungan.setSelectedItem(c);
        tnamaorangtuakunjungan.setText(d);
        String rt = e.replaceAll("[^0-9]", "");
        trt.setText(rt);
    }//GEN-LAST:event_tabelkunjunganMouseClicked

    private void bsimpan2MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bsimpan2MouseEntered
        bsimpan2.setBackground(new Color(0,0,204));
        bsimpan2.setForeground(Color.white);
    }//GEN-LAST:event_bsimpan2MouseEntered

    private void bsimpan2MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bsimpan2MouseExited
        bsimpan2.setBackground(new Color(204,204,204));
        bsimpan2.setForeground(Color.black);
    }//GEN-LAST:event_bsimpan2MouseExited

    private void bsimpan2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bsimpan2ActionPerformed
        String tampilan = "yyyy-MM-dd";
        SimpleDateFormat fm = new SimpleDateFormat(tampilan);
        if (tglkunjungan.getDate() == null) {
        JOptionPane.showMessageDialog(null, "Semua data harus terisi", "Notice !!!", JOptionPane.WARNING_MESSAGE);
        } else {
        String tanggal = String.valueOf(fm.format(tglkunjungan.getDate()));
        if (cbnamaanakkunjungan.getSelectedItem() == null || tnamaorangtuakunjungan.getText().isEmpty() ||
            trt.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Semua data harus terisi", "Notice !!!", JOptionPane.WARNING_MESSAGE);
        } else {
        try{
            String sql = "insert into tbkunjungan values (?,?,?,?,?)";
            PreparedStatement stat = conn.prepareStatement(sql);
            stat.setString(1, tanggal);
            stat.setString(2, tidkunjungan.getText());
            stat.setString(3, cbnamaanakkunjungan.getSelectedItem().toString());
            stat.setString(4, tnamaorangtuakunjungan.getText());
            String rt = "RT " + trt.getText();
            stat.setString(5, rt);
            stat.executeUpdate();
            JOptionPane.showMessageDialog(null, "Data Berhasil Disimpan");
            kosong3();
            datatable3();
            autoNumber3();
            tidkunjungan.setEnabled(false);
        }catch (SQLException e){
            JOptionPane.showMessageDialog(null, "Data Gagal Disimpan"+e);
        }
        }
        }
    }//GEN-LAST:event_bsimpan2ActionPerformed

    private void bubah2MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bubah2MouseEntered
        bubah2.setBackground(new Color(0,0,204));
        bubah2.setForeground(Color.white);
    }//GEN-LAST:event_bubah2MouseEntered

    private void bubah2MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bubah2MouseExited
        bubah2.setBackground(new Color(204,204,204));
        bubah2.setForeground(Color.black);
    }//GEN-LAST:event_bubah2MouseExited

    private void bubah2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bubah2ActionPerformed
        String tampilan = "yyyy-MM-dd";
        SimpleDateFormat fm = new SimpleDateFormat(tampilan);
        String tanggal = String.valueOf(fm.format(tglkunjungan.getDate()));
        try{
            String sql = "update tbkunjungan set tgl=?,nama_anak=?,nama_orangtua=?,rt=? where id=?";
            PreparedStatement stat = conn.prepareStatement(sql);
            stat.setString(1, tanggal);
            stat.setString(2, cbnamaanakkunjungan.getSelectedItem().toString());
            stat.setString(3, tnamaorangtuakunjungan.getText());
            String rt = "RT " + trt.getText();
            stat.setString(4, rt);
            stat.setString(5, tidkunjungan.getText());

            stat.executeUpdate();
            JOptionPane.showMessageDialog(null,"Data Berhasil diubah");
            kosong3();
            datatable3();
            autoNumber3();
        }catch (SQLException e){
            JOptionPane.showMessageDialog(null, "Data Gagal Diubah"+e);
        }
    }//GEN-LAST:event_bubah2ActionPerformed

    private void bhapus2MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bhapus2MouseEntered
        bhapus2.setBackground(new Color(0,0,204));
        bhapus2.setForeground(Color.white);
    }//GEN-LAST:event_bhapus2MouseEntered

    private void bhapus2MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bhapus2MouseExited
        bhapus2.setBackground(new Color(204,204,204));
        bhapus2.setForeground(Color.black);
    }//GEN-LAST:event_bhapus2MouseExited

    private void bhapus2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bhapus2ActionPerformed
        int ok = JOptionPane.showConfirmDialog(null,"hapus","Konfirmasi Dialog", JOptionPane.YES_NO_CANCEL_OPTION);
        if (ok==0){
            String sql="delete from tbkunjungan where id='"+tidkunjungan.getText()+"'";
            try {
                PreparedStatement stat = conn.prepareStatement(sql);
                stat.executeUpdate();
                JOptionPane.showMessageDialog(null, "data berhasil dihapus");
                kosong3();
                datatable3();
                autoNumber3();
            } catch (SQLException e){
                JOptionPane.showMessageDialog(null, "Data gagal dihapus"+e);
            }
        }
    }//GEN-LAST:event_bhapus2ActionPerformed

    private void bbersih2MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bbersih2MouseEntered
        bbersih2.setBackground(new Color(0,0,204));
        bbersih2.setForeground(Color.white);
    }//GEN-LAST:event_bbersih2MouseEntered

    private void bbersih2MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bbersih2MouseExited
        bbersih2.setBackground(new Color(204,204,204));
        bbersih2.setForeground(Color.black);
    }//GEN-LAST:event_bbersih2MouseExited

    private void bbersih2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bbersih2ActionPerformed
        kosong3();
        autoNumber3();
        datatable3();
    }//GEN-LAST:event_bbersih2ActionPerformed

    private void tcarikunjunganActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tcarikunjunganActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tcarikunjunganActionPerformed

    private void bcarikunjunganMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bcarikunjunganMouseEntered
        bcarikunjungan.setBackground(new Color(0,0,204));
        bcarikunjungan.setForeground(Color.white);
    }//GEN-LAST:event_bcarikunjunganMouseEntered

    private void bcarikunjunganMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bcarikunjunganMouseExited
        bcarikunjungan.setBackground(new Color(204,204,204));
        bcarikunjungan.setForeground(Color.black);
    }//GEN-LAST:event_bcarikunjunganMouseExited

    private void bcarikunjunganActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bcarikunjunganActionPerformed
        Object [] Baris = {"TANGGAL KUNJUNGAN","ID KUNJUNGAN","NAMA ANAK","NAMA ORANG TUA/WALI","RT"};
            tabmode2 = new DefaultTableModel(null, Baris);
            tabelkunjungan.setModel(tabmode2);
            String cari = tcarikunjungan.getText();
            tcarikunjungan.setText("");
            try {
                String sql = "SELECT DATE_FORMAT(tgl, '%d-%m-%Y') AS myDate, id, nama_anak, nama_orangtua, rt FROM tbkunjungan "
                            + "WHERE id LIKE '%" + cari + "%' " 
                            + "OR nama_anak LIKE '%" + cari + "%' "
                            + "OR nama_orangtua LIKE '%" + cari + "%' "
                            + "OR rt LIKE '%" + cari + "%' "
                            + "OR DATE_FORMAT(tgl, '%d-%m-%Y') LIKE '%" + cari + "%' "
                            + "ORDER BY id";


                java.sql.Statement stat = conn.createStatement();
                ResultSet hasil = stat.executeQuery(sql);
                while (hasil.next()){
                    String a = hasil.getString("myDate");
                    String b = hasil.getString("id");
                    String c = hasil.getString("nama_anak");
                    String d = hasil.getString("nama_orangtua");
                    String e = hasil.getString("rt");

                    String[] data={a,b,c,d,e};
                    tabmode2.addRow(data);
                }
            }catch (Exception e){
                }
    }//GEN-LAST:event_bcarikunjunganActionPerformed

    private void tidkondisiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tidkondisiActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tidkondisiActionPerformed

    private void tusiaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tusiaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tusiaActionPerformed

    private void tberatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tberatActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tberatActionPerformed

    private void ttinggiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ttinggiActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ttinggiActionPerformed

    private void tabelkondisiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelkondisiMouseClicked
        int bar = tabelkondisi.getSelectedRow();
        String a = tabmode3.getValueAt (bar, 0).toString();
        String b = tabmode3.getValueAt (bar, 1).toString();
        String c = tabmode3.getValueAt (bar, 2).toString();
        String d = tabmode3.getValueAt (bar, 3).toString();
        String e = tabmode3.getValueAt (bar, 4).toString();
        String f = tabmode3.getValueAt (bar, 5).toString();
        String g = tabmode3.getValueAt (bar, 6).toString();
        String h = tabmode3.getValueAt (bar, 7).toString();
        String i = tabmode3.getValueAt (bar, 8).toString();
        String j = tabmode3.getValueAt (bar, 9).toString();
        
        tidkondisi.setText(a);
        cbidkunjungan.setSelectedItem(b);
        tnamaanakkondisi.setText(c);
        cbbidantugas.setSelectedItem(d);
        
        String usiaAngka = e.replaceAll("[^0-9]", "");
        tusia.setText(usiaAngka);
        String lingkarAngka = f.replaceAll("[^0-9.,]", "");
        tlingkar.setText(lingkarAngka);
        String lenganAngka = g.replaceAll("[^0-9.,]", "");
        tlengan.setText(lenganAngka);
        String beratAngka = h.replaceAll("[^0-9.,]", "");
        tberat.setText(beratAngka);
        String tinggiAngka = i.replaceAll("[^0-9.,]", "");
        ttinggi.setText(tinggiAngka);
        tkondisi.setText(j);
        
    }//GEN-LAST:event_tabelkondisiMouseClicked

    private void bsimpan3MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bsimpan3MouseEntered
        bsimpan3.setBackground(new Color(0,0,204));
        bsimpan3.setForeground(Color.white);
    }//GEN-LAST:event_bsimpan3MouseEntered

    private void bsimpan3MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bsimpan3MouseExited
        bsimpan3.setBackground(new Color(204,204,204));
        bsimpan3.setForeground(Color.black);
    }//GEN-LAST:event_bsimpan3MouseExited

    private void bsimpan3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bsimpan3ActionPerformed
        String sql = "insert into tbkondisi values (?,?,?,?,?,?,?,?,?,?)";
        try{
            PreparedStatement stat = conn.prepareStatement(sql);
            if (tidkondisi.getText().isEmpty() || tnamaanakkondisi.getText().isEmpty() || tusia.getText().isEmpty()
                || tlingkar.getText().isEmpty() || tberat.getText().isEmpty() || tlengan.getText().isEmpty()
                || ttinggi.getText().isEmpty())  {
                JOptionPane.showMessageDialog(null, "Semua data harus terisi", "Notice !!!", JOptionPane.WARNING_MESSAGE);
            } else {
                stat.setString(1, tidkondisi.getText());
                stat.setString(2, cbidkunjungan.getSelectedItem().toString());
                stat.setString(3, tnamaanakkondisi.getText());
                stat.setString(4, cbbidantugas.getSelectedItem().toString());
                
                String usiabln = tusia.getText() + " Bulan";
                stat.setString(5, usiabln);
                String lingkarcm = tlingkar.getText() + " CM";
                stat.setString(6, lingkarcm);
                String lengancm = tlengan.getText() + " CM";
                stat.setString(7, lengancm);
                String beratkg = tberat.getText() + " KG";
                stat.setString(8, beratkg);
                String tinggicm = ttinggi.getText() + " CM";
                stat.setString(9, tinggicm);
                stat.setString(10, tkondisi.getText());
                
                stat.executeUpdate();
                JOptionPane.showMessageDialog(null, "Data Berhasil Disimpan");
                kosong4();
                tusia.requestFocus();
                datatable4();
                autoNumber4();
                tidkondisi.setEnabled(false);
            }
        }catch (SQLException e){
            JOptionPane.showMessageDialog(null, "Data Gagal Disimpan"+e);
        }
    }//GEN-LAST:event_bsimpan3ActionPerformed

    private void bubah3MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bubah3MouseEntered
        bubah3.setBackground(new Color(0,0,204));
        bubah3.setForeground(Color.white);
    }//GEN-LAST:event_bubah3MouseEntered

    private void bubah3MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bubah3MouseExited
        bubah3.setBackground(new Color(204,204,204));
        bubah3.setForeground(Color.black);
    }//GEN-LAST:event_bubah3MouseExited

    private void bubah3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bubah3ActionPerformed
        if (tidkondisi.getText().isEmpty() || tnamaanakkondisi.getText().isEmpty() || tusia.getText().isEmpty() ||
            tlingkar.getText().isEmpty() || tberat.getText().isEmpty() || tlengan.getText().isEmpty() ||
            ttinggi.getText().isEmpty())  {
            JOptionPane.showMessageDialog(null, "Semua data harus terisi", "Notice !!!", JOptionPane.WARNING_MESSAGE);
        } else {
            try {
                String sql = "update tbkondisi set idkunjungan=?,nama_anak=?,nama_bidan=?,usia=?,lingkarkepala=?,lingkarlengan=?,berat=?,tinggi=?,kondisi=? where id=?";
                PreparedStatement stat = conn.prepareStatement(sql);
                stat.setString(1, cbidkunjungan.getSelectedItem().toString());
                stat.setString(2, tnamaanakkondisi.getText());
                stat.setString(3, cbbidantugas.getSelectedItem().toString());
                String usiabln = tusia.getText() + " Bulan";
                stat.setString(4, usiabln);
                String lingkarcm = tlingkar.getText() + " CM";
                stat.setString(5, lingkarcm);
                String lengancm = tlengan.getText() + " CM";
                stat.setString(6, lengancm);
                String beratkg = tberat.getText() + " KG";
                stat.setString(7, beratkg);
                String tinggicm = ttinggi.getText() + " CM";
                stat.setString(8, tinggicm);
                stat.setString(9, tkondisi.getText());
                stat.setString(10, tidkondisi.getText());
                stat.executeUpdate();
                JOptionPane.showMessageDialog(null,"Data Berhasil diubah");
                kosong4();
                tusia.requestFocus();
                datatable4();
                autoNumber4();
                tidkondisi.setEnabled(false);
            }catch (SQLException e){
                JOptionPane.showMessageDialog(null, "Data Gagal Diubah"+e);
            }
        }
    }//GEN-LAST:event_bubah3ActionPerformed

    private void bhapus3MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bhapus3MouseEntered
        bhapus3.setBackground(new Color(0,0,204));
        bhapus3.setForeground(Color.white);
    }//GEN-LAST:event_bhapus3MouseEntered

    private void bhapus3MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bhapus3MouseExited
        bhapus3.setBackground(new Color(204,204,204));
        bhapus3.setForeground(Color.black);
    }//GEN-LAST:event_bhapus3MouseExited

    private void bhapus3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bhapus3ActionPerformed
        int ok = JOptionPane.showConfirmDialog(null,"hapus","Konfirmasi Dialog", JOptionPane.YES_NO_CANCEL_OPTION);
        if (ok==0){
            String sql="delete from tbkondisi where id='"+tidkondisi.getText()+"'";
            try {
                PreparedStatement stat = conn.prepareStatement(sql);
                stat.executeUpdate();
                JOptionPane.showMessageDialog(null, "data berhasil dihapus");
                kosong4();
                datatable4();
                autoNumber4();
            } catch (SQLException e){
                JOptionPane.showMessageDialog(null, "Data gagal dihapus"+e);
            }
        }
    }//GEN-LAST:event_bhapus3ActionPerformed

    private void bbersih3MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bbersih3MouseEntered
        bbersih3.setBackground(new Color(0,0,204));
        bbersih3.setForeground(Color.white);
    }//GEN-LAST:event_bbersih3MouseEntered

    private void bbersih3MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bbersih3MouseExited
        bbersih3.setBackground(new Color(204,204,204));
        bbersih3.setForeground(Color.black);
    }//GEN-LAST:event_bbersih3MouseExited

    private void bbersih3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bbersih3ActionPerformed
        kosong4();
        datatable4();
        autoNumber4();
    }//GEN-LAST:event_bbersih3ActionPerformed

    private void tcarikondisiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tcarikondisiActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tcarikondisiActionPerformed

    private void bcarikondisiMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bcarikondisiMouseEntered
        bcarikondisi.setBackground(new Color(0,0,204));
        bcarikondisi.setForeground(Color.white);
    }//GEN-LAST:event_bcarikondisiMouseEntered

    private void bcarikondisiMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bcarikondisiMouseExited
        bcarikondisi.setBackground(new Color(204,204,204));
        bcarikondisi.setForeground(Color.black);
    }//GEN-LAST:event_bcarikondisiMouseExited

    private void bcarikondisiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bcarikondisiActionPerformed
        datatable4();
        tcarikondisi.setText("");
    }//GEN-LAST:event_bcarikondisiActionPerformed

    private void tabeljadwalMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabeljadwalMouseClicked
        int bar = tabeljadwal.getSelectedRow();
        String a = tabmode5.getValueAt (bar, 0).toString();
        String b = tabmode5.getValueAt (bar, 1).toString();
        String c = tabmode5.getValueAt (bar, 2).toString();
        String d = tabmode5.getValueAt (bar, 3).toString();
        String e = tabmode5.getValueAt (bar, 4).toString();
        
        SimpleDateFormat inputFormat = new SimpleDateFormat("EEEE, dd MMM yyyy", new Locale("id"));
        SimpleDateFormat outputFormat = new SimpleDateFormat("dd-MM-yyyy");
        Date tanggal = null;
        try {
            tanggal = inputFormat.parse(d);
        } catch (ParseException ex) {
            ex.printStackTrace();
        }
        String tanggalString = outputFormat.format(tanggal);

        tidjadwal.setText(a);
        cbnamabidanjadwal.setSelectedItem(b);
        tnikjadwal.setText(c);
        jdwl.setDate(tanggal);
        twaktu.setText(e);
    }//GEN-LAST:event_tabeljadwalMouseClicked

    private void bsimpan5MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bsimpan5MouseEntered
        bsimpan5.setBackground(new Color(0,0,204));
        bsimpan5.setForeground(Color.white);
    }//GEN-LAST:event_bsimpan5MouseEntered

    private void bsimpan5MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bsimpan5MouseExited
        bsimpan5.setBackground(new Color(204,204,204));
        bsimpan5.setForeground(Color.black);
    }//GEN-LAST:event_bsimpan5MouseExited

    private void bsimpan5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bsimpan5ActionPerformed
        String tampilan = "EEEE, dd MMMM yyyy";
        SimpleDateFormat fm = new SimpleDateFormat(tampilan, new Locale("id"));
        String tanggal  = String.valueOf(fm.format(jdwl.getDate()));
        String sql = "insert into tbjadwal values (?,?,?,?,?)";
        try{
            PreparedStatement stat = conn.prepareStatement(sql);
            if (tidjadwal.getText().isEmpty() || twaktu.getText().isEmpty()
                || tnikjadwal.getText().isEmpty()){
                JOptionPane.showMessageDialog(null, "Semua data harus terisi", "Notice !!!", JOptionPane.WARNING_MESSAGE);
            } else {
                stat.setString(1, tidjadwal.getText());
                stat.setString(2, cbnamabidanjadwal.getSelectedItem().toString());
                stat.setString(3, tnikjadwal.getText());
                stat.setString(4, tanggal);
                stat.setString(5, twaktu.getText());
                
                stat.executeUpdate();
                JOptionPane.showMessageDialog(null, "Data Berhasil Disimpan");
                kosong6();
                autoNumber6();
                datatable6();
                tidjadwal.setEnabled(false);
            }
        }catch (SQLException e){
            JOptionPane.showMessageDialog(null, "Data Gagal Disimpan"+e);
        }
    }//GEN-LAST:event_bsimpan5ActionPerformed

    private void bubah5MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bubah5MouseEntered
        bubah5.setBackground(new Color(0,0,204));
        bubah5.setForeground(Color.white);
    }//GEN-LAST:event_bubah5MouseEntered

    private void bubah5MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bubah5MouseExited
        bubah5.setBackground(new Color(204,204,204));
        bubah5.setForeground(Color.black);
    }//GEN-LAST:event_bubah5MouseExited

    private void bubah5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bubah5ActionPerformed
        String tampilan = "EEEE, dd MMM yyyy";
        SimpleDateFormat fm = new SimpleDateFormat(tampilan, new Locale("id"));
        String tanggal  = String.valueOf(fm.format(jdwl.getDate()));
        if (tidjadwal.getText().isEmpty() || twaktu.getText().isEmpty()){
                JOptionPane.showMessageDialog(null, "Semua data harus terisi", "Notice !!!", JOptionPane.WARNING_MESSAGE);
        } else {
            try{
                String sql = "update tbjadwal set bidan=?,nik_bidan=?,tanggal=?,waktu=? where id=?";
                PreparedStatement stat = conn.prepareStatement(sql);
                stat.setString(1, cbnamabidanjadwal.getSelectedItem().toString());
                stat.setString(2, tnikjadwal.getText());
                stat.setString(3, tanggal);
                stat.setString(4, twaktu.getText());
                stat.setString(5, tidjadwal.getText());

                stat.executeUpdate();
                JOptionPane.showMessageDialog(null,"Data Berhasil diubah");
                kosong6();
                autoNumber6();
                datatable6();
            }catch (SQLException e){
                JOptionPane.showMessageDialog(null, "Data Gagal Diubah"+e);

            }
        }
    }//GEN-LAST:event_bubah5ActionPerformed

    private void bhapus5MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bhapus5MouseEntered
        bhapus5.setBackground(new Color(0,0,204));
        bhapus5.setForeground(Color.white);
    }//GEN-LAST:event_bhapus5MouseEntered

    private void bhapus5MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bhapus5MouseExited
        bhapus5.setBackground(new Color(204,204,204));
        bhapus5.setForeground(Color.black);
    }//GEN-LAST:event_bhapus5MouseExited

    private void bhapus5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bhapus5ActionPerformed
        int ok = JOptionPane.showConfirmDialog(null,"hapus","Konfirmasi Dialog", JOptionPane.YES_NO_CANCEL_OPTION);
        if (ok==0){
            String sql="delete from tbjadwal where id='"+tidjadwal.getText()+"'";
            try {
                PreparedStatement stat = conn.prepareStatement(sql);
                stat.executeUpdate();
                JOptionPane.showMessageDialog(null, "data berhasil dihapus");
                kosong6();
                datatable6();
                autoNumber6();
            } catch (SQLException e){
                JOptionPane.showMessageDialog(null, "Data gagal dihapus"+e);
            }
        }
    }//GEN-LAST:event_bhapus5ActionPerformed

    private void bbersih5MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bbersih5MouseEntered
        bbersih5.setBackground(new Color(0,0,204));
        bbersih5.setForeground(Color.white);
    }//GEN-LAST:event_bbersih5MouseEntered

    private void bbersih5MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bbersih5MouseExited
        bbersih5.setBackground(new Color(204,204,204));
        bbersih5.setForeground(Color.black);
    }//GEN-LAST:event_bbersih5MouseExited

    private void bbersih5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bbersih5ActionPerformed
        kosong6();
        autoNumber6();
        datatable6();
    }//GEN-LAST:event_bbersih5ActionPerformed

    private void twaktuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_twaktuActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_twaktuActionPerformed

    private void tidjadwalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tidjadwalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tidjadwalActionPerformed

    private void tberatlahirKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tberatlahirKeyTyped
        char number = evt.getKeyChar();
        if (!(Character.isDigit(number) || number == KeyEvent.VK_BACK_SPACE || number == KeyEvent.VK_DELETE 
        || number == '.' || number == ',')){
        evt.consume();
        }
    }//GEN-LAST:event_tberatlahirKeyTyped

    private void ttinggilahirKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_ttinggilahirKeyTyped
        char number = evt.getKeyChar();
        if (!(Character.isDigit(number) || number == KeyEvent.VK_BACK_SPACE || number == KeyEvent.VK_DELETE 
        || number == '.' || number == ',')){
        evt.consume();
        }
    }//GEN-LAST:event_ttinggilahirKeyTyped

    private void tusiaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tusiaKeyTyped
        char number = evt.getKeyChar();
        if (!(Character.isDigit(number) || number == KeyEvent.VK_BACK_SPACE || number == KeyEvent.VK_DELETE)){
            evt.consume();
        }
    }//GEN-LAST:event_tusiaKeyTyped

    private void tberatKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tberatKeyTyped
        char number = evt.getKeyChar();
        if (!(Character.isDigit(number) || number == KeyEvent.VK_BACK_SPACE || number == KeyEvent.VK_DELETE 
        || number == '.' || number == ',')){
        evt.consume();
        }
    }//GEN-LAST:event_tberatKeyTyped

    private void ttinggiKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_ttinggiKeyTyped
        char number = evt.getKeyChar();
        if (!(Character.isDigit(number) || number == KeyEvent.VK_BACK_SPACE || number == KeyEvent.VK_DELETE 
        || number == '.' || number == ',')){
        evt.consume();
        }
    }//GEN-LAST:event_ttinggiKeyTyped

    private void tnamaorangtuakunjunganActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tnamaorangtuakunjunganActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tnamaorangtuakunjunganActionPerformed

    private void trtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_trtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_trtActionPerformed

    private void trtKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_trtKeyTyped
        char number = evt.getKeyChar();
        if (!(Character.isDigit(number) || number == KeyEvent.VK_BACK_SPACE || number == KeyEvent.VK_DELETE)){
            evt.consume();
        }
    }//GEN-LAST:event_trtKeyTyped
    // panel drag atau pindah2
    private int xMouse,yMouse;
    private void formMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMousePressed
        xMouse=evt.getX();
        yMouse=evt.getY();
    }//GEN-LAST:event_formMousePressed

    private void formMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseDragged
        int x=evt.getXOnScreen();
        int y=evt.getYOnScreen();
        setLocation(x-xMouse,y-yMouse);
    }//GEN-LAST:event_formMouseDragged

    private void bcetak6MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bcetak6MouseEntered
        bcetak6.setBackground(new Color(0,0,204));
        bcetak6.setForeground(Color.white);
    }//GEN-LAST:event_bcetak6MouseEntered

    private void bcetak6MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bcetak6MouseExited
        bcetak6.setBackground(new Color(204,204,204));
        bcetak6.setForeground(Color.black);
    }//GEN-LAST:event_bcetak6MouseExited

    private void bcetak6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bcetak6ActionPerformed
        try {
            String namaFile = "src/Report/Rjadwaltugas.jasper";
            Connection conn = new koneksi().connect();
            HashMap parameter = new HashMap();
            File report_file = new File(namaFile);
            JasperReport jasperReport = (JasperReport) JRLoader.loadObject(report_file.getPath());
            JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameter, conn);
            JasperViewer.viewReport(jasperPrint, false); //coba
            JasperViewer.setDefaultLookAndFeelDecorated(true);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,e.getMessage());
        }
    }//GEN-LAST:event_bcetak6ActionPerformed

    private void bcetak4MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bcetak4MouseEntered
        bcetak4.setBackground(new Color(0,0,204));
        bcetak4.setForeground(Color.white);
    }//GEN-LAST:event_bcetak4MouseEntered

    private void bcetak4MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bcetak4MouseExited
        bcetak4.setBackground(new Color(204,204,204));
        bcetak4.setForeground(Color.black);
    }//GEN-LAST:event_bcetak4MouseExited

    private void bcetak4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bcetak4ActionPerformed
        try {
            String namaFile = "src/Report/NewRkondisianak.jasper";
            Connection conn = new koneksi().connect();
            HashMap parameter = new HashMap();
            File report_file = new File(namaFile);
            JasperReport jasperReport = (JasperReport) JRLoader.loadObject(report_file.getPath());
            JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameter, conn);
            JasperViewer.viewReport(jasperPrint, false); //coba
            JasperViewer.setDefaultLookAndFeelDecorated(true);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,e.getMessage());
        }
    }//GEN-LAST:event_bcetak4ActionPerformed

    private void bcetak3MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bcetak3MouseEntered
        bcetak3.setBackground(new Color(0,0,204));
        bcetak3.setForeground(Color.white);
    }//GEN-LAST:event_bcetak3MouseEntered

    private void bcetak3MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bcetak3MouseExited
        bcetak3.setBackground(new Color(204,204,204));
        bcetak3.setForeground(Color.black);
    }//GEN-LAST:event_bcetak3MouseExited

    private void bcetak3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bcetak3ActionPerformed
        ReportKunjungan laporan = new ReportKunjungan();
        laporan.setVisible(true);
    }//GEN-LAST:event_bcetak3ActionPerformed

    private void bcetak2MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bcetak2MouseEntered
        bcetak2.setBackground(new Color(0,0,204));
        bcetak2.setForeground(Color.white);
    }//GEN-LAST:event_bcetak2MouseEntered

    private void bcetak2MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bcetak2MouseExited
        bcetak2.setBackground(new Color(204,204,204));
        bcetak2.setForeground(Color.black);
    }//GEN-LAST:event_bcetak2MouseExited

    private void bcetak2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bcetak2ActionPerformed
        try {
            String namaFile = "src/Report/Rdataanak.jasper";
            Connection conn = new koneksi().connect();
            HashMap parameter = new HashMap();
            File report_file = new File(namaFile);
            JasperReport jasperReport = (JasperReport) JRLoader.loadObject(report_file.getPath());
            JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameter, conn);
            JasperViewer.viewReport(jasperPrint, false); //coba
            JasperViewer.setDefaultLookAndFeelDecorated(true);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,e.getMessage());
        }
    }//GEN-LAST:event_bcetak2ActionPerformed

    private void cbidkunjunganActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbidkunjunganActionPerformed
        cbidkunjungan();
    }//GEN-LAST:event_cbidkunjunganActionPerformed

    private void tnamaanakkondisiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tnamaanakkondisiActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tnamaanakkondisiActionPerformed

    private void tlingkarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tlingkarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tlingkarActionPerformed

    private void tlingkarKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tlingkarKeyTyped
        char number = evt.getKeyChar();
        if (!(Character.isDigit(number) || number == KeyEvent.VK_BACK_SPACE || number == KeyEvent.VK_DELETE 
        || number == '.' || number == ',')){
        evt.consume();
        }
    }//GEN-LAST:event_tlingkarKeyTyped

    private void tnikKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tnikKeyTyped
        char number = evt.getKeyChar();
        if (!(Character.isDigit(number) || number == KeyEvent.VK_BACK_SPACE || number == KeyEvent.VK_DELETE)){
            evt.consume();
        }
    }//GEN-LAST:event_tnikKeyTyped

    private void tlenganActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tlenganActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tlenganActionPerformed

    private void tlenganKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tlenganKeyTyped
        char number = evt.getKeyChar();
        if (!(Character.isDigit(number) || number == KeyEvent.VK_BACK_SPACE || number == KeyEvent.VK_DELETE 
        || number == '.' || number == ',')){
        evt.consume();
        }
    }//GEN-LAST:event_tlenganKeyTyped

    private void bbidanMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bbidanMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_bbidanMouseEntered

    private void bbidanMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bbidanMouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_bbidanMouseExited

    private void bbidanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bbidanActionPerformed
        panelmain.removeAll();
        panelmain.repaint();
        panelmain.revalidate();
        //add panel
        panelmain.add(panelbidan);
        panelmain.repaint();
        panelmain.revalidate();
    }//GEN-LAST:event_bbidanActionPerformed

    private void tidbidanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tidbidanActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tidbidanActionPerformed

    private void tnamabidanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tnamabidanActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tnamabidanActionPerformed

    private void talamatbidanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_talamatbidanActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_talamatbidanActionPerformed

    private void tabelbidanMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelbidanMouseClicked
        int bar = tabelbidan.getSelectedRow();
        String a = tabmode6.getValueAt (bar, 0).toString();
        String b = tabmode6.getValueAt (bar, 1).toString();
        String c = tabmode6.getValueAt (bar, 2).toString();
        String d = tabmode6.getValueAt (bar, 3).toString();
        String e = tabmode6.getValueAt (bar, 4).toString();
        
        tidbidan.setText(a);
        tnikbidan.setText(b);
        tnamabidan.setText(c);
        talamatbidan.setText(d);
        tnohpbidan.setText(e);
    }//GEN-LAST:event_tabelbidanMouseClicked

    private void bsimpan6MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bsimpan6MouseEntered
        bsimpan6.setBackground(new Color(0,0,204));
        bsimpan6.setForeground(Color.white);
    }//GEN-LAST:event_bsimpan6MouseEntered

    private void bsimpan6MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bsimpan6MouseExited
        bsimpan6.setBackground(new Color(204,204,204));
        bsimpan6.setForeground(Color.black);
    }//GEN-LAST:event_bsimpan6MouseExited

    private void bsimpan6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bsimpan6ActionPerformed
        String sql = "insert into tbbidan values (?,?,?,?,?)";
        try{
            PreparedStatement stat = conn.prepareStatement(sql);
            if (tnohpbidan.getText().isEmpty() || tnamabidan.getText().isEmpty()
               || tnikbidan.getText().isEmpty() || talamatbidan.getText().isEmpty()){
                JOptionPane.showMessageDialog(null, "Semua data harus terisi", "Notice !!!", JOptionPane.WARNING_MESSAGE);
            } else {
                stat.setString(1, tidbidan.getText());
                stat.setString(2, tnikbidan.getText());
                stat.setString(3, tnamabidan.getText());
                stat.setString(4, talamatbidan.getText());
                stat.setString(5, tnohpbidan.getText());
                
                stat.executeUpdate();
                JOptionPane.showMessageDialog(null, "Data Berhasil Disimpan");
                kosong7();
                autoNumber7();
                tnikbidan.requestFocus();
                datatable7();
                tidbidan.setEnabled(false);
            }
        }catch (SQLException e){
            JOptionPane.showMessageDialog(null, "Data Gagal Disimpan"+e);
        }
    }//GEN-LAST:event_bsimpan6ActionPerformed

    private void bubah6MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bubah6MouseEntered
        bubah6.setBackground(new Color(0,0,204));
        bubah6.setForeground(Color.white);
    }//GEN-LAST:event_bubah6MouseEntered

    private void bubah6MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bubah6MouseExited
        bubah6.setBackground(new Color(204,204,204));
        bubah6.setForeground(Color.black);
    }//GEN-LAST:event_bubah6MouseExited

    private void bubah6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bubah6ActionPerformed
        if (tnamabidan.getText().isEmpty() || talamatbidan.getText().isEmpty()
                || tnikbidan.getText().isEmpty() || tnohpbidan.getText().isEmpty()){
                JOptionPane.showMessageDialog(null, "Semua data harus terisi", "Notice !!!", JOptionPane.WARNING_MESSAGE);
        } else {
            try{
                String sql = "update tbbidan set nik_bidan=?,nama_bidan=?,alamat=?,telp=? where id=?";
                PreparedStatement stat = conn.prepareStatement(sql);
                stat.setString(1, tnikbidan.getText());
                stat.setString(2, tnamabidan.getText());
                stat.setString(3, talamatbidan.getText());
                stat.setString(4, tnohpbidan.getText());
                stat.setString(5, tidbidan.getText());

                stat.executeUpdate();
                JOptionPane.showMessageDialog(null,"Data Berhasil diubah");
                kosong7();
                autoNumber7();
                datatable7();
            }catch (SQLException e){
                JOptionPane.showMessageDialog(null, "Data Gagal Diubah"+e);

            }
        }
    }//GEN-LAST:event_bubah6ActionPerformed

    private void bhapus6MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bhapus6MouseEntered
        bhapus6.setBackground(new Color(0,0,204));
        bhapus6.setForeground(Color.white);
    }//GEN-LAST:event_bhapus6MouseEntered

    private void bhapus6MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bhapus6MouseExited
        bhapus6.setBackground(new Color(204,204,204));
        bhapus6.setForeground(Color.black);
    }//GEN-LAST:event_bhapus6MouseExited

    private void bhapus6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bhapus6ActionPerformed
        int ok = JOptionPane.showConfirmDialog(null,"hapus","Konfirmasi Dialog", JOptionPane.YES_NO_CANCEL_OPTION);
        if (ok==0){
            String sql="delete from tbbidan where id='"+tidbidan.getText()+"'";
            try {
                PreparedStatement stat = conn.prepareStatement(sql);
                stat.executeUpdate();
                JOptionPane.showMessageDialog(null, "data berhasil dihapus");
                kosong7();
                datatable7();
                autoNumber7();
            } catch (SQLException e){
                JOptionPane.showMessageDialog(null, "Data gagal dihapus"+e);
            }
        }
    }//GEN-LAST:event_bhapus6ActionPerformed

    private void bbersih6MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bbersih6MouseEntered
        bbersih6.setBackground(new Color(0,0,204));
        bbersih6.setForeground(Color.white);
    }//GEN-LAST:event_bbersih6MouseEntered

    private void bbersih6MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bbersih6MouseExited
        bbersih6.setBackground(new Color(204,204,204));
        bbersih6.setForeground(Color.black);
    }//GEN-LAST:event_bbersih6MouseExited

    private void bbersih6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bbersih6ActionPerformed
        kosong7();
    }//GEN-LAST:event_bbersih6ActionPerformed

    private void tnohpbidanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tnohpbidanActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tnohpbidanActionPerformed

    private void tnohpbidanKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tnohpbidanKeyTyped
        char number = evt.getKeyChar();
        if (!(Character.isDigit(number) || number == KeyEvent.VK_BACK_SPACE || number == KeyEvent.VK_DELETE)){
            evt.consume();
        }
    }//GEN-LAST:event_tnohpbidanKeyTyped

    private void bcetak7MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bcetak7MouseEntered
        bcetak7.setBackground(new Color(0,0,204));
        bcetak7.setForeground(Color.white);
    }//GEN-LAST:event_bcetak7MouseEntered

    private void bcetak7MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bcetak7MouseExited
        bcetak7.setBackground(new Color(204,204,204));
        bcetak7.setForeground(Color.black);
    }//GEN-LAST:event_bcetak7MouseExited

    private void bcetak7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bcetak7ActionPerformed
        try {
            String namaFile = "src/Report/Rbidan.jasper";
            Connection conn = new koneksi().connect();
            HashMap parameter = new HashMap();
            File report_file = new File(namaFile);
            JasperReport jasperReport = (JasperReport) JRLoader.loadObject(report_file.getPath());
            JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameter, conn);
            JasperViewer.viewReport(jasperPrint, false); //coba
            JasperViewer.setDefaultLookAndFeelDecorated(true);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,e.getMessage());
        }
    }//GEN-LAST:event_bcetak7ActionPerformed

    private void tnamaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tnamaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tnamaActionPerformed

    private void tnamaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tnamaKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_tnamaKeyTyped

    private void tnikbidanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tnikbidanActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tnikbidanActionPerformed

    private void tnikjadwalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tnikjadwalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tnikjadwalActionPerformed

    private void tusiaanakActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tusiaanakActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tusiaanakActionPerformed

    private void tnikanakpendaftaranActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tnikanakpendaftaranActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tnikanakpendaftaranActionPerformed

    private void bcetak1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bcetak1ActionPerformed
        ReportPendaftaran laporan = new ReportPendaftaran();
        laporan.setVisible(true);
    }//GEN-LAST:event_bcetak1ActionPerformed

    private void bcetak1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bcetak1MouseExited
        bcetak1.setBackground(new Color(204,204,204));
        bcetak1.setForeground(Color.black);
    }//GEN-LAST:event_bcetak1MouseExited

    private void bcetak1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bcetak1MouseEntered
        bcetak1.setBackground(new Color(0,0,204));
        bcetak1.setForeground(Color.white);
    }//GEN-LAST:event_bcetak1MouseEntered

    private void bcaripendaftaranActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bcaripendaftaranActionPerformed
        Object [] Baris = {"TANGGAL","ID PENDAFTARAN","NIK ANAK","NAMA ANAK","USIA ANAK","IMUNISASI","VITAMIN","NAMA ORANG TUA","NO HP","ALAMAT","JENIS KB"};
        tabmode = new DefaultTableModel(null, Baris);
        tabelpendaftaran.setModel(tabmode);
        String cari = tcaripendaftaran.getText();
        tcaripendaftaran.setText("");
        try {
            String sql = "SELECT DATE_FORMAT(tgl, '%d-%m-%Y') AS myDate, id, nik_anak, nama_anak, usia, imunisasi, vitamin, nama_orangtua, nohp, jenis_kb FROM tbpendaftaran "
            + "WHERE id LIKE '%" + cari + "%' "
            + "OR DATE_FORMAT(tgl, '%d-%m-%Y') LIKE '%" + cari + "%' "
            + "OR nik_anak LIKE '%" + cari + "%' "
            + "OR nama_anak LIKE '%" + cari + "%' "
            + "OR nama_orangtua LIKE '%" + cari + "%' "
            + "OR usia LIKE '%" + cari + "%' "
            + "OR imunisasi LIKE '%" + cari + "%' "
            + "OR vitamin LIKE '%" + cari + "%' "
            + "OR nohp LIKE '%" + cari + "%' "
            + "OR alamat LIKE '%" + cari + "%' "
            + "OR jenis_kb LIKE '%" + cari + "%' "
            + "ORDER BY id";

            java.sql.Statement stat = conn.createStatement();
            ResultSet hasil = stat.executeQuery(sql);
            while (hasil.next()){
            String a = hasil.getString("myDate");
            String b = hasil.getString("id");
            String c = hasil.getString("nik_anak");
            String d = hasil.getString("nama_anak");
            String e = hasil.getString("usia");
            String f = hasil.getString("imunisasi");
            String g = hasil.getString("vitamin");
            String h = hasil.getString("nama_orangtua");
            String i = hasil.getString("nohp");
            String j = hasil.getString("alamat");
            String k = hasil.getString("jenis_kb");
            
            String[] data={a,b,c,d,e,f,g,h,i,j,k};
            tabmode.addRow(data);
        }
        }catch (Exception e){
        }
    }//GEN-LAST:event_bcaripendaftaranActionPerformed

    private void bcaripendaftaranMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bcaripendaftaranMouseExited
        bcaripendaftaran.setBackground(new Color(204,204,204));
        bcaripendaftaran.setForeground(Color.black);
    }//GEN-LAST:event_bcaripendaftaranMouseExited

    private void bcaripendaftaranMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bcaripendaftaranMouseEntered
        bcaripendaftaran.setBackground(new Color(0,0,204));
        bcaripendaftaran.setForeground(Color.white);
    }//GEN-LAST:event_bcaripendaftaranMouseEntered

    private void tcaripendaftaranActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tcaripendaftaranActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tcaripendaftaranActionPerformed

    private void bbersihActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bbersihActionPerformed
        // TODO add your handling code here:
        kosong1();
        datatable1();
        autoNumber1();
    }//GEN-LAST:event_bbersihActionPerformed

    private void bbersihMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bbersihMouseExited
        // TODO add your handling code here:
        bbersih.setBackground(new Color(204,204,204));
        bbersih.setForeground(Color.black);
    }//GEN-LAST:event_bbersihMouseExited

    private void bbersihMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bbersihMouseEntered
        // TODO add your handling code here:
        bbersih.setBackground(new Color(0,0,204));
        bbersih.setForeground(Color.white);
    }//GEN-LAST:event_bbersihMouseEntered

    private void bhapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bhapusActionPerformed
        // TODO add your handling code here:
        int ok = JOptionPane.showConfirmDialog(null,"hapus","Konfirmasi Dialog", JOptionPane.YES_NO_CANCEL_OPTION);
        if (ok==0){
            String sql="delete from tbpendaftaran where id='"+tidpendaftaran.getText()+"'";
            try {
                PreparedStatement stat = conn.prepareStatement(sql);
                stat.executeUpdate();
                JOptionPane.showMessageDialog(null, "data berhasil dihapus");
                kosong1();
                tnamaanak.requestFocus();
                datatable1();
                autoNumber1();
            }catch (SQLException e){
                JOptionPane.showMessageDialog(null, "Data gagal dihapus"+e);
            }
        }
    }//GEN-LAST:event_bhapusActionPerformed

    private void bhapusMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bhapusMouseExited
        // TODO add your handling code here:
        bhapus.setBackground(new Color(204,204,204));
        bhapus.setForeground(Color.black);
    }//GEN-LAST:event_bhapusMouseExited

    private void bhapusMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bhapusMouseEntered
        // TODO add your handling code here:
        bhapus.setBackground(Color.red);
        bhapus.setForeground(Color.white);
    }//GEN-LAST:event_bhapusMouseEntered

    private void bubahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bubahActionPerformed
        try{
            String sql = "update tbpendaftaran set nik_anak=?,nama_anak=?,usia=?,imunisasi=?,vitamin=?,nama_orangtua=?,nohp=?,alamat=?,jenis_kb=? where id=?";
            PreparedStatement stat = conn.prepareStatement(sql);
            if (tnamaanak.getText().isEmpty() || tnamaorangtua.getText().isEmpty()
                || tnohp.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Semua data harus terisi", "Notice !!!", JOptionPane.WARNING_MESSAGE);
            } else {
                stat.setString(1, tnikanakpendaftaran.getText());
                stat.setString(2, tnamaanak.getText());
                String bulan = tusiaanak.getText() + " Bulan";
                stat.setString(3, bulan);
                stat.setString(4, cbimunisasi.getSelectedItem().toString());
                stat.setString(5, cbvitamin.getSelectedItem().toString());
                stat.setString(6, tnamaorangtua.getText());
                stat.setString(7, tnohp.getText());
                stat.setString(8, talamat.getText());
                stat.setString(9, cbjeniskb.getSelectedItem().toString());

                stat.setString(10, tidpendaftaran.getText());

                stat.executeUpdate();
                JOptionPane.showMessageDialog(null,"Data Berhasil diubah");
                kosong1();
                tnamaanak.requestFocus();
                datatable1();
                autoNumber1();
            }
        }catch (SQLException e){
            JOptionPane.showMessageDialog(null, "Data Gagal Diubah"+e);
        }
    }//GEN-LAST:event_bubahActionPerformed

    private void bubahMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bubahMouseExited
        // TODO add your handling code here:
        bubah.setBackground(new Color(204,204,204));
        bubah.setForeground(Color.black);
    }//GEN-LAST:event_bubahMouseExited

    private void bubahMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bubahMouseEntered
        // TODO add your handling code here:
        bubah.setBackground(new Color(0,0,204));
        bubah.setForeground(Color.white);
    }//GEN-LAST:event_bubahMouseEntered

    private void bsimpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bsimpanActionPerformed
        String sql = "insert into tbpendaftaran values (?,?,?,?,?,?,?,?,?,?,?)";
        try{
            String dateString = tgl.getText();
            DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
            Date date = dateFormat.parse(dateString);
            PreparedStatement stat = conn.prepareStatement(sql);
            if (tidpendaftaran.getText().isEmpty() || tnamaanak.getText().isEmpty() || tnamaorangtua.getText().isEmpty()
                || talamat.getText().isEmpty() || tnohp.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Semua data harus terisi", "Notice !!!", JOptionPane.WARNING_MESSAGE);
            } else {
                stat.setDate(1, new java.sql.Date(date.getTime()));
                stat.setString(2, tidpendaftaran.getText());
                stat.setString(3, tnikanakpendaftaran.getText());
                stat.setString(4, tnamaanak.getText());
                String bulan = tusiaanak.getText() + " Bulan";
                stat.setString(5, bulan);
                stat.setString(6, cbimunisasi.getSelectedItem().toString());
                stat.setString(7, cbvitamin.getSelectedItem().toString());
                stat.setString(8, tnamaorangtua.getText());
                stat.setString(9, tnohp.getText());
                stat.setString(10, talamat.getText());
                stat.setString(11, cbjeniskb.getSelectedItem().toString());
                stat.executeUpdate();
                JOptionPane.showMessageDialog(null, "Data Berhasil Disimpan");
                kosong1();
                tnikanakpendaftaran.requestFocus();
                datatable1();
                autoNumber1();
                tidpendaftaran.setEnabled(false);
            }
        }catch (SQLException | ParseException e){
            JOptionPane.showMessageDialog(null, "Data Gagal Disimpan"+e);
        }
    }//GEN-LAST:event_bsimpanActionPerformed

    private void bsimpanMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bsimpanMouseExited
        bsimpan.setBackground(new Color(204,204,204));
        bsimpan.setForeground(Color.black);
    }//GEN-LAST:event_bsimpanMouseExited

    private void bsimpanMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bsimpanMouseEntered
        bsimpan.setBackground(new Color(0,0,204));
        bsimpan.setForeground(Color.white);
    }//GEN-LAST:event_bsimpanMouseEntered

    private void tnohpKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tnohpKeyTyped
        char number = evt.getKeyChar();
        if (!(Character.isDigit(number) || number == KeyEvent.VK_BACK_SPACE || number == KeyEvent.VK_DELETE)){
            evt.consume();
        }
    }//GEN-LAST:event_tnohpKeyTyped

    private void tnohpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tnohpActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tnohpActionPerformed

    private void tnamaorangtuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tnamaorangtuaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tnamaorangtuaActionPerformed

    private void tnamaanakActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tnamaanakActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tnamaanakActionPerformed

    private void tidpendaftaranActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tidpendaftaranActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tidpendaftaranActionPerformed

    private void tabelpendaftaranMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelpendaftaranMouseClicked
        int bar = tabelpendaftaran.getSelectedRow();
        String a = tabmode.getValueAt (bar, 1).toString();
        String b = tabmode.getValueAt (bar, 2).toString();
        String c = tabmode.getValueAt (bar, 3).toString();
        String d = tabmode.getValueAt (bar, 4).toString();
        String e = tabmode.getValueAt (bar, 5).toString();
        String f = tabmode.getValueAt (bar, 6).toString();
        String g = tabmode.getValueAt (bar, 7).toString();
        String h = tabmode.getValueAt (bar, 8).toString();
        String i = tabmode.getValueAt (bar, 9).toString();
        String j = tabmode.getValueAt (bar, 10).toString();

        tidpendaftaran.setText(a);
        tnikanakpendaftaran.setText(b);
        tnamaanak.setText(c);
        String bulan = d.replaceAll("[^0-9]", "");
        tusiaanak.setText(bulan);
        cbimunisasi.setSelectedItem(e);
        cbvitamin.setSelectedItem(f);
        tnamaorangtua.setText(g);
        tnohp.setText(h);
        talamat.setText(i);
        cbjeniskb.setSelectedItem(j);
    }//GEN-LAST:event_tabelpendaftaranMouseClicked

    private void tnikbidanKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tnikbidanKeyTyped
        char number = evt.getKeyChar();
        if (!(Character.isDigit(number) || number == KeyEvent.VK_BACK_SPACE || number == KeyEvent.VK_DELETE)){
            evt.consume();
        }
    }//GEN-LAST:event_tnikbidanKeyTyped

    private void tnikjadwalKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tnikjadwalKeyTyped
        char number = evt.getKeyChar();
        if (!(Character.isDigit(number) || number == KeyEvent.VK_BACK_SPACE || number == KeyEvent.VK_DELETE)){
            evt.consume();
        }
    }//GEN-LAST:event_tnikjadwalKeyTyped

    private void tnikjadwalKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tnikjadwalKeyPressed
        
    }//GEN-LAST:event_tnikjadwalKeyPressed

    private void cbnamabidanjadwalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbnamabidanjadwalActionPerformed
        cbnamabidan();
    }//GEN-LAST:event_cbnamabidanjadwalActionPerformed

    private void tnikanakpendaftaranKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tnikanakpendaftaranKeyPressed
        String sql = "select * from tbdataanak where nik = '"+tnikanakpendaftaran.getText()+"'";
        try{
            java.sql.Statement stat = conn.createStatement();
            ResultSet hasil = stat.executeQuery(sql);
            while(hasil.next()){
                String nama = hasil.getString("nama_anak");
                tnamaanak.setText(nama);
            }
        } catch (Exception e) {}
    }//GEN-LAST:event_tnikanakpendaftaranKeyPressed

    private void tnikanakpendaftaranKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tnikanakpendaftaranKeyTyped
        char number = evt.getKeyChar();
        if (!(Character.isDigit(number) || number == KeyEvent.VK_BACK_SPACE || number == KeyEvent.VK_DELETE)){
            evt.consume();
        }
    }//GEN-LAST:event_tnikanakpendaftaranKeyTyped

    private void tusiaanakKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tusiaanakKeyTyped
        char number = evt.getKeyChar();
        if (!(Character.isDigit(number) || number == KeyEvent.VK_BACK_SPACE || number == KeyEvent.VK_DELETE)){
            evt.consume();
        }
    }//GEN-LAST:event_tusiaanakKeyTyped

    private void talamatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_talamatActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_talamatActionPerformed

    private void talamatKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_talamatKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_talamatKeyTyped
    
     /**
     * @param args the command line arguments
     */
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
            java.util.logging.Logger.getLogger(mainmenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(mainmenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(mainmenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(mainmenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new mainmenu().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bbersih;
    private javax.swing.JButton bbersih1;
    private javax.swing.JButton bbersih2;
    private javax.swing.JButton bbersih3;
    private javax.swing.JButton bbersih5;
    private javax.swing.JButton bbersih6;
    private javax.swing.JButton bbidan;
    private javax.swing.JButton bcaridataanak;
    private javax.swing.JButton bcarikondisi;
    private javax.swing.JButton bcarikunjungan;
    private javax.swing.JButton bcaripendaftaran;
    private javax.swing.JButton bcetak1;
    private javax.swing.JButton bcetak2;
    private javax.swing.JButton bcetak3;
    private javax.swing.JButton bcetak4;
    private javax.swing.JButton bcetak6;
    private javax.swing.JButton bcetak7;
    private javax.swing.JButton bdasboard;
    private javax.swing.JButton bdataanak;
    private javax.swing.JButton bhapus;
    private javax.swing.JButton bhapus1;
    private javax.swing.JButton bhapus2;
    private javax.swing.JButton bhapus3;
    private javax.swing.JButton bhapus5;
    private javax.swing.JButton bhapus6;
    private javax.swing.JButton bjadwal;
    private javax.swing.JButton bkeluar;
    private javax.swing.JButton bkondisi;
    private javax.swing.JButton bkunjungan;
    private javax.swing.JButton bpendaftaran;
    private javax.swing.JButton bsimpan;
    private javax.swing.JButton bsimpan1;
    private javax.swing.JButton bsimpan2;
    private javax.swing.JButton bsimpan3;
    private javax.swing.JButton bsimpan5;
    private javax.swing.JButton bsimpan6;
    private javax.swing.JButton bubah;
    private javax.swing.JButton bubah1;
    private javax.swing.JButton bubah2;
    private javax.swing.JButton bubah3;
    private javax.swing.JButton bubah5;
    private javax.swing.JButton bubah6;
    private javax.swing.JComboBox<String> cbbidantugas;
    private javax.swing.JComboBox<String> cbgolongandarah;
    private javax.swing.JComboBox<String> cbidkunjungan;
    private javax.swing.JComboBox<String> cbimunisasi;
    private javax.swing.JComboBox<String> cbjeniskb;
    private javax.swing.JComboBox<String> cbnamaanakkunjungan;
    private javax.swing.JComboBox<String> cbnamabidanjadwal;
    private javax.swing.JComboBox<String> cbvitamin;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private com.toedter.calendar.JDateChooser jdwl;
    private javax.swing.JLabel judul1;
    private javax.swing.JLabel judul2;
    private javax.swing.JLabel labelaja1;
    private javax.swing.JLabel labelaja2;
    private javax.swing.JLabel labelee;
    private javax.swing.JLabel labelee1;
    private javax.swing.JLabel labelee2;
    private javax.swing.JLabel labelee3;
    private javax.swing.JLabel labelee4;
    private javax.swing.JLabel labelee5;
    private javax.swing.JLabel labelee6;
    private javax.swing.JLabel labelgih;
    private javax.swing.JLabel labelgih1;
    private javax.swing.JLabel labelgih2;
    private javax.swing.JLabel labelgih3;
    private javax.swing.JLabel labelgih4;
    private javax.swing.JLabel labelgih5;
    private javax.swing.JLabel labelgih6;
    private javax.swing.JLabel labelid;
    private javax.swing.JLabel labelid1;
    private javax.swing.JLabel labelid2;
    private javax.swing.JLabel labelid3;
    private javax.swing.JLabel labelid7;
    private javax.swing.JLabel labelid8;
    private javax.swing.JLabel labeljk;
    private javax.swing.JLabel labelnama;
    private javax.swing.JLabel labelnama1;
    private javax.swing.JLabel labelnama10;
    private javax.swing.JLabel labelnama11;
    private javax.swing.JLabel labelnama2;
    private javax.swing.JLabel labelnama3;
    private javax.swing.JLabel labelnama4;
    private javax.swing.JLabel labelnama5;
    private javax.swing.JLabel labelnama6;
    private javax.swing.JLabel labelnama7;
    private javax.swing.JLabel labelnama8;
    private javax.swing.JLabel labelnama9;
    private javax.swing.JLabel labelu;
    private javax.swing.JLabel labelu1;
    private javax.swing.JLabel labelu10;
    private javax.swing.JLabel labelu11;
    private javax.swing.JLabel labelu12;
    private javax.swing.JLabel labelu13;
    private javax.swing.JLabel labelu14;
    private javax.swing.JLabel labelu15;
    private javax.swing.JLabel labelu16;
    private javax.swing.JLabel labelu2;
    private javax.swing.JLabel labelu3;
    private javax.swing.JLabel labelu4;
    private javax.swing.JLabel labelu5;
    private javax.swing.JLabel labelu6;
    private javax.swing.JLabel labelu7;
    private javax.swing.JLabel labelu9;
    private javax.swing.JLabel logo;
    private javax.swing.JPanel panelbidan;
    private javax.swing.JPanel paneldasboard;
    private javax.swing.JPanel paneldataanak;
    private javax.swing.JPanel panelheader;
    private javax.swing.JPanel paneljadwal;
    private javax.swing.JPanel panelkondisi;
    private javax.swing.JPanel panelkunjungan;
    private javax.swing.JPanel panelmain;
    private javax.swing.JPanel panelmenu;
    private javax.swing.JPanel panelpendaftaran;
    private javax.swing.JPanel paneltanggal;
    private javax.swing.JPanel panelutama;
    private javax.swing.JRadioButton rj1;
    private javax.swing.JRadioButton rj2;
    private javax.swing.JTable tabelbidan;
    private javax.swing.JTable tabeldataanak;
    private javax.swing.JTable tabeljadwal;
    private javax.swing.JTable tabelkondisi;
    private javax.swing.JTable tabelkunjungan;
    private javax.swing.JTable tabelpendaftaran;
    private javax.swing.JTextField talamat;
    private javax.swing.JTextField talamatbidan;
    private javax.swing.JTextField tberat;
    private javax.swing.JTextField tberatlahir;
    private javax.swing.JTextField tcaridataanak;
    private javax.swing.JTextField tcarikondisi;
    private javax.swing.JTextField tcarikunjungan;
    private javax.swing.JTextField tcaripendaftaran;
    private javax.swing.JLabel tgl;
    private com.toedter.calendar.JDateChooser tglkunjungan;
    private com.toedter.calendar.JDateChooser tgllahiranak;
    private javax.swing.JTextField tidanak;
    private javax.swing.JTextField tidbidan;
    private javax.swing.JTextField tidjadwal;
    private javax.swing.JTextField tidkondisi;
    private javax.swing.JTextField tidkunjungan;
    private javax.swing.JTextField tidpendaftaran;
    private javax.swing.JTextArea tkondisi;
    private javax.swing.JTextField tlengan;
    private javax.swing.JTextField tlingkar;
    private javax.swing.JTextField tnama;
    private javax.swing.JTextField tnamaanak;
    private javax.swing.JTextField tnamaanakkondisi;
    private javax.swing.JTextField tnamabidan;
    private javax.swing.JTextField tnamaorangtua;
    private javax.swing.JTextField tnamaorangtuakunjungan;
    private javax.swing.JTextField tnik;
    private javax.swing.JTextField tnikanakpendaftaran;
    private javax.swing.JTextField tnikbidan;
    private javax.swing.JTextField tnikjadwal;
    private javax.swing.JTextField tnohp;
    private javax.swing.JTextField tnohpbidan;
    private javax.swing.JTextField trt;
    private javax.swing.JTextField ttinggi;
    private javax.swing.JTextField ttinggilahir;
    private javax.swing.JTextField tusia;
    private javax.swing.JTextField tusiaanak;
    private javax.swing.JTextField twaktu;
    // End of variables declaration//GEN-END:variables
}
