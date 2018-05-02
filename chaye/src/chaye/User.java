package chaye;

public class User {
	
	String nicheng;
	String xingming;
	int touxiang;
	int xingbie;
	int shoujihao;
	int userid;
	String youxiang;
	String mima;
	@Override
	public String toString() {
		return "User [nicheng=" + nicheng + ", xingming=" + xingming + ", touxiang=" + touxiang + ", xingbie=" + xingbie
				+ ", shoujihao=" + shoujihao + ", userid=" + userid + ", youxiang=" + youxiang + ", mima=" + mima + "]";
	}
	public String getNicheng() {
		return nicheng;
	}
	public void setNicheng(String nicheng) {
		this.nicheng = nicheng;
	}
	public String getXingming() {
		return xingming;
	}
	public void setXingming(String xingming) {
		this.xingming = xingming;
	}
	public int getTouxiang() {
		return touxiang;
	}
	public void setTouxiang(int touxiang) {
		this.touxiang = touxiang;
	}
	public int getXingbie() {
		return xingbie;
	}
	public void setXingbie(int xingbie) {
		this.xingbie = xingbie;
	}
	public int getShoujihao() {
		return shoujihao;
	}
	public void setShoujihao(int shoujihao) {
		this.shoujihao = shoujihao;
	}
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
	public String getYouxiang() {
		return youxiang;
	}
	public void setYouxiang(String youxiang) {
		this.youxiang = youxiang;
	}
	public String getMima() {
		return mima;
	}
	public void setMima(String mima) {
		this.mima = mima;
	}
	public User(String nicheng, String xingming, int touxiang, int xingbie, int shoujihao, int userid, String youxiang,
			String mima) {
		super();
		this.nicheng = nicheng;
		this.xingming = xingming;
		this.touxiang = touxiang;
		this.xingbie = xingbie;
		this.shoujihao = shoujihao;
		this.userid = userid;
		this.youxiang = youxiang;
		this.mima = mima;
	}
	public User(int userid, String mima) {
		super();
		this.userid = userid;
		this.mima = mima;
	}
	public User() {
		super();
	}

}
