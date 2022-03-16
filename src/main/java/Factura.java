import java.time.LocalDate;
import java.util.ArrayList;

import java.util.List;

public class Factura {
    String description;
    int importe;
    int cantidadProducto;
    int codigo;
    String fecha;

    Factura(String description, int importe, int cantidadProducto, int codigo,String fecha){
        this.description = description;
        this.importe = importe;
        this.cantidadProducto = cantidadProducto;
        this.codigo = codigo;
        this.fecha = fecha;
    }

    int getImporte(){
        return importe;
    }

    public String getDescription() {
        return description;
    }

    public int getCantidadProducto() {
        return cantidadProducto;
    }

    public int getCodigo() {
        return codigo;
    }

    public String getFecha() {
        return fecha;
    }

    @Override
    public String toString() {
        return "Factura{" +
                "description='" + description + '\'' +
                ", importe=" + importe +
                ", cantidadProducto=" + cantidadProducto +
                ", codigo=" + codigo +
                ", fecha=" + fecha +
                '}';
    }
}

