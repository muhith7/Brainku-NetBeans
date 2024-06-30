/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author nawawi
 */
public class ExceptionData extends Exception{
    public ExceptionData(){
        
    }
    
    public String showMessageError(){
        String notice = "Silahkan isi data dengan lengkap..";
        return notice;
    }
    
}