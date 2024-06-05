/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import java.sql.Date;

/**
 *
 * @author Cesar
 */
public class Categoria extends Auditoria {

    private int IdCategoria;
    private String Nombre;
    private String Descripcion;

    public Categoria(int IdCategoria, String Nombre, String Descripcion, int Estado, int UsuarioCrea, Date FechaCrea, int UsuarioModifica, Date FechaModifica, int UsuarioElimina, Date FechaElimina) {
        super(Estado, UsuarioCrea, FechaCrea, UsuarioModifica, FechaModifica, UsuarioElimina, FechaElimina);
        this.IdCategoria = IdCategoria;
        this.Nombre = Nombre;
        this.Descripcion = Descripcion;
    }

    public Categoria() {
    }
     public Categoria(int IdCategoria, String Nombre) {
        this.IdCategoria = IdCategoria;
        this.Nombre = Nombre;
       
    }

    @Override
    public String toString() {
        return  Nombre ;
    }

    
    

    public Categoria(int IdCategoria, String Nombre, String Descripcion) {
        this.IdCategoria = IdCategoria;
        this.Nombre = Nombre;
        this.Descripcion = Descripcion;
    }

    public int getIdCategoria() {
        return IdCategoria;
    }

    public void setIdCategoria(int IdCategoria) {
        this.IdCategoria = IdCategoria;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getDescripcion() {
        return Descripcion;
    }

    public void setDescripcion(String Descripcion) {
        this.Descripcion = Descripcion;
    }


    
}
