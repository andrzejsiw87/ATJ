package atj.ws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "Rate")
@XmlAccessorType(XmlAccessType.FIELD)
public class Rate {
	
	@XmlElement(name = "No")
	private String no;
	
	@XmlElement(name = "EffectiveDate")
	private String effectiveDate;
	
	@XmlElement(name = "Mid")
	private Double mid;
	
	public Double getMid() {
		return mid;
	}
	public String getNo() {
		return no;
	}
	public void setNo(String no) {
		this.no = no;
	}
	public String getEffectiveDate() {
		return effectiveDate;
	}
	public void setEffectiveDate(String effectiveDate) {
		this.effectiveDate = effectiveDate;
	}
	public void setMid(Double mid) {
		this.mid = mid;
	}

}