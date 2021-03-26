public class CreateAliens
{

    public static void main(String[] args)
    {
        Martian martian = new Martian(4, "Borg");
        Jupiterian jupiterian = new Jupiterian(7, "Jarbog");

        System.out.println(martian.toString());
        System.out.println(jupiterian.toString());
    }
}
