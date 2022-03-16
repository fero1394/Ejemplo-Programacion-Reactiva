import org.w3c.dom.ls.LSOutput;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class reactiva {

    public static void main(String[] args) {
        Factura f = new Factura("ordenador",1000, 3,520, "15/02/2021");
        Factura f2 = new Factura("Movil",300,2,510, "1/02/2022");
        Factura f3 = new Factura("impresora",200,1,505, "5/12/2021");
        Factura f4 = new Factura("imac",1500,5,530, "16/03/2022");

        //generar Una lista
        List<Factura> lista = new ArrayList<Factura>();

        //Agregar los productos de la factura
        lista.add(f);
        lista.add(f2);
        lista.add(f3);
        lista.add(f4);

        /*
        Predicate<Factura> predicado = new Predicate<Factura>() {
            @Override
            public boolean test(Factura t) {
                return t.getImporte()>300;
            }
        };

        Factura facturaFiltro=lista.stream()
                .filter(predicado)
                .findFirst()
                .get();

        System.out.println("FACTURA UNICA : "+facturaFiltro.getImporte());
        */

        //filtraje funcional con streams

        //FILTRO EN LA FACTURA POR IMPORTE
        Factura facturaFiltro=lista.stream()
                .filter(elemento->elemento.getImporte()>300)
                .findFirst()
                .get();
        System.out.println("FILTRO DE FACTURA POR IMPORTE\n"+" Filtro: "+facturaFiltro.getImporte()+"\nDetalles del producto: "+facturaFiltro);


        //FILTRO DE PRODUCTOS POR CANTIDAD
        List<Factura> facturaFiltroCantidad=lista.stream()
                .filter(elemento->elemento.getCantidadProducto() == 3)
                        .collect(Collectors.toList());

        System.out.println("\nFILTRO POR CANTIDAD");
        facturaFiltroCantidad.forEach(System.out::println);


        //FILTRO POR FECHA USANDO EL PREDICADO
        Predicate<Factura> predicado = new Predicate<Factura>() {
            @Override
            public boolean test(Factura t) {
                return t.getFecha().equals("16/03/2022");
            }
        };

        Factura filtroFecha=lista.stream()
                .filter(predicado)
                .findFirst()
                .get();

        System.out.println("\nFILTRO POR FECHA\n"+"Filtro: "+filtroFecha.getFecha() + "\nDetalles del producto: "+filtroFecha);
    }
}







