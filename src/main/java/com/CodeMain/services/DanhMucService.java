/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.CodeMain.services;

import com.CodeMain.domainModel.DanhMuc;
import java.util.List;

/**
 *
 * @author hungs
 */
public interface DanhMucService {

    public List<DanhMuc> getListAll();

    public DanhMuc getOneObj(String id);

    public void save(DanhMuc dm) throws Exception;

    public void update(DanhMuc dm) throws Exception;

    public void delete(String id) throws Exception;
}
