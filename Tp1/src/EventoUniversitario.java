import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class EventoUniversitario {
    //Atributos
    final String id;
    String titulo;
    double costoBase;
    boolean gratuito;
    static int  cantidadEventos;

    private Sala sala;
    private List<Actividad> actividades;

    public List<Actividad> getActividades() {
        return actividades;
    }

    public Sala getSala(){
        return sala;
    }

    //Get y Set
    public String getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public double getCostoBase() {
        return costoBase;
    }

    public void setCostoBase(double costoBase) {
        this.costoBase = costoBase;
    }

    public boolean isGratuito() {
        return gratuito;
    }

    public void setGratuito(boolean gratuito) {
        this.gratuito = gratuito;
    }

    public static void setCantidadEventos(int cantidadEventos) {
        EventoUniversitario.cantidadEventos = cantidadEventos;
    }

    //Constructores
    public EventoUniversitario(String Id, String titulo, double costoBase, boolean gratuito){
        this.id = Id;
        this.titulo = titulo;
        this.costoBase = costoBase;
        this.gratuito = gratuito;
        cantidadEventos++;
        this.actividades = new ArrayList<>();

    }
    public EventoUniversitario(EventoUniversitario otroEvento){
        this(otroEvento.id + "-COPIA",
                otroEvento.titulo,
                otroEvento.costoBase,
                otroEvento.gratuito);
    }
    public double calcularCostoEstimado(){
        if (this.gratuito){
            return 0.0;
        }
        double costoTotal = costoBase;
        for(Actividad actividad : actividades){
            costoTotal += actividad.calcularCostoMateriales();
        }
        return costoTotal * 1.21; // 21% de impuestos
    }
    public void asignarSala(Sala sala){

        this.sala = sala;
    }
    public void crearActividad(int id, String titulo, int cupo, String tipoActividad){
        Scanner scanner = new Scanner(System.in);
        if (tipoActividad.equalsIgnoreCase("Taller")){
            System.out.println("¿Requiere el uso de Notebook? (S/N)");
            String respuesta = scanner.nextLine().trim().toLowerCase();
            boolean requiereNotebook = respuesta.equals("s") || respuesta.equals("si") || respuesta.equals("sí");
                Actividad taller = new Taller(id, titulo, cupo, true);
                actividades.add(taller);
            } else if (tipoActividad.equalsIgnoreCase("Charla")) {
                System.out.println("Ingrese el nombre del disertante:");
                String disertante = scanner.nextLine();

                Actividad charla = new Charla(id, titulo, disertante, cupo);
                actividades.add(charla);
            }
    }
    void mostrarDatos(){
        System.out.println("===================================================================================");
        System.out.println("Código del evento: " + id);
        System.out.println("El título es: " + titulo);
        System.out.println("El costo es: " + this.calcularCostoEstimado());
        //Mostrar sala
        if (sala != null){
            System.out.println("La sala asignada es: " + sala.getnombre());

        }
        System.out.println("actividades");
        System.out.println("____________");
        for (Actividad actividad : actividades) {
            System.out.println("- " + actividad.getTitulo());
        }
    }
    public static int getCantidadEventos(){
        return cantidadEventos;
    }
}