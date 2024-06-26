package domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Inscripcion {
   private Alumno alumno;
   private List<Materia> materiasAInscribir;

   public Inscripcion(Alumno alumno, Materia ... materias) {
      this.alumno = alumno;
      this.materiasAInscribir = new ArrayList<>();
      Collections.addAll(this.materiasAInscribir, materias);
   }

   public boolean aprobada(){
      List<Boolean> resultados = this.materiasAInscribir
              .stream()
              .map(materia -> this.alumno.puedeCursar(materia))
              .toList();

      return resultados
              .stream()
              .reduce(true, (resultado, elemento) -> resultado & elemento);
   }
}
