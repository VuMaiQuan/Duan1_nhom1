package CodeMain.services.serviceImp;

import CodeMain.Response.ViewCTSPReponse;
import CodeMain.domainModel.ChiTietSP;
import CodeMain.repository.CTSPRepository;
import java.util.ArrayList;
import java.util.List;
import CodeMain.services.CTSPService;

/**
 *
 * @author hungs
 */
public class CTSPServiceImp implements CTSPService {

    List<ChiTietSP> listCTSP;
    CTSPRepository ctspRepo;

    public CTSPServiceImp() {
        ctspRepo = new CTSPRepository();
        listCTSP = ctspRepo.getListAll();

    }

    @Override
    public List<ViewCTSPReponse> getListAll() {
        List<ViewCTSPReponse> list = new ArrayList<>();
        for (ChiTietSP x : listCTSP) {
            list.add(new ViewCTSPReponse(x));
        }
        return list.isEmpty() ? null : list;
    }

    @Override
    public ViewCTSPReponse getOneObj(String ma) {
        return null;
    }

    @Override
    public void save(ChiTietSP ctsp) throws Exception {

    }

    @Override
    public void update(ChiTietSP ctsp) throws Exception {

    }

    @Override
    public void delete(String ma) throws Exception {

    }

    public static void main(String[] args) {
        CTSPServiceImp c = new CTSPServiceImp();

        for (ViewCTSPReponse x : c.getListAll()) {
            System.out.println(x);
        }

    }

}
