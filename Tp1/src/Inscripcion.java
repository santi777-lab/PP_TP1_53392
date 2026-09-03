import java.time.LocalDate;

public class Inscripcion {
    private Actividad actividad;
    private Estudiante estudiante;
    private LocalDate fecha;
    private String estado;

    public Inscripcion(Actividad actividad, Estudiante estudiante, LocalDate fecha, String estado){
        this.actividad = actividad;
        this.estudiante = estudiante;
        this.fecha = fecha;
        this.estado = estado;
    }

    public Actividad getActividad() {
        return actividad;
    }

    public void setActividad(Actividad actividad) {
        this.actividad = actividad;
    }

    public Estudiante getEstudiante() {
        return estudiante;
    }

    public void setEstudiante(Estudiante estudiante) {
        this.estudiante = estudiante;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}
