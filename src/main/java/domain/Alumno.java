package domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Alumno {
   private Integer legajo;
   private List<Materia> aprobadas;

   public Alumno(int legajo) {
      this.legajo = legajo;
      this.aprobadas = new ArrayList<>();
   }

   public void aprobo(Materia ... materias) {
      Collections.addAll(this.aprobadas, materias);
   }

   public boolean puedeCursar(Materia materia) {
      return this.aprobadas.containsAll(materia.getCorrelativas());
   }

}
