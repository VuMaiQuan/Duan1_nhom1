package com.CodeMain.services;

import com.CodeMain.Response.ViewCTSPReponse;
import com.CodeMain.domainModel.ChiTietSP;
import java.util.List;

/**
 *
 * @author hungs
 */
public interface CTSPService {

    public List<ViewCTSPReponse> getListAll();
    
    public List<ViewCTSPReponse> getListCustom(String text);

    public ChiTietSP getOneObj(String ma);

    public void save(ChiTietSP ctsp) throws Exception;

    public void update(ChiTietSP ctsp) throws Exception;

    public void delete(String ma) throws Exception;

}
