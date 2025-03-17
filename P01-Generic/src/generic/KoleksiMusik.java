package generic;

import java.awt.event.MouseEvent;
import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;
import java.util.List;

public class KoleksiMusik extends AbstractTableModel {
    private final List<Musik> daftarMusik = new ArrayList<>();
    private final String[] kolom = {"Nama File", "Ukuran", "Ekstensi"};

    public void add(Musik m) {
        daftarMusik.add(m);
        fireTableDataChanged();
    }

    public void clear() {
        daftarMusik.clear();
        fireTableDataChanged();
    }

    public Musik get(int index) {
        return daftarMusik.get(index);
    }

    @Override
    public int getRowCount() {
        return daftarMusik.size();
    }

    @Override
    public int getColumnCount() {
        return kolom.length;
    }

    @Override
    public String getColumnName(int column) {
        return kolom[column];
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Musik m = daftarMusik.get(rowIndex);
        return switch (columnIndex) {
            case 0 -> m.getFileName();
            case 1 -> m.getFileSize();
            case 2 -> m.getExtension();
            default -> null;
        };
    }

    public void popuptombolMouseClicked(MouseEvent evt) {
    }
}
