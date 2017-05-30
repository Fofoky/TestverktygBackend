/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testverktygfrontend.logic;

public class Logic {
    
    private static Logic instance;
    
    private Logic(){}
    
    public static Logic getInstance(){
        if(instance == null){
            instance = new Logic();
        }
        return instance;
    }
    
    
    
    
    
    
}
