/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.CodeMain.services;

import com.CodeMain.domainModel.NoiSX;
import java.util.List;
import javax.naming.NoInitialContextException;

/**
 *
 * @author NhatAn
 */
public interface NSXService {

    public List<NoiSX> getListAll();

    public NoiSX getOneObj(String ma);

    public void save(NoiSX nsx) throws Exception;

    public void update(NoiSX ctsp) throws Exception;

    public void delete(String ma) throws Exception;
}
