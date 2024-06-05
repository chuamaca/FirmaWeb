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
public class Documento extends Auditoria {

    public int IdDocumento;
    public int IdCliente;
    public int IdCategoria;
    public byte[] ArchivoOrigen;
    public String TipoDocumento;
    public String NombreDocumento;

//    public Documento(int IdDocumento, int IdCliente, int IdCategoria, byte[] ArchivoOrigen, String TipoDocumento, String NombreDocumento, int Estado, int UsuarioCrea, Date FechaCrea, int UsuarioModifica, Date FechaModifica, int UsuarioElimina, Date FechaElimina) {
//        super(Estado, UsuarioCrea, FechaCrea, UsuarioModifica, FechaModifica, UsuarioElimina, FechaElimina);
//        this.IdDocumento = IdDocumento;
//        this.IdCliente = IdCliente;
//        this.IdCategoria = IdCategoria;
//        this.ArchivoOrigen = ArchivoOrigen;
//        this.TipoDocumento = TipoDocumento;
//        this.NombreDocumento = NombreDocumento;
//    }
//
//    public Documento(int IdDocumento, int IdCliente, int IdCategoria, byte[] ArchivoOrigen, String TipoDocumento, String NombreDocumento) {
//        this.IdDocumento = IdDocumento;
//        this.IdCliente = IdCliente;
//        this.IdCategoria = IdCategoria;
//        this.ArchivoOrigen = ArchivoOrigen;
//        this.TipoDocumento = TipoDocumento;
//        this.NombreDocumento = NombreDocumento;
//    }
//
//    public Documento() {
//    }
//
//    
//    public int getIdDocumento() {
//        return IdDocumento;
//    }
//
//    public void setIdDocumento(int IdDocumento) {
//        this.IdDocumento = IdDocumento;
//    }
//
//    public int getIdCliente() {
//        return IdCliente;
//    }
//
//    public void setIdCliente(int IdCliente) {
//        this.IdCliente = IdCliente;
//    }
//
//    public int getIdCategoria() {
//        return IdCategoria;
//    }
//
//    public void setIdCategoria(int IdCategoria) {
//        this.IdCategoria = IdCategoria;
//    }
//
//    public byte[] getArchivoOrigen() {
//        return ArchivoOrigen;
//    }
//
//    public void setArchivoOrigen(byte[] ArchivoOrigen) {
//        this.ArchivoOrigen = ArchivoOrigen;
//    }
//
    public String getTipoDocumento() {
        return TipoDocumento;
    }
//
    public void setTipoDocumento(String TipoDocumento) {
        this.TipoDocumento = TipoDocumento;
    }
//
//    public String getNombreDocumento() {
//        return NombreDocumento;
//    }
//
//    public void setNombreDocumento(String NombreDocumento) {
//        this.NombreDocumento = NombreDocumento;
//    }

}
