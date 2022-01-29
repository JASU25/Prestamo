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

import com.api.prestamos.Catalago.CAmortizacion;
import com.api.prestamos.Catalago.Lista.ListaAmortizacion;
import com.api.prestamos.Bo.BAmortizacion;

@RestController
public class ServicioAmortizacion {

    
    @RequestMapping(value="/amortizacion" , method = RequestMethod.GET)
    public ResponseEntity<Object> GetClientes(@RequestBody CAmortizacion data) throws Exception {

        BAmortizacion bAmortizacion = new BAmortizacion();
        ListaAmortizacion listaCliente = new ListaAmortizacion();
        listaCliente = bAmortizacion.mostarRegistros(data);

        return new ResponseEntity<>( listaCliente, HttpStatus.OK);
    }

    @RequestMapping(value="/amortizacion" , method = RequestMethod.POST)
    public ResponseEntity<Object> GetAmortizacionInsert(@RequestBody CAmortizacion data) throws Exception {

        BAmortizacion bAmortizacion = new BAmortizacion();
        data = bAmortizacion.registAmortizacion(data);

        return new ResponseEntity<>( data, HttpStatus.OK);
    }


    @RequestMapping(value="/amortizacion" , method = RequestMethod.DELETE)
    public ResponseEntity<Object> GetAmortizacionDelete(@RequestBody CAmortizacion data) throws Exception {

        BAmortizacion bAmortizacion = new BAmortizacion();
        data = bAmortizacion.borraraAmortizacion(data);
        return new ResponseEntity<>( data, HttpStatus.OK);
    }
}
