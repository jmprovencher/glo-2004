/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Reseau;
import java.util.*;
/**
 *
 * @author Rémi
 */
public class Node extends  LocationData implements java.io.Serializable{
    
    public Node(int argX, int argY){
        positionX = argX;
        positionY = argY;
        initialPositionX = argX;
        initialPositionY = argY;
        isStation = false;
        listLines = new ArrayList<Line>();
        listRoutes = new ArrayList<Route>();
        listPassenger = new ArrayList<Passenger>();
        listBus = new ArrayList<Bus>();
    }
    
    public void addLine(Line l){
        listLines.add(l);
    }
    

    @Override
    public double getPositionX(){
        return positionX;
    }
    
    @Override
    public double getPositionY(){
        return positionY;
    }
    
    public double getInitialPositionX(){
        return initialPositionX;
    }
    
    public double getInitialPositionY(){
        return initialPositionY;
    }
    
    public void setInitialPositionX(double x){
        initialPositionX = x;
    }
    
    public void setInitialPositionY(double y){
        initialPositionY = y;
    }
    
    @Override
    public void setPositionX(double x){
        positionX = x;
    }
    
    @Override
    public void setPositionY(double y){
        positionY = y;
    }
    
    private double positionX;
    private double positionY;
    private double initialPositionX;
    private double initialPositionY;
    public Boolean isStation;
    
    // *****
    //-----------------Station------------------//
    // *****
     public void setName(String newName){
         if(isStation){
        name = newName;
         }
    }
    
     public Boolean setStation(String arg_nom){
         if (!isStation){
            isStation = true;
            name = arg_nom;
            return true;
         }
         else{
             return false;
         }
     }
     
     public Boolean deleteStation(){
         if (!isStation){
             return false;
         }
         if (listRoutes.isEmpty()){
            isStation = false;
            name = null;
            return true;
         }
         return false;
     }


    public void setRoute(int n, Route r){
  
        if (n == 1){
            if(!listRoutes.contains(r)){
                listRoutes.add(r);
            }
            
        }
        if (n == -1){
            listRoutes.remove(r);
        }
         
    }

    public String getName(){
         if(isStation){
        return name;
         }
         return null;
    }
    

    public int getNumberOfRoutes(){

        return listRoutes.size();

    }
    
    public void addPassenger(Passenger p){
        listPassenger.add(p);
    }
    
    public void addBus(Bus b){
        listBus.add(b);
    }
    
      public void removeBus(Bus b){
        listBus.remove(b);
    }
    
    public void removePassenger(Passenger p){
        listPassenger.remove(p);
    }
    
    public List<Route> listRoutes;
    public List<Line> listLines;
    public List<Passenger> listPassenger;
    public List<Bus> listBus;
    private String name;

}
