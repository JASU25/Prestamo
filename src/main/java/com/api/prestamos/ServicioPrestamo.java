package com.api.prestamos;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import java.util.HashMap;
import java.util.Map;

import com.api.prestamos.Catalago.CPrestamo;
import com.api.prestamos.Catalago.Lista.ListaPrestamo;
import com.api.prestamos.Bo.BPrestamo;

@RestController
public class ServicioPrestamo {
    
    @RequestMapping("/")
    public String index(){
        return "Hola";
    }
    
    @RequestMapping(value="/prestamo" , method = RequestMethod.GET)
    public ResponseEntity<Object> GetPrestamo(@RequestBody CPrestamo data ) throws Exception {

        BPrestamo bPrestamo = new BPrestamo();
        data = bPrestamo.buscarPrestamo(data);

        return new ResponseEntity<>( data , HttpStatus.OK);
    }

    @RequestMapping(value="/prestamos" , method = RequestMethod.GET)
    public ResponseEntity<Object> GetClientes(@RequestBody CPrestamo data) throws Exception {

        BPrestamo bPrestamo = new BPrestamo();
        ListaPrestamo listaPrestamo = new ListaPrestamo();
        listaPrestamo = bPrestamo.mostarPrestamo(data);

        return new ResponseEntity<>( listaPrestamo, HttpStatus.OK);
    }
    @RequestMapping(value="/prestamo" , method = RequestMethod.POST)
    public ResponseEntity<Object> GetClientesInsert(@RequestBody CPrestamo data) throws Exception {

        BPrestamo bPrestamo = new BPrestamo();
        data = bPrestamo.registPrestamo(data);

        return new ResponseEntity<>( data, HttpStatus.OK);
    }

    @RequestMapping(value="/prestamo" , method = RequestMethod.PUT)
    public ResponseEntity<Object> GetClientesUpdate(@RequestBody CPrestamo data) throws Exception {

        BPrestamo bPrestamo = new BPrestamo();
        data = bPrestamo.modificarPrestamo(data);

        return new ResponseEntity<>( data, HttpStatus.OK);
    }

    @RequestMapping(value="/prestamo" , method = RequestMethod.DELETE)
    public ResponseEntity<Object> GetClientesDelete(@RequestBody CPrestamo data) throws Exception {

        BPrestamo bPrestamo = new BPrestamo();
        data = bPrestamo.borrarPrestamo(data);
        return new ResponseEntity<>( data, HttpStatus.OK);
    }

    
}
