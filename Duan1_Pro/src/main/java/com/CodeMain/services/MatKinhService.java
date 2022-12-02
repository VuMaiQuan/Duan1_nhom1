/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.CodeMain.services;

import com.CodeMain.domainModel.MatKinh;
import java.util.List;

/**
 *
 * @author NhatAn
 */
public interface MatKinhService {

    public List<MatKinh> getListAll();

    public MatKinh getOneObj(String ma);

    public void save(MatKinh mk) throws Exception;

    public void update(MatKinh mk) throws Exception;

    public void delete(String ma) throws Exception;
}
