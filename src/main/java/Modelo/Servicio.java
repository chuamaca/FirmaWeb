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
public class Servicio extends Auditoria  {

    public int IdServicio;
    public int IdUsuario;
    public int IdDocumento;
    public byte[] ContenidoDocumento;
    public String TipoDocumento;
    public String NombreDocumento;
    public String Lugar;
    public java.sql.Date FechaServicio;
    public java.sql.Date FechaVigencia;

    public Servicio(int IdServicio, int IdUsuario, int IdDocumento, byte[] ContenidoDocumento, String TipoDocumento, String NombreDocumento, String Lugar, Date FechaServicio, Date FechaVigencia, int Estado, int UsuarioCrea, Date FechaCrea, int UsuarioModifica, Date FechaModifica, int UsuarioElimina, Date FechaElimina) {
        super(Estado, UsuarioCrea, FechaCrea, UsuarioModifica, FechaModifica, UsuarioElimina, FechaElimina);
        this.IdServicio = IdServicio;
        this.IdUsuario = IdUsuario;
        this.IdDocumento = IdDocumento;
        this.ContenidoDocumento = ContenidoDocumento;
        this.TipoDocumento = TipoDocumento;
        this.NombreDocumento = NombreDocumento;
        this.Lugar = Lugar;
        this.FechaServicio = FechaServicio;
        this.FechaVigencia = FechaVigencia;
    }

    public Servicio(int IdServicio, int IdUsuario, int IdDocumento, byte[] ContenidoDocumento, String TipoDocumento, String NombreDocumento, String Lugar, Date FechaServicio, Date FechaVigencia) {
        this.IdServicio = IdServicio;
        this.IdUsuario = IdUsuario;
        this.IdDocumento = IdDocumento;
        this.ContenidoDocumento = ContenidoDocumento;
        this.TipoDocumento = TipoDocumento;
        this.NombreDocumento = NombreDocumento;
        this.Lugar = Lugar;
        this.FechaServicio = FechaServicio;
        this.FechaVigencia = FechaVigencia;
    }

    public Servicio() {
    }
    
    

    public int getIdServicio() {
        return IdServicio;
    }

    public void setIdServicio(int IdServicio) {
        this.IdServicio = IdServicio;
    }

    public int getIdUsuario() {
        return IdUsuario;
    }

    public void setIdUsuario(int IdUsuario) {
        this.IdUsuario = IdUsuario;
    }

    public int getIdDocumento() {
        return IdDocumento;
    }

    public void setIdDocumento(int IdDocumento) {
        this.IdDocumento = IdDocumento;
    }

    public byte[] getContenidoDocumento() {
        return ContenidoDocumento;
    }

    public void setContenidoDocumento(byte[] ContenidoDocumento) {
        this.ContenidoDocumento = ContenidoDocumento;
    }

    public String getTipoDocumento() {
        return TipoDocumento;
    }

    public void setTipoDocumento(String TipoDocumento) {
        this.TipoDocumento = TipoDocumento;
    }

    public String getNombreDocumento() {
        return NombreDocumento;
    }

    public void setNombreDocumento(String NombreDocumento) {
        this.NombreDocumento = NombreDocumento;
    }

    public String getLugar() {
        return Lugar;
    }

    public void setLugar(String Lugar) {
        this.Lugar = Lugar;
    }

    public Date getFechaServicio() {
        return FechaServicio;
    }

    public void setFechaServicio(Date FechaServicio) {
        this.FechaServicio = FechaServicio;
    }

    public Date getFechaVigencia() {
        return FechaVigencia;
    }

    public void setFechaVigencia(Date FechaVigencia) {
        this.FechaVigencia = FechaVigencia;
    }

}
