package com.lectopia.quinque.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;

public class MultiPlayListView extends JPanel {
   private JScrollPane scrollbar;
   private DefaultTableModel model;

   private JButton btnPrev;
   private JButton btnMypage;
   private JButton btnSearchRoom;
   private JButton btnCreateRoom;
   private JButton btnRefresh;
   private JButton btnQuickMatch;

   private Object[] col;
   private Object[][] row;

   private JTable tableRoomList;
   private JTextField searchRoom;

   public MultiPlayListView() {

      setBackground(new Color(244, 228, 223));

      row = new Object[][] { { "1", "1대1", "어서와","게임중"  }, { "2", "3인", "빨리와","게임중"  },
            { "3", "2대2", "왕초보만","참가" } };

      col = new String[] { "번호", "게임모드", "방 제목", "비고" };

      model = new DefaultTableModel(row, col){
         public boolean isCellEditable(int i, int c)
         {
            if(c != 3)
            {
               return false;
            }
            return true;
         }
      };
      tableRoomList = new JTable(model);
      tableRoomList.setAlignmentY(Component.BOTTOM_ALIGNMENT);
      tableRoomList.setAlignmentX(Component.RIGHT_ALIGNMENT);
      tableRoomList.setSelectionBackground(new Color(000, 204, 255));
      tableRoomList.setShowVerticalLines(false);
      tableRoomList.setRowSelectionAllowed(true);
      tableRoomList.setIntercellSpacing(new Dimension(0, 0));
      tableRoomList.setFocusable(false);
      tableRoomList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
      tableRoomList.setFont(new Font("메이플스토리", Font.PLAIN, 14));
      
      DefaultTableCellRenderer renderer = new DefaultTableCellRenderer();
      renderer.setHorizontalAlignment(SwingConstants.CENTER);
      
      
      
      tableRoomList.getColumnModel().getColumn(0).setCellRenderer(renderer);
      tableRoomList.getColumnModel().getColumn(1).setCellRenderer(renderer);
      tableRoomList.getColumnModel().getColumn(2).setCellRenderer(renderer);
      
      tableRoomList.getColumnModel().getColumn(3).setCellRenderer(new MyTableCellRenderer());
      tableRoomList.getColumnModel().getColumn(3).setCellEditor(new ButtonEditor(new JTextField()));
      JPanel panel = new JPanel();
      panel.setBounds(202, 240, 675, 386);
      add(panel);
      panel.setLayout(new BorderLayout(0, 0));

      panel.setLayout(new BorderLayout());
      scrollbar = new JScrollPane(tableRoomList);
      scrollbar.setBackground(new Color(204, 204, 051));

      panel.add(scrollbar);
      tableRoomList.getTableHeader().setReorderingAllowed(false); // 셀 이동 금지
      tableRoomList.getTableHeader().setResizingAllowed(false); // 셀 간격 고정
      tableRoomList.getTableHeader().setFont(new Font("배달의민족 한나는 열한살", Font.BOLD, 18));
      tableRoomList.getTableHeader().setBackground(new Color(244, 176, 44));
      // tableRoomList.getTableHeader().setForeground(new Color(66, 101, 244));
      tableRoomList.getTableHeader().getHeight();
      tableRoomList.setRowHeight(33);
      tableRoomList.getTableHeader().setOpaque(false);
      tableRoomList.setBackground(new Color(255, 255, 153));
      
      
      
      tableRoomList.getColumnModel().getColumn(0).setMaxWidth(50);
      tableRoomList.getColumnModel().getColumn(1).setMaxWidth(300);
      tableRoomList.getColumnModel().getColumn(2).setMinWidth(400);
      
      add(panel);

      

      model.addRow(new String[] { "11", "3대3", "어서와", "게임중" });

      setLayout(null);

      btnPrev = new JButton("");
      btnPrev.setIcon(new ImageIcon(MultiPlayListView.class.getResource("/multiGameList/logout.png")));
      btnPrev.setFont(new Font("메이플스토리", Font.BOLD, 26));
      btnPrev.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
      btnPrev.setBounds(38, 29, 158, 81);
      add(btnPrev);

      btnSearchRoom = new JButton("");
      btnSearchRoom.setIcon(new ImageIcon(MultiPlayListView.class.getResource("/multiGameList/searchRoom.png")));
      btnSearchRoom.setFont(new Font("메이플스토리", Font.BOLD, 23));
      btnSearchRoom.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
      btnSearchRoom.setBounds(956, 159, 181, 80);
      add(btnSearchRoom);

      btnRefresh = new JButton("");
      btnRefresh.setIcon(new ImageIcon(MultiPlayListView.class.getResource("/multiGameList/refresh.png")));
      btnRefresh.setFont(new Font("메이플스토리", Font.BOLD, 26));
      btnRefresh.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
      btnRefresh.setBounds(993, 249, 97, 80);
      add(btnRefresh);

      btnMypage = new JButton("");
      btnMypage.setIcon(new ImageIcon(MultiPlayListView.class.getResource("/multiGameList/myPage.png")));
      btnMypage.setFont(new Font("메이플스토리", Font.BOLD, 29));
      btnMypage.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
      btnMypage.setBounds(930, 47, 214, 81);
      add(btnMypage);

      searchRoom = new JTextField();
      searchRoom.setHorizontalAlignment(SwingConstants.RIGHT);
      searchRoom.setFont(new Font("메이플스토리", Font.PLAIN, 14));
      searchRoom.setBounds(202, 178, 675, 36);
      add(searchRoom);
      searchRoom.setColumns(10);

      btnQuickMatch = new JButton("");
      btnQuickMatch.setIcon(new ImageIcon(MultiPlayListView.class.getResource("/multiGameList/quickMatch.png")));
      btnQuickMatch.setFont(new Font("메이플스토리", Font.BOLD, 30));
      btnQuickMatch.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
      btnQuickMatch.setBounds(950, 556, 187, 70);
      add(btnQuickMatch);

      btnCreateRoom = new JButton("");
      btnCreateRoom.setIcon(new ImageIcon(MultiPlayListView.class.getResource("/multiGameList/createRoom.png")));
      btnCreateRoom.setFont(new Font("메이플스토리", Font.BOLD, 30));
      btnCreateRoom.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
      btnCreateRoom.setBounds(950, 476, 187, 70);
      add(btnCreateRoom);

      JLabel labelRoom = new JLabel("\uBC29");
      labelRoom.setForeground(Color.DARK_GRAY);
      labelRoom.setFont(new Font("메이플스토리", Font.BOLD, 75));
      labelRoom.setBounds(436, 29, 121, 144);
      add(labelRoom);

      JLabel labelList = new JLabel("\uBAA9\uB85D");
      labelList.setForeground(Color.DARK_GRAY);
      labelList.setFont(new Font("메이플스토리", Font.BOLD, 75));
      labelList.setBounds(539, 35, 205, 133);
      add(labelList);

      JComboBox cbModeSelect = new JComboBox();
      cbModeSelect.setModel(new DefaultComboBoxModel(new String[] { "\uAC8C\uC784 \uBAA8\uB4DC \uC120\uD0DD",
            "2\uC778 \uBAA8\uB4DC", "3\uC778 \uBAA8\uB4DC", "4\uC778 \uBAA8\uB4DC" }));
      cbModeSelect.setBackground(new Color(255, 255, 255));
      cbModeSelect.setFont(new Font("배달의민족 한나는 열한살", Font.PLAIN, 19));
      cbModeSelect.setBounds(950, 357, 181, 36);
      add(cbModeSelect);

      MultiPlayListViewHandler handler = new MultiPlayListViewHandler();
      btnSearchRoom.addActionListener(handler);
      btnRefresh.addActionListener(handler);
      btnMypage.addActionListener(handler);
      btnQuickMatch.addActionListener(handler);
      btnCreateRoom.addActionListener(handler);
      btnPrev.addActionListener(handler);

      btnSearchRoom.setContentAreaFilled(false);
      btnSearchRoom.setFocusPainted(false);
      btnSearchRoom.setBorderPainted(false);

      btnRefresh.setContentAreaFilled(false);
      btnRefresh.setFocusPainted(false);
      btnRefresh.setBorderPainted(false);

      btnMypage.setContentAreaFilled(false);
      btnMypage.setFocusPainted(false);
      btnMypage.setBorderPainted(false);

      btnQuickMatch.setContentAreaFilled(false);
      btnQuickMatch.setFocusPainted(false);
      btnQuickMatch.setBorderPainted(false);

      btnCreateRoom.setContentAreaFilled(false);
      btnCreateRoom.setFocusPainted(false);
      btnCreateRoom.setBorderPainted(false);

      btnPrev.setContentAreaFilled(false);
      btnPrev.setFocusPainted(false);
      btnPrev.setBorderPainted(false);

   }

   private class MultiPlayListViewHandler implements ActionListener {
      public void actionPerformed(ActionEvent e) {
         ChangePanelService c = ChangePanelService.getInstance();
         JButton btn = (JButton) e.getSource();
         if (btn.equals(btnPrev)) {
            c.changePanel("LoginView");
         } else if (btn.equals(btnMypage)) {
            c.changePanel("MyPageView");
         } else if (btn.equals(btnRefresh)) {
            c.changePanel("MultiPlayListView"); // 새로고침은 어떻게 하지?
         } else if (btn.equals(btnCreateRoom)) {
            c.changePanel("MultiRoomView");
         } else if (btn.equals(btnQuickMatch)) {
            c.changePanel("MultiRoomView");
         } else if (btn.equals(btnSearchRoom)) {
            // 텍스트의 값 가져와서 목록의 방 제목에 있는지 확인하고 있는거 보여주기
         }
      }
   }
}