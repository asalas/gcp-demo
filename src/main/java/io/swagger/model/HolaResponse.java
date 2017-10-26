package io.swagger.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * HolaResponse
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2017-10-26T05:27:28.167Z")

public class HolaResponse   {
  @JsonProperty("mensaje")
  private String mensaje = null;

  public HolaResponse mensaje(String mensaje) {
    this.mensaje = mensaje;
    return this;
  }

   /**
   * Mensaje devuelto
   * @return mensaje
  **/
  @ApiModelProperty(value = "Mensaje devuelto")


  public String getMensaje() {
    return mensaje;
  }

  public void setMensaje(String mensaje) {
    this.mensaje = mensaje;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    HolaResponse holaResponse = (HolaResponse) o;
    return Objects.equals(this.mensaje, holaResponse.mensaje);
  }

  @Override
  public int hashCode() {
    return Objects.hash(mensaje);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class HolaResponse {\n");
    
    sb.append("    mensaje: ").append(toIndentedString(mensaje)).append("\n");
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

