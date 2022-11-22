/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package CodeMain.services;

import CodeMain.domainModel.MauSac;
import java.util.List;

/**
 *
 * @author NhatAn
 */
public interface MauSacService {
    public List<MauSac> getListAll();

    public MauSac getOneObj(String ma);

    public void save(MauSac ms) throws Exception;

    public void update(MauSac ms) throws Exception;

    public void delete(String ma) throws Exception;
}
