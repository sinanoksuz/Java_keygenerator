package generatorlist;

import javax.swing.table.DefaultTableModel;

public class MyModel extends DefaultTableModel {
	//it is defined for cellEditable 
	//because of this, it is called DefaultTableModel as extends
	public MyModel(Object [][] data,Object [] cols) {
		super(data,cols);
	}
	public boolean isCellEditable(int row,int col) {
		return false;
	}
}
