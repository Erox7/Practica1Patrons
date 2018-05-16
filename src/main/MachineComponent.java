package main;

import java.util.Observable;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ssh5
 */

//Aplicariem el patró Observer per a poder monitoritzar els canvis d'estat i,
//així, notificar els observadors.

public abstract class MachineComponent extends Observable{
    protected boolean broken = false;
    
    public abstract void setBroken();
    public abstract void repair();
    public abstract boolean isBroken();
}
