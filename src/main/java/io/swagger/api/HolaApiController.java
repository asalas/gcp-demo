package io.swagger.api;

import com.cirrocode.gcp.demo.service.SaludoService;
import io.swagger.model.ModelApiResponse;

import io.swagger.annotations.*;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

import javax.validation.constraints.*;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2017-10-25T15:40:05.895Z")

@Controller
public class HolaApiController implements HolaApi {

    @Autowired SaludoService saludoService;

    public ResponseEntity<ModelApiResponse> saludo(@ApiParam(value = "Nombre de la persona a saludar",required=true ) @PathVariable("nombre") String nombre) {
        // do some magic!
        final String mensaje = this.saludoService.saludar(nombre);
        
        ModelApiResponse response = new ModelApiResponse();
        response.setMensaje(mensaje);
        
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

}
