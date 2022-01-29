package com.api.prestamos.Dal.Modelo;

import java.sql.*;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;

import com.api.prestamos.Persistencia.SQL;
import com.api.prestamos.Persistencia.MysqlConexion;
import com.api.prestamos.Persistencia.PAmortizacion;
import com.api.prestamos.Catalago.CAmortizacion;
import com.api.prestamos.Catalago.Lista.ListaAmortizacion;

public class MAmortizacion {
    private MysqlConexion MysqlConexion = new MysqlConexion();
    private PAmortizacion pAmortizacion = new PAmortizacion(); 
    private SQL SQL = new SQL();
    private ListaAmortizacion listaAmortizacion = new ListaAmortizacion();

    protected ListaAmortizacion selectTodo( CAmortizacion data) throws Exception {
        //String query = "SELECT * FROM usuario";
        String armarQuery = null;
        Statement abrirConexion = null;
        ResultSet ejecutar = null;
        try {
            
            armarQuery = SQL.Select(pAmortizacion.Tabla , pAmortizacion.Parametros , Condicion(data) );
            abrirConexion = MysqlConexion.abri().createStatement();
            ejecutar = abrirConexion.executeQuery(armarQuery);
            
            while (ejecutar.next())
            { 
                data.setIdPrestamo(ejecutar.getInt(pAmortizacion.id));
                data.setIPago(ejecutar.getInt(pAmortizacion.pago));
                data.setSFecha(ejecutar.getString(pAmortizacion.fehca));
                data.setIPrestamo(ejecutar.getInt(pAmortizacion.prestamo));
                data.setIInteres(ejecutar.getInt(pAmortizacion.interes));
                data.setIAbono(ejecutar.getInt(pAmortizacion.abono));

                listaAmortizacion.lista.add(data);
                data = new CAmortizacion();
            }
        } catch (Exception e) {
            //TODO: handle exception
            throw e;
        }
        
        ejecutar.close();
        return listaAmortizacion;
    } 

    protected CAmortizacion insertar(CAmortizacion data) throws Exception {
        String armarQuery = null;
        PreparedStatement ejecutar = null;
        try {
            armarQuery = SQL.Insertar(pAmortizacion.Tabla , pAmortizacion.Parametros , pAmortizacion.Valores);

            ejecutar = MysqlConexion.abri().prepareStatement(armarQuery);
            ejecutar.setInt(1 , data.getIdPrestamo());
            ejecutar.setInt(2, data.getIPago() );
            ejecutar.setString(3, data.getSFecha() );
            ejecutar.setInt(4, data.getIPrestamo() );
            ejecutar.setInt(5, data.getIInteres() );
            ejecutar.setInt(6, data.getIAbono() );

            ejecutar.execute();
            ejecutar.close();
        } catch (Exception e) {
            //TODO: handle exception
            System.err.println(e.getMessage());
            throw e;
        }
        
        return data;
    }
   
    protected CAmortizacion Delete(CAmortizacion data)throws Exception{
        String armarQuery = null;
        PreparedStatement ejecutar = null;

        try{
            
            armarQuery = SQL.Delete(pAmortizacion.Tabla , pAmortizacion.Parametros, Condicion(data));
        
            ejecutar = MysqlConexion.abri().prepareStatement(armarQuery);
            
            ejecutar.execute();
          
            ejecutar.close();
        }
        catch(Exception e){
            data.setError(e.getMessage());
            throw e;
        }
       
        return data;
    }
   
    private String Condicion(CAmortizacion data ){
        String query = "";
        try {
            if( data.getIdPrestamo() != 0) {
                query = pAmortizacion.id +" = "+data.getIdPrestamo();
            }
        } catch (Exception e) {
            data.setError(e.getMessage());
            throw e;
        }
        
        return query;
    }


}
