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
public class Usuario extends Auditoria {

    public int IdUsuario;
    public String NombreUsuario;
    public String Contrasena;
    public String Correo;
    public String TipoDocumento;
    public String NumeroDocumento;
    public String Imagen;
    
    public Usuario(){
        
    }

    public Usuario(int IdUsuario, String NombreUsuario, String Contrasena, String Correo, String TipoDocumento, String NumeroDocumento, String Imagen, int Estado, int UsuarioCrea, Date FechaCrea, int UsuarioModifica, Date FechaModifica, int UsuarioElimina, Date FechaElimina) {
        super(Estado, UsuarioCrea, FechaCrea, UsuarioModifica, FechaModifica, UsuarioElimina, FechaElimina);
        this.IdUsuario = IdUsuario;
        this.NombreUsuario = NombreUsuario;
        this.Contrasena = Contrasena;
        this.Correo = Correo;
        this.TipoDocumento = TipoDocumento;
        this.NumeroDocumento = NumeroDocumento;
        this.Imagen = Imagen;
    }

    public Usuario(int IdUsuario, String NombreUsuario, String Contrasena, String Correo, String TipoDocumento, String NumeroDocumento, String Imagen) {
        this.IdUsuario = IdUsuario;
        this.NombreUsuario = NombreUsuario;
        this.Contrasena = Contrasena;
        this.Correo = Correo;
        this.TipoDocumento = TipoDocumento;
        this.NumeroDocumento = NumeroDocumento;
        this.Imagen = Imagen;
    }

    public int getIdUsuario() {
        return IdUsuario;
    }

    public void setIdUsuario(int IdUsuario) {
        this.IdUsuario = IdUsuario;
    }

    public String getNombreUsuario() {
        return NombreUsuario;
    }

    public void setNombreUsuario(String NombreUsuario) {
        this.NombreUsuario = NombreUsuario;
    }

    public String getContrasena() {
        return Contrasena;
    }

    public void setContrasena(String Contrasena) {
        this.Contrasena = Contrasena;
    }

    public String getCorreo() {
        return Correo;
    }

    public void setCorreo(String Correo) {
        this.Correo = Correo;
    }

    public String getTipoDocumento() {
        return TipoDocumento;
    }

    public void setTipoDocumento(String TipoDocumento) {
        this.TipoDocumento = TipoDocumento;
    }

    public String getNumeroDocumento() {
        return NumeroDocumento;
    }

    public void setNumeroDocumento(String NumeroDocumento) {
        this.NumeroDocumento = NumeroDocumento;
    }

    public String getImagen() {
        return Imagen;
    }

    public void setImagen(String Imagen) {
        this.Imagen = Imagen;
    }

}
