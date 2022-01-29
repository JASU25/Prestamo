package com.api.prestamos.Dal.Modelo;

import java.sql.*;
import java.sql.ResultSet;

import com.api.prestamos.Persistencia.SQL;
import com.api.prestamos.Persistencia.MysqlConexion;
import com.api.prestamos.Catalago.CMontos;
import com.api.prestamos.Catalago.Lista.ListaMonto;
import com.api.prestamos.Persistencia.PMonto;

public class MMonto  {
    private MysqlConexion MysqlConexion = new MysqlConexion();
    private PMonto pMonto = new PMonto(); 
    private SQL SQL = new SQL();
    private ListaMonto listaMonto = new ListaMonto();

    protected ListaMonto selectTodo( ) throws Exception {
        //String query = "SELECT * FROM usuario";
        String armarQuery = null;
        Statement abrirConexion = null;
        ResultSet ejecutar = null;
        CMontos data = new CMontos();
        try {
             armarQuery = SQL.Select(pMonto.Tabla , pMonto.Parametros , Condicion(data) );
             abrirConexion = MysqlConexion.abri().createStatement();
             ejecutar = abrirConexion.executeQuery(armarQuery);
            while (ejecutar.next())
            {
                data.setId( ejecutar.getInt(pMonto.id) );
                data.setIMonto(ejecutar.getInt(pMonto.monto));
                data.setIPlazo(ejecutar.getInt(pMonto.plazo));
                
                if(ejecutar.getInt(pMonto.id) != 0 ) {
                    data.setInstanceSQLBoolean(true);
                    data.setInstanceBoolean(true);
                }
                listaMonto.lista.add(data);
                data = new CMontos();

            // print the results
            // System.out.format("%s, %s, %s, %s, %s, %s\n", id, firstName, lastName, dateCreated, isAdmin, numPoints);
            }
        } catch (Exception e) {
            data.setError(e.getMessage());
            throw e;
        }
        
        ejecutar.close();
        return listaMonto;
    } 
   
    protected CMontos selectUno( CMontos data ) throws Exception {
        //String query = "SELECT * FROM usuario";
        String armarQuery = null;
        Statement abrirConexion = null;
        ResultSet ejecutar = null;
        try {
            if (data.isInstanceBoolean() == true){
                armarQuery = SQL.Select(pMonto.Tabla , pMonto.Parametros , CondicionUpdate(data));
            }else {
                armarQuery = SQL.Select(pMonto.Tabla , pMonto.Parametros , Condicion(data));
            }
             abrirConexion = MysqlConexion.abri().createStatement();
             ejecutar = abrirConexion.executeQuery(armarQuery);
            while (ejecutar.next())
            {
                if( ( ejecutar.getString(pMonto.id) != null ) && ( data.isInstanceBoolean() == false )) {
                    data.setId( ejecutar.getInt(pMonto.id) );
                    data.setIMonto(ejecutar.getInt(pMonto.monto));
                    data.setIPlazo(ejecutar.getInt(pMonto.plazo));
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

    protected CMontos insertar(CMontos data) throws Exception {
        String armarQuery = null;
        PreparedStatement ejecutar = null;
        try {
            armarQuery = SQL.Insertar(pMonto.Tabla , pMonto.ParametrosInsert , pMonto.Valores);
            ejecutar = MysqlConexion.abri().prepareStatement(armarQuery);
            ejecutar.setInt (1, data.getIMonto() );
            ejecutar.setInt (2, data.getIPlazo() );

            ejecutar.execute();
            ejecutar.close();
        } catch (Exception e) {
            data.setError(e.getMessage());
            System.err.println(e.getMessage());
            throw e;
        }
        
        return data;
    }

    protected CMontos update( CMontos data)throws Exception{
        String armarQuery = null;
        PreparedStatement ejecutar = null;
        try {
            armarQuery = SQL.Update(pMonto.Tabla , parametrosUpdate(data), pMonto.Valores , CondicionUpdate(data));
            data.setError(armarQuery);
            ejecutar = MysqlConexion.abri().prepareStatement(armarQuery);
            ejecutar.setInt (1, data.getIMonto() );
            ejecutar.setInt (2, data.getIPlazo() );
            
            ejecutar.executeUpdate();
            ejecutar.execute();
            ejecutar.close();
        } catch (Exception e) {
            data.setError(e.getMessage());
            throw e;
        }
        
        return data;
    }

    protected CMontos Delete(CMontos data)throws Exception{
        String armarQuery = null;
        PreparedStatement ejecutar = null;

        try{
            
            armarQuery = SQL.Delete(pMonto.Tabla , pMonto.Parametros, Condicion(data));
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
    private String Condicion(CMontos data ){
        String query = "";
        try {
            if( data.getId() != 0 ) {
                query = pMonto.id +" = "+data.getId();
            }

            if( (data.getIMonto() != 0 ) && query != ""){
                query = query+" && "+pMonto.monto+" = "+data.getIMonto();
            }else if( (data.getIMonto() !=0  )  ) { query = pMonto.monto+" = "+data.getIMonto();}
    
            if( (data.getIPlazo() != 0 ) && query != ""){
                query = query+" && "+pMonto.plazo+" = "+data.getIPlazo();
            }else if( (data.getIPlazo() !=0  )  ) { query = pMonto.plazo+" = "+data.getIPlazo();}
    
           
        } catch (Exception e) {
            data.setError(e.getMessage());
            throw e;
        }
        
        return query;
    }

    private String CondicionUpdate(CMontos data ){
        String query = "";
        String id = data.getId()+"";
        try {
            if( data.getId() != 0 ) {
                query = pMonto.id +" = "+data.getId();
            }

        } catch (Exception e) {
            data.setError(e.getMessage());
            throw e;
        }
        
        return query;
    }
   
    private String parametrosUpdate(CMontos data) throws Exception{
        String query = "";
        try {

            if( (data.getIMonto()  != 0 ) && query != ""){
                // query = query+" , "+PUsuario.Contrasena+" = ? ";
                query = query+" , "+ pMonto.monto +" = "+ data.getIMonto();
            }else if(data.getIMonto()  != 0 ) { 
                query = pMonto.monto+" = "+data.getIMonto();
                // query = PUsuario.Contrasena+" = ? ";
            }

            if( (data.getIPlazo()  != 0 ) && query != ""){
                // query = query+" , "+PUsuario.Contrasena+" = ? ";
                query = query+" , "+ pMonto.plazo +" = "+ data.getIPlazo();
            }else if(data.getIPlazo()  != 0 ) { 
                query = pMonto.plazo+" = "+data.getIPlazo();
                // query = PUsuario.Contrasena+" = ? ";
            }
    
        } catch (Exception e) {
            data.setError(e.getMessage());
            throw e;
        }
        
       
        return query;
    }
    
}
