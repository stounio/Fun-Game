package com.gpichot.fungame.gui.component;

import static com.gpichot.fungame.resource.FunGameConstants.FUNGAME_NUMBER_OF_DEAD_HEAT_HEADER_KEY;
import static com.gpichot.fungame.resource.FunGameConstants.FUNGAME_NUMBER_OF_LOSSES_HEADER_KEY;
import static com.gpichot.fungame.resource.FunGameConstants.FUNGAME_NUMBER_OF_WINS_HEADER_KEY;

import java.awt.Font;
import java.util.Enumeration;

import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableColumn;
import javax.swing.table.TableModel;

import com.gpichot.fungame.factory.GamePlayServiceFactory;
import com.gpichot.fungame.game.om.GameScoringBoard;
import com.gpichot.fungame.game.service.GamePlayService;
import com.gpichot.fungame.resource.service.ResourceService;

public class FunGameGuiScoringBoard {
	
	private JTable scoringBoardTable;
	private JPanel scoringBoardPanel;
	
	public FunGameGuiScoringBoard(){
		scoringBoardTable = new JTable(new ScoringBoardTableModel());
		scoringBoardTable.setRowHeight(50);
		scoringBoardTable.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		scoringBoardTable.setFont(new Font("sansserif", Font.BOLD, 32));
		Enumeration<TableColumn> columns = scoringBoardTable.getColumnModel().getColumns();
		while(columns.hasMoreElements()){
			TableColumn column = columns.nextElement();
			column.setPreferredWidth(200);
		}
		scoringBoardPanel = new JPanel();
		scoringBoardPanel.add(scoringBoardTable);
	}

	public void addScoringBoardToPanel(JPanel panel) {
		panel.add(scoringBoardPanel);
	}

	public void display() {
		updateScoringBoard();
		scoringBoardPanel.setVisible(true);
	}
	

	public void hide() {
		scoringBoardPanel.setVisible(false);
	}
	
	private void updateScoringBoard() {
		GamePlayService gamePlayService = GamePlayServiceFactory.getFactory().getInstance();
		GameScoringBoard gameScoringBoard = gamePlayService.getPlayerScoringBoard();
		TableModel tableModel = scoringBoardTable.getModel();
		tableModel.setValueAt(gameScoringBoard.getWins(), 1, 0);
		tableModel.setValueAt(gameScoringBoard.getLosses(), 1, 1);
		tableModel.setValueAt(gameScoringBoard.getDeadHeats(), 1, 2);
	}
	
	 
	@SuppressWarnings("serial")
	private class ScoringBoardTableModel extends AbstractTableModel{
		private String columnNames[] = {ResourceService.getService().getResource(FUNGAME_NUMBER_OF_WINS_HEADER_KEY), 
				ResourceService.getService().getResource(FUNGAME_NUMBER_OF_LOSSES_HEADER_KEY), 
				ResourceService.getService().getResource(FUNGAME_NUMBER_OF_DEAD_HEAT_HEADER_KEY)
				};
		
		private Object rowTableData[][] = {{ResourceService.getService().getResource(FUNGAME_NUMBER_OF_WINS_HEADER_KEY), 
			ResourceService.getService().getResource(FUNGAME_NUMBER_OF_LOSSES_HEADER_KEY), 
			ResourceService.getService().getResource(FUNGAME_NUMBER_OF_DEAD_HEAT_HEADER_KEY)
			},{0,0,0}};
		
		@Override
		public int getColumnCount() {
			return columnNames.length;
		}

		@Override
		public int getRowCount() {
			return rowTableData.length;
		}

		@Override
		public Object getValueAt(int row, int column) {
			return rowTableData[row][column];
		}
		
		 public void setValueAt(Object value, int row, int column) {
			 rowTableData[row][column] = value;
			 fireTableCellUpdated(row, column);
		}
		 
		
		
	}
}
