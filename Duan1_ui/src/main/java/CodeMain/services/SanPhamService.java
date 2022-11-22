/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package CodeMain.services;

import CodeMain.domainModel.SanPham;
import java.util.List;

/**
 *
 * @author NhatAn
 */
public interface SanPhamService {
    
    public List<SanPham> getListAll();

    public SanPham getOneObj(String ma);

    public void save(SanPham sp) throws Exception;

    public void update(SanPham sp) throws Exception;

    public void delete(String ma) throws Exception;
}
