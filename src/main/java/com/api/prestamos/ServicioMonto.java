package com.api.prestamos;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


import com.api.prestamos.Catalago.CMontos;
import com.api.prestamos.Catalago.Lista.ListaMonto;
import com.api.prestamos.Bo.BMonto;

@RestController
public class ServicioMonto {
    @RequestMapping(value="/monto" , method = RequestMethod.GET)
    public ResponseEntity<Object> GetCliente(@RequestBody CMontos data ) throws Exception {

        BMonto bClinete = new BMonto();
        data = bClinete.buscarMonto(data);

        return new ResponseEntity<>( data , HttpStatus.OK);
    }
    @RequestMapping(value="/montos" , method = RequestMethod.GET)
    public ResponseEntity<Object> GetMonsots() throws Exception {

        BMonto bPrestamo = new BMonto();
        ListaMonto listaMonto = new ListaMonto();
        listaMonto = bPrestamo.mostarMonto();

        return new ResponseEntity<>( listaMonto, HttpStatus.OK);
    }
    
    @RequestMapping(value="/monto" , method = RequestMethod.POST)
    public ResponseEntity<Object> GetClientesInsert(@RequestBody CMontos data) throws Exception {

        BMonto bClinete = new BMonto();
        data = bClinete.registMonto(data);

        return new ResponseEntity<>( data, HttpStatus.OK);
    }

    @RequestMapping(value="/monto" , method = RequestMethod.PUT)
    public ResponseEntity<Object> PutMonto(@RequestBody CMontos data) throws Exception {

        BMonto bClinete = new BMonto();
        data = bClinete.modificarMonto(data);

        return new ResponseEntity<>( data, HttpStatus.OK);
    }

    @RequestMapping(value="/monto" , method = RequestMethod.DELETE)
    public ResponseEntity<Object> DeleteMonto(@RequestBody CMontos data) throws Exception {

        BMonto bClinete = new BMonto();
        data = bClinete.borrarmonto(data);
        return new ResponseEntity<>( data, HttpStatus.OK);
    }
    
}
