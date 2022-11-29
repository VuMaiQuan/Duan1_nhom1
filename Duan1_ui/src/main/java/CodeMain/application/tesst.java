package CodeMain.application;

import CodeMain.domainModel.Voucher;
import CodeMain.services.VoucherService;
import CodeMain.services.serviceImp.VoucherServiceImp;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author hungs
 */
public class tesst {

    public static void main(String[] args) {
        VoucherService vcc = new VoucherServiceImp();
        int vc = vcc.getListAll().size();
        System.out.println(vc);

    }

}
