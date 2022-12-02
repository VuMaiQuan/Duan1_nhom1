/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.CodeMain.services.serviceImp;

import com.CodeMain.domainModel.MatKinh;
import com.CodeMain.repository.MatKinhRepository;
import com.CodeMain.services.MatKinhService;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author NhatAn
 */
public class MatKinhServiceImp implements MatKinhService {

    private MatKinhRepository _Repository;
    private List<MatKinh> _List;

    public MatKinhServiceImp() {
        _Repository = new MatKinhRepository();
        _List = _Repository.getAll();
    }

    @Override
    public List<MatKinh> getListAll() {
        _List = _Repository.getAll();
        List<MatKinh> list = new ArrayList<>();
        for (MatKinh x : _List) {
            list.add(x);
        }
        return list.isEmpty() ? null : list;
    }

    @Override
    public MatKinh getOneObj(String ma) {
        return _Repository.getOneHang(ma);
    }

    @Override
    public void save(MatKinh mk) throws Exception {
        mk.setId(null);
        try {
            _Repository.create(mk);
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public void update(MatKinh mk) throws Exception {
        try {
            _Repository.create(mk);
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
        MatKinhServiceImp mk = new MatKinhServiceImp();
        for (var o : mk.getListAll()) {
            System.out.println(o.toString());
        }
    }

}
