package yuan.zhang.entity;

public class Record {
	private int LTID;		//鲁通卡号
	private String plate;   //车牌号
	private String startstation;  //起始站
	private String arrivalstation;  //终点站
	private String starttime;		//进站时间
	private String arrivaltime;		//出站时间
	private int monetary;    //消费金额
	private int sum;
	public Record() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Record(String plate, int sum) {
		super();
		this.plate = plate;
		this.sum = sum;
	}

	public Record(int lTID, String plate, String startstation,
			String arrivalstation, String starttime, String arrivaltime,
			int monetary) {
		super();
		LTID = lTID;
		this.plate = plate;
		this.startstation = startstation;
		this.arrivalstation = arrivalstation;
		this.starttime = starttime;
		this.arrivaltime = arrivaltime;
		this.monetary = monetary;
	}
	public int getLTID() {
		return LTID;
	}
	public void setLTID(int lTID) {
		LTID = lTID;
	}
	public String getPlate() {
		return plate;
	}
	public void setPlate(String plate) {
		this.plate = plate;
	}
	public String getStartstation() {
		return startstation;
	}
	public void setStartstation(String startstation) {
		this.startstation = startstation;
	}
	public String getArrivalstation() {
		return arrivalstation;
	}
	public void setArrivalstation(String arrivalstation) {
		this.arrivalstation = arrivalstation;
	}
	public String getStarttime() {
		return starttime;
	}
	public void setStarttime(String starttime) {
		this.starttime = starttime;
	}
	public String getArrivaltime() {
		return arrivaltime;
	}
	public void setArrivaltime(String arrivaltime) {
		this.arrivaltime = arrivaltime;
	}
	public int getMonetary() {
		return monetary;
	}
	public void setMonetary(int monetary) {
		this.monetary = monetary;
	}

	public int getSum() {
		return sum;
	}

	public void setSum(int sum) {
		this.sum = sum;
	}
	

}
