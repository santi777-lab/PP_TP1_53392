Trabajo Práctico Nº 1 - Paradigmas de Programación
Descripción:
Este proyecto implementa un sistema en Java para la **gestión de eventos universitarios**, permitiendo registrar:
- Eventos con título, costo base y condición de gratuito.
- Salas donde se realizan los eventos.
- Actividades asociadas a cada evento (Charlas y Talleres).
- Estudiantes inscriptos en las actividades.
- Cálculo del costo estimado del evento según las actividades y materiales.


Funcionalidades principales:
1. **Registro de estudiantes**  
   - Se crean 3 estudiantes con legajo y nombre.

2. **Registro de eventos**  
   - Se crea un evento con título, costo base y condición de gratuito.  
   - Se genera también un evento de copia para validar el constructor de copia.

3. **Asignación de sala**  
   - Se asigna una sala al evento con un nombre descriptivo.

4. **Registro de actividades**  
   - Se crean 2 actividades: una Charla y un Taller.  
   - Cada actividad tiene título, cupo máximo y tipo.

5. **Inscripción de estudiantes**  
   - Dos estudiantes se inscriben en la Charla.  
   - Dos estudiantes se inscriben en el Taller.  
   - Se muestran las inscripciones de cada actividad.

6. **Cálculo de costos**  
   - Se calcula el costo estimado del evento considerando las actividades y materiales.

---

Estructura del proyecto:
- **Main.java** → Contiene el flujo principal del programa (creación de estudiantes, evento, sala, actividades e inscripciones).
- **EventoUniversitario.java** → Clase que modela el evento, con atributos, constructores, métodos de copia y cálculo de costos.
- **Sala.java** → Clase que representa la sala donde se realiza el evento.
- **Actividad.java** → Clase abstracta que define las actividades del evento (Charla/Taller).
- **Estudiante.java** → Clase que modela a los estudiantes con legajo y nombre.
- **Inscripcion.java** → Clase que vincula estudiantes con actividades.

---

Ejemplo de ejecución: Propuesto en capturas de pantalla sobre el programa Intellij Idea componiendo un único documento de word.
