import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.swing.table.AbstractTableModel;

public class TableData extends AbstractTableModel {
	public List<Transaction> list;
	private String[] headers = { "번호","이름", "이메일", "전화번호", "성별", "메모" };

	public TableData() {
		updateList();
	}

	public String getColumnName(int cell) {
		return headers[cell];
	}

	public void updateList() {
		list = new ArrayList<>();
		try {
			Scanner sc = new Scanner(new File("C:\\java\\workspace\\cm_program\\data.csv"));
			for (int i = 0; sc.hasNextLine(); i++) {
				String[] data = sc.nextLine().split(",");
				if (i != 0) {
					Transaction t = new Transaction();
					TransactionBuilder tb = new TransactionBuilder(t);
					if (data.length < 6) {
						t = tb.idx(data[0]).name(data[1]).email(data[2]).phone(data[3]).gender(data[4])
								.transaction();
					} else {
						t = tb.idx(data[0]).name(data[1]).email(data[2]).phone(data[3]).gender(data[4]).note(data[5])
								.transaction();
					}
					list.add(t);
				}
			}
			sc.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void deleteList(int rowIndex) {
		String deleteName = list.get(rowIndex).getName();
		list = new ArrayList<>();
		try {
			Scanner sc = new Scanner(new File("./data.csv"));
			for (int i = 0; sc.hasNextLine(); i++) {
				String[] data = sc.nextLine().split(",");
				if (i != 0) {
					Transaction t = new Transaction();
					TransactionBuilder tb = new TransactionBuilder(t);
					if (data.length < 6) {
						t = tb.idx(data[0]).name(data[1]).email(data[2]).phone(data[3]).gender(data[4])
								.transaction();
					} else {
						t = tb.idx(data[0]).name(data[1]).email(data[2]).phone(data[3]).gender(data[4]).note(data[5])
								.transaction();
					}
					if (t.getName().equals(deleteName))
						continue;
					list.add(t);
				}
			}
			super.fireTableDataChanged();
			sc.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void deleteList2(int rowIndex) {
		list.get(rowIndex).setName("");
//		String deleteName = list.get(rowIndex).getName();
//		for (int j = 0; j < list.size(); j++) {
//			if (list.get(j).getName().equals(deleteName)) {
//				list.get(j).setName("");
//				break;
//			}
//		}
		refresh();
	}

	@Override
	public int getRowCount() {
		return list.size();
	}

	@Override
	public int getColumnCount() {
		return 6;
	}

	@Override
	public Object getValueAt(int row, int cell) {
		switch (cell) {
		case 0:
			return list.get(row).getIdx();
		case 1:
			return list.get(row).getName();
		case 2:
			return list.get(row).getEmail();
		case 3:
			return list.get(row).getPhone();
		case 4:
			return list.get(row).getGender();
		case 5:
			return list.get(row).getNote();
		}
		return null;
	}

	public void refresh() {
		updateList();
		super.fireTableDataChanged();
	}

}
