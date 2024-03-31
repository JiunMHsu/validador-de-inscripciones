package domain;

import java.util.List;

public class Alumno {
   List<Materia> aprobadas;

   public Alumno(List<Materia> materiasAprobadas) {
      this.aprobadas = materiasAprobadas;
   }

   public List<Materia> getAprobadas() {
      return this.aprobadas;
   }

   public boolean puedeCursar(Materia materia) {
      return this.aprobadas.containsAll(materia.getCorrelativas());
   }

}
