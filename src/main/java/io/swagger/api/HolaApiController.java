package io.swagger.api;

import com.cirrocode.gcp.demo.service.SaludoService;
import io.swagger.model.HolaResponse;

import io.swagger.annotations.*;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.beans.factory.annotation.Autowired;
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2017-10-26T05:27:28.167Z")

@Controller
public class HolaApiController implements HolaApi {

    @Autowired SaludoService saludoService;

    public ResponseEntity<HolaResponse> saludo(@ApiParam(value = "Nombre de la persona a saludar",required=true ) @PathVariable("nombre") String nombre) {
        final HolaResponse response = this.saludoService.saludar(nombre);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

}
