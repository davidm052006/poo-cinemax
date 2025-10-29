public class Main {
    public static void main(String[] args) {

            Objetos projector_de_cine1 =  new Objetos ("reproductor de cine","es digital, tiene alta resolcion, cubre grandes pantallas","projecta imagenes en movimiento");
            Objetos pantalla = new Objetos ("pantalla de proyeccion","es blanca y fabricada en material que mejora la reflexion de la luz","mostrar la pelicula con una buena visibilidad a los espectadores");
            Objetos sonido = new Objetos ("sistema de sonido","sonido envolvente, control de volumen y frecuencia","reproducir efectos y sonidos de alta calidad");
            Objetos asiento = new Objetos("asiento","acolchada,reclinable, con portavasos y apoyabrazos","brindar comodidad al espectador");
            Objetos palomitas = new Objetos("maquina de palomitas","funciona con calor aire o aceite, tiene vitrinas de vidrio y bandejas de acero","reventar granos de mais y convertirlos en palomitas");
            projector_de_cine1.showInfo();
            pantalla.showInfo();
            sonido.showInfo();
            asiento.showInfo();
            palomitas.showInfo();
        }

    }


class Objetos{
    String nombre;
    String caracteristicas;
    String funcion;

    public Objetos(String nombre, String caracteristicas, String funcion) {
        this.nombre = nombre;
        this.caracteristicas = caracteristicas;
        this.funcion = funcion;
    }

    public void showInfo(){
        System.out.println("nombre: " + nombre);
        System.out.println("caractesiticas: " + caracteristicas);
        System.out.println("funcion: " + funcion);
    }

}



