package domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Materia {
   private List<Materia> correlativas;

   public Materia(Materia ... correlativas) {
      this.correlativas = new ArrayList<>();
      Collections.addAll(this.correlativas, correlativas);
   }

   public List<Materia> getCorrelativas() {
      return this.correlativas;
   }

}
