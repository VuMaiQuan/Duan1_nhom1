package CodeMain.repository;

import CodeMain.Utilities.HibernateUtil;
import CodeMain.domainModel.NguoiDung;
import CodeMain.domainModel.TaiKhoan;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.TypedQuery;
import org.hibernate.Session;

public class TaiKhoanRepository {

    public List<TaiKhoan> getList() {
        List<TaiKhoan> list = new ArrayList<>();
        try ( Session s = HibernateUtil.getFactory().openSession()) {
            TypedQuery<TaiKhoan> qr = s.createQuery("from TaiKhoan");
            list = qr.getResultList();
            s.close();
            return list;
        } catch (Exception e) {
            return null;
        }
    }

    

    public static void main(String[] args) {
        TaiKhoanRepository tk = new TaiKhoanRepository();
        for (TaiKhoan x : tk.getList()) {
            System.out.println(x);
        }

    }
}
