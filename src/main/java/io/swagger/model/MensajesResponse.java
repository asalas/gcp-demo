package io.swagger.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * MensajesResponse
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2017-10-26T05:27:28.167Z")

public class MensajesResponse   {
  @JsonProperty("mensaje")
  private String mensaje = null;

  @JsonProperty("fregistro")
  private String fregistro = null;

  public MensajesResponse mensaje(String mensaje) {
    this.mensaje = mensaje;
    return this;
  }

   /**
   * Saludo
   * @return mensaje
  **/
  @ApiModelProperty(value = "Saludo")


  public String getMensaje() {
    return mensaje;
  }

  public void setMensaje(String mensaje) {
    this.mensaje = mensaje;
  }

  public MensajesResponse fregistro(String fregistro) {
    this.fregistro = fregistro;
    return this;
  }

   /**
   * Fecha de registro formateada
   * @return fregistro
  **/
  @ApiModelProperty(value = "Fecha de registro formateada")


  public String getFregistro() {
    return fregistro;
  }

  public void setFregistro(String fregistro) {
    this.fregistro = fregistro;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    MensajesResponse mensajesResponse = (MensajesResponse) o;
    return Objects.equals(this.mensaje, mensajesResponse.mensaje) &&
        Objects.equals(this.fregistro, mensajesResponse.fregistro);
  }

  @Override
  public int hashCode() {
    return Objects.hash(mensaje, fregistro);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class MensajesResponse {\n");
    
    sb.append("    mensaje: ").append(toIndentedString(mensaje)).append("\n");
    sb.append("    fregistro: ").append(toIndentedString(fregistro)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}

