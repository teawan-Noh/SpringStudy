package com.min.edu.dto;

/*
 * statement_join1.xml에서 사용함
 * join의 결과를 담을 수 있도록 조인에 참여는 모든 table과 매핑되는 컬럼을 은닉화하여 작성한다
 * 장점: 사용테이블의 모든 컬럼이 있기 때문에 사용하기 편함
 * 단점: 모든 컬럼이 다 있기 때문에 객체가 무겁다
 */
public class All_Dto {
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

	private String team_id;
	private String region_name;
	private String team_name;
	private String e_team_name;
	private String orig_yyyy;
	private String stadium_id;
	private String zip_code1;
	private String zip_code2;
	private String address;
	private String ddd;
	private String tel;
	private String fax;
	private String homepage;
	private String owner;
	
	@Override
	public String toString() {
		return "All_Dto [player_name=" + player_name + ", position=" + position + ", back_no=" + back_no
				+ ", region_name=" + region_name + ", team_name=" + team_name + ", address=" + address + ", homepage="
				+ homepage + "]";
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
	public String getTeam_id() {
		return team_id;
	}
	public void setTeam_id(String team_id) {
		this.team_id = team_id;
	}
	public String getRegion_name() {
		return region_name;
	}
	public void setRegion_name(String region_name) {
		this.region_name = region_name;
	}
	public String getTeam_name() {
		return team_name;
	}
	public void setTeam_name(String team_name) {
		this.team_name = team_name;
	}
	public String getE_team_name() {
		return e_team_name;
	}
	public void setE_team_name(String e_team_name) {
		this.e_team_name = e_team_name;
	}
	public String getOrig_yyyy() {
		return orig_yyyy;
	}
	public void setOrig_yyyy(String orig_yyyy) {
		this.orig_yyyy = orig_yyyy;
	}
	public String getStadium_id() {
		return stadium_id;
	}
	public void setStadium_id(String stadium_id) {
		this.stadium_id = stadium_id;
	}
	public String getZip_code1() {
		return zip_code1;
	}
	public void setZip_code1(String zip_code1) {
		this.zip_code1 = zip_code1;
	}
	public String getZip_code2() {
		return zip_code2;
	}
	public void setZip_code2(String zip_code2) {
		this.zip_code2 = zip_code2;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getDdd() {
		return ddd;
	}
	public void setDdd(String ddd) {
		this.ddd = ddd;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getFax() {
		return fax;
	}
	public void setFax(String fax) {
		this.fax = fax;
	}
	public String getHomepage() {
		return homepage;
	}
	public void setHomepage(String homepage) {
		this.homepage = homepage;
	}
	public String getOwner() {
		return owner;
	}
	public void setOwner(String owner) {
		this.owner = owner;
	}
	
	
	
}
