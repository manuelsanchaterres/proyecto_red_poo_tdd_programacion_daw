package red.dominio;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class SistemaSeguridad {


   public static boolean determinarSobreCarga(double totalConsumoActual, double consumoMaximo) {

      return totalConsumoActual > consumoMaximo;

   }

//   public static ArrayList<Aparato> apagarAparatos(){
//
//      Red redElectrica = new Red();
//      ArrayList<Aparato> listaAparatosEncendidos = redElectrica.getListaAparatosEncendidos();
//      ArrayList<Aparato> newListaAparatosEncendidos = new ArrayList<Aparato>();
//      // Sort the list based on the propertyToSort property
//      Collections.sort(listaAparatosEncendidos, new Comparator<Aparato>() {
//         @Override
//         public int compare(Aparato aparato1, Aparato aparato2) {
//            // Compare objects based on the propertyToSort property
//            return String.valueOf(aparato1.getPrioridad()).compareTo(String.valueOf(aparato2.getPrioridad()));
//         }
//      });
//
//      return listaAparatosEncendidos;
//   }
}
