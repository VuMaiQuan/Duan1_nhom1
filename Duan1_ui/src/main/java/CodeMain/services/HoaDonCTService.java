/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package CodeMain.services;

import CodeMain.Response.ViewHoaDonCTResponse;
import CodeMain.domainModel.ChiTietSP;
import CodeMain.domainModel.HoaDon;
import CodeMain.domainModel.HoaDonCT;
import java.util.List;

/**
 *
 * @author hungs
 */
public interface HoaDonCTService {

    public List<ViewHoaDonCTResponse> getListAll();

    public List<ViewHoaDonCTResponse> getListShowTBLAll(HoaDon hd);

    public HoaDonCT getOneObj(String ma);

    public void save(HoaDonCT hdct) throws Exception;

    public void update(HoaDonCT hdct) throws Exception;

    public void delete(String ma) throws Exception;
}
