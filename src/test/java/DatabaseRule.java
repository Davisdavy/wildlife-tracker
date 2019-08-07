import org.junit.rules.ExternalResource;
import org.sql2o.*;

public class DatabaseRule extends ExternalResource {

    @Override
    protected void before() {
        DB.sql2o = new Sql2o("jdbc:postgresql://localhost:5432/virtual_pets_test", "davis", "vegas2017");
       // DB.sql2o = new Sql2o("jdbc:postgresql://ec2-54-83-1-101.compute-1.amazonaws.com:5432/d41or48rdrchmq", "trajcxqbotrgdl", "e41e99b6bb41e8e4b2937b57c48a3d351db73c6b0095b00e1292d46e3df5fe3f");
    }

    @Override
    protected void after() {
        try (Connection con = DB.sql2o.open()) {
            String deleteAnimalsQuery = "DELETE FROM animals *;";
            String deleteRangersQuery = "DELETE FROM rangers *;";
            String deleteLocationQuery = "DELETE FROM location *";
            String deleteSightingQuery = "DELETE FROM sightings *";

            con.createQuery(deleteAnimalsQuery).executeUpdate();
            con.createQuery(deleteRangersQuery).executeUpdate();
            con.createQuery(deleteLocationQuery).executeUpdate();
            con.createQuery(deleteSightingQuery).executeUpdate();
        }
    }

}