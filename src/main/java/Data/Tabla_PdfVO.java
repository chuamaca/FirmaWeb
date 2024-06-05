package Data;

import Modelo.Documento;
import Modelo.Servicio;
import Util.imgTabla;
import java.awt.Image;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Cesar
 */
public class Tabla_PdfVO extends javax.swing.JFrame {

    public void MostrarGrillaArchivoCargado(JTable tabla, int idDocumento) {
        System.out.println("MostrarGrillaArchivoCargado: " + idDocumento);
        tabla.setDefaultRenderer(Object.class, new imgTabla());
        DefaultTableModel dt = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        dt.addColumn("Ruta Origen");
        dt.addColumn("Ver Pdf");
        dt.addColumn("Id");

        ImageIcon icono = null;
        if (get_Image("/Imagen/179483.png") != null) {
            icono = new ImageIcon(get_Image("/Imagen/179483.png"));
            System.out.println("Icono: " + icono);
        }

        DDocumento dao = new DDocumento();
        Documento vo = new Documento();

        Documento doc = new Documento();
        doc.IdDocumento = idDocumento;
        List<Documento> list = dao.SelectByIdDocumento(doc);

        System.out.println(" List<Documento> list = dao.SelectByIdDocumento(doc): " + list.toString());
        if (list.size() > 0) {
            for (int i = 0; i < list.size(); i++) {
                Object fila[] = new Object[4];
                vo = list.get(i);

                fila[0] = vo.getNombreDocumento();
                if (vo.getArchivoOrigen() != null) {
                    fila[1] = new JButton(icono);
                } else {
                    fila[1] = new JButton("Vacio");
                }
                fila[2] = vo.getIdDocumento();

                dt.addRow(fila);
            }
            tabla.setModel(dt);

        }
    }

    public void MostrarGrillaArchivoFirmado(JTable tabla, int idServicio) {
        System.out.println("MostrarGrillaArchivoFirmado: " + idServicio);
        tabla.setDefaultRenderer(Object.class, new imgTabla());
        DefaultTableModel dt = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        dt.addColumn("Ver Pdf");
        dt.addColumn("Archivo");
        dt.addColumn("Id");

        ImageIcon icono = null;
        if (get_Image("/Imagen/179483.png") != null) {
            icono = new ImageIcon(get_Image("/Imagen/179483.png"));
            System.out.println("Icono: " + icono);
        }

        DServicio dServicio = new DServicio();

        Servicio docufirmado = new Servicio();
        docufirmado.setIdServicio(idServicio);

        List<Servicio> listFirmado = dServicio.SelectServicioByIdServicio(docufirmado);

        Servicio vo = new Servicio();
        System.out.println(" List<Servicio> list = dServicio.SelectServicioByIdDocumento(docu): " + listFirmado.toString());
        if (listFirmado.size() > 0) {
            for (int i = 0; i < listFirmado.size(); i++) {
                Object fila[] = new Object[3];
                vo = listFirmado.get(i);

                if (vo.getContenidoDocumento() != null) {
                    fila[0] = new JButton(icono);
                } else {
                    fila[0] = new JButton("Vacio");
                }
                fila[1] = vo.getIdServicio();
                fila[2] = vo.getNombreDocumento();

                dt.addRow(fila);
            }
            tabla.setModel(dt);

        }
    }

    public Image get_Image(String ruta) {
        try {
            ImageIcon imageIcon = new ImageIcon(getClass().getResource(ruta));
            Image mainIcon = imageIcon.getImage();
            return mainIcon;
        } catch (Exception e) {
        }
        return null;
    }
}
