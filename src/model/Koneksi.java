/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author nawawi
 */
public class Koneksi {
    public static Connection koneksi;
    public Statement st;
    
    public static Connection getConnetion(){
        if(koneksi==null){
            try{
                String server="jdbc:mysql://localhost:3306/saw-brainku";
                String user="root";
                String password="";
                Class.forName("com.mysql.jdbc.Driver");
                koneksi=DriverManager.getConnection(server,user,password);
            }catch(Exception x){
                JOptionPane.showMessageDialog(null,"Koneksi Gagal, Pesan error \n"+x);
            }
        }
        return koneksi;
    }
    
    public void koneksi(){
        try{
            getConnetion();
            st=koneksi.createStatement();
        }catch(Exception x){
            JOptionPane.showMessageDialog(null,"Koneksi ambil Gagal, Pesan error \n"+x);
        }
    }
    
    public void closeConnection(ResultSet rs){
        try{
            if(rs!=null){
                rs.close();
            }
            st.close();
            koneksi.close();
        }catch(Exception x){
            JOptionPane.showMessageDialog(null,"Tutup Koneksi Gagal, Pesan error \n"+x);
        }
    } 
    
    public ResultSet getData(String sql){
         ResultSet rs=null;
         try{
            koneksi();
            rs=st.executeQuery(sql);
         }catch(Exception x){
             JOptionPane.showMessageDialog(null,"Ambil Data Gagal, Pesan error : \n"+x);
         }
         return rs;
    }
    
    public void saveData(String sql){
        try{
            koneksi();
            st.executeUpdate(sql);
        }catch(Exception x){
            System.out.print(x);
        }
    }
}
