/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.CodeMain.services;

import com.CodeMain.domainModel.MauSac;
import java.util.List;

/**
 *
 * @author hungs
 */
public interface MauSacService {

    public List<MauSac> getListAll();

    public MauSac getOneObj(String sdt);

    public void save(MauSac ms) throws Exception;

    public void update(MauSac ms) throws Exception;

    public void delete(String ma) throws Exception;
}
