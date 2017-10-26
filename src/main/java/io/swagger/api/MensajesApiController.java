package io.swagger.api;

import com.cirrocode.gcp.demo.service.SaludoService;
import io.swagger.model.MensajesResponse;

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
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2017-10-26T05:27:28.167Z")

@Controller
public class MensajesApiController implements MensajesApi {

    @Autowired SaludoService saludoService;

    public ResponseEntity<List<MensajesResponse>> leerMensajes() {
        final List<MensajesResponse> leerMensajesBigQuery = this.saludoService.leerMensajesBigQuery();
        return new ResponseEntity<>(leerMensajesBigQuery, HttpStatus.OK);
    }

}
