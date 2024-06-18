/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import java.sql.Date;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 *
 * @author Cesar
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ServicioDocumento extends Documento {
    
    
    public int IdServicio;
    public int IdUsuario;
    public int IdDocumento;
    public byte[] ContenidoDocumento;
    public String TipoDocumento;
    public String NombreDocumento;
    public String Lugar;
    public java.sql.Date FechaServicio;
    public java.sql.Date FechaVigencia;
    
    public String UsuarioFirma;
    public String Categoria;
    public String Empresa;
     
}
