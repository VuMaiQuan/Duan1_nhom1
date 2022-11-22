/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CodeMain.services.serviceImp;

import CodeMain.domainModel.DanhMuc;
import CodeMain.repository.DanhMucRepository;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author NhatAn
 */
public class DanhMucServiceImp implements DanhMucService {

    private DanhMucRepository _Repository;
    private List<DanhMuc> _List;

    public DanhMucServiceImp() {
        _Repository = new DanhMucRepository();
        _List = _Repository.getAll();
    }

    @Override
    public List<DanhMuc> getListAll() {
        _List = _Repository.getAll();
        List<DanhMuc> list = new ArrayList<>();
        for (DanhMuc x : _List) {
            list.add(x);
        }
        return list.isEmpty() ? null : list;
    }

    @Override
    public DanhMuc getOneObj(String ma) {
        return _Repository.getOneHang(ma);
    }

    @Override
    public void save(DanhMuc dm) throws Exception {
        dm.setId(null);
        try {
            _Repository.create(dm);
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public void update(DanhMuc dm) throws Exception {
         try {
            _Repository.create(dm);
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public void delete(String ma) throws Exception {
         try {
            _Repository.delete(ma);
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }
    public static void main(String[] args) {
        DanhMucServiceImp dm=new DanhMucServiceImp();
        for (var o : dm.getListAll()) {
            System.out.println(o.toString());
        }
    }

}
