/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CodeMain.services.serviceImp;

import CodeMain.Response.ViewHoaDonCTResponse;
import CodeMain.domainModel.HoaDonCT;
import CodeMain.services.HoaDonCTService;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author hungs
 */
public class HoaDonCTServiceImp implements HoaDonCTService {

    @Override
    public List<ViewHoaDonCTResponse> getListAll() {
        List<ViewHoaDonCTResponse> list = new ArrayList<>();
        return list;
    }

    @Override
    public ViewHoaDonCTResponse getOneObj(String ma) {
        return null;
    }

    @Override
    public void save(HoaDonCT hdct) throws Exception {

    }

    @Override
    public void update(HoaDonCT hdct) throws Exception {

    }

    @Override
    public void delete(String ma) throws Exception {

    }

}
