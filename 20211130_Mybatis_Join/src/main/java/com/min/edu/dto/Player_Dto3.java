package com.min.edu.dto;

public class Player_Dto3 {

	private String player_id;
	private String player_name;
	private String e_player_name;
	private String nickname;
	private String join_yyyy;
	private String position;
	private int back_no;
	private String nation;
	private String birth_date;
	private String solar;
	private int height;
	private int weight;
	
	@Override
	public String toString() {
		return "Player_Dto3 [player_name=" + player_name + ", position=" + position + ", back_no=" + back_no + "]";
	}
	public String getPlayer_id() {
		return player_id;
	}
	public void setPlayer_id(String player_id) {
		this.player_id = player_id;
	}
	public String getPlayer_name() {
		return player_name;
	}
	public void setPlayer_name(String player_name) {
		this.player_name = player_name;
	}
	public String getE_player_name() {
		return e_player_name;
	}
	public void setE_player_name(String e_player_name) {
		this.e_player_name = e_player_name;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public String getJoin_yyyy() {
		return join_yyyy;
	}
	public void setJoin_yyyy(String join_yyyy) {
		this.join_yyyy = join_yyyy;
	}
	public String getPosition() {
		return position;
	}
	public void setPosition(String position) {
		this.position = position;
	}
	public int getBack_no() {
		return back_no;
	}
	public void setBack_no(int back_no) {
		this.back_no = back_no;
	}
	public String getNation() {
		return nation;
	}
	public void setNation(String nation) {
		this.nation = nation;
	}
	public String getBirth_date() {
		return birth_date;
	}
	public void setBirth_date(String birth_date) {
		this.birth_date = birth_date;
	}
	public String getSolar() {
		return solar;
	}
	public void setSolar(String solar) {
		this.solar = solar;
	}
	public int getHeight() {
		return height;
	}
	public void setHeight(int height) {
		this.height = height;
	}
	public int getWeight() {
		return weight;
	}
	public void setWeight(int weight) {
		this.weight = weight;
	}
	
	
}
