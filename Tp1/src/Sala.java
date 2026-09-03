public class Sala {

    private int id;
    private String nombre;

    //Constructor
    public Sala(int id, String nombre){
        this.id = id;
        this.nombre = nombre;
    }

    //Métodos
    public int getId() {
        return id;
    }

    public void setid(int id) {
        this.id = id;
    }

    public String getnombre(){
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String toString(){
        return "Sala [id=" + id + ", nombre=" + nombre + "]";
    }
}
