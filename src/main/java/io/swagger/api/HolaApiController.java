package io.swagger.api;

import io.swagger.model.HolaResponse;

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
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2017-10-26T05:27:28.167Z")

@Controller
public class HolaApiController implements HolaApi {



    public ResponseEntity<HolaResponse> saludo(@ApiParam(value = "Nombre de la persona a saludar",required=true ) @PathVariable("nombre") String nombre) {
        // do some magic!
        return new ResponseEntity<HolaResponse>(HttpStatus.OK);
    }

}