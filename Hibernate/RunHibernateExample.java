package WesHibernate;

public class RunHibernateExample {

    public static void main(String[] args) {
        int cityID = 6037;

        WorldDAO t = WorldDAO.getInstance();

        System.out.println("-CIT-360 Week 9 Assignment-\n");
        System.out.println("Executing SELECT Statement on database: world");
        System.out.println("SELECT * FROM city WHERE id = 1");

        System.out.println(t.getCity(1));
        System.out.println("\n");

        System.out.println("Executing INSERT Statement on database: world");
        System.out.println("INSERT INTO city VALUES (6000,\"Sacramento\", \"USA\", 7000)");
        t.insertCity(cityID,"Sacramento", 7000, "USA");
        System.out.println(t.getCity(cityID));

        System.out.println("Executing UPDATE Statement on database: world");
        System.out.println("");
        t.updateCity(cityID,"Sacramento", 9000, "USA");
        System.out.println(t.getCity(cityID));
    }

}
