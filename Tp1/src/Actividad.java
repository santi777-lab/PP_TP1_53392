import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public abstract class Actividad { //abstracta xq es la clase padre de la herencia y no tiene sentido crear una clase actividad
    protected int id; ////los atributos ahora son protected porque es herencia
    protected String titulo;
    protected int cupoMaximo;
    protected String tipoActividad; //Atributo de apoyo para el resumen de evento
    public static final int CUPO_MINIMO; //los estáticos quedan como públicos

    static{
        CUPO_MINIMO = 5;
    }

    private List<Inscripcion> inscripciones;


    //Métodos

    public Actividad(int id, String titulo, int cupoMaximo){
        this.id = id;
        this.titulo = titulo;
        this.cupoMaximo = (cupoMaximo > CUPO_MINIMO) ? cupoMaximo : CUPO_MINIMO;
        this.tipoActividad = tipoActividad;
        this.inscripciones = new ArrayList<>();
    }

    public Inscripcion inscribir(Estudiante estudiante){
        Inscripcion inscripcion = new Inscripcion(this, estudiante, LocalDate.now(), "REGISTRADA");
        inscripciones.add(inscripcion);
        return inscripcion;
    }

    public List<Inscripcion> getInscripciones() {
        return inscripciones;
    }

    public void mostrarInscripciones(){
        System.out.println("Inscripciones de la actividad: " + titulo);
        System.out.println("-----------------------------------");
        if (inscripciones.isEmpty()) {
            System.out.println("No hay inscripciones registradas.");
        } else {
            for (Inscripcion inscripcion : inscripciones) {
                System.out.println("-Fecha: " + inscripcion.getFecha() +"-Estado: "+  inscripcion.getEstado()+ "-Estudiante: " + inscripcion.getEstudiante().getNombre() + " (-Legajo: " + inscripcion.getEstudiante().getLegajo() + ")");
            }
        }
    }

    public int getId(){
        return id;
    }
    public void setId(int id){
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public int getCupoMaximo() {
        return cupoMaximo;
    }
    public void setCupoMaximo(int cupoMaximo) {
        this.cupoMaximo = cupoMaximo;
    }

    public String getTipoActividad() {
        return tipoActividad;
    }

    public final void mostrarIdentificacion(){
        System.out.println("- " + getTipo() + ": "+ titulo + "id: " + id + "cupo Maximo: " + cupoMaximo);
    }

    public abstract double calcularCostoMateriales(); //acá no se ponen llaves porque es abstract

    public abstract String getTipo();
}
