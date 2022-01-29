package com.api.prestamos.Persistencia;

public class SQL{

    public final String insertar = "insert into users (first_name, last_name, date_created, is_admin, num_points)";
    public final String buscar = "select * from";
    
    public String Select(String tabla , String parametros , String condicion){
    String consulta = null;
    if(condicion!="" ){
    consulta = "select "+parametros+" from "+tabla+" where "+condicion;
    }else{
    consulta = "select "+parametros+" from "+tabla;
    }
    return consulta;
    
    }
    public String Insertar( String tabla , String parametros , String valores){
    return "insert into "+tabla+" ("+parametros+") values( "+valores+" )";
    }
    public String Update (String tabla , String parametrosUpdate , String valores , String condicion){
    return "UPDATE "+tabla+" SET "+parametrosUpdate+" where "+condicion;
    }
    public String Delete(String tabla , String parametros , String condicion){
    return "delete from "+tabla+" where "+condicion;
    }
    }
