/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.CodeMain.services;

import com.CodeMain.domainModel.SanPham;
import java.util.List;

/**
 *
 * @author hungs
 */
public interface SanPhamService {

    public List<SanPham> getListAll();

    public SanPham getOneObj(String ma);

    public void save(SanPham tk) throws Exception;

    public void update(SanPham tk) throws Exception;

    public void delete(String ma) throws Exception;
}
