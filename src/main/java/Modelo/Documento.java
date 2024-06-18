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
    
}
