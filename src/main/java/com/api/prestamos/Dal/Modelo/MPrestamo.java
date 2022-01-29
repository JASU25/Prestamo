package com.api.prestamos.Dal.Modelo;

import java.sql.*;
import java.sql.ResultSet;

import com.api.prestamos.Persistencia.SQL;
import com.api.prestamos.Persistencia.MysqlConexion;
import com.api.prestamos.Catalago.CPrestamo;
import com.api.prestamos.Catalago.Lista.ListaPrestamo;
import com.api.prestamos.Persistencia.PPrestamo;


public class MPrestamo {

    private MysqlConexion MysqlConexion = new MysqlConexion();
    private PPrestamo PPrestamo = new PPrestamo(); 
    private SQL SQL = new SQL();
    private ListaPrestamo ListaPrestamo = new ListaPrestamo();

    protected ListaPrestamo selectTodo( CPrestamo data) throws Exception {
        //String query = "SELECT * FROM usuario";
        String armarQuery = null;
        Statement abrirConexion = null;
        ResultSet ejecutar = null;
        try {
             armarQuery = SQL.Select(PPrestamo.Tabla , PPrestamo.Parametros , Condicion(data) );
             abrirConexion = MysqlConexion.abri().createStatement();
             ejecutar = abrirConexion.executeQuery(armarQuery);
            while (ejecutar.next())
            {
                data.setId( ejecutar.getInt(PPrestamo.id) );
                data.setIdCliente( ejecutar.getInt(PPrestamo.idCliente));
                data.setIdMonto(ejecutar.getInt(PPrestamo.idMonto) );
                
                if(ejecutar.getInt(PPrestamo.id) != 0 ) {
                    data.setInstanceSQLBoolean(true);
                    data.setInstanceBoolean(true);
                }
                ListaPrestamo.lista.add(data);
                data = new CPrestamo();
            }
        } catch (Exception e) {
            data.setError(e.getMessage());
            throw e;
        }
        
        ejecutar.close();
        return ListaPrestamo;
    } 
   
    protected CPrestamo selectUno( CPrestamo data ) throws Exception {
        String armarQuery = null;
        Statement abrirConexion = null;
        ResultSet ejecutar = null;
        try {
           
            armarQuery = SQL.Select(PPrestamo.Tabla , PPrestamo.Parametros , Condicion(data));
            abrirConexion = MysqlConexion.abri().createStatement();
            ejecutar = abrirConexion.executeQuery(armarQuery);
            while (ejecutar.next())
            {
                if( ( ejecutar.getInt(PPrestamo.id) != 0 ) && ( data.isInstanceBoolean() == false )) {
                    data.setId( ejecutar.getInt(PPrestamo.id) );
                    data.setIdCliente( ejecutar.getInt(PPrestamo.idCliente));
                    data.setIdMonto(ejecutar.getInt(PPrestamo.idMonto) );
                    data.setInstanceSQLBoolean(true);
                    
                }else{
                    data.setInstanceSQLBoolean(true);
                } 
            }ejecutar.close();
        } catch (Exception e) {
            data.setError(e.getMessage());
            throw e;
        }
        return data ;
    } 

    protected CPrestamo insertar(CPrestamo data) throws Exception {
        String armarQuery = null;
        PreparedStatement ejecutar = null;
        try {
            armarQuery = SQL.Insertar(PPrestamo.Tabla , PPrestamo.Parametros , PPrestamo.Valores);
            ejecutar = MysqlConexion.abri().prepareStatement(armarQuery);
            ejecutar.setInt(1 , data.getId() );
            ejecutar.setInt (2, data.getIdCliente() );
            ejecutar.setInt (3, data.getIdMonto() );

            ejecutar.execute();
            ejecutar.close();
        } catch (Exception e) {
            data.setError(e.getMessage());
            throw e;
        }
        
        return data;
    }

    protected CPrestamo update( CPrestamo data)throws Exception{
        String armarQuery = null;
        PreparedStatement ejecutar = null;
        try {
            armarQuery = SQL.Update(PPrestamo.Tabla , parametrosUpdate(data), PPrestamo.Valores , CondicionUpdate(data));
            ejecutar = MysqlConexion.abri().prepareStatement(armarQuery);
            ejecutar.execute();
            ejecutar.close();
        } catch (Exception e) {
            data.setError(e.getMessage());
            throw e;
        }
        
        return data;
    }

    protected CPrestamo Delete(CPrestamo data)throws Exception{
        String armarQuery = null;
        PreparedStatement ejecutar = null;

        try{
            
            armarQuery = SQL.Delete(PPrestamo.Tabla , PPrestamo.Parametros, Condicion(data));
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
    private String Condicion(CPrestamo data ){
        String query = "";
        try {
            if( data.getId() != 0 ) {
                query = PPrestamo.id +" = "+data.getId();
            }
            
            if(data.getIdCliente()  != 0 ) { 
                query = PPrestamo.idCliente+" = "+data.getIdCliente();
                // query = PUsuario.Contrasena+" = ? ";
            }
           
        } catch (Exception e) {
            data.setError(e.getMessage());
            throw e;
        }
        
        return query;
    }

    private String CondicionUpdate(CPrestamo data ){
        String query = "";
        try {
            if( data.getId() != 0 ) {
                query = PPrestamo.id +" = "+data.getId();
            }

        } catch (Exception e) {
            data.setError(e.getMessage());
            throw e;
        }
        
        return query;
    }
   
    private String parametrosUpdate(CPrestamo data) throws Exception{
        String query = "";
        try {

            if(data.getIdCliente()  != 0 ) { 
                query = PPrestamo.idCliente+" = "+data.getIdCliente();
                // query = PUsuario.Contrasena+" = ? ";
            }

            if( (data.getIdMonto()  != 0 ) && query != ""){
                // query = query+" , "+PUsuario.Contrasena+" = ? ";
                query = query+" , "+ PPrestamo.idMonto +" = "+ data.getIdMonto();
            }else if(data.getIdMonto()  != 0 ) { 
                query = PPrestamo.idMonto+" = "+data.getIdMonto();
                // query = PUsuario.Contrasena+" = ? ";
            }
    
        } catch (Exception e) {
            data.setError(e.getMessage());
            throw e;
        }
        
       
        return query;
    }
}
