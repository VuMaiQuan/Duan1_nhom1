/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CodeMain.services.serviceImp;

import CodeMain.domainModel.SanPham;
import CodeMain.repository.SanPhamRepository;
import CodeMain.services.SanPhamService;
import java.util.ArrayList;
import java.util.List;


public class SanPhamServiceImp implements SanPhamService{

    private SanPhamRepository _sprepo;
    private List<SanPham>_listsp;

    public SanPhamServiceImp() {
        _sprepo=new SanPhamRepository();
        _listsp=_sprepo.getList();
    }
    
    
    @Override
    public List<SanPham> getListAll() {
  _listsp = _sprepo.getList();
        List<SanPham> list = new ArrayList<>();
        for (SanPham x : _listsp) {
            list.add(x);
        }
        return list.isEmpty() ? null : list;    }

    @Override
    public SanPham getOneObj(String ma) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void save(SanPham sp) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void update(SanPham sp) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void delete(String ma) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
