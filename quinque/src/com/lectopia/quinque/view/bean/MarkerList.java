package com.lectopia.quinque.view.bean;

import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class MarkerList {
	private ArrayList<ArrayList<Marker>> markerList;
	
	public MarkerList() {
		markerList = new ArrayList<ArrayList<Marker>>();
		
		ArrayList<Marker> marker1 = new ArrayList<Marker>();
		marker1.add(new Marker(Cane.ROCK, "Rabbit Rock", new String[] { "/playUI/localrabbit.png", "/playUI/rabbitRock.png" }));
		
		ArrayList<Marker> marker2 = new ArrayList<Marker>();
		marker2.add(new Marker(Cane.SCISSORS, "Rabbit Scissors", new String[] { "/playUI/localrabbit.png", "/playUI/rabbitScissors.png" }));
		
		ArrayList<Marker> marker3 = new ArrayList<Marker>();
		marker3.add(new Marker(Cane.PAPER, "Rabbit Paper",  new String[] { "/playUI/localrabbit.png", "/playUI/rabbitPaper.png" }));
		
		ArrayList<Marker> marker4 = new ArrayList<Marker>();
		marker4.add(new Marker(Cane.QUESTIONMARK, "Rabbit Questionmark", new String[] { "/playUI/rabbitWildcard.png", "/playUI/rabbitWildcard.png", "/playUI/rabbitWildcard.png", "/playUI/rabbitWildcard.png" }));
		
		ArrayList<Marker> marker5 = new ArrayList<Marker>();
		marker5.add(new Marker(Cane.ROCK, "Turtle Rock", new String[] { "/playUI/localturtle.png", "/playUI/turtleRock.png" }));
		
		ArrayList<Marker> marker6 = new ArrayList<Marker>();
		marker6.add(new Marker(Cane.SCISSORS, "Turtle Scissors", new String[] { "/playUI/localturtle.png", "/playUI/turtleScissors.png" }));
		
		ArrayList<Marker> marker7 = new ArrayList<Marker>();
		marker7.add(new Marker(Cane.PAPER, "Turtle Paper", new String[] { "/playUI/localturtle.png", "/playUI/turtlePaper.png" }));
		
		ArrayList<Marker> marker8 = new ArrayList<Marker>();
		marker8.add(new Marker(Cane.QUESTIONMARK, "Turtle Questionmark", new String[] { "/playUI/turtleWildcard.png", "/playUI/turtleWildcard.png", "/playUI/turtleWildcard.png", "/playUI/turtleWildcard.png" }));
		
		markerList.add(marker1);
		markerList.add(marker2);
		markerList.add(marker3);
		markerList.add(marker4);
		markerList.add(marker5);
		markerList.add(marker6);
		markerList.add(marker7);
		markerList.add(marker8);
		
	}
	
	public ArrayList<ArrayList<Marker>> getMarkerList(){
		return markerList;
	}
	public void setMarkerList(ArrayList<ArrayList<Marker>> markerList) {
		this.markerList=markerList;
	}
	
	public MarkerList(ArrayList<ArrayList<Marker>> markerList) {
		if (markerList == null) markerList = new ArrayList<ArrayList<Marker>>();
		else this.markerList = markerList;
	}
	
	public void setMarkerList(String name1, String name2) {
		if (name1.equals("Rabbit")) {
			for (int i = 0; i < markerList.size(); i++) {
				for (int j = 0; j < markerList.get(i).size(); j++) {
					Marker marker = markerList.get(i).get(j);
					StringTokenizer st = new StringTokenizer(marker.getName(), " ");
					if (st.nextToken().equals("Rabbit")) {
						marker.setTurn(1);
						switch (marker.getCane()) {
							case ROCK : 
								marker.setRectangle(new Rectangle(397, 483, 80, 140));
								break;
							case SCISSORS :
								marker.setRectangle(new Rectangle(316, 427, 80, 140));
								break;
							case PAPER :
								marker.setRectangle(new Rectangle(234, 381, 85, 140));
								break;
							case QUESTIONMARK :
								marker.setRectangle(new Rectangle(140, 313, 90, 140));
								break;
						}
					}
				}
			}
		}
		else {
			for (int i = 0; i < markerList.size(); i++) {
				for (int j = 0; j < markerList.get(i).size(); j++) {
					Marker marker = markerList.get(i).get(j);
					StringTokenizer st = new StringTokenizer(marker.getName(), " ");
					if (st.nextToken().equals("Rabbit")) {
						marker.setTurn(2);
						switch (marker.getCane()) {
							case ROCK : 
								marker.setRectangle(new Rectangle(437, -16, 80, 140));
								break;
							case SCISSORS :
								marker.setRectangle(new Rectangle(363, 34, 80, 140));
								break;
							case PAPER :
								marker.setRectangle(new Rectangle(281, 85, 85, 140));
								break;
							case QUESTIONMARK :
								marker.setRectangle(new Rectangle(169, 128, 80, 140));
								break;
						}
					}
				}
			}
		}
		
		if (!name2.equals("Turtle")) {
			for (int i = 0; i < markerList.size(); i++) {
				for (int j = 0; j < markerList.get(i).size(); j++) {
					Marker marker = markerList.get(i).get(j);
					StringTokenizer st = new StringTokenizer(marker.getName(), " ");
					if (st.nextToken().equals("Turtle")) {
						marker.setTurn(1);
						switch (marker.getCane()) {
							case ROCK : 
								marker.setRectangle(new Rectangle(382, 468, 119, 169));
								break;
							case SCISSORS :
								marker.setRectangle(new Rectangle(316, 417, 81, 150));
								break;
							case PAPER :
								marker.setRectangle(new Rectangle(229, 366, 99, 161));
								break;
							case QUESTIONMARK :
								marker.setRectangle(new Rectangle(137, 286, 114, 197));
								break;
						}
					}
				}
			}
		}
		else {
			for (int i = 0; i < markerList.size(); i++) {
				for (int j = 0; j < markerList.get(i).size(); j++) {
					Marker marker = markerList.get(i).get(j);
					StringTokenizer st = new StringTokenizer(marker.getName(), " ");
					if (st.nextToken().equals("Turtle")) {
						marker.setTurn(2);
						switch (marker.getCane()) {
							case ROCK : 
								marker.setRectangle(new Rectangle(437, -16, 99, 161));
								break;
							case SCISSORS :
								marker.setRectangle(new Rectangle(363, 34, 99, 161));
								break;
							case PAPER :
								marker.setRectangle(new Rectangle(281, 85, 99, 161));
								break;
							case QUESTIONMARK :
								marker.setRectangle(new Rectangle(169, 128, 122, 169));
								break;
						}
					}
				}
			}
		}
	}
	
	public ArrayList<Marker> searchMarkers(String name) {
		ArrayList<Marker> resultList = new ArrayList<Marker>();
		for (ArrayList<Marker> markers : markerList) {
			for (Marker marker : markers) {
				if (marker.getName().equals(name)) {
					resultList.add(marker);
				}
			}
		}
		System.out.println(resultList.size());
		return resultList;
	}
	
	public ArrayList<Marker> searchMarkers(int tileNum) {
		ArrayList<Marker> resultList = new ArrayList<Marker>();
		int size = markerList.size();
		for (int i = 0; i < size; i++) {
			ArrayList<Marker> markers = markerList.get(i);
			int markersSize = markers.size();
			for (int j = 0; j < markersSize; j++) {
				if (markers.get(j).getMapTileNum() == tileNum) {
					resultList.add(markers.get(j));
				}
			}
		}
		return resultList;
	}
	
	public void moveMarker(ArrayList<Marker> markers, int tileNum) {
		for (Marker marker : markers) {
			marker.setMapTileNum(tileNum);
		}
	}
	
	public int battle(int tileNum) {
		int result = 0;
		ArrayList<Marker> current = this.getSelectedMarkers();
		String myCane = current.get(0).getCane().getCane();
		ArrayList<Marker> enemy = this.searchEnemyMarker(tileNum);
		
		if(enemy.get(0).getMapTileNum() == tileNum) {
			String opCane = enemy.get(0).getCane().getCane();
			
			if(myCane.equals("Questionmark") && opCane.equals("Questionmark"))
				return 0;
			else if(myCane.equals("Questionmark"))
				return 1;
			else if(opCane.equals("Questionmark"))
				return -1;
			
			
			if(myCane.equals(opCane)) {
				result = 0;
			}
			else {
				if(myCane.equals("Rock")) {
					if(opCane.equals("Paper"))
						result = -1;
					else
						result = 1;
				}
				else if(myCane.equals("Paper")) {
					if(opCane.equals("Rock"))
						result = 1;
					else
						result = -1;
				}
				else {
					if(opCane.equals("Rock"))
						result = -1;
					else
						result = 1;
				}
			}
		}
		return result;
	}
	
	public void merge(int tileNum) {
		System.out.println("before merge:"+markerList.size());
		ArrayList<Marker> current = this.getSelectedMarkers();
		ArrayList<Marker> friend = this.searchFriendMarker(tileNum);
		for(int i=0; i<friend.size(); i++) {
			Marker temp = new Marker(friend.get(i)); // 깊은 복사
			current.add(temp); // 현재 리스트에 추가
		}
		for(int i=0; i<current.size(); i++)
		{
			System.out.println("name:"+current.get(i).getName());
		}
		markerList.remove(friend);   // 합병 했으면 원래 friend는 지우기
		System.out.println("after merge:"+markerList.size());
	}
	
	public void breakUp(ArrayList<Marker> loser) {
		int i;
		for(Marker marker : loser)
		{
			if(marker.getCane().getCane().equals("Questionmark"))
				continue;
			marker.setHiddenFlag(true);
		}
		for(i= 0; i<loser.size()-1; i++) {
			ArrayList<Marker> tempList =new ArrayList<Marker>();
			Marker temp = new Marker(loser.get(i));
			System.out.println("breakUP:"+temp.getName());
			tempList.add(temp);
			markerList.add(tempList);
		}
		if(i!=0)markerList.remove(loser);
	}
	
	public ArrayList<ArrayList<Object>> getResource() {
		ArrayList<ArrayList<Object>> resources = new ArrayList<ArrayList<Object>>();
		int markerListSize = markerList.size();
		for (int i = 0; i < markerListSize; i++) {
			ArrayList<Object> resource = new ArrayList<Object>();
			ArrayList<Marker> markers = markerList.get(i);
			int markersSize = markers.size();
			for (int j = 0; j < markersSize; j++) {
				resource.add(markers.get(j).getName());
				resource.add(markers.get(j).getImage()[0]);
				resource.add(markers.get(j).getRectangle());
			}
			resources.add(resource);
		}
		return resources;
	}
	
	public ArrayList<Marker> getSelectedMarkers() {
		ArrayList<Marker> selectedMarkers = new ArrayList<Marker>();
		for(ArrayList<Marker> markers : markerList) {
			for (Marker marker : markers) {
				if (marker.getSelected() == true) {
					selectedMarkers.add(marker);
				}
			}
		}
		return selectedMarkers;
	}
	
	public void setSelectedMarkers(String name) {
		for (ArrayList<Marker> markers : markerList) {
			for (Marker marker : markers) {
				if (marker.getName().equals(name))
					marker.setSelected(true);
			}
		}
	}
	public void deselectedMarker(String name) {
		int tileNum = 0;
		for (ArrayList<Marker> markers : markerList) {
			for (Marker marker : markers) {
				if (marker.getName().equals(name)) {
					tileNum = marker.getMapTileNum();
					break;
				}
			}
			if (tileNum != 0) break;
		}
		for (ArrayList<Marker> markers : markerList) {
			for (Marker marker : markers) {
				if (marker.getMapTileNum() != tileNum)
					marker.setSelected(false);
			}
		}
	}
	public void deselectedAllMarkers() {
		for (ArrayList<Marker> markers : markerList) {
			for (Marker marker : markers) {
				marker.setSelected(false);
			}
		}
	}
	
	public ArrayList<Marker> getHiddenMarker(int tileNum) {
		ArrayList<Marker> hiddenMarkers = new ArrayList<Marker>();
		for(ArrayList<Marker> markers : markerList) {
			for (Marker marker : markers) {
				if (marker.getMapTileNum() == tileNum && marker.getHiddenFlag() == true) {
					hiddenMarkers.add(marker);
				}
			}
		}
		return hiddenMarkers;
	}
	
	public void setMarkersHiddenFlag(int tileNum, boolean hiddenFlag) {
		for (ArrayList<Marker> markers : markerList) {
			for (Marker marker : markers) {
				marker.setHiddenFlag(hiddenFlag);
			}
		}
	}

	public ArrayList<Marker> searchEnemyMarker(int tileNum) {
		ArrayList<Marker> enemy = new ArrayList<Marker>();
		
		for(ArrayList<Marker> markers : markerList)
			for(Marker marker: markers) { // 리스트에서 tileNum 위에 있으면서 현재 턴과 다른 말들 반환
				if(marker.getTurn() != this.getSelectedMarkers().get(0).getTurn() && marker.getMapTileNum()==tileNum)
					enemy.add(marker);
		}
		return enemy;
	}
		
	public ArrayList<Marker> searchFriendMarker(int tileNum) {
		ArrayList<Marker> friend = new ArrayList<Marker>();
	
		for(ArrayList<Marker> markers : markerList)   // 현재 턴과 같으면서 tileNum 위에 있는 말 리턴
			if(markers.get(0).getTurn() == this.getSelectedMarkers().get(0).getTurn() && markers.get(0).getMapTileNum()==tileNum)
				friend.addAll(markers);
	
		return friend;
	}
	
	public void resetMapTileNum() {
		for (ArrayList<Marker> markers : markerList) {
			for (Marker marker : markers) {
				marker.setMapTileNum(-1);
				marker.setHiddenFlag(true);
			}
		}
	}
	
	public void setMarkersHiddenFlag(ArrayList<Marker> markers) {
		for (Marker marker : markers) {
			marker.setHiddenFlag(true);
		}
	}
	
	public boolean changePartyCane(String teamName,String selectCaneName) {   
		ArrayList<Marker> party=searchMarkers(teamName);
		if(party.size()==0) {System.out.println("MarkerList::changePartyCane 이 찾은 파티가 존재하지 않어용!");return false;}
		for(int i=0; i<party.size();i++) {
			if(party.get(i).getCane().getCane().equals(selectCaneName)){
				party.add(0,party.get(i));
				party.remove(i+1);   
				System.out.println(party.get(i).getCane().getCane()+"이 파티의 0번 인덱스로 이동했습니닷");
				return true;
			}
		}
		System.out.println("해당하는 Cane이 파티에 없네용");
		return false;
	}
}