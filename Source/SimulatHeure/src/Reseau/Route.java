/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


package Reseau;

import java.util.*;
/**
 *
 * @author Sam
 */
public class Route {
    public Route(int arg_numero, int arg_frequence, int arg_t_depart, List<Node> p){
        number = arg_numero;
        frequency = arg_frequence;
        timeFirstStart = arg_t_depart;
        timeNextStart = arg_t_depart;
        route = new ArrayList<Node>(p);
        listBus = new ArrayList<Bus>();
        if (p.get(0) == p.get(p.size()-1)){
            isLoop = true;
        }
        else{
            isLoop = false;
        }
        loopDone = false;
        System.out.println(isLoop);
    }
    
    public void reset(){
        listBus.clear();
        loopDone = false;
        timeNextStart = timeFirstStart;
    }
    
    public Bus addBus(){
        if (!loopDone){
            Bus newBus = new Bus(0, this, 0);
            listBus.add(newBus);
            return newBus;
        }
        return null;
    }
    
    public void deleteBus(Bus b){
        listBus.remove(b);
    }
    
    
    public void setNumber(int arg_num){
        number = arg_num;
    }
    
    public int getNumber(){
        return number;
    }
    
    public int getFrequency(){
        return frequency;
    }
    
    public int getTimeNextStart(){
        return timeNextStart;
    }
    
    public void setTimeNextStart(double time){
        timeNextStart += time;
    }
    
    public Node getNodeFromIndex(int index){
        return route.get(index);
    }
    
    public int getNumberOfNodes(){
        return route.size();
    }
    
    public Line getLineFromIndex(int i){
        if (i+1 < route.size())
        {
            for (Line a: route.get(i).listLines){
                if (a.origine == route.get(i+1) || a.destination == route.get(i+1) ){
                    if (a.origine == route.get(i) || a.destination == route.get(i) ){
                        return a;
                    }

                }
            }
        }
        return null;
    }
    
    private List<Node> route;
    public List<Bus> listBus;
    private int number;
    private int frequency;
    private int timeFirstStart;
    private int timeNextStart;
    public Boolean isLoop;
    public Boolean loopDone;
}