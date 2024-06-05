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
public class Auditoria {

    private int Estado;
    private int UsuarioCrea;
    private java.sql.Date FechaCrea;
    private int UsuarioModifica;
    private java.sql.Date FechaModifica;
    private int UsuarioElimina;
    private java.sql.Date FechaElimina;

    public Auditoria(int Estado, int UsuarioCrea, Date FechaCrea, int UsuarioModifica, Date FechaModifica, int UsuarioElimina, Date FechaElimina) {
        this.Estado = Estado;
        this.UsuarioCrea = UsuarioCrea;
        this.FechaCrea = FechaCrea;
        this.UsuarioModifica = UsuarioModifica;
        this.FechaModifica = FechaModifica;
        this.UsuarioElimina = UsuarioElimina;
        this.FechaElimina = FechaElimina;
    }

    public Auditoria() {
    }

    public int getEstado() {
        return Estado;
    }

    public void setEstado(int Estado) {
        this.Estado = Estado;
    }

    public int getUsuarioCrea() {
        return UsuarioCrea;
    }

    public void setUsuarioCrea(int UsuarioCrea) {
        this.UsuarioCrea = UsuarioCrea;
    }

    public Date getFechaCrea() {
        return FechaCrea;
    }

    public void setFechaCrea(Date FechaCrea) {
        this.FechaCrea = FechaCrea;
    }

    public int getUsuarioModifica() {
        return UsuarioModifica;
    }

    public void setUsuarioModifica(int UsuarioModifica) {
        this.UsuarioModifica = UsuarioModifica;
    }

    public Date getFechaModifica() {
        return FechaModifica;
    }

    public void setFechaModifica(Date FechaModifica) {
        this.FechaModifica = FechaModifica;
    }

    public int getUsuarioElimina() {
        return UsuarioElimina;
    }

    public void setUsuarioElimina(int UsuarioElimina) {
        this.UsuarioElimina = UsuarioElimina;
    }

    public Date getFechaElimina() {
        return FechaElimina;
    }

    public void setFechaElimina(Date FechaElimina) {
        this.FechaElimina = FechaElimina;
    }

}
