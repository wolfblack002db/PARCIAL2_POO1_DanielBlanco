/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sv.udb.controlador;

import com.sv.udb.modelo.Bodegas;
import com.sv.udb.modelo.Piezas;
import com.sv.udb.modelo.Proveedores;
import com.sv.udb.recursos.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Estudiante
 */
public class BodegaCtrl {
    private Connection conn;

    public BodegaCtrl() {
        
    }
    
    public boolean agregar(Piezas codiPiez,Proveedores codiProv,int cant){
        this.conn=new Conexion().getConn();
        boolean resp=false;
        try 
        {
            PreparedStatement cmd = this.conn.prepareStatement("INSERT INTO bodegas VALUES(NULL,?,?,?,CURRENT_DATE)");
            cmd.setInt(1, codiPiez.getCodiPiez());
            cmd.setInt(2, codiProv.getCodiProv());
            cmd.setInt(3, cant);
            cmd.executeUpdate();
            resp=true;
        } catch (Exception e) {
            System.out.println("Error al guardar bodega "+ e.getMessage());
        }
        finally{
            try 
            {
                if (this.conn != null) 
                {
                    if (!this.conn.isClosed()) 
                    {
                        this.conn.close();
                    }
                }
            }catch(SQLException e) 
            {
                System.out.println("Error al cerrar la conexion " + e.getMessage());
            }
        }
        return resp;
    }
    
//    public List<Bodegas> obtenerTodo(){
//        this.conn=new Conexion().getConn();
//        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
//        List<Bodegas> resp = new ArrayList<>();
//        try {
//            PreparedStatement cmd = this.conn.prepareStatement("Select b.codi_bode, p* ,r*, b.cant, b.fecha_comp from bodegas b "
//                    + "INNER JOIN piezas p ON b.codi_piez = p.codi_piez "
//                    + "INNER JOIN proveedores r ON b.codi_prov = r.codi_prov");
//            ResultSet rs = cmd.executeQuery();
//            while (rs.next()) {
//                resp.add(new Bodegas(rs.getInt(1),new Piezas(rs.getInt(2),rs.getString(3),rs.getString(4),rs.getString(5)),
//                new Proveedores(rs.getInt(6),rs.getString(7),rs.getString(8),rs.getString(9)),sdf.format(rs.getDate(3))));
//            }
//        } catch (SQLException ex) {
//            System.err.println("Error al consultar: " + ex.getMessage());
//        } finally {
//            try {
//                if (this.conn != null) {
//                    if (!this.conn.isClosed()) {
//                        this.conn.close();
//                    }
//                }
//            } catch (SQLException ex) {
//                System.err.println("Error al cerrar la conexión");
//            }
//        }
//        return resp;
//    }
    
    
    public boolean modificar(int id, Piezas codiPiez,Proveedores codiProv,int cant){
        this.conn=new Conexion().getConn();
        boolean resp = false;
        
        try {
            PreparedStatement cmd = this.conn.prepareStatement("UPDATE bodegas SET codi_piez = ?, codi_prov = ?, cant = ? WHERE codi_bode=?");
            cmd.setInt(1, id);
            cmd.setInt(2, codiPiez.getCodiPiez());
            cmd.setInt(3, codiProv.getCodiProv());
            cmd.setInt(4, cant);
            cmd.executeUpdate();
            resp = true;
        } catch (Exception ex) {
            System.err.println("Error al modificar colegios" + ex.getMessage());
        } finally {
            try {
                if (this.conn != null) {
                    if (!this.conn.isClosed()) {
                        this.conn.close();
                    }
                }
            } catch (SQLException e) {
                System.err.println("Error al cerrar la conexion en equipos: " + e.getMessage());
            }
        }
        
        return resp;
    }
    
    public boolean eliminar(int id){
        this.conn=new Conexion().getConn();
        boolean resp = false;
        
        try {
            PreparedStatement cmd = this.conn.prepareStatement("DELETE FROM bodegas WHERE codi_bode=?");
            cmd.setInt(1, id);
            cmd.executeUpdate();
            resp = true;
        } catch (Exception ex) {
            System.err.println("Error al eliminar colegios" + ex.getMessage());
        } finally {
            try {
                if (this.conn != null) {
                    if (!this.conn.isClosed()) {
                        this.conn.close();
                    }
                }
            } catch (SQLException e) {
                System.err.println("Error al cerrar la conexion en colegios: " + e.getMessage());
            }
        }
        
        return resp;
    }
}
