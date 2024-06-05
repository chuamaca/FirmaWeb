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
public class Cliente extends Auditoria {

    public int IdCliente;
    public String Nombre;
    public String NumeroDocumento;
    public String Direccion;
    public String Telefono;
    public String Correo;

    public Cliente() {
    }

    
    
    public Cliente(int IdCliente, String Nombre, String NumeroDocumento, String Direccion, String Telefono, String Correo, int Estado, int UsuarioCrea, Date FechaCrea, int UsuarioModifica, Date FechaModifica, int UsuarioElimina, Date FechaElimina) {
        super(Estado, UsuarioCrea, FechaCrea, UsuarioModifica, FechaModifica, UsuarioElimina, FechaElimina);
        this.IdCliente = IdCliente;
        this.Nombre = Nombre;
        this.NumeroDocumento = NumeroDocumento;
        this.Direccion = Direccion;
        this.Telefono = Telefono;
        this.Correo = Correo;
    }
    
     public Cliente(int IdCliente, String Nombre) {
        this.IdCliente = IdCliente;
        this.Nombre = Nombre;
    }

    public Cliente(int IdCliente, String Nombre, String NumeroDocumento, String Direccion, String Telefono, String Correo) {
        this.IdCliente = IdCliente;
        this.Nombre = Nombre;
        this.NumeroDocumento = NumeroDocumento;
        this.Direccion = Direccion;
        this.Telefono = Telefono;
        this.Correo = Correo;
    }

    public int getIdCliente() {
        return IdCliente;
    }

    public void setIdCliente(int IdCliente) {
        this.IdCliente = IdCliente;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getNumeroDocumento() {
        return NumeroDocumento;
    }

    public void setNumeroDocumento(String NumeroDocumento) {
        this.NumeroDocumento = NumeroDocumento;
    }

    public String getDireccion() {
        return Direccion;
    }

    public void setDireccion(String Direccion) {
        this.Direccion = Direccion;
    }

    public String getTelefono() {
        return Telefono;
    }

    public void setTelefono(String Telefono) {
        this.Telefono = Telefono;
    }

    public String getCorreo() {
        return Correo;
    }

    public void setCorreo(String Correo) {
        this.Correo = Correo;
    }

    @Override
    public String toString() {
        return Nombre;
    }
    
    
    
    
}
