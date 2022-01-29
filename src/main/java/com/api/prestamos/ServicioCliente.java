package com.api.prestamos;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


import com.api.prestamos.Catalago.CClientes;
import com.api.prestamos.Catalago.Lista.ListaCliente;
import com.api.prestamos.Bo.BClinete;

@RestController
public class ServicioCliente {

    @RequestMapping(value="/cliente" , method = RequestMethod.GET)
    public ResponseEntity<Object> GetCliente(@RequestBody CClientes data ) throws Exception {

        BClinete bClinete = new BClinete();
        data = bClinete.buscarCliente(data);

        return new ResponseEntity<>( data , HttpStatus.OK);
    }

    @RequestMapping(value="/clientes" , method = RequestMethod.GET)
    public ResponseEntity<Object> GetClientes() throws Exception {

        BClinete bClinete = new BClinete();
        ListaCliente listaCliente = new ListaCliente();
        listaCliente = bClinete.mostarCliente();

        return new ResponseEntity<>( listaCliente, HttpStatus.OK);
    }
    
    @RequestMapping(value="/cliente" , method = RequestMethod.POST)
    public ResponseEntity<Object> GetClientesInsert(@RequestBody CClientes data) throws Exception {

        BClinete bClinete = new BClinete();
        data = bClinete.registClientes(data);

        return new ResponseEntity<>( data, HttpStatus.OK);
    }

    @RequestMapping(value="/cliente" , method = RequestMethod.PUT)
    public ResponseEntity<Object> GetClientesUpdate(@RequestBody CClientes data) throws Exception {

        BClinete bClinete = new BClinete();
        data = bClinete.modificarClientes(data);

        return new ResponseEntity<>( data, HttpStatus.OK);
    }

    @RequestMapping(value="/cliente" , method = RequestMethod.DELETE)
    public ResponseEntity<Object> GetClientesDelete(@RequestBody CClientes data) throws Exception {

        BClinete bClinete = new BClinete();
        data = bClinete.borrarClientes(data);
        return new ResponseEntity<>( data, HttpStatus.OK);
    }
}
