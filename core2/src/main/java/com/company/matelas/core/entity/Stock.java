
package com.company.matelas.core.entity;

import java.util.HashSet;

public class Stock {
    static public HashSet<Matelas>stock=new HashSet();
    public Stock(){
        
        stock.add(new Matelas("1","Matelas 1",120,800));
        stock.add(new Matelas("2","Matelas 2",200,800));
        stock.add(new Matelas("3","Matelas 3",550,990));
    }
    
}
