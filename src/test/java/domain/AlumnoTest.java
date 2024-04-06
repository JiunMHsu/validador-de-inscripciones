package domain;

import org.junit.Assert;
import org.junit.Test;

public class AlumnoTest {
   private Materia ayed = new Materia();
   private Materia md = new Materia();
   private Materia syo = new Materia();
   private Materia inglesI = new Materia();
   private Materia pdep = new Materia(ayed, md);
   private Materia ads = new Materia(ayed, syo);
   private Materia dds = new Materia(ads, ayed, syo, pdep, inglesI);

   @Test
   public void puedeCursarSiLaMateriaNoTieneCorrelativas() {
      Alumno unAlumno = new Alumno(2090260);
      unAlumno.aprobo();
      Assert.assertTrue("El alumno puede cursar algoritmos porque ésta no tiene correlativas", unAlumno.puedeCursar(ayed));
   }

   @Test
   public void puedeCursarSiCumpleLasCorrelativas() {
      Alumno unAlumno = new Alumno(2090260);
      unAlumno.aprobo(ads, ayed, md, syo, pdep, inglesI);
      Assert.assertTrue("El alumno puede cursar diseño porque cumple las correlativas", unAlumno.puedeCursar(dds));
   }

   @Test
   public void noPuedeCursarSiNoCumpleLasCorrelativas() {
      Alumno unAlumno = new Alumno(2090260);
      unAlumno.aprobo(md, syo, pdep, inglesI);
      Assert.assertFalse("El alumno no puede cursar diseño porque le faltan las correlativas ayed y ads", unAlumno.puedeCursar(dds));
   }
}
