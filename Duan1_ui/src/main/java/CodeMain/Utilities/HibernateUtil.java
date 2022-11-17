package CodeMain.Utilities;

import CodeMain.domainModel.NguoiDung;
import CodeMain.domainModel.TaiKhoan;
import java.util.Properties;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;

public class HibernateUtil {

    public static final SessionFactory Factory;
    public static String url = "localhost:1433";
    public static String dbname = "";
    public static String user = "hung";
    public static String pass = "123";

    static {
        Configuration conf = new Configuration();
        Properties props = new Properties();

//        props.put(Environment.DIALECT, "org.hibernate.dialect.SQLServerDialect");
//        props.put(Environment.DRIVER, "com.microsoft.sqlserver.jdbc.SQLServerDriver");
//        props.put(Environment.URL, "jdbc:sqlserver://HUNG_SILVER:1433;databaseName=DemoDuan1;encrypt=true;trustServerCertificate=true");
//        props.put(Environment.USER, "hung");
//        props.put(Environment.PASS, "123");
//        props.put(Environment.SHOW_SQL, true);
        props.put(Environment.DIALECT, "org.hibernate.dialect.SQLServerDialect");
        props.put(Environment.DRIVER, "com.microsoft.sqlserver.jdbc.SQLServerDriver");
        props.put(Environment.URL, "jdbc:sqlserver://" + url + ";databaseName=" + dbname + ";encrypt=true;trustServerCertificate=true");
        props.put(Environment.USER, user);
        props.put(Environment.PASS, pass);
        props.put(Environment.SHOW_SQL, true);

        conf.addAnnotatedClass(TaiKhoan.class);
        conf.addAnnotatedClass(NguoiDung.class);

        conf.setProperties(props);
        ServiceRegistry registry = new StandardServiceRegistryBuilder().applySettings(conf.getProperties()).build();
        Factory = conf.buildSessionFactory(registry);
    }

    public static SessionFactory getFactory() {
        return Factory;
    }

    public static void closeFactory() {
        Factory.close();
    }

    public static void main(String[] args) {
        System.out.println(getFactory());
        System.out.println("Thành công");
    }

}
