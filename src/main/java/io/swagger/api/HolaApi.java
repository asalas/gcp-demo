/**
 * NOTE: This class is auto generated by the swagger code generator program (2.2.3).
 * https://github.com/swagger-api/swagger-codegen
 * Do not edit the class manually.
 */
package io.swagger.api;

import io.swagger.model.HolaResponse;

import io.swagger.annotations.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import javax.validation.constraints.*;
import javax.validation.Valid;
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2017-10-26T05:27:28.167Z")

@Api(value = "hola", description = "the hola API")
public interface HolaApi {

    @ApiOperation(value = "Saluda a una persona por su nombre", notes = "Retorna un mensaje de saludo", response = HolaResponse.class, authorizations = {
        @Authorization(value = "api_key")
    }, tags={ "hola", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "Operacion exitosa", response = HolaResponse.class) })
    
    @RequestMapping(value = "/hola/{nombre}",
        produces = { "application/json" }, 
        method = RequestMethod.GET)
    ResponseEntity<HolaResponse> saludo(@ApiParam(value = "Nombre de la persona a saludar",required=true ) @PathVariable("nombre") String nombre);

}