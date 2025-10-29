//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        movies incepcion = new movies("incepcion",2010,148,"Un ladrón especializado en infiltrarse en los sueños de las personas es contratado para implantar una idea en la mente de un heredero empresarial");
        movies avatar = new movies("avatar",2009,162,"Un ex marine parapléjico es enviado a un planeta llamado Pandora, donde se debate entre seguir órdenes humanas o proteger a la raza nativa Na’vi");
        movies dark = new movies("the dark knight",2008,152,"Batman enfrenta a su mayor enemigo, el Joker, quien desata el caos en Ciudad Gótica y pone a prueba la moral del héroe");
        movies titanic = new movies("titanic",1997,195,"Una joven aristócrata y un artista pobre se enamoran a bordo del Titanic, el famoso barco que naufragó trágicamente en su viaje inaugural");
        movies interstellar = new movies("interstellar",2014,169,"Un grupo de astronautas viaja a través de un agujero de gusano en busca de un nuevo hogar para la humanidad");
        incepcion.show();
        avatar.show();
        dark.show();
        titanic.show();
        interstellar.show();






    }
}

class movies{
    String nombre;
    int año;
    int duracion;
    String resumen;

    public movies(String nombre, int año, int duracion, String resumen) {
        this.nombre = nombre;
        this.año = año;
        this.duracion = duracion;
        this.resumen = resumen;
    }
    public void show(){
        System.out.println("Nombre: "+nombre);
        System.out.println("año: " + año);
        System.out.println("Duracion: "+duracion);
        System.out.println("Resumen: "+resumen);

    }
}