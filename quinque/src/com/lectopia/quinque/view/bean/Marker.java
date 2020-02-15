package com.lectopia.quinque.view.bean;

import java.awt.Rectangle;



/**
 * 말에 대한 정보를 가지고 있는 클래스다.
 * @author QuinqueBliss
 *
 */
public class Marker {
   /**
    * 가위, 바위, 보, 물음표, 와일드카드 가위, 와일드카드 바위, 와일드카드 보, 와일드카드 물음표의
    * 정보를 가지고 있다.
    */
   private Cane cane;
   /**
    * 타일에 지정된 번호다.
    */
   private int mapTileNum;
   /**
    * 버튼의 actionCommand와 일치하는 이름이다.
    */
   private String name;
   /**
    * url
    */
   private String[] image;
   /**
    * 말이 선택 되었는지 표시해주는 역할을 한다.
    */
   private boolean selected;
   /**
    * 상대방 턴인지 내턴인지 알려주는 역할을 한다.
    */
   private int turn;
   /**
    * 골인했는지 알려주는 역할을 한다.
    */
   private boolean goalFlag;
   private boolean hiddenFlag;
   private Rectangle rectangle;
   
   /**
    * null parameter 생성자다.
    */
   public Marker() {}
   
   public Marker(Cane cane, String name) {
	   this.cane = cane;
	   this.name = name;
	   this.mapTileNum = -1;
   }
   
   public Marker(Cane cane, String name, String[] image) {
	   this.cane = cane;
	   this.name = name;
	   this.image = image;
	   this.mapTileNum = -1;
	   if(cane.getCane().equals("Questionmark"))
		   this.hiddenFlag = false;
	   else
		   this.hiddenFlag = true;
   }
   
   /**
    * 
    * @param cane 지팡이 정보
    * @param name 이름
    * @param image url
    * @param turn 턴정보
    */
   public Marker(Cane cane, String character, String name, String[] image, Rectangle rectangle) {
	   this.cane = cane;
	   this.name = name; 
	   this.image = image;
	   this.turn = 1;
	   this.rectangle = rectangle;
	   this.mapTileNum = -1;
	   this.goalFlag = false;
	   if(cane.getCane().equals("Questionmark"))
		   this.hiddenFlag = false;
	   else
		   this.hiddenFlag = true;
	   this.selected = false;
   }

	public Marker(Marker obj) {
		this.cane = obj.getCane();
		this.name = obj.getName();
		this.image = obj.getImage();
		this.turn = obj.getTurn();
		this.rectangle = obj.getRectangle();
		this.mapTileNum = obj.getMapTileNum();
		this.goalFlag = obj.getGoalFlag();
		if (obj.getCane().getCane().equals("Questionmark"))
			this.hiddenFlag = false;
		else
			this.hiddenFlag = obj.getHiddenFlag();
		this.selected = obj.getSelected();
	}

	public Cane getCane() {
		return cane;
	}
   
   public void setCane(Cane cane) {
	   this.cane = cane;
   }
   
   public String getName() {
	   return name;
   }
   
   public void setName(String name) {
	   this.name = name;
   }
   
   
   /**
    * getter()
    * @return 타일에 지정된 번호를 리턴한다.
    */
   public int getMapTileNum() {
      return mapTileNum;
   }
   /**
    * setter()
    * @param mapTitleNum 타일에 지정된 번호를 리턴한다.
    */
   public void setMapTileNum(int mapTileNum) {
      this.mapTileNum = mapTileNum;
   }
   /**
    * getter()
    * @return url
    */
   public String[] getImage() {
      return image;
   }
   /**
    * setter()
    * @param image url
    */
   public void setImage(String[] image) {
      this.image = image;
   }
   /**
    * getter()
    * @return 선택되었으면 true, 아니면 false를 리턴한다.
    */
   public boolean getSelected() {
      return selected;
   }
   /**
    * setter()
    * @param selected 선택여부를 리턴한다.
    */
   public void setSelected(boolean selected) {
      this.selected = selected;
   }
   /**
    * getter()
    * @return 턴 정보를 리턴한다.
    */
   public int getTurn() {
      return turn;
   }
   /**
    * setter()
    * @param turn 턴 정보
    */
   public void setTurn(int turn) {
      this.turn = turn;
   }

   
   public Rectangle getRectangle() {
	   return rectangle;
   }
   
   public void setRectangle(Rectangle rectangle) {
	   this.rectangle = rectangle;
   }
   
   /**
    * getter()
    * @return 골인했는지 여부를 리턴한다.
    */
   public boolean getGoalFlag() {
      return goalFlag;
   }
   
   /**
    * setter()
    * @param goalFlag 골인 여부
    */
   public void setGoalFlag(boolean goalFlag) {
      this.goalFlag = goalFlag;
   }
   
   public boolean getHiddenFlag() {
	   return hiddenFlag;
   }
   
   public void setHiddenFlag(boolean hiddenFlag) {
	   this.hiddenFlag = hiddenFlag;
   }

}