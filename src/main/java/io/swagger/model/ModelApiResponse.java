package io.swagger.model;

import java.util.Objects;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * ModelApiResponse
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2017-10-25T15:40:05.895Z")

public class ModelApiResponse   {

  private String mensaje;

  public String getMensaje()
  {
      return mensaje;
  }

  public void setMensaje(String mensaje)
  {
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
    return true;
  }

  @Override
  public int hashCode() {
    return Objects.hash();
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ModelApiResponse {\n");
    sb.append(mensaje);
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

