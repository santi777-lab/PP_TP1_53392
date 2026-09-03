import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int id = 1;
        boolean esGratuito = false;

        // a. Crear 3 estudiantes
        List<Estudiante> estudiantes = new ArrayList<>();
        for (int i = 1; i <= 3; i++) {
            System.out.println("Ingrese legajo del estudiante " + i + ": ");
            String legajo = scanner.nextLine();
            System.out.println("Ingrese nombre del estudiante " + i + ": ");
            String nombre = scanner.nextLine();

            Estudiante estudiante = new Estudiante();
            estudiante.setLegajo(legajo);
            estudiante.setNombre(nombre);
            estudiantes.add(estudiante);
        }

        // b. Crear 1 evento
        System.out.println("\n\nREGISTRO DE EVENTO: ");
        System.out.println("Ingrese un título para el evento");
        String titulo = scanner.nextLine();

        System.out.println("¿El evento es gratuito? S/N");
        String respuesta = scanner.nextLine().trim().toLowerCase();
        esGratuito = (respuesta.equals("s") || respuesta.equals("si") || respuesta.equals("sí"));

        double costoBase = 0;
        if (!esGratuito) {
            System.out.println("Ingrese el costo base");
            costoBase = scanner.nextDouble();
            scanner.nextLine();
        }

        EventoUniversitario evento = new EventoUniversitario("EVT-" + id, titulo, costoBase, esGratuito);
        id++;
        EventoUniversitario copiaevento = new EventoUniversitario(evento);

        evento.mostrarDatos();
        copiaevento.mostrarDatos();

        System.out.println("Cantidad total de eventos: " + EventoUniversitario.getCantidadEventos());

        // c. Crear 1 sala
        System.out.println("Ingrese el nombre de la sala donde se realizará el evento");
        String nombreSala = scanner.nextLine();
        Sala sala = new Sala(id, nombreSala);
        evento.asignarSala(sala);

        // d. Crear 2 actividades
        System.out.println("\n\nREGISTRO DE ACTIVIDADES PARA EL EVENTO " + evento.getTitulo());
        for (int idActividad = 1; idActividad <= 2; idActividad++) {
            System.out.println("Ingrese el título de la actividad " + idActividad + ": ");
            String tituloActividad = scanner.nextLine();

            System.out.println("Ingrese el cupo máximo de estudiantes admitidos para la actividad: ");
            int cupoMaximo = scanner.nextInt();
            scanner.nextLine();

            System.out.println("Ingrese el tipo de actividad (Charla/Taller): ");
            String tipoActividad = scanner.nextLine();

            evento.crearActividad(idActividad, tituloActividad, cupoMaximo, tipoActividad);
        }

        // e. Inscribir 2 estudiantes en la Charla (actividad 1)
        evento.getActividades().get(0).inscribir(estudiantes.get(0));
        evento.getActividades().get(0).inscribir(estudiantes.get(1));

        // f. Inscribir 2 estudiantes en el Taller (actividad 2)
        evento.getActividades().get(1).inscribir(estudiantes.get(1));
        evento.getActividades().get(1).inscribir(estudiantes.get(2));

        // Mostrar inscripciones y costo
        System.out.println("\nINSCRIPCIONES REGISTRADAS:");
        for (Actividad act : evento.getActividades()) {
            System.out.println("Actividad: " + act.getTitulo() + " (" + act.getTipoActividad() + ")");
            act.mostrarInscripciones();
        }

        System.out.println("\n\n=== RESUMEN COMPLETO DEL EVENTO ===");
        System.out.println("Evento: " + evento.getTitulo());
        System.out.println("Sala asignada: " + evento.getSala().getnombre());

        System.out.println("\nActividades registradas:");
        for (Actividad act : evento.getActividades()) {
            System.out.println(" - Actividad: " + act.getTitulo() + " (" + act.getTipoActividad() + ")");
            System.out.println("   Cupo máximo: " + act.getCupoMaximo());

            System.out.println("   Estudiantes inscriptos:");
            for (Inscripcion insc : act.getInscripciones()) {
                System.out.println("     * " + insc.getEstudiante().getNombre() + " - Legajo: " + insc.getEstudiante().getLegajo());
            }
        }

        System.out.println("\nCosto estimado del evento con actividades: " + evento.calcularCostoEstimado());
    }
}
