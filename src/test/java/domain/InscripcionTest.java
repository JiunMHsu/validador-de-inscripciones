package domain;

import org.junit.Assert;
import org.junit.Test;

public class InscripcionTest {
   private Materia ayed = new Materia();
   private Materia md = new Materia();
   private Materia syo = new Materia();
   private Materia adc = new Materia();
   private Materia inglesI = new Materia();
   private Materia pdep = new Materia(ayed, md);
   private Materia so = new Materia(adc);
   private Materia ads = new Materia(ayed, syo);
   private Materia dds = new Materia(ads, ayed, syo, pdep, inglesI);

   @Test
   public void seApruebaSiSeCumplenLasCorrelativasParaTodasLasMaterias() {
      Alumno unAlumno = new Alumno(2090260);
      unAlumno.aprobo(ayed, md, syo);

      Inscripcion inscripcion = new Inscripcion(unAlumno, pdep, ads);
      Assert.assertTrue(inscripcion.aprobada());
   }

   @Test
   public void seRechazaSiAlMenosUnaMateriaNoVerificaLasCorrelativas() {
      Alumno unAlumno = new Alumno(2090260);
      unAlumno.aprobo(ayed, md, syo);

      Inscripcion inscripcion = new Inscripcion(unAlumno, pdep, ads, so);
      Assert.assertFalse(inscripcion.aprobada());
   }

}
