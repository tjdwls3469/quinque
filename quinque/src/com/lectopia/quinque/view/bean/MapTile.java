package com.lectopia.quinque.view.bean;

import java.awt.Rectangle;

/**
 * 퀸키스톤(Quinque Stone) 게임에서 맵 타일(Map Tile)과 관련된 정보를 담고 있는 클래스이다.
 * <br>- 맵을 이루고 있는 타일 정보에 대한 가장 기본 데이터가 되는 클래스이다.
 * <br>- 타일에 대한 기본 정보에는 타일의 위치 정보(index)를 나타내는 tileNum 변수와
 * 타일이 말이 이동할 수 있는 상태로 활성화된 상태인지를 나타내는 available 변수,
 * 그리고 타일이 지름길이 존재하는지 여부를 판단하는 scFlag 변수가 존재한다. 
 * @author QuinqueBliss
 *
 */

public class MapTile {
   /**
    * 맵 타일의 Index 번호가 저장된 변수이다.
    */
   private int tileNum;
   
   private String image;
   private Rectangle rectangle;
   
   /**
    * 맵 타일에서 말(Marker)이 이동할 수 있는 지름길의 존재 유무를 판단하는 Flag 변수이다.
    * <br>- default 값은 false로 말이 이동할 수 있는 지름길이 존재하지 않음을 의미한다.
    * <br>- 값이 true 상태인 맵 타일은 말(Marker)이 이동할 수 있는 지름길이 존재함을 의미한다.
    */
   private boolean scFlag;
   
   /**
    * MapTile 클래스의 null 파라미터 생성자이다.
    */
   public MapTile() {
      
   }
   /**
    * 타일의 Index 번호와 지름길의 유무를 판단하는 scFlag 변수의 값을 boolean 타입의 파라미터로 받는 생성자이다.
    * @param tileNum 타일의 Index 번호 (int)
    * @param scFlag 지름길의 존재 유무 (boolean)
    */
   public MapTile(int tileNum, boolean scFlag) {
      this.tileNum = tileNum;
      this.scFlag = scFlag;
   }
   
   public MapTile(int tileNum, String image, Rectangle rectangle, boolean scFlag) {
      this.tileNum = tileNum;
      this.image = image;
      this.rectangle = rectangle;
      this.scFlag = scFlag;
   }
   
   /**
    * 맵 타일 클래스의 인스턴스 객체의 Index 번호를 반환하는 메서드이다.
    * @return 타일의 Index 번호
    */
   public int getTileNum() {
      return this.tileNum;
   }
   
   /**
    * 맵 타일 클래스의 인스턴스 객체의 Index 번호를 설정하는 메서드이다.
    * @param tileNum 설정할 맵 타일의 Index 번호 (int)
    */
   public void setTileNum(int tileNum) {
      this.tileNum = tileNum;
   }
   
   public String getImage() {
      return image;
   }
   
   public void setImage(String image) {
      this.image = image;
   }
   
   public Rectangle getRectangle() {
      return rectangle;
   }
   
   public void setRectangle(Rectangle rectangle) { 
      this.rectangle = rectangle;
   }
}