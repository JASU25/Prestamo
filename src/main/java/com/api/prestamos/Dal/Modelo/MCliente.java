package com.api.prestamos.Dal.Modelo;

import java.sql.*;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;

import com.api.prestamos.Persistencia.SQL;
import com.api.prestamos.Persistencia.MysqlConexion;
import com.api.prestamos.Persistencia.PCliente;
import com.api.prestamos.Catalago.CClientes;
import com.api.prestamos.Catalago.Lista.ListaCliente;

public class MCliente {
    private MysqlConexion MysqlConexion = new MysqlConexion();
    private PCliente pCliente = new PCliente(); 
    private SQL SQL = new SQL();
    private ListaCliente listaCliente = new ListaCliente();

    protected ListaCliente selectTodo() throws Exception {
        //String query = "SELECT * FROM usuario";
        String armarQuery = null;
        Statement abrirConexion = null;
        ResultSet ejecutar = null;
        CClientes data = new CClientes();
        try {
            
            armarQuery = SQL.Select(pCliente.Tabla , pCliente.Parametros , "" );
            abrirConexion = MysqlConexion.abri().createStatement();
            ejecutar = abrirConexion.executeQuery(armarQuery);
            
            while (ejecutar.next())
            {
                
                data.setId(ejecutar.getInt(pCliente.id));
                data.setSNombre(ejecutar.getString(pCliente.nombre));
                listaCliente.lista.add(data);
                data = new CClientes();
            }
        } catch (Exception e) {
            //TODO: handle exception
            throw e;
        }
        
        ejecutar.close();
        return listaCliente;
    } 
   
    protected CClientes selectUno( CClientes data ) throws Exception {
        //String query = "SELECT * FROM usuario";
        String armarQuery = null;
        Statement abrirConexion = null;
        ResultSet ejecutar = null;
        try {
          if (data.isInstanceBoolean() == true){
                armarQuery = SQL.Select(pCliente.Tabla , pCliente.Parametros , CondicionUpdate(data));
            }else {
                armarQuery = SQL.Select(pCliente.Tabla , pCliente.Parametros , Condicion(data));
            }

            abrirConexion = MysqlConexion.abri().createStatement();
            ejecutar = abrirConexion.executeQuery(armarQuery);
            while (ejecutar.next())
            {
                if( ( ejecutar.getString(pCliente.id) != null ) && ( data.isInstanceBoolean() == false )) {
                    data.setId( ejecutar.getInt(pCliente.id) );
                    data.setSNombre(ejecutar.getString(pCliente.nombre));
                    data.setInstanceSQLBoolean(true);
                    
                }else{
                    data.setInstanceSQLBoolean(true);
                } 

            // print the results
            // System.out.format("%s, %s, %s, %s, %s, %s\n", id, firstName, lastName, dateCreated, isAdmin, numPoints);
            }ejecutar.close();
        } catch (Exception e) {
            //TODO: handle exception
            throw e;
        }
        return data ;
    } 

    protected CClientes insertar(CClientes data) throws Exception {
        String armarQuery = null;
        PreparedStatement ejecutar = null;
        try {
            armarQuery = SQL.Insertar(pCliente.Tabla , pCliente.Parametros , pCliente.Valores);
            //Statement abrirConexion = MysqlConexion.abri().createStatement();
            //ResultSet ejecutar = abrirConexion.executeQuery(armarQuery);

            ejecutar = MysqlConexion.abri().prepareStatement(armarQuery);
            ejecutar.setInt(1 , data.getId());
            ejecutar.setString(2, data.getSNombre() );

            ejecutar.execute();
            ejecutar.close();
        } catch (Exception e) {
            //TODO: handle exception
            System.err.println(e.getMessage());
            throw e;
        }
        
        return data;
    }

    protected CClientes update( CClientes data)throws Exception{
        String armarQuery = null;
        PreparedStatement ejecutar = null;
        try {
            armarQuery = SQL.Update(pCliente.Tabla , parametrosUpdate(data), pCliente.Valores , CondicionUpdate(data));

            ejecutar = MysqlConexion.abri().prepareStatement(armarQuery);
            
            // ejecutar.executeUpdate();
            ejecutar.execute();
            ejecutar.close();
        } catch (Exception e) {
            data.setError(e.getMessage());
            throw e;
        }
        
        return data;
    }

    protected CClientes Delete(CClientes data)throws Exception{
        String armarQuery = null;
        PreparedStatement ejecutar = null;

        try{
            
            armarQuery = SQL.Delete(pCliente.Tabla , pCliente.Parametros, Condicion(data));
        
            ejecutar = MysqlConexion.abri().prepareStatement(armarQuery);
            // ejecutar.setInt(1 , CUsuario.getId());
            // ejecutar.setString (2, CUsuario.getUsuario());
            // ejecutar.setString (3, CUsuario.getContrasena());
            
            ejecutar.execute();
          
            ejecutar.close();
        }
        catch(Exception e){
            data.setError(e.getMessage());
            throw e;
        }
       
        return data;
    }
   
    private String Condicion(CClientes data ){
        String query = "";
        try {
            if( data.getId() != 0) {
                query = pCliente.id +" = "+data.getId();
            }

            if( (data.getSNombre() != "" && data.getSNombre() != null ) && query != ""){
                query = query+" && "+pCliente.nombre+" = '"+data.getSNombre()+"'";
            }else if( (data.getSNombre() != "" && data.getSNombre() != null )  ) { query = pCliente.nombre+" = '"+data.getSNombre()+"'";}
           
        } catch (Exception e) {
            data.setError(e.getMessage());
            throw e;
        }
        
        return query;
    }

    private String CondicionUpdate(CClientes data ){
        String query = "";
        String id = data.getId()+"";
        try {
            if( data.getId() != 0 ) {
                query = pCliente.id +" = "+data.getId()+";";
            }

        } catch (Exception e) {
            data.setError(e.getMessage());
            throw e;
        }
        
        return query;
    }
   
    private String parametrosUpdate(CClientes data) throws Exception{
        String query = "";
        try {

            if( (data.getSNombre() != "" ) ){
                query =   pCliente.nombre +" = '"+ data.getSNombre()+"' ";
            }
    
        } catch (Exception e) {
            data.setError(e.getMessage());
            throw e;
        }
        
       
        return query;
    }
}
