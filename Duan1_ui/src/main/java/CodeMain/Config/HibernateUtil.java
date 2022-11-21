package CodeMain.Config;

import CodeMain.domainModel.ChiTietSP;
import CodeMain.domainModel.DanhMuc;
import CodeMain.domainModel.Hang;
import CodeMain.domainModel.HoaDon;
import CodeMain.domainModel.HoaDonCT;
import CodeMain.domainModel.KhachHang;
import CodeMain.domainModel.MatKinh;
import CodeMain.domainModel.MauSac;
import CodeMain.domainModel.NguoiDung;
import CodeMain.domainModel.NoiSX;
import CodeMain.domainModel.SanPham;
import CodeMain.domainModel.TaiKhoan;
import CodeMain.domainModel.Voucher;
import java.util.Properties;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;

public class HibernateUtil {

    public static final SessionFactory Factory;
    public static String url = "localhost:1433";
    public static String dbname = "DUAN1_DONGHO";
    public static String user = "hung";
    public static String pass = "123";

    static {
        Configuration conf = new Configuration();
        Properties props = new Properties();

        props.put(Environment.DIALECT, "org.hibernate.dialect.SQLServerDialect");
        props.put(Environment.DRIVER, "com.microsoft.sqlserver.jdbc.SQLServerDriver");
        props.put(Environment.URL, "jdbc:sqlserver://" + url + ";databaseName=" + dbname + ";encrypt=true;trustServerCertificate=true");
        props.put(Environment.USER, user);
        props.put(Environment.PASS, pass);
        props.put(Environment.SHOW_SQL, true);

        conf.addAnnotatedClass(TaiKhoan.class);
        conf.addAnnotatedClass(NguoiDung.class);
        conf.addAnnotatedClass(HoaDon.class);
        conf.addAnnotatedClass(HoaDonCT.class);
        conf.addAnnotatedClass(ChiTietSP.class);
        conf.addAnnotatedClass(DanhMuc.class);
        conf.addAnnotatedClass(Hang.class);
        conf.addAnnotatedClass(KhachHang.class);
        conf.addAnnotatedClass(MatKinh.class);
        conf.addAnnotatedClass(MauSac.class);
        conf.addAnnotatedClass(NoiSX.class);
        conf.addAnnotatedClass(SanPham.class);
        conf.addAnnotatedClass(Voucher.class);

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
