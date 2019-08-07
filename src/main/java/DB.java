import org.sql2o.Sql2o;


public class DB {
   // postgres://rtufxkpzpyzrrl:42325527e91d6ec584b609cc13599c866825c8b6440ddfdd656df4cddfaee271@ec2-54-204-37-92.compute-1.amazonaws.com:5432/d6pal4uv6rp2t0


    public static Sql2o sql2o = new Sql2o("jdbc:postgresql://ec2-23-21-177-102.compute-1.amazonaws.com:5432/d6pal4uv6rp2t0", "afpahcqdjygvgz", "edf7eb6117642da47e26d85a0efcf7a8b974f286be7c4d323999e0c4cb401699");
}
