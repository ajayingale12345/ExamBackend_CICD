
package com.cybage.service;

import java.util.List;


import com.cybage.entity.Catagory;

public interface CatagoryService {
  public Catagory addCatagory(Catagory catagory);
  public Catagory updateCatagory(Catagory catagory);
  public List<Catagory> getCatagories( );
  public Catagory getCatagory(Long catogaryId);
  public void deleteCatagory(Long catogaryId);
  
}
