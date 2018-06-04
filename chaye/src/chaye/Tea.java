package chaye;


public class Tea {

	private int   chayeid;
	private String  mingzi;
	private int yuanjia;
	private int  xianjia;
	private int shoutu;
	private int pinglunshu;
	@Override
	public String toString() {
		return "tea [chayeid=" + chayeid + ", mingzi=" + mingzi + ", yuanjia=" + yuanjia + ", xianjia=" + xianjia
				+ ", shoutu=" + shoutu + ", pinglunshu=" + pinglunshu + "]";
	}
	public int getChayeid() {
		return chayeid;
	}
	public void setChayeid(int chayeid) {
		this.chayeid = chayeid;
	}
	public String getMingzi() {
		return mingzi;
	}
	public void setMingzi(String mingzi) {
		this.mingzi = mingzi;
	}
	public int getYuanjia() {
		return yuanjia;
	}
	public void setYuanjia(int yuanjia) {
		this.yuanjia = yuanjia;
	}
	public int getXianjia() {
		return xianjia;
	}
	public void setXianjia(int xianjia) {
		this.xianjia = xianjia;
	}
	public int getShoutu() {
		return shoutu;
	}
	public void setShoutu(int shoutu) {
		this.shoutu = shoutu;
	}
	public int getPinglunshu() {
		return pinglunshu;
	}
	public void setPinglunshu(int pinglunshu) {
		this.pinglunshu = pinglunshu;
	}
	
	
	public Tea() {
		super();
	}
	public Tea(int chayeid, String mingzi, int yuanjia, int xianjia, int shoutu, int pinglunshu) {
		super();
		this.chayeid = chayeid;
		this.mingzi = mingzi;
		this.yuanjia = yuanjia;
		this.xianjia = xianjia;
		this.shoutu = shoutu;
		this.pinglunshu = pinglunshu;
	}
	public Tea(int parseInt) {
		super();
		this.chayeid = chayeid;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + chayeid;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		System.out.println("进equals了");
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Tea other = (Tea) obj;
		if (chayeid != other.chayeid)
			return false;
		return true;
	}
	
	


}
