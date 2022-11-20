/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CodeMain.services.serviceImp;

import CodeMain.Response.ViewHoaDonResponse;
import CodeMain.domainModel.HoaDon;
import CodeMain.repository.HoaDonRepository;
import CodeMain.services.HoaDonService;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author hungs
 */
public class HoaDonServiceImp implements HoaDonService {

    HoaDonRepository hdRepository;
    List<HoaDon> listHD;

    public HoaDonServiceImp() {
        hdRepository = new HoaDonRepository();
        listHD = hdRepository.getListAll();
    }

    @Override
    public List<ViewHoaDonResponse> getListAll() {
        List<ViewHoaDonResponse> list = new ArrayList<>();
        for (HoaDon x : listHD) {
            list.add(new ViewHoaDonResponse(x));
        }
        return list.isEmpty() ? null : list;
    }

    @Override
    public ViewHoaDonResponse getOneObj(String ma) {
        return null;
    }

    @Override
    public void save(HoaDon hd) throws Exception {
        hd.setId(null);
        try {
            hdRepository.create(hd);
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public void update(HoaDon hd) throws Exception {
        try {
            hdRepository.create(hd);
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public void delete(String ma) throws Exception {
        try {
            hdRepository.delete(ma);
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

}
