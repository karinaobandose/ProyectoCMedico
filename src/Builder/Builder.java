/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Builder;

import MVC.Model.Model;

/**
 *
 * @author emalo
 */
public abstract class Builder {

    protected Model Model;

    public Model getModel() {
        return this.Model;
    }

    public abstract void CrearModelo();

}
