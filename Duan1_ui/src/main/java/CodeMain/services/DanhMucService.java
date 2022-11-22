/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package CodeMain.services.serviceImp;

import CodeMain.domainModel.DanhMuc;
import java.util.List;

/**
 *
 * @author NhatAn
 */
public interface DanhMucService {
    public List<DanhMuc> getListAll();

    public DanhMuc getOneObj(String ma);

    public void save(DanhMuc dm) throws Exception;

    public void update(DanhMuc dm) throws Exception;

    public void delete(String ma) throws Exception;
}
