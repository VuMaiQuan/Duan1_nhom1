/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.com.CodeMain.services;

import com.CodeMain.domainModel.Hang;
import java.util.List;

/**
 *
 * @author NhatAn
 */
public interface HangService {

    public List<Hang> getAll();

    public Hang getOneObj(String ma);

    public void save(Hang hang) throws Exception;

    public void update(Hang hang) throws Exception;

    public void delete(String ma) throws Exception;

}
